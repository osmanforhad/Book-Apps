package com.osman.bookapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class DescriptionActivity extends AppCompatActivity {

    /* Variable Declaration **/
    private static final String TAG = "DescriptionActivity";
    private Context mContext;
    private Bundle extras;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        /* initial the declared variable **/
        mContext = DescriptionActivity.this;

        webView = (WebView) findViewById(R.id.simpleWebView);

        extras = getIntent().getExtras();//get data from previous activity
        /* making validation for getting actual data **/
        if (!extras.equals(null)) {
            String data = extras.getString("titles");//here titles is the key from main activity
            Log.d(TAG, "onCreate: the coming data is "+data);

            /* load the data according to constance class **/
            String url = "file:///android_asset/"+data+".html";
            webView.loadUrl(url);

            /* writing code for setting for app **/
            WebSettings webSettings = webView.getSettings();
            webSettings.setBuiltInZoomControls(true);
            webSettings.setDisplayZoomControls(false);
            webSettings.setJavaScriptEnabled(true);

        }//end of the if condition

    }//end of the onCreate method

}//end of the class
