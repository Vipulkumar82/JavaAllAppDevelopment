package com.example.chekboxapp;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    CheckBox pizza, coffee, burger;
    TextView txt;
    Button buttonOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListnerOnButtonClick();
    }

    public void addListnerOnButtonClick() {
        pizza =(CheckBox) findViewById(R.id.checkBox);
        coffee =(CheckBox) findViewById(R.id.checkBox2);
        burger =(CheckBox) findViewById(R.id.checkBox3);
        buttonOrder = (Button) findViewById(R.id.button);
        txt = (TextView) findViewById(R.id.textView2);
        buttonOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int totalamount = 0;
                StringBuilder result = new StringBuilder();
                result.append("Selected Items: ");
                if (pizza.isChecked()) {
                    result.append("\nPizza 100 Rs");
                    totalamount += 100;
                }
                if (coffee.isChecked()) {
                    result.append("\nCoffee 50Rs");
                    totalamount += 50;
                }
                if (burger.isChecked()) {
                    result.append("\nBurger 120Rs");
                    totalamount += 120;
                }

                // Append the total amount with a label
                result.append("\n\nTotal Amount: ").append(totalamount).append("Rs");

                txt.setText(result.toString());
            }
        });

    }

}
