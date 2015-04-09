package org.ieee.ieeehub.sync;

/**
 * Created by Timo on 4/6/15.
 */

import android.accounts.Account;
import android.content.AbstractThreadedSyncAdapter;
import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.SyncResult;
import android.net.Uri;
import android.os.Bundle;

import com.appspot.ieee_hub.ieeehub.Ieeehub;
import com.appspot.ieee_hub.ieeehub.model.ApiApiEndpointsArticleCollectionMessage;
import com.appspot.ieee_hub.ieeehub.model.ApiApiEndpointsArticleMessage;
import com.appspot.ieee_hub.ieeehub.model.ApiApiEndpointsCategoryCollectionMessage;
import com.appspot.ieee_hub.ieeehub.model.ApiApiEndpointsCategoryMessage;
import com.appspot.ieee_hub.ieeehub.model.ApiApiEndpointsConferenceCollectionMessage;
import com.appspot.ieee_hub.ieeehub.model.ApiApiEndpointsConferenceMessage;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.json.gson.GsonFactory;

import org.ieee.ieeehub.provider.article.ArticleColumns;
import org.ieee.ieeehub.provider.articleimage.ArticleImageContentValues;
import org.ieee.ieeehub.provider.articletag.ArticleTagContentValues;
import org.ieee.ieeehub.provider.category.CategoryColumns;
import org.ieee.ieeehub.provider.conference.ConferenceColumns;
import org.ieee.ieeehub.provider.conferencesponsor.ConferenceSponsorContentValues;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * Handle the transfer of data between a server and an
 * app, using the Android sync adapter framework.
 */
public class SyncAdapter extends AbstractThreadedSyncAdapter {

    // Global variables
    // Define a variable to contain a content resolver instance
    ContentResolver mContentResolver;

    /**
     * Set up the sync adapter
     */
    public SyncAdapter(Context context, boolean autoInitialize) {
        super(context, autoInitialize);
        /*
         * If your app uses a content resolver, get an instance of it
         * from the incoming Context
         */
        mContentResolver = context.getContentResolver();
    }

    /**
     * Set up the sync adapter. This form of the
     * constructor maintains compatibility with Android 3.0
     * and later platform versions
     */
    public SyncAdapter(
            Context context,
            boolean autoInitialize,
            boolean allowParallelSyncs) {
        super(context, autoInitialize, allowParallelSyncs);
        /*
         * If your app uses a content resolver, get an instance of it
         * from the incoming Context
         */
        mContentResolver = context.getContentResolver();

    }

    @Override
    public void onPerformSync(Account account, Bundle extras, String authority, ContentProviderClient provider, SyncResult syncResult) {

        Ieeehub.Builder builder = new Ieeehub.Builder(AndroidHttp.newCompatibleTransport(), new GsonFactory(), null);
        Ieeehub  service = builder.build();
        try {
            ApiApiEndpointsCategoryCollectionMessage categoryCollectionMessage = service.categories().list().execute();
            List<ContentValues> contentValuesList = new ArrayList<>();
            ContentValues contentValues = null;
            for(ApiApiEndpointsCategoryMessage category: categoryCollectionMessage.getItems()){
                contentValues = new ContentValues();
                contentValues.put(CategoryColumns._ID, category.getId());
                contentValues.put(CategoryColumns.NAME, category.getName());
                contentValues.put(CategoryColumns.COLOR, category.getColor());
                contentValuesList.add(contentValues);
            }
            mContentResolver.bulkInsert(CategoryColumns.CONTENT_URI, contentValuesList.toArray(new ContentValues[contentValuesList.size()]));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            ApiApiEndpointsArticleCollectionMessage articleCollectionMessage = service.articles().articlesList().execute();
            for(ApiApiEndpointsArticleMessage article: articleCollectionMessage.getItems()){
                ContentValues contentValues = new ContentValues();
                contentValues.put(ArticleColumns._ID, article.getId());
                contentValues.put(ArticleColumns.TITLE, article.getTitle());
                contentValues.put(ArticleColumns.TEXT, article.getText());
                contentValues.put(ArticleColumns.CATEGORY_ID, article.getCategoryId());
                contentValues.put(ArticleColumns.LINK, article.getLink());
                contentValues.put(ArticleColumns.PUB_DATE, article.getPubDate().getValue());
                contentValues.put(ArticleColumns.IMAGE, article.getImageUrls().get(0));
                Uri uri = mContentResolver.insert(ArticleColumns.CONTENT_URI, contentValues);

                for(String url: article.getImageUrls()){
                    ArticleImageContentValues imageContentValues = new ArticleImageContentValues();
                    imageContentValues.putUrl(url);
                    imageContentValues.putArticleId(Long.valueOf(uri.getPathSegments().get(1)));
                    imageContentValues.insert(mContentResolver);
                }
                for(String tag: article.getTags()){
                    ArticleTagContentValues tagContentValues = new ArticleTagContentValues();
                    tagContentValues.putName(tag);
                    tagContentValues.putArticleId(Long.valueOf(uri.getPathSegments().get(1)));
                    tagContentValues.insert(mContentResolver);
                }
            }} catch (IOException e) {
            e.printStackTrace();
        }
        try {
            ApiApiEndpointsConferenceCollectionMessage conferenceCollectionMessage = service.conferences().conferencesList().execute();
            ContentValues contentValues = null;
            List<ContentValues> contentValuesList = new ArrayList<>();
            for(ApiApiEndpointsConferenceMessage conference: conferenceCollectionMessage.getItems()){
                contentValues = new ContentValues();
                contentValues.put(ConferenceColumns._ID, conference.getId());
                contentValues.put(ConferenceColumns.TITLE, conference.getTitle());
                contentValues.put(ConferenceColumns.ATTENDANCE, conference.getAttendance());
                contentValues.put(ConferenceColumns.NUMBER, conference.getNumber());
                contentValues.put(ConferenceColumns.CONTACT, conference.getContact());
                contentValues.put(ConferenceColumns.DESCRIPTION, conference.getDescription());
                contentValues.put(ConferenceColumns.DISPLAY_DATE, conference.getDates());
                contentValues.put(ConferenceColumns.START_DATE, conference.getStartDate().getValue());
                contentValues.put(ConferenceColumns.END_DATE, conference.getEndDate().getValue());
                contentValues.put(ConferenceColumns.LOCATION, conference.getLocation());
                contentValues.put(ConferenceColumns.LINK, conference.getLink());
                contentValues.put(ConferenceColumns.WEBSITE, conference.getWebsite());
                contentValues.put(ConferenceColumns.REGION, conference.getRegion());
                contentValues.put(ConferenceColumns.CALL_URL, conference.getCallForPapersUrl());
                Uri uri = mContentResolver.insert(ConferenceColumns.CONTENT_URI, contentValues);
                for(String sponsor: conference.getSponsors()) {
                    ConferenceSponsorContentValues conferenceSponsorContentValues = new ConferenceSponsorContentValues();
                    conferenceSponsorContentValues.putConferenceId(Long.valueOf(uri.getPathSegments().get(1)));
                    conferenceSponsorContentValues.putName(sponsor);
                    conferenceSponsorContentValues.insert(mContentResolver);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
