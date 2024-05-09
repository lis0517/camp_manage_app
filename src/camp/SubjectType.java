package camp;

/**
 * 과목 타입을 나타내는 enum
 */
public enum SubjectType {
    MANDATORY("Mandatory"), // 필수 과목
    CHOICE("Choice"); // 선택 과목

    /*과목 타입의 문자열 표현*/
    private final String type;

    /**
     * @param type 과목 타입의 문자열 표현
     */
    SubjectType(String type){
        this.type = type;
    }

    /**
     * 과목 타입의 문자열 표현을 반환하는 메서드
     *
     * @return 과목 타입의 문자열 표현
     */
    public String getTypeText() {
        return type;
    }

    /**
     * 문자열로부터 해당하는 SubjectType 상수를 찾아 반환하는 메서드
     *
     * @param type 찾고자 하는 과목 타입의 문자열
     * @return 문자열에 해당하는 SubjectType 상수
     * @throws IllegalArgumentException 해당하는 과목 타입이 없는 경우
     */
    public static SubjectType fromString(String type){
        for( SubjectType subjectType : SubjectType.values()){
            if (subjectType.type.equalsIgnoreCase(type)){
                return subjectType;
            }
        }
        throw new IllegalArgumentException("Invalid subject type: " + type);
    }
}
