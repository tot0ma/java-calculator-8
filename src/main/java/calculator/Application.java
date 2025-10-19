package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        DelimiterExtractor extractor = new DelimiterExtractor(input);
        NumberParser numberParser = new NumberParser(extractor.getRemaining(), extractor.getDelimiter());
        List<Short> numbers = numberParser.getNumbers();
        Adder adder = new Adder(numbers);
        Integer result = adder.getResult();
        System.out.printf("결과 : %s", result);
    }
}
