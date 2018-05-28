package ydsun.servingsizecalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Calculations extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculations_of_servings);

        final int[] weight_of_food = {0};

        Intent intent = getIntent();

        // Load the clicked pot's info
        String pot_name = intent.getStringExtra("Selected Name");
        final int pot_weight = intent.getIntExtra("Selected Weight", 0);
        String pot_weight_as_string = "" + pot_weight;

        setupBACKButton();

        // Showing info on activity
        TextView display_name = (TextView) findViewById(R.id.display_pot_name);
        display_name.setText(pot_name);

        TextView display_raw_weight = (TextView) findViewById(R.id.display_pot_weight);
        display_raw_weight.setText(pot_weight_as_string);

        final EditText entered_Weight = (EditText) findViewById(R.id.enterend_W_with_food);

        // TextWatcher for the Total Weight
        entered_Weight.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String entered_weight_as_string = entered_Weight.getText().toString();

                if(entered_weight_as_string.length() == 0){
                    Toast.makeText(getApplicationContext(), "Please Enter A Valid Weight!", Toast.LENGTH_SHORT).show();
                }
                else if(Integer.parseInt(entered_weight_as_string) < pot_weight){
                    Toast.makeText(getApplicationContext(), "Weight of Pot and Food Cannot be less than Weight of Pot!", Toast.LENGTH_LONG).show();
                }
                else if(Integer.parseInt(entered_weight_as_string) == pot_weight){
                    Toast.makeText(getApplicationContext(), "Doesn't Like Food huh?", Toast.LENGTH_LONG).show();
                }
                else{
                    int entered_weight_as_int = Integer.parseInt(entered_weight_as_string);
                    weight_of_food[0] = entered_weight_as_int - pot_weight;
                    String food_weight_as_string = "" + weight_of_food[0];
                    TextView display_food_weight = (TextView) findViewById(R.id.Calculated_Food_Weight);
                    display_food_weight.setText(food_weight_as_string);
                }
            }
        });

        final EditText entered_serving = (EditText) findViewById(R.id.entered_Serving_number);

        // TextWatcher for Serving
        entered_serving.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String entered_serving_as_string = entered_serving.getText().toString();

                if(entered_serving_as_string.length() == 0){
                    Toast.makeText(getApplicationContext(), "Please Enter A Valid Number!", Toast.LENGTH_SHORT).show();
                }
                else if(Integer.parseInt(entered_serving_as_string) == 0){
                    TextView display_serving_number = (TextView) findViewById(R.id.Calculated_Serving_Number);
                    display_serving_number.setText("0");
                }
                else{
                    int entered_serving_as_int = Integer.parseInt(entered_serving_as_string);
                    int weight_per_serving = weight_of_food[0]/entered_serving_as_int;
                    String food_per_serving_as_string = "" + weight_per_serving;
                    TextView display_serving_number = (TextView) findViewById(R.id.Calculated_Serving_Number);
                    display_serving_number.setText(food_per_serving_as_string);
                }
            }
        });
    }

    // initiate BACK button
    private void setupBACKButton(){
        Button back = (Button) findViewById(R.id.back_btn);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
