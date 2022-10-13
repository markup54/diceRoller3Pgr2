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
        losowanie();
        diceButton = findViewById(R.id.button);
        for (int i = 0; i < diceImageView.size(); i++) {
            ImageView image = diceImageView.get(i);
            int id = i;
            image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(image.getImageAlpha() == 50){
                        image.setImageAlpha(255);
                        rolledDices.get(id).setClicked(false);
                    }
                    else {
                        image.setImageAlpha(50);
                        rolledDices.get(id).setClicked(true);
                    }
                }
            });

        }

        diceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                losowanie();

            }
        });
    }
    private void  losowanie(){
        if(rolledDices.size() == 0) {
            for (int i = 0; i < 5; i++) {
                Dice dice = new Dice();
                rolledDices.add(dice);
                diceImageView.get(i).setImageResource(dice.getIdImage());
            }
        }
        else {
            for (int i = 0; i < 5; i++) {
                Dice dice = rolledDices.get(i);
                if (dice.isClicked() == false) {
                    dice.setValue();
                    diceImageView.get(i).setImageResource(dice.getIdImage());
                }

            }
        }
    }
}