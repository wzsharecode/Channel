package idoool.com.baselib.utils;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author: wangdeshun
 * @date: 2018/1/22  14:26
 * @description: 创建 BarTextColorUtils
 */

public class BarTextColorUtils {
    /**
     * @param status 是否需要變成透明底黑字體
     */
    public static int StatusBarLightMode(Activity activity, boolean status) {
        int result = 0;
        //这个方法只支持4.0以上系统
        if (status) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                //判断是不是小米系统
                if (MIUISetStatusBarLightMode(activity.getWindow(), true)) {
                    result = 1;
                    //判断是不是魅族系统
                } else if (FlymeSetStatusBarLightMode(activity.getWindow(), true)) {
                    result = 2;
                    //判断当前是不是6.0以上的系统
                } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    activity.getWindow()
                            .getDecorView()
                            .setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                                    | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
                    result = 3;
                } else {
                    //如果以上都不符合就只能加个半透明的背景色了
                    result = 4;
                    setTranslucentForCoordinatorLayout(activity, 70);
                }
            }
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                //判断是不是小米系统
                if (MIUISetStatusBarLightMode(activity.getWindow(), false)) {
                    result = 1;
                    //判断是不是魅族系统
                } else if (FlymeSetStatusBarLightMode(activity.getWindow(), false)) {
                    result = 2;
                    //判断当前是不是6.0以上的系统
                } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    activity.getWindow()
                            .getDecorView()
                            .setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                                    | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
                    result = 3;
                } else {
                    //如果以上都不符合就只能加个半透明的背景色了
                    result = 4;
                    setTranslucentForCoordinatorLayout(activity, 70);
                }
            }
        }

        return result;
    }

    /**
     * 获取状态通知栏高度
     */
    public static int getStatusBarHeight(Activity activity) {
        Rect frame = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(frame);
        return frame.top;
    }

    /**
     * 修改状态栏为全透明
     */
    @TargetApi(19)
    public static void transparencyBar(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            //5.0+系统应用布局内容扩充到状态栏，状态栏透明
            Window window = activity.getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
                    | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            window.getDecorView()
                    .setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
            //          window.setNavigationBarColor(Color.TRANSPARENT);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //4.4系统应用布局内容扩充到状态栏，状态栏透明
            Window window = activity.getWindow();
            window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN);

            window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
    }

    /**
     * 修改状态栏为白色
     */
    @TargetApi(19)
    public static void colorBar(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            //5.0+系统应用布局内容扩充到状态栏，状态栏透明
            Window window = activity.getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
                    | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            window.getDecorView()
                    .setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.WHITE);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = activity.getWindow();
            window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN);

            window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            //创建状态栏的管理实例
            SystemBarTintManager tintManager = new SystemBarTintManager(activity);
            // 激活状态栏设置
            tintManager.setStatusBarTintEnabled(true);
            // 设置一个颜色给系统栏
            tintManager.setTintColor(Color.parseColor("#FFFFFF"));
        }
    }

    /**
     * 带有透明颜色的状态栏
     * @param activity
     * @param statusBarAlpha
     */
    public static void setTranslucentForCoordinatorLayout(Activity activity, int statusBarAlpha) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
            return;
        }
        //先将状态栏设置为完全透明
        transparentStatusBar(activity);
    }

    /**
     * 使状态栏透明
     */
    @TargetApi(Build.VERSION_CODES.KITKAT)
    public static void transparentStatusBar(
            Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            activity.getWindow()
                    .addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            activity.getWindow().setStatusBarColor(Color.TRANSPARENT);
            // 创建状态栏的管理实例
            SystemBarTintManager tintManager = new SystemBarTintManager(activity);
            // 激活状态栏设置
            tintManager.setStatusBarTintEnabled(true);
            tintManager.setTintColor(Color.parseColor("#45000000"));
        } else {
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            // 创建状态栏的管理实例
            SystemBarTintManager tintManager = new SystemBarTintManager(activity);
            // 激活状态栏设置
            tintManager.setStatusBarTintEnabled(true);
            // 设置一个颜色给系统栏
            tintManager.setTintColor(Color.parseColor("#45000000"));
        }
    }

    /**
     * 添加半透明矩形条
     *
     * @param activity       需要设置的 activity
     * @param statusBarAlpha 透明值
     */
    private static void addTranslucentView(Activity activity, int statusBarAlpha) {
        //ViewGroup contentView = (ViewGroup) activity.findViewById(android.R.id.content);
        //if (contentView.getChildCount() > 1) {
        //    contentView.getChildAt(1).setBackgroundColor(Color.argb(statusBarAlpha, 0, 0, 0));
        //} else {
        //    contentView.addView(createTranslucentStatusBarView(activity, statusBarAlpha));
        //}
    }

    /**
     * 获取状态栏高度
     *
     * @param context context
     * @return 状态栏高度
     */
    private static int getStatusBarHeight(Context context) {
        // 获得状态栏高度
        int resourceId =
                context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        return context.getResources().getDimensionPixelSize(resourceId);
    }

    /**
     * 修改小米手机系统的
     */
    public static boolean MIUISetStatusBarLightMode(Window window, boolean dark) {
        boolean result = false;
        if (window != null) {
            Class clazz = window.getClass();
            try {
                int darkModeFlag = 0;
                Class layoutParams = Class.forName("android.view.MiuiWindowManager$LayoutParams");
                Field field = layoutParams.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE");
                darkModeFlag = field.getInt(layoutParams);
                Method extraFlagField = clazz.getMethod("setExtraFlags", int.class, int.class);
                if (dark) {
                    //状态栏透明且黑色字体
                    extraFlagField.invoke(window, darkModeFlag, darkModeFlag);
                } else {
                    //清除黑色字体
                    extraFlagField.invoke(window, 0, darkModeFlag);
                }
                result = true;
            } catch (Exception e) {

            }
        }
        return result;
    }

    /**
     * 魅族手机修改该字体颜色
     */
    public static boolean FlymeSetStatusBarLightMode(Window window, boolean dark) {
        boolean result = false;
        if (window != null) {
            try {
                WindowManager.LayoutParams lp = window.getAttributes();
                Field darkFlag = WindowManager.LayoutParams.class.getDeclaredField(
                        "MEIZU_FLAG_DARK_STATUS_BAR_ICON");
                Field meizuFlags = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
                darkFlag.setAccessible(true);
                meizuFlags.setAccessible(true);
                int bit = darkFlag.getInt(null);
                int value = meizuFlags.getInt(lp);
                if (dark) {
                    value |= bit;
                } else {
                    value &= ~bit;
                }
                meizuFlags.setInt(lp, value);
                window.setAttributes(lp);
                result = true;
            } catch (Exception e) {

            }
        }
        return result;
    }
}
