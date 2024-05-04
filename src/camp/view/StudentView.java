package camp.view;

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

    // ... 필요한 내용 더 구현

}
