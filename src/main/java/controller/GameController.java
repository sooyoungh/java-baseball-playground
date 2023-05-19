package controller;

import domain.Computer;
import domain.Score;
import view.InputView;
import view.ResultView;

public class GameController {

    private static InputView inputView = new InputView();
    private static ResultView resultView = new ResultView();
    private static Computer computer = new Computer();

    private boolean gameContinue = true;

    // 게임 전체 동작 흐름
    public void start() {
        computer.createAnswer();

        while (gameContinue) {
            game();
        }
        gameRestart();
    }

    // 게임 진행
    private void game() {
        String userNumber = inputView.getUserNumber();
        computer.judge(userNumber);
        isAllStrike();
        getGameResult();
    }

    // 결과 출력
    private void getGameResult() {
        int strikeCnt = computer.getStrike();
        int ballCnt = computer.getBall();

        String result = Score.getResult(strikeCnt, ballCnt);
        resultView.printScore(result);
        computer.resetBallAndStrike();
    }

    // 올스트라이크 체크하기
    private void isAllStrike() {
        int strikeCnt = computer.getStrike();
        isGameFinish(strikeCnt);
    }

    // 게임 결과 맞췄는지 여부
    private void isGameFinish(int strikeCnt) {
        if (strikeCnt == 3) {
            gameContinue = false;
            resultView.printFinish();
        }
    }

    // 게임 계속 여부
    private boolean gameRestart() {
        String userNumber = inputView.getGameContinue();
        if (userNumber.equals("1")) {
            return true;
        }
        return false;
    }
}