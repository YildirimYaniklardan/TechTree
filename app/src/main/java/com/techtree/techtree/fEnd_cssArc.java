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

public class fEnd_cssArc extends AppCompatActivity {

    private TextView cssArc_textview;
    private SeekBar cssArc_seekbar;

    private SharedPreferences preferences;

    private static final String PROGRESS = "SEEKBAR8";

    public static double change = 0;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fend_css_arc);

        cssArc_textview = findViewById(R.id.cssArcKnowledgeInt);
        cssArc_seekbar = findViewById(R.id.cssArc_knowledge);

        cssArc_seekbar.setProgressTintList(ColorStateList.valueOf(Color.parseColor("#03A9F4")));

        preferences = getSharedPreferences(" ", MODE_PRIVATE);

        final SharedPreferences.Editor editor_1 = preferences.edit();

        cssArc_seekbar.setProgress(preferences.getInt(PROGRESS,0));;

        cssArc_textview.setText(""+cssArc_seekbar.getProgress());

        change = cssArc_seekbar.getProgress();

        cssArc_seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int sb_change = 0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                sb_change = progress;
                change = progress;
                cssArc_textview.setText(""+sb_change);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                editor_1.putInt(PROGRESS, cssArc_seekbar.getProgress());
                editor_1.commit();

                change = cssArc_seekbar.getProgress();                      ////////////////////////////////////////////

            }
        });
    }
    public static double getData() {return change;}

    public static void setChange(double d) {
        change = d;
    }
}