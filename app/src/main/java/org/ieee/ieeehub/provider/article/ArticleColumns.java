package org.ieee.ieeehub.provider.article;

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
 * Columns for the {@code article} table.
 */
public class ArticleColumns implements BaseColumns {
    public static final String TABLE_NAME = "article";
    public static final Uri CONTENT_URI = Uri.parse(IEEEHubProvider.CONTENT_URI_BASE + "/" + TABLE_NAME);

    /**
     * Primary key.
     */
    public static final String _ID = BaseColumns._ID;

    public static final String TITLE = "title";

    public static final String TEXT = "text";

    public static final String PUB_DATE = "pub_date";

    public static final String CATEGORY_ID = "category_id";

    public static final String IMAGE = "image";

    public static final String LINK = "article__link";


    public static final String DEFAULT_ORDER = TABLE_NAME + "." +_ID;

    // @formatter:off
    public static final String[] ALL_COLUMNS = new String[] {
            _ID,
            TITLE,
            TEXT,
            PUB_DATE,
            CATEGORY_ID,
            IMAGE,
            LINK
    };
    // @formatter:on

    public static boolean hasColumns(String[] projection) {
        if (projection == null) return true;
        for (String c : projection) {
            if (c.equals(TITLE) || c.contains("." + TITLE)) return true;
            if (c.equals(TEXT) || c.contains("." + TEXT)) return true;
            if (c.equals(PUB_DATE) || c.contains("." + PUB_DATE)) return true;
            if (c.equals(CATEGORY_ID) || c.contains("." + CATEGORY_ID)) return true;
            if (c.equals(IMAGE) || c.contains("." + IMAGE)) return true;
            if (c.equals(LINK) || c.contains("." + LINK)) return true;
        }
        return false;
    }

    public static final String PREFIX_CATEGORY = TABLE_NAME + "__" + CategoryColumns.TABLE_NAME;
}
