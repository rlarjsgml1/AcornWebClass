<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>LOG.ME - Home</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/global.css">
    <style>
        /* Home 페이지 전용 레이아웃 */
        .home-wrapper {
            display: flex;
            min-height: 100vh;
            width: 100%;
            overflow: hidden;
            position: relative;
        }

        /* 벚꽃 컨테이너 */
        #cherry-blossom-container {
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            pointer-events: none;
            z-index: 9999; 
            overflow: hidden;
            display: none;
        }

        .cherry-petal {
            position: absolute;
            background-color: #ffb7c5; 
            border-radius: 150% 0 150% 0;
            opacity: 0.8; 
            pointer-events: none;
            animation: fall linear infinite;
        }

        @keyframes fall {
            0% {
                transform: translate(0, -10px) rotate(0deg);
            }
            100% {
                transform: translate(150px, 100vh) rotate(720deg);
            }
        }

        /* 왼쪽 사이드바 (대시보드) */
        .sidebar {
            width: 320px;
            background-color: var(--color-bg-gray);
            display: flex;
            flex-direction: column;
            transition: transform 0.3s ease, margin-left 0.3s ease;
            position: relative;
            padding: var(--spacing-xl) var(--spacing-lg);
            z-index: 10;
            gap: var(--spacing-xl);
            /* 경계를 보이되 연하게 처리 */
            border-right: 1px solid #f0f0f0; 
        }

        .sidebar.collapsed {
            margin-left: -320px;
        }

        .toggle-btn {
            position: absolute;
            right: -40px;
            top: 20px;
            width: 32px;
            height: 32px;
            background-color: var(--color-brand-black);
            color: var(--color-brand-white);
            border-radius: var(--border-radius-sm);
            display: flex;
            justify-content: center;
            align-items: center;
            font-size: 18px;
            box-shadow: 0 2px 8px rgba(0,0,0,0.1);
            cursor: pointer;
        }

        /* 깃허브 잔디 섹션 */
        .grass-section {
            padding-bottom: var(--spacing-md);
            /* 경계선 연하게 */
            border-bottom: 1px solid #f0f0f0;
        }

        .grass-title {
            font-size: var(--font-size-xs);
            font-weight: 700;
            color: var(--color-text-sub);
            margin-bottom: var(--spacing-sm);
            display: block;
        }

        .grass-grid {
            display: grid;
            grid-template-columns: repeat(7, 1fr);
            gap: 4px;
        }

        .grass-node {
            width: 100%;
            aspect-ratio: 1;
            border-radius: 2px;
            background-color: var(--grass-level-0);
        }
        .level-1 { background-color: var(--grass-level-1); }
        .level-2 { background-color: var(--grass-level-2); }
        .level-3 { background-color: var(--grass-level-3); }
        .level-4 { background-color: var(--grass-level-4); }

        /* 프로필 섹션 */
        .profile-section {
            text-align: center;
        }

        .profile-avatar {
            width: 100px;
            height: 100px;
            /* Black & White 톤 */
            background-color: var(--color-brand-black);
            color: var(--color-brand-white);
            border-radius: var(--border-radius-full);
            margin: 0 auto var(--spacing-md);
            display: flex;
            justify-content: center;
            align-items: center;
            font-size: 40px;
        }

        .profile-info h2 {
            font-size: var(--font-size-xl);
            font-weight: 700;
            margin-bottom: var(--spacing-xs);
            color: var(--color-brand-black);
        }

        .profile-info p {
            color: var(--color-text-sub);
            font-size: var(--font-size-sm);
        }

        /* 로그아웃 버튼 스타일 */
        .logout-link {
            color: var(--color-text-sub); /* 블랙&화이트 톤을 위해 채도 낮춤 */
            font-weight: 700;
            display: flex;
            align-items: center;
            gap: 8px;
            margin-top: var(--spacing-md);
            transition: color 0.2s;
        }
        
        .logout-link:hover {
            color: var(--color-brand-black);
        }

        /* 벚꽃 토글 UI (사이드바 하단) */
        .sidebar-footer {
            margin-top: auto;
            display: flex;
            align-items: center;
            justify-content: space-between;
            font-size: var(--font-size-sm);
            color: var(--color-text-sub);
            padding-top: var(--spacing-md);
            border-top: 1px solid #f0f0f0;
        }

        .switch {
            position: relative;
            display: inline-block;
            width: 40px;
            height: 20px;
        }

        .switch input {
            opacity: 0;
            width: 0;
            height: 0;
        }

        .slider {
            position: absolute;
            cursor: pointer;
            top: 0;
            left: 0;
            right: 0;
            bottom: 0;
            background-color: #e0e0e0;
            transition: .4s;
            border-radius: 20px;
        }

        .slider:before {
            position: absolute;
            content: "";
            height: 14px;
            width: 14px;
            left: 3px;
            bottom: 3px;
            background-color: white;
            transition: .4s;
            border-radius: 50%;
        }

        input:checked + .slider {
            background-color: var(--color-brand-black);
        }

        input:checked + .slider:before {
            transform: translateX(20px);
        }

        /* 오른쪽 메인 콘텐츠 영역 */
        .main-content {
            flex: 1;
            background-color: var(--color-brand-white);
            padding: var(--spacing-xl);
            overflow-y: auto;
            position: relative;
            z-index: 5;
        }

        /* 상단 바 (검색 + 설정) */
        .top-bar {
            display: flex;
            /* 검색바를 우측으로 밀기 위해 flex-end 사용 */
            justify-content: flex-end; 
            align-items: center;
            margin-bottom: var(--spacing-xl);
            gap: var(--spacing-md);
        }

        /* 검색바 스타일 - 블랙 & 화이트 톤 */
        .search-container {
            width: 100%;
            max-width: 320px; /* 크기 조정 */
            display: flex;
            align-items: center;
            background-color: var(--color-brand-white);
            padding: 8px 16px;
            border-radius: var(--border-radius-full); /* 더 둥글게 */
            /* 경계선을 연하게 처리 */
            border: 1px solid #eeeeee; 
            transition: all 0.2s;
        }

        .search-container:focus-within {
            border-color: var(--color-brand-black);
            box-shadow: 0 2px 10px rgba(0,0,0,0.05);
        }

        .search-icon {
            font-size: 16px;
            margin-right: 10px;
            color: var(--color-text-muted);
        }

        .search-input {
            width: 100%;
            border: none;
            background: transparent;
            font-family: inherit;
            font-size: var(--font-size-sm);
            outline: none;
            color: var(--color-text-main);
        }

        .settings-btn {
            width: 36px;
            height: 36px;
            display: flex;
            justify-content: center;
            align-items: center;
            font-size: 20px;
            color: var(--color-text-sub);
            transition: color 0.2s, transform 0.2s;
            cursor: pointer;
            border-radius: var(--border-radius-full);
            border: 1px solid #eeeeee; /* 설정 버튼에도 연한 테두리 */
        }

        .settings-btn:hover {
            color: var(--color-brand-black);
            border-color: var(--color-brand-black);
            transform: rotate(45deg);
        }

        .placeholder-card {
            width: 100%;
            height: 200px;
            /* 경계선 연하게 */
            border: 1px solid #f5f5f5;
            border-radius: var(--border-radius-md);
            display: flex;
            justify-content: center;
            align-items: center;
            color: var(--color-text-muted);
            margin-bottom: var(--spacing-lg);
            background-color: #fafafa;
        }

        @media (max-width: 768px) {
            .sidebar {
                position: fixed;
                height: 100vh;
            }
        }
    </style>
