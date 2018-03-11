package idoool.com.httplib.presenter;

import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.android.ActivityEvent;
import idoool.com.baselib.bean.BaseJson;
import idoool.com.baselib.bean.ChannelDetails;
import idoool.com.baselib.bean.ChannelListType;
import idoool.com.httplib.base.BaseObserver;
import idoool.com.httplib.net.RetrofitFactory;
import idoool.com.httplib.view.IChannelDetails;

/**
 * @author: wangdeshun
 * @date: 2018/1/22  11:29
 * @description: 创建 ChannelDetailsPresenter 频道详情P层
 */

public class ChannelDetailsPresenter extends BasePresenter implements IChannelDetails.Presenter {

    private IChannelDetails.View mView;

    public ChannelDetailsPresenter(IChannelDetails.View view, LifecycleProvider<ActivityEvent> provider) {
        super(view, provider);
        this.mView = view;
    }

    /**
     * 根据id查询新频道详情
     *
     * @param channel   频道
     * @param channelId 频道ID
     */
    @Override
    public void channelDetailById(String channel, String channelId) {
        addSubscribe(RetrofitFactory.getInstance().channelDetailById(channel, channelId))
                .subscribe(new BaseObserver<ChannelDetails>(true, mView, "channelDetailById") {
                    @Override
                    protected void onHandleSuccess(ChannelDetails bean) {
                        if (null == bean) {
                            return;
                        }
                        mView.changeData(bean);
                    }
                });

    }

    /**
     * 根据频道ID和查询类型查询频道下的帖子列表
     *
     * @param channel
     * @param channelId 频道ID
     * @param queryType 查询类型（1：最新，2：最热，3：精选）
     * @param limit     取多少条
     * @param offset    偏移量
     */
    @Override
    public void postsByChannelId(String channel, String channelId, int queryType, int limit, int offset) {
        addSubscribe(RetrofitFactory.getInstance().postsByChannelId(channel, channelId, queryType, limit))
                .subscribe(new BaseObserver<ChannelListType>(true, mView, "postsByChannelId") {
                    @Override
                    protected void onHandleSuccess(ChannelListType bean) {
                        if (null == bean) {
                            return;
                        }
                        mView.setAdapter(bean.getList());
                    }

                });

    }

}
