package idoool.com.httplib.presenter;

import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.GetRequest;

import idoool.com.baselib.Api;
import idoool.com.baselib.bean.ChannelList;
import idoool.com.httplib.convert.JsonCallback;
import idoool.com.httplib.view.IChannel;

/**
 * @author: wangdeshun
 * @date: 2018/1/18  12:00
 * @description: 创建 ChannelPresenter
 */

public class ChannelPresenter extends BasePresenter implements IChannel.Presenter {

    private IChannel.View mView;

    public ChannelPresenter(IChannel.View view, Object tag) {
        super(view, tag);
        this.mView = view;
    }

    @Override
    public void getAllChannel() {

        GetRequest getRequest = okGoGet(Api.All_CHANNEL);
        getRequest.cacheKey("getAllChannel").cacheMode(CacheMode.REQUEST_FAILED_READ_CACHE);
        getRequest.execute(new JsonCallback<ChannelList>(true, mView, "getAllChannel") {
            @Override
            public void onSuccess(Response<ChannelList> response) {
                // 保存用户信息
                ChannelList channelList = response.body();
                if (null == channelList) {
                    return;
                }
                mView.setAdapter(channelList.getList());
            }
        });

    }
}
