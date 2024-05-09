package camp.presenter;

import camp.SubjectType;
import camp.model.Subject;
import camp.view.SubjectView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 과목 관리 기능을 담당하는 Presenter 클래스
 */
public class SubjectPresenter {


    private SubjectView subjectView;
    private List<Subject> subjectList;

    /**
     * SubjectPresenter 생성자
     *
     * @param subjectView 과목 관리 화면을 나타내는 View 인터페이스
     */
    public SubjectPresenter(SubjectView subjectView) {
        this.subjectView = subjectView;
        this.subjectList = new ArrayList<>();

        this.subjectList.add(new Subject(generateSubjectId(), "Java", SubjectType.MANDATORY.getTypeText()));
        this.subjectList.add(new Subject(generateSubjectId(), "객체지향", SubjectType.MANDATORY.getTypeText()));
        this.subjectList.add(new Subject(generateSubjectId(), "Spring", SubjectType.MANDATORY.getTypeText()));
        this.subjectList.add(new Subject(generateSubjectId(), "JPA", SubjectType.MANDATORY.getTypeText()));
        this.subjectList.add(new Subject(generateSubjectId(), "MySQL", SubjectType.MANDATORY.getTypeText()));
        this.subjectList.add(new Subject(generateSubjectId(), "디자인 패턴", SubjectType.CHOICE.getTypeText()));
        this.subjectList.add(new Subject(generateSubjectId(), "Spring Security", SubjectType.CHOICE.getTypeText()));
        this.subjectList.add(new Subject(generateSubjectId(), "Redis", SubjectType.CHOICE.getTypeText()));
        this.subjectList.add(new Subject(generateSubjectId(), "MongoDB", SubjectType.CHOICE.getTypeText()));
    }

    public Subject findSubjectByName(String name){
        return subjectList.stream()
                .filter(subject -> subject.getSubjectName().equals(name))
                .findFirst()
                .orElse(null);
    }


    // 기능 구현 (필수 과목 3개 이상, 선택 과목 2개 이상 선택하는 것 만들기)

    public List<Subject> selectSubjects(SubjectType type, int minCount) {
        List<Subject> subjects = subjectList.stream()
                .filter(subject -> subject.getSubjectType() == type)
                .toList();

        subjectView.displaySubjectList(type, subjects);

        List<Subject> selectedSubjects = new ArrayList<>();
        while (selectedSubjects.size() < minCount) {
            String subjectName = subjectView.getSubjectName();
            Subject subject = findSubjectByName(subjectName);
            if (subject != null && subject.getSubjectType() == type && !selectedSubjects.contains(subject)) {
                selectedSubjects.add(subject);
            } else {
                System.out.println("유효하지 않은 과목 선택입니다. 다시 선택해주세요.");
            }
        }
        return selectedSubjects;
    }

    private String generateSubjectId(){
        return "SJ" + (subjectList.size()+1);
    }

}