package com.bookstore.app.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.bookstore.JobListActivity;
import com.bookstore.ProfileActivity;
import com.bookstore.R;

/**
 * Created by Mahbub Hasan Mridul on 08-Jul-15.
 */
public class AgentCompletedJob extends Fragment implements View.OnClickListener {
    Button button1, button2;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_agent_completed_job, container, false);
        initialization(root);
        return root;
    }

    private void initialization(ViewGroup root) {
        button1 = (Button) root.findViewById(R.id.button1);
        button2 = (Button) root.findViewById(R.id.button2);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.button1) {
            Intent intent = new Intent(getActivity(), JobListActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            startActivity(intent);
        } else if (id == R.id.button2) {
            Intent intent = new Intent(getActivity(), ProfileActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            startActivity(intent);
        }
    }
}
