package impl;

import service.ICalc;

/**
 * @Author: shuyizhi
 * @Date: 2018-07-23 15:54
 * @Description:
 */
public class CalculatorImpl implements ICalc {
    public int add(int num1, int num2) {
        return num1 + num2;
    }

    public int sub(int num1, int num2) {
        return num1 - num2;
    }

    public int mul(int num1, int num2) {
        return num1 * num2;
    }

    public int div(int num1, int num2) {
        return num1 / num2;
    }
}
