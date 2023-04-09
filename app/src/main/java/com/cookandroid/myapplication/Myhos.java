package com.cookandroid.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class Myhos extends AppCompatActivity {

    //발급받은 인증키 입력
    TextView text;
    XmlPullParser xpp;
    String key ="UgCtmns4BxUedDLz%2BrZvWRlZAF%2BbWmGMEFr6lPGsS%2FvCmg9w0yuiaO4JC1EwFAGMxtBQ1ovtYi%2BjspMe6m8TBw%3D%3D";
    String data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myhos);

        text = (TextView) findViewById(R.id.result);

        new Thread(new Runnable() {
            @Override
            public void run() {

                data = getXmlData();

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        text.setText(data);
                    }
                });
            }
        }).start();
    }

    String getXmlData(){
        StringBuffer buffer = new StringBuffer();
        String queryUrl="https://apis.data.go.kr/B552657/HsptlAsembySearchService/getHsptlMdcncFullDown?&pageNo=1&numOfRows=10&serviceKey=UgCtmns4BxUedDLz%2BrZvWRlZAF%2BbWmGMEFr6lPGsS%2FvCmg9w0yuiaO4JC1EwFAGMxtBQ1ovtYi%2BjspMe6m8TBw%3D%3D";
        try{
            URL url= new URL(queryUrl);//문자열로 된 요청 url을 URL 객체로 생성.
            InputStream is= url.openStream(); //url위치로 입력스트림 연결

            XmlPullParserFactory factory= XmlPullParserFactory.newInstance();//xml파싱을 위한
            XmlPullParser xpp= factory.newPullParser();
            xpp.setInput( new InputStreamReader(is, "UTF-8") ); //inputstream 으로부터 xml 입력받기

            String tag;

            xpp.next();
            int eventType= xpp.getEventType();
            while( eventType != XmlPullParser.END_DOCUMENT ){
                switch( eventType ){
                    case XmlPullParser.START_DOCUMENT:
                        break;

                    case XmlPullParser.START_TAG:
                        tag= xpp.getName();//테그 이름 얻어오기

                        if(tag.equals("item")) ;// 첫번째 검색결과
                        else if(tag.equals("dutyAddr")){
                            buffer.append("주소 : ");
                            xpp.next();
                            buffer.append(xpp.getText());//dutyAddr 요소의 TEXT 읽어와서 문자열버퍼에 추가
                            buffer.append("\n"); //줄바꿈 문자 추가
                        }
                        else if(tag.equals("dutyDiv")){
                            buffer.append("병원분류 : ");
                            xpp.next();
                            buffer.append(xpp.getText());//dutyDiv 요소의 TEXT 읽어와서 문자열버퍼에 추가
                            buffer.append("\n");//줄바꿈 문자 추가
                        }
                        else if(tag.equals("dutyDivNam")){
                            buffer.append("병원분류명 :");
                            xpp.next();
                            buffer.append(xpp.getText());//dutyDivNam 요소의 TEXT 읽어와서 문자열버퍼에 추가
                            buffer.append("\n");//줄바꿈 문자 추가
                        }
                        else if(tag.equals("dutyEmcls")){
                            buffer.append("응급의료기관코드 :");
                            xpp.next();
                            buffer.append(xpp.getText());//dutyEmcls 요소의 TEXT 읽어와서 문자열버퍼에 추가
                            buffer.append("\n");//줄바꿈 문자 추가
                        }
                        else if(tag.equals("dutyEmclsName")){
                            buffer.append("응급의료기관코드명 :");
                            xpp.next();
                            buffer.append(xpp.getText());//dutyEmclsName 요소의 TEXT 읽어와서 문자열버퍼에 추가
                            buffer.append("\n");//줄바꿈 문자 추가
                        }
                        else if(tag.equals("dutyEryn")){
                            buffer.append("응급실 운영여부 :");
                            xpp.next();
                            buffer.append(xpp.getText());//dutyEryn 요소의 TEXT 읽어와서 문자열버퍼에 추가
                            buffer.append("\n"); //줄바꿈 문자 추가
                        }
                        else if(tag.equals("dutyName")){
                            buffer.append("기관명 :");
                            xpp.next();
                            buffer.append(xpp.getText());//dutyName 요소의 TEXT 읽어와서 문자열버퍼에 추가
                            buffer.append("\n"); //줄바꿈 문자 추가
                        }
                        else if(tag.equals("dutyTel1")){
                            buffer.append("대표전화1 :");
                            xpp.next();
                            buffer.append(xpp.getText());//dutyTel1 요소의 TEXT 읽어와서 문자열버퍼에 추가
                            buffer.append("\n"); //줄바꿈 문자 추가
                        }

                        else if(tag.equals("dutyTime1c")){
                            buffer.append("진료시간(월요일)C :");
                            xpp.next();
                            buffer.append(xpp.getText());//dutyTime1c 요소의 TEXT 읽어와서 문자열버퍼에 추가
                            buffer.append("\n"); //줄바꿈 문자 추가
                        }
                        else if(tag.equals("dutyTime2c")){
                            buffer.append("진료시간(화요일)C :");
                            xpp.next();
                            buffer.append(xpp.getText());//dutyTime2c 요소의 TEXT 읽어와서 문자열버퍼에 추가
                            buffer.append("\n"); //줄바꿈 문자 추가
                        }
                        else if(tag.equals("dutyTime3c")){
                            buffer.append("진료시간(수요일)C :");
                            xpp.next();
                            buffer.append(xpp.getText());//dutyTime3c 요소의 TEXT 읽어와서 문자열버퍼에 추가
                            buffer.append("\n"); //줄바꿈 문자 추가
                        }
                        else if(tag.equals("dutyTime4c")){
                            buffer.append("진료시간(목요일)C :");
                            xpp.next();
                            buffer.append(xpp.getText());//dutyTime4c 요소의 TEXT 읽어와서 문자열버퍼에 추가
                            buffer.append("\n"); //줄바꿈 문자 추가
                        }
                        else if(tag.equals("dutyTime5c")){
                            buffer.append("진료시간(금요일)C :");
                            xpp.next();
                            buffer.append(xpp.getText());//dutyTime5c 요소의 TEXT 읽어와서 문자열버퍼에 추가
                            buffer.append("\n"); //줄바꿈 문자 추가
                        }
                        else if(tag.equals("dutyTime6c")){
                            buffer.append("진료시간(토요일)C :");
                            xpp.next();
                            buffer.append(xpp.getText());//dutyTime6c 요소의 TEXT 읽어와서 문자열버퍼에 추가
                            buffer.append("\n"); //줄바꿈 문자 추가
                        }
                        else if(tag.equals("dutyTime7c")){
                            buffer.append("진료시간(일요일)C :");
                            xpp.next();
                            buffer.append(xpp.getText());//dutyTime7c 요소의 TEXT 읽어와서 문자열버퍼에 추가
                            buffer.append("\n"); //줄바꿈 문자 추가
                        }
                        else if(tag.equals("dutyTime8c")){
                            buffer.append("진료시간(공휴일)C :");
                            xpp.next();
                            buffer.append(xpp.getText());//dutyTime8c 요소의 TEXT 읽어와서 문자열버퍼에 추가
                            buffer.append("\n"); //줄바꿈 문자 추가
                        }

                        else if(tag.equals("dutyTime1s")){
                            buffer.append("진료시간(월요일)S :");
                            xpp.next();
                            buffer.append(xpp.getText());//dutyTime1s 요소의 TEXT 읽어와서 문자열버퍼에 추가
                            buffer.append("\n"); //줄바꿈 문자 추가
                        }
                        else if(tag.equals("dutyTime2s")){
                            buffer.append("진료시간(화요일)S :");
                            xpp.next();
                            buffer.append(xpp.getText());//dutyTime2s 요소의 TEXT 읽어와서 문자열버퍼에 추가
                            buffer.append("\n"); //줄바꿈 문자 추가
                        }
                        else if(tag.equals("dutyTime3s")){
                            buffer.append("진료시간(수요일)S :");
                            xpp.next();
                            buffer.append(xpp.getText());//dutyTime3s 요소의 TEXT 읽어와서 문자열버퍼에 추가
                            buffer.append("\n"); //줄바꿈 문자 추가
                        }
                        else if(tag.equals("dutyTime4s")){
                            buffer.append("진료시간(목요일)S :");
                            xpp.next();
                            buffer.append(xpp.getText());//dutyTime4s 요소의 TEXT 읽어와서 문자열버퍼에 추가
                            buffer.append("\n"); //줄바꿈 문자 추가
                        }
                        else if(tag.equals("dutyTime5s")){
                            buffer.append("진료시간(금요일)S :");
                            xpp.next();
                            buffer.append(xpp.getText());//dutyTime5s 요소의 TEXT 읽어와서 문자열버퍼에 추가
                            buffer.append("\n"); //줄바꿈 문자 추가
                        }
                        else if(tag.equals("dutyTime6s")){
                            buffer.append("진료시간(토요일)S :");
                            xpp.next();
                            buffer.append(xpp.getText());//dutyTime6s 요소의 TEXT 읽어와서 문자열버퍼에 추가
                            buffer.append("\n"); //줄바꿈 문자 추가
                        }
                        else if(tag.equals("dutyTime7s")){
                            buffer.append("진료시간(일요일)S :");
                            xpp.next();
                            buffer.append(xpp.getText());//dutyTime7s요소의 TEXT 읽어와서 문자열버퍼에 추가
                            buffer.append("\n"); //줄바꿈 문자 추가
                        }
                        else if(tag.equals("dutyTime8s")){
                            buffer.append("진료시간(공휴일)S :");
                            xpp.next();
                            buffer.append(xpp.getText());//dutyTime8s 요소의 TEXT 읽어와서 문자열버퍼에 추가
                            buffer.append("\n"); //줄바꿈 문자 추가
                        }
                        else if(tag.equals("hpid")){
                            buffer.append("기관 ID :");
                            xpp.next();
                            buffer.append(xpp.getText());//hpid 요소의 TEXT 읽어와서 문자열버퍼에 추가
                            buffer.append("\n"); //줄바꿈 문자 추가
                        }
                        else if(tag.equals("postCdn1")){
                            buffer.append("우편번호1 :");
                            xpp.next();
                            buffer.append(xpp.getText());//postCdn1 요소의 TEXT 읽어와서 문자열버퍼에 추가
                            buffer.append("\n"); //줄바꿈 문자 추가
                        }
                        else if(tag.equals("postCdn2")){
                            buffer.append("우편번호2 :");
                            xpp.next();
                            buffer.append(xpp.getText());//postCdn2 요소의 TEXT 읽어와서 문자열버퍼에 추가
                            buffer.append("\n"); //줄바꿈 문자 추가
                        }

                        else if(tag.equals("rnum")){
                            buffer.append("일련번호 :");
                            xpp.next();
                            buffer.append(xpp.getText());//rnum 요소의 TEXT 읽어와서 문자열버퍼에 추가
                            buffer.append("\n"); //줄바꿈 문자 추가
                        }
                        else if(tag.equals("wgs84Lat")){
                            buffer.append("병원위도 :");
                            xpp.next();
                            buffer.append(xpp.getText());//wgs84Lat 요소의 TEXT 읽어와서 문자열버퍼에 추가
                            buffer.append("\n"); //줄바꿈 문자 추가
                        }
                        else if(tag.equals("wgs84Lon")){
                            buffer.append("병원경도 :");
                            xpp.next();
                            buffer.append(xpp.getText());//wgs84Lon 요소의 TEXT 읽어와서 문자열버퍼에 추가
                            buffer.append("\n"); //줄바꿈 문자 추가
                        }
                        break;



                    case XmlPullParser.TEXT:
                        break;

                    case XmlPullParser.END_TAG:
                        tag= xpp.getName(); //테그 이름 얻어오기

                        if(tag.equals("item")) buffer.append("\n");// 첫번째 검색결과종료..줄바꿈
                        break;
                }

                eventType= xpp.next();
            }

        } catch (Exception e){
            e.printStackTrace();
        }
        return buffer.toString();//StringBuffer 문자열 객체 반환

    }
}