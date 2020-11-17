package com.example.androidassignments;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.util.Xml;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import org.xmlpull.v1.XmlPullParser;

import java.io.InputStream;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class WeatherForecast extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_forecast);
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);
        setTitle("Weather");

    }
    private class ForecastQuery extends AsyncTask<String, Integer, String> {

        private String currentTemp;
        private String minTemp;
        private String maxTemp;
        private Bitmap picture;
        ImageView imageView;
        ProgressBar progressBar;
        protected String city;
        ForecastQuery(String city){
            this.city = city;
        }
        @Override
        protected String doInBackground(String... strings) {
            try{
                URL url = new URL(
                        "http://api.openweathermap.org/data/2.5/weather?q=ottawa,ca&APPID=79cecf493cb6e52d25bb7b7050ff723c&mode=xml&units=metric");

                HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
                conn.setReadTimeout(10000);
                conn.setConnectTimeout(15000);
                conn.setRequestMethod("GET");
                conn.setDoInput(true);
                conn.connect();
                InputStream inputStream = conn.getInputStream();
                try{

                    XmlPullParser parser = Xml.newPullParser();
                    parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
                    parser.setInput(inputStream, null);

                    int type;

                    while((type = parser.getEventType()) != XmlPullParser.END_DOCUMENT){
                        if (parser.getEventType() == XmlPullParser.START_TAG){
                            if (parser.getName().equals("temperature")){
                                currentTemp = parser.getAttributeValue(null, "current");
                                publishProgress(25);
                                minTemp = parser.getAttributeValue(null, "min");
                                publishProgress(50);
                                maxTemp = parser.getAttributeValue(null, "max");
                                publishProgress(75);
                            } else if (parser.getName().equals("weather")){
                                String iconName = parser.getAttributeValue(null, "icon");
                                String fileName = iconName + ".png";

                                Log.i("WeatherForecast", "Looking for file" + fileName);

                                if (fileExisitance(fileName)){
                                    FileInputStream fileInputStream = null;
                                    try{
                                        fileInputStream = openFileInput(fileName);
                                    } catch (FileNotFoundException e){
                                        e.printStackTrace();
                                    }
                                    Log.i("WeatherForecast", "Found File Locally");
                                    picture = BitmapFactory.decodeStream(fileInputStream);

                                }else{
                                    String iconURL = "https://openweathermap.org/img/w/" + fileName;
                                    picture = getImage(new URL(iconURL));
                                    FileOutputStream outputStream = openFileOutput(fileName, Context.MODE_PRIVATE);
                                    picture.compress(Bitmap.CompressFormat.PNG, 80, outputStream);
                                    Log.i("WeatherForecast", "Downloaded File From Internet");
                                    outputStream.flush();
                                    outputStream.close();
                                }
                                publishProgress(100);

                            }
                        }
                        parser.next();
                    }

                } finally {
                    inputStream.close();
                }
            } catch (Exception e){
                e.printStackTrace();
            }

            return null;


        }
        public boolean fileExisitance(String name){
            File file = getBaseContext().getFileStreamPath(name);
            return file.exists();
        }
        public Bitmap getImage(URL url) {
            HttpsURLConnection conn = null;
            try {
                conn = (HttpsURLConnection) url.openConnection();
                conn.connect();
                int responseCode = conn.getResponseCode();
                if (responseCode == 200){
                    return BitmapFactory.decodeStream(conn.getInputStream());
                }else{
                    return null;
                }

            } catch (Exception e) {
                return null;
            } finally{
                if (conn!=null){
                    conn.disconnect();
                }
            }
        }
        @Override
        protected void onProgressUpdate(Integer... values) {
            progressBar.setProgress(values[0]);
        }
        @Override
        protected void onPostExecute(String a){
            progressBar.setVisibility(View.INVISIBLE);
            imageView.setImageBitmap(picture);
//            currentTemp.setText(currentTemp + "C\u00b0");
            
        }
    }
}