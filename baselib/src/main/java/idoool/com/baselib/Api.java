package idoool.com.baselib;

/**
 * @author: wangdeshun
 * @date: 2018/1/21  21:36
 * @description: 创建 Api 存放一些与 API 有关的东西,如请求地址,请求码等
 */

public interface Api {
    /**
     * isDebug true Debug测试模式
     */
    boolean isDebug = true;

    String REQUEST_SUCCESS = "1";
    /**
     * MainUrl
     */
    String MAIN_URL = "http://hzt.idoool.com/";
    /**
     * 登录
     */
    String LOGIN = "login";
    /**
     * 根据id查询新频道详情
     */
    String CHANNEL_DETAIL_BY_ID = "app/channeldetailbyid";
    /**
     * 根据频道ID和查询类型查询频道下的帖子列表
     */
    String POSTS_BY_CHANNEL_ID = "app/postsbychannelid";
    /**
     * 所有频道
     */
    String All_CHANNEL = "app/allchannels";
}
