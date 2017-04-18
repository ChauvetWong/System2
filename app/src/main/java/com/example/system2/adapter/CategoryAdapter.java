package com.example.system2.adapter;

import com.example.mylibrary.BaseQuickAdapter;
import com.example.mylibrary.BaseViewHolder;
import com.example.system2.R;
import com.example.system2.entity.HomeItem;

import java.util.List;

/**
 * Created by 学伟 on 2017/4/17.
 */

public class CategoryAdapter extends BaseQuickAdapter<HomeItem, BaseViewHolder> {
    public CategoryAdapter(int layoutResId, List data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HomeItem item) {
        helper.setText(R.id.text, item.getTitle());
        helper.setImageResource(R.id.icon, item.getImageResource());
    }
}
