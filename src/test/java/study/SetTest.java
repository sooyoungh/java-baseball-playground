package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class SetTest {

    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    void 요구사항1_size () {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("ValueSource를 활용하여 각 숫자가 존재하는 지 결과 반환")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void 요구사항2_contains(int num) {
        assertThat(numbers.contains(num)).isTrue();
    }

    @DisplayName("CsvSource를 활용하여 각 숫자별 boolean 결과 반환")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void 요구사항3_contains(int num, boolean result) {
        assertThat(numbers.contains(num)).isEqualTo(result);
    }
}
