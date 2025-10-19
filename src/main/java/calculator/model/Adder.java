package calculator.model;

import java.util.List;

public class Adder {
    private final Integer result;

    public Adder(Integer result) {
        this.result = result;
    }

    public static Adder from(List<Short> numbers) {
        Integer result = add(numbers);
        return new Adder(result);
    }

    private static Integer add(List<Short> numbers) {
        Integer result = 0;
        for (Short n : numbers) {
            result += n;
        }
        return result;
    }

    public Integer getResult() {
        return result;
    }
}
