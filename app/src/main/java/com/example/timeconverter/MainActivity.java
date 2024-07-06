package com.example.timeconverter;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText inputNumber;
    RadioGroup timeUnitRadioGroup;
    Button convertButton;
    TextView result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        inputNumber = findViewById(R.id.input_number);
        timeUnitRadioGroup = findViewById(R.id.time_unit_radio_group);
        convertButton = findViewById(R.id.convert_button);
        result = findViewById(R.id.result_textview);


        convertButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                convertTime();
            }
        });
    }

    private void convertTime() {
        if (inputNumber.getText().toString().isEmpty()) {
            Toast.makeText(this, "Please enter a number", Toast.LENGTH_SHORT).show();
            return;
        }
        double inputValue = Integer.parseInt(inputNumber.getText().toString());

        double checkedRadioButtonId = timeUnitRadioGroup.getCheckedRadioButtonId();
        RadioButton selectedRadioButton = findViewById((int) checkedRadioButtonId);

        String selectedUnit = selectedRadioButton.getText().toString();
        double hours=0,minutes = 0, seconds = 0;

        switch (selectedUnit) {
            case "Hours":
                result.setText("Minutes:"+(inputValue * 60)+"\nsecounds:"+(inputValue * 3600));
                break;
            case "Minutes":
                result.setText("Hours:"+(inputValue / 60)+"\nsecounds:"+(inputValue * 3600));
                break;
            case "Seconds":
                result.setText("Hours:"+(inputValue /3600)+"\nMinutes:"+(inputValue / 60));
                break;
        }

    }
}