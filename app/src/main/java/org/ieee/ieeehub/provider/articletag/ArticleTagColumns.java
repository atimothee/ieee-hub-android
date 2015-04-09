package org.ieee.ieeehub.provider.articletag;

import android.net.Uri;
import android.provider.BaseColumns;

import org.ieee.ieeehub.provider.IEEEHubProvider;
import org.ieee.ieeehub.provider.article.ArticleColumns;
import org.ieee.ieeehub.provider.articleimage.ArticleImageColumns;
import org.ieee.ieeehub.provider.articletag.ArticleTagColumns;
import org.ieee.ieeehub.provider.category.CategoryColumns;
import org.ieee.ieeehub.provider.conference.ConferenceColumns;
import org.ieee.ieeehub.provider.conferencesponsor.ConferenceSponsorColumns;

/**
 * Columns for the {@code article_tag} table.
 */
public class ArticleTagColumns implements BaseColumns {
    public static final String TABLE_NAME = "article_tag";
    public static final Uri CONTENT_URI = Uri.parse(IEEEHubProvider.CONTENT_URI_BASE + "/" + TABLE_NAME);

    /**
     * Primary key.
     */
    public static final String _ID = BaseColumns._ID;

    public static final String ARTICLE_ID = "article_id";

    public static final String NAME = "article_tag__name";


    public static final String DEFAULT_ORDER = TABLE_NAME + "." +_ID;

    // @formatter:off
    public static final String[] ALL_COLUMNS = new String[] {
            _ID,
            ARTICLE_ID,
            NAME
    };
    // @formatter:on

    public static boolean hasColumns(String[] projection) {
        if (projection == null) return true;
        for (String c : projection) {
            if (c.equals(ARTICLE_ID) || c.contains("." + ARTICLE_ID)) return true;
            if (c.equals(NAME) || c.contains("." + NAME)) return true;
        }
        return false;
    }

    public static final String PREFIX_ARTICLE = TABLE_NAME + "__" + ArticleColumns.TABLE_NAME;
}
