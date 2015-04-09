package org.ieee.ieeehub.provider;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.DefaultDatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.util.Log;

import org.ieee.ieeehub.BuildConfig;
import org.ieee.ieeehub.provider.article.ArticleColumns;
import org.ieee.ieeehub.provider.articleimage.ArticleImageColumns;
import org.ieee.ieeehub.provider.articletag.ArticleTagColumns;
import org.ieee.ieeehub.provider.category.CategoryColumns;
import org.ieee.ieeehub.provider.conference.ConferenceColumns;
import org.ieee.ieeehub.provider.conferencesponsor.ConferenceSponsorColumns;

public class IEEEHubSQLiteOpenHelper extends SQLiteOpenHelper {
    private static final String TAG = IEEEHubSQLiteOpenHelper.class.getSimpleName();

    public static final String DATABASE_FILE_NAME = "ieeehub.db";
    private static final int DATABASE_VERSION = 1;
    private static IEEEHubSQLiteOpenHelper sInstance;
    private final Context mContext;
    private final IEEEHubSQLiteOpenHelperCallbacks mOpenHelperCallbacks;

    // @formatter:off
    public static final String SQL_CREATE_TABLE_ARTICLE = "CREATE TABLE IF NOT EXISTS "
            + ArticleColumns.TABLE_NAME + " ( "
            + ArticleColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + ArticleColumns.TITLE + " TEXT NOT NULL, "
            + ArticleColumns.TEXT + " TEXT, "
            + ArticleColumns.PUB_DATE + " INTEGER, "
            + ArticleColumns.CATEGORY_ID + " INTEGER, "
            + ArticleColumns.IMAGE + " TEXT, "
            + ArticleColumns.LINK + " TEXT "
            + ", CONSTRAINT fk_category_id FOREIGN KEY (" + ArticleColumns.CATEGORY_ID + ") REFERENCES category (_id) ON DELETE CASCADE"
            + " );";

    public static final String SQL_CREATE_TABLE_ARTICLE_IMAGE = "CREATE TABLE IF NOT EXISTS "
            + ArticleImageColumns.TABLE_NAME + " ( "
            + ArticleImageColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + ArticleImageColumns.ARTICLE_ID + " INTEGER, "
            + ArticleImageColumns.URL + " TEXT NOT NULL "
            + ", CONSTRAINT fk_article_id FOREIGN KEY (" + ArticleImageColumns.ARTICLE_ID + ") REFERENCES conference (_id) ON DELETE CASCADE"
            + " );";

    public static final String SQL_CREATE_TABLE_ARTICLE_TAG = "CREATE TABLE IF NOT EXISTS "
            + ArticleTagColumns.TABLE_NAME + " ( "
            + ArticleTagColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + ArticleTagColumns.ARTICLE_ID + " INTEGER, "
            + ArticleTagColumns.NAME + " TEXT NOT NULL "
            + ", CONSTRAINT fk_article_id FOREIGN KEY (" + ArticleTagColumns.ARTICLE_ID + ") REFERENCES article (_id) ON DELETE CASCADE"
            + " );";

    public static final String SQL_CREATE_TABLE_CATEGORY = "CREATE TABLE IF NOT EXISTS "
            + CategoryColumns.TABLE_NAME + " ( "
            + CategoryColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + CategoryColumns.NAME + " TEXT NOT NULL, "
            + CategoryColumns.LINK + " TEXT, "
            + CategoryColumns.COLOR + " TEXT "
            + " );";

    public static final String SQL_CREATE_TABLE_CONFERENCE = "CREATE TABLE IF NOT EXISTS "
            + ConferenceColumns.TABLE_NAME + " ( "
            + ConferenceColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + ConferenceColumns.TITLE + " TEXT NOT NULL, "
            + ConferenceColumns.DESCRIPTION + " TEXT, "
            + ConferenceColumns.START_DATE + " INTEGER, "
            + ConferenceColumns.END_DATE + " INTEGER, "
            + ConferenceColumns.DISPLAY_DATE + " TEXT, "
            + ConferenceColumns.CONTACT + " TEXT, "
            + ConferenceColumns.CALL_URL + " TEXT, "
            + ConferenceColumns.LOCATION + " TEXT, "
            + ConferenceColumns.LINK + " TEXT, "
            + ConferenceColumns.NUMBER + " INTEGER, "
            + ConferenceColumns.ATTENDANCE + " INTEGER, "
            + ConferenceColumns.REGION + " TEXT, "
            + ConferenceColumns.WEBSITE + " TEXT "
            + " );";

