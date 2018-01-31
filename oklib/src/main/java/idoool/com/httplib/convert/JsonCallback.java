package idoool.com.httplib.convert;

import com.lzy.okgo.callback.AbsCallback;
import com.lzy.okgo.model.Progress;
import com.lzy.okgo.request.base.Request;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import idoool.com.httplib.base.IBaseView;
import okhttp3.Response;

/**
 * @author: wangdeshun
 * @date: 2018/1/27  10:40
 * @description: 创建 JsonCallback
 */

public abstract class JsonCallback<T> extends AbsCallback<T> {
    private Type type;
    private Class<T> clazz;
    private IBaseView mView;
    private boolean isShowDialog;
    private String mRequestCode;

    public JsonCallback(boolean isShowDialog, IBaseView view, String requestCode) {
        this.isShowDialog = isShowDialog;
        this.mView = view;
        this.mRequestCode = requestCode;
    }

    @Override
    public void onStart(Request<T, ? extends Request> request) {
        mView.onRequestStart(isShowDialog);
        super.onStart(request);
        // 主要用于在所有请求之前添加公共的请求头或请求参数
        // 例如登录授权的 token headers
        // 使用的设备信息
        // 可以随意添加,也可以什么都不传
        // 还可以在这里对所有的参数进行加密，均在这里实现

    }

    @Override
    public void onCacheSuccess(com.lzy.okgo.model.Response<T> response) {
        onSuccess(response);
        super.onCacheSuccess(response);
    }

    @Override
    public void onError(com.lzy.okgo.model.Response response) {
        mView.onError(mRequestCode, response);
    }

    @Override
    public void onFinish() {
        mView.onFinish();
    }

    @Override
    public void uploadProgress(Progress progress) {
        mView.uploadProgress(progress);
    }

    @Override
    public void downloadProgress(Progress progress) {
        mView.downloadProgress(progress);
    }

    /**
     * 该方法是子线程处理，不能做ui相关的工作
     * 主要作用是解析网络返回的 response 对象,生产onSuccess回调中需要的数据对象
     */
    @Override
    public T convertResponse(Response response) throws Throwable {

        if (type == null) {
            if (clazz == null) {
                Type genType = getClass().getGenericSuperclass();
                type = ((ParameterizedType) genType).getActualTypeArguments()[0];
            } else {
                JsonConvert<T> convert = new JsonConvert<>(clazz);
                return convert.convertResponse(response);
            }
        }

        JsonConvert<T> convert = new JsonConvert<>(type);
        return convert.convertResponse(response);
    }
}