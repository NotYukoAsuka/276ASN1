package ydsun.servingsizecalculator;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Conformation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.conformation);

        setupNoButton();
        setupYesButton();
    }

    // initiate No Button
    private void setupNoButton(){
        Button No_btn = (Button) findViewById(R.id.no_button);
        No_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
                Intent pos = getIntent();
                final Intent intent = new Intent();
                final int position = pos.getIntExtra("removing position", 0);
                intent.putExtra("comforming position", position);
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });
    }
}
