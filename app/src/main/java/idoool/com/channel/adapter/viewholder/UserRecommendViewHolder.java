package idoool.com.channel.adapter.viewholder;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import idoool.com.channel.R;
import idoool.com.channel.utils.GlideUtil;
import idoool.com.channel.utils.ToastUtils;
import idoool.com.baselib.BaseApplication;
import idoool.com.baselib.bean.ChannelListType;

/**
 * @author: wangdeshun
 * @date: 2018/1/24  14:06
 * @description: 创建 UserRecommendViewHolder  用户推荐
 */

public class UserRecommendViewHolder extends RecyclerView.ViewHolder {

    @InjectView(R.id.iv_head)
    ImageView mIvHead;
    @InjectView(R.id.tv_title)
    TextView mTvTitle;
    @InjectView(R.id.tv_vip)
    TextView mTvVip;
    @InjectView(R.id.iv_more)
    ImageView mIvMore;
    @InjectView(R.id.iv_pic)
    ImageView mIvPic;

    public UserRecommendViewHolder(View v) {
        super(v);
        ButterKnife.inject(this, v);
    }

    public void bindView(Activity activity, List<ChannelListType.ListBean> list, int position) {
        //TODO 数据
        mTvTitle.setText(list.get(position).getContentType() +" UserRecommendViewHolder");
        GlideUtil.load(BaseApplication.getAppContext(), "http://static.idoool.com/upload/medium/c47b25ba339f997a79cd610905509538.medium.jpeg", mIvPic);

        mIvPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.showShort("picture");
            }
        });
    }
}