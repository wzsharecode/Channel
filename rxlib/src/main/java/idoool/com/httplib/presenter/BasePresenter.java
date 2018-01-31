package idoool.com.httplib.presenter;

import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.LifecycleTransformer;
import com.trello.rxlifecycle2.android.ActivityEvent;

import idoool.com.baselib.BaseApplication;
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

public abstract class BasePresenter {
    protected IBaseView mView;

    private LifecycleProvider<ActivityEvent> provider;

    public BasePresenter(IBaseView iBaseView, LifecycleProvider<ActivityEvent> provider) {
        this.provider = provider;
        this.mView = iBaseView;

    }

    public LifecycleProvider<ActivityEvent> getProvider() {
        return provider;
    }

    /**
     * 线程调度
     */
    protected <T> ObservableTransformer<T, T> compose(final LifecycleTransformer<T> lifecycle) {
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(Observable<T> observable) {
                return observable
                        .subscribeOn(Schedulers.io())
                        .doOnSubscribe(new Consumer<Disposable>() {
                            @Override
                            public void accept(Disposable disposable) throws Exception {
                                // 可添加网络连接判断等
                                if (!NetWorkUtil.isNetworkConnected(BaseApplication.getAppContext())) {
                                    mView.onNoConnect();
                                }
                            }
                        })
                        .observeOn(AndroidSchedulers.mainThread())
                        .compose(lifecycle)
                        .doFinally(new Action() {
                            @Override
                            public void run() throws Exception {
                                mView.onFinish();
                            }
                        });
            }
        };
    }

}
