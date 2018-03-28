package idoool.com.httplib.base;

import idoool.com.baselib.bean.BaseJson;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * @author: WangDeShun
 * @date: 2018/3/22  10:33
 * @description: 创建 BaseObserver
 */

public abstract class BaseObserver<T> implements Observer<BaseJson<T>> {

    private IBaseView mView;
    private boolean isShowDialog;
    private String mRequestCode;

    protected BaseObserver(boolean isShowDialog, IBaseView view, String requestCode) {
        this.isShowDialog = isShowDialog;
        this.mView = view;
        this.mRequestCode = requestCode;
    }

    /**
     * 解析成功
     *
     * @param t
     */
    protected abstract void onHandleSuccess(T t);

    @Override
    public void onSubscribe(Disposable d) {
        mView.onRequestStart(isShowDialog);
    }

    @Override
    public void onNext(BaseJson<T> value) {
        if (value.isSuccess()) {
            T t = value.getData();
            onHandleSuccess(t);
        } else {
            onHandleError(value.getMsg());
        }
    }

    @Override
    public void onError(Throwable e) {
        mView.onError(mRequestCode, e.toString());
    }

    @Override
    public void onComplete() {
        mView.onFinish();
    }

    protected void onHandleError(String msg) {
        mView.onRequestFailed(mRequestCode, msg);
    }
}
