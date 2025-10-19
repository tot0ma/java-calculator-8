package calculator;

import java.util.ArrayList;
import java.util.List;

public class NumberParser {
    private final List<Delimiter> defaultDelimiters = List.of(new Delimiter(","), new Delimiter(":"));
    private final ArrayList<Short> numbers;

    public NumberParser(String target, Delimiter customDelimiter) {
        String regex = makeRegexFromDelimiter(customDelimiter);
        this.numbers = parse(target, regex);
    }

    private ArrayList<Short> parse(String target, String regex) {
        ArrayList<Short> result = new ArrayList<>();
        for (String s: target.split(regex)) {
            result.add(Short.valueOf(s));
        }
        return result;
    };

    private String makeRegexFromDelimiter(Delimiter customDelimiter) {
        StringBuilder result = new StringBuilder();
        result.append("[");
        for (Delimiter delimiter: defaultDelimiters) {
            result.append(delimiter);
        }
        result.append(customDelimiter);
        result.append("]");
        return result.toString();
    }

    public ArrayList<Short> getNumbers() {
        return numbers;
    }
}
