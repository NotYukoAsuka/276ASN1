package ydsun.servingsizecalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Calculations extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculations_of_servings);

        Intent intent = getIntent();

        String pot_name = intent.getStringExtra("Selected Name");
        int pot_weight = intent.getIntExtra("Selected Weight", 0);
        String pot_weight_as_string = "" + pot_weight;

        setupBACKButton();

        TextView display_name = (TextView) findViewById(R.id.display_pot_name);
        display_name.setText(pot_name);

        TextView display_raw_weight = (TextView) findViewById(R.id.display_pot_weight);
        display_raw_weight.setText(pot_weight_as_string);
    }

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
