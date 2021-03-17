package com.example.practice2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class ThirdActivity extends AppCompatActivity {

    EditText days;
    Spinner locations;
    RadioButton rad1,rad2;
    Button calculate;
    ImageView img;
    TextView display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        days = findViewById(R.id.editTextDays);
        locations = findViewById(R.id.spinnerLoc);
        rad1 = findViewById(R.id.radioButtonPowerWash);
        rad2= findViewById(R.id.radioButtonTiller);
        calculate = findViewById(R.id.buttonCal);
        img = findViewById(R.id.imageViewTool);
        display = findViewById(R.id.textViewDisplay);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int day = Integer.parseInt(days.getText().toString());
                double price =0;

                if(locations.getSelectedItemPosition()==0){

                   img.setImageResource(R.drawable.bagpipes);
                }
                else if(locations.getSelectedItemPosition()==1){

                    img.setImageResource(R.drawable.drums);
                    }
                else if(locations.getSelectedItemPosition()==2){
                img.setImageResource(R.drawable.ukulele);

                }
                if(day<=7){
                    if(rad1.isChecked()){
                        price =55.99;
                    }
                    else {
                        price = 68.99;
                    }
                    double total = day * price;

                    Toast.makeText(ThirdActivity.this, "Machine cost is" + String.valueOf(total) , Toast.LENGTH_SHORT).show();
                    display.setText(String.format("%.2f",total));
                }
                else
                {
                    Toast.makeText(ThirdActivity.this, "Enter days 7 or less" , Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}