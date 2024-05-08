package camp.presenter;

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
    private List<String> gradeList;

    /**
     * ScorePresenter 생성자
     *
     * @param scoreView 점수 관리 화면을 나타내는 View 인터페이스
     */
    public ScorePresenter(ScoreView scoreView) {
        this.scoreView = scoreView;
        this.scoreList = new ArrayList<>();
        this.gradeList = new ArrayList<>();
    }

    /*
    * 점수 관리 기능을 담당하는 ScorePresenter 클래스를 구현합니다.
    * 점수 등록, 점수 수정, 점수 조회 등의 메서드를 구현합니다.
    * */

    public void addScore(Score score){
            scoreList.add(score);
            String grade = getGrade(score.getScore());
            gradeList.add(grade);
            scoreView.displayMessage("점수가 등록되었습니다.");
    }

    public void displayAllScore(){
        if(scoreList.isEmpty()){
            scoreView.displayMessage("등록된 점수가 없습니다");
        }
        else{
            scoreView.displayScores(scoreList, gradeList);
        }
    }

    public void displayScore(String scoreId){
        boolean bool = false;
        for (Score score: scoreList){
            if(score.getScoreId().equals(scoreId)){
                String grade = gradeList.get(scoreList.indexOf(score));
                scoreView.displayMessage("점수: " + score.getScore() + ", 등급: " + getGrade(score.getScore()));
                bool = true;
                break;
            }
        }
        if(!bool){
            scoreView.displayMessage("해당 점수와 등급을 찾을 수 없습니다.");
        }
    }

    private String getGrade(int score) {
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

}
