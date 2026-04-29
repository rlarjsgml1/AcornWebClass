<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>나만의 학습 기록 블로그 - Welcome</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/global.css">
    <style>
        /* 메인 페이지 전용 스타일 */
        .main-wrapper {
            display: flex;
            min-height: 100vh;
            width: 100%;
        }

        /* 왼쪽: 캐릭터 인터랙션 영역 */
        .interaction-section {
            flex: 1.2;
            background-color: var(--color-bg-gray);
            display: flex;
            justify-content: center;
            align-items: flex-end;
            position: relative;
            overflow: hidden;
            padding-bottom: 10px;
        }

        /* 캐릭터들을 담는 SVG 컨테이너 */
        #jelly-container {
            width: 80%;
            height: 70%;
            max-width: 600px;
        }

        /* 오른쪽: 로그인 영역 */
        .login-section {
            flex: 1;
            background-color: var(--color-brand-white);
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            padding: var(--spacing-xl);
            border-left: 1px solid var(--color-border);
        }

        .login-container {
            width: 100%;
            max-width: 360px;
        }

        .login-header {
            text-align: center;
            margin-bottom: var(--spacing-xl);
        }

        /* 텍스트 로고 스타일 (이미지 대체) */
        .text-logo {
            font-size: 32px;
            font-weight: 900;
            letter-spacing: -1.5px;
            margin-bottom: var(--spacing-md);
            display: inline-block;
            border-bottom: 4px solid var(--color-brand-black);
            line-height: 1;
        }

        .login-header h1 {
            font-size: var(--font-size-3xl);
            font-weight: 800;
            margin-bottom: var(--spacing-xs);
            color: var(--color-brand-black);
        }

        /* 폼 스타일 */
        .form-group {
            margin-bottom: var(--spacing-lg);
        }

        .form-group label {
            display: block;
            font-size: var(--font-size-sm);
            font-weight: 600;
            margin-bottom: var(--spacing-sm);
            color: var(--color-text-main);
        }

        .input-control {
            width: 100%;
            padding: 12px 0;
            border: none;
            border-bottom: 2px solid var(--color-border);
            font-size: var(--font-size-base);
            transition: border-color 0.3s;
            outline: none;
            background: transparent;
        }

        .input-control:focus {
            border-bottom-color: var(--color-brand-black);
        }

        .form-options {
            display: flex;
            justify-content: space-between;
            align-items: center;
            font-size: var(--font-size-xs);
            margin-bottom: var(--spacing-lg);
            color: var(--color-text-sub);
        }

        /* 버튼 스타일 */
        .btn-login {
            width: 100%;
            padding: 14px;
            background-color: var(--color-brand-black);
            color: var(--color-brand-white);
            border-radius: var(--border-radius-full);
            font-weight: 700;
            margin-bottom: var(--spacing-md);
            transition: opacity 0.2s;
        }

        .btn-login:hover {
            opacity: 0.9;
        }

        /* 구글 로그인 버튼 (이미지 없이 텍스트/CSS로 처리) */
        .btn-google {
            width: 100%;
            padding: 12px;
            background-color: var(--color-brand-white);
            border: 1px solid var(--color-border);
            border-radius: var(--border-radius-full);
            display: flex;
            justify-content: center;
            align-items: center;
            gap: 10px;
            font-weight: 600;
            font-size: var(--font-size-sm);
            transition: background-color 0.2s;
        }

        .btn-google:hover {
            background-color: var(--color-bg-gray);
        }

        .google-icon-text {
            font-weight: 900;
            font-size: 18px;
            /* 구글 컬러 느낌만 텍스트로 부여 */
            background: linear-gradient(to right, #4285F4, #EA4335, #FBBC05, #34A853);
            -webkit-background-clip: text;
            -webkit-text-fill-color: transparent;
        }

        .signup-link {
            text-align: center;
            margin-top: var(--spacing-xl);
            font-size: var(--font-size-sm);
            color: var(--color-text-sub);
        }

        .signup-link a {
            color: var(--color-brand-black);
            font-weight: 700;
            text-decoration: underline;
        }


        @media (max-width: 768px) {
            .main-wrapper { flex-direction: column; }
            .interaction-section { display: none; }
        }
    </style>
</head>
<body>

<div class="main-wrapper">
    <section class="interaction-section">
        <%--
            모든 캐릭터 동일 공식: 둥근 머리(반원) + 평평한 바닥 (bottom=360)
            path 공식: M x,360  L x+ox, topY+rx+oy  Q x+ox,topY+oy  cx+ox,topY+oy
                       Q x+w+ox,topY+oy  x+w+ox,topY+rx+oy  L x+w,360  Z
            (JS가 ox/oy 값으로 상체를 늘려줌, 바닥 두 점은 항상 고정)
        --%>
        <svg id="jelly-container" viewBox="0 0 500 400" preserveAspectRatio="xMidYMid meet">

            <%-- ① 보라: x=85, w=76, topY=48  (반원 rx=38, bottom=360) --%>
            <g id="char-purple">
                <path class="body" d="M85,360 L85,86 Q85,48 123,48 Q161,48 161,86 L161,360 Z" fill="#7C5CE7"/>
                <circle class="eye-white" cx="104" cy="100" r="7.5" fill="white"/>
                <circle class="pupil"     cx="104" cy="100" r="3.5" fill="#222"/>
                <circle class="eye-white" cx="142" cy="100" r="7.5" fill="white"/>
                <circle class="pupil"     cx="142" cy="100" r="3.5" fill="#222"/>
            </g>

            <%-- ② 주황: x=110, w=170, topY=186  (반원 rx=85, bottom=360) --%>
            <g id="char-orange">
                <path class="body" d="M110,360 L110,271 Q110,186 195,186 Q280,186 280,271 L280,360 Z" fill="#FF9F43"/>
                <circle class="eye-white" cx="165" cy="235" r="13"  fill="white"/>
                <circle class="pupil"     cx="165" cy="235" r="6"   fill="#222"/>
                <circle class="eye-white" cx="225" cy="235" r="13"  fill="white"/>
                <circle class="pupil"     cx="225" cy="235" r="6"   fill="#222"/>
                <path class="mouth" d="M175,258 Q195,274 215,258" stroke="#333" stroke-width="3" fill="none" stroke-linecap="round"/>
            </g>

            <%-- ③ 핑크: x=238, w=92, topY=150  (반원 rx=46, bottom=360) --%>
            <g id="char-pink">
                <path class="body" d="M238,360 L238,196 Q238,150 284,150 Q330,150 330,196 L330,360 Z" fill="#E84393"/>
                <circle class="eye-white" cx="263" cy="204" r="9"   fill="white"/>
                <circle class="pupil"     cx="263" cy="204" r="4.2" fill="#222"/>
                <circle class="eye-white" cx="305" cy="204" r="9"   fill="white"/>
                <circle class="pupil"     cx="305" cy="204" r="4.2" fill="#222"/>
            </g>

            <%-- ④ 노랑: x=295, w=120, topY=250  (반원 rx=60, bottom=360) --%>
            <g id="char-yellow">
                <path class="body" d="M295,360 L295,310 Q295,250 355,250 Q415,250 415,310 L415,360 Z" fill="#FECA57"/>
                <circle class="pupil" cx="325" cy="316" r="6"   fill="#333"/>
                <circle class="pupil" cx="385" cy="316" r="6"   fill="#333"/>
                <line class="mouth" x1="328" y1="338" x2="382" y2="338" stroke="#333" stroke-width="3" stroke-linecap="round"/>
            </g>
        </svg>
    </section>

    <section class="login-section">
        <div class="login-container">
            <header class="login-header">
                <div class="text-logo">LOG.ME</div>
                <h1>Welcome back!</h1>
                <p class="text-sub">학습의 기록을 계속 이어가세요.</p>
            </header>

            <form id="loginForm" action="${pageContext.request.contextPath}/login.do" method="post">
                <div class="form-group">
                    <label for="email">Email</label>
                    <input type="email" id="email" name="email" class="input-control" placeholder="example@domain.com" required>
                </div>

                <div class="form-group">
                    <label for="password">Password</label>
                    <input type="password" id="password" name="password" class="input-control" placeholder="••••••••" required>
                </div>

                <div class="form-options">
                    <label style="cursor: pointer;"><input type="checkbox"> Remember me</label>
                    <a href="#">Forgot password?</a>
                </div>

                <button type="submit" class="btn-login">Log In</button>
                
                <button type="button" class="btn-google">
                    <span class="google-icon-text">G</span>
                    Continue with Google
                </button>
            </form>

            <div class="signup-link">
                Don't have an account? <a href="${pageContext.request.contextPath}/join.do">Sign up</a>
            </div>
        </div>
    </section>
</div>

<script src="${pageContext.request.contextPath}/js/main-interaction.js"></script>
</body>
</html>