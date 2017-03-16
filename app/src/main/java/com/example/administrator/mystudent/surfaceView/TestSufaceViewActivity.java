package com.example.administrator.mystudent.surfaceView;

import android.graphics.PixelFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.administrator.mystudent.R;

public class TestSufaceViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TestSufaceView sfv=new TestSufaceView(this);

        setContentView(sfv);
    }
}
