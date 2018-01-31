package idoool.com.httplib.net;

import android.util.Log;

import com.franmontiel.persistentcookiejar.ClearableCookieJar;
import com.franmontiel.persistentcookiejar.PersistentCookieJar;
import com.franmontiel.persistentcookiejar.cache.SetCookieCache;
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import idoool.com.baselib.Api;
import idoool.com.baselib.BaseApplication;
import idoool.com.baselib.bean.Login;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitFactory {

    private static final long TIMEOUT = 30;

    /**
     * Retrofit是基于OkHttpClient的，可以创建一个OkHttpClient进行一些配置
     */
    private static OkHttpClient httpClient = new OkHttpClient.Builder()
            .addInterceptor(new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
                @Override
                public void log(String message) {
                    Log.v("rx", message);

                }
            }).setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
            //使用数据库保持cookie，如果cookie不过期，则一直有效
            .cookieJar(new PersistentCookieJar(new SetCookieCache(), new SharedPrefsCookiePersistor(BaseApplication.getAppContext())))
            .readTimeout(TIMEOUT, TimeUnit.SECONDS)
            .build();


    private static RetrofitService retrofitService = new Retrofit.Builder()
            .baseUrl(Api.MAIN_URL)
            // 添加Gson转换器
            .addConverterFactory(GsonConverterFactory.create(buildGson()))
            // 添加Retrofit到RxJava的转换器
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(httpClient)
            .build()
            .create(RetrofitService.class);

    public static RetrofitService getInstance() {
        return retrofitService;
    }

    private static Gson buildGson() {
        return new GsonBuilder()
                .serializeNulls()
                .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
                .create();
    }
}
