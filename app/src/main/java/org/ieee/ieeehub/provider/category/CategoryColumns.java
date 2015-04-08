package org.ieee.ieeehub.provider.category;

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
 * Columns for the {@code category} table.
 */
public class CategoryColumns implements BaseColumns {
    public static final String TABLE_NAME = "category";
    public static final Uri CONTENT_URI = Uri.parse(IEEEHubProvider.CONTENT_URI_BASE + "/" + TABLE_NAME);

    /**
     * Primary key.
     */
    public static final String _ID = BaseColumns._ID;

    public static final String NAME = "name";

    public static final String LINK = "category__link";

    public static final String COLOR = "color";


    public static final String DEFAULT_ORDER = TABLE_NAME + "." +_ID;

    // @formatter:off
    public static final String[] ALL_COLUMNS = new String[] {
            _ID,
            NAME,
            LINK,
            COLOR
    };
    // @formatter:on

    public static boolean hasColumns(String[] projection) {
        if (projection == null) return true;
        for (String c : projection) {
            if (c.equals(NAME) || c.contains("." + NAME)) return true;
            if (c.equals(LINK) || c.contains("." + LINK)) return true;
            if (c.equals(COLOR) || c.contains("." + COLOR)) return true;
        }
        return false;
    }

}
