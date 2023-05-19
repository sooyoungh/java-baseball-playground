package domain;

import java.util.function.Function;

public enum Score {

    STRIKE(i -> i + "스트라이크"),
    BALL(i -> i +"볼"),
    NOTHING(i -> "낫싱");

    private Function<Integer, String> expression;

    Score(Function<Integer, String> expression) {
        this.expression = expression;
    }

    public String printExpression(int count) {
        return expression.apply(count);
    }

    // 스트라이크 갯수에 따라서 결과문 출력
    public static String getResult(int strikeCnt, int ballCnt) {

        if (strikeCnt == 0 && ballCnt == 0) {
            return Score.NOTHING.printExpression(0);
        }
        if (strikeCnt != 0 && ballCnt == 0) {
            return Score.STRIKE.printExpression(strikeCnt);
        }
        if (strikeCnt == 0) {
            return Score.BALL.printExpression(ballCnt);
        }

        return Score.BALL.printExpression(ballCnt) + " " + Score.STRIKE.printExpression(strikeCnt);
    }
}