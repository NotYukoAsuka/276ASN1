package ydsun.servingsizecalculator;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddingNewPot extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_new_pot);

        setupOKButton();
        setupCancelButton();
    }

    private void setupOKButton(){
        Button OK_btn = (Button) findViewById(R.id.ok_button);
        OK_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent intent = new Intent();
                EditText user_typed_name = (EditText) findViewById(R.id.UserEnterName);
                String typed_name = user_typed_name.getText().toString();

                EditText user_typed_weight = (EditText) findViewById(R.id.UserEnterWeight);
                String typed_weight = user_typed_weight.getText().toString();

                if(typed_weight.length() == 0){
                    setResult(Activity.RESULT_CANCELED, intent);
                    finish();
                }
                else {
                    int typed_number = Integer.parseInt(typed_weight);

                    if (typed_number < 0) {
                        setResult(Activity.RESULT_CANCELED, intent);
                        finish();
                    } else if (typed_name.length() == 0) {
                        setResult(Activity.RESULT_CANCELED, intent);
                        finish();
                    } else {
                        intent.putExtra("Pot Weight", typed_number);
                        intent.putExtra("Pot Name", typed_name);
                        setResult(Activity.RESULT_OK, intent);
                        finish();
                    }
                }
            }
        });
    }

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
