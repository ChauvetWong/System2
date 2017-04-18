package com.example.system2.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.mylibrary.BaseQuickAdapter;
import com.example.system2.ExToolbar;
import com.example.system2.R;
import com.example.system2.ToolBarActivity;
import com.example.system2.adapter.CategoryAdapter;
import com.example.system2.entity.HomeItem;
import com.example.system2.fragment.GoodsComment;
import com.example.system2.fragment.GoodsDisplay;

import java.util.ArrayList;

public class category extends AppCompatActivity {
    private static final Class<?>[] ACTIVITY = {cart.class, ExToolbar.class, mainpage.class, personal.class, search.class, GoodsInfo.class, ToolBarActivity.class};
    private static final String[] TITLE = {"购物车", "工具栏", "主页", "个人信息", "搜索", "移动条", "视图"};
    private static final int[] IMG = {R.mipmap.gv_animation, R.mipmap.gv_databinding, R.mipmap.gv_header_and_footer, R.mipmap.gv_expandable,R.mipmap.gv_drag_and_swipe, R.mipmap.gv_item_click, R.mipmap.gv_empty};
    private ArrayList<HomeItem> mDataList;
    private RecyclerView mRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        initView();
        initData();
        initAdapter();
    }

    private void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_list);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
    }

    @SuppressWarnings("unchecked")
    private void initAdapter() {
        BaseQuickAdapter homeAdapter = new CategoryAdapter(R.layout.category_item_view, mDataList);
        homeAdapter.openLoadAnimation();
        View top = getLayoutInflater().inflate(R.layout.top_view, (ViewGroup) mRecyclerView.getParent(), false);
        homeAdapter.addHeaderView(top);
        homeAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(category.this, ACTIVITY[position]);
                startActivity(intent);
            }
        });

        mRecyclerView.setAdapter(homeAdapter);
    }

    private void initData() {
        mDataList = new ArrayList<>();
        for (int i = 0; i < TITLE.length; i++) {
            HomeItem item = new HomeItem();
            item.setTitle(TITLE[i]);
            item.setActivity(ACTIVITY[i]);
            item.setImageResource(IMG[i]);
            mDataList.add(item);
        }
    }
}
