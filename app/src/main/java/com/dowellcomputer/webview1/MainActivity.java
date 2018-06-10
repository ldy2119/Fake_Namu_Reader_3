package com.dowellcomputer.webview1;

import android.content.res.AssetManager;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView webview = (WebView) findViewById(R.id.webView2);
        webview.setWebViewClient(new WebViewClient());
        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);

        build("");
    }

    public void build(String url)
    {
        TextView textView = (TextView)findViewById(R.id.text1);

        try {
            AssetManager am = getAssets();
            InputStream in = am.open("umaN/head.html");
            InputStreamReader ir = new InputStreamReader(in);
            BufferedReader br = new BufferedReader(ir);
            //Document head = Jsoup.parse(in, "UTF-8", "");
            //Document body = Jsoup.connect(url).get();
            //String a = head.html();
            String a = "";
            //a += body.body();
            a += "</html>";
            int index = 0;
            while((index = a.indexOf("/w/", index)) != -1)
            {
                System.out.println(index);
                index = index+1;
            }
            a = a.replaceAll("/w/", "");

            String sdcard = Environment.getExternalStorageState();
            File file = null;

            if ( !sdcard.equals(Environment.MEDIA_MOUNTED))
            {
                // SD카드가 마운트되어있지 않음
                file = Environment.getRootDirectory();
            }
            else
            {
                // SD카드가 마운트되어있음
                file = Environment.getExternalStorageDirectory();
            }


            String dir = file.getAbsolutePath() + "/mytestdata/";
           // String path = file.getAbsolutePath() + String.format("/mytestdata/file_%02d/myfile%04d.mp4", fileType, fileId);

            file = new File(dir);
            if ( !file.exists() )
            {
                // 디렉토리가 존재하지 않으면 디렉토리 생성

                //textView.setText(""+file.mkdirs());
            }

            /*
            BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f), "UTF-8"));
            bf.write(a);
            bf.close();
            */
            in.close();

        } catch (IOException e) {
            e.printStackTrace();
            textView.setText(e.toString());
        }
    }
}
