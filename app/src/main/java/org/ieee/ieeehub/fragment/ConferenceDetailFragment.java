package org.ieee.ieeehub.fragment;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import org.ieee.ieeehub.R;
import org.ieee.ieeehub.dummy.DummyContent;
import org.ieee.ieeehub.provider.conference.ConferenceColumns;
import org.ieee.ieeehub.provider.conference.ConferenceSelection;
import org.w3c.dom.Text;

/**
 * A fragment representing a single Conference detail screen.
 * This fragment is either contained in a {@link org.ieee.ieeehub.ConferenceListActivity}
 * in two-pane mode (on tablets) or a {@link org.ieee.ieeehub.ConferenceDetailActivity}
 * on handsets.
 */
public class ConferenceDetailFragment extends Fragment implements LoaderManager.LoaderCallbacks{
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";
    private static final int CONFERENCE_LOADER = 5;

    /**
     * The dummy content this fragment is presenting.
     */
    private DummyContent.DummyItem mItem;
    private TextView mTitleTextView;
    private TextView mDescriptionTextView;
    private Cursor mCursor;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ConferenceDetailFragment() {
    }

    public static ConferenceDetailFragment newInstance(Long id){
        Bundle bundle = new Bundle();
        bundle.putLong(ARG_ITEM_ID, id);
        ConferenceDetailFragment fragment = new ConferenceDetailFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getLoaderManager().initLoader(CONFERENCE_LOADER, getArguments(), this);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            mItem = DummyContent.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_conference_detail, container, false);


        mTitleTextView = (TextView)rootView.findViewById(R.id.conference_detail_title);
        mDescriptionTextView = (TextView)rootView.findViewById(R.id.conference_detail_description);

        return rootView;
    }

    @Override
    public Loader onCreateLoader(int id, Bundle args) {
        ConferenceSelection conferenceSelection = new ConferenceSelection();
        conferenceSelection.id(args.getLong(ARG_ITEM_ID));
        return new CursorLoader(getActivity(), ConferenceColumns.CONTENT_URI, null, conferenceSelection.sel(), conferenceSelection.args(), null);
    }

    @Override
    public void onLoadFinished(Loader loader, Object data) {
        mCursor = (Cursor)data;
        mCursor.moveToFirst();
        mTitleTextView.setText(mCursor.getString(mCursor.getColumnIndex(ConferenceColumns.TITLE)));
        mDescriptionTextView.setText(mCursor.getString(mCursor.getColumnIndex(ConferenceColumns.DESCRIPTION)));


    }

    @Override
    public void onLoaderReset(Loader loader) {

    }
}
