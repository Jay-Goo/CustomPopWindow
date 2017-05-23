package jaygoo.widget.cpw;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * ================================================
 * 作    者：JayGoo
 * 版    本：1.1.0
 * 创建日期：2017/5/23
 * 描    述:分割线
 * ================================================
 */
public class DividerView extends View {

    private DividerView(Context context) {
        super(context);
    }

    public DividerView(Context context,int color,float heightDp){
        super(context);
        setBackgroundColor(color);
        int h = DensityUtils.dip2px(heightDp,getContext());
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,h);
        setLayoutParams(params);
    }

    public DividerView(Context context,int color,float heightDp,int leftMargin,int rightMargin){
        super(context);
        setBackgroundColor(color);
        int h = DensityUtils.dip2px(heightDp,getContext());
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,h);
        params.leftMargin = leftMargin;
        params.rightMargin = rightMargin;
        setLayoutParams(params);
    }
}
