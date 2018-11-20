/**
 * The sagittarius_activity class is used for displaying
 * information provided from BasicZodiacActivity
 * about the specific zodiac sign.
 *
 *
 * @author  Aleksandar Kalapsazov
 * @version 1.0
 * @since   2017-03-18
 */
package com.example.alex.daily_horoscope;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class sagittarius_activity extends AppCompatActivity {

    @Override
    //---On create function which displays the formated string---//
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sagittarius_activity);
        // Sample AdMob app ID: ca-app-pub-3940256099942544~3347511713
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://aztro.sameerkumar.website/?sign=sagittarius&day=today";
        final TextView textView = (TextView)findViewById(R.id.sagittariusTextview);
        final TextView extra = (TextView)findViewById(R.id.extra);

        //Typeface Textviews
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/AdventPro-Light.ttf");
        textView.setTypeface(typeface);
        extra.setTypeface(typeface);

        StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("Response", response);
                        try{
                            JSONObject jObj = new JSONObject(response);
                            String horoscope = jObj.getString("current_date") + "\n\n" + jObj.getString("description") + "\n";
                            String extraInformation = "Lucky number: " + jObj.getString("lucky_number")+ "\n" + "Color: " + jObj.getString("color") + "\n" + "Compatibility: " + jObj.getString("compatibility") + "\n" + "Mood: " + jObj.getString("mood");
                            extra.setText(extraInformation);
                            textView.setText(horoscope);

                        }catch (JSONException e){
                            Log.e("MyAPP","unexpected JSON exception");
                        }
                    }
                }

      ,new Response.ErrorListener()
        {
            @Override
            public void onErrorResponse(VolleyError error) {
                // error
                Log.d("Error.Response", error.toString());
            }
        }
        );
        queue.add(postRequest);
    }
    public void onBackPressed() {
        Intent intent = new Intent(sagittarius_activity.this,MainActivity.class);
        startActivity(intent);
    }
}
