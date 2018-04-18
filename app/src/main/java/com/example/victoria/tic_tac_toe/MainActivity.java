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

public class MainActivity extends AppCompatActivity {

    Button twoPlayer;
    Button singlePlayer;

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        twoPlayer = (Button) findViewById(R.id.twoPlayer);
        twoPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Main4Activity.class);
                startActivity(intent);
            }
        });
        /*singlePlayer = (Button) findViewById(R.id.singlePlayer);
        singlePlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Main3Activity.class);
                startActivity(intent);
            }
        });*/

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

