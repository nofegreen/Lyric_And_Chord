package com.nofegreen.chord;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class WebLirics extends AppCompatActivity {

    Toolbar ntoolbar;
    WebView mWebView;
    Dialog myDialog;

    // Digunakan untuk scroll otomatis keatas
    /*private Runnable runCycle = new Runnable() {
        @Override
        public void run() {
            if (mWebView.getScrollY() - mWebView.getHeight() > 0) {
                mWebView.scrollBy(0, -(int) mWebView.getHeight());
            } else {
                mWebView.scrollTo(0, 0);
            }
        }
    };*/

    private void textNormal(){
        WebSettings settings = mWebView.getSettings();
        settings.setTextZoom(100);
    }

    private void textSmaller() {
        WebSettings settings = mWebView.getSettings();
        settings.setTextZoom(settings.getTextZoom() - 10);
    }

    private void textBigger() {
        WebSettings settings = mWebView.getSettings();
        settings.setTextZoom(settings.getTextZoom() + 10);
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.nofegreen.chord.R.layout.activity_web_lirics);

        ntoolbar = (Toolbar) findViewById(com.nofegreen.chord.R.id.toolbar2);
        mWebView = (WebView) findViewById(com.nofegreen.chord.R.id.webView);
        myDialog = new Dialog(this);

        setSupportActionBar(ntoolbar);
        ntoolbar.setNavigationIcon(com.nofegreen.chord.R.drawable.ic_arrow_back);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            ntoolbar.setTitle(bundle.getString("Title"));

            // ALBUM SABYAN
            if (ntoolbar.getTitle().toString().equalsIgnoreCase("Ya Maulana")) {
                mWebView.loadUrl("file:///android_asset/Ya_Maulana.html");
            } else if (ntoolbar.getTitle().toString().equalsIgnoreCase("Ya Jamalu")) {
                mWebView.loadUrl("file:///android_asset/Ya_Jamalu.html");
            } else if (ntoolbar.getTitle().toString().equalsIgnoreCase("Ya Asyqol")) {
                mWebView.loadUrl("file:///android_asset/Ya_Asyqol.html");
            } else if (ntoolbar.getTitle().toString().equalsIgnoreCase("Rohman Ya Rohman")) {
                mWebView.loadUrl("file:///android_asset/Rohman_Ya_Rohman.html");
            } else if (ntoolbar.getTitle().toString().equalsIgnoreCase("Ya Habibal Qolbi")) {
                mWebView.loadUrl("file:///android_asset/Ya_Habibal_Qolbi.html");
            } else if (ntoolbar.getTitle().toString().equalsIgnoreCase("Deen Assalam")) {
                mWebView.loadUrl("file:///android_asset/Deen_Assalam.html");
            } else if (ntoolbar.getTitle().toString().equalsIgnoreCase("Qomarun")) {
                mWebView.loadUrl("file:///android_asset/Qomarun.html");
            }else {
                mWebView.loadUrl("file:///android_asset/SUPPORT.html");
            }
        }
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    };

    /* private void ShowPopUp(){
        myDialog.show();
        myDialog.setContentView(com.nofegreen.chord.R.layout.custompopup);
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
    } */

    // Menu icons are inflated just as they were with actionbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(com.nofegreen.chord.R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        switch (item.getItemId()) {
            case R.id.miZoom:
                textBigger();
                return true;
            case R.id.miMinimize:
                textSmaller();
                return true;
            case R.id.miNormal:
                textNormal();
                return true;
                 //ShowPopUp();
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}