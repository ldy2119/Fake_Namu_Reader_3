package com.dowellcomputer.webview1;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class buildpage {

    public void build(String url)
    {
        try {
            Document head = Jsoup.parse(new File("file:///android_asset/umaN/head.html"), "UTF-8");
            Document body = Jsoup.connect(url).get();
            String a = head.html();
            a += body.body();
            a += "</html>";
            int index = 0;
            while((index = a.indexOf("/w/", index)) != -1)
            {
                System.out.println(index);
                index = index+1;
            }
            a = a.replaceAll("/w/", "");
            File f = new File("file:///umaN");
            f.mkdirs();
            f = new File(f.getAbsoluteFile(), "output.html");
            BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f), "UTF-8"));
            bf.write(a);
            bf.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
