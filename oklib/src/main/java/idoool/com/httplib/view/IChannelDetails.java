package idoool.com.httplib.view;

import java.util.List;
import idoool.com.baselib.bean.ChannelDetails;
import idoool.com.baselib.bean.ChannelListType;
import idoool.com.httplib.base.IBasePresenter;
import idoool.com.httplib.base.IBaseView;

/**
 * @author: wangdeshun
 * @date: 2018/1/22  11:31
 * @description: 创建 IChannelDetails
 */

public interface IChannelDetails {

    interface View extends IBaseView<Presenter> {

        /**
         * 更新UI
         *
         * @param bean 更新数据
         */
        void changeData(ChannelDetails bean);

        /**
         * 更新适配器数据
         *
         * @param list 列表数据
         */
        void setAdapter(List<ChannelListType.ListBean> list);

    }

    interface Presenter extends IBasePresenter {

        /**
         * 根据id查询新频道详情
         *
         * @param channel   频道
         * @param channelId
         */
        void channelDetailById(String channel, String channelId);

        /**
         * 根据频道ID和查询类型查询频道下的帖子列表
         *
         * @param channel   频道
         * @param channelId 频道ID
         * @param queryType 查询类型（1：最新，2：最热，3：精选）
         * @param limit     取多少条
         * @param offset    偏移量
         */
        void postsByChannelId(String channel, String channelId, int queryType, int limit, int offset);

    }
}
