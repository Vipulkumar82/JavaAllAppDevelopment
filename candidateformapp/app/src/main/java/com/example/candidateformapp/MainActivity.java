package com.example.candidateformapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ToggleButton;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editTextName, editTextAge, editTextAddress;
    ToggleButton toggleButtonCategory;
    CheckBox checkBoxJava, checkBoxCpp, checkBoxC;
    RadioGroup radioGroupGender;
    TextView textViewDetails;
    Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Ensure the correct layout file name

        // Initialize the views
        editTextName = findViewById(R.id.editTextText);
        editTextAge = findViewById(R.id.editTextText2);
        editTextAddress = findViewById(R.id.editTextText3);
        toggleButtonCategory = findViewById(R.id.toggleButton);
        checkBoxJava = findViewById(R.id.checkBox);
        checkBoxCpp = findViewById(R.id.checkBox2);
        checkBoxC = findViewById(R.id.checkBox3);
        radioGroupGender = findViewById(R.id.radioGroup);
        textViewDetails = findViewById(R.id.textView2);
        buttonSubmit = findViewById(R.id.button);

        // Set up the submit button click listener
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get input values
                String name = editTextName.getText().toString();
                String age = editTextAge.getText().toString();
                String address = editTextAddress.getText().toString();
                String category = toggleButtonCategory.isChecked() ? "Non-General" : "General";

                StringBuilder skills = new StringBuilder();
                if (checkBoxJava.isChecked()) {
                    skills.append("Java ");
                }
                if (checkBoxCpp.isChecked()) {
                    skills.append("C++ ");
                }
                if (checkBoxC.isChecked()) {
                    skills.append("C ");
                }

                int selectedGenderId = radioGroupGender.getCheckedRadioButtonId();
                RadioButton selectedGenderButton = findViewById(selectedGenderId);
                String gender = selectedGenderButton != null ? selectedGenderButton.getText().toString() : "Not selected";

                // Create the candidate details string
                String details = "Name: " + name + "\n"
                        + "Age: " + age + "\n"
                        + "Address: " + address + "\n"
                        + "Category: " + category + "\n"
                        + "Skills: " + skills.toString() + "\n"
                        + "Gender: " + gender;

                // Display the details
                textViewDetails.setText(details);
            }
        });
    }
}
