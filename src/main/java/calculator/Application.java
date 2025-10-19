package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.NoSuchElementException;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String input = CalculatorView.readInput();
        DelimiterExtractor extractor = new DelimiterExtractor(input);
        NumberParser numberParser = new NumberParser(extractor.getRemaining(), extractor.getDelimiter());
        List<Short> numbers = numberParser.getNumbers();
        Adder adder = new Adder(numbers);
        Integer result = adder.getResult();
        CalculatorView.printResult(result);
    }
}
