package day06Prac.testplay;

public class StudyFortuneResult {

	private final String name;
	private final String subject;
	private final int focusLevel;
	private final int studyTime;
	private final int score;
	private final String level;
	private final String fortune;
	private final String advice;
	private final String createdAt;

	public StudyFortuneResult(String name, String subject, int focusLevel, int studyTime, int score, String level,
			String fortune, String advice, String createdAt) {
		this.name = name;
		this.subject = subject;
		this.focusLevel = focusLevel;
		this.studyTime = studyTime;
		this.score = score;
		this.level = level;
		this.fortune = fortune;
		this.advice = advice;
		this.createdAt = createdAt;
	}

	public String getName() {
		return name;
	}

	public String getSubject() {
		return subject;
	}

	public int getFocusLevel() {
		return focusLevel;
	}

	public int getStudyTime() {
		return studyTime;
	}

	public int getScore() {
		return score;
	}

	public String getLevel() {
		return level;
	}

	public String getFortune() {
		return fortune;
	}

	public String getAdvice() {
		return advice;
	}

	public String getCreatedAt() {
		return createdAt;
	}
}
