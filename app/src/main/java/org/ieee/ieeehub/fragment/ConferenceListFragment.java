package org.ieee.ieeehub.fragment;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;


import com.melnykov.fab.FloatingActionButton;

import org.ieee.ieeehub.ConferenceDetailActivity;
import org.ieee.ieeehub.ConferenceSearchActivity;
import org.ieee.ieeehub.R;
import org.ieee.ieeehub.dummy.DummyContent;
import org.ieee.ieeehub.provider.conference.ConferenceColumns;

/**
 * A list fragment representing a list of Conferences. This fragment
 * also supports tablet devices by allowing list items to be given an
 * 'activated' state upon selection. This helps indicate which item is
 * currently being viewed in a {@link ConferenceDetailFragment}.
 * <p/>
 * Activities containing this fragment MUST implement the {@link Callbacks}
 * interface.
 */
public class ConferenceListFragment extends Fragment implements LoaderManager.LoaderCallbacks {
    public static final String TAG = ConferenceListFragment.class.getSimpleName();
    private static final int CONFERENCES_LOADER = 2;
    private SimpleCursorAdapter mAdapter;
    private Cursor mCursor;
    private ListView mListView;

    /**
     * The serialization (saved instance state) Bundle key representing the
     * activated item position. Only used on tablets.
     */
    private static final String STATE_ACTIVATED_POSITION = "activated_position";

    /**
     * The fragment's current callback object, which is notified of list item
     * clicks.
     */
    private Callbacks mCallbacks = sDummyCallbacks;

    /**
     * The current activated item position. Only used on tablets.
     */
    private int mActivatedPosition = ListView.INVALID_POSITION;

    private String[] COLUMNS = {ConferenceColumns.TITLE, ConferenceColumns.LOCATION, ConferenceColumns.DISPLAY_DATE, ConferenceColumns.DESCRIPTION};
    private int[] VIEW_IDS = {R.id.conference_item_title, R.id.conference_item_location, R.id.conference_item_date,
            R.id.conference_item_description};

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getLoaderManager().initLoader(CONFERENCES_LOADER, null, this);
    }

    @Override
    public Loader onCreateLoader(int id, Bundle args) {
        return new CursorLoader(getActivity(), ConferenceColumns.CONTENT_URI, null, null, null, null);
    }

    @Override
    public void onLoadFinished(Loader loader, Object data) {
        mCursor = (Cursor) data;
        mAdapter.swapCursor(mCursor);
    }

    @Override
    public void onLoaderReset(Loader loader) {

    }

    /**
     * A callback interface that all activities containing this fragment must
     * implement. This mechanism allows activities to be notified of item
     * selections.
     */
    public interface Callbacks {
        /**
         * Callback for when an item has been selected.
         */
        public void onItemSelected(Long id);
    }

    /**
     * A dummy implementation of the {@link Callbacks} interface that does
     * nothing. Used only when this fragment is not attached to an activity.
     */
    private static Callbacks sDummyCallbacks = new Callbacks() {
        @Override
        public void onItemSelected(Long id) {
        }
    };

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ConferenceListFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mAdapter = new SimpleCursorAdapter(getActivity(), R.layout.conference_list_item, mCursor, COLUMNS, VIEW_IDS, 0);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_conference_list, null, true);
        mListView = (ListView)rootView.findViewById(R.id.conference_list);
        mListView.setAdapter(mAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                mCursor.moveToPosition(position);
                mCallbacks.onItemSelected(mCursor.getLong(mCursor.getColumnIndex(ConferenceColumns._ID)));
            }
        });
        FloatingActionButton fab = (FloatingActionButton)rootView.findViewById(R.id.fab);
       fab.attachToListView(mListView);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i = new Intent(getActivity(), ConferenceSearchActivity.class);
//                startActivity(i);
//            }
//        });

        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // Activities containing this fragment must implement its callbacks.
        if (!(activity instanceof Callbacks)) {
            throw new IllegalStateException("Activity must implement fragment's callbacks.");
        }

        mCallbacks = (Callbacks) activity;
    }

    @Override
    public void onDetach() {
        super.onDetach();

        // Reset the active callbacks interface to the dummy implementation.
        mCallbacks = sDummyCallbacks;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (mActivatedPosition != ListView.INVALID_POSITION) {
            // Serialize and persist the activated item position.
            outState.putInt(STATE_ACTIVATED_POSITION, mActivatedPosition);
        }
    }

}
