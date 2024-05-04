package camp.model;

import camp.SubjectType;

/**
 * 과목 정보를 저장하고 관리하는 클래스
 */
public class Subject {

    // 과목 고유 ID
    private String subjectId;
    // 과목 이름
    private String subjectName;
    // 과목 타입 (필수/선택)
    private SubjectType subjectType;

    public Subject(String seq, String subjectName, String subjectType) {
        this.subjectId = seq;
        this.subjectName = subjectName;
        this.subjectType = SubjectType.fromString(subjectType);
    }

    // Getter
    public String getSubjectId() {
        return subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public String getSubjectType() {
        return subjectType.getTypeText();
    }

}
