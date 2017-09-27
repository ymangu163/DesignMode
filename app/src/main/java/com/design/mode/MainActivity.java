package com.design.mode;

import android.content.Intent;

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
                break;
            case 2:
//                intent = new Intent(this, CustomActivity.class);
                break;
            case 3:
//                intent = new Intent(this, FrameActivity.class);
                break;



        }
        startActivity(intent);

    }

     public void initData() {
        String[] array = getResources().getStringArray(R.array.main);
        mDatas = Arrays.asList(array);
        mAdapter.setDatas(mDatas);
    }




}
