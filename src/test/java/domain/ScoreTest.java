package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ScoreTest {

    private Score score;

    @DisplayName("볼, 스트라이크 갯수에 따른 문자열 반환")
    @ParameterizedTest
    @CsvSource(value = {"3:0:3스트라이크", "0:0:낫싱", "2:0:2스트라이크", "1:2:2볼 1스트라이크", "0:3:3볼"}, delimiter = ':')
    void test_getResult(int strikeCnt, int ballCnt, String resultInput) {

        String result = Score.getResult(strikeCnt, ballCnt);

        Assertions.assertEquals(result, resultInput);
    }
}