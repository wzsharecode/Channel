package idoool.com.channel.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;

import java.util.List;

import idoool.com.channel.moudel.channel.details.ChannelListFragment;

/**
 * @author pc wangdeshun
 * @Description IdViewPager ViewPager适配器
 * @date 2018/1/18 17:30
 * o(＞﹏＜)o
 */

public class IdViewPager extends FragmentStatePagerAdapter {
    private List<ChannelListFragment> mFragmentList;

    public IdViewPager(FragmentManager fm, List<ChannelListFragment> fragmentList) {
        super(fm);
        this.mFragmentList = fragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    @Override
    public int getItemPosition(Object object) {
        return PagerAdapter.POSITION_NONE;
    }

}