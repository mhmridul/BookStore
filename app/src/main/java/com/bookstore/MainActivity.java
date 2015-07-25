package com.bookstore;

import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.bookstore.app.adapter.ViewPagerAdapter;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, TabLayout.OnTabSelectedListener {
    DrawerLayout drawerlayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    Toolbar toolBar;
    NavigationView navigation;
    int navItemID;

    TabLayout tabLayout;
    ViewPager masterpager;
    ViewPagerAdapter adapter;

    String[] agentTabsTitle = {"Completed Jobs", "Pending Jobs", "Submitted jobs", "Rejected Jobs"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home_page);

        initToolbar();
        initialization();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    private void initToolbar() {
        toolBar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolBar);
        toolBar.setTitleTextColor(Color.WHITE);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Home");
    }

    private void initialization() {
        drawerlayout = (DrawerLayout) findViewById(R.id.drawerlayout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerlayout, toolBar, R.string.drawer_open, R.string.drawer_close);
        drawerlayout.setDrawerListener(actionBarDrawerToggle);

        navigation = (NavigationView) findViewById(R.id.navigation);
        navigation.setNavigationItemSelectedListener(this);

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        masterpager = (ViewPager) findViewById(R.id.viewpager);

        adapter = new ViewPagerAdapter(getSupportFragmentManager(), agentTabsTitle, 4, "AGENT");
        masterpager.setAdapter(adapter);

        tabLayout.addTab(tabLayout.newTab().setText("Completed job"));
        tabLayout.addTab(tabLayout.newTab().setText("Pending job"));
        tabLayout.addTab(tabLayout.newTab().setText("Submitted job"));
        tabLayout.addTab(tabLayout.newTab().setText("Rejected job"));
        tabLayout.setOnTabSelectedListener(this);

        masterpager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        actionBarDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        menuItem.setChecked(true);
        navItemID = menuItem.getItemId();
        drawerlayout.closeDrawer(GravityCompat.START);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                navItemClick(navItemID);
            }
        }, 500);
        return true;
    }

    private void navItemClick(int id) {

    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        masterpager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
