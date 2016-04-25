package com.snow.night.quikeindex;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    private QuikIndexBar quikIndexBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        quikIndexBar = (QuikIndexBar) findViewById(R.id.quikindex);


    }
}
