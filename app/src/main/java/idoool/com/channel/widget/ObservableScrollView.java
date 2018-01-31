package idoool.com.channel.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

/**
 * @author pc wangdeshun
 * @Description ObservableScrollView 兼容性的scrollview滑动监听
 * @date 2018/1/19 13:40
 * o(＞﹏＜)o
 */

public class ObservableScrollView extends ScrollView {

    public RelativeLayout mImageView;
    private int mImageViewHeight = -1;
    private int mDefaultImageViewHeight = 0;
    private double mZoomRatio = 2;
    // 滑动距离及坐标
    private float xDistance, yDistance, xLast, yLast;

    private boolean mIsIntercept = false;

    private float xFirst, yFirst;

    private Context mContext;

    private float mTouchSlop;

    private boolean isRefresh = false;
    private boolean isLoad = false;
    /**
     * 上拉加载更多事件
     */
    private OnScrollToBottomListener mOnScrollToBottom;

    public void setOnScrollToBottomLintener(OnScrollToBottomListener listener) {
        mOnScrollToBottom = listener;
    }

    public interface OnScrollToBottomListener {
        /**
         * 滑动到底部
         */
        void onScrollBottomListener();
    }

    /**
     * 下拉刷新加载ProgressBar 回调
     */
    public interface PullToListener {

        /**
         * 显示加载
         */
        void showProgressBar();

        /**
         * 隐藏加载
         */
        void hideProgressBar();

        /**
         * 开始加载网络数据
         */
        void refresh();

    }

    /**
     * 下拉监听事件显示加载控件
     */
    private PullToListener mPullToListener;

    public void setPullToListener(PullToListener pullToListener) {
        this.mPullToListener = pullToListener;
    }

    /**
     * ScrollView滑动监听
     */
    public interface ScrollViewListener {

        /**
         * ScrollView Change事件
         *
         * @param scrollView
         * @param x
         * @param y
         * @param oldx
         * @param oldy
         */
        void onScrollChanged(ObservableScrollView scrollView, int x, int y, int oldx, int oldy);
    }

    private ScrollViewListener scrollViewListener = null;

    public void setScrollViewListener(ScrollViewListener scrollViewListener) {
        this.scrollViewListener = scrollViewListener;
    }

    public ObservableScrollView(Context context) {
        super(context);
        mContext = context;
        init();
    }

