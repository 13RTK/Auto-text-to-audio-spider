package org.alex.text2speech.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;

import java.util.Scanner;

@Log
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class InputValidator {
    public static final Scanner scanner = new Scanner(System.in);
//    private static final String OS_NAME = System.getProperty("os.name");

    private static int operateSkipValidate(String inputStr, int leftBoundary, int rightBoundary) {
        if (isNumber(inputStr)) {
            return -1;
        }

        int inputNumber = Integer.parseInt(inputStr);
        if ((inputNumber < leftBoundary || inputNumber > rightBoundary) && inputNumber != 7) {
            return 1;
        }

        return 0;
    }

    private static boolean isNumber(String inputStr) {
        for (char curChar : inputStr.toCharArray()) {
            if (!Character.isDigit(curChar)) {
                return true;
            }
        }

        return false;
    }

    public static int getValidateNumberFromInput(int leftBoundary, int rightBoundary, String repeatOptionStr) {
        String inputStr = scanner.nextLine();
        while (InputValidator.operateSkipValidate(inputStr, leftBoundary, rightBoundary) != 0) {
            System.out.println("输入有误，请输入对应的数字:\n" + repeatOptionStr);
            inputStr = scanner.nextLine();
        }

        return Integer.parseInt(inputStr);
    }
}
