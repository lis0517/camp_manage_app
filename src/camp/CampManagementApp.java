package camp;

import camp.view.MainView;

import java.util.Scanner;

public class CampManagementApp {

    private static MainView mainView;
    
    // 자기가 만든 presenter를 만들어서 테스트 해보기

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        //ex. StudentPesenter = new StudentPresenter(new StudentView(scanner));

        mainView = new MainView(scanner);

        // 메인 화면 표시
        displayMainView();
    }

    private static void displayMainView(){
        boolean exit = false;

        while( !exit ){
            int input = mainView.displayMainMenu();


            switch (input){
                // case 1,2,3에 자기가 연결한 기능을 추가해서 테스트해보기
                case 4 -> {
                    exit = true;
                    System.out.println("프로그램을 종료합니다.");
                }
                default -> System.out.println("잘못된 입력입니다.");
            }
        }
    }

}
