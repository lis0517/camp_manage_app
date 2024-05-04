package camp.model;

import camp.StudentStatus;
import java.util.ArrayList;
import java.util.List;

/**
 * 수강생 정보를 저장하고 관리하는 클래스
 */
public class Student {
    // 수강생 고유 ID
    private String studentId;
    // 수강생 이름
    private String studentName;
    // 수강생이 수강 중인 과목 목록
    private List<Subject> subjects;

    private StudentStatus status;

    /**
     * Student 클래스의 생성자
     * @param studentId 수강생 고유 ID
     * @param studentName 수강생 이름
     */
    public Student(String studentId, String studentName){
        this.studentId = studentId;
        this.studentName = studentName;
        this.subjects = new ArrayList<>();
    }

    /**
     * 수강생이 수강할 과목을 추가하는 메서드
     * @param subject 추가할 과목 객체
     */
    public void addSubject(Subject subject){
        subjects.add(subject);
    }

    // Getters

    /**
     * 수강생 고유 ID를 반환하는 메서드
     * @return 수강생 고유 ID
     */
    public String getStudentId(){
        return studentId;
    }

    /**
     * 수강생 이름을 반환하는 메서드
     * @return 수강생 이름
     */
    public String getStudentName() {
        return studentName;
    }

    /**
     * 수강생이 수강 중인 과목 목록을 반환하는 메서드
     * @return 수강 중인 과목 목록
     */
    public List<Subject> getSubjects(){
        return subjects;
    }

    /**
     * 수강생의 상태를 반환하는 메서드
     * @return 수강생 상태를 문자열로 반환
     * */
    public String getStatus(){
        return status.getStatusText();
    }

    //Setter
    /**
     * 수강생의 상태를 등록하는 메서드
     * @
     * */
    public void setStatus(String status){
        this.status = StudentStatus.fromString(status);
    }

}
