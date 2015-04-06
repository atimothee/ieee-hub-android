package org.ieee.ieeehub.provider;

import java.util.Arrays;

import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.util.Log;

import org.ieee.ieeehub.BuildConfig;
import org.ieee.ieeehub.provider.base.BaseContentProvider;
import org.ieee.ieeehub.provider.article.ArticleColumns;
import org.ieee.ieeehub.provider.articleimage.ArticleImageColumns;
import org.ieee.ieeehub.provider.category.CategoryColumns;
import org.ieee.ieeehub.provider.conference.ConferenceColumns;
import org.ieee.ieeehub.provider.conferencesponsor.ConferenceSponsorColumns;

public class IEEEHubProvider extends BaseContentProvider {
    private static final String TAG = IEEEHubProvider.class.getSimpleName();

    private static final boolean DEBUG = BuildConfig.DEBUG;

    private static final String TYPE_CURSOR_ITEM = "vnd.android.cursor.item/";
    private static final String TYPE_CURSOR_DIR = "vnd.android.cursor.dir/";

    public static final String AUTHORITY = "org.ieee.ieeehub.provider";
    public static final String CONTENT_URI_BASE = "content://" + AUTHORITY;

    private static final int URI_TYPE_ARTICLE = 0;
    private static final int URI_TYPE_ARTICLE_ID = 1;

    private static final int URI_TYPE_ARTICLE_IMAGE = 2;
    private static final int URI_TYPE_ARTICLE_IMAGE_ID = 3;

    private static final int URI_TYPE_CATEGORY = 4;
    private static final int URI_TYPE_CATEGORY_ID = 5;

    private static final int URI_TYPE_CONFERENCE = 6;
    private static final int URI_TYPE_CONFERENCE_ID = 7;

    private static final int URI_TYPE_CONFERENCE_SPONSOR = 8;
    private static final int URI_TYPE_CONFERENCE_SPONSOR_ID = 9;



