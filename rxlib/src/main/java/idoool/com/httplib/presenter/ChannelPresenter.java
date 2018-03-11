package idoool.com.httplib.presenter;

import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.android.ActivityEvent;
import idoool.com.baselib.bean.BaseJson;
import idoool.com.baselib.bean.ChannelList;
import idoool.com.httplib.base.BaseObserver;
import idoool.com.httplib.net.RetrofitFactory;
import idoool.com.httplib.view.IChannel;

/**
 * @author: wangdeshun
 * @date: 2018/1/18  12:00
 * @description: 创建 ChannelPresenter
 */

public class ChannelPresenter extends BasePresenter implements IChannel.Presenter {

    private IChannel.View mView;

    public ChannelPresenter(IChannel.View view, LifecycleProvider<ActivityEvent> provider) {
        super(view, provider);
        this.mView = view;
    }

    @Override
    public void getAllChannel() {
        addSubscribe(RetrofitFactory.getInstance().getAllChannel())
                .subscribe(new BaseObserver<ChannelList>(true, mView, "getAllChannel") {
                    @Override
                    protected void onHandleSuccess(ChannelList bean) {
                        if (null == bean) {
                            return;
                        }
                        mView.setAdapter(bean.getList());
                    }
                });

    }
}
