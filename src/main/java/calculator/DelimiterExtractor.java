package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DelimiterExtractor {
    private final String PATTERN = "//(.)\\\\n(.*)";
    private final Delimiter delimiter;
    private final String remaining;

    public DelimiterExtractor(String input) {
        this.delimiter = extractDelimiter(input);
        this.remaining = this.delimiter != null? input.substring(5) : input;
        // 5라는 숫자는 pattern에 영향 받는다 나중에 고쳐야 하나?
    }

    private Delimiter extractDelimiter(String input) {
        Matcher matcher = Pattern.compile(PATTERN).matcher(input);
        return matcher.find()? new Delimiter(matcher.group(1)) : null;
    }

    public Delimiter getDelimiter() {
        return delimiter;
    }

    public String getRemaining() {
        return remaining;
    }
}
