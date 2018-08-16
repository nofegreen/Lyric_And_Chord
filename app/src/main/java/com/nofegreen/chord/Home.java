package com.nofegreen.chord;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.FrameLayout;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.AdRequest;

public class Home extends AppCompatActivity {

    private FrameLayout lyricCard,shareCard,moreappCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // definisi card
        lyricCard = (FrameLayout) findViewById(R.id.lyric_id);
        shareCard = (FrameLayout) findViewById(R.id.share_id);
        moreappCard = (FrameLayout) findViewById(R.id.moreapp_id);

        //add click listener
        lyricCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),MenuGrid.class);
                startActivity(i);
            }
        });

        shareCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shareIt();
            }
        });
        moreappCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.nofegreen.icon"));
                startActivity(intent);
            }
        });
    }

    private void shareIt(){
        Intent  mi = new Intent();
        mi.setAction(Intent.ACTION_SEND);
        mi.putExtra(Intent.EXTRA_TEXT, "https://play.google.com/store/apps/details?id=com.nofegreen.icon");
        mi.setType("text/plain");
        startActivity(mi);
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder ab = new AlertDialog.Builder(Home.this);
        ab.setTitle("A Big Thank You");
        ab.setMessage("are you sure to exit?");
        ab.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                //if you want to kill app . from other then your main avtivity.(Launcher)
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);

                //if you want to finish just current activity
                Home.this.finish();
            }
        });
        ab.setNegativeButton("no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        ab.show();
    }
}
