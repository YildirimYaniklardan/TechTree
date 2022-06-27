package com.techtree.techtree;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class fEnd_webAssembly extends AppCompatActivity {

    private TextView webAssemb_textview;
    private SeekBar webAssemb_seekbar;

    private SharedPreferences preferences;

    private static final String PROGRESS = "SEEKBAR23";

    public static double change = 0;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fend_web_assembly);

        webAssemb_textview = findViewById(R.id.webAssembKnowledgeInt);
        webAssemb_seekbar = findViewById(R.id.webAssemb_knowledge);

        webAssemb_seekbar.setProgressTintList(ColorStateList.valueOf(Color.parseColor("#03A9F4")));

        preferences = getSharedPreferences(" ", MODE_PRIVATE);

        final SharedPreferences.Editor editor_1 = preferences.edit();

        webAssemb_seekbar.setProgress(preferences.getInt(PROGRESS,0));;

        webAssemb_textview.setText(""+webAssemb_seekbar.getProgress());

        change = webAssemb_seekbar.getProgress();

        webAssemb_seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int sb_change = 0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                sb_change = progress;
                change = progress;
                webAssemb_textview.setText(""+sb_change);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                editor_1.putInt(PROGRESS, webAssemb_seekbar.getProgress());
                editor_1.commit();

                change = webAssemb_seekbar.getProgress();                      ////////////////////////////////////////////

            }
        });
    }
    public static double getData() {return change;}

    public static void setChange(double d) {
        change = d;
    }
}