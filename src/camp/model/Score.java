package camp.model;

public class Score {
    // 점수가 속한 수강생 ID
    private String studentId;
    // 점수가 속한 과목 ID
    private String subjectId;
    // 시험 회차
    private int round;
    // 점수
    private int score;

    // 점수 등급
    private String grade;

    /**
     * Score 클래스의 생성자
     * @param studentId 점수가 속한 수강생 ID
     * @param subjectId 점수가 속한 과목 ID
     * @param round 시험 회차
     * @param score 점수
     */
    public Score(String studentId, String subjectId, int round, int score, String grade) {
        this.studentId = studentId;
        this.subjectId = subjectId;
        this.round = round;
        this.score = score;
        this.grade = grade;
    }

    // Getters and Setters
    /**
     * 점수가 속한 수강생 ID를 반환하는 메서드
     * @return 수강생 ID
     */
    public String getStudentId() {
        return studentId;
    }

    /**
     * 점수가 속한 과목 ID를 반환하는 메서드
     * @return 과목 ID
     */
    public String getSubjectId() {
        return subjectId;
    }

    /**
     * 시험 회차를 반환하는 메서드
     * @return 시험 회차
     */
    public int getRound() {
        return round;
    }

    /**
     * 점수를 반환하는 메서드
     * @return 점수
     */
    public int getScore() {
        return score;
    }

    // 스코어가 변경되면 등급도 같이 변경하도록?

    /**
     * 점수를 설정하는 메서드
     * @param score 설정할 점수
     */
    public void setScore(int score) {
        this.score = score;
        }

    /**
     * 등급을 반환하는 메서드
     * @return 등급
     */
    public String getGrade() {
        return grade;
    }

    /**
     * 등급을 설정하는 메서드
     * @param grade 설정할 등급
     */
    public void setGrade(String grade) {
        this.grade = grade;
    }

}
