package com.nofegreen.chord;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Welcome extends AppCompatActivity {

    private ImageView myImage;
    private TextView myText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.nofegreen.chord.R.layout.activity_welcome);

        myImage = (ImageView)findViewById(com.nofegreen.chord.R.id.imageWelcome);
        myText = (TextView)findViewById(com.nofegreen.chord.R.id.textWelcome);

        Animation myanim = AnimationUtils.loadAnimation(this, com.nofegreen.chord.R.anim.efectanim);
        myImage.startAnimation(myanim);
        myText.startAnimation(myanim);


        final Intent i = new Intent(this,Home.class);
        Thread timer = new Thread(){
            public void run(){
                try {
                    sleep(5000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                finally {
                    startActivity(i);
                    finish();
                }
            }
        };
        timer.start();
    }
}
