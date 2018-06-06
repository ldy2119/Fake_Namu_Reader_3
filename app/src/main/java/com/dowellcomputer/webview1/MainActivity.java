package com.dowellcomputer.webview1;

import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AssetManager am = getResources().getAssets();

        WebView webview = (WebView) findViewById(R.id.webView2);
        webview.setWebViewClient(new WebViewClient());
        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);

        webview.loadUrl("file:///android_asset/umaN/test.html");

        /*
        try
        {

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        */
    }
}
