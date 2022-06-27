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

public class fEnd_build extends AppCompatActivity {

    private TextView build_textview;
    private SeekBar build_seekbar;

    private SharedPreferences preferences;

    private static final String PROGRESS = "SEEKBAR10";

    public static double change = 0;                                      ///////////////////////////////////////

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fend_build);

        build_textview = findViewById(R.id.buildKnowledgeInt);
        build_seekbar = findViewById(R.id.build_knowledge);

        build_seekbar.setProgressTintList(ColorStateList.valueOf(Color.parseColor("#03A9F4")));

        preferences = getSharedPreferences(" ", MODE_PRIVATE);

        final SharedPreferences.Editor editor_1 = preferences.edit();

        build_seekbar.setProgress(preferences.getInt(PROGRESS,0));;

        build_textview.setText(""+build_seekbar.getProgress());

        change = build_seekbar.getProgress();                           //////////////////////////////////////////

        build_seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int sb_change = 0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                sb_change = progress;
                change = progress;                                     //////////////////////////////////////////
                build_textview.setText(""+sb_change);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                editor_1.putInt(PROGRESS, build_seekbar.getProgress());
                editor_1.commit();

                change = build_seekbar.getProgress();                      ////////////////////////////////////////////

            }
        });
    }
    public static double getData() {return change;}                        //////////////////////////////////////////////

    public static void setChange(double d) {
        change = d;
    }
}