package idoool.com.channel.moudel.channel.details;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import java.util.List;

import butterknife.InjectView;
import idoool.com.baselib.bean.ChannelListType;
import idoool.com.channel.R;
import idoool.com.channel.adapter.ChannelListAdapter;
import idoool.com.channel.utils.ToastUtils;
import idoool.com.httplib.base.BaseFragment;

/**
 * @author: wangdeshun
 * @date: 2018/1/22  14:50
 * @description: 创建 ChannelListFragment 最新、最热、精选列表
 */

public class ChannelListFragment extends BaseFragment {

    @InjectView(R.id.iv_no_data)
    ImageView mIvNoData;
    @InjectView(R.id.prb)
    ProgressBar mPrb;
    @InjectView(R.id.rc_list)
    RecyclerView mRcList;

    private ChannelListAdapter mAdapter;

    public static ChannelListFragment newInstance() {
        ChannelListFragment fragment = new ChannelListFragment();
        return fragment;

    }

    @Override
    protected int attachLayoutId() {
        return R.layout.fragment_channel_list;
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected void initData() throws NullPointerException {
        mAdapter = new ChannelListAdapter(getActivity());
        mRcList.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRcList.setAdapter(mAdapter);

        mAdapter.setOnItemClick(new ChannelListAdapter.RecyclerViewItemOnClick() {
            @Override
            public void onClick(View v, ChannelListType.ListBean bean) {
                ToastUtils.showShort("详情页");
            }
        });

        mIvNoData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPrb.setVisibility(View.VISIBLE);
                mIvNoData.setVisibility(View.GONE);
                ((ChannelDetailsActivity) getActivity()).getData();
            }
        });
    }

    /**
     * 设置数据
     *
     * @param list      列表数据
     * @param isRefresh
     */
    public void setData(List<ChannelListType.ListBean> list, boolean isRefresh) {
        if (isRefresh) {
            mRcList.setVisibility(View.GONE);
            mIvNoData.setVisibility(View.VISIBLE);
        } else {
            mRcList.setVisibility(View.VISIBLE);
            mIvNoData.setVisibility(View.GONE);
            mAdapter.setData(list);
        }
    }

    /**
     * 显示加载控件
     */
    public void showProgressBar() {
        mPrb.setVisibility(View.VISIBLE);
    }

    /**
     * 隐藏加载控件
     */
    public void hideProgressBar() {
        mPrb.setVisibility(View.GONE);
    }

    /**
     * 无网络图片
     */
    public void showNoNetWork() {
        mRcList.setVisibility(View.GONE);
        mIvNoData.setImageResource(R.mipmap.no_network_icon);
        mIvNoData.setVisibility(View.VISIBLE);
    }

    /**
     * 无数据
     */
    public void showNoData() {
        mRcList.setVisibility(View.GONE);
        mIvNoData.setImageResource(R.mipmap.no_more_data_icon);
        mIvNoData.setVisibility(View.VISIBLE);
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
    }

    @Override
    public Object setPresenter(Object presenter) {
        return null;
    }
}
