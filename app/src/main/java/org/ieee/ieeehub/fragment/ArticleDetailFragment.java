package org.ieee.ieeehub.fragment;

import android.database.Cursor;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.ieee.ieeehub.R;
import org.ieee.ieeehub.provider.article.ArticleColumns;
import org.ieee.ieeehub.provider.article.ArticleSelection;


/**
 * A placeholder fragment containing a simple view.
 */
public class ArticleDetailFragment extends Fragment implements LoaderManager.LoaderCallbacks{

    public static final String ARG_ITEM_ID = "item_id";
    private static final int ARTICLE_LOADER = 4;
    private Cursor mCursor;
    private TextView titleTextView;
    private TextView textTextView;

    public ArticleDetailFragment() {
    }

    public static ArticleDetailFragment newInstance(Long id){
        ArticleDetailFragment fragment = new ArticleDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putLong(ARG_ITEM_ID, id);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getLoaderManager().initLoader(ARTICLE_LOADER, getArguments(), this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_article_detail, container, false);
        titleTextView = (TextView)rootView.findViewById(R.id.article_detail_title);
        textTextView = (TextView)rootView.findViewById(R.id.article_detail_text);
        return rootView;
    }

    @Override
    public Loader onCreateLoader(int id, Bundle args) {
        ArticleSelection articleSelection = new ArticleSelection();
        articleSelection.id(args.getLong(ARG_ITEM_ID));
        return new CursorLoader(getActivity(), ArticleColumns.CONTENT_URI, null, articleSelection.sel(), articleSelection.args(), null);
    }

    @Override
    public void onLoadFinished(Loader loader, Object data) {
        mCursor = (Cursor)data;
        mCursor.moveToFirst();
        titleTextView.setText(mCursor.getString(mCursor.getColumnIndex(ArticleColumns.TITLE)));
        textTextView.setText(mCursor.getString(mCursor.getColumnIndex(ArticleColumns.TEXT)));
    }

    @Override
    public void onLoaderReset(Loader loader) {

    }
}