</head>
<body>

<div id="cherry-blossom-container"></div>

<div class="home-wrapper">
    <aside class="sidebar" id="sidebar">
        <button class="toggle-btn" id="toggleBtn" title="사이드바 접기/펴기">☰</button>
        
        <div class="grass-section">
            <span class="grass-title">Yearly Contributions</span>
            <div class="grass-grid">
                <div class="grass-node level-4"></div>
                <div class="grass-node level-2"></div>
                <div class="grass-node level-0"></div>
                <div class="grass-node level-1"></div>
                <div class="grass-node level-3"></div>
                <div class="grass-node level-0"></div>
                <div class="grass-node level-2"></div>
                <div class="grass-node level-1"></div>
                <div class="grass-node level-4"></div>
                <div class="grass-node level-0"></div>
                <div class="grass-node level-2"></div>
                <div class="grass-node level-3"></div>
                <div class="grass-node level-1"></div>
                <div class="grass-node level-0"></div>
                <div class="grass-node level-4"></div>
                <div class="grass-node level-2"></div>
                <div class="grass-node level-0"></div>
                <div class="grass-node level-1"></div>
                <div class="grass-node level-3"></div>
                <div class="grass-node level-0"></div>
                <div class="grass-node level-2"></div>
            </div>
        </div>

        <div class="profile-section">
            <div class="profile-avatar">👤</div>
            <div class="profile-info">
                <h2>User Name</h2>
                <p>Learning & Recording...</p>
            </div>
        </div>

        <nav>
            <ul style="list-style: none;">
                <li style="margin-bottom: var(--spacing-sm); font-weight: 600; cursor: pointer;">📁 My Folders</li>
                <li style="margin-bottom: var(--spacing-sm); font-weight: 600; cursor: pointer;">🔖 Bookmarks</li>
                <li>
                    <a href="${pageContext.request.contextPath}/logout.do" class="logout-link">🚪 Logout</a>
                </li>
            </ul>
        </nav>

        <div class="sidebar-footer">
            <span>🌸 Cherry Blossom</span>
            <label class="switch">
                <input type="checkbox" id="cherryToggle">
                <span class="slider"></span>
            </label>
        </div>
    </aside>

    <main class="main-content">
        <div class="top-bar">
            <div class="search-container">
                <span class="search-icon">🔍</span>
                <input type="text" class="search-input" placeholder="기록 검색하기...">
            </div>
            <div class="settings-btn" title="Settings" onclick="alert('설정창이 열립니다.')">⚙️</div>
        </div>

        <header style="margin-bottom: var(--spacing-xl);">
            <h1 style="font-size: var(--font-size-3xl); font-weight: 800; color: var(--color-brand-black);">My Dashboard</h1>
            <p class="text-sub">오늘의 학습 기록을 확인해보세요.</p>
        </header>

        <div class="placeholder-card">메인 콘텐츠가 들어갈 자리입니다.</div>
        <div class="placeholder-card">메인 콘텐츠가 들어갈 자리입니다.</div>
    </main>
</div>

<script>
    document.addEventListener('DOMContentLoaded', function() {
        const sidebar = document.getElementById('sidebar');
        const toggleBtn = document.getElementById('toggleBtn');

        toggleBtn.addEventListener('click', function() {
            sidebar.classList.toggle('collapsed');
            if (sidebar.classList.contains('collapsed')) {
                toggleBtn.textContent = '▶';
            } else {
                toggleBtn.textContent = '☰';
            }
        });

        const blossomContainer = document.getElementById('cherry-blossom-container');
        const cherryToggle = document.getElementById('cherryToggle');
        let petalInterval;

        function createPetal() {
            const petal = document.createElement('div');
            petal.classList.add('cherry-petal');
            
            const size = Math.random() * 12 + 8 + 'px';
            petal.style.width = size;
            petal.style.height = size;
            petal.style.left = Math.random() * 100 + 'vw';
            petal.style.animationDuration = Math.random() * 3 + 5 + 's';
            petal.style.opacity = Math.random() * 0.4 + 0.5; 
            
            blossomContainer.appendChild(petal);

            setTimeout(() => {
                petal.remove();
            }, 8000);
        }

        cherryToggle.addEventListener('change', function() {
            if (this.checked) {
                blossomContainer.style.display = 'block';
                petalInterval = setInterval(createPetal, 200); 
            } else {
                blossomContainer.style.display = 'none';
                clearInterval(petalInterval);
                blossomContainer.innerHTML = '';
            }
        });
    });
</script>
</body>
</html>