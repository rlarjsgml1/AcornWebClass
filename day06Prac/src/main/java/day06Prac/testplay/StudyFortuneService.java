package day06Prac.testplay;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class StudyFortuneService {

	private static final List<StudyFortuneResult> HISTORY = new ArrayList<>();
	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	public StudyFortuneResult createFortune(StudyFortuneRequest request) {
		String name = normalizeName(request.getName());
		String subject = normalizeSubject(request.getSubject());
		int focusLevel = normalizeFocusLevel(request.getFocusLevel());
		int studyTime = normalizeStudyTime(request.getStudyTime());

		int score = (name.length() * 11 + subject.length() * 7 + focusLevel * 15 + studyTime * 3) % 100;
		String fortune;
		String advice;
		String level;

		if (score >= 80) {
			level = "상";
			fortune = "오늘은 집중이 잘 되는 날입니다.";
			advice = subject + " 과목에서 어려운 문제를 먼저 풀고 마지막에 오답 정리를 해보세요.";
		} else if (score >= 50) {
			level = "중";
			fortune = "무난하게 공부 흐름을 만들 수 있는 날입니다.";
			advice = "50분 공부 후 10분 휴식으로 리듬을 맞추면 좋습니다.";
		} else {
			level = "하";
			fortune = "조금 지칠 수 있으니 짧은 목표부터 시작하는 게 좋습니다.";
			advice = subject + " 과목의 쉬운 개념 3개만 먼저 정리해 보세요.";
		}

		StudyFortuneResult result = new StudyFortuneResult(
			name,
			subject,
			focusLevel,
			studyTime,
			score,
			level,
			fortune,
			advice,
			LocalDateTime.now().format(FORMATTER)
		);

		synchronized (HISTORY) {
			HISTORY.add(0, result);
			if (HISTORY.size() > 5) {
				HISTORY.remove(HISTORY.size() - 1);
			}
		}

		return result;
	}

	public List<StudyFortuneResult> getHistory() {
		synchronized (HISTORY) {
			return new ArrayList<>(HISTORY);
		}
	}

	private String normalizeName(String name) {
		if (name == null || name.trim().isEmpty()) {
			return "익명";
		}
		return name.trim();
	}

	private String normalizeSubject(String subject) {
		if (subject == null || subject.trim().isEmpty()) {
			return "공통";
		}
		return subject.trim();
	}

	private int normalizeFocusLevel(int focusLevel) {
		if (focusLevel < 1) {
			return 1;
		}
		if (focusLevel > 5) {
			return 5;
		}
		return focusLevel;
	}

	private int normalizeStudyTime(int studyTime) {
		if (studyTime < 10) {
			return 10;
		}
		return studyTime;
	}
}
