package idoool.com.httplib.presenter;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.bind.DateTypeAdapter;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.request.GetRequest;
import com.lzy.okgo.request.PostRequest;

import java.util.Date;

import idoool.com.baselib.Api;
import idoool.com.baselib.BaseApplication;
import idoool.com.baselib.utils.NetWorkUtil;
import idoool.com.httplib.base.IBaseView;

/**
 * @author pc wangdeshun
 * @Description BasePresenter 请求基类
 * @date 2018/1/18 13:31
 * o(＞﹏＜)o
 */

public abstract class BasePresenter<T> {

    protected IBaseView mResult;
    protected Object mTag;
    public Gson mGson = null;

    public BasePresenter(IBaseView iNetResult, Object tag) {
        this.mResult = iNetResult;
        this.mTag = tag;
        if (mGson == null) {
            mGson = new GsonBuilder()
                    .setPrettyPrinting()
                    .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                    .registerTypeAdapter(Date.class, new DateTypeAdapter())
                    .create();
        }
    }

    /**
     * POST 请求
     *
     * @param url URL链接地址
     * @return
     */
    public GetRequest okGoGet(String url) {
        return OkGo.get(getUrl(url));
    }

    /**
     * POST 请求
     *
     * @param url URL链接地址
     * @return
     */
    public PostRequest okGoPost(String url) {
        return OkGo.post(getUrl(url));
    }

    private String getUrl(String url) {
        return Api.MAIN_URL + url;
    }

    /**
     * GET 请求
     *
     * @param getRequest  GET请求的实现类
     * @param requestCode 区分请求
     */
    public GetRequest getExecute(GetRequest getRequest, String requestCode) {
        return getExecute(getRequest, requestCode, true);
    }

    /**
     * POST 请求
     *
     * @param postRequest POST请求的实现类
     * @param requestCode 区分请求
     * @return
     */
    public PostRequest postExecute(PostRequest postRequest, String requestCode) {
        return postExecute(postRequest, requestCode, true);
    }

    /**
     * GET 请求
     *
     * @param getRequest   GET请求的实现类
     * @param requestCode  区分请求
     * @param isShowDialog 是否显示对话框
     * @return
     */
    public GetRequest getExecute(GetRequest getRequest, final String requestCode, final boolean isShowDialog) {
        // 判断网络状态
        if (!NetWorkUtil.isNetworkConnected(BaseApplication.getAppContext())) {
            if (getRequest.getCacheMode().equals(CacheMode.NO_CACHE)) {
                mResult.onNoConnect();
                return null;
            }
        }
        getRequest.tag(mTag);
//        getRequest.execute(new StringCallback() {
//            @Override
//            public void onSuccess(Response<String> response) {
//                String body = response.body();
//                if (!TextUtils.isEmpty(body)) {
//                    BaseJson commonResponse = mGson.fromJson(body, BaseJson.class);
//                    if ("1".equals(commonResponse.status)) {
////                        onRequestSuccess(response, requestCode);
//                    } else {
//                        mResult.onRequestFailed(requestCode, commonResponse.getMsg());
//                    }
//                }
//            }
//
//            @Override
//            public void onStart(Request request) {
//                mResult.onRequestStart(isShowDialog);
//            }
//
//            @Override
//            public void onCacheSuccess(Response<String> response) {
////                onRequestCacheSuccess((T) response.body(), requestCode);
//            }
//
//            @Override
//            public void onError(Response response) {
//                mResult.onError(requestCode, response);
//            }
//
//            @Override
//            public void onFinish() {
//                mResult.onFinish();
//            }
//
//            @Override
//            public void uploadProgress(Progress progress) {
//                mResult.uploadProgress(progress);
//            }
//
//            @Override
//            public void downloadProgress(Progress progress) {
//                mResult.downloadProgress(progress);
//            }
//
//
//        });
        return getRequest;
    }

    /**
     * POST 请求
     *
     * @param postRequest  POST请求的实现类
     * @param requestCode  区分请求
     * @param isShowDialog 是否显示对话框
     * @return
     */
    public PostRequest postExecute(PostRequest postRequest, final String requestCode, final boolean isShowDialog) {
        // 判断网络状态
        if (!NetWorkUtil.isNetworkConnected(BaseApplication.getAppContext())) {
            if (postRequest.getCacheMode().equals(CacheMode.NO_CACHE)) {
                mResult.onNoConnect();
                return null;
            }
        }
        postRequest.tag(mTag);
        return postRequest;
    }

}
