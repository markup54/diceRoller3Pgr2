package com.example.dice3pgr2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public Integer wylosowanaLiczba;
    public ArrayList<Integer> obrazkiKosci = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        obrazkiKosci.add(R.drawable.dice_1);
        obrazkiKosci.add(R.drawable.dice_2);
        obrazkiKosci.add(R.drawable.dice_3);
        obrazkiKosci.add(R.drawable.dice_4);
        obrazkiKosci.add(R.drawable.dice_5);
        obrazkiKosci.add(R.drawable.dice_6);
        Button diceButton = findViewById(R.id.button);
        TextView diceTextView = findViewById(R.id.textView);
        ImageView diceImageView = findViewById(R.id.imageView);
        diceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wylosowanaLiczba = (int)(Math.random()*6+1);
                diceTextView.setText(wylosowanaLiczba.toString());
                diceImageView.setImageResource(obrazkiKosci.get(wylosowanaLiczba-1));
            }
        });
    }
}