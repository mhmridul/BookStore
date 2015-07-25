package com.bookstore.app.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bookstore.R;
import com.bookstore.app.adapter.ViewPagerAdapter;

/**
 * Created by Mahbub Hasan Mridul on 08-Jul-15.
 */
public class HomeFramgent extends Fragment implements TabLayout.OnTabSelectedListener {
    TabLayout tabLayout;
    ViewPager masterpager;
    ViewPagerAdapter adapter;
    Toolbar toolBar;
    String[] agentTabsTitle = {"Completed Jobs", "Pending Jobs", "Submitted jobs", "Rejected Jobs"};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_home_framgnet, container, false);
        initToolbar(root);
        initialization(root);
        return root;
    }

    private void initToolbar(ViewGroup root) {
        toolBar = (Toolbar) root.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolBar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setHomeButtonEnabled(true);
    }

    private void initialization(ViewGroup root) {
        tabLayout = (TabLayout) root.findViewById(R.id.tabLayout);
        masterpager = (ViewPager) root.findViewById(R.id.masterpager);

        adapter = new ViewPagerAdapter(getActivity().getSupportFragmentManager(), agentTabsTitle, 4, "AGENT");
        masterpager.setAdapter(adapter);

        tabLayout.addTab(tabLayout.newTab().setText("Completed job"));
        tabLayout.addTab(tabLayout.newTab().setText("Pending job"));
        tabLayout.addTab(tabLayout.newTab().setText("Submitted job"));
        tabLayout.addTab(tabLayout.newTab().setText("Rejected job"));
        tabLayout.setOnTabSelectedListener(this);

        masterpager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
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
