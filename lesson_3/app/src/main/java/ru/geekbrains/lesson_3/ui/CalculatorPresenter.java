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
    private boolean pointPress;
    private int cntAfterPoint;

    private  Operator selectedOperator;

    public CalculatorPresenter (CalculatorView view, Calculator calculator) {
        this.view = view;
        this.calculator = calculator;
    }


    public void onDigitPressed(int digit) {
        if(pointPress) cntAfterPoint++;

        if (argTwo == null) {
            if(pointPress){
                argOne = argOne  + digit * Math.pow(10, -cntAfterPoint);
                view.showResult(String.valueOf(argOne));
            } else {
                argOne = argOne * 10 + digit;
                showFormatted(argOne);
            }

        } else {
            if(pointPress){
                argTwo = argTwo  + digit* Math.pow(10, -cntAfterPoint);
                view.showResult(String.valueOf(argTwo));
            } else {
                argTwo = argTwo * 10 + digit;
                showFormatted(argTwo);
            }


        }
    }


    public void onOperatorPressed(Operator operator) {
        if(selectedOperator != null){
            if( !argTwo.equals(0.0)){

                argOne = calculator.perform(argOne, argTwo, selectedOperator);
            }

                view.showResult(String.valueOf(argOne));

        }
            argTwo = 0.0;
            pointPress = false;
            cntAfterPoint = 0;

        selectedOperator = operator;
    }

    public void onPointPressed() {
        pointPress = true;
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
