package camp.presenter;

import camp.SubjectType;
import camp.model.Score;
import camp.model.Student;
import camp.model.Subject;
import camp.view.ScoreView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 수강생 관리 기능을 담당하는 Presenter 클래스
 */
public class ScorePresenter {

    private ScoreView scoreView;
    private List<Score> scoreList;

    private StudentPresenter studentPresenter;


    /**
     * ScorePresenter 생성자
     *
     * @param scoreView 점수 관리 화면을 나타내는 View 인터페이스
     */
    public ScorePresenter(ScoreView scoreView) {
        this.scoreView = scoreView;
        this.scoreList = new ArrayList<>();
    }

    public void setStudentPresenter(StudentPresenter studentPresenter){
        this.studentPresenter = studentPresenter;
    }

    //점수 관리 루프를 통해 값을 입력 받고 입력 받은 값에 따라 메서드 호출 4번 선택시 루프 종료
    public void manageScore(){
        while (true) {
            int input = scoreView.displayScoreMenu();

            switch (input) {
                case 1 -> registerScore();
                case 2 -> updateScore();
                case 3 -> displayGrade();
                case 4 -> displayAvgScoreByStatus();
                case 5 -> {
                    return;
                }
                default -> {
                    System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
                }
            }
        }
    }

    /**
     * 시험 점수를 등록하는 메서드
     * 학생 이름, 과목 이름, 회차를 입력받아 해당 점수를 등록합니다.
     * 이미 등록된 점수가 존재하는 경우 등록을 진행하지 않습니다.
     */
    private void registerScore(){
        System.out.println("==================================");
        System.out.println("시험 점수를 등록합니다");

        Student student = findStudent(scoreView.getStudentName()); // 해당 이름의 수강생이 존재하는지 확인
        if (student == null) {
            return;
        }

        Subject subject = findSubject(student, scoreView.getSubjectName()); // 과목이 있는지 확인
        if (subject == null) {
            return;
        }

        int round = scoreView.getRound(); // 회차 정보 입력

        Score score = findScore(student.getStudentId(), subject.getSubjectId(), round); // 정보가 일치하는 score가 존재하면 이미 입력된 점수가 있다는 뜻

        if(score != null){
            System.out.println("해당 회차 점수가 이미 존재합니다.");
            return;
        }

        int scoreValue = scoreView.getScore();
        scoreList.add(new Score(student.getStudentId(), subject.getSubjectId(), round, scoreValue,
                getGrade(subject.getSubjectType(), scoreValue)));
        System.out.println("시험 점수 등록을 성공했습니다.");
    }

    /**
     * 시험 점수를 수정하는 메서드
     * 학생 이름, 과목 이름, 회차를 입력받아 해당 점수를 수정합니다.
     * 등록되지 않은 점수인 경우 수정을 진행하지 않습니다.
     */
    private void updateScore(){
        System.out.println("==================================");
        System.out.println("시험 점수를 수정합니다...");

        Student student = findStudent(scoreView.getStudentName());
        if (student == null) {
            return;
        }

        Subject subject = findSubject(student, scoreView.getSubjectName());
        if (subject == null) {
            return;
        }

        int round = scoreView.getRound();

        // 점수 찾기
        Score score = findScore(student.getStudentId(), subject.getSubjectId(), round); // 수정하는 경우에는 없으면 안됨
        if(score == null){
            System.out.println("점수가 등록되어있지 않습니다.");
            return;
        }
        int scoreValue = scoreView.getScore();

        score.setScore(scoreValue);
        score.setGrade(getGrade(subject.getSubjectType(),scoreValue));
    }

    /**
     * 회차별 등급을 조회하는 메서드
     * 학생 이름, 과목 이름을 입력받아 해당 학생의 특정 과목에 대한 모든 점수를 출력합니다.
     */
    private void displayGrade(){
        System.out.println("==================================");
        System.out.println("회차별 등급을 조회합니다...");

        Student student = findStudent(scoreView.getStudentName());
        if (student == null) {
            return;
        }

        Subject subject = findSubject(student, scoreView.getSubjectName());
        if (subject == null) {
            return;
        }

        List<Score> studentScores = new ArrayList<>();
        for (Score score : scoreList){
         if(score.getStudentId().equals(student.getStudentId())
                 && score.getSubjectId().equals(subject.getSubjectId())){
             studentScores.add(score);
             }
        }
        if (studentScores.isEmpty()){
            System.out.println("등록된 점수 정보가 없습니다.");
            return;
        }
        scoreView.displayScores(student.getStudentName(), subject.getSubjectName(), studentScores); // ID가 아닌 학생과 과목 이름으로 표현하게 바꿨습니다.
    }

    /**
     * 특정 상태의 학생들의 필수 과목 평균 등급을 조회하는 메서드
     * 상태를 입력받아 해당 상태의 학생들의 필수 과목 평균 점수와 등급을 출력합니다.
     */
    public void displayAvgScoreByStatus(){
        // 상태 입력
        String status = scoreView.getStudentStatus();

        List<Student> studentList  = studentPresenter.getStudentListByStatus(status);
        if ( studentList  == null || studentList.isEmpty() ){
            System.out.println("상태에 해당되는 학생들이 존재하지않습니다.");
            return;
        }

        for( Student student : studentList ){
            List<Score> studentScores = getStudentMandatoryScores(student);

            if (studentScores.isEmpty()) {
                System.out.println(student.getStudentName() + " 학생의 필수 과목 점수 정보가 없습니다.");
                continue;
            }

            // 학생의 필수 과목 합계 구하기
            double totalScore = studentScores.stream()
                    .mapToInt(Score::getScore)
                    .sum();

            // 필수 과목 합과 과목 개수를 나눠 평균 구하기
            double avgScore = totalScore / studentScores.size();
            
            // getGrade 함수를 통해 평균으로 등급 구하기
            scoreView.displayAvgScoreByStatus(student.getStudentName(), getGrade(SubjectType.MANDATORY,(int)avgScore));
        }
    }

    private List<Score> getStudentMandatoryScores(Student student) {
        return scoreList.stream()
                .filter(score -> score.getStudentId().equals(student.getStudentId()))
                .filter(score -> {
                    Subject subject = studentPresenter.findSubjectById(student, score.getSubjectId());
                    return subject != null && subject.getSubjectType() == SubjectType.MANDATORY;
                })
                .collect(Collectors.toList());
    }

    /**
     * 주어진 학생 ID, 과목 ID, 회차에 해당하는 점수를 찾는 메서드
     *
     * @param studentId 학생 ID
     * @param subjectId 과목 ID
     * @param round     회차
     * @return 해당하는 점수 객체, 없으면 null 반환
     */
    private Score findScore(String studentId, String subjectId, int round){
        for(Score score : scoreList){
            if (score.getStudentId().equals(studentId) &&
                    score.getSubjectId().equals(subjectId) &&
                    score.getRound() == round) {
                return score;
            }
        }
        return null;
    }

    /**
     * 이름으로 학생을 찾는 메서드
     *
     * @param studentName 찾고자 하는 학생의 이름
     * @return 해당하는 학생 객체, 없으면 null 반환
     */
    private Student findStudent(String studentName) {
        Student student = studentPresenter.findStudentByName(studentName);
        if (student == null) {
            System.out.println("등록되어있지않은 학생 이름입니다.");
        }
        return student;
    }

    /**
     * 특정 학생의 이름으로 과목을 찾는 메서드
     *
     * @param student     찾고자 하는 과목이 속한 학생 객체
     * @param subjectName 찾고자 하는 과목의 이름
     * @return 해당하는 과목 객체, 없으면 null 반환
     */
    private Subject findSubject(Student student, String subjectName) {
        Subject subject = studentPresenter.findSubjectByName(student, subjectName);
        if (subject == null) {
            System.out.println("등록되어있지않은 과목 이름입니다.");
        }
        return subject;
    }

    /**
     * 점수와 과목 타입에 따라 해당하는 등급을 반환하는 메서드
     *
     * @param subjectType 과목 타입 (필수/선택)
     * @param score       점수
     * @return 해당하는 등급 (A, B, C, D, F, N)
     */
    private String getGrade(SubjectType subjectType, int score) {
        if (subjectType == SubjectType.MANDATORY) {
            if (score >= 95 && score <= 100) {
                return "A";
            } else if (score >= 90 && score <= 94) {
                return "B";
            } else if (score >= 80 && score <= 89) {
                return "C";
            } else if (score >= 70 && score <= 79) {
                return "D";
            } else if (score >= 60 && score <= 69) {
                return "F";
            } else {
                return "N";
            }
        }
        else {
            if (score >= 90 && score <= 100) {
                return "A";
            } else if (score >= 80 && score <= 89) {
                return "B";
            } else if (score >= 70 && score <= 79) {
                return "C";
            } else if (score >= 60 && score <= 69) {
                return "D";
            } else if (score >= 50 && score <= 59) {
                return "F";
            } else {
                return "N";
            }
        }
    }

}
