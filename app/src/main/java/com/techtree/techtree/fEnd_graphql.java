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

public class fEnd_graphql extends AppCompatActivity {

    private TextView graphQl_textview;
    private SeekBar graphQl_seekbar;

    private SharedPreferences preferences;

    private static final String PROGRESS = "SEEKBAR19";

    public static double change = 0;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fend_graphql);

        graphQl_textview = findViewById(R.id.graphQlKnowledgeInt);
        graphQl_seekbar = findViewById(R.id.graphQl_knowledge);

        graphQl_seekbar.setProgressTintList(ColorStateList.valueOf(Color.parseColor("#03A9F4")));

        preferences = getSharedPreferences(" ", MODE_PRIVATE);

        final SharedPreferences.Editor editor_1 = preferences.edit();

        graphQl_seekbar.setProgress(preferences.getInt(PROGRESS,0));;

        graphQl_textview.setText(""+graphQl_seekbar.getProgress());

        change = graphQl_seekbar.getProgress();

        graphQl_seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int sb_change = 0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                sb_change = progress;
                change = progress;
                graphQl_textview.setText(""+sb_change);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                editor_1.putInt(PROGRESS, graphQl_seekbar.getProgress());
                editor_1.commit();

                change = graphQl_seekbar.getProgress();                      ////////////////////////////////////////////

            }
        });
    }
    public static double getData() {return change;}

    public static void setChange(double d) {
        change = d;
    }
}