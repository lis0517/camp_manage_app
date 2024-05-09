package camp;

/*
* 수강생의 상태를 나타내는 enum
* */
public enum StudentStatus {
    GREEN("Green"), // 좋음
    RED("Red"), // 나쁨
    YELLOW("Yellow"); // 보통

    /*수강생의 상태를 문자로 표현*/
    private final String status;

    /**
     * @param status 학생의 상태를 나타내는 문자열
     */
    StudentStatus(String status){
        this.status = status;
    }

    /**
     * 학생의 상태를 문자열 반환하는 메서드
     * @return 학생의 상태를 나타내는 문자열
     * */
    public String getStatusText(){
        return status;
    }

    /**
     * 문자열로부터 해당하는 SubjectType 상수를 찾아 반환하는 메서드
     *
     * @param status 찾고자 하는 학생의 상태 문자열
     * @return 문자열에 해당하는 StudentStatus 상수
     * @throws IllegalArgumentException 해당하는 학생 상태가 없는 경우
     */
    public static StudentStatus fromString(String status){
        for(StudentStatus studentStatus : StudentStatus.values()){
            if (studentStatus.status.equalsIgnoreCase(status)){
                return studentStatus;
            }
        }
        throw new IllegalArgumentException("Invalid status: " + status);
    }
}

