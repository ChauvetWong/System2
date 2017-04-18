package com.example.system2.activity;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.TabHost;

import com.example.system2.AppManager;
import com.example.system2.R;

public class home extends TabActivity {
    public static final String TAG = home.class.getSimpleName();

    private RadioGroup mTabButtonGroup;
    private TabHost mTabHost;

    public static final String TAB_MAIN = "MAIN_ACTIVITY";
    public static final String TAB_SEARCH = "SEARCH_ACTIVITY";
    public static final String TAB_CATEGORY = "CATEGORY_ACTIVITY";
    public static final String TAB_CART = "CART_ACTIVITY";
    public static final String TAB_PERSONAL = "PERSONAL_ACTIVITY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppManager.getInstance().addActivity(this);
        setContentView(R.layout.activity_home);

        mTabButtonGroup = (RadioGroup) findViewById(R.id.home_radio_button_group);

        mTabHost = getTabHost();

        Intent i_main = new Intent(this,mainpage.class);
        Intent i_search = new Intent(this, search.class);
        Intent i_category = new Intent(this, category.class);
        Intent i_cart = new Intent(this, cart.class);
        Intent i_personal = new Intent(this, personal.class);

        mTabHost.addTab(mTabHost.newTabSpec(TAB_MAIN).setIndicator(TAB_MAIN)
                .setContent(i_main));
        mTabHost.addTab(mTabHost.newTabSpec(TAB_SEARCH)
                .setIndicator(TAB_SEARCH).setContent(i_search));
        mTabHost.addTab(mTabHost.newTabSpec(TAB_CATEGORY)
                .setIndicator(TAB_CATEGORY).setContent(i_category));
        mTabHost.addTab(mTabHost.newTabSpec(TAB_CART).setIndicator(TAB_CART)
                .setContent(i_cart));
        mTabHost.addTab(mTabHost.newTabSpec(TAB_PERSONAL)
                .setIndicator(TAB_PERSONAL).setContent(i_personal));

        mTabHost.setCurrentTabByTag(TAB_MAIN);

        mTabButtonGroup
                .setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        switch (checkedId) {
                            case R.id.home_tab_main:
                                mTabHost.setCurrentTabByTag(TAB_MAIN);
                                break;

                            case R.id.home_tab_search:
                                mTabHost.setCurrentTabByTag(TAB_SEARCH);
                                break;

                            case R.id.home_tab_category:
                                mTabHost.setCurrentTabByTag(TAB_CATEGORY);
                                break;

                            case R.id.home_tab_cart:
                                mTabHost.setCurrentTabByTag(TAB_CART);
                                break;

                            case R.id.home_tab_personal:
                                mTabHost.setCurrentTabByTag(TAB_PERSONAL);
                                break;

                            default:
                                break;
                        }
                    }
                });

    }
}