    public static final String SQL_CREATE_TABLE_CONFERENCE_SPONSOR = "CREATE TABLE IF NOT EXISTS "
            + ConferenceSponsorColumns.TABLE_NAME + " ( "
            + ConferenceSponsorColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + ConferenceSponsorColumns.CONFERENCE_ID + " INTEGER, "
            + ConferenceSponsorColumns.NAME + " TEXT NOT NULL "
            + ", CONSTRAINT fk_conference_id FOREIGN KEY (" + ConferenceSponsorColumns.CONFERENCE_ID + ") REFERENCES conference (_id) ON DELETE CASCADE"
            + " );";

    // @formatter:on

    public static IEEEHubSQLiteOpenHelper getInstance(Context context) {
        // Use the application context, which will ensure that you
        // don't accidentally leak an Activity's context.
        // See this article for more information: http://bit.ly/6LRzfx
        if (sInstance == null) {
            sInstance = newInstance(context.getApplicationContext());
        }
        return sInstance;
    }

    private static IEEEHubSQLiteOpenHelper newInstance(Context context) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB) {
            return newInstancePreHoneycomb(context);
        }
        return newInstancePostHoneycomb(context);
    }


    /*
     * Pre Honeycomb.
     */
    private static IEEEHubSQLiteOpenHelper newInstancePreHoneycomb(Context context) {
        return new IEEEHubSQLiteOpenHelper(context);
    }

    private IEEEHubSQLiteOpenHelper(Context context) {
        super(context, DATABASE_FILE_NAME, null, DATABASE_VERSION);
        mContext = context;
        mOpenHelperCallbacks = new IEEEHubSQLiteOpenHelperCallbacks();
    }


    /*
     * Post Honeycomb.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private static IEEEHubSQLiteOpenHelper newInstancePostHoneycomb(Context context) {
        return new IEEEHubSQLiteOpenHelper(context, new DefaultDatabaseErrorHandler());
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private IEEEHubSQLiteOpenHelper(Context context, DatabaseErrorHandler errorHandler) {
        super(context, DATABASE_FILE_NAME, null, DATABASE_VERSION, errorHandler);
        mContext = context;
        mOpenHelperCallbacks = new IEEEHubSQLiteOpenHelperCallbacks();
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        if (BuildConfig.DEBUG) Log.d(TAG, "onCreate");
        mOpenHelperCallbacks.onPreCreate(mContext, db);
        db.execSQL(SQL_CREATE_TABLE_ARTICLE);
        db.execSQL(SQL_CREATE_TABLE_ARTICLE_IMAGE);
        db.execSQL(SQL_CREATE_TABLE_ARTICLE_TAG);
        db.execSQL(SQL_CREATE_TABLE_CATEGORY);
        db.execSQL(SQL_CREATE_TABLE_CONFERENCE);
        db.execSQL(SQL_CREATE_TABLE_CONFERENCE_SPONSOR);
        mOpenHelperCallbacks.onPostCreate(mContext, db);
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        if (!db.isReadOnly()) {
            setForeignKeyConstraintsEnabled(db);
        }
        mOpenHelperCallbacks.onOpen(mContext, db);
    }

    private void setForeignKeyConstraintsEnabled(SQLiteDatabase db) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
            setForeignKeyConstraintsEnabledPreJellyBean(db);
        } else {
            setForeignKeyConstraintsEnabledPostJellyBean(db);
        }
    }

    private void setForeignKeyConstraintsEnabledPreJellyBean(SQLiteDatabase db) {
        db.execSQL("PRAGMA foreign_keys=ON;");
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private void setForeignKeyConstraintsEnabledPostJellyBean(SQLiteDatabase db) {
        db.setForeignKeyConstraintsEnabled(true);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        mOpenHelperCallbacks.onUpgrade(mContext, db, oldVersion, newVersion);
    }
}
