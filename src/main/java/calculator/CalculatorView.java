package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;

public class CalculatorView {
    public static String readInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input;
        try {
            input = Console.readLine();
        } catch (NoSuchElementException e) {
            input = "";
        }
        return input;
    }

    public static void printResult(Integer result) {
        System.out.printf("결과 : %s", result);
    }
}
