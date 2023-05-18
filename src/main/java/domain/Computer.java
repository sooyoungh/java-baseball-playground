package domain;

import java.util.Arrays;
import java.util.Random;

public class Computer {

    static String answer = null;
    int strike = 0;
    int ball = 0;

    // 랜덤 숫자 생성
    public void createAnswer() {
        Random random = new Random();
        int[] randomNumber = new int[3];

        for (int i = 0; i < 3; i++) {
            int now = random.nextInt(8) + 1;
            randomNumber[i] = now;
        }
        answer = Arrays.toString(randomNumber);
        answer = answer.substring(1, answer.length()-1);
        answer = answer.replace(", ", "");
    }

    // 볼, 스트라이크 갯수 세기
    public void judge(String input) {
        for (int i = 0; i < 3; i++) {
            String nowUser = input.substring(i, i+1);
            String nowAns = answer.substring(i, i+1);
            boolean isStrike = countStrike(nowUser, nowAns);
            if (!isStrike) {
                countBall(nowUser, nowAns);
            }
        }
    }

    private boolean countStrike(String nowUser, String nowAns) {
        if (nowUser.equals(nowAns)) {
            strike++;
            return true;
        }
        return false;
    }

    private void countBall(String nowUser, String nowAns) {
        if (!nowUser.equals(nowAns) && answer.contains(nowUser)) {
            ball++;
        }
    }

    public void resetBallAndStrike() {
        strike = 0;
        ball = 0;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    // 테스트용 랜덤숫자 -> ?
    public void setRandom(String input) {
        answer = input;
    }
}