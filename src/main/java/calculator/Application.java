package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        Delimiter delimiter = DelimiterExtractor.getDelimiter(input);
        System.out.println(delimiter);
        Integer result = 0;
        System.out.printf("결과: %s", result);
        // Parser -> 숫자들
        // Calculator -> 결과
        // 결과를 담아서 "결과 : "라고 입력하기
    }
}
