package com.example.system2.activity;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.system2.R;
import com.example.system2.adapter.ItemTitlePagerAdapter;
import com.example.system2.base.Base;
import com.example.system2.fragment.GoodsComment;
import com.example.system2.fragment.GoodsDetail;
import com.example.system2.fragment.GoodsDisplay;
import com.example.system2.widgets.NoScrollViewPager;
import com.gxz.PagerSlidingTabStrip;

import java.util.ArrayList;
import java.util.List;

public class GoodsInfo extends Base {
    public PagerSlidingTabStrip psts_tabs;
    public NoScrollViewPager vp_content;
    public TextView tv_title;

    private List<Fragment> fragmentList = new ArrayList<>();
    private GoodsDisplay goodsInfoFragment;
    private GoodsDetail goodsDetailFragment;
    private GoodsComment goodsCommentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBackBtn();
        setTitle("智能清洁机器人");
        setContentView(R.layout.activity_goods_info);

        psts_tabs = (PagerSlidingTabStrip) findViewById(R.id.psts_tabs);
        vp_content = (NoScrollViewPager) findViewById(R.id.vp_content);
        tv_title = (TextView) findViewById(R.id.tv_title);

        fragmentList.add(goodsInfoFragment = new GoodsDisplay());
        fragmentList.add(goodsDetailFragment = new GoodsDetail());
        fragmentList.add(goodsCommentFragment = new GoodsComment());
        vp_content.setAdapter(new ItemTitlePagerAdapter(getSupportFragmentManager(),
                fragmentList, new String[]{"商品", "详情", "评价"}));
        vp_content.setOffscreenPageLimit(3);
        psts_tabs.setViewPager(vp_content);
    }
}
