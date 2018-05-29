package ydsun.servingsizecalculator;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Conformation extends AppCompatActivity {

    public static final String POT_POS = "Position of the Pot";
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.conformation);

        extractDataFromIntentForRemoveConformation();
        setupNoButton();
        setupYesButton();
    }

    // Data For Edit Feature
    private void extractDataFromIntentForRemoveConformation(){
        Intent intent = getIntent();
        position = intent.getIntExtra(POT_POS,0);
    }

    // initiate No Button
    private void setupNoButton(){
        Button No_btn = (Button) findViewById(R.id.no_button);
        No_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Please Take Your Time To Think About Which Pot To Remove...", Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }

    // initiate Yes Button
    private void setupYesButton(){
        Button Yes_btn = (Button) findViewById(R.id.yes_button);
        Yes_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent intent = new Intent();
                intent.putExtra("conforming position", position);
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });
    }

    // Position Data for removing conformation
    public static Intent makeIntentForConforming(RemovePot context, int position) {
        Intent intent = new Intent(context, Conformation.class);
        intent.putExtra(POT_POS, position);
        return intent;
    }
}
