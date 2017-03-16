package com.example.administrator.mystudent.UIMould;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.administrator.mystudent.R;

public class UIMouldActivity extends AppCompatActivity {
    private TopBar myTopBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uimould);

        myTopBar= (TopBar) findViewById(R.id.myTopBar);
        myTopBar.setOnTopBarListener(new TopBar.OnTopBarListener() {
            @Override
            public void leftClick() {
                Toast.makeText(UIMouldActivity.this,"你按了左边按钮",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void rightClick() {

                Toast.makeText(UIMouldActivity.this,"你按了右边按钮",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
