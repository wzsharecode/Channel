package idoool.com.channel.moudel.channel.details;

import android.content.Intent;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.InjectView;
import butterknife.OnClick;
import idoool.com.baselib.BaseApplication;
import idoool.com.baselib.bean.ChannelDetails;
import idoool.com.baselib.bean.ChannelListType;
import idoool.com.baselib.utils.BarTextColorUtils;
import idoool.com.channel.R;
import idoool.com.channel.adapter.IdViewPager;
import idoool.com.channel.config.Constant;
import idoool.com.channel.utils.GlideUtil;
import idoool.com.channel.utils.ToastUtils;
import idoool.com.channel.widget.NavigationTabStrip;
import idoool.com.channel.widget.ObservableScrollView;
import idoool.com.channel.widget.ViewPagerForScrollView;
import idoool.com.httplib.base.BaseActivity;
import idoool.com.httplib.presenter.ChannelDetailsPresenter;
import idoool.com.httplib.view.IChannelDetails;

/**
 * @author: wangdeshun
 * @date: 2018/1/22  11:35
 * @description: 创建 ChannelDetailsActivity 频道详情
 */

public class ChannelDetailsActivity extends BaseActivity<IChannelDetails.Presenter> implements IChannelDetails.View {
    @InjectView(R.id.iv_tpo_pic)
    ImageView mIvTpoPic;
    @InjectView(R.id.nts)
    NavigationTabStrip mNts;
    @InjectView(R.id.visible_nts)
    NavigationTabStrip mVisibleNts;
    @InjectView(R.id.vp)
    ViewPagerForScrollView mVp;
    @InjectView(R.id.sc_main)
    ObservableScrollView mScMain;
    @InjectView(R.id.fl_iv)
    RelativeLayout mFlIv;
    @InjectView(R.id.view_line)
    View mViewLine;
    @InjectView(R.id.tv_title)
    TextView mTvTitle;
    @InjectView(R.id.prb_progressbar)
    ProgressBar mPrbProgressbar;

    @InjectView(R.id.prb_more)
    ProgressBar mPrbMore;
    @InjectView(R.id.tv_intro)
    TextView mTvIntro;

    @InjectView(R.id.tv_head)
    TextView mTvHead;
    @InjectView(R.id.ll_head)
    RelativeLayout mRlHead;
    @InjectView(R.id.tv_subscribe_num)
    TextView mTvSubscribeNum;
    @InjectView(R.id.iv_back)
    ImageView mIvBack;

    @InjectView(R.id.ll_visible_nts)
    LinearLayout mLlVisibleNts;

    private String mChannel = "117";
    private String mChannelId;

    private List<ChannelListFragment> mFragmentList = new ArrayList<>();
    private List<ChannelListType.ListBean> mNewList;
    private List<ChannelListType.ListBean> mHotList;
    private List<ChannelListType.ListBean> mSelectedList;
    private boolean isVisibleNts = false;
    private int mIndex = 0;
    private IdViewPager mIdViewPager;

    @Override
    protected int layoutId() {
        return R.layout.activity_channel_details;
    }

    @Override
    protected void initView() {
        Intent intent = getIntent();
        if (null == intent) {
            return;
        }

        mChannel = intent.getStringExtra(Constant.KEY_CHANNEL);
        //频道ID
        mChannelId = intent.getStringExtra(Constant.KEY_CHANNEL_ID);

        /**
         * 最新列表
         */
        mNewList = new ArrayList<>();
        /**
         * 最热列表
         */
        mHotList = new ArrayList<>();
        /**
         * 精选列表
         */
        mSelectedList = new ArrayList<>();

        int size = getResources().getStringArray(R.array.titles).length;
        for (int i = 0; i < size; i++) {
            ChannelListFragment fragment = ChannelListFragment.newInstance();
            mFragmentList.add(fragment);
        }

        mIdViewPager = new IdViewPager(getSupportFragmentManager(), mFragmentList);
        mVp.setAdapter(mIdViewPager);
        mNts.setViewPager(mVp, 0);
        mVisibleNts.setViewPager(mVp, 0);
        mScMain.mImageView = mFlIv;

        /**
         * 显示不透明
         */
        mTvHead.setAlpha(0);
        mRlHead.setAlpha(0);

        setListener();
    }

    @Override
    protected void onResume() {
        super.onResume();
        getData();

    }

