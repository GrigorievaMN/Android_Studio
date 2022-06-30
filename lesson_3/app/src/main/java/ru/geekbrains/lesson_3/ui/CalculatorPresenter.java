package ru.geekbrains.lesson_3.ui;

import java.text.DecimalFormat;

import ru.geekbrains.lesson_3.model.Calculator;
import ru.geekbrains.lesson_3.model.Operator;

public class CalculatorPresenter {

    private final DecimalFormat formater = new DecimalFormat("#.##");

    private CalculatorView view;
    private Calculator calculator;

    private double argOne;

    private Double argTwo;

    private  Operator selectedOperator;

    public CalculatorPresenter (CalculatorView view, Calculator calculator) {
        this.view = view;
        this.calculator = calculator;
    }


    public void onDigitPressed(int digit) {

        if (argTwo == null) {

            argOne = argOne * 10 + digit;

            showFormatted(argOne);
        } else {
            argTwo = argTwo * 10 + digit;

            showFormatted(argTwo);

        }
    }


    public void onOperatorPressed(Operator operator) {
        if(selectedOperator != null) {
            argOne = calculator.perform(argOne, argTwo, selectedOperator);
            view.showResult(String.valueOf(argOne));
        }
            argTwo = 0.0;

        selectedOperator = operator;
    }

    public void onPointPressed() {
    }

    private void showFormatted(double value) {
        view.showResult(formater.format(value));
    }

    public void onEquallyPressed() {
        if(selectedOperator != null) {
            argOne = calculator.perform(argOne, argTwo, selectedOperator);
            view.showResult(String.valueOf(argOne));
        }
        argTwo = 0.0;

    }
}
