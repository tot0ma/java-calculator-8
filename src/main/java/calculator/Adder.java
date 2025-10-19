package calculator;

import java.util.List;

public class Adder {
    private final Integer result;

    public Adder(List<Short> numbers) {
        this.result = add(numbers);
    }

    private Integer add(List<Short> numbers) {
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
