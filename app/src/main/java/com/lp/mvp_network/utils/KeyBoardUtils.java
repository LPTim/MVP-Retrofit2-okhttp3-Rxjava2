package com.lp.mvp_network.utils;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import static android.content.Context.INPUT_METHOD_SERVICE;

/**
 * <pre>
 *  author : wyz
 *  e_mail : xxx@xx
 *  time  : 2017/06/${DYA}
 *  desc :
 *  version: 1.0
 * </pre>
 */

public class KeyBoardUtils {

    /**
     * 打开键盘
     **/
    public static void openKeybord(View v) {
        InputMethodManager imm = (InputMethodManager) v.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        if (!imm.isActive()) {
            imm.showSoftInput(v, InputMethodManager.SHOW_FORCED);
            imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    /**
     * 2. * 关闭软键盘
     * 3. *
     * 4. * @param v
     * 5.
     */
    public static void closeKeybord(View v) {
        InputMethodManager imm = (InputMethodManager) v.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm.isActive()) {
            imm.hideSoftInputFromWindow(v.getApplicationWindowToken(), 0);
        }
    }


    /**
     * 设置键盘显示与隐藏
     *
     * @param context
     * @param view
     * @param visible
     */
    public static boolean setIMM(Context context, View view, boolean visible) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (visible) {
            return imm.showSoftInput(view, InputMethodManager.SHOW_FORCED);
        } else {
            return imm.hideSoftInputFromWindow(view.getWindowToken(), 0);

        }
    }


    /**
     * des:隐藏软键盘,这种方式参数为activity
     * 但没有失去焦点
     *
     * @param activity
     */
    public static void hideInputForce(Activity activity) {
        if (activity == null || activity.getCurrentFocus() == null)
            return;

        ((InputMethodManager) activity.getSystemService(INPUT_METHOD_SERVICE))
                .hideSoftInputFromWindow(activity.getCurrentFocus()
                        .getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
    }

    /**
     * 打开软键盘
     * 魅族可能会有问题
     *
     * @param mEditText
     * @param mContext
     */
    public static void showInput(EditText mEditText, Context mContext) {
        InputMethodManager imm = (InputMethodManager) mContext.getSystemService(INPUT_METHOD_SERVICE);
        imm.showSoftInput(mEditText, InputMethodManager.RESULT_SHOWN);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);



    }

}
