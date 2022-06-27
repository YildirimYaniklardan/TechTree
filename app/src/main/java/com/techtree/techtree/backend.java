package com.techtree.techtree;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class backend extends AppCompatActivity {

    TextView backend_knowledge;

    public double [] know = new double[22];

    private double totalKnow = 0;

    int isCreate = 1;

    @Override
    protected void onStart() {

        backend_knowledge = findViewById(R.id.b_knowledge);


        know[0] = bEnd_Internet.getData();  //Internet knowledge
        know[1] = bEnd_Os.getData();        //os
        know[2] = bEnd_progLang.getData();  //programming lang.
        know[3] = bEnd_vcs.getData();       //version control systems
        know[4] = bEnd_databases.getData();  //database
        know[5] = bEnd_Rdatabases.getData();  //relational database
        know[6] = bEnd_noSqldatabases.getData();  //nosql database
        know[7] = bEnd_apis.getData();         //apis
        know[8] = bEnd_caching.getData();     //caching
        know[9] = bEnd_webSec.getData();      //web security
        know[10] = bEnd_testing.getData();    //testing
        know[11] = bEnd_cicd.getData();       //ci/cd
        know[12] = bEnd_desDev.getData();     //design and development
        know[13] = bEnd_patterns.getData();   //arc. patterns
        know[14] = bEnd_search.getData();     //search engines
        know[15] = bEnd_broker.getData();    //message brokers
        know[16] = bEnd_conVir.getData();    //contain./virtual.
        know[17] = bEnd_graphql.getData();   //graphql
        know[18] = bEnd_graphDat.getData();  //graph. database
        know[19] = bEnd_webSock.getData();   //websockets
        know[20] = bEnd_webServ.getData();   //web servers
        know[21] = bEnd_scale.getData();     //scalable backend

        totalKnow = 0;

        for(int i = 0; i < 22; i++){
            totalKnow += know[i];
        }

        totalKnow = totalKnow / 2.2;
        totalKnow = totalKnow*100;
        totalKnow = Math.round(totalKnow);
        totalKnow = totalKnow / 100;

        backend_knowledge.setText("%"+totalKnow);

        SharedPreferences sp2 = getSharedPreferences("key2", MODE_PRIVATE);
        SharedPreferences.Editor spEdit = sp2.edit();
        spEdit.putFloat("value2", Float.parseFloat(Double.toString(totalKnow)));
        spEdit.commit();

        if(isCreate == 0){
            backend_knowledge.setText("%"+totalKnow);
        }

        isCreate = 0;


        super.onStart();
    }

    @Override
    protected void onStop() {

        SharedPreferences sp = getSharedPreferences("key2", MODE_PRIVATE);
        SharedPreferences.Editor spEdit = sp.edit();
        spEdit.putFloat("value2", Float.parseFloat(Double.toString(totalKnow)));
        spEdit.commit();

        super.onStop();
    }

    @Override
    protected void onPause() {

        SharedPreferences sp = getSharedPreferences("key2", MODE_PRIVATE);
        SharedPreferences.Editor spEdit = sp.edit();
        spEdit.putFloat("value2", Float.parseFloat(Double.toString(totalKnow)));
        spEdit.commit();
        super.onPause();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_backend);

        backend_knowledge = findViewById(R.id.b_knowledge);

        SharedPreferences sp2 = getSharedPreferences("key2", MODE_PRIVATE);

        SharedPreferences temp = getSharedPreferences(" ", MODE_PRIVATE);                           ////////////////////////////////////

        know[0] = temp.getInt("SEEKBAR43",0);               //Internet knowledge
        know[1] = temp.getInt("SEEKBAR25",0);           //os
        know[2] = temp.getInt("SEEKBAR26",0);           //programming lang.
        know[3] = temp.getInt("SEEKBAR44",0);          //version control systems
        know[4] = temp.getInt("SEEKBAR27",0);          //database
        know[5] = temp.getInt("SEEKBAR28",0);           //relational database
        know[6] = temp.getInt("SEEKBAR29",0);              //nosql database
        know[7] = temp.getInt("SEEKBAR30",0);            //apis
        know[8] = temp.getInt("SEEKBAR31",0);           //caching
        know[9] = temp.getInt("SEEKBAR45",0);           //web security
        know[10] = temp.getInt("SEEKBAR32",0);           //testing
        know[11] = temp.getInt("SEEKBAR33",0);           //ci/cd
        know[12] = temp.getInt("SEEKBAR34",0);           //design and development
        know[13] = temp.getInt("SEEKBAR35",0);           //arc. patterns
        know[14] = temp.getInt("SEEKBAR36",0);           //search engines
        know[15] = temp.getInt("SEEKBAR37",0);          //message brokers
        know[16] = temp.getInt("SEEKBAR38",0);          //contain./virtual.
        know[17] = temp.getInt("SEEKBAR46",0);          //graphql
        know[18] = temp.getInt("SEEKBAR39",0);          //graph. database
        know[19] = temp.getInt("SEEKBAR40",0);          //websockets
        know[20] = temp.getInt("SEEKBAR41",0);          //web servers
        know[21] = temp.getInt("SEEKBAR42",0);          //scalable backend

        bEnd_Internet.setChange(know[0]);
        bEnd_Os.setChange(know[1]);
        bEnd_progLang.setChange(know[2]);
        bEnd_vcs.setChange(know[3]);
        bEnd_databases.setChange(know[4]);
        bEnd_Rdatabases.setChange(know[5]);
        bEnd_noSqldatabases.setChange(know[6]);
        bEnd_apis.setChange(know[7]);
        bEnd_caching.setChange(know[8]);
        bEnd_webSec.setChange(know[9]);
        bEnd_testing.setChange(know[10]);
        bEnd_cicd.setChange(know[11]);
        bEnd_desDev.setChange(know[12]);
        bEnd_patterns.setChange(know[13]);
        bEnd_search.setChange(know[14]);
        bEnd_broker.setChange(know[15]);
        bEnd_conVir.setChange(know[16]);
        bEnd_graphql.setChange(know[17]);
        bEnd_graphDat.setChange(know[18]);
        bEnd_webSock.setChange(know[19]);
        bEnd_webServ.setChange(know[20]);
        bEnd_scale.setChange(know[21]);

        if(isCreate == 1){
            backend_knowledge.setText("%"+sp2.getFloat("value", 0));
        }

        Button[] buttons = new Button[24];
        buttons[0] = (Button) findViewById(R.id.bEnd1);
        buttons[1] = (Button) findViewById(R.id.bEnd2);
        buttons[2] = (Button) findViewById(R.id.bEnd3);
        buttons[3] = (Button) findViewById(R.id.bEnd4);
        buttons[4] = (Button) findViewById(R.id.bEnd5);
        buttons[5] = (Button) findViewById(R.id.bEnd6);
        buttons[6] = (Button) findViewById(R.id.bEnd7);
        buttons[7] = (Button) findViewById(R.id.bEnd8);
        buttons[8] = (Button) findViewById(R.id.bEnd9);
        buttons[9] = (Button) findViewById(R.id.bEnd10);
        buttons[10] = (Button) findViewById(R.id.bEnd11);
        buttons[11] = (Button) findViewById(R.id.bEnd12);
        buttons[12] = (Button) findViewById(R.id.bEnd13);
        buttons[13] = (Button) findViewById(R.id.bEnd14);
        buttons[14] = (Button) findViewById(R.id.bEnd15);
        buttons[15] = (Button) findViewById(R.id.bEnd16);
        buttons[16] = (Button) findViewById(R.id.bEnd17);
        buttons[17] = (Button) findViewById(R.id.bEnd18);
        buttons[18] = (Button) findViewById(R.id.bEnd19);
        buttons[19] = (Button) findViewById(R.id.bEnd20);
        buttons[20] = (Button) findViewById(R.id.bEnd21);
        buttons[21] = (Button) findViewById(R.id.bEnd22);
        buttons[22] = (Button) findViewById(R.id.bEnd0);

        buttons[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), bEnd_Internet.class);
                startActivityForResult(myIntent,0);
            }
        });

        buttons[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), bEnd_Os.class);
                startActivityForResult(myIntent,0);
            }
        });

        buttons[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), bEnd_progLang.class);
                startActivityForResult(myIntent,0);
            }
        });

        buttons[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), bEnd_vcs.class);
                startActivityForResult(myIntent,0);
            }
        });

        buttons[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), bEnd_databases.class);
                startActivityForResult(myIntent,0);
            }
        });

        buttons[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), bEnd_Rdatabases.class);
                startActivityForResult(myIntent,0);
            }
        });

        buttons[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), bEnd_noSqldatabases.class);
                startActivityForResult(myIntent,0);
            }
        });

        buttons[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), bEnd_apis.class);
                startActivityForResult(myIntent,0);
            }
        });

        buttons[8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), bEnd_caching.class);
                startActivityForResult(myIntent,0);
            }
        });

        buttons[9].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), bEnd_webSec.class);
                startActivityForResult(myIntent,0);
            }
        });

        buttons[10].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), bEnd_testing.class);
                startActivityForResult(myIntent,0);
            }
        });

        buttons[11].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), bEnd_cicd.class);
                startActivityForResult(myIntent,0);
            }
        });

        buttons[12].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), bEnd_desDev.class);
                startActivityForResult(myIntent,0);
            }
        });

        buttons[13].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), bEnd_patterns.class);
                startActivityForResult(myIntent,0);
            }
        });

        buttons[14].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), bEnd_search.class);
                startActivityForResult(myIntent,0);
            }
        });

        buttons[15].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), bEnd_broker.class);
                startActivityForResult(myIntent,0);
            }
        });

        buttons[16].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), bEnd_conVir.class);
                startActivityForResult(myIntent,0);
            }
        });

        buttons[17].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), bEnd_graphql.class);
                startActivityForResult(myIntent,0);
            }
        });

        buttons[18].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), bEnd_graphDat.class);
                startActivityForResult(myIntent,0);
            }
        });

        buttons[19].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), bEnd_webSock.class);
                startActivityForResult(myIntent,0);
            }
        });

        buttons[20].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), bEnd_webServ.class);
                startActivityForResult(myIntent,0);
            }
        });

        buttons[21].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), bEnd_scale.class);
                startActivityForResult(myIntent,0);
            }
        });

        buttons[22].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), bEnd_whatIs.class);
                startActivityForResult(myIntent,0);
            }
        });
    }
}