package jaygoo.widget.cpw;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

/**
 * ================================================
 * 作    者：JayGoo
 * 版    本：1.0.0
 * 创建日期：2017/5/22
 * 描    述: 纯代码生成opWindow
 * ================================================
 */
public class CustomPopWindow {

    private PopupWindow mPopupWindow;
    private Builder mBuilder;
    private LinearLayout popView;

    private CustomPopWindow(Builder builder){
        mBuilder = builder;
        initPopWindow();
    }

    private void initPopWindow() {
        if (mBuilder.mActivity == null)return;
        popView = new LinearLayout(mBuilder.mActivity);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        popView.setLayoutParams(params);
        popView.setOrientation(LinearLayout.VERTICAL);

        mPopupWindow = new PopupWindow(popView, WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        mPopupWindow.setAnimationStyle(mBuilder.animationStyle == 0 ? R.style.popwindow_anim_style : mBuilder.animationStyle);
        mPopupWindow.setBackgroundDrawable(new ColorDrawable(0x00000000));
        mPopupWindow.setInputMethodMode(PopupWindow.INPUT_METHOD_NEEDED);
        mPopupWindow.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        mPopupWindow.setFocusable(true); // 设置PopupWindow可获得焦点
        mPopupWindow.setTouchable(true); // 设置PopupWindow可触摸
        mPopupWindow.setOutsideTouchable(true); // 设置非PopupWindow区域可触摸
        mPopupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                backgroundAlpha(1f);
            }
        });
    }

    public CustomPopWindow addItem(final View ctv){
        if (popView != null) {
            popView.addView(ctv);
        }
        return this;
    }

    public CustomPopWindow addItem(final View ctv, final OnPopItemClickListener listener){
        if (popView != null) {
            popView.addView(ctv);
            ctv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dismiss();
                    if (listener != null) {
                        listener.onClick(ctv);
                    }
                }
            });
        }
        return this;
    }

    public CustomPopWindow addDivider(int color,float dp){
        if (mBuilder.mActivity == null || popView == null)return this;
        DividerView dividerView = new DividerView(mBuilder.mActivity.getApplicationContext(),color,dp);
        popView.addView(dividerView);
        return this;
    }

    public CustomPopWindow addDivider(int color){
        return addDivider(color,0.5f);
    }


    public View getContentView(){
        return popView;
    }

    public CustomPopWindow setBackgroundColor(int color){
        if (popView != null){
            popView.setBackgroundColor(color);
        }
        return this;
    }

    public CustomPopWindow setOutsideTouchable(boolean isOutsideTouchable){
        if (mPopupWindow != null) {
            mPopupWindow.setOutsideTouchable(isOutsideTouchable);
        }
        return this;
    }

    public void show(View showLocationView){
        if (mPopupWindow != null) {
            mPopupWindow.showAtLocation(showLocationView, Gravity.BOTTOM, 0, 0);
            backgroundAlpha(0.8f);
        }
    }

    public void dismiss(){
        try {
            mPopupWindow.dismiss();
        }catch (NullPointerException e){
            e.printStackTrace();
        }
    }

    /**
     * set background alpha
     * @param alpha
     */
    public void backgroundAlpha(float alpha) {
        try {
            WindowManager.LayoutParams lp = mBuilder.mActivity.getWindow().getAttributes();
            lp.alpha = alpha; //0.0-1.0
            mBuilder.mActivity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
            mBuilder.mActivity.getWindow().setAttributes(lp);

        }catch (RuntimeException e){
            e.printStackTrace();
        }

    }

    public static class Builder{
        private Activity mActivity;
        private int animationStyle;

        public void setAnimationStyle(int animationStyle) {
            this.animationStyle = animationStyle;
        }

        public Builder(Activity activity){
            this.mActivity = activity;
        }

        public CustomPopWindow build(){
            return new CustomPopWindow(this);
        }
    }

}
