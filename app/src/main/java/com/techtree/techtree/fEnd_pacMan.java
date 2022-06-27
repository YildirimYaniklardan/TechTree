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

public class fEnd_pacMan extends AppCompatActivity {

    private TextView pacMan_textview;
    private SeekBar pacMan_seekbar;

    private SharedPreferences preferences;

    private static final String PROGRESS = "SEEKBAR7";

    public static double change = 0;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fend_pac_man);

        pacMan_textview = findViewById(R.id.pmKnowledgeInt);
        pacMan_seekbar = findViewById(R.id.pm_knowledge);

        pacMan_seekbar.setProgressTintList(ColorStateList.valueOf(Color.parseColor("#03A9F4")));

        preferences = getSharedPreferences(" ", MODE_PRIVATE);

        final SharedPreferences.Editor editor_1 = preferences.edit();

        pacMan_seekbar.setProgress(preferences.getInt(PROGRESS,0));;

        pacMan_textview.setText(""+pacMan_seekbar.getProgress());

        change = pacMan_seekbar.getProgress();

        pacMan_seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int sb_change = 0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                sb_change = progress;
                change = progress;
                pacMan_textview.setText(""+sb_change);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                editor_1.putInt(PROGRESS, pacMan_seekbar.getProgress());
                editor_1.commit();

                change = pacMan_seekbar.getProgress();                      ////////////////////////////////////////////

            }
        });
    }
    public static double getData() {return change;}

    public static void setChange(double d) {
        change = d;
    }
}