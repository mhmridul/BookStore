package com.bookstore.app.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bookstore.R;

/**
 * Created by Mahbub Hasan Mridul on 08-Jul-15.
 */
public class AgentSubmittedJob extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_agent_submitted_job, container, false);
    }
}
