package ydsun.servingsizecalculator;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddingNewPot extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_new_pot);

        setupOKButton();
        setupCancelButton();
    }

    // initiate OK Button
    private void setupOKButton(){
        Button OK_btn = (Button) findViewById(R.id.ok_button);
        OK_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent data = getIntent();
                final int position = data.getIntExtra("Selected Position For Edit", 0);
                final Intent intent = new Intent();
                intent.putExtra("Position", position);
                EditText user_typed_name = (EditText) findViewById(R.id.UserEnterName);
                String typed_name = user_typed_name.getText().toString();

                EditText user_typed_weight = (EditText) findViewById(R.id.UserEnterWeight);
                String typed_weight = user_typed_weight.getText().toString();

                // Exceptions For Inputs
                if (typed_name == null || typed_name.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Pot Name Cannot Be Empty!", Toast.LENGTH_LONG).show();
                }

                else if(typed_weight == null || typed_weight.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Please Enter a Valid Number For Pot Weight!", Toast.LENGTH_LONG).show();
                }
                else if (Double.parseDouble(typed_weight) > 99999999 && Double.parseDouble(typed_weight) < 1000000000000l){
                    Toast.makeText(getApplicationContext(), "Come on! That is too Heavy for a Pot to be!", Toast.LENGTH_LONG).show();
                }
                else if (Double.parseDouble(typed_weight) > 1000000000000l && Double.parseDouble(typed_weight) < 99999999999999999l){
                    Toast.makeText(getApplicationContext(), "Your Trying to Test Out the Limit Aren't You...?", Toast.LENGTH_LONG).show();
                }
                else if (Double.parseDouble(typed_weight) > 99999999999999999l){
                    Toast.makeText(getApplicationContext(), "I Guess You Found the Limit....", Toast.LENGTH_LONG).show();
                }
                else {
                    int typed_number = Integer.parseInt(typed_weight);

                    if (typed_number < 0) {
                        Toast.makeText(getApplicationContext(), "Please Enter a Non-Negative Number!", Toast.LENGTH_LONG).show();
                    }

                    // Valid Input Detected
                    else if (typed_number < 10){
                        Toast.makeText(getApplicationContext(), "A Pretty Light Pot huh? Hmmm...", Toast.LENGTH_LONG).show();
                        intent.putExtra("Pot Weight", typed_number);
                        intent.putExtra("Pot Name", typed_name);
                        setResult(Activity.RESULT_OK, intent);
                        finish();
                    }
                    else{
                        intent.putExtra("Pot Weight", typed_number);
                        intent.putExtra("Pot Name", typed_name);
                        setResult(Activity.RESULT_OK, intent);
                        finish();
                    }
                }
            }
        });
    }

    // initiate Cancel Button
    private void setupCancelButton(){
        Button CANCEL_btn = (Button) findViewById(R.id.cancel_button);
        CANCEL_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent intent = new Intent();
                setResult(Activity.RESULT_CANCELED, intent);
                finish();
            }
        });
    }
}
