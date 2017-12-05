package com.design.mode;

import android.content.Intent;
import android.util.Log;

import com.common.activity.RecycleActivity;
import com.design.mode.sectionone.activity.FacebookActivity;

import java.util.Arrays;

public class MainActivity extends RecycleActivity {

     protected void handleClick(int position) {
        Intent intent = null;
        switch (position) {
            case 0:
                intent = new Intent(this, FacebookActivity.class);
                break;
            case 1:
//                intent = new Intent(this, EncloseActivity.class);
                doTest();
                break;
            case 2:
                break;
            case 3:
//                intent = new Intent(this, FrameActivity.class);
                break;
        }
        if (intent != null) {
            startActivity(intent);
        }

    }

     public void initData() {
        String[] array = getResources().getStringArray(R.array.main);
        mDatas = Arrays.asList(array);
        mAdapter.setDatas(mDatas);

    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.e("gao", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("gao", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("gao", "onDestroy");

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Log.e("gao", "onBackPressed");
    }

    private void doTest() {

    }

}
