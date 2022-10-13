package com.example.dice3pgr2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<ImageView> diceImageView = new ArrayList<>();
    Button diceButton;
    ArrayList<Dice> rolledDices = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        diceImageView.add(findViewById(R.id.imageView1));
        diceImageView.add(findViewById(R.id.imageView2));
        diceImageView.add(findViewById(R.id.imageView3));
        diceImageView.add(findViewById(R.id.imageView4));
        diceImageView.add(findViewById(R.id.imageView5));

        diceButton = findViewById(R.id.button);
        diceImageView.get(0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,
                        "kliknięto",
                        Toast.LENGTH_SHORT)
                        .show();
            }
        });
        diceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i=0;i<5;i++){
                    Dice dice = new Dice();
                    rolledDices.add(dice);
                    diceImageView.get(i).setImageResource(dice.getIdImage());
                }

            }
        });
    }
}