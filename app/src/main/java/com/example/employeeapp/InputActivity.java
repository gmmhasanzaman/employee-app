package com.example.employeeapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class InputActivity extends AppCompatActivity {

    private Button nextButton;
    EditText etEmpName, etEmpID, etEmpSalary;
    RadioButton radioButton;
    RadioGroup radioGroup;
    int selectedId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        etEmpName = findViewById(R.id.etEmpNameId);
        etEmpID = findViewById(R.id.etEmpID);
        etEmpSalary = findViewById(R.id.etEmpSalaryId);

        radioGroup = findViewById(R.id.radioGroupID);


        nextButton = findViewById(R.id.nextButtonId);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isValid(radioGroup,etEmpName,etEmpID,etEmpSalary)){
                    radioButton = (RadioButton) findViewById(selectedId);
                    String empType = radioButton.getText().toString();
                    startActivity(new Intent(getApplicationContext(),ExtraActivity.class));

                }

            }
        });

    }

    private boolean isValid(RadioGroup radioGroup, EditText... editTexts){
        boolean b = true;
        for (EditText editText: editTexts){
            String value = editText.getText().toString();
            if (value.isEmpty()){
                b = false;
                editText.setError("Please fill it");
            }
        }
        selectedId = radioGroup.getCheckedRadioButtonId();
        if (selectedId == -1){
            b = false;
            Toast.makeText(this, "Choose employee type.", Toast.LENGTH_SHORT).show();
        }

        return b;
    }
}
