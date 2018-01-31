package idoool.com.httplib;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.cookie.CookieJarImpl;
import com.lzy.okgo.cookie.store.DBCookieStore;
import com.lzy.okgo.interceptor.HttpLoggingInterceptor;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import idoool.com.baselib.Api;
import idoool.com.baselib.BaseApplication;
import okhttp3.OkHttpClient;

/**
 * @author: wangdeshun
 * @date: 2018/1/18  11:22
 * @description: 创建AppLib
 */

public class AppLib extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        initOkGo();
    }

    /**
     * 初始化网络请求
     */
    private void initOkGo() {
        //OkGo网络请求 网络请求的配置,未来https连接也用builder配置
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        //超时时间
        builder.readTimeout(20000, TimeUnit.MILLISECONDS);
        builder.writeTimeout(20000, TimeUnit.MILLISECONDS);
        builder.connectTimeout(20000, TimeUnit.MILLISECONDS);
        //使用数据库保持cookie，如果cookie不过期，则一直有效
        builder.cookieJar(new CookieJarImpl(new DBCookieStore(this)));

        //测试环境下查看log
        if (Api.isDebug) {
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor("OkGo");
            loggingInterceptor.setPrintLevel(HttpLoggingInterceptor.Level.BODY);
            loggingInterceptor.setColorLevel(Level.INFO);
            builder.addInterceptor(loggingInterceptor);
        }

        OkGo.getInstance().init(this).setOkHttpClient(builder.build());
        OkGo.getInstance().setRetryCount(0);
    }
}
