package ydsun.servingsizecalculator;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class RemovePot extends AppCompatActivity {

    public static final int REQUEST_CONFORM = 810;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.remove_pot);

        Intent intent = getIntent();

        String[] pot_description = intent.getStringArrayExtra("Pot Collection");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.pots, pot_description);
        ListView list = (ListView) findViewById(R.id.pots_to_remove);
        list.setAdapter(adapter);

        setupBACKButton();
        RegisterClickCallBackForClickingPots();
    }

    // initiate BACK button
    private void setupBACKButton(){
        Button back = (Button) findViewById(R.id.remove_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    // initiate "Click on a Pot to remove it" feature
    private void RegisterClickCallBackForClickingPots() {
        ListView list = (ListView) findViewById(R.id.pots_to_remove);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View viewClicked, int position, long id) {
                final Intent data = new Intent(RemovePot.this, Conformation.class);
                data.putExtra("removing position", position);
                startActivityForResult(data, REQUEST_CONFORM);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch(requestCode){
            case REQUEST_CONFORM:
                if(resultCode == Activity.RESULT_OK){

                }
        }
    }
}
