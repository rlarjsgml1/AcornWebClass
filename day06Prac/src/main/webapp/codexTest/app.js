const STORAGE_KEYS = {
  members: "codexTestMembers",
  currentUser: "codexTestCurrentUser",
  history: "codexTestHistory"
};

const fortuneQuotes = [
  "오늘은 망설이던 일을 시작하면 생각보다 훨씬 좋은 흐름이 따라옵니다.",
  "작은 미소 하나가 큰 행운을 끌어오는 날입니다.",
  "지금의 선택이 다음 기회를 환하게 밝혀줄 수 있습니다.",
  "평소보다 한 걸음 더 움직이면 좋은 소식이 가까워집니다.",
  "오늘의 당신은 주변 사람에게 따뜻한 기운을 전하는 행운의 중심입니다.",
  "미뤄둔 연락을 하면 반가운 답을 받을 가능성이 큽니다.",
  "숫자 하나에 집중하면 예상하지 못한 힌트를 얻게 됩니다.",
  "차분하게 정리한 계획이 오늘의 운을 단단하게 만들어줍니다.",
  "새로운 아이디어가 금방 현실이 될 만큼 기운이 좋은 날입니다.",
  "당신의 진심이 통하는 순간, 운도 함께 열립니다.",
  "오늘은 작은 도전이 큰 자신감으로 돌아오는 날입니다.",
  "좋아하는 일을 먼저 하면 하루 전체의 흐름이 매끄러워집니다.",
  "우연처럼 보이는 만남 속에 좋은 기회가 숨어 있습니다.",
  "한 번 더 확인하는 습관이 오늘의 행운을 더 크게 만듭니다.",
  "긍정적인 말 한마디가 예상 밖의 좋은 결과를 불러옵니다.",
  "지금 가진 능력을 믿으면 원하는 방향으로 흐름이 바뀝니다.",
  "오늘의 행운은 꾸준함을 선택한 사람에게 오래 머뭅니다.",
  "익숙한 곳에서도 새로운 기쁨을 발견하게 되는 날입니다.",
  "당신이 정한 번호가 오늘 하루의 기분 좋은 신호가 됩니다.",
  "가볍게 시작한 일이 의외의 만족과 성과를 안겨줄 수 있습니다."
];

const gradeByScore = (score) => {
  if (score >= 90) return "대길";
  if (score >= 75) return "상승";
  if (score >= 60) return "맑음";
  if (score >= 40) return "보통";
  return "주의";
};

const members = loadJson(STORAGE_KEYS.members, []);
let currentUser = loadJson(STORAGE_KEYS.currentUser, null);
let history = loadJson(STORAGE_KEYS.history, []);

const authMessage = document.getElementById("authMessage");
const fortuneMessage = document.getElementById("fortuneMessage");
const loginStatus = document.getElementById("loginStatus");
const signupForm = document.getElementById("signupForm");
const loginForm = document.getElementById("loginForm");
const fortuneForm = document.getElementById("fortuneForm");
const logoutButton = document.getElementById("logoutButton");
const clearHistoryButton = document.getElementById("clearHistoryButton");
const scoreRing = document.getElementById("scoreRing");
const tabButtons = document.querySelectorAll(".tab");

tabButtons.forEach((button) => {
  button.addEventListener("click", () => switchTab(button.dataset.tab));
});

signupForm.addEventListener("submit", (event) => {
  event.preventDefault();

  const id = document.getElementById("signupId").value.trim();
  const password = document.getElementById("signupPassword").value.trim();

  if (!id || !password) {
    setMessage(authMessage, "아이디와 비밀번호를 모두 입력해주세요.", "danger");
    return;
  }

  const exists = members.some((member) => member.id === id);
  if (exists) {
    setMessage(authMessage, "이미 사용 중인 아이디입니다.", "danger");
    return;
  }

  members.push({ id, password });
  saveJson(STORAGE_KEYS.members, members);
  signupForm.reset();
  setMessage(authMessage, "회원가입이 완료되었습니다. 이제 로그인하세요.", "mint");
  switchTab("login");
});

loginForm.addEventListener("submit", (event) => {
  event.preventDefault();

  const id = document.getElementById("loginId").value.trim();
  const password = document.getElementById("loginPassword").value.trim();
  const found = members.find((member) => member.id === id && member.password === password);

  if (!found) {
    setMessage(authMessage, "아이디 또는 비밀번호가 맞지 않습니다.", "danger");
    return;
  }

  currentUser = { id };
  saveJson(STORAGE_KEYS.currentUser, currentUser);
  loginForm.reset();
  setMessage(authMessage, `${id}님 로그인되었습니다.`, "mint");
  syncUi();
});

