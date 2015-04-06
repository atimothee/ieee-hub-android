package org.ieee.ieeehub.provider.conferencesponsor;

import android.net.Uri;
import android.provider.BaseColumns;

import org.ieee.ieeehub.provider.IEEEHubProvider;
import org.ieee.ieeehub.provider.article.ArticleColumns;
import org.ieee.ieeehub.provider.articleimage.ArticleImageColumns;
import org.ieee.ieeehub.provider.category.CategoryColumns;
import org.ieee.ieeehub.provider.conference.ConferenceColumns;
import org.ieee.ieeehub.provider.conferencesponsor.ConferenceSponsorColumns;

/**
 * Columns for the {@code conference_sponsor} table.
 */
public class ConferenceSponsorColumns implements BaseColumns {
    public static final String TABLE_NAME = "conference_sponsor";
    public static final Uri CONTENT_URI = Uri.parse(IEEEHubProvider.CONTENT_URI_BASE + "/" + TABLE_NAME);

    /**
     * Primary key.
     */
    public static final String _ID = BaseColumns._ID;

    public static final String CONFERENCE_ID = "conference_id";

    public static final String NAME = "name";


    public static final String DEFAULT_ORDER = TABLE_NAME + "." +_ID;

    // @formatter:off
    public static final String[] ALL_COLUMNS = new String[] {
            _ID,
            CONFERENCE_ID,
            NAME
    };
    // @formatter:on

    public static boolean hasColumns(String[] projection) {
        if (projection == null) return true;
        for (String c : projection) {
            if (c.equals(CONFERENCE_ID) || c.contains("." + CONFERENCE_ID)) return true;
            if (c.equals(NAME) || c.contains("." + NAME)) return true;
        }
        return false;
    }

    public static final String PREFIX_CONFERENCE = TABLE_NAME + "__" + ConferenceColumns.TABLE_NAME;
}
