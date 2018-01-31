package idoool.com.channel.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import idoool.com.baselib.bean.ChannelListType;
import idoool.com.channel.R;
import idoool.com.channel.adapter.viewholder.PostsViewHolder;
import idoool.com.channel.adapter.viewholder.RecommendViewHolder;
import idoool.com.channel.adapter.viewholder.UpdateViewHolder;
import idoool.com.channel.adapter.viewholder.UserRecommendViewHolder;

/**
 * @author: wangdeshun
 * @date: 2018/1/22  16:18
 * @description: 创建 ChannelListAdapter
 */

public class ChannelListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Activity mActivity;
    private List<ChannelListType.ListBean> mList;

    public interface RecyclerViewItemOnClick {
        /**
         * 列表Item点击事件
         *
         * @param v
         * @param bean
         */
        void onClick(View v, ChannelListType.ListBean bean);
    }

    private RecyclerViewItemOnClick mOnItemClick;

    public void setOnItemClick(RecyclerViewItemOnClick mOnItemClick) {
        this.mOnItemClick = mOnItemClick;
    }

    public ChannelListAdapter(Activity activity) {
        this.mActivity = activity;
        this.mList = new ArrayList<>();
    }

    @Override
    public int getItemViewType(int position) {

        return mList.get(position).getContentType();
    }

    @Override
    public int getItemCount() {

        return mList.size();
    }

    public void setData(List<ChannelListType.ListBean> list) {

        this.mList = list;
        this.notifyDataSetChanged();
    }

    /**
     * 基于项不同的类型来获得不同的ViewHolder
     *
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = null;

        //TODO viewType
        switch (viewType) {
            case 0:
                View v = inflater.inflate(R.layout.item_channel_posts, parent, false);
                viewHolder = new PostsViewHolder(v);
                break;
            case 4:
                view = inflater.inflate(R.layout.item_channel_recommend, parent, false);
                viewHolder = new RecommendViewHolder(view);
                break;
            case 1:
                view = inflater.inflate(R.layout.item_channel_update, parent, false);
                viewHolder = new UpdateViewHolder(view);
                break;
            case 3:
                view = inflater.inflate(R.layout.item_user_recommend, parent, false);
                viewHolder = new UserRecommendViewHolder(view);
                break;
            default:
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        if (holder instanceof PostsViewHolder) {
            ((PostsViewHolder) holder).bindView(mActivity, mList, position);
        } else if (holder instanceof RecommendViewHolder) {
            ((RecommendViewHolder) holder).bindView(mActivity, mList, position);
        } else if (holder instanceof UpdateViewHolder) {
            ((UpdateViewHolder) holder).bindView(mActivity, mList, position);
        } else if (holder instanceof UserRecommendViewHolder) {
            ((UserRecommendViewHolder) holder).bindView(mActivity, mList, position);
        }

        /**
         * 设置监听事件
         */
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnItemClick.onClick(v, mList.get(position));
            }
        });
    }

}