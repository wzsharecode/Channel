package idoool.com.channel.adapter.viewholder;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;
import butterknife.ButterKnife;
import butterknife.InjectView;
import idoool.com.baselib.bean.ChannelListType;
import idoool.com.channel.R;

/**
 * @author: wangdeshun
 * @date: 2018/1/23  23:39
 * @description: 创建 PostsViewHolder 帖子
 */

public class PostsViewHolder extends RecyclerView.ViewHolder {

    @InjectView(R.id.iv_head)
    ImageView mIvHead;
    @InjectView(R.id.tv_title)
    TextView mTvTitle;
    @InjectView(R.id.tv_vip)
    TextView mTvVip;
    @InjectView(R.id.iv_more)
    ImageView mIvMore;

    public PostsViewHolder(View v) {
        super(v);
        ButterKnife.inject(this, v);
    }

    public void bindView(Activity activity, List<ChannelListType.ListBean> list, int position) {

        //TODO 数据
        mTvTitle.setText(list.get(position).getContentType() + "PostsViewHolder");

    }
}