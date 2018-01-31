package idoool.com.channel.adapter.viewholder;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import idoool.com.baselib.BaseApplication;
import idoool.com.baselib.bean.ChannelListType;
import idoool.com.channel.R;
import idoool.com.channel.utils.GlideUtil;
import idoool.com.channel.utils.ToastUtils;

/**
 * @author: wangdeshun
 * @date: 2018/1/24  14:05
 * @description: 创建 RecommendViewHolder 推荐频道
 */

public class RecommendViewHolder extends RecyclerView.ViewHolder {

    @InjectView(R.id.iv_head)
    ImageView mIvHead;
    @InjectView(R.id.tv_title)
    TextView mTvTitle;
    @InjectView(R.id.iv_play_video)
    ImageView mIvPlayVideo;
    @InjectView(R.id.tv_vip)
    TextView mTvVip;
    @InjectView(R.id.iv_more)
    ImageView mIvMore;

    public RecommendViewHolder(View v) {
        super(v);
        ButterKnife.inject(this, v);
    }

    public void bindView(Activity activity, List<ChannelListType.ListBean> list, int position) {
        //TODO 数据
//        mTvTitle.setText(list.get(position).getPost().getChannel().getTitle() + "RecommendViewHolder");
        mTvTitle.setText(list.get(position).getContentType() + "RecommendViewHolder");
        GlideUtil.load(BaseApplication.getAppContext(), "http://hzt.idoool.com/upload/small/f1e1543017e150b75b81492373994331.small.jpeg", mIvPlayVideo);

        mIvPlayVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.showShort("play video");
            }
        });

        mIvMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.showShort("more");
            }
        });

    }
}