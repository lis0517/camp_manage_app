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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        MainView mainView = new MainView(scanner);
        SubjectPresenter subjectPresenter = new SubjectPresenter(new SubjectView(scanner));
        StudentPresenter studentPresenter = new StudentPresenter(new StudentView(scanner));
        ScorePresenter scorePresenter = new ScorePresenter(new ScoreView(scanner));

        studentPresenter.setSubjectPresenter( subjectPresenter );
        scorePresenter.setStudentPresenter( studentPresenter );


        // 메인 화면 표시
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
