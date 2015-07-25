package com.bookstore.app.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.bookstore.app.fragment.AgentCompletedJob;
import com.bookstore.app.fragment.AgentPendingJob;
import com.bookstore.app.fragment.AgentRejectedJob;
import com.bookstore.app.fragment.AgentSubmittedJob;

/**
 * Created by Mahbub Hasan Mridul on 08-Jul-15.
 */
public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    String[] titlePage;
    int pageIndexCount;
    String mood;
    Fragment fragment;

    public ViewPagerAdapter(FragmentManager fm, String[] title, int numOfPages, String wichiMode) {
        super(fm);
        titlePage = title;
        pageIndexCount = numOfPages;
        mood = wichiMode;
    }

    @Override
    public Fragment getItem(int position) {
        if (mood.equals("AGENT")) {
            if (position == 0) {
                fragment = new AgentCompletedJob();
            } else if (position == 1) {
                fragment = new AgentPendingJob();
            } else if (position == 2) {
                fragment = new AgentSubmittedJob();
            } else {
                fragment = new AgentRejectedJob();
            }
        } else {

        }
        return fragment;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titlePage[position];
    }

    @Override
    public int getCount() {
        return pageIndexCount;
    }
}
