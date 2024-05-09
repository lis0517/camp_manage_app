package camp.presenter;

import camp.SubjectType;
import camp.model.Student;
import camp.model.Subject;
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
        this.subjectPresenter=null;
    }

    public void manageStudent() {
        while (true) {
            int input = studentView.displayStudentMenu();

            switch (input) {
                case 1 -> registerStudent();
                case 2 -> displayStudentList();
                case 3 -> {
                    return;
                }
                default -> System.out.println("잘못된 입력입니다.");
            }
        }
    }

    public void registerStudent(){
        System.out.println("==================================");
        System.out.println("학생 정보를 등록합니다...");

        String name = studentView.getStudentName();
        // TODO : 과목 선택은 과목 담당자에게 요청 및 선택된 과목리스트가 넘어온다고 가정
        List<Subject> mandatorySubjects = selectSubjects(SubjectType.MANDATORY, 3);
        List<Subject> choiceSubjects = selectSubjects(SubjectType.CHOICE, 2);

        // 최소 개수가 모자라면 어떻게 할지도 생각해보시면 좋습니다.

        // 넘어온 리스트 합쳐서 등록하기
        List<Subject> allSubjects = new ArrayList<>();
        allSubjects.addAll(mandatorySubjects);
        allSubjects.addAll(choiceSubjects);
        // 기능 구현
        System.out.println("수강생 등록 성공!\n");
    }

    public void displayStudentList(){
        System.out.println("==================================");
        System.out.println("수강생 목록을 조회합니다...");
        studentView.displayStudentList(studentList);
    }
    //이름으로 찾아오기.
    public Student findByName(String name){
        for(Student st : studentList){
            if(st.getStudentName().equals(name)){
                return st;
            }
        }
    }

    public Subject findSubjectByName(Student student, String name){
        for(Subject sb : student.getSubject()){
            if(sb.getSubjectName().equals(name)){
                return sb;
            }
        }
    }
    private List<Subject> selectSubjects(SubjectType type, int count) {
        // 과목 담당자로부터 과목을 선택하여 받아오는 기능이라고 가정
        // 실제로는 이 과정에 대한 코드가 들어가야 합니다.
        return new ArrayList<>(); // 임시로 빈 리스트 반환
    }

    private String generateStudentId(){
        return "ST" + ( studentList.size() + 1 );
    }
}