    private static final UriMatcher URI_MATCHER = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        URI_MATCHER.addURI(AUTHORITY, ArticleColumns.TABLE_NAME, URI_TYPE_ARTICLE);
        URI_MATCHER.addURI(AUTHORITY, ArticleColumns.TABLE_NAME + "/#", URI_TYPE_ARTICLE_ID);
        URI_MATCHER.addURI(AUTHORITY, ArticleImageColumns.TABLE_NAME, URI_TYPE_ARTICLE_IMAGE);
        URI_MATCHER.addURI(AUTHORITY, ArticleImageColumns.TABLE_NAME + "/#", URI_TYPE_ARTICLE_IMAGE_ID);
        URI_MATCHER.addURI(AUTHORITY, CategoryColumns.TABLE_NAME, URI_TYPE_CATEGORY);
        URI_MATCHER.addURI(AUTHORITY, CategoryColumns.TABLE_NAME + "/#", URI_TYPE_CATEGORY_ID);
        URI_MATCHER.addURI(AUTHORITY, ConferenceColumns.TABLE_NAME, URI_TYPE_CONFERENCE);
        URI_MATCHER.addURI(AUTHORITY, ConferenceColumns.TABLE_NAME + "/#", URI_TYPE_CONFERENCE_ID);
        URI_MATCHER.addURI(AUTHORITY, ConferenceSponsorColumns.TABLE_NAME, URI_TYPE_CONFERENCE_SPONSOR);
        URI_MATCHER.addURI(AUTHORITY, ConferenceSponsorColumns.TABLE_NAME + "/#", URI_TYPE_CONFERENCE_SPONSOR_ID);
    }

    @Override
    protected SQLiteOpenHelper createSqLiteOpenHelper() {
        return IEEEHubSQLiteOpenHelper.getInstance(getContext());
    }

    @Override
    protected boolean hasDebug() {
        return DEBUG;
    }

    @Override
    public String getType(Uri uri) {
        int match = URI_MATCHER.match(uri);
        switch (match) {
            case URI_TYPE_ARTICLE:
                return TYPE_CURSOR_DIR + ArticleColumns.TABLE_NAME;
            case URI_TYPE_ARTICLE_ID:
                return TYPE_CURSOR_ITEM + ArticleColumns.TABLE_NAME;

            case URI_TYPE_ARTICLE_IMAGE:
                return TYPE_CURSOR_DIR + ArticleImageColumns.TABLE_NAME;
            case URI_TYPE_ARTICLE_IMAGE_ID:
                return TYPE_CURSOR_ITEM + ArticleImageColumns.TABLE_NAME;

            case URI_TYPE_CATEGORY:
                return TYPE_CURSOR_DIR + CategoryColumns.TABLE_NAME;
            case URI_TYPE_CATEGORY_ID:
                return TYPE_CURSOR_ITEM + CategoryColumns.TABLE_NAME;

            case URI_TYPE_CONFERENCE:
                return TYPE_CURSOR_DIR + ConferenceColumns.TABLE_NAME;
            case URI_TYPE_CONFERENCE_ID:
                return TYPE_CURSOR_ITEM + ConferenceColumns.TABLE_NAME;

            case URI_TYPE_CONFERENCE_SPONSOR:
                return TYPE_CURSOR_DIR + ConferenceSponsorColumns.TABLE_NAME;
            case URI_TYPE_CONFERENCE_SPONSOR_ID:
                return TYPE_CURSOR_ITEM + ConferenceSponsorColumns.TABLE_NAME;

        }
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        if (DEBUG) Log.d(TAG, "insert uri=" + uri + " values=" + values);
        return super.insert(uri, values);
    }

    @Override
    public int bulkInsert(Uri uri, ContentValues[] values) {
        if (DEBUG) Log.d(TAG, "bulkInsert uri=" + uri + " values.length=" + values.length);
        return super.bulkInsert(uri, values);
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        if (DEBUG) Log.d(TAG, "update uri=" + uri + " values=" + values + " selection=" + selection + " selectionArgs=" + Arrays.toString(selectionArgs));
        return super.update(uri, values, selection, selectionArgs);
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        if (DEBUG) Log.d(TAG, "delete uri=" + uri + " selection=" + selection + " selectionArgs=" + Arrays.toString(selectionArgs));
        return super.delete(uri, selection, selectionArgs);
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        if (DEBUG)
            Log.d(TAG, "query uri=" + uri + " selection=" + selection + " selectionArgs=" + Arrays.toString(selectionArgs) + " sortOrder=" + sortOrder
                    + " groupBy=" + uri.getQueryParameter(QUERY_GROUP_BY) + " having=" + uri.getQueryParameter(QUERY_HAVING) + " limit=" + uri.getQueryParameter(QUERY_LIMIT));
        return super.query(uri, projection, selection, selectionArgs, sortOrder);
    }

    @Override
    protected QueryParams getQueryParams(Uri uri, String selection, String[] projection) {
        QueryParams res = new QueryParams();
        String id = null;
        int matchedId = URI_MATCHER.match(uri);
        switch (matchedId) {
            case URI_TYPE_ARTICLE:
            case URI_TYPE_ARTICLE_ID:
                res.table = ArticleColumns.TABLE_NAME;
                res.idColumn = ArticleColumns._ID;
                res.tablesWithJoins = ArticleColumns.TABLE_NAME;
                if (CategoryColumns.hasColumns(projection)) {
                    res.tablesWithJoins += " LEFT OUTER JOIN " + CategoryColumns.TABLE_NAME + " AS " + ArticleColumns.PREFIX_CATEGORY + " ON " + ArticleColumns.TABLE_NAME + "." + ArticleColumns.CATEGORY_ID + "=" + ArticleColumns.PREFIX_CATEGORY + "." + CategoryColumns._ID;
                }
                res.orderBy = ArticleColumns.DEFAULT_ORDER;
                break;

            case URI_TYPE_ARTICLE_IMAGE:
            case URI_TYPE_ARTICLE_IMAGE_ID:
                res.table = ArticleImageColumns.TABLE_NAME;
                res.idColumn = ArticleImageColumns._ID;
                res.tablesWithJoins = ArticleImageColumns.TABLE_NAME;
                if (ConferenceColumns.hasColumns(projection)) {
                    res.tablesWithJoins += " LEFT OUTER JOIN " + ConferenceColumns.TABLE_NAME + " AS " + ArticleImageColumns.PREFIX_CONFERENCE + " ON " + ArticleImageColumns.TABLE_NAME + "." + ArticleImageColumns.ARTICLE_ID + "=" + ArticleImageColumns.PREFIX_CONFERENCE + "." + ConferenceColumns._ID;
                }
                res.orderBy = ArticleImageColumns.DEFAULT_ORDER;
                break;

            case URI_TYPE_CATEGORY:
            case URI_TYPE_CATEGORY_ID:
                res.table = CategoryColumns.TABLE_NAME;
                res.idColumn = CategoryColumns._ID;
                res.tablesWithJoins = CategoryColumns.TABLE_NAME;
                res.orderBy = CategoryColumns.DEFAULT_ORDER;
                break;

            case URI_TYPE_CONFERENCE:
            case URI_TYPE_CONFERENCE_ID:
                res.table = ConferenceColumns.TABLE_NAME;
                res.idColumn = ConferenceColumns._ID;
                res.tablesWithJoins = ConferenceColumns.TABLE_NAME;
                res.orderBy = ConferenceColumns.DEFAULT_ORDER;
                break;

            case URI_TYPE_CONFERENCE_SPONSOR:
            case URI_TYPE_CONFERENCE_SPONSOR_ID:
                res.table = ConferenceSponsorColumns.TABLE_NAME;
                res.idColumn = ConferenceSponsorColumns._ID;
                res.tablesWithJoins = ConferenceSponsorColumns.TABLE_NAME;
                if (ConferenceColumns.hasColumns(projection)) {
                    res.tablesWithJoins += " LEFT OUTER JOIN " + ConferenceColumns.TABLE_NAME + " AS " + ConferenceSponsorColumns.PREFIX_CONFERENCE + " ON " + ConferenceSponsorColumns.TABLE_NAME + "." + ConferenceSponsorColumns.CONFERENCE_ID + "=" + ConferenceSponsorColumns.PREFIX_CONFERENCE + "." + ConferenceColumns._ID;
                }
                res.orderBy = ConferenceSponsorColumns.DEFAULT_ORDER;
                break;

            default:
                throw new IllegalArgumentException("The uri '" + uri + "' is not supported by this ContentProvider");
        }

        switch (matchedId) {
            case URI_TYPE_ARTICLE_ID:
            case URI_TYPE_ARTICLE_IMAGE_ID:
            case URI_TYPE_CATEGORY_ID:
            case URI_TYPE_CONFERENCE_ID:
            case URI_TYPE_CONFERENCE_SPONSOR_ID:
                id = uri.getLastPathSegment();
        }
        if (id != null) {
            if (selection != null) {
                res.selection = res.table + "." + res.idColumn + "=" + id + " and (" + selection + ")";
            } else {
                res.selection = res.table + "." + res.idColumn + "=" + id;
            }
        } else {
            res.selection = selection;
        }
        return res;
    }
}
