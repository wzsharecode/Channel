package idoool.com.channel.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author pc wangdeshun
 * @Description ViewPagerForScrollView 解决scrollview嵌套viewpager ，viewpager高度不显示的问题
 * @date 2018/1/19 15:40
 * o(＞﹏＜)o
 */

public class  ViewPagerForScrollView extends ViewPager {
    public ViewPagerForScrollView(Context context) {
        super(context);
    }

    public ViewPagerForScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int height = 0;
        for (int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);
            child.measure(widthMeasureSpec, MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));
            int h = child.getMeasuredHeight();
            if (h > height){
                height = h;
            }
        }

        heightMeasureSpec = MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY);

        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}

