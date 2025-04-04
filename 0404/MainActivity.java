package com.example.a0404;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView resultTextView;
    private String currentInput = "";
    private String operator = "";
    private double firstOperand = 0.0;
    private boolean resetInput = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultTextView = findViewById(R.id.textView_result);
    }

    public void onNumberClick(View view) {
        Button button = (Button) view;
        String value = button.getText().toString();

        if (resetInput) {
            currentInput = "";
            resetInput = false;
        }

        currentInput += value;
        resultTextView.setText(currentInput);
    }

    public void onOperatorClick(View view) {
        Button button = (Button) view;
        operator = button.getText().toString();
        try {
            firstOperand = Double.parseDouble(currentInput);
        } catch (NumberFormatException e) {
            firstOperand = 0;
        }
        currentInput = "";
    }

    public void onEqualClick(View view) {
        try {
            double secondOperand = Double.parseDouble(currentInput);
            double result = 0;

            switch (operator) {
                case "+":
                    result = firstOperand + secondOperand;
                    break;
                case "-":
                    result = firstOperand - secondOperand;
                    break;
                case "*":
                    result = firstOperand * secondOperand;
                    break;
                case "/":
                    if (secondOperand != 0) {
                        result = firstOperand / secondOperand;
                    } else {
                        resultTextView.setText("Error");
                        return;
                    }
                    break;
            }

            resultTextView.setText(String.valueOf(result));
            currentInput = String.valueOf(result);
            resetInput = true;

        } catch (NumberFormatException e) {
            resultTextView.setText("Error");
        }
    }

    public void onClearClick(View view) {
        currentInput = "";
        operator = "";
        firstOperand = 0.0;
        resultTextView.setText("0");
    }
}
