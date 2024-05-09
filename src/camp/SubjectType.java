package camp.view;

import camp.SubjectType;
import camp.model.Subject;

import java.util.List;
import java.util.Scanner;

public class SubjectView {

    Scanner scanner;

    public SubjectView(Scanner scanner) {
        this.scanner = scanner;
    }

    /*StudentView, ScoreView 예시 참고*  /

    public String getSubjectName() {
        System.out.print("수강할 과목 이름 입력: ");
        return scanner.nextLine();
    }

    public void displaySubjectList(SubjectType type, List<Subject> subjectList) {
        if (subjectList.isEmpty()){
            System.out.println("과목 목록이 비어있습니다.");
            return;
        }

        System.out.println(type == SubjectType.MANDATORY ? "필수 과목 목록" : "선택 과목 목록");
        System.out.println("================");

        for (Subject subject : subjectList) {
            System.out.println(subject.getSubjectName());
            System.out.println("----------------");
        }
    }


}