package com.design.mode.sectionone.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.common.utils.GlideUtil;
import com.design.mode.R;

/**
 * File description
 *
 * @author gao
 * @date 2017/11/30
 */

public class ImageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        ImageView glideImg = findViewById(R.id.glide_iv);
        String url = "http://ggimg.tapas.net/prod/upload/adunion/images/05b/796_416_59536d82e0c5e0ca.jpeg";
        GlideUtil.displayImage(this, url, glideImg, R.drawable.com_facebook_auth_dialog_cancel_background, DiskCacheStrategy.ALL);

        glideImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ImageActivity.this, ImageActivity2.class));
            }
        });

    }

}
