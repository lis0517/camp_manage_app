package camp.view;

import camp.UtilHelper;

import java.util.Scanner;

public class MainView {

    private Scanner scanner;

    public MainView(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * 메인 화면을 출력하고 사용자 입력을 받는 메서드
     *
     * @return 사용자가 선택한 메뉴 번호
     */
    public int displayMainMenu() {
        System.out.println("\n==================================");
        System.out.println("내일배움캠프 수강생 관리 프로그램 실행 중...");
        System.out.println("1. 수강생 관리");
        System.out.println("2. 점수 관리");
        System.out.println("3. 프로그램 종료");
        System.out.print("관리 항목을 선택하세요...");
        return UtilHelper.getIntInput(scanner);
    }
}
