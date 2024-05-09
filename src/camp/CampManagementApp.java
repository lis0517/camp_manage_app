package camp;

import camp.presenter.ScorePresenter;
import camp.presenter.StudentPresenter;
import camp.presenter.SubjectPresenter;
import camp.view.MainView;
import camp.view.ScoreView;
import camp.view.StudentView;
import camp.view.SubjectView;

import java.util.Scanner;

public class CampManagementApp {

    private static MainView mainView;
    private static StudentPresenter studentPresenter;
    private static ScorePresenter scorePresenter;
    
    // 자기가 만든 presenter를 만들어서 테스트 해보기

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        mainView = new MainView(scanner);
        studentPresenter = new StudentPresenter(new StudentView(scanner));
        scorePresenter = new ScorePresenter(new ScoreView(scanner));
        // 메인 화면 표시
        displayMainView();
    }

    private static void displayMainView(){
        boolean exit = false;

        while( !exit ){
            int input = mainView.displayMainMenu();


            switch (input){
                 case 1 -> {
                    studentPresenter.manageStudent();
                 }
                case 2 -> {
                    scorePresenter.manageScore();
                 }
                case 3 -> {
                    exit = true;
                    System.out.println("프로그램을 종료합니다.");
                }
                default -> System.out.println("잘못된 입력입니다.");
            }
        }
    }
}
