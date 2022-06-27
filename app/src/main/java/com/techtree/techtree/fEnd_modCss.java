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

public class fEnd_modCss extends AppCompatActivity {

    private TextView cssMod_textview;
    private SeekBar cssMod_seekbar;

    private SharedPreferences preferences;

    private static final String PROGRESS = "SEEKBAR12";

    public static double change = 0;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fend_mod_css);

        cssMod_textview = findViewById(R.id.cssModKnowledgeInt);
        cssMod_seekbar = findViewById(R.id.cssMod_knowledge);

        cssMod_seekbar.setProgressTintList(ColorStateList.valueOf(Color.parseColor("#03A9F4")));

        preferences = getSharedPreferences(" ", MODE_PRIVATE);

        final SharedPreferences.Editor editor_1 = preferences.edit();

        cssMod_seekbar.setProgress(preferences.getInt(PROGRESS,0));;

        cssMod_textview.setText(""+cssMod_seekbar.getProgress());

        change = cssMod_seekbar.getProgress();

        cssMod_seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int sb_change = 0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                sb_change = progress;
                cssMod_textview.setText(""+sb_change);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                editor_1.putInt(PROGRESS, cssMod_seekbar.getProgress());
                editor_1.commit();

                change = cssMod_seekbar.getProgress();                      ////////////////////////////////////////////

            }
        });
    }
    public static double getData() {return change;}

    public static void setChange(double d) {
        change = d;
    }
}