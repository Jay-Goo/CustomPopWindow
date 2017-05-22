package jaygoo.widget.cpw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;

/**
 * ================================================
 * 作    者：JayGoo
 * 版    本：1.1.0
 * 创建日期：2017/5/22
 * 描    述:
 * ================================================
 */
public class ClickableTextView extends android.support.v7.widget.AppCompatTextView{
    private Paint mPaint;
    private int mHeight;
    private float mDivHeight;
    private int mDivColor;


    public ClickableTextView(Context context) {
        super(context);
        init();
    }

    public ClickableTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ClickableTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public ClickableTextView(Context context, String text){
        super(context);
        init();
        setText(text);
    }

    public ClickableTextView(Context context, String text,int textSize){
        super(context);
        init();
        setText(text);
        setTextSize(textSize);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawLine(0,getHeight() - mDivHeight,getWidth(),getHeight(),mPaint);
    }

    private void init(){

        // set default value
        mHeight = DensityUtils.dip2px(52,getContext());
        mDivHeight = DensityUtils.dip2px(3,getContext());
        mDivColor = Color.parseColor("#dedede");
        setTextSize(16);
        setTextColor(Color.parseColor("#333333"));
        setBackgroundColor(Color.WHITE);

        mPaint = new Paint();
        mPaint.setColor(mDivColor);
        mPaint.setAntiAlias(true);
        setGravity(Gravity.CENTER);
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(MATCH_PARENT,mHeight);
        setLayoutParams(params);
    }

    public void setHeight(int height){
        mHeight = height;
    }

    public void setDivHeight(float divHeight){
        mDivHeight = divHeight;
    }

    public void setDivColor(int divColor){
        mDivColor = divColor;
        if (mPaint != null){
            mPaint.setColor(mDivColor);
        }
    }




}
