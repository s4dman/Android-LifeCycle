package com.droidman.androidlifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    private static final String TAG = "SecondActivity";
    private TextView mCreate, mStart, mResume, mRestart;
    private Button mNextActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Log.d(TAG, "SecondActivity onCreate: ");
        init();
        mCreate.setText("Called when activity is first created");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "SecondActivity onStart: ");
        mStart.setText("Called when activity is becoming visible to the user.");
    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "SecondActivity onResume: ");
        mResume.setText("Called when activity will start interacting with the user.");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "SecondActivity onPause: Called when activity is not visible to the user.");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "SecondActivity onStop: Called when activity is no longer visible to the user.");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "SecondActivity onRestart: ");
        mRestart.setText("Activity Restarted from backstack OnBackButtonPress");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "SecondActivity onDestroy: User clicked back button and Called before the activity is destroyed.");
    }


    private void init() {
        mCreate = findViewById(R.id.text_called_create2);
        mStart = findViewById(R.id.text_called_start2);
        mResume = findViewById(R.id.text_called_resume2);
        mRestart = findViewById(R.id.text_called_restart2);
        mNextActivity = findViewById(R.id.btn_previous);

        onClick();
    }


    private void onClick() {
        mNextActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent prevActivity = new Intent(SecondActivity.this, FirstActivity.class);
                startActivity(prevActivity);
            }
        });
    }

}
