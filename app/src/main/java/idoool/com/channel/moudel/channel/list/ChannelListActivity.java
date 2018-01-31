package idoool.com.channel.moudel.channel.list;

import android.content.Intent;
import android.widget.TextView;

import java.util.List;

import butterknife.InjectView;
import butterknife.OnClick;
import idoool.com.channel.R;
import idoool.com.channel.config.Constant;
import idoool.com.channel.moudel.channel.details.ChannelDetailsActivity;
import idoool.com.httplib.base.BaseActivity;
import idoool.com.baselib.bean.ChannelList;
import idoool.com.httplib.presenter.ChannelPresenter;
import idoool.com.httplib.view.IChannel;

/**
 * @author: wangdeshun
 * @date: 2018/1/18  11:14
 * @description: 创建 ChannelListActivity
 */

public class ChannelListActivity extends BaseActivity<IChannel.Presenter> implements IChannel.View {

    @InjectView(R.id.tv_channel)
    TextView mTvChannel;

    private String mChannelId;
    private String mChannel;
    @Override
    protected int layoutId() {
        return R.layout.activity_channel_list;
    }

    @Override
    protected void initView() {
        mPresenter.getAllChannel();
    }

    @Override
    public IChannel.Presenter setPresenter(IChannel.Presenter presenter) {
        if (null == presenter) {
            this.mPresenter = new ChannelPresenter(this, this);
        }
        return mPresenter;
    }

    /**
     * 适配器
     *
     * @param list 更新列表数据
     */
    @Override
    public void setAdapter(List<ChannelList.ListBean> list) {
        mTvChannel.setText(list.get(0).get_id());
        mChannel = "117";
        mChannelId = "5a57571f16fb146b5ca51880";
    }

    @OnClick(R.id.tv_channel)
    public void onViewClicked() {

        Intent intent = new Intent(this, ChannelDetailsActivity.class);
        intent.putExtra(Constant.KEY_CHANNEL, mChannel);
        intent.putExtra(Constant.KEY_CHANNEL_ID, mChannelId);
        startActivity(intent);
        finish();
        
    }
}
