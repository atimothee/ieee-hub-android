package org.ieee.ieeehub;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import org.ieee.ieeehub.fragment.ConferenceDetailFragment;
import org.ieee.ieeehub.fragment.ConferenceListFragment;


/**
 * An activity representing a list of Conferences. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a {@link ConferenceDetailActivity} representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 * <p/>
 * The activity makes heavy use of fragments. The list of items is a
 * {@link org.ieee.ieeehub.fragment.ConferenceListFragment} and the item details
 * (if present) is a {@link org.ieee.ieeehub.fragment.ConferenceDetailFragment}.
 * <p/>
 * This activity also implements the required
 * {@link org.ieee.ieeehub.fragment.ConferenceListFragment.Callbacks} interface
 * to listen for item selections.
 */
public class ConferenceListActivity extends FragmentActivity
        implements ConferenceListFragment.Callbacks {

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private boolean mTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conference_list);

        if (findViewById(R.id.conference_detail_container) != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-large and
            // res/values-sw600dp). If this view is present, then the
            // activity should be in two-pane mode.
            mTwoPane = true;

            // In two-pane mode, list items should be given the
            // 'activated' state when touched.
            ((ConferenceListFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.conference_list))
                    .setActivateOnItemClick(true);
        }

        // TODO: If exposing deep links into your app, handle intents here.
    }

    /**
     * Callback method from {@link ConferenceListFragment.Callbacks}
     * indicating that the item with the given ID was selected.
     */
    @Override
    public void onItemSelected(String id) {
        if (mTwoPane) {
            // In two-pane mode, show the detail view in this activity by
            // adding or replacing the detail fragment using a
            // fragment transaction.
            Bundle arguments = new Bundle();
            arguments.putString(ConferenceDetailFragment.ARG_ITEM_ID, id);
            ConferenceDetailFragment fragment = new ConferenceDetailFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.conference_detail_container, fragment)
                    .commit();

        } else {
            // In single-pane mode, simply start the detail activity
            // for the selected item ID.
            Intent detailIntent = new Intent(this, ConferenceDetailActivity.class);
            detailIntent.putExtra(ConferenceDetailFragment.ARG_ITEM_ID, id);
            startActivity(detailIntent);
        }
    }
}
