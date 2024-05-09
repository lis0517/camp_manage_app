package camp.view;

import camp.model.Student;

import java.util.List;
import java.util.Scanner;

/**
 * 수강생 관리 화면을 나타내는 View 인터페이스
 */
public class StudentView {

    Scanner scanner;

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
        System.out.println("3. 메인 화면 이동");
        System.out.print("관리 항목을 선택하세요...");
        return scanner.nextInt();
    }


    public String getStudentName(){
        System.out.print("학생 이름을 입력해주세요: ");
        return scanner.next();
    }

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
}
