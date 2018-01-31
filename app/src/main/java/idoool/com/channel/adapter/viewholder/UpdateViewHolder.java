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
import idoool.com.channel.R;
import idoool.com.channel.utils.GlideUtil;
import idoool.com.baselib.bean.ChannelListType;

/**
 * @author: wangdeshun
 * @date: 2018/1/24  14:05
 * @description: 创建 UpdateViewHolder 频道更新
 */

public class UpdateViewHolder extends RecyclerView.ViewHolder {

    @InjectView(R.id.iv_head)
    ImageView mIvHead;
    @InjectView(R.id.tv_title)
    TextView mTvTitle;
    @InjectView(R.id.tv_vip)
    TextView mTvVip;
    @InjectView(R.id.iv_more)
    ImageView mIvMore;
    @InjectView(R.id.iv_one)
    ImageView mIvOne;
    @InjectView(R.id.iv_two)
    ImageView mIvTwo;
    @InjectView(R.id.iv_three)
    ImageView mIvThree;

    @InjectView(R.id.iv_four)
    ImageView mIvFour;
    @InjectView(R.id.iv_five)
    ImageView mIvFive;
    @InjectView(R.id.iv_six)
    ImageView mIvSix;

    public UpdateViewHolder(View v) {
        super(v);
        ButterKnife.inject(this, v);
    }

    public void bindView(Activity activity, List<ChannelListType.ListBean> list, int position) {
        //TODO 数据
        mTvTitle.setText(list.get(position).getContentType() + "UpdateViewHolder");
        GlideUtil.load(BaseApplication.getAppContext(), "http://static.idoool.com/upload/medium/c47b25ba339f997a79cd610905509538.medium.jpeg", mIvOne);
        GlideUtil.load(BaseApplication.getAppContext(), "http://static.idoool.com/upload/medium/c47b25ba339f997a79cd610905509538.medium.jpeg", mIvTwo);
        GlideUtil.load(BaseApplication.getAppContext(), "http://static.idoool.com/upload/medium/c47b25ba339f997a79cd610905509538.medium.jpeg", mIvThree);
        GlideUtil.load(BaseApplication.getAppContext(), "http://static.idoool.com/upload/medium/c47b25ba339f997a79cd610905509538.medium.jpeg", mIvFour);
        GlideUtil.load(BaseApplication.getAppContext(), "http://static.idoool.com/upload/medium/c47b25ba339f997a79cd610905509538.medium.jpeg", mIvFive);
        GlideUtil.load(BaseApplication.getAppContext(), "http://static.idoool.com/upload/medium/c47b25ba339f997a79cd610905509538.medium.jpeg", mIvSix);

    }
}