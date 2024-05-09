package camp.view;

import camp.StudentStatus;
import camp.model.Student;
import camp.model.Subject;

import java.util.List;
import java.util.Scanner;

/**
 * 수강생 관리 화면을 나타내는 View 인터페이스
 */
public class StudentView {

    Scanner scanner;

    /**
     * StudentView 생성자
     *
     * @param scanner 사용자 입력을 받기 위한 Scanner 객체
     */
    public StudentView(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * 수강생 관리 메뉴를 출력하고 사용자 입력을 받는 메서드
     *
     * @return 사용자가 선택한 메뉴 번호
     */
    public int displayStudentMenu() {
        System.out.println("==================================");
        System.out.println("수강생 관리 실행 중...");
        System.out.println("1. 수강생 등록");
        System.out.println("2. 수강생 목록 조회");
        System.out.println("3. 수강생 상태 관리");
        System.out.println("4. 수강생 정보 조회");
        System.out.println("5. 메인 화면 이동");
        System.out.print("관리 항목을 선택하세요...");
        return scanner.nextInt();
    }


    /**
     * 수강생의 이름을 입력받는 메서드
     *
     * @return 입력받은 수강생의 이름
     */
    public String getStudentName(){
        System.out.print("수강생의 이름을 입력해주세요: ");
        String name = scanner.next();
        scanner.nextLine();
        return name;
    }

    /**
     * 수강생의 상태를 입력받는 메서드
     *
     * @return 입력받은 수강생의 상태
     */
    public String getStudentStatus(){
        System.out.print("수강생의 상태를 선택해주세요.(1.좋음, 2.나쁨, 3.보통): ");
        int status;
        while(true){ // 올바른 값이 입력 될 때까지 반복
            status = scanner.nextInt();
            scanner.nextLine();
            if ( status < 1 || status > 3 ){
                System.out.println("정의되지않은 수강생의 상태입니다.");
                continue;
            }
            break;
        }
        return switch (status) {
            case 1 -> StudentStatus.GREEN.getStatusText();
            case 2 -> StudentStatus.RED.getStatusText();
            default -> StudentStatus.YELLOW.getStatusText();
        };
    }

    /**
     * 수강생 목록을 출력하는 메서드
     *
     * @param studentList 출력할 수강생 목록
     */
    public void displayStudentList(List<Student> studentList){
        System.out.println("==================================");
        System.out.println("수강생 목록을 조회합니다...");

        if(studentList.isEmpty()) {
            System.out.println("등록된 학생이 없습니다.");
            return;
        }

        for(Student student : studentList) {
            System.out.println("학생 ID: " + student.getStudentId() + "이름: " + student.getStudentName());

            System.out.println("----------------------------------");
        }
    }

    /**
     * 특정 수강생의 정보를 출력하는 메서드
     *
     * @param student 출력할 수강생 객체
     */
    public void displayStudentInfo(Student student){
        System.out.println("==================================");
        System.out.println("수강생 정보 출력...");
        System.out.println("고유 번호 | 이름 | 상태");
        System.out.println(student.getStudentId() + ", " + student.getStudentName() + ", " + student.getStatus());

        System.out.println("----------------------------------");
        System.out.println("선택한 과목명: ");

        List<Subject> subjects = student.getSubjects();
        if ( subjects.isEmpty() ){
            System.out.println("선택한 과목이 없습니다.");
        }else{
            for(Subject subject : subjects){
                System.out.println(subject.getSubjectName());
            }
        }
    }
}
