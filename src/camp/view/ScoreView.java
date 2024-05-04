package camp.view;

import java.util.Scanner;

/**
 * 점수 관리 화면을 나타내는 클래스
 */
public class ScoreView {

    Scanner scanner;

    public ScoreView(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * 점수 관리 메뉴를 출력하고 사용자 입력을 받는 메서드
     *
     * @return 사용자가 선택한 메뉴 번호
     */
    public int displayScoreMenu() {
        System.out.println("==================================");
        System.out.println("점수 관리 실행 중...");
        System.out.println("1. 수강생의 과목별 시험 회차 및 점수 등록");
        System.out.println("2. 수강생의 과목별 회차 점수 수정");
        System.out.println("3. 수강생의 특정 과목 회차별 등급 조회");
        System.out.println("4. 메인 화면 이동");
        System.out.print("관리 항목을 선택하세요...");
        return scanner.nextInt();
    }

    // ... 필요한 내용 더 구현

}
