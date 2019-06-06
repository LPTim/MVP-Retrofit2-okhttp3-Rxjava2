package com.lp.mvp_network.view;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.TextView;

import com.lp.mvp_network.R;


/**
 * File descripition:   简单菊花框
 *
 * @author lp
 * @date 2019/4/10
 */

public class LoadingDialog extends Dialog {
    private TextView mTvText;

    public LoadingDialog(Context context) {
        super(context);
        try {
            Context contexts = this.getContext();
            int dividerID = contexts.getResources().getIdentifier("android:id/titleDivider", null, null);
            View divider = this.findViewById(dividerID);
            if (divider != null) {
                divider.setBackgroundColor(Color.TRANSPARENT);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setContentView(R.layout.dialog_loading);
        mTvText = findViewById(R.id.tv_text);
        setCanceledOnTouchOutside(false);
    }

    public LoadingDialog setMessage(String message) {
        mTvText.setText(message);
        return this;
    }
}
