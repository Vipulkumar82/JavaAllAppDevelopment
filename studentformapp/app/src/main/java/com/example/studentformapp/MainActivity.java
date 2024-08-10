package com.example.studentformapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Declare UI elements
     EditText editTextName, editTextRollNo;
     RadioGroup radioGroupCourse;
     CheckBox checkBoxC, checkBoxJava, checkBoxKotlin;
     Button buttonSubmit;
     TextView textViewInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI elements
        editTextName = findViewById(R.id.editTextText);
        editTextRollNo = findViewById(R.id.editTextText2);

        radioGroupCourse = findViewById(R.id.radioGroup);

        checkBoxC = findViewById(R.id.checkBox);
        checkBoxJava = findViewById(R.id.checkBox2);
        checkBoxKotlin = findViewById(R.id.checkBox3);

        buttonSubmit = findViewById(R.id.button);
        textViewInfo = findViewById(R.id.textView4);

        // Set onClickListener for the submit button
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Collect data from UI elements
                String name = editTextName.getText().toString().trim();
                String rollNo = editTextRollNo.getText().toString().trim();

                // Get selected course
                int selectedCourseId = radioGroupCourse.getCheckedRadioButtonId();
                String course = "";
                if (selectedCourseId == R.id.radioButton) {
                    course = "MCA";
                } else if (selectedCourseId == R.id.radioButton2) {
                    course = "BCA";
                } else if (selectedCourseId == R.id.radioButton3) {
                    course = "BTech";
                }

                // Get selected subjects
                StringBuilder subjects = new StringBuilder();
                if (checkBoxC.isChecked()) {
                    subjects.append("C ");
                }
                if (checkBoxJava.isChecked()) {
                    subjects.append("Java ");
                }
                if (checkBoxKotlin.isChecked()) {
                    subjects.append("Kotlin ");
                }

                // Check for any missing fields
                if (name.isEmpty() || rollNo.isEmpty() || course.isEmpty() || subjects.toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Display the information in the TextView
                String info = "Name: " + name +
                        "\nRoll No: " + rollNo +
                        "\nCourse: " + course +
                        "\nSubjects: " + subjects.toString();

                textViewInfo.setText(info);
            }
        });
    }
}
