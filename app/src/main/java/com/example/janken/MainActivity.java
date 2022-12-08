package com.example.janken;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickRock(View view) {
        game(0);
    }

    public void onClickScissors(View view) {
        game(1);
    }

    public void onClickPaper(View view) {
        game(2);
    }


    private void game(int playerHand) {
        String[] handTexts = {"ぐー(cpu)", "ちょき(cpu)", "ぱー(cpu)"};
        Random r = new Random();
        int cupHand = r.nextInt(3);
        String judge = null;
        if (playerHand == cupHand) {
            judge = "あいこ";
        } else if (playerHand == 0 && cupHand == 2) {
            judge = "まけ";
        } else if (playerHand == 0 && cupHand == 1) {
            judge = "かち";
        } else if (playerHand == 1 && cupHand == 0) {
            judge = "まけ";
        } else if (playerHand == 1 && cupHand == 2) {
            judge = "かち";
        } else if (playerHand == 2 && cupHand == 0) {
            judge = "かち";
        } else if (playerHand == 2 && cupHand == 1) {
            judge = "まけ";
        }

        TextView textViewJudge = (TextView) findViewById(R.id.judge);
        textViewJudge.setText(judge);
        TextView textViewCpu = (TextView) findViewById(R.id.cpu);
        textViewCpu.setText(handTexts[cupHand]);
        String text = handTexts[cupHand];
        int[] ids = {R.drawable.janken_gu, R.drawable.janken_choki, R.drawable.janken_pa};
        int id = ids[cupHand];

        // リソースIDから Drawable のインスタンスを取得
        Drawable d = ResourcesCompat.getDrawable(getResources(), id, null);

        // これを入れないと表示されない（0表示）
        d.setBounds(0, 0, 500, 500);

        textViewCpu.setCompoundDrawables(null,d,null,null);
    }
}
