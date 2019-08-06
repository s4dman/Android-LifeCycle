package com.droidman.androidlifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FirstActivity extends AppCompatActivity {
    private static final String TAG = "FirstActivity";
    private TextView mCreate, mStart, mResume, mRestart;
    private Button mNextActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        Log.d(TAG, "FirstActivity onCreate: ");
        mCreate.setText("Called when activity is first created");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "FirstActivity onStart: ");
        mStart.setText("Called when activity is becoming visible to the user.");
    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "FirstActivity onResume: ");
        mResume.setText("Called when activity will start interacting with the user.");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "FirstActivity onPause: Called when activity is not visible to the user.");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "FirstActivity onStop: Called when activity is no longer visible to the user.");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "FirstActivity onRestart: User clicked back button");
        mRestart.setText("Activity Restarted from backstack OnBackButtonPress");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "FirstActivity onDestroy: User clicked back button and Called before the activity is destroyed.");
    }


    private void init() {
        mCreate = findViewById(R.id.text_called_create);
        mStart = findViewById(R.id.text_called_start);
        mResume = findViewById(R.id.text_called_resume);
        mRestart = findViewById(R.id.text_called_restart);
        mNextActivity = findViewById(R.id.btn_next);

        onClick();
    }


    private void onClick() {
        mNextActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextActivity = new Intent(FirstActivity.this, SecondActivity.class);
                startActivity(nextActivity);
            }
        });
    }

}
