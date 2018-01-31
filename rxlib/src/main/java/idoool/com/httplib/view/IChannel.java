package idoool.com.httplib.view;
import java.util.List;

import idoool.com.baselib.bean.ChannelList;
import idoool.com.httplib.base.IBasePresenter;
import idoool.com.httplib.base.IBaseView;

/**
 * @author: wangdeshun
 * @date: 2018/1/22  12:38
 * @description: 创建 IChannel
 */

public interface IChannel {

    interface View extends IBaseView<Presenter> {

        /**
         * 请求数据
         *
         * @param list 更新列表数据
         */
        void setAdapter(List<ChannelList.ListBean> list);

    }

    interface Presenter extends IBasePresenter {

        /**
         * 获取所有的频道列表
         */
        void getAllChannel();

    }
}
