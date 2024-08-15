package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editTextNumber1, editTextNumber2;
    TextView textViewResult;
    Button buttonAdd, buttonSubtract, buttonMultiply, buttonDivide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initializing the UI components
        editTextNumber1 = findViewById(R.id.editTextText);
        editTextNumber2 = findViewById(R.id.editTextText2);
        textViewResult = findViewById(R.id.textView5);
        buttonAdd = findViewById(R.id.button);
        buttonSubtract = findViewById(R.id.button2);
        buttonMultiply = findViewById(R.id.button3);
        buttonDivide = findViewById(R.id.button4);

        // Setting up onClickListeners for each button
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation('+');
            }
        });

        buttonSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation('-');
            }
        });

        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation('*');
            }
        });

        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation('/');
            }
        });
    }

    // Method to perform the operation based on the selected operator
    private void performOperation(char operator) {
        String num1Str = editTextNumber1.getText().toString();
        String num2Str = editTextNumber2.getText().toString();

        if (num1Str.isEmpty() || num2Str.isEmpty()) {
            textViewResult.setText("Please enter both numbers");
            return;
        }

        double num1 = Double.parseDouble(num1Str);
        double num2 = Double.parseDouble(num2Str);
        double result = 0;

        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    textViewResult.setText("Cannot divide by zero");
                    return;
                }
                break;
        }
        textViewResult.setText(String.valueOf(result));
    }
}
