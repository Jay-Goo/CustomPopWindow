package jaygoo.widget.cpw;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.View;

/**
 * Created by JayGoo on 16/9/5.
 */
public class DensityUtils {

    public static int dip2px(float dip, Context ctx) {
        float density = ctx.getResources().getDisplayMetrics().density;
        int px = (int) (dip * density + 0.5f);
        return px;
    }

    public static float px2dip(int px, Context ctx) {
        float density = ctx.getResources().getDisplayMetrics().density;
        float dp = px / density;
        return dp;
    }

    /**
     * 将px值转换为sp值，保证文字大小不变
     *
     * @param pxValue
     *            （DisplayMetrics类中属性scaledDensity）
     * @return
     */
    public static int px2sp(float pxValue , Context context) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / fontScale + 0.5f);
    }

    /**
     * 将sp值转换为px值，保证文字大小不变
     *
     * @param spValue
     *            （DisplayMetrics类中属性scaledDensity）
     * @return
     */
    public static int sp2px(float spValue , Context context) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }
    public static DisplayMetrics getMetrics(Activity activity) {
        DisplayMetrics metric = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(metric);
        return metric;
    }

    /**
     * 屏幕宽度（像素）
     *
     * @param activity
     * @return
     */
    public static int getDeviceWith(Activity activity) {
        return getMetrics(activity).widthPixels;
    }

    /**
     * 屏幕高度（像素）
     *
     * @param activity
     * @return
     */
    public static int getDeviceHeight(Activity activity) {
        return getMetrics(activity).heightPixels;   // 屏幕高度（像素）
    }

    /**
     * 最全面的获取状态栏高度的方法
     * @param view
     * @return
     */
    public static int getStatusBarHeight(View view) {
        int statusBarHeight = 0;
        if (view == null)return 0;

        //尝试借助应用区域的top属性获取状态栏高度
        //此方式只有onWindowFocusChanged()回调后方会生效，onCreate中调用无效
        if (0 == statusBarHeight) {
            Rect rectangle = new Rect();
            view.getRootView().getWindowVisibleDisplayFrame(rectangle);
            statusBarHeight = rectangle.top;
        }

        statusBarHeight = getStatusBarHeight(view.getContext());
        return statusBarHeight;
    }

    /**
     * 通过系统资源和反射的方式获取状态栏高度
     * @param context
     * @return
     */
    public static int getStatusBarHeight(Context context) {
        int statusBarHeight = 0;

        //尝试通过系统尺寸资源获取状态栏高度
        try {
            //获取status_bar_height资源的ID
            int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
            //根据资源ID获取响应的尺寸值
            statusBarHeight = context.getResources().getDimensionPixelSize(resourceId);
        } catch (Exception e) {
            e.printStackTrace();
        }


        //尝试借助反射R类实例域方式获取状态栏高度
        if (0 == statusBarHeight){
            try {
                Class<?> clazz = Class.forName("com.android.internal.R$dimen");
                Object object = clazz.newInstance();
                int height = Integer.parseInt(clazz.getField("status_bar_height")
                        .get(object).toString());
                statusBarHeight = context.getResources().getDimensionPixelSize(height);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return statusBarHeight;
    }
}
