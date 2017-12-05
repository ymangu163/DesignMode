package com.design.mode.sectionone.activity;

import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.KeyEvent;

import com.common.activity.RecycleActivity;
import com.common.receiver.HomeReceiver;
import com.common.utils.AppUtil;
import com.design.mode.R;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.share.model.AppInviteContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.AppInviteDialog;
import com.facebook.share.widget.ShareDialog;

import java.io.IOException;
import java.util.Arrays;

/**
 * Created by gao on 2017/9/27.
 */

public class FacebookActivity extends RecycleActivity {


    @Override
    protected void handleClick(int position) {
        Intent intent = null;
        switch (position) {
            case 0:
                shareFacebook();
                break;
            case 1:
               inviteFacebook();
//                intent = new Intent(this, ImageActivity.class);
                break;
            case 2:
                likeFacebook(FacebookActivity.this.getString(R.string.facebook_app_page));
                break;
            case 3:
                intent = new Intent(this, BillingActivity.class);
//
                try {
                    Runtime.getRuntime().exec("input keyevent " + KeyEvent.KEYCODE_BACK);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                break;

        }
        if (intent != null) {
            startActivity(intent);
        }

    }

    private void shareFacebook() {
        ShareDialog shareDialog = new ShareDialog(this);
        ShareLinkContent linkContent = new ShareLinkContent.Builder()
//                .setContentTitle(MasterUtil.getAppName(this))
                .setContentUrl(Uri.parse("https://play.google.com/store/apps/details?id=" + getPackageName()))
                .build();
        if (shareDialog.canShow(linkContent)) {
            shareDialog.show(linkContent);
        }
    }

    private void inviteFacebook() {
        AppInviteContent content = new AppInviteContent.Builder()
//                .setApplinkUrl("https://fb.me/1897497707237055" + "?referral=4324324" )
                .setApplinkUrl("https://fb.me/240673899792985?referral=2" )
                .build();
        AppInviteDialog.show(this, content);
    }

    private void likeFacebook(String url) {
        Intent intent;
        if (AppUtil.isAppInstalled(this, "com.facebook.katana")) {
            intent =  new Intent(Intent.ACTION_VIEW, Uri.parse("fb://facewebmodal/f?href=" + url));
        } else {
            intent =  new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        }
        startActivity(intent);
    }



    @Override
    public void initData() {
        AppEventsLogger.activateApp(this, "");

        String[] array = getResources().getStringArray(R.array.facebook_array);
        mDatas = Arrays.asList(array);
        mAdapter.setDatas(mDatas);
        HomeReceiver.regObserver(this, mHomeListener);
    }
    private HomeReceiver.IHomeListener mHomeListener = new HomeReceiver.IHomeListener() {
        @Override
        public void onHomePress() {
            Log.e("gao", "home press");
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        HomeReceiver.unRegObserver(this, mHomeListener);
    }
}
