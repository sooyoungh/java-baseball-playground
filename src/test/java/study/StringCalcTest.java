package study;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class StringCalcTest {

    private String input;

    @BeforeEach
    void setup() {
        input = "2 + 3 * 4 / 2";
    }

    @Test
    void calcTest () {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] values = line.split(" ");

        int tmp = Integer.parseInt(values[0]);
        for (int i = 1; i < values.length; i += 2) {
            String op = values[i];
            int num = Integer.parseInt(values[i+1]);

            if (op.equals("+")) {
                tmp += num;
                continue;
            }
            if (op.equals("-")) {
                tmp -= num;
                continue;
            }
            if (op.equals("*")) {
                tmp *= num;
                continue;
            }
            if (op.equals("/")) {
                tmp /= num;
            }
        }

        Assertions.assertEquals(tmp, 10);
    }
}
