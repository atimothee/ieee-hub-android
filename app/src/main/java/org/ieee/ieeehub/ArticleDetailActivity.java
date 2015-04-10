package org.ieee.ieeehub;

import android.content.Intent;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.ShareActionProvider;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import org.ieee.ieeehub.fragment.ArticleDetailFragment;
import org.ieee.ieeehub.fragment.ConferenceDetailFragment;


public class ArticleDetailActivity extends ActionBarActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_detail);
        if (savedInstanceState == null) {
            // Create the detail fragment and add it to the activity
            // using a fragment transaction.
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.article_detail_container, ArticleDetailFragment.newInstance(getIntent().getLongExtra(ArticleDetailFragment.ARG_ITEM_ID, 0)))
                    .commit();
        }
    }





}