    public void getData() {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                /**
                 * 开始加载网络数据
                 */
                mPresenter.channelDetailById(mChannel, mChannelId);
                mPresenter.postsByChannelId(mChannel, mChannelId, mIndex + 1, 20, 0);
            }

        }, 500);
    }

    /**
     * 设置控件监听
     */
    private void setListener() {
        mNts.setOnTabStripSelectedIndexListener(new NavigationTabStrip.OnTabStripSelectedIndexListener() {
            @Override
            public void onStartTabSelected(String title, int index) {

            }

            @Override
            public void onEndTabSelected(String title, int index) {

                if (index == mIndex) {
                    return;
                }
                if (!isVisibleNts) {
                    mIndex = index;
                    boolean isRefreshed = true;
                    switch (index) {
                        case 0:
                            if (mNewList.size() > 0) {
                                isRefreshed = false;
                            }
                            break;
                        case 1:
                            if (mHotList.size() > 0) {
                                isRefreshed = false;
                            }
                            break;
                        case 2:
                            if (mSelectedList.size() > 0) {
                                isRefreshed = false;
                            }
                            break;
                        default:
                            break;
                    }
                    getChannelList(index, isRefreshed);
                }
            }
        });

        /**
         * NavigationTab 滑动、点击事件监听
         */
        mVisibleNts.setOnTabStripSelectedIndexListener(new NavigationTabStrip.OnTabStripSelectedIndexListener() {
            @Override
            public void onStartTabSelected(String title, int index) {

            }

            @Override
            public void onEndTabSelected(String title, int index) {
                if (index == mIndex) {
                    return;
                }
                if (isVisibleNts) {
                    mIndex = index;
                    getChannelList(index, false);
                }
            }
        });

        /**
         * ScrollView滑动控件渐变
         */
        mScMain.setScrollViewListener(new ObservableScrollView.ScrollViewListener() {
            @Override
            public void onScrollChanged(ObservableScrollView scrollView, int x, int t, int oldx,
                                        int oldy) {
                t = Math.abs(t);
                int[] location = new int[2];
                mNts.getLocationOnScreen(location);
                int yPosition = location[1];
                int statusBarHeight = 210;
                if (yPosition <= statusBarHeight) {
                    mLlVisibleNts.setVisibility(View.VISIBLE);
                } else {
                    mLlVisibleNts.setVisibility(View.INVISIBLE);
                }

                if (t >= 0 && t <= 300) {
                    //设置标题栏透明度0~255
                    float v = (float) (t % 301 * 0.004);
                    mRlHead.setAlpha(v);
                    //状态栏白色字体
                    BarTextColorUtils.StatusBarLightMode(ChannelDetailsActivity.this, false);
                } else if (t > 255) {
                    //状态栏黑色字体
                    BarTextColorUtils.StatusBarLightMode(ChannelDetailsActivity.this, true);
                    //滑动距离大于255就设置为不透明
                    mRlHead.setAlpha(1);
                    mTvHead.setAlpha(1);
                }
            }
        });

        /**
         * 下拉刷新
         */
        mScMain.setPullToListener(new ObservableScrollView.PullToListener() {
            @Override
            public void showProgressBar() {

                if (mPrbProgressbar.getVisibility() != View.VISIBLE) {
                    mPrbProgressbar.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void hideProgressBar() {
                mPrbProgressbar.setVisibility(View.GONE);
            }

            @Override
            public void refresh() {
                switch (mIndex) {
                    case 0:
                        mNewList.clear();
                        break;
                    case 1:
                        mHotList.clear();
                        break;
                    case 2:
                        mSelectedList.clear();
                        break;
                    default:
                        break;
                }
                getData();
            }
        });

        /**
         * 上拉加载更多
         */
        mScMain.setOnScrollToBottomLintener(new ObservableScrollView.OnScrollToBottomListener() {
            @Override
            public void onScrollBottomListener() {
                if (mPrbMore.getVisibility() == View.VISIBLE) {
                    return;
                }

                //TODO 判断
                mPrbMore.setVisibility(View.VISIBLE);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mPrbMore.setVisibility(View.GONE);
                    }

                }, 3000);


            }
        });
    }

    /**
     * 根据ID 获取列表数据
     *
     * @param index 当前索引 type 最新、最热、精选
     */
    private void getChannelList(int index, boolean isRefresh) {
        switch (index) {
            case 0:
                if (isRefresh) {
                    mNewList.clear();
                    (mFragmentList.get(mIndex)).showProgressBar();
                    mPresenter.postsByChannelId(mChannel, mChannelId, mIndex + 1, 20, 0);
                } else {
                    (mFragmentList.get(mIndex)).setData(mNewList, false);
                }
                break;
            case 1:
                if (isRefresh) {
                    mHotList.clear();
                    (mFragmentList.get(mIndex)).showProgressBar();
                    mPresenter.postsByChannelId(mChannel, mChannelId, mIndex + 1, 20, 0);
                } else {
                    (mFragmentList.get(mIndex)).setData(mHotList, false);
                }
                break;
            case 2:
                if (mSelectedList.size() < 1) {
                    (mFragmentList.get(mIndex)).showProgressBar();
                    mPresenter.postsByChannelId(mChannel, mChannelId, mIndex + 1, 20, 0);
                } else {
                    (mFragmentList.get(mIndex)).setData(mSelectedList, false);
                }
                break;
            default:
                break;
        }

    }

    @Override
    public IChannelDetails.Presenter setPresenter(IChannelDetails.Presenter presenter) {
        if (null == presenter) {
            mPresenter = new ChannelDetailsPresenter(this, this);
        }
        return mPresenter;
    }

    /**
     * 更新UI  TOP图片
     *
     * @param bean 更新数据
     */
    @Override
    public void changeData(ChannelDetails bean) {
        mPrbProgressbar.setVisibility(View.GONE);

        String url = bean.getChannel().getCoverImageUrl();
        GlideUtil.load(BaseApplication.getAppContext(), url, mIvTpoPic);
        mTvIntro.setText(bean.getChannel().getIntro());
        mTvTitle.setText(bean.getChannel().getTitle());

        StringBuilder str = new StringBuilder();
        str.append(bean.getChannel().getSubscriptionNum());
        str.append(getString(R.string.subscription_num));
        str.append(" · ");
        if (bean.getChannel().isIsSubscribe()) {
            str.append(getString(R.string.is_subscribe));
        } else {
            str.append(getString(R.string.no_subscribe));
        }
        mTvSubscribeNum.setText(str.toString());
        mTvHead.setText(bean.getChannel().getTitle());

    }

    /**
     * 根据频道ID和查询类型查询频道下的帖子列表
     *
     * @param list 列表数据
     */
    @Override
    public void setAdapter(List<ChannelListType.ListBean> list) {
        (mFragmentList.get(mIndex)).hideProgressBar();
        mPrbProgressbar.setVisibility(View.GONE);
        mIdViewPager.notifyDataSetChanged();
        if (list.size() < 1) {
            (mFragmentList.get(mIndex)).showNoData();
            return;
        }
        switch (mIndex) {
            case 0:
                mNewList.addAll(list);
                if (mNewList.size() < 1) {
                    (mFragmentList.get(mIndex)).setData(mNewList, true);
                } else {
                    (mFragmentList.get(mIndex)).setData(mNewList, false);
                }
                break;
            case 1:
                mHotList.addAll(list);
                if (mHotList.size() < 1) {
                    (mFragmentList.get(mIndex)).setData(mHotList, true);
                } else {
                    (mFragmentList.get(mIndex)).setData(mHotList, false);
                }
                break;
            case 2:
                mSelectedList.addAll(list);
                if (mSelectedList.size() < 1) {
                    (mFragmentList.get(mIndex)).setData(mSelectedList, true);
                } else {
                    (mFragmentList.get(mIndex)).setData(mSelectedList, false);
                }

                break;
            default:
                break;
        }
    }

    @OnClick({R.id.iv_back, R.id.iv_right_pic, R.id.iv_right_share})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.iv_right_pic:
                ToastUtils.showShort("channel details");
                break;
            case R.id.iv_right_share:
                ToastUtils.showShort("share");
                break;
            default:
                break;
        }

    }

    @Override
    public void onNoConnect() {
        super.onNoConnect();
        mTvHead.setAlpha(0);
        mVisibleNts.setVisibility(View.GONE);
        mLlVisibleNts.setVisibility(View.GONE);
        mPrbProgressbar.setVisibility(View.GONE);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                (mFragmentList.get(mIndex)).hideProgressBar();
                (mFragmentList.get(mIndex)).showNoNetWork();
            }

        }, 500);

    }

}
