const pages = Array.from(document.querySelectorAll("[data-view]"));
const navItems = Array.from(document.querySelectorAll(".nav-item"));
const pageTitle = document.getElementById("pageTitle");
const reportModal = document.getElementById("reportModal");
const adminTable = document.getElementById("adminTable");

const titles = {
  login: "로그인",
  signup: "회원가입",
  workspace: "내 작업 공간",
  community: "커뮤니티",
  write: "게시글 작성",
  detail: "게시글 상세 조회",
  admin: "관리자 대시보드"
};

const adminData = {
  members: {
    title: "회원 관리",
    headers: ["이름", "이메일", "권한", "상태"],
    rows: [
      ["김하늘", "sky@campus.ac.kr", "사용자", "활성"],
      ["박서준", "jun@campus.ac.kr", "관리자", "활성"],
      ["이유진", "yujin@campus.ac.kr", "사용자", "휴면"]
    ]
  },
  tags: {
    title: "태그 관리",
    headers: ["태그", "게시글 수", "노출", "관리"],
    rows: [
      ["#JSP", "42", "사용", "수정"],
      ["#팀프로젝트", "38", "사용", "수정"],
      ["#질문", "27", "사용", "수정"]
    ]
  },
  reports: {
    title: "신고 관리",
    headers: ["게시글", "신고 사유", "신고자", "상태"],
    rows: [
      ["광고성 게시글", "광고", "김하늘", "검토 중"],
      ["개인정보 포함", "개인정보", "박서준", "긴급"],
      ["욕설 댓글", "부적절한 내용", "이유진", "처리 완료"]
    ]
  },
  posts: {
    title: "게시글 관리",
    headers: ["제목", "작성자", "조회", "관리"],
    rows: [
      ["Servlet/JSP 발표 자료 공유", "김하늘", "128", "숨김"],
      ["DB 연결 오류 해결 방법", "박서준", "94", "수정"],
      ["프로젝트 제출 전 점검표", "이유진", "76", "고정"]
    ]
  }
};

function showPage(name) {
  const next = titles[name] ? name : "workspace";

  pages.forEach((page) => {
    page.classList.toggle("hidden", page.dataset.view !== next);
  });

  navItems.forEach((item) => {
    item.classList.toggle("active", item.dataset.page === next);
  });

  pageTitle.textContent = titles[next];
  window.location.hash = next;
}

function renderAdminTable(type = "members") {
  const data = adminData[type];
  const head = data.headers.map((header) => `<th>${header}</th>`).join("");
  const body = data.rows
    .map((row) => `<tr>${row.map((cell) => `<td>${cell}</td>`).join("")}</tr>`)
    .join("");

  adminTable.innerHTML = `
    <div class="section-heading">
      <div>
        <p class="eyebrow">관리자 기능</p>
        <h2>${data.title}</h2>
      </div>
      <button class="ghost-btn" type="button">내보내기</button>
    </div>
    <table>
      <thead><tr>${head}</tr></thead>
      <tbody>${body}</tbody>
    </table>
  `;
}

document.addEventListener("click", (event) => {
  const pageButton = event.target.closest("[data-page]");
  const adminButton = event.target.closest("[data-admin]");

  if (pageButton) {
    showPage(pageButton.dataset.page);
  }

  if (adminButton) {
    document.querySelectorAll("[data-admin]").forEach((button) => {
      button.classList.toggle("selected", button === adminButton);
    });
    renderAdminTable(adminButton.dataset.admin);
  }
});

document.getElementById("openReport").addEventListener("click", () => {
  reportModal.classList.remove("hidden");
});

document.getElementById("closeReport").addEventListener("click", () => {
  reportModal.classList.add("hidden");
});

reportModal.addEventListener("click", (event) => {
  if (event.target === reportModal) {
    reportModal.classList.add("hidden");
  }
});

renderAdminTable();
showPage(window.location.hash.replace("#", "") || "workspace");
