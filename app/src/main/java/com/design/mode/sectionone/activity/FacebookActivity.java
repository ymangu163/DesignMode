package com.design.mode.sectionone.activity;

import android.content.Intent;
import android.net.Uri;

import com.common.activity.RecycleActivity;
import com.common.utils.AppUtil;
import com.design.mode.R;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.share.model.AppInviteContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.AppInviteDialog;
import com.facebook.share.widget.ShareDialog;

import java.util.Arrays;

/**
 * Created by gao on 2017/9/27.
 */

public class FacebookActivity extends RecycleActivity {


    @Override
    protected void handleClick(int position) {
        switch (position) {
            case 0:
                shareFacebook();
                break;
            case 1:
               inviteFacebook();
                break;
            case 2:
                likeFacebook(FacebookActivity.this.getString(R.string.facebook_app_page));
                break;
            case 3:
//                intent = new Intent(this, FrameActivity.class);
                break;



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
                .setApplinkUrl("https://fb.me/1897497707237055" + "?referral=4324324" )
                .build();
        AppInviteDialog.show(this, content);
    }

    private void likeFacebook(String fbId) {
        Intent intent;
        if (AppUtil.isAppInstalled(this, "com.facebook.katana")) {
            intent =  new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/" + fbId));
        } else {
            intent =  new Intent(Intent.ACTION_VIEW, Uri.parse("https://m.facebook.com/" + fbId));
        }
        startActivity(intent);
    }



    @Override
    public void initData() {
        AppEventsLogger.activateApp(this, "");

        String[] array = getResources().getStringArray(R.array.facebook_array);
        mDatas = Arrays.asList(array);
        mAdapter.setDatas(mDatas);
    }
}
