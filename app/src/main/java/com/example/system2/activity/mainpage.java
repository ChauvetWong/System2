package com.example.system2.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.example.mylibrary.BaseQuickAdapter;
import com.example.mylibrary.BaseViewHolder;
import com.example.system2.FullyLinearLayoutManager;
import com.example.system2.LocalImageHolderView;
import com.example.system2.R;
import com.example.system2.adapter.DataBindingUseAdapter;
import com.example.system2.entity.Movie;
import com.example.system2.util.ToastUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class mainpage extends AppCompatActivity{
    private ConvenientBanner convenientBanner;//顶部广告栏控件
    private ArrayList<Integer> localImages = new ArrayList<>();
    RecyclerView mRecyclerView;
    DataBindingUseAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainpage);

        initViews();
        init();

        FullyLinearLayoutManager linearLayoutManager = new FullyLinearLayoutManager(this);
        mRecyclerView = (RecyclerView) findViewById(R.id.rv);
        mAdapter = new DataBindingUseAdapter(R.layout.item_goods,genData());
        mRecyclerView.setNestedScrollingEnabled(false);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener<Movie>() {
            @Override
            public void onItemClick(BaseQuickAdapter<Movie, ? extends BaseViewHolder> adapter, View view, int position) {
                Intent goodsIntent = new Intent(mainpage.this,GoodsInfo.class);
                mainpage.this.startActivity(goodsIntent);
            }
        });
        mAdapter.setOnItemChildLongClickListener(new BaseQuickAdapter.OnItemChildLongClickListener<Movie>() {
            @Override
            public boolean onItemChildLongClick(BaseQuickAdapter<Movie, ? extends BaseViewHolder> adapter, View view, int position) {
                ToastUtils.showShortToast("onItemChildLongClick");
                return true;
            }
        });
        mAdapter.setOnItemLongClickListener(new BaseQuickAdapter.OnItemLongClickListener<Movie>() {
            @Override
            public boolean onItemLongClick(BaseQuickAdapter<Movie, ? extends BaseViewHolder> adapter, View view, int position) {
                ToastUtils.showShortToast("onItemLongClick");
                return true;
            }
        });
    }

    private List<Movie> genData() {
        ArrayList<Movie> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            String name = "No." + (i+1);
            int price = random.nextInt(10) + 10;
            int len = random.nextInt(80) + 60;
            Movie movie = new Movie(name, len, price, "还未录入商品");
            list.add(movie);
        }
        return list;
    }

    private void initViews() {
        convenientBanner = (ConvenientBanner) findViewById(R.id.convenientBanner);
        //listView = (ListView) findViewById(R.id.listView);
        //transformerArrayAdapter = new ArrayAdapter(this,R.layout.adapter_transformer,transformerList);
        //listView.setAdapter(transformerArrayAdapter);
        //listView.setOnItemClickListener(this);
    }

    private void init() {
        loadTestDatas();
        //本地图片例子
        convenientBanner.setPages(
                new CBViewHolderCreator<LocalImageHolderView>() {
                    @Override
                    public LocalImageHolderView createHolder() {
                        return new LocalImageHolderView();
                    }
                }, localImages)
                //设置两个点图片作为翻页指示器，不设置则没有指示器，可以根据自己需求自行配合自己的指示器,不需要圆点指示器可用不设
                .setPageIndicator(new int[]{R.drawable.ic_page_indicator, R.drawable.ic_page_indicator_focused})
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.ALIGN_PARENT_RIGHT);
                //.setOnPageChangeListener(this);//监听翻页事件
    }
    /*
    加入测试Views
    * */
    private void loadTestDatas() {
        //本地图片集合
        for (int position = 0; position < 7; position++)
            localImages.add(getResId("adver_" + position, R.drawable.class));

        /*各种翻页效果
        transformerList.add(DefaultTransformer.class.getSimpleName());
        transformerList.add(AccordionTransformer.class.getSimpleName());
        transformerList.add(BackgroundToForegroundTransformer.class.getSimpleName());
        transformerList.add(CubeInTransformer.class.getSimpleName());
        transformerList.add(CubeOutTransformer.class.getSimpleName());
        transformerList.add(DepthPageTransformer.class.getSimpleName());
        transformerList.add(FlipHorizontalTransformer.class.getSimpleName());
        transformerList.add(FlipVerticalTransformer.class.getSimpleName());
        transformerList.add(ForegroundToBackgroundTransformer.class.getSimpleName());
        transformerList.add(RotateDownTransformer.class.getSimpleName());
        transformerList.add(RotateUpTransformer.class.getSimpleName());
        transformerList.add(StackTransformer.class.getSimpleName());
        transformerList.add(ZoomInTransformer.class.getSimpleName());
        transformerList.add(ZoomOutTranformer.class.getSimpleName());

        transformerArrayAdapter.notifyDataSetChanged();*/
    }

    public static int getResId(String variableName, Class<?> c) {
        try {
            Field idField = c.getDeclaredField(variableName);
            return idField.getInt(idField);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    // 开始自动翻页
    @Override
    protected void onResume() {
        super.onResume();
        //开始自动翻页
        convenientBanner.startTurning(5000);
    }

    // 停止自动翻页
    @Override
    protected void onPause() {
        super.onPause();
        //停止翻页
        convenientBanner.stopTurning();
    }

    /*@Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {
    }*/

}
