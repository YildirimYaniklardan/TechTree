package com.techtree.techtree;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class frontend extends AppCompatActivity {

    TextView frontend_knowledge;

    public double [] know = new double[23];

    private double totalKnow = 0;

    int isCreate = 1;

    @Override
    protected void onStart() {

        frontend_knowledge = findViewById(R.id.f_knowledge);

        know[0] = fEnd_Internet.getData();   //Internet knowledge
        know[1] = fEnd_html.getData();      //HTML knowledge
        know[2] = fEnd_css.getData();       //CSS knowledge
        know[3] = fEnd_javascript.getData();  //JS
        know[4] = fEnd_vcs.getData();         //VCS
        know[5] = fEnd_webSec.getData();   //Web Security
        know[6] = fEnd_pacMan.getData();   //Package Managers
        know[7] = fEnd_cssArc.getData();   //CSS Archit.
        know[8] = fEnd_cssPre.getData();   //CSS Preprocess.
        know[9] = fEnd_build.getData();    //Build Tools
        know[10] = fEnd_frameworks.getData();   //Frameworks
        know[11] = fEnd_modCss.getData();     //Modern CSS
        know[12] = fEnd_webComp.getData(); //Web Component
        know[13] = fEnd_cssFrame.getData();  //CSS Frame.
        know[14] = fEnd_testApp.getData();   //Testing the app
        know[15] = fEnd_typeCheck.getData(); //Type checkers
        know[16] = fEnd_pwa.getData();       //Progressive web apps
        know[17] = fEnd_ssr.getData();       //Server side rendering
        know[18] = fEnd_graphql.getData();   //GraphQL
        know[19] = fEnd_staSiteGen.getData();  //Static site gen.
        know[20] = fEnd_mobileApps.getData();   //Mobile Apps
        know[21] = fEnd_desktopApps.getData();  //Desktop Apps
        know[22] = fEnd_webAssembly.getData();   //Web Assembly

        totalKnow = 0;

        for(int i = 0; i < 23; i++){
            totalKnow += know[i];
        }

        totalKnow = totalKnow / 2.3;
        totalKnow = totalKnow*100;
        totalKnow = Math.round(totalKnow);
        totalKnow = totalKnow / 100;

        SharedPreferences sp2 = getSharedPreferences("key", MODE_PRIVATE);
        SharedPreferences.Editor spEdit = sp2.edit();
        spEdit.putFloat("value", Float.parseFloat(Double.toString(totalKnow)));
        spEdit.commit();

        if(isCreate == 0){
            frontend_knowledge.setText("%"+totalKnow);
        }

        isCreate = 0;

        super.onStart();
    }

    @Override
    protected void onStop() {

        SharedPreferences sp = getSharedPreferences("key", MODE_PRIVATE);
        SharedPreferences.Editor spEdit = sp.edit();
        spEdit.putFloat("value", Float.parseFloat(Double.toString(totalKnow)));
        spEdit.commit();

        super.onStop();
    }

    @Override
    protected void onPause() {

        SharedPreferences sp = getSharedPreferences("key", MODE_PRIVATE);
        SharedPreferences.Editor spEdit = sp.edit();
        spEdit.putFloat("value", Float.parseFloat(Double.toString(totalKnow)));
        spEdit.commit();
        super.onPause();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frontend);

        frontend_knowledge = findViewById(R.id.f_knowledge);

        SharedPreferences sp2 = getSharedPreferences("key", MODE_PRIVATE);

        SharedPreferences temp = getSharedPreferences(" ", MODE_PRIVATE);                           ////////////////////////////////////

        know[0] = temp.getInt("SEEKBAR1",0);
        know[1] = temp.getInt("SEEKBAR2",0);
        know[2] = temp.getInt("SEEKBAR3",0);
        know[3] = temp.getInt("SEEKBAR4",0);
        know[4] = temp.getInt("SEEKBAR5",0);
        know[5] = temp.getInt("SEEKBAR6",0);
        know[6] = temp.getInt("SEEKBAR7",0);
        know[7] = temp.getInt("SEEKBAR8",0);
        know[8] = temp.getInt("SEEKBAR9",0);
        know[9] = temp.getInt("SEEKBAR10",0);
        know[10] = temp.getInt("SEEKBAR11",0);
        know[11] = temp.getInt("SEEKBAR12",0);
        know[12] = temp.getInt("SEEKBAR13",0);
        know[13] = temp.getInt("SEEKBAR14",0);
        know[14] = temp.getInt("SEEKBAR15",0);
        know[15] = temp.getInt("SEEKBAR16",0);
        know[16] = temp.getInt("SEEKBAR17",0);
        know[17] = temp.getInt("SEEKBAR18",0);
        know[18] = temp.getInt("SEEKBAR19",0);
        know[19] = temp.getInt("SEEKBAR20",0);
        know[20] = temp.getInt("SEEKBAR21",0);
        know[21] = temp.getInt("SEEKBAR22",0);
        know[22] = temp.getInt("SEEKBAR23",0);

        fEnd_Internet.setChange(know[0]);
        fEnd_html.setChange(know[1]);
        fEnd_css.setChange(know[2]);
        fEnd_javascript.setChange(know[3]);
        fEnd_vcs.setChange(know[4]);
        fEnd_webSec.setChange(know[5]);
        fEnd_pacMan.setChange(know[6]);
        fEnd_cssArc.setChange(know[7]);
        fEnd_cssPre.setChange(know[8]);
        fEnd_build.setChange(know[9]);
        fEnd_frameworks.setChange(know[10]);
        fEnd_modCss.setChange(know[11]);
        fEnd_webComp.setChange(know[12]);
        fEnd_cssFrame.setChange(know[13]);
        fEnd_testApp.setChange(know[14]);
        fEnd_typeCheck.setChange(know[15]);
        fEnd_pwa.setChange(know[16]);
        fEnd_ssr.setChange(know[17]);
        fEnd_graphql.setChange(know[18]);
        fEnd_staSiteGen.setChange(know[19]);
        fEnd_mobileApps.setChange(know[20]);
        fEnd_desktopApps.setChange(know[21]);
        fEnd_webAssembly.setChange(know[22]);

        if(isCreate == 1){
            frontend_knowledge.setText("%"+sp2.getFloat("value", 0));
        }

        Button [] buttons = new Button[24];
        buttons[0] = (Button) findViewById(R.id.fEnd1);
        buttons[1] = (Button) findViewById(R.id.fEnd2);
        buttons[2] = (Button) findViewById(R.id.fEnd3);
        buttons[3] = (Button) findViewById(R.id.fEnd4);
        buttons[4] = (Button) findViewById(R.id.fEnd5);
        buttons[5] = (Button) findViewById(R.id.fEnd6);
        buttons[6] = (Button) findViewById(R.id.fEnd7);
        buttons[7] = (Button) findViewById(R.id.fEnd8);
        buttons[8] = (Button) findViewById(R.id.fEnd9);
        buttons[9] = (Button) findViewById(R.id.fEnd10);
        buttons[10] = (Button) findViewById(R.id.fEnd11);
        buttons[11] = (Button) findViewById(R.id.fEnd12);
        buttons[12] = (Button) findViewById(R.id.fEnd13);
        buttons[13] = (Button) findViewById(R.id.fEnd14);
        buttons[14] = (Button) findViewById(R.id.fEnd15);
        buttons[15] = (Button) findViewById(R.id.fEnd16);
        buttons[16] = (Button) findViewById(R.id.fEnd17);
        buttons[17] = (Button) findViewById(R.id.fEnd18);
        buttons[18] = (Button) findViewById(R.id.fEnd19);
        buttons[19] = (Button) findViewById(R.id.fEnd20);
        buttons[20] = (Button) findViewById(R.id.fEnd21);
        buttons[21] = (Button) findViewById(R.id.fEnd22);
        buttons[22] = (Button) findViewById(R.id.fEnd23);
        buttons[23] = (Button) findViewById(R.id.fEnd0);

        buttons[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), fEnd_Internet.class);
                startActivityForResult(myIntent,0);
            }
        });

        buttons[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), fEnd_html.class);
                startActivityForResult(myIntent,0);
            }
        });

        buttons[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), fEnd_css.class);
                startActivityForResult(myIntent,0);
            }
        });

        buttons[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), fEnd_javascript.class);
                startActivityForResult(myIntent,0);
            }
        });

        buttons[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), fEnd_vcs.class);
                startActivityForResult(myIntent,0);
            }
        });

        buttons[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), fEnd_webSec.class);
                startActivityForResult(myIntent,0);
            }

        });

        buttons[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), fEnd_pacMan.class);
                startActivityForResult(myIntent,0);
            }
        });

        buttons[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), fEnd_cssArc.class);
                startActivityForResult(myIntent,0);
            }
        });

        buttons[8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), fEnd_cssPre.class);
                startActivityForResult(myIntent,0);
            }
        });

        buttons[9].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), fEnd_build.class);
                startActivityForResult(myIntent,0);
            }
        });

        buttons[10].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), fEnd_frameworks.class);
                startActivityForResult(myIntent,0);
            }
        });

        buttons[11].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), fEnd_modCss.class);
                startActivityForResult(myIntent,0);
            }
        });

        buttons[12].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), fEnd_webComp.class);
                startActivityForResult(myIntent,0);
            }
        });

        buttons[13].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), fEnd_cssFrame.class);
                startActivityForResult(myIntent,0);
            }
        });

        buttons[14].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), fEnd_testApp.class);
                startActivityForResult(myIntent,0);
            }
        });

        buttons[15].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), fEnd_typeCheck.class);
                startActivityForResult(myIntent,0);
            }
        });

        buttons[16].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), fEnd_pwa.class);
                startActivityForResult(myIntent,0);
            }
        });

        buttons[17].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), fEnd_ssr.class);
                startActivityForResult(myIntent,0);
            }
        });

        buttons[18].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), fEnd_graphql.class);
                startActivityForResult(myIntent,0);
            }
        });

        buttons[19].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), fEnd_staSiteGen.class);
                startActivityForResult(myIntent,0);
            }
        });

        buttons[20].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), fEnd_mobileApps.class);
                startActivityForResult(myIntent,0);
            }
        });

        buttons[21].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), fEnd_desktopApps.class);
                startActivityForResult(myIntent,0);
            }
        });

        buttons[22].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), fEnd_webAssembly.class);
                startActivityForResult(myIntent,0);
            }
        });

        buttons[23].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), fEnd_whatIs.class);
                startActivityForResult(myIntent,0);
            }
        });
    }
}