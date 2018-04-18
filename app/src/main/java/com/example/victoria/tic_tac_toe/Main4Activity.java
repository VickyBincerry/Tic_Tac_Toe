package com.example.victoria.tic_tac_toe;

/**
 * Created by VICTORIA on 4/10/2018.
 */
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.victoria.tic_tac_toe.R;

public class Main4Activity extends AppCompatActivity {

    Button threeByThree;
    Button fiveByFive;

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        threeByThree = (Button) findViewById(R.id.threeByThree);
        threeByThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main4Activity.this, Main2Activity.class);
                startActivity(intent);
            }
        });
        fiveByFive = (Button) findViewById(R.id.fiveByFive);
        fiveByFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main4Activity.this, Main3Activity.class);
                startActivity(intent);
            }
        });

    }
}





/*}
   public void goThree(View view){
        Intent intent = new Intent(getApplicationContext(), NextActivity.class);
        startActivity(intent);
    }
    public void goFive(View view){
        Intent intent = new Intent(MainActivity.this, Five.class);
        startActivity(intent);
}}*/

