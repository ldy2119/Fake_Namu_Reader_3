package com.dowellcomputer.webview1;

import android.content.res.AssetManager;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
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
import java.io.OutputStream;
import java.io.OutputStreamWriter;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bt1 = (Button) findViewById(R.id.bt1);

        WebView webview = (WebView) findViewById(R.id.webView2);
        webview.setWebViewClient(new WebViewClient());
        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);

        buildpagefirst();
        //build("");
    }

    public void buildpagefirst()
    {
        try
        {
            if(new File(getFilesDir().getAbsolutePath() + File.separator + "umaN").exists())
            {
                //TextView text = (TextView)findViewById(R.id.text1);
                //text.setText("not Empty");
                return;
            }
            AssetManager am = getAssets();
            String[] assets = am.list("");

            for(String element : assets)
            {
                copyall(element);
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    void copyall(String path)
    {
        try
        {
            AssetManager am = getAssets();
            String[] assets = am.list(path);
            if(assets.length == 0)
            {
                copyfile(path);
            }

            else
            {
                String newpath = getFilesDir().getAbsolutePath() + File.separator + path;
                File dir = new File(newpath);

                if(!dir.exists())
                    dir.mkdirs();
                for(String element : assets)
                    copyall(path + File.separator + element);

            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    void copyfile(String path)
    {
        try
        {
            AssetManager am = getAssets();

            String newpath = getFilesDir().getAbsolutePath() + File.separator + path;

            InputStream is = am.open(path);
            OutputStream out = new FileOutputStream(newpath);

            byte[] buffer =     new byte[1024];
            int read;
            while((read = is.read()) != -1)
            {
                out.write(buffer, 0, read);
            }
            is.close();
            out.flush();
            out.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void build(String url)
    {
        TextView textView = (TextView)findViewById(R.id.text1);

        try {
            AssetManager am = getAssets();
            InputStream in = am.open("umaN/head.html");
            InputStreamReader ir = new InputStreamReader(in);
            BufferedReader br = new BufferedReader(ir);
            TextView text1 = (TextView) findViewById(R.id.text1);
            //Document head = Jsoup.parse(in, "UTF-8", "");
            //Document body = Jsoup.connect(url).get();
            //String a = head.html();
            String a = "";
            //a += body.body();
            a += "</html>";
            int index = 0;

            File file = null;


            String dir = file.getAbsolutePath() + "/umaN/";

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
            br.close();
            in.close();

        } catch (IOException e) {
            e.printStackTrace();
            textView.setText(e.toString());
        }
    }
}
