package com.example.studentapp;

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

    EditText editTextName, editTextRollNo, editTextAge, editTextAddress, editTextMobile;
    RadioGroup radioGroupCourse;
    RadioButton radioMCA, radioBCA, radioBTech, radioMTech;
    CheckBox checkBoxMaths, checkBoxPhysics, checkBoxChemistry, checkBoxComputerScience;
    Button buttonSubmit;
    TextView textViewInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        editTextName = findViewById(R.id.editTextName);
        editTextRollNo = findViewById(R.id.editTextRollNo);
        editTextAge = findViewById(R.id.editTextAge);
        editTextAddress = findViewById(R.id.editTextAddress);
        editTextMobile = findViewById(R.id.editTextMobile);

        radioGroupCourse = findViewById(R.id.radioGroupCourse); // Initialize RadioGroup
        radioMCA = findViewById(R.id.radioMCA);
        radioBCA = findViewById(R.id.radioBCA);
        radioBTech = findViewById(R.id.radioBTech);
        radioMTech = findViewById(R.id.radioMTech);

        checkBoxMaths = findViewById(R.id.checkBoxMaths);
        checkBoxPhysics = findViewById(R.id.checkBoxPhysics);
        checkBoxChemistry = findViewById(R.id.checkBoxChemistry);
        checkBoxComputerScience = findViewById(R.id.checkBoxComputerScience);

        buttonSubmit = findViewById(R.id.buttonSubmit);
        textViewInfo = findViewById(R.id.textView3);

        // Set onClickListener for the submit button
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Collect data from views
                String name = editTextName.getText().toString();
                String rollNo = editTextRollNo.getText().toString();
                String age = editTextAge.getText().toString();
                String address = editTextAddress.getText().toString();
                String mobile = editTextMobile.getText().toString();

                // Get selected course
                int selectedCourseId = radioGroupCourse.getCheckedRadioButtonId();
                String course = "";
                if (selectedCourseId == R.id.radioMCA) {
                    course = "MCA";
                } else if (selectedCourseId == R.id.radioBCA) {
                    course = "BCA";
                } else if (selectedCourseId == R.id.radioBTech) {
                    course = "BTech";
                } else if (selectedCourseId == R.id.radioMTech) {
                    course = "MTech";
                }

                // Get selected subjects
                StringBuilder subjects = new StringBuilder();
                if (checkBoxMaths.isChecked()) {
                    subjects.append("C ");
                }
                if (checkBoxPhysics.isChecked()) {
                    subjects.append("C++ ");
                }
                if (checkBoxChemistry.isChecked()) {
                    subjects.append("Java ");
                }
                if (checkBoxComputerScience.isChecked()) {
                    subjects.append("Kotlin ");
                }

                // Check for any missing fields
                if (name.isEmpty() || rollNo.isEmpty() || age.isEmpty() || address.isEmpty() || mobile.isEmpty() || course.isEmpty() || subjects.toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Display the information in the TextView
                String info = "Name: " + name +
                        "\nRoll No: " + rollNo +
                        "\nAge: " + age +
                        "\nCourse: " + course +
                        "\nSubjects: " + subjects.toString() +
                        "\nAddress: " + address +
                        "\nMobile: " + mobile;

                textViewInfo.setText(info);
            }
        });
    }
}
