package idoool.com.httplib.presenter;

import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.LifecycleTransformer;
import com.trello.rxlifecycle2.android.ActivityEvent;

import idoool.com.baselib.BaseApplication;
import idoool.com.baselib.bean.BaseJson;
import idoool.com.baselib.utils.NetWorkUtil;
import idoool.com.httplib.base.IBaseView;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * @author pc wangdeshun
 * @Description BasePresenter Presenter基类
 * @date 2018/1/18 13:31
 * o(＞﹏＜)o
 */

public abstract class BasePresenter<T> {
    protected IBaseView mView;

    private LifecycleProvider<ActivityEvent> provider;

    public BasePresenter(IBaseView iBaseView, LifecycleProvider<ActivityEvent> provider) {
        this.provider = provider;
        this.mView = iBaseView;

    }

    /**
     * 无参数
     *
     * @param <T> 泛型
     * @return 返回Observable
     */
    protected <T> ObservableTransformer<T, T> switchSchedulers(IBaseView mView) {
        return upstream -> upstream
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .doOnSubscribe(disposable -> {
                    // 可添加网络连接判断等
                    if (!NetWorkUtil.isNetworkConnected(BaseApplication.getAppContext())) {
                        mView.onNoConnect();
                    }
                })
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .doFinally(() -> mView.onFinish());
    }
}
