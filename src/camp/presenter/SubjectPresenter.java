package camp.presenter;

import camp.model.Subject;
import camp.view.SubjectView;

import java.util.ArrayList;
import java.util.List;

/**
 * 과목 관리 기능을 담당하는 Presenter 클래스
 */
public class SubjectPresenter {


    private SubjectView subjectView;
    private List<Subject> subjectList;

    /**
     * SubjectPresenter 생성자
     *
     * @param subjectView 과목 관리 화면을 나타내는 View 인터페이스
     */
    public SubjectPresenter(SubjectView subjectView) {
        this.subjectView = subjectView;
        this.subjectList = new ArrayList<>();
    }

    /*
    * 과목 관리 기능을 담당하는 SubjectPresenter 클래스를 구현합니다.
    * 과목 등록, 과목 조회 등의 메서드를 구현합니다.
    * */
}