fortuneForm.addEventListener("submit", (event) => {
  event.preventDefault();

  if (!currentUser) {
    setMessage(fortuneMessage, "먼저 로그인해주세요.", "danger");
    return;
  }

  const name = document.getElementById("userName").value.trim();
  const birthday = document.getElementById("birthday").value;
  const luckyNumber = Number(document.getElementById("luckyNumber").value);

  if (!name || !birthday || !luckyNumber) {
    setMessage(fortuneMessage, "성함, 생일, 번호를 모두 입력해주세요.", "danger");
    return;
  }

  const score = Math.floor(Math.random() * 100) + 1;
  const quote = fortuneQuotes[Math.floor(Math.random() * fortuneQuotes.length)];
  const grade = gradeByScore(score);
  const createdAt = new Date().toLocaleString("ko-KR");

  const result = {
    userId: currentUser.id,
    name,
    birthday,
    luckyNumber,
    score,
    grade,
    quote,
    createdAt
  };

  history = [result, ...history].slice(0, 6);
  saveJson(STORAGE_KEYS.history, history);
  renderResult(result);
  renderHistory();
  setMessage(fortuneMessage, `${name}님의 오늘 행운 결과가 생성되었습니다.`, "mint");
});

logoutButton.addEventListener("click", () => {
  currentUser = null;
  saveJson(STORAGE_KEYS.currentUser, currentUser);
  setMessage(fortuneMessage, "로그아웃되었습니다.", "muted");
  syncUi();
});

clearHistoryButton.addEventListener("click", () => {
  history = [];
  saveJson(STORAGE_KEYS.history, history);
  renderHistory();
});

function switchTab(tabName) {
  const isSignup = tabName === "signup";
  signupForm.classList.toggle("hidden", !isSignup);
  loginForm.classList.toggle("hidden", isSignup);

  tabButtons.forEach((button) => {
    button.classList.toggle("is-active", button.dataset.tab === tabName);
  });
}

function syncUi() {
  const loggedIn = Boolean(currentUser);
  loginStatus.textContent = loggedIn ? `${currentUser.id} 로그인 중` : "로그인되지 않음";
  logoutButton.disabled = !loggedIn;
  logoutButton.style.opacity = loggedIn ? "1" : "0.45";

  if (!loggedIn) {
    resetResult();
  }

  renderHistory();
}

function renderResult(result) {
  document.getElementById("fortuneScore").textContent = result.score;
  document.getElementById("fortuneGrade").textContent = result.grade;
  document.getElementById("fortuneQuote").textContent = result.quote;
  document.getElementById("resultName").textContent = result.name;
  document.getElementById("resultBirthday").textContent = result.birthday;
  document.getElementById("resultNumber").textContent = String(result.luckyNumber);

  const degree = Math.round((result.score / 100) * 360);
  scoreRing.style.background =
    `conic-gradient(var(--accent) ${degree}deg, rgba(255, 255, 255, 0.08) ${degree}deg)`;
}

function resetResult() {
  document.getElementById("fortuneScore").textContent = "--";
  document.getElementById("fortuneGrade").textContent = "준비중";
  document.getElementById("fortuneQuote").textContent = "로그인하고 행운의 버튼을 눌러주세요.";
  document.getElementById("resultName").textContent = "-";
  document.getElementById("resultBirthday").textContent = "-";
  document.getElementById("resultNumber").textContent = "-";
  scoreRing.style.background =
    "conic-gradient(var(--accent) 0deg, rgba(255, 255, 255, 0.08) 0deg)";
}

function renderHistory() {
  const container = document.getElementById("historyList");
  const visibleHistory = currentUser
    ? history.filter((item) => item.userId === currentUser.id)
    : [];

  if (!visibleHistory.length) {
    container.innerHTML = '<p class="empty-history">아직 생성된 행운 기록이 없습니다.</p>';
    return;
  }

  container.innerHTML = visibleHistory
    .map((item) => `
      <div class="history-item">
        <p>${item.name}님 · ${item.score}점 · ${item.grade}</p>
        <p class="history-meta">${item.createdAt} · 번호 ${item.luckyNumber} · ${item.quote}</p>
      </div>
    `)
    .join("");
}

function setMessage(target, text, tone) {
  target.textContent = text;
  if (tone === "danger") target.style.color = "var(--danger)";
  if (tone === "mint") target.style.color = "var(--mint)";
  if (tone === "muted") target.style.color = "var(--muted)";
}

function loadJson(key, fallbackValue) {
  try {
    const value = localStorage.getItem(key);
    return value ? JSON.parse(value) : fallbackValue;
  } catch (error) {
    return fallbackValue;
  }
}

function saveJson(key, value) {
  localStorage.setItem(key, JSON.stringify(value));
}

syncUi();
