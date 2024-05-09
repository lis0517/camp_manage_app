packagepackage camp.view;

import camp.SubjectType;
import camp.model.Subject;

import java.util.List;
import java.util.Scanner;

public class SubjectView {

    Scanner scanner;

    public SubjectView(Scanner scanner) {
        this.scanner = scanner;
    }
  //스캐너사용

    /*StudentView, ScoreView 예시 참고*/

    public String getSubjectName() {
        System.out.print("수강할 과목 이름 입력: ");
        return scanner.nextLine();
    }
//과목을 입력합니다
    public void displaySubjectList(SubjectType type, List<Subject> subjectList) {
        if (subjectList.isEmpty()){
            System.out.println("과목 목록이 비어있습니다.");
            return;
        }
//리스트 생성 과목 비여있음
        System.out.println(type == SubjectType.MANDATORY ? "필수 과목 목록" : "선택 과목 목록");
        System.out.println("================");
//subjecttype.mandantory가 필수 과목 목록 일지 선택 과목 목록 일지 서택후 출력
        for (Subject subject : subjectList) {
            System.out.println(subject.getSubjectName());
            System.out.println("----------------");
//과목이 subjectList일 동안 getSubjectName 한다(추가한다).
        }
    }


}
