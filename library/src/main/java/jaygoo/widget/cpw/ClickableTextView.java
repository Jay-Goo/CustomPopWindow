package jaygoo.widget.cpw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;
import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

/**
 * ================================================
 * 作    者：JayGoo
 * 版    本：1.0.0
 * 创建日期：2017/5/22
 * 描    述: item，目前根据TextView改写，也可以使用自己设计的View
 * ================================================
 */
public class ClickableTextView extends android.support.v7.widget.AppCompatTextView{
    private int mHeight;

    private ClickableTextView(Context context) {
        super(context);
        init();
    }

    private ClickableTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private ClickableTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public ClickableTextView(Context context, String text){
        super(context);
        init();
        setText(text);
    }

    public ClickableTextView(Context context, String text,int textColor){
        super(context);
        init();
        setText(text);
        setTextColor(textColor);
    }

    public ClickableTextView(Context context, String text,float textSize){
        super(context);
        init();
        setText(text);
        setTextSize(textSize);
    }

    public ClickableTextView(Context context, String text,int textSize,int textColor){
        super(context);
        init();
        setText(text);
        setTextSize(textSize);
        setTextColor(textColor);
    }

    public ClickableTextView(Context context, String text,int textSize,float dpHeight){
        super(context);
        init();
        setText(text);
        setTextSize(textSize);
        mHeight = DensityUtils.dip2px(dpHeight,getContext());
    }

    public ClickableTextView(Context context, String text,int textSize,float dpHeight,int textColor){
        super(context);
        init();
        setText(text);
        setTextSize(textSize);
        setTextColor(textColor);
        mHeight = DensityUtils.dip2px(dpHeight,getContext());
    }

    private void init(){

        // set default value
        mHeight = DensityUtils.dip2px(52,getContext());

        setTextSize(16);
        setTextColor(Color.parseColor("#333333"));
        setBackgroundColor(Color.WHITE);
        setGravity(Gravity.CENTER);

        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(MATCH_PARENT,mHeight);
        setLayoutParams(params);

    }


    public void setHeight(int height){
        mHeight = DensityUtils.dip2px(height,getContext());
        ViewGroup.LayoutParams params = getLayoutParams();
        if (params != null) {
            params.height = mHeight;
            setLayoutParams(params);
        }
    }

    public void setPadding(float dp){
        int padding = DensityUtils.dip2px(dp,getContext());
        setPadding(padding,padding,padding,padding);
    }

    public boolean setWrapContent(){
        ViewGroup.LayoutParams params = getLayoutParams();
        if (params != null){
            params.height = ViewGroup.LayoutParams.WRAP_CONTENT;
            setLayoutParams(params);
            return true;
        }
        return false;
    }


}
