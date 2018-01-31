package idoool.com.baselib;

import android.app.Application;
import android.content.Context;

/**
 * @author: wangdeshun
 * @date: 2018/1/19  12:33
 * @description: 创建BaseApplication
 */

public class BaseApplication extends Application {

    protected static Context AppContext;

    public static Context getAppContext() {
        return AppContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        AppContext = getApplicationContext();
    }
}
