package com.design.mode.sectionone.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.design.mode.MainActivity;
import com.facebook.FacebookSdk;

import bolts.AppLinks;

public class InviteFromFacebookActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }

    @Override
    protected void onResume() {
        super.onResume();
        FacebookSdk.sdkInitialize(this);
        Uri targetUrl = AppLinks.getTargetUrlFromInboundIntent(this, getIntent());
        Log.d("gao", "facebook_invite " + targetUrl.toString());
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
