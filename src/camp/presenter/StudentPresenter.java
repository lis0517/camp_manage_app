package camp.presenter;

import camp.SubjectType;
import camp.model.Student;
import camp.model.Subject;
import camp.view.StudentView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 수강생 관리 기능을 담당하는 Presenter 클래스
 */
public class StudentPresenter {

    private static final int MANDATORY_SUBJECT_MIN_COUNT = 3; // 코드에 2, 3 같이 직접 입력하지않는 것이 좋습니다.
    private static final int CHOICE_SUBJECT_MIN_COUNT = 2;

    private StudentView studentView;
    private List<Student> studentList;

    private SubjectPresenter subjectPresenter;

    /**
     * StudentPresenter 생성자
     *
     * @param studentView 수강생 관리 화면을 나타내는 View 인터페이스
     */
    public StudentPresenter(StudentView studentView) {
        this.studentView = studentView;
        this.studentList = new ArrayList<>();
        this.subjectPresenter = null;
    }

    /**
     * SubjectPresenter를 설정하는 메서드
     *
     * @param subjectPresenter 설정할 SubjectPresenter 객체
     */
    public void setSubjectPresenter(SubjectPresenter subjectPresenter){
        this.subjectPresenter = subjectPresenter;
    }


    /**
     * 수강생 관리 메뉴를 실행하는 메서드
     */
    public void manageStudent() {
        while (true) {
            int input = studentView.displayStudentMenu();

            switch (input) {
                case 1 -> registerStudent(); // 수강생 등록
                case 2 -> displayStudentList(); // 수강생 전체 목록 보기
                case 3 -> updateStudentStatus(); // 수강생 상태 관리
                case 4 -> displayStudentInfo(); // 특정 수강생 정보 보기
                case 5 -> {
                    return;
                }
                default -> System.out.println("잘못된 입력입니다.");
            }
        }
    }

    /**
     * 수강생을 등록하는 메서드
     */
    public void registerStudent(){
        System.out.println("==================================");
        System.out.println("수강생을 등록합니다...");

        String name = studentView.getStudentName();
        // 필수 과목 고르기
        List<Subject> mandatorySubjects = selectSubjects(SubjectType.MANDATORY, MANDATORY_SUBJECT_MIN_COUNT);
        // 선택 과목 고르기
        List<Subject> choiceSubjects = selectSubjects(SubjectType.CHOICE, CHOICE_SUBJECT_MIN_COUNT);

        if ( mandatorySubjects.size() < MANDATORY_SUBJECT_MIN_COUNT || choiceSubjects.size() < CHOICE_SUBJECT_MIN_COUNT ){
            System.out.println("필수 과목 또는 선택 과목 선택이 부족합니다. 수강생 등록을 취소합니다.");
            return;
        }

        // 필수, 선택 리스트를 한 리스트로 합침
        List<Subject> allSubjects = new ArrayList<>(mandatorySubjects);
        allSubjects.addAll(choiceSubjects);

        studentList.add(new Student(generateStudentId(), name, allSubjects));
        System.out.println("수강생 등록 성공!\n");
    }

    /**
     * 수강생 목록을 출력하는 메서드
     */
    public void displayStudentList(){
        System.out.println("==================================");
        System.out.println("수강생 목록을 조회합니다...");
        studentView.displayStudentList(studentList);
    }

    /**
     * 수강생의 상태를 업데이트하는 메서드
     */
    public void updateStudentStatus(){
        System.out.println("==================================");
        System.out.println("수강생의 상태를 관리합니다...");

        Student student = findStudentByName(studentView.getStudentName());
        if ( student == null ){
            System.out.println("등록되어있지않은 수강생입니다.");
            return;
        }

        String status = studentView.getStudentStatus();

        student.setStatus(status);
        System.out.println("수강생 상태 변경 성공!\n");
    }

    /**
     * 수강생 정보를 출력하는 메서드
     */
    public void displayStudentInfo(){
        System.out.println("==================================");
        System.out.println("수강생 정보를 조회합니다...");

        Student student = findStudentByName(studentView.getStudentName());
        if ( student == null ){
            System.out.println("등록되어있지않은 수강생입니다.");
            return;
        }
        studentView.displayStudentInfo(student);
    }

    /**
     * 이름으로 수강생을 찾는 메서드
     *
     * @param name 찾고자 하는 수강생의 이름
     * @return 찾은 수강생 객체, 없으면 null 반환
     */
    public Student findStudentByName(String name){
        for(Student st : studentList){
            if(st.getStudentName().equals(name)){
                return st;
            }
        }
        return null;
    }

    /**
     * 특정 수강생의 과목을 이름으로 찾는 메서드
     *
     * @param student   찾고자 하는 과목이 속한 수강생 객체
     * @param name 찾고자 하는 과목의 이름
     * @return 찾은 과목 객체, 없으면 null 반환
     */
    public Subject findSubjectByName(Student student, String name){
        for(Subject sb : student.getSubjects()){
            if(sb.getSubjectName().equals(name)){
                return sb;
            }
        }
        return null;
    }

    /**
     * 주어진 타입과 개수에 맞는 과목을 선택하는 메서드
     *
     * @param type  선택할 과목의 타입 (필수/선택)
     * @param count 선택할 과목의 개수
     * @return 선택된 과목 리스트
     */
    private List<Subject> selectSubjects(SubjectType type, int count) {
        return subjectPresenter.selectSubjects(type, count);
    }

    /**
     * 특정 수강생의 과목을 ID로 찾는 메서드
     *
     * @param student 찾고자 하는 과목이 속한 수강생 객체
     * @param id      찾고자 하는 과목의 ID
     * @return 찾은 과목 객체, 없으면 null 반환
     */
    public Subject findSubjectById(Student student, String id){
        return student.getSubjects().stream()
                .filter(subject -> subject.getSubjectId().equals(id))
                .findFirst()
                .orElse(null);
    }

    /**
     * 특정 상태의 수강생 목록을 반환하는 메서드
     *
     * @param status 찾고자 하는 수강생의 상태
     * @return 해당 상태의 수강생 목록
     */
    public List<Student> getStudentListByStatus(String status) {
        return studentList.stream()
                .filter(student -> student.getStatus().equals(status))
                .collect(Collectors.toList());
    }

    /**
     * 새로운 수강생 ID를 생성하는 메서드
     *
     * @return 새로 생성된 수강생 ID
     */
    private String generateStudentId(){
        return "ST" + ( studentList.size() + 1 );
    }
}
