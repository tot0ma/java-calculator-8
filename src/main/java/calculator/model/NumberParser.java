package calculator.model;

import java.util.ArrayList;
import java.util.List;

public class NumberParser {
    private final static List<Delimiter> defaultDelimiters = List.of(new Delimiter(","), new Delimiter(":"));
    private final ArrayList<Short> numbers;

    public NumberParser(ArrayList<Short> numbers) {
        this.numbers = numbers;
    }

    public static NumberParser from(String target, Delimiter customDelimiter) {
        String regex = makeRegexFromDelimiter(customDelimiter);
        ArrayList<Short> numbers = parse(target, regex);
        return new NumberParser(numbers);
    }


    private static ArrayList<Short> parse(String target, String regex) {
        ArrayList<Short> result = new ArrayList<>();
        for (String s: target.split(regex)) {
            if (s.isEmpty()) continue;
            if (!s.matches("\\d+")) {
                throw new IllegalArgumentException(
                        String.format("잘못된 입력입니다. 허용된 구분자는 %s입니다.", regex.substring(1, regex.length()-1))
                );
            }
            result.add(Short.valueOf(s));
        }
        return result;
    };

    private static String makeRegexFromDelimiter(Delimiter customDelimiter) {
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
