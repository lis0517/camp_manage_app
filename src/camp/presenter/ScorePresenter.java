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

}
