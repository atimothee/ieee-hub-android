package org.ieee.ieeehub.fragment;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;


import com.squareup.picasso.Picasso;

import org.ieee.ieeehub.R;
import org.ieee.ieeehub.provider.article.ArticleColumns;
import org.ieee.ieeehub.provider.article.ArticleSelection;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Large screen devices (such as tablets) are supported by replacing the ListView
 * with a GridView.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnFragmentInteractionListener}
 * interface.
 */
public class ArticlesFragment extends Fragment implements AbsListView.OnItemClickListener, LoaderManager.LoaderCallbacks {

    public static final String TAG = ArticlesFragment.class.getSimpleName();
    private static final int ARTICLE_LOADER = 1;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "category_id";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private Long mParam1;
    private String mParam2;

    private String[] COLUMNS = {ArticleColumns.TITLE, ArticleColumns.IMAGE};
    private int[] VIEW_IDS = {R.id.article_item_title, R.id.article_item_image};

    private OnFragmentInteractionListener mListener;

    /**
     * The fragment's ListView/GridView.
     */
    private AbsListView mListView;

    /**
     * The Adapter which will be used to populate the ListView/GridView with
     * Views.
     */
    private SimpleCursorAdapter mAdapter;
    private Cursor mCursor;

    // TODO: Rename and change types of parameters
    public static ArticlesFragment newInstance(Long param1) {
        ArticlesFragment fragment = new ArticlesFragment();
        Bundle args = new Bundle();
        args.putLong(ARG_PARAM1, param1);
        Log.d(TAG, "param1 "+param1);
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ArticlesFragment() {
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getLoaderManager().initLoader(ARTICLE_LOADER, getArguments(), this);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getLong(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        mAdapter = new SimpleCursorAdapter(getActivity(), R.layout.article_item, mCursor, COLUMNS, VIEW_IDS, 0);
        mAdapter.setViewBinder(new SimpleCursorAdapter.ViewBinder() {
            @Override
            public boolean setViewValue(View view, Cursor cursor, int i) {
                if(view.getId()==R.id.article_item_image){
                    Picasso.with(getActivity()).load("http://spectrum.ieee.org"+cursor.getString(cursor.getColumnIndex(ArticleColumns.IMAGE))).into((ImageView)view);
                    return true;
                }
                return false;
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_article, container, false);

        // Set the adapter
        mListView = (AbsListView) view.findViewById(android.R.id.list);
        ((AdapterView<ListAdapter>) mListView).setAdapter(mAdapter);

        // Set OnItemClickListener so we can be notified on item clicks
        mListView.setOnItemClickListener(this);

        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (null != mListener) {
            // Notify the active callbacks interface (the activity, if the
            // fragment is attached to one) that an item has been selected.
            mCursor.moveToPosition(position);
            Log.d(TAG, "article id " + mCursor.getLong(mCursor.getColumnIndex(ArticleColumns._ID)));
            Log.d(TAG, "category id " + mCursor.getLong(mCursor.getColumnIndex(ArticleColumns.CATEGORY_ID)));
            Log.d(TAG, "article title "+mCursor.getString(mCursor.getColumnIndex(ArticleColumns.TITLE)));
            Log.d(TAG, "cursor "+mCursor.toString());
            mListener.onFragmentInteraction(mCursor.getLong(mCursor.getColumnIndex(ArticleColumns._ID)));
        }
    }

    /**
     * The default content for this Fragment has a TextView that is shown when
     * the list is empty. If you would like to change the text, call this method
     * to supply the text it should use.
     */
    public void setEmptyText(CharSequence emptyText) {
        View emptyView = mListView.getEmptyView();

        if (emptyView instanceof TextView) {
            ((TextView) emptyView).setText(emptyText);
        }
    }

    @Override
    public Loader onCreateLoader(int id, Bundle args) {
        ArticleSelection articleSelection = new ArticleSelection();
        articleSelection.categoryId((args.getLong(ARG_PARAM1)));
        return new CursorLoader(getActivity(), ArticleColumns.CONTENT_URI, ArticleColumns.ALL_COLUMNS, articleSelection.sel(), articleSelection.args(), null);
    }

    @Override
    public void onLoadFinished(Loader loader, Object data) {
        mCursor = (Cursor)data;
        mAdapter.swapCursor(mCursor);
    }

    @Override
    public void onLoaderReset(Loader loader) {

    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        public void onFragmentInteraction(Long id);
    }

}
