package idoool.com.httplib.base;

/**
 * @author: wangdeshun
 * @date: 2018/1/21  22:34
 * @description: 创建 IBaseView 基类接口
 */

public interface IBaseView<T> {

    /**
     * 无网络连接
     */
    void onNoConnect();

    /**
     * 请求网络开始前，UI线程
     * @param isShow
     */
    void onRequestStart(boolean isShow);

    /**
     * 上传过程中的进度回调，get请求不回调，UI线程
     * @param progress
     */
    void uploadProgress(Object progress);

    /**
     * 下载过程中的进度回调，UI线程
     * @param progress
     */
    void downloadProgress(Object progress);
    /**
     * 请求失败，响应错误，数据解析错误等，都会回调该方法， UI线程
     * @param requestCode
     * @param errorMessage
     */
    void onRequestFailed(Object requestCode, String errorMessage);

    /**
     * 请求网络无响应
     * @param requestCode
     * @param response
     */
    void onError(Object requestCode, Object response);

    /**
     * 请求网络结束后，UI线程
     */
    void onFinish();

    /**
     * 设置 presenter
     * @param presenter
     * @return
     */
    T setPresenter(T presenter);

}
