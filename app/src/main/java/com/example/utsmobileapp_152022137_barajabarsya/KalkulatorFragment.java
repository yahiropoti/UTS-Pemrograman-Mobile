package com.example.utsmobileapp_152022137_barajabarsya;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

public class KalkulatorFragment extends Fragment {

    private TextView display;
    private String currentNumber = "";
    private String currentOperator = "";
    private double firstNumber = 0;
    private boolean isNewCalculation = true;
    private boolean hasDecimal = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_kalkulator, container, false);

        display = view.findViewById(R.id.display);
        setupNumberButtons(view);
        setupOperatorButtons(view);
        setupFunctionButtons(view);

        return view;
    }

    private void setupNumberButtons(View view) {
        int[] numberButtonIds = {
                R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4,
                R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9
        };

        for (int id : numberButtonIds) {
            Button button = view.findViewById(id);
            button.setOnClickListener(v -> {
                Button btn = (Button) v;
                String number = btn.getText().toString();

                if (isNewCalculation) {
                    currentNumber = number;
                    isNewCalculation = false;
                } else {
                    currentNumber += number;
                }
                display.setText(currentNumber);
            });
        }

        // Decimal button
        Button btnDecimal = view.findViewById(R.id.btnDecimal);
        btnDecimal.setOnClickListener(v -> {
            if (!hasDecimal) {
                if (currentNumber.isEmpty() || isNewCalculation) {
                    currentNumber = "0.";
                    isNewCalculation = false;
                } else {
                    currentNumber += ".";
                }
                display.setText(currentNumber);
                hasDecimal = true;
            }
        });
    }

    private void setupOperatorButtons(View view) {
        int[] operatorButtonIds = {
                R.id.btnAdd, R.id.btnSubtract, R.id.btnMultiply, R.id.btnDivide
        };

        for (int id : operatorButtonIds) {
            Button button = view.findViewById(id);
            button.setOnClickListener(v -> {
                Button btn = (Button) v;
                if (!currentNumber.isEmpty()) {
                    firstNumber = Double.parseDouble(currentNumber);
                    currentOperator = btn.getText().toString();
                    currentNumber = "";
                    hasDecimal = false;
                    isNewCalculation = false;
                }
            });
        }
    }

    private void setupFunctionButtons(View view) {
        // Clear button
        Button btnClear = view.findViewById(R.id.btnClear);
        btnClear.setOnClickListener(v -> {
            currentNumber = "";
            currentOperator = "";
            firstNumber = 0;
            hasDecimal = false;
            display.setText("0");
            isNewCalculation = true;
        });

        // Equals button
        Button btnEquals = view.findViewById(R.id.btnEquals);
        btnEquals.setOnClickListener(v -> {
            if (!currentNumber.isEmpty() && !currentOperator.isEmpty()) {
                double secondNumber = Double.parseDouble(currentNumber);
                double result = calculate(firstNumber, secondNumber, currentOperator);

                displayResult(result);

                currentNumber = String.valueOf(result);
                currentOperator = "";
                hasDecimal = currentNumber.contains(".");
                isNewCalculation = true;
            }
        });

        // Square button
        Button btnSquare = view.findViewById(R.id.btnSquare);
        btnSquare.setOnClickListener(v -> {
            if (!currentNumber.isEmpty()) {
                double number = Double.parseDouble(currentNumber);
                double result = number * number;
                displayResult(result);
                currentNumber = String.valueOf(result);
                hasDecimal = currentNumber.contains(".");
                isNewCalculation = true;
            }
        });

        // Square root button
        Button btnSqrt = view.findViewById(R.id.btnSqrt);
        btnSqrt.setOnClickListener(v -> {
            if (!currentNumber.isEmpty()) {
                double number = Double.parseDouble(currentNumber);
                if (number >= 0) {
                    double result = Math.sqrt(number);
                    displayResult(result);
                    currentNumber = String.valueOf(result);
                    hasDecimal = currentNumber.contains(".");
                    isNewCalculation = true;
                } else {
                    display.setText("Error");
                    currentNumber = "";
                }
            }
        });
    }

    private double calculate(double first, double second, String operator) {
        switch (operator) {
            case "+": return first + second;
            case "−": return first - second;  // Support for "−" character
            case "×": return first * second;
            case "÷":
                if (second != 0) return first / second;
                else {
                    display.setText("Error");
                    return 0;
                }
            default: return second;
        }
    }

    private void displayResult(double result) {
        if (result == (long) result) {
            display.setText(String.valueOf((long) result));
        } else {
            String resultStr = String.valueOf(result);
            if (resultStr.length() > 10) {
                resultStr = String.format("%.6f", result);
            }
            display.setText(resultStr);
        }
    }
}