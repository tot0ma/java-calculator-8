package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void 기본_구분자_사용() {
        assertSimpleTest(() -> {
            run("1,2,3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1;2;3;10");
            assertThat(output()).contains("결과 : 16");
        });
    }

    @Test
    void 기본_커스텀_구분자_둘다_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1;2:3,4");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Test
    void 빈_문자열_사용() {
        assertSimpleTest(() -> {
            run("");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 예외_음수_입력() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_허용되지_않은_구분자_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\\n1[2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
