package com.example.tmnt.bargemenu;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.support.v4.view.ActionProvider;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by tmnt on 2016/7/14.
 */
public class BargeActionProvider extends ActionProvider {
    private ImageView mIvIcon;
    private TextView mTvBadge;

    private OnClickMeniListener mOnClickMeniListener;
    private int what;

    /**
     * Creates a new instance.
     *
     * @param context Context for accessing resources.
     */
    public BargeActionProvider(Context context) {
        super(context);
    }

    @Override
    public View onCreateActionView() {
        int size = getContext().getResources().getDimensionPixelSize(
                android.support.design.R.dimen.abc_action_bar_default_height_material);//将menu设置为与系统的一致

        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(size, size);

        View view = LayoutInflater.from(getContext()).inflate(R.layout.barge_lay, null, false);
        view.setLayoutParams(layoutParams);
        mIvIcon = (ImageView) view.findViewById(R.id.iv_icon);
        mTvBadge = (TextView) view.findViewById(R.id.tv_badge);

        mIvIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnClickMeniListener != null) {

                    mOnClickMeniListener.clickMenu(what);
                }
            }
        });
        return view;
    }

    public void setOnClickMeniListener(OnClickMeniListener mOnClickMeniListener, int what) {
        this.mOnClickMeniListener = mOnClickMeniListener;
        this.what = what;
    }

    public interface OnClickMeniListener {
        void clickMenu(int what);
    }

    // 设置图标。
    public void setIcon(@DrawableRes int icon) {
        mIvIcon.setImageResource(icon);
    }

    // 设置显示的数字。
    public void setBadge(int i) {
        mTvBadge.setText(Integer.toString(i));
    }

    // 设置文字。
    public void setTextInt(@StringRes int i) {
        mTvBadge.setText(i);
    }

    // 设置显示的文字。
    public void setText(CharSequence i) {
        mTvBadge.setText(i);
    }
}
