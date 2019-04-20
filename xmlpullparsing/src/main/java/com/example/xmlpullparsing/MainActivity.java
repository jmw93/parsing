package com.example.xmlpullparsing;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class MainActivity extends Activity {
    TextView textView;
    String data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);

         // 파싱후 내용이담긴 (String) buffer 객체
        new Thread(new Runnable() {
            @Override
            public void run() {
                data = XMLparser();

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    textView.setText(data);
                }
            });
            }


        }).start();
    }

        public String XMLparser(){
        StringBuffer buffer = new StringBuffer();
        String Urlrequest ="http://open.ev.or.kr:8080/openapi/services/rest/EvChargerService?serviceKey=" +
                        "RjzMYQORqJIq4l9YZkCCmV5mTIec%2BdJYC%2BUzK3c2Aogy4I2Y0tZnRI4292OO56Qqr%2FIMajYNHjo5M8Ayz4R05g%3D%3D";

            try {
                URL url = new URL(Urlrequest);
                InputStream is = url.openStream();
                XmlPullParserFactory parserFactory = XmlPullParserFactory.newInstance();
                XmlPullParser xpp = parserFactory.newPullParser();
                xpp.setInput(new InputStreamReader(is,"UTF-8"));


                int eventType = xpp.getEventType();

                while (eventType != XmlPullParser.END_DOCUMENT){
                    switch (eventType) {
                        case XmlPullParser.START_TAG:
                            String startTag = xpp.getName();
                            Log.d("minwoo",startTag);
                            if(startTag.equals("item")){
                                buffer.append(startTag+"{");
                                buffer.append("\n");
                            }

                            if(startTag.equals("statNm")){
                                xpp.next();
                                buffer.append(startTag+":"+xpp.getText());
                                buffer.append("\n");
                            }
                            if(startTag.equals("chgerId")){
                                xpp.next();
                                buffer.append(startTag+":"+xpp.getText());
                                buffer.append("\n");
                            }
                            if(startTag.equals("chgerType")){
                                xpp.next();
                                buffer.append(startTag+":"+xpp.getText());
                                buffer.append("\n");
                            }
                            if(startTag.equals("stat")){
                                xpp.next();
                                buffer.append(startTag+":"+xpp.getText());
                                buffer.append("\n");
                            }
                            if(startTag.equals("addrDoro")){
                                xpp.next();
                                buffer.append(startTag+":"+xpp.getText());
                                buffer.append("\n");
                            }
                            if(startTag.equals("useTime")){
                                xpp.next();
                                buffer.append(startTag+":"+xpp.getText());
                                buffer.append("\n");
                            }


                            break;

                     /*
                        case XmlPullParser.TEXT:
                            String textTag = xpp.getText();
                                if(textTag != null)
                                Log.d("minwoo",textTag);*/

                        case XmlPullParser.END_TAG:
                         String endTag =xpp.getName();
                         if(endTag.equals("item")){
                             buffer.append("}");
                             buffer.append("\n");

                         }
                    break;
                    }

                    // 다음 엘리먼트 읽기
                    eventType = xpp.next();
                }

            } catch (Exception e) {
                Log.e("minwoo", e.toString());
            }
            return buffer.toString();
        }


    }