    public ObservableScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);

        mContext = context;
        init();
    }

    public ObservableScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mContext = context;
        init();
    }

    public void init() {
        mDefaultImageViewHeight = 200;
        final ViewConfiguration configuration = ViewConfiguration.get(mContext);
        mTouchSlop = configuration.getScaledTouchSlop();
    }

    /**
     * overScrollBy 回调
     */
    private interface OnOverScrollByListener {
        /**
         * overScrollBy
         *
         * @param deltaX
         * @param deltaY
         * @param scrollX
         * @param scrollY
         * @param scrollRangeX
         * @param scrollRangeY
         * @param maxOverScrollX
         * @param maxOverScrollY
         * @param isTouchEvent
         * @return
         */
        boolean overScrollBy(int deltaX, int deltaY, int scrollX,
                             int scrollY, int scrollRangeX, int scrollRangeY,
                             int maxOverScrollX, int maxOverScrollY, boolean isTouchEvent);
    }

    private interface OnTouchEventListener {
        /**
         * 触摸事件
         *
         * @param ev
         */
        void onTouchEvent(MotionEvent ev);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        initViewsBounds(mZoomRatio);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        touchListener.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    /**
     * 重写 OnInterceptTouchEvent方法，在上下滑动的时候拦截事件，在左右滑动的时候不拦截事件，返回 false，这样确保子View 的dispatchTouchEvent方法会被调用
     *
     * @param event
     * @return
     */
    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                xFirst = event.getX();
                yFirst = event.getY();
                mIsIntercept = false;
                super.onInterceptTouchEvent(event);

            case MotionEvent.ACTION_MOVE:
                xDistance = event.getX() - xFirst;
                yDistance = event.getY() - yFirst;

                if (Math.abs(yDistance) > mTouchSlop) {
                    mIsIntercept = true;
                } else {
                    mIsIntercept = false;
                }
                final float deltaX = Math.abs(event.getX() - xFirst);
                final float deltaY = Math.abs(event.getY() - yFirst);
                // 这里是否拦截的判断依据是左右滑动，读者可根据自己的逻辑进行是否拦截

                // 左右滑动不拦截
                if (deltaX > deltaY) {
                    isLoad = false;
                    return false;
                }
                break;
            default:
                break;
        }
        return mIsIntercept;

    }

    @Override
    public boolean canScrollVertically(int direction) {
        return true;
    }

    @Override
    protected boolean overScrollBy(int deltaX, int deltaY, int scrollX,
                                   int scrollY, int scrollRangeX, int scrollRangeY,
                                   int maxOverScrollX, int maxOverScrollY, boolean isTouchEvent) {
        boolean isCollapseAnimation = false;

        isCollapseAnimation = scrollByListener.overScrollBy(deltaX, deltaY,
                scrollX, scrollY, scrollRangeX, scrollRangeY, maxOverScrollX,
                maxOverScrollY, isTouchEvent)
                || isCollapseAnimation;

        return isCollapseAnimation ? true : super.overScrollBy(deltaX, deltaY,
                scrollX, scrollY, scrollRangeX, scrollRangeY, maxOverScrollX,
                maxOverScrollY, isTouchEvent);
    }

    @Override
    protected void onOverScrolled(int scrollX, int scrollY, boolean clampedX, boolean clampedY) {
        super.onOverScrolled(scrollX, scrollY, clampedX, clampedY);
        if (scrollX == 0 && scrollY != 0 && null != mOnScrollToBottom) {
            mOnScrollToBottom.onScrollBottomListener();
        }
    }

    private OnOverScrollByListener scrollByListener = new OnOverScrollByListener() {
        @Override
        public boolean overScrollBy(int deltaX, int deltaY, int scrollX,
                                    int scrollY, int scrollRangeX, int scrollRangeY,
                                    int maxOverScrollX, int maxOverScrollY, boolean isTouchEvent) {
            if (isTouchEvent) {
                if (deltaY < 0) {
                    if ((mImageView.getHeight() - deltaY / 2) > 750) {
                        if (null != mPullToListener) {
                            isRefresh = true;
                            mPullToListener.showProgressBar();
                        }
                    }
                    if ((mImageView.getHeight() - deltaY / 2) < 700) {
                        isRefresh = false;
                        mPullToListener.hideProgressBar();
                    }
                    if (mImageView.getHeight() - deltaY / 2 >= mImageViewHeight && getScrollY() == 0) {
                        mImageView.getLayoutParams().height = mImageView.getHeight() - deltaY / 2 >= mImageViewHeight ?
                                mImageView.getHeight() - deltaY / 2 : mImageViewHeight;
                        mImageView.requestLayout();
                    }
                } else {
                    if (mImageView.getHeight() > mImageViewHeight) {
                        mImageView.getLayoutParams().height = mImageView.getHeight() - deltaY > mImageViewHeight ?
                                mImageView.getHeight() - deltaY : mImageViewHeight;
                        mImageView.requestLayout();
                        return true;
                    }
                }
            }
            return false;
        }
    };

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if (scrollViewListener != null) {
            scrollViewListener.onScrollChanged(this, l, t, oldl, oldt);
        }
        View firstView = (View) mImageView.getParent();
        // firstView.getTop < getPaddingTop means mImageView will be covered by top padding,
        // so we can layout it to make it shorter

        if (firstView.getTop() < getPaddingTop() && mImageView.getHeight() > mImageViewHeight) {
            mImageView.getLayoutParams().height = Math.max(mImageView.getHeight() - (getPaddingTop() - firstView.getTop()), mImageViewHeight);
            // to set the firstView.mTop to 0,
            // maybe use View.setTop() is more easy, but it just support from Android 3.0 (API 11)
            firstView.layout(firstView.getLeft(), 0, firstView.getRight(), firstView.getHeight());
            mImageView.requestLayout();
        }
    }

    private void initViewsBounds(double zoomRatio) {
        if (mImageViewHeight == -1) {
            mImageViewHeight = mImageView.getHeight();
            if (mImageViewHeight <= 0) {
                mImageViewHeight = mDefaultImageViewHeight;
            }
        }
    }

    /**
     * 监听OnTouch事件
     */
    private OnTouchEventListener touchListener = new OnTouchEventListener() {
        @Override
        public void onTouchEvent(MotionEvent ev) {
            if (ev.getAction() == MotionEvent.ACTION_UP) {
                if (mImageViewHeight - 1 < mImageView.getHeight()) {
                    ResetAnimation animation = new ResetAnimation(mImageView, mImageViewHeight);
                    animation.setDuration(300);
                    mImageView.startAnimation(animation);
                }
                mIsIntercept = false;
                if (null != mPullToListener) {
                    if (isRefresh) {
                        mPullToListener.refresh();
                    }
                }
                isRefresh = false;
                isLoad = false;
            }
        }
    };

    /**
     * 动画
     */
    public class ResetAnimation extends Animation {
        int targetHeight;
        int originalHeight;
        int extraHeight;
        View mView;

        protected ResetAnimation(View view, int targetHeight) {
            this.mView = view;
            this.targetHeight = targetHeight;
            originalHeight = view.getHeight();
            extraHeight = this.targetHeight - originalHeight;
        }

        @Override
        protected void applyTransformation(float interpolatedTime, Transformation t) {

            int newHeight;
            newHeight = (int) (targetHeight - extraHeight * (1 - interpolatedTime));
            mView.getLayoutParams().height = newHeight;
            mView.requestLayout();
        }
    }

}
