package camp.view;

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
        System.out.println("4. 메인 화면 이동");
        System.out.print("관리 항목을 선택하세요...");
        return scanner.nextInt();
    }

    // ... 필요한 내용 더 구현

    public String getStudentId(){
        System.out.println("수강생 ID를 입력하세요 : ");
        return scanner.next();
    }

    public String getSubjectId(){
        System.out.println("과목 ID를 입력하세요 : ");
        return scanner.next();
    }

    // 시험회차를 입력받아 1미만 10초과할 경우 오류메세지 출력
    public int getRound(){
        while (true){
            System.out.println("시험 회차를 입력하세요 : ");
            int round = scanner.nextInt();
            if(round < 1 || round > 10){
                System.out.println("회차에 1미만 10초과 수가 저장될 수 없습니다. ");
                continue;
            }
            return round;
        }
    }

    //점수를 입력받아 0미만 100초과할 경우 오류 메세지 출력
    public int getScore(){
        while (true){
            System.out.println("점수를 입력하세요 : ");
            int score = scanner.nextInt();
            if(score < 0 || score > 100){
                System.out.println("점수에 100초과 및 음수가 저장될 수 없습니다.");
                continue;
            }
            return score;
        }
    }

    //점수목록 출력 해당 학생과 과목에 대한 점수 목록을 받아 출력
    public void displayScores(String studentId, String subjectId, List<Score> scores) {
        System.out.println("점수 목록:");
        System.out.println("학생 ID: " + studentId + ", 과목 ID: " + subjectId);

        for (Score score : scores) {
            System.out.println(
                    "회차: " + score.getRound() +
                            ", 점수: " + score.getScore() +
                            ", 등급: " + score.getGrade());
        }
    }
}

