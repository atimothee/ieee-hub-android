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
import org.ieee.ieeehub.provider.conferencesponsor.ConferenceSponsorColumns;
import org.ieee.ieeehub.provider.conferencesponsor.ConferenceSponsorSelection;
import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Date;


public class ConferenceDetailFragment extends Fragment implements LoaderManager.LoaderCallbacks{

    public static final String ARG_ITEM_ID = "item_id";
    private static final int CONFERENCE_LOADER = 5;
    private static final int CONFERENCE_SPONSORS_LOADER = 6;
    private TextView mTitleTextView;
    private TextView mDescriptionTextView;
    private TextView mStartDateTextView;
    private TextView mEndDateTextView;
    private TextView mLocationTextView;
    private TextView mContactTextView;
    private TextView mAttendanceTextView;
    private TextView mNumberTextView;
    private TextView mRegionTextView;
    private TextView mSponsorsTextView;
    private TextView callUrlTextView;
    private TextView websiteTextView;
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
        getLoaderManager().initLoader(CONFERENCE_SPONSORS_LOADER, getArguments(), this);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_conference_detail, container, false);


        mTitleTextView = (TextView)rootView.findViewById(R.id.conference_detail_title);
        mDescriptionTextView = (TextView)rootView.findViewById(R.id.conference_detail_description);
        mStartDateTextView = (TextView)rootView.findViewById(R.id.conference_detail_start_date);
        mEndDateTextView = (TextView)rootView.findViewById(R.id.conference_detail_end_date);
        mLocationTextView = (TextView)rootView.findViewById(R.id.conference_detail_location);
        mNumberTextView = (TextView)rootView.findViewById(R.id.conference_detail_number);
        mAttendanceTextView = (TextView)rootView.findViewById(R.id.conference_detail_attendance);
        mRegionTextView = (TextView)rootView.findViewById(R.id.conference_detail_region);
        mRegionTextView = (TextView)rootView.findViewById(R.id.conference_detail_region);
        callUrlTextView = (TextView)rootView.findViewById(R.id.conference_detail_call_for_papers_link);
        mContactTextView = (TextView)rootView.findViewById(R.id.conference_detail_contact);
        websiteTextView = (TextView)rootView.findViewById(R.id.conference_detail_website);
        mSponsorsTextView = (TextView)rootView.findViewById(R.id.conference_detail_sponsors);

        return rootView;
    }

    @Override
    public Loader onCreateLoader(int id, Bundle args) {
        if(id==CONFERENCE_LOADER) {
            ConferenceSelection conferenceSelection = new ConferenceSelection();
            conferenceSelection.id(args.getLong(ARG_ITEM_ID));
            return new CursorLoader(getActivity(), ConferenceColumns.CONTENT_URI, null, conferenceSelection.sel(), conferenceSelection.args(), null);
        }
        else if(id==CONFERENCE_SPONSORS_LOADER){
            ConferenceSponsorSelection sponsorSelection = new ConferenceSponsorSelection();
            sponsorSelection.conferenceId(args.getLong(ARG_ITEM_ID));
            return new CursorLoader(getActivity(), ConferenceSponsorColumns.CONTENT_URI, ConferenceSponsorColumns.ALL_COLUMNS, sponsorSelection.sel(), sponsorSelection.args(), null);
        }
        return null;
    }

    @Override
    public void onLoadFinished(Loader loader, Object data) {
        if(loader.getId()==CONFERENCE_LOADER) {
            mCursor = (Cursor) data;
            mCursor.moveToFirst();
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            Date startDate = new Date(mCursor.getLong(mCursor.getColumnIndex(ConferenceColumns.START_DATE)));
            Date endDate = new Date(mCursor.getLong(mCursor.getColumnIndex(ConferenceColumns.END_DATE)));
            mTitleTextView.setText(mCursor.getString(mCursor.getColumnIndex(ConferenceColumns.TITLE)));
            mDescriptionTextView.setText(mCursor.getString(mCursor.getColumnIndex(ConferenceColumns.DESCRIPTION)));
            mLocationTextView.setText(mCursor.getString(mCursor.getColumnIndex(ConferenceColumns.LOCATION)));
            mStartDateTextView.setText(format.format(startDate));
            mEndDateTextView.setText(format.format(endDate));
            mLocationTextView.setText(mCursor.getString(mCursor.getColumnIndex(ConferenceColumns.LOCATION)));
            mRegionTextView.setText(mCursor.getString(mCursor.getColumnIndex(ConferenceColumns.REGION)));
            mNumberTextView.setText(mCursor.getString(mCursor.getColumnIndex(ConferenceColumns.NUMBER)));
            mAttendanceTextView.setText(mCursor.getString(mCursor.getColumnIndex(ConferenceColumns.ATTENDANCE)));
            mContactTextView.setText(mCursor.getString(mCursor.getColumnIndex(ConferenceColumns.CONTACT)));
            callUrlTextView.setText(mCursor.getString(mCursor.getColumnIndex(ConferenceColumns.CALL_URL)));
            websiteTextView.setText(mCursor.getString(mCursor.getColumnIndex(ConferenceColumns.LINK)));
        }
        else if(loader.getId()==CONFERENCE_SPONSORS_LOADER){
            Cursor cursor = (Cursor)data;
            String sponsors = "";
            cursor.moveToFirst();
            do{
                sponsors += "\n"+cursor.getString(cursor.getColumnIndex(ConferenceSponsorColumns.NAME));
            }
            while(cursor.moveToNext());
            mSponsorsTextView.setText(sponsors);
        }


    }

    @Override
    public void onLoaderReset(Loader loader) {

    }
}
