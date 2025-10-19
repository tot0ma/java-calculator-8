package calculator.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;

public class CalculatorView {
    private String input;
    private Integer result;

    public void readInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        try {
            this.input = Console.readLine();
        } catch (NoSuchElementException e) {
            this.input = "";
        }
    }

    public void printResult() {
        System.out.printf("결과 : %s", result);
    }

    public String getInput() {
        return this.input;
    }

    public void setResult(Integer result) {
        this.result = result;
    }
}
