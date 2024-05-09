package camp.view;

import camp.StudentStatus;
import camp.UtilHelper;
import camp.model.Score;

import java.util.List;
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
        System.out.println("4. 특정 상태 수강생들의 필수 과목 평균 등급");
        System.out.println("5. 메인 화면 이동");
        System.out.print("관리 항목을 선택하세요...");
        return UtilHelper.getIntInput(scanner);
    }

    /**
     * 수강생의 이름을 입력받는 메서드
     *
     * @return 입력받은 수강생의 이름
     */
    public String getStudentName(){
        System.out.print("수강생 이름을 입력하세요: ");

        String name = scanner.next().trim(); // 공백 제거
        scanner.nextLine(); // 개행 문자로 인해 의도치않게 넘어가는 일 방지
        return name;
    }

    /**
     * 과목의 이름을 입력받는 메서드
     *
     * @return 입력받은 과목의 이름
     */
    public String getSubjectName(){
        System.out.print("과목 이름을 입력하세요: ");

        String name = scanner.next().trim(); // 공백 제거
        scanner.nextLine(); // 개행 문자로 인해 의도치않게 넘어가는 일 방지
        return name;
    }

    /**
     * 수강생의 상태를 입력받는 메서드
     *
     * @return 입력받은 수강생의 상태
     */
    public String getStudentStatus(){
        System.out.print("찾을 수강생의 상태를 선택해주세요.(1.좋음, 2.나쁨, 3.보통): ");
        int status;
        while(true){ // 올바른 값이 입력 될 때까지 반복
            status = UtilHelper.getIntInput(scanner);
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
     * 시험 회차를 입력받는 메서드
     *
     * @return 입력받은 시험 회차
     */
    public int getRound(){
        while (true){
            System.out.print("시험 회차를 입력하세요 : ");
            int round = UtilHelper.getIntInput(scanner);
            if(round < 1 || round > 10){ // 해당 조건에 걸리는 경우 while문 처음으로 돌아가서 입력을 다시 받습니다.
                System.out.println("회차에 1미만 10초과 수가 저장될 수 없습니다. ");
                continue;
            }
            return round;
        }
    }

    /**
     * 점수를 입력받는 메서드
     *
     * @return 입력받은 점수
     */
    public int getScore(){
        while (true){
            System.out.print("점수를 입력하세요 : ");
            int score = UtilHelper.getIntInput(scanner);
            if(score < 0 || score > 100){ // 해당 조건에 걸리는 경우 while문 처음으로 돌아가서 입력을 다시 받습니다.
                System.out.println("점수에 100초과 및 음수가 저장될 수 없습니다.");
                continue;
            }
            return score;
        }
    }

    //점수목록 출력 해당 학생과 과목에 대한 점수 목록을 받아 출력
    public void displayScores(String studentName, String subjectName, List<Score> scores) {
        System.out.println("점수 목록:");
        System.out.println("학생 이름: " + studentName + ", 과목 이름: " + subjectName);

        for (Score score : scores) {
            System.out.println(
                    "회차: " + score.getRound() +
                            ", 점수: " + score.getScore() +
                            ", 등급: " + score.getGrade());
        }
    }

    public void displayAvgScoreByStatus(String studentName, String grade) {
        System.out.println("학생 이름: " + studentName + ", 필수 과목 평균 등급: " + grade );
    }
}

