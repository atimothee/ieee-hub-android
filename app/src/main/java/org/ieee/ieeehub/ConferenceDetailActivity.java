package org.ieee.ieeehub;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;

import org.ieee.ieeehub.fragment.ConferenceDetailFragment;



public class ConferenceDetailActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conference_detail);
        if (savedInstanceState == null) {
            // Create the detail fragment and add it to the activity
            // using a fragment transaction.
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.conference_detail_container, ConferenceDetailFragment.newInstance(getIntent().getLongExtra(ConferenceDetailFragment.ARG_ITEM_ID, 0)))
                    .commit();
        }
    }


}
