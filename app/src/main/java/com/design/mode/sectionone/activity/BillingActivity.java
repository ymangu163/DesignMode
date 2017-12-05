package com.design.mode.sectionone.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.design.mode.R;

/**
 * Created by gao on 2017/10/9.
 */

public class BillingActivity extends AppCompatActivity {

    private TextView billTv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_billing);
        billTv = (TextView) findViewById(R.id.bill_tv);
        showPolicy();

    }

    public void showPolicy() {
        String policyStr = getString(R.string.privacy_policy_line);
        SpannableStringBuilder spannable = new SpannableStringBuilder(policyStr);
        int startIndex = policyStr.indexOf("Privacy");
        spannable.setSpan(new TextClick(), policyStr.length() - 14, policyStr.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannable.setSpan(new UnderlineSpan(), startIndex, policyStr.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannable.setSpan(new ForegroundColorSpan(ContextCompat.getColor(this, R.color.black)),
                0, policyStr.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        billTv.setMovementMethod(LinkMovementMethod.getInstance());
        billTv.setText(spannable);
    }

    private class TextClick extends ClickableSpan {
        @Override
        public void onClick(View widget) {
            Toast.makeText(getApplication(), "dksjfkdjfk", Toast.LENGTH_SHORT).show();
        }
    }
}
