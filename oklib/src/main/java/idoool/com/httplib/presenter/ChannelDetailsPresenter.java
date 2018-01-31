package idoool.com.httplib.presenter;

import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.model.HttpParams;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.GetRequest;

import java.util.ArrayList;
import java.util.List;

import idoool.com.baselib.Api;
import idoool.com.baselib.bean.ChannelDetails;
import idoool.com.baselib.bean.ChannelListType;
import idoool.com.httplib.convert.JsonCallback;
import idoool.com.httplib.view.IChannelDetails;

/**
 * @author: wangdeshun
 * @date: 2018/1/22  11:29
 * @description: 创建 ChannelDetailsPresenter 频道详情P层
 */

public class ChannelDetailsPresenter extends BasePresenter implements IChannelDetails.Presenter {

    private IChannelDetails.View mView;

    public ChannelDetailsPresenter(IChannelDetails.View view, Object tag) {
        super(view, tag);
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

        HttpParams params = new HttpParams();
        params.put("channelId", channelId);
        params.put("channel", channel);

        GetRequest getRequest = okGoGet(Api.CHANNEL_DETAIL_BY_ID);
        getRequest.params(params).cacheMode(CacheMode.NO_CACHE);
        getRequest.execute(new JsonCallback<ChannelDetails>(true, mView, "channelDetailById") {
            @Override
            public void onSuccess(Response<ChannelDetails> response) {
                ChannelDetails bean = response.body();
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

        HttpParams params = new HttpParams();
        params.put("channelId", channelId);
        params.put("queryType", queryType);
        params.put("limit", limit);
        params.put("channel", channel);
        GetRequest getRequest = okGoGet(Api.POSTS_BY_CHANNEL_ID);
        getRequest.params(params).cacheMode(CacheMode.NO_CACHE);
        getRequest.execute(new JsonCallback<ChannelListType>(false, mView, "postsByChannelId") {
            @Override
            public void onSuccess(Response<ChannelListType> response) {
                ChannelListType bean = response.body();
                if (null == bean) {
                    return;
                }
                //TODO
                List<ChannelListType.ListBean> list = new ArrayList<>();
                for (int i = 0; i < 10; i++) {
                    list.add(new ChannelListType.ListBean());
                }
                mView.setAdapter(list);
            }
        });
    }

}
