package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class ComputerTest {

    private Computer computer;

    @BeforeEach
    void setUp() {
        computer = new Computer();
        computer.setRandom("123");
    }

    @DisplayName("볼과 스트라이크 갯수 세기")
    @ParameterizedTest
    @CsvSource(value = {"123:0:3", "456:0:0", "124:0:2", "321:2:1", "312:3:0"}, delimiter = ':')
    void test_judge (String input, int inputBall, int inputStrike) {
        computer.judge(input);
        int ballCnt = computer.getBall();
        int strikeCnt = computer.getStrike();

        Assertions.assertEquals(ballCnt, inputBall);
        Assertions.assertEquals(strikeCnt, inputStrike);
    }
}