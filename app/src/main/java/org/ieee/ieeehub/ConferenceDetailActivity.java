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

        // Show the Up button in the action bar.
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // savedInstanceState is non-null when there is fragment state
        // saved from previous configurations of this activity
        // (e.g. when rotating the screen from portrait to landscape).
        // In this case, the fragment will automatically be re-added
        // to its container so we don't need to manually add it.
        // For more information, see the Fragments API guide at:
        //
        // http://developer.android.com/guide/components/fragments.html
        //
        if (savedInstanceState == null) {
            // Create the detail fragment and add it to the activity
            // using a fragment transaction.
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.conference_detail_container, ConferenceDetailFragment.newInstance(getIntent().getLongExtra(ConferenceDetailFragment.ARG_ITEM_ID, 0)))
                    .commit();
        }
    }


}
