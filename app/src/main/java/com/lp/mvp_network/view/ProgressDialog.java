package com.lp.mvp_network.view;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;

import com.gastudio.downloadloadding.library.GADownloadingView;
import com.lp.mvp_network.R;

/**
 * File descripition:
 *
 * @author lp
 * @date 2019/8/8
 */
public class ProgressDialog extends Dialog {
    private GADownloadingView mProgressBar;

    public ProgressDialog(Context context) {
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
        setContentView(R.layout.progress_uptade);
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        mProgressBar = findViewById(R.id.ga_downloading);
        mProgressBar.performAnimation();
    }

    public GADownloadingView getProgressBar() {
        return mProgressBar;
    }


    public ProgressDialog updateProgress(int progress) {
        mProgressBar.updateProgress(progress);
        return this;
    }
}
