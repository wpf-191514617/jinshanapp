package com.jinshan.application.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jinshan.application.R;
import com.minilive.library.util.StringUtils;

public class LineView extends LinearLayout {

    public LineView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);
    }

    public LineView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context, attrs);
    }

    private void initView(Context context, AttributeSet attrs){
        TypedArray array = context.obtainStyledAttributes(attrs,
                R.styleable.LineView);
        String lable = array.getString(R.styleable.LineView_lable);
        array.recycle();
        View view = LayoutInflater.from(context).inflate(R.layout.layout_lineview, this);
        TextView tvLable = view.findViewById(R.id.tvLable);
        if (!StringUtils.isEmpty(lable)){
            tvLable.setText(lable);
        }
    }

}
