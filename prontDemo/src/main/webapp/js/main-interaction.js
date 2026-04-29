document.addEventListener('DOMContentLoaded', function() {
    var svg = document.getElementById('jelly-container');
    if (!svg) return;

    /* ---------------------------------------------------------------
       path 공식: 바닥(x, bottom) ~ (x+w, bottom) 은 고정,
       상체 꼭대기가 ox(가로), oy(세로) 만큼 이동
    --------------------------------------------------------------- */
    function buildPath(x, topY, w, bottom, ox, oy) {
        var cx = x + w / 2;
        var rx = w / 2;
        return (
            'M' + x + ',' + bottom +
            ' L' + (x + ox) + ',' + (topY + rx + oy) +
            ' Q' + (x + ox) + ',' + (topY + oy) +
            ' '  + (cx + ox) + ',' + (topY + oy) +
            ' Q' + (x + w + ox) + ',' + (topY + oy) +
            ' '  + (x + w + ox) + ',' + (topY + rx + oy) +
            ' L' + (x + w) + ',' + bottom +
            ' Z'
        );
    }

    function lerp(a, b, t) { return a + (b - a) * t; }

    /* 캐릭터 정의 (모두 동일한 반원+평바닥 공식) */
    var charDefs = [
        {
            id: 'char-purple',
            x: 85, topY: 48, w: 76, bottom: 360,
            maxLean: 18, maxStretch: 8,
            eyes: [ {cx: 104, cy: 100}, {cx: 142, cy: 100} ],
            hasEyeWhite: true
        },
        {
            id: 'char-orange',
            x: 110, topY: 186, w: 170, bottom: 360,
            maxLean: 22, maxStretch: 8,
            eyes: [ {cx: 165, cy: 235}, {cx: 225, cy: 235} ],
            hasEyeWhite: true,
            smile: { p1x: 175, p1y: 258, cpx: 195, cpy: 274, p2x: 215, p2y: 258 }
        },
        {
            id: 'char-pink',
            x: 238, topY: 150, w: 92, bottom: 360,
            maxLean: 16, maxStretch: 8,
            eyes: [ {cx: 263, cy: 204}, {cx: 305, cy: 204} ],
            hasEyeWhite: true
        },
        {
            id: 'char-yellow',
            x: 295, topY: 250, w: 120, bottom: 360,
            maxLean: 14, maxStretch: 6,
            eyes: [ {cx: 325, cy: 316}, {cx: 385, cy: 316} ],
            hasEyeWhite: false,
            linemouth: { x1: 328, y1: 338, x2: 382, y2: 338 }
        }
    ];

    /* DOM 수집 */
    var chars = [];
    for (var i = 0; i < charDefs.length; i++) {
        var def   = charDefs[i];
        var group = document.getElementById(def.id);
        if (!group) {
            console.warn('[main-interaction] 요소를 찾을 수 없음: #' + def.id);
            continue;
        }
        chars.push({
            def:      def,
            bodyEl:   group.querySelector('.body'),
            eyeWEls:  group.querySelectorAll('.eye-white'),
            pupilEls: group.querySelectorAll('.pupil'),
            mouthEl:  group.querySelector('.mouth'),
            ox: 0, oy: 0,
            targetOx: 0, targetOy: 0,
            hasMouse: false,
            mouseX: 0, mouseY: 0
        });
    }

    if (chars.length === 0) return;

    /* 캐릭터 하나 업데이트 */
    function applyChar(ch) {
        var def = ch.def;
        var ox  = ch.ox;
        var oy  = ch.oy;

        /* 몸통 path 갱신 */
        ch.bodyEl.setAttribute('d', buildPath(def.x, def.topY, def.w, def.bottom, ox, oy));

        /* 눈 흰자 이동 */
        for (var j = 0; j < ch.eyeWEls.length; j++) {
            ch.eyeWEls[j].setAttribute('cx', def.eyes[j].cx + ox);
            ch.eyeWEls[j].setAttribute('cy', def.eyes[j].cy + oy);
        }

        /* 눈동자: 상체 이동 + 마우스 추적 */
        for (var j = 0; j < ch.pupilEls.length; j++) {
            var eye = def.eyes[j];
            var ecx = eye.cx + ox;
            var ecy = eye.cy + oy;
            if (ch.hasMouse) {
                var pdx  = ch.mouseX - ecx;
                var pdy  = ch.mouseY - ecy;
                var dist = Math.sqrt(pdx * pdx + pdy * pdy) || 1;
                var move = Math.min(dist * 0.05, 3);
                ch.pupilEls[j].setAttribute('cx', ecx + (pdx / dist) * move);
                ch.pupilEls[j].setAttribute('cy', ecy + (pdy / dist) * move);
            } else {
                ch.pupilEls[j].setAttribute('cx', ecx);
                ch.pupilEls[j].setAttribute('cy', ecy);
            }
        }

        /* 입 이동 */
        if (ch.mouthEl) {
            if (def.smile) {
                var s = def.smile;
                ch.mouthEl.setAttribute('d',
                    'M' + (s.p1x + ox) + ',' + (s.p1y + oy) +
                    ' Q' + (s.cpx + ox) + ',' + (s.cpy + oy) +
                    ' ' + (s.p2x + ox) + ',' + (s.p2y + oy)
                );
            } else if (def.linemouth) {
                var l = def.linemouth;
                ch.mouthEl.setAttribute('x1', l.x1 + ox);
                ch.mouthEl.setAttribute('y1', l.y1 + oy);
                ch.mouthEl.setAttribute('x2', l.x2 + ox);
                ch.mouthEl.setAttribute('y2', l.y2 + oy);
            }
        }
    }

    /* 매 프레임: lerp로 부드럽게 목표값에 접근 */
    function tick() {
        requestAnimationFrame(tick);
        for (var i = 0; i < chars.length; i++) {
            var ch = chars[i];
            ch.ox = lerp(ch.ox, ch.targetOx, 0.14);
            ch.oy = lerp(ch.oy, ch.targetOy, 0.14);
            applyChar(ch);
        }
    }

    /* 마우스 이동: SVG 좌표로 변환 후 목표 offset 계산 */
    window.addEventListener('mousemove', function(e) {
        var r    = svg.getBoundingClientRect();
        var svgX = (e.clientX - r.left) / r.width  * 500;
        var svgY = (e.clientY - r.top)  / r.height * 400;

        for (var i = 0; i < chars.length; i++) {
            var ch  = chars[i];
            var def = ch.def;
            var cx  = def.x + def.w / 2;

            ch.hasMouse = true;
            ch.mouseX   = svgX;
            ch.mouseY   = svgY;

            /* 가로: 마우스가 캐릭터 중심 기준 좌우로 얼마나 떨어졌는지 */
            var dx = svgX - cx;
            ch.targetOx = Math.max(-def.maxLean, Math.min(def.maxLean, dx * 0.04));

            /* 세로: 위쪽 방향만 늘어남 (아래로는 늘어나지 않음) */
            var dy = svgY - def.bottom;
            ch.targetOy = Math.max(-def.maxStretch, Math.min(0, dy * 0.02));
        }
    });

    /* 마우스가 화면 밖으로 나가면 원위치 */
    document.addEventListener('mouseleave', function() {
        for (var i = 0; i < chars.length; i++) {
            chars[i].targetOx = 0;
            chars[i].targetOy = 0;
            chars[i].hasMouse = false;
        }
    });

    tick();
});
