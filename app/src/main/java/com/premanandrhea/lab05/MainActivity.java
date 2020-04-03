package com.premanandrhea.lab05;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.admin.FreezePeriod;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView c1, s1, r1, p1, st1, rs1, d1;
    TextView c2, s2, r2, p2, st2, rs2, d2;
    int c, s, r, p, st, rs, d;
    SharedPreferences.Editor editor;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        c=s=r=p=st=rs=d=0;

        sharedPreferences=getSharedPreferences("Setting", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.apply();

        c1=findViewById(R.id.create1);
        s1=findViewById(R.id.start1);
        r1=findViewById(R.id.resume1);
        p1=findViewById(R.id.pause1);
        st1=findViewById(R.id.stop1);
        rs1=findViewById(R.id.restart1);
        d1=findViewById(R.id.destroy1);

        c2=findViewById(R.id.create2);
        s2=findViewById(R.id.start2);
        r2=findViewById(R.id.resume2);
        p2=findViewById(R.id.pause2);
        st2=findViewById(R.id.stop2);
        rs2=findViewById(R.id.restart2);
        d2=findViewById(R.id.destroy2);

        p2.setText("onPause(): " + sharedPreferences.getInt("pause", 0));
        st2.setText("onStop(): " + sharedPreferences.getInt("stop", 0));
        rs2.setText(("onRestart(): " + sharedPreferences.getInt("restart", 0)));
        d2.setText("onDestroy(): " + sharedPreferences.getInt("des", 0));

        c+=1;
        c1.setText("onCreate(): " + c);

        int value = sharedPreferences.getInt("create", 0);
        int cc = value + c;
        editor.putInt("create", cc);
        editor.apply();
        c2.setText("onCreate(): " + cc);

    }
    protected void onStart(){
        super.onStart();
        s+=1;
        s1.setText("onStart(): " + s);

        int value = sharedPreferences.getInt("start", 0);
        int cs = value + s;
        editor.putInt("start", cs);
        editor.apply();
        s2.setText("onStart(): " + cs);
    }
    protected void onResume(){
        super.onResume();
        r+=1;
        r1.setText("onResume(): " + r);

        int value = sharedPreferences.getInt("res", 0);
        int cr = value + r;
        editor.putInt("res", cr);
        editor.apply();
        r2.setText("onResume(): " + cr);
    }
    protected void onPause(){
        super.onPause();
        p+=1;
        p1.setText("onPause(): " + p);

        int value = sharedPreferences.getInt("pause", 0);
        int c = value + p;
        editor.putInt("pause", c);
        editor.apply();
        p2.setText("onPause(): " + c);
    }
    protected void onStop(){
        super.onStop();
        st+=1;
        st1.setText("onStop(): " + st);

        int value = sharedPreferences.getInt("stop", 0);
        int c = value + st;
        editor.putInt("stop", c);
        editor.apply();
        st2.setText("onStop(): " + c);
    }
    protected void onRestart(){
        super.onRestart();
        rs+=1;
        rs1.setText("onRestart(): " + rs);

        int value = sharedPreferences.getInt("restart", 0);
        int c = value + rs;
        editor.putInt("restart", c);
        editor.apply();
        rs2.setText("onRestart(): " + c);
    }
    protected void onDestroy(){
        super.onDestroy();
        d+=1;
        d1.setText("onDestroy(): " + d);

        int value = sharedPreferences.getInt("des", 0);
        int c = value + d;
        editor.putInt("des", c);
        editor.apply();
        d2.setText("onDestroy(): " + c);
    }
}
