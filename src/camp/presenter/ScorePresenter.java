package camp.presenter;

import camp.SubjectType;
import camp.model.Score;
import camp.view.ScoreView;

import java.util.ArrayList;
import java.util.List;

/**
 * 수강생 관리 기능을 담당하는 Presenter 클래스
 */
public class ScorePresenter {

    private ScoreView scoreView;
    private List<Score> scoreList;


    /**
     * ScorePresenter 생성자
     *
     * @param scoreView 점수 관리 화면을 나타내는 View 인터페이스
     */
    public ScorePresenter(ScoreView scoreView) {
        this.scoreView = scoreView;
        this.scoreList = new ArrayList<>();
    }

    /*
    * 점수 관리 기능을 담당하는 ScorePresenter 클래스를 구현합니다.
    * 점수 등록, 점수 수정, 점수 조회 등의 메서드를 구현합니다.
    * */

    //점수 관리 루프를 통해 값을 입력 받고 입력 받은 값에 따라 메서드 호출 4번 선택시 루프 종료
    public void manageScore(){
        while (true){
            int input =scoreView.displayScoreMenu();

            if(input == 1){
                registerScore();
            }
            else if(input ==2){
                updateScore();
            }
            else if(input == 3){
                displayGrade();
            }
            else if (input == 4) {
                return;
            }
            else{
                System.out.println("잘못된 입력입니다.");
            }
        }
    }

    //시험점수 등록 학생,과목 ID, 회차를 입력받고 해당 점수가 등록되었는지 확인후 새로운 점수 등록 점수는 scoreList에 추가
    private void registerScore(){
        System.out.println("시험 점수를 등록합니다");
        //TODO : StudentPresenter에 검사 요청
        String studentId = scoreView.getStudentId();
        //TODO : SubjectPresenter에 검사 요청
        String subjectID = scoreView.getSubjectId();

        int round = scoreView.getRound();

        Score score = findScore(studentId, subjectID, round);

        if(score != null){
            System.out.println("해당 회차 점수가 이미 존재합니다.");
            return;
        }

        int scoreValue = scoreView.getScore();
        // TODO : getGrade(SubjectType.MANDATORY) <- 이 부분 다른 곳에서 정보 받아오는 것으로 수정하기
        scoreList.add(new Score(generateScoreId(), studentId, subjectID, round, scoreValue,
                getGrade(SubjectType.MANDATORY, scoreValue)));
        System.out.println("시험 점수 등록을 성공했습니다.");
    }

    //시험점수 수정 학생,과목 ID를 입력받고 해당 점수가 존재하는지 확인후 새로운 점수를 입력받아 업데이트
    private void updateScore(){
        System.out.println("시험 점수를 수정합니다");

        String studentId = scoreView.getStudentId();
        String subjectId = scoreView.getSubjectId();
        int round = scoreView.getRound();

        // 점수 찾기
        Score score = findScore(studentId, subjectId, round);
        if(score == null){
            System.out.println("점수가 등록되어있지 않습니다.");
            return;
        }
        int scoreValue = scoreView.getScore();

        // TODO : getGrade(SubjectType.MANDATORY) <- 이 부분 다른 곳에서 정보 받아오는 것으로 수정하기
        score.setScore(scoreValue, getGrade(SubjectType.MANDATORY, scoreValue));
    }

    //회차별 등급 조회 학생,과목 ID를 입력받고 해당 학생과 과목에 대한 모든점수 출력
    private void displayGrade(){
        System.out.println("회차별 등급을 조회합니다");

        String studentId = scoreView.getStudentId();
        String subjectId = scoreView.getSubjectId();

        List<Score> studentScores = new ArrayList<>();
        for (Score score : scoreList){
         if(score.getScoreId().equals(studentId) && score.getSubjectId().equals(subjectId)){
             studentScores.add(score);
             }
        }
        if (studentScores.isEmpty()){
            System.out.println("등록된 점수 정보가 없습니다.");
            return;
        }
        scoreView.displayScores(studentId, subjectId, studentScores);
    }

    //scoreList의 크기에 1을 더하여 "SC"와 조합하여 반환
    private String generateScoreId(){
        return  "SC" + (scoreList.size()+ 1);
    }

    //주어진 학생 ID, 과목 ID, 회차에 해당하는 점수를 찾아. scoreList를 순회하면서 조건에 맞는 점수를 찾아 반환
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

    //주어진 점수와 과목 타입에 해당하는 학점을 반환 만약 과목 타입이 필수인경우
    // 필수과목에 해당하는 학점반환 그렇지 않으면 선택과목 학점 반환
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
