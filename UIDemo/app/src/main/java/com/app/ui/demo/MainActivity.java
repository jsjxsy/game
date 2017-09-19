package com.app.ui.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.app.ui.demo.util.JumpingBeans;

public class MainActivity extends AppCompatActivity {
    private JumpingBeans jumpingTextView;
    private TextView mContentView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContentView = (TextView) findViewById(R.id.id_text_view);
        jumpingTextView = JumpingBeans.with(mContentView)
                .makeTextJump(0, mContentView.getText().length())
                .setIsWave(true)
                .setLoopDuration(1000)
                .setWavePerCharDelay(100)
                .build();
    }

    @Override
    protected void onPause() {
        super.onPause();
        jumpingTextView.stopJumping();
    }
}
