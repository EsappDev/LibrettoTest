package com.esappdev.librettotest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    FirebaseAnalytics mFirebaseAnalytics;
    FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        mFirebaseAuth = FirebaseAuth.getInstance();

        //Check the buildType and activate/deactivate the Analytics
        if (BuildConfig.DEBUG) {
            mFirebaseAnalytics.setAnalyticsCollectionEnabled(false);
            Log.d(TAG, "Starting Analytics collection");
        }

        if (mFirebaseAuth.getCurrentUser() == null) {
            //User is not logged in, redirecting to Login page.
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
            finish();
        }
    }
}