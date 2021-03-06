package org.ieee.ieeehub;

import android.accounts.Account;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.ieee.ieeehub.fragment.ArticleDetailFragment;
import org.ieee.ieeehub.fragment.ArticlesFragment;
import org.ieee.ieeehub.fragment.ConferenceDetailFragment;
import org.ieee.ieeehub.fragment.ConferenceListFragment;
import org.ieee.ieeehub.helper.AccountHelper;
import org.ieee.ieeehub.provider.IEEEHubProvider;
import org.ieee.ieeehub.provider.category.CategoryColumns;


public class NavigationDrawerActivity extends ActionBarActivity implements ArticlesFragment.OnFragmentInteractionListener, ActionBar.TabListener , LoaderManager.LoaderCallbacks, ConferenceListFragment.Callbacks{

    private static final String TAG = NavigationDrawerActivity.class.getSimpleName();
    private static final int CATEG0RIES_LOADER = 0;

    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;

    private CharSequence mDrawerTitle;
    private CharSequence mTitle;
    private String[] mDrawerItmes;
    ArticlePagerAdapter mSectionsPagerAdapter;
    private Cursor mCursor;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AccountHelper accountHelper = new AccountHelper(NavigationDrawerActivity.this);
        Bundle bundle = new Bundle();
        bundle.putBoolean(ContentResolver.SYNC_EXTRAS_EXPEDITED, true);
        bundle.putBoolean(ContentResolver.SYNC_EXTRAS_MANUAL, true);
        //bundle.putString("type", "article");
        Account account = accountHelper.CreateSyncAccount();
        Log.d(TAG, "account "+account.toString());

        ContentResolver.setSyncAutomatically(accountHelper.CreateSyncAccount(), IEEEHubProvider.AUTHORITY, true);
        ContentResolver.requestSync(accountHelper.CreateSyncAccount(), IEEEHubProvider.AUTHORITY, bundle);
        mSectionsPagerAdapter = new ArticlePagerAdapter(getSupportFragmentManager(), null);
        getSupportLoaderManager().initLoader(CATEG0RIES_LOADER, savedInstanceState, this);
        setContentView(R.layout.activity_navigation_drawer);
        mViewPager = (ViewPager)findViewById(R.id.pager);


        mTitle = mDrawerTitle = getTitle();

        mDrawerItmes = getResources().getStringArray(R.array.drawer_titles);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);

        // set a custom shadow that overlays the main content when the drawer opens
        mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow,  GravityCompat.START);

        // Add items to the ListView
        mDrawerList.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mDrawerItmes));
        // Set the OnItemClickListener so something happens when a
        // user clicks on an item.
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

        // Enable ActionBar app icon to behave as action to toggle the NavigationDrawer
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        mDrawerToggle = new ActionBarDrawerToggle(
                this,
                mDrawerLayout,
                R.drawable.ic_drawer,
                R.string.drawer_open,
                R.string.drawer_close
        ) {
            public void onDrawerClosed(View view) {
                getSupportActionBar().setTitle(mTitle);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu
            }

            public void onDrawerOpened(View drawerView) {
                getSupportActionBar().setTitle(mDrawerTitle);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu
            }
        };

        mDrawerLayout.setDrawerListener(mDrawerToggle);

        // Set the default content area to item 0
        // when the app opens for the first time
        if(savedInstanceState == null) {
            navigateTo(0);
            Log.d(TAG, "navigated to zero");
        }

    }

    /*
     * If you do not have any menus, you still need this function
     * in order to open or close the NavigationDrawer when the user
     * clicking the ActionBar app icon.
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /*
     * When using the ActionBarDrawerToggle, you must call it during onPostCreate()
     * and onConfigurationChanged()
     */

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public void onFragmentInteraction(Long id) {
        Intent i = new Intent(this, ArticleDetailActivity.class);
        i.putExtra(ArticleDetailFragment.ARG_ITEM_ID, id);
        startActivity(i);

    }

    @Override
    public Loader onCreateLoader(int id, Bundle args) {
        return new CursorLoader(this, CategoryColumns.CONTENT_URI, null, null, null, null);
    }

    @Override
    public void onLoadFinished(Loader loader, Object data) {
        if(loader.getId()==CATEG0RIES_LOADER) {
            mCursor = (Cursor) data;
            Cursor cursor = (Cursor) data;
            cursor.moveToFirst();
            mSectionsPagerAdapter = new ArticlePagerAdapter(getSupportFragmentManager(), (Cursor) data);
            Log.d(TAG, "cursor loaded");
            navigateTo(0);
            setTitle("Spectrum");
        }
    }

    @Override
    public void onLoaderReset(Loader loader) {

    }

    @Override
    public void onItemSelected(Long id) {
        Intent i = new Intent(this, ConferenceDetailActivity.class);
        i.putExtra(ConferenceDetailFragment.ARG_ITEM_ID, id);
        startActivity(i);

    }

    private class DrawerItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            mTitle =  mDrawerItmes[position];
            navigateTo(position);
        }
    }

    private void navigateTo(int position) {
        //mViewPager = (ViewPager)findViewById(R.id.pager);

        if(position==0){
            mSectionsPagerAdapter = new ArticlePagerAdapter(getSupportFragmentManager(), mCursor);
            mViewPager.setAdapter(mSectionsPagerAdapter);
            final ActionBar actionBar = getSupportActionBar();
            actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
            actionBar.removeAllTabs();
            mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
                @Override
                public void onPageSelected(int position) {
                    actionBar.setSelectedNavigationItem(position);
                }
            });
            for (int i = 0; i < mSectionsPagerAdapter.getCount(); i++) {
                // Create a tab with text corresponding to the page title defined by
                // the adapter. Also specify this Activity object, which implements
                // the TabListener interface, as the callback (listener) for when
                // this tab is selected.
                actionBar.addTab(
                        actionBar.newTab()
                                .setText(mSectionsPagerAdapter.getPageTitle(i))
                                .setTabListener(this));
            }

        }else if(position==1){

            ConferencePagerAdapter adapter = new ConferencePagerAdapter(getSupportFragmentManager());
            mViewPager.setAdapter(adapter);
                final ActionBar actionBar = getSupportActionBar();
                actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
            actionBar.removeAllTabs();
            mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
                @Override
                public void onPageSelected(int position) {
                    actionBar.setSelectedNavigationItem(position);
                }
            });


            for (int i = 0; i < adapter.getCount(); i++) {
                    // Create a tab with text corresponding to the page title defined by
                    // the adapter. Also specify this Activity object, which implements
                    // the TabListener interface, as the callback (listener) for when
                    // this tab is selected.
                    actionBar.addTab(
                            actionBar.newTab()
                                    .setText(adapter.getPageTitle(i))
                                    .setTabListener(this));
                }
        }
        mDrawerLayout.closeDrawer(mDrawerList);
    }

    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        getSupportActionBar().setTitle(mTitle);
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        // When the given tab is selected, switch to the corresponding page in
        // the ViewPager.
        mViewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class ArticlePagerAdapter extends FragmentStatePagerAdapter {
        private Cursor mCursor;

        public ArticlePagerAdapter(FragmentManager fm, Cursor cursor) {
            super(fm);
            this.mCursor = cursor;
        }

        @Override
        public Fragment getItem(int position) {
            mCursor.moveToPosition(position);
            return ArticlesFragment.newInstance(mCursor.getLong(mCursor.getColumnIndex(CategoryColumns._ID)));
        }

        @Override
        public int getCount() {
            if(mCursor !=null) {
                return mCursor.getCount();
            }else {
                return 0;
            }
        }

        @Override
        public CharSequence getPageTitle(int position) {
            mCursor.moveToPosition(position);
            return mCursor.getString(mCursor.getColumnIndex(CategoryColumns.NAME));
        }
    }

    public class ConferencePagerAdapter extends FragmentStatePagerAdapter {

        public ConferencePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return new ConferenceListFragment();
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position){
                case 0:
                    return "Upcoming";
                case 1:
                    return "Favorites";
            }
            return "";
        }
    }
}
