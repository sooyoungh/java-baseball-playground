package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void 요구사항1_split () {
        String actual1 = "1,2";
        String actual2 = "1";

        List<String> list1 = Arrays.asList(actual1.split(","));
        List<String> list2 = Arrays.asList(actual2.split(","));

        assertThat(list1).contains("1", "2");
        assertThat(list2).containsExactly("1");
    }

    @Test
    void 요구사항2_substring () {
        String actual = "(1,2)";
        String actualSubstring = actual.substring(1, actual.length() - 1);

        assertThat(actualSubstring).isEqualTo("1,2");
    }

    @Test
    @DisplayName("특정 위치의 문자를 가져오기")
    void 요구사항3_charAt () {
        String actual = "abc";

        assertThatThrownBy( () -> {
            char findChar = actual.charAt(actual.length());
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
