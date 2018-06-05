package com.dowellcomputer.webview1;

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

        //File z = new File(System.getProperty("user.dir"));


        Button b1 = findViewById(R.id.bt1);

        /*
        WebView webview = (WebView) findViewById(R.id.webview);
        webview.setWebViewClient(new WebViewClient());
        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);

        webview.loadUrl("https://namu.wiki/w/%EB%82%98%EB%AC%B4%EC%9C%84%ED%82%A4:%EB%8C%80%EB%AC%B8");

        */

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView v = (TextView) findViewById(R.id.asdfg1);
                File z = new File(System.getProperty("user.dir"));
                v.setText(z.getAbsolutePath());
                //z.mkdirs();
                //v.setText(z.getPath());
            }
        });

    }
}
