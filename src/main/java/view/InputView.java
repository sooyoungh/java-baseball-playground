package view;

import java.util.Scanner;

public class InputView {

    // 유저 정보 입력받기
    public String getUserNumber() {
        System.out.print("숫자를 입력해 주세요 : ");
        Scanner sc = new Scanner(System.in);
        String userNumber = sc.nextLine();
        return userNumber;
    }

    // 게임 계속할지 여부 입력받기
    public String getGameContinue() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        Scanner sc = new Scanner(System.in);
        String gameContinue = sc.nextLine();
        return gameContinue;
    }
}