package idoool.com.httplib.net;

import idoool.com.baselib.Api;
import idoool.com.baselib.bean.BaseJson;
import idoool.com.baselib.bean.ChannelDetails;
import idoool.com.baselib.bean.ChannelList;
import idoool.com.baselib.bean.ChannelListType;
import idoool.com.baselib.bean.Login;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * @author: wangdeshun
 * @date: 2018/1/31  20:36
 * @description: 创建 RetrofitService
 */

public interface RetrofitService {

    /**
     * 登录
     *
     * @param name
     * @param password
     * @return
     */
    @POST(Api.LOGIN)
    Observable<BaseJson<Login>> login(@Query("phone") String name, @Query("password") String password);

    /**
     * 频道列表
     *
     * @return
     */
    @GET(Api.All_CHANNEL)
    Observable<BaseJson<ChannelList>> getAllChannel();

    /**
     * 根据id查询新频道详情
     *
     * @param channel   频道
     * @param channelId 频道ID
     * @return
     */
    @GET(Api.CHANNEL_DETAIL_BY_ID)
    Observable<BaseJson<ChannelDetails>> channelDetailById(@Query("channel") String channel, @Query("channelId") String channelId);

    /**
     * 根据频道ID和查询类型查询频道下的帖子列表
     *
     * @param channel   频道
     * @param channelId 频道ID
     * @param queryType 查询类型（1：最新，2：最热，3：精选）
     * @param limit     取多少条
     * @return
     */
    @GET(Api.POSTS_BY_CHANNEL_ID)
    Observable<BaseJson<ChannelListType>> postsByChannelId(@Query("channel") String channel, @Query("channelId") String channelId, @Query("queryType") int queryType, @Query("limit") int limit);
}
