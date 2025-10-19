package calculator.service;

import calculator.model.Adder;
import calculator.model.DelimiterExtractor;
import calculator.model.NumberParser;
import java.util.List;

public class CalculatorService {

    public CalculatorService() {
    }

    public Integer run(String input) {
        DelimiterExtractor extractor = DelimiterExtractor.from(input);
        NumberParser numberParser = NumberParser.from(
                extractor.getRemaining(), extractor.getDelimiter()
        );
        List<Short> numbers = numberParser.getNumbers();
        Adder adder = Adder.from(numbers);
        return adder.getResult();
    }
}
