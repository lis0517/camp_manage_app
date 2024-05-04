package camp.presenter;

import camp.model.Student;
import camp.view.StudentView;

import java.util.ArrayList;
import java.util.List;

/**
 * 수강생 관리 기능을 담당하는 Presenter 클래스
 */
public class StudentPresenter {
    private StudentView studentView;
    private List<Student> studentList;

    /**
     * StudentPresenter 생성자
     *
     * @param studentView 수강생 관리 화면을 나타내는 View 인터페이스
     */
    public StudentPresenter(StudentView studentView) {
        this.studentView = studentView;
        this.studentList = new ArrayList<>();
    }

    /*
    * 수강생 관리 기능을 담당하는 StudentPresenter 클래스를 구현합니다.
    * 수강생 등록, 수강생 조회 등의 메서드를 구현합니다.
    * */

}
