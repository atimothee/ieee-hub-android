package org.ieee.ieeehub.provider.articleimage;

import android.net.Uri;
import android.provider.BaseColumns;

import org.ieee.ieeehub.provider.IEEEHubProvider;
import org.ieee.ieeehub.provider.article.ArticleColumns;
import org.ieee.ieeehub.provider.articleimage.ArticleImageColumns;
import org.ieee.ieeehub.provider.category.CategoryColumns;
import org.ieee.ieeehub.provider.conference.ConferenceColumns;
import org.ieee.ieeehub.provider.conferencesponsor.ConferenceSponsorColumns;
import org.ieee.ieeehub.provider.conferencetag.ConferenceTagColumns;

/**
 * Columns for the {@code article_image} table.
 */
public class ArticleImageColumns implements BaseColumns {
    public static final String TABLE_NAME = "article_image";
    public static final Uri CONTENT_URI = Uri.parse(IEEEHubProvider.CONTENT_URI_BASE + "/" + TABLE_NAME);

    /**
     * Primary key.
     */
    public static final String _ID = BaseColumns._ID;

    public static final String ARTICLE_ID = "article_id";

    public static final String URL = "url";


    public static final String DEFAULT_ORDER = TABLE_NAME + "." +_ID;

    // @formatter:off
    public static final String[] ALL_COLUMNS = new String[] {
            _ID,
            ARTICLE_ID,
            URL
    };
    // @formatter:on

    public static boolean hasColumns(String[] projection) {
        if (projection == null) return true;
        for (String c : projection) {
            if (c.equals(ARTICLE_ID) || c.contains("." + ARTICLE_ID)) return true;
            if (c.equals(URL) || c.contains("." + URL)) return true;
        }
        return false;
    }

    public static final String PREFIX_CONFERENCE = TABLE_NAME + "__" + ConferenceColumns.TABLE_NAME;
}
