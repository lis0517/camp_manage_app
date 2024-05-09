package camp;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UtilHelper {
    public static int getIntInput(Scanner scanner){
        while(true){
            try {
                return scanner.nextInt();
            }catch (InputMismatchException e){
                System.out.println("잘못된 입력입니다. 정수 값을 입력해주세요.");
                scanner.nextLine(); // 입력 버퍼 비우기
            }
        }
    }
}
