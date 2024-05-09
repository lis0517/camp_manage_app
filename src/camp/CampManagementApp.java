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
    private static SubjectPresenter subjectPresenter;
    private static ScorePresenter scorePresenter;
    
    // 자기가 만든 presenter를 만들어서 테스트 해보기

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        //ex. StudentPesenter = new StudentPresenter(new StudentView(scanner));

        mainView = new MainView(scanner);
        studentPresenter = new StudentPresenter(new StudentView(scanner));
        subjectPresenter = new SubjectPresenter(new SubjectView(scanner));
        scorePresenter = new ScorePresenter(new ScoreView(scanner));
        // 메인 화면 표시
        displayMainView();
    }

    private static void displayMainView(){
        boolean exit = false;

        while( !exit ){
            int input = mainView.displayMainMenu();


            switch (input){
                // case 1,2,3에 자기가 연결한 기능을 추가해서 테스트해보기
//                case 1 -> {
//                    System.out.println("학생 등록 화면으로 이동합니다."); //학생 등록
//                    int studentInput = studentPresenter.displayStudentMenu();// StudentPresenter 에 Menu호출메서드추가.
//                }
//                case 2 -> {
//                    System.out.println("점수 관리 화면으로 이동합니다.");// 점수 등록
//                    int scoreInput = scorePresenter.displayScoreMenu();// ScorePresenter 에 Menu호출메서드추가.
//                }
//                case 3 -> {
//                    System.out.println("과목별 관리 화면으로 이동합니다.");// 과목 등록 만들어 지면 변경
//                    int subjectInput = subjcetPresenter.displaySubjectMenu();
//                }
                case 4 -> {
                    exit = true;
                    System.out.println("프로그램을 종료합니다.");
                }
                default -> System.out.println("잘못된 입력입니다.");
            }
        }
    }
}
