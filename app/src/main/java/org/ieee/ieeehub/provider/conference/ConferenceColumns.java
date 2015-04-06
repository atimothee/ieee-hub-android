package org.ieee.ieeehub.provider.conference;

import android.net.Uri;
import android.provider.BaseColumns;

import org.ieee.ieeehub.provider.IEEEHubProvider;
import org.ieee.ieeehub.provider.article.ArticleColumns;
import org.ieee.ieeehub.provider.articleimage.ArticleImageColumns;
import org.ieee.ieeehub.provider.category.CategoryColumns;
import org.ieee.ieeehub.provider.conference.ConferenceColumns;
import org.ieee.ieeehub.provider.conferencesponsor.ConferenceSponsorColumns;

/**
 * Columns for the {@code conference} table.
 */
public class ConferenceColumns implements BaseColumns {
    public static final String TABLE_NAME = "conference";
    public static final Uri CONTENT_URI = Uri.parse(IEEEHubProvider.CONTENT_URI_BASE + "/" + TABLE_NAME);

    /**
     * Primary key.
     */
    public static final String _ID = BaseColumns._ID;

    public static final String TITLE = "title";

    public static final String DESCRIPTION = "description";

    public static final String START_DATE = "start_date";

    public static final String END_DATE = "end_date";

    public static final String DISPLAY_DATE = "display_date";

    public static final String CONTACT = "contact";

    public static final String CALL = "call";

    public static final String LOCATION = "location";

    public static final String LINK = "link";

    public static final String NUMBER = "number";

    public static final String ATTENDANCE = "attendance";

    public static final String REGION = "region";


    public static final String DEFAULT_ORDER = TABLE_NAME + "." +_ID;

    // @formatter:off
    public static final String[] ALL_COLUMNS = new String[] {
            _ID,
            TITLE,
            DESCRIPTION,
            START_DATE,
            END_DATE,
            DISPLAY_DATE,
            CONTACT,
            CALL,
            LOCATION,
            LINK,
            NUMBER,
            ATTENDANCE,
            REGION
    };
    // @formatter:on

    public static boolean hasColumns(String[] projection) {
        if (projection == null) return true;
        for (String c : projection) {
            if (c.equals(TITLE) || c.contains("." + TITLE)) return true;
            if (c.equals(DESCRIPTION) || c.contains("." + DESCRIPTION)) return true;
            if (c.equals(START_DATE) || c.contains("." + START_DATE)) return true;
            if (c.equals(END_DATE) || c.contains("." + END_DATE)) return true;
            if (c.equals(DISPLAY_DATE) || c.contains("." + DISPLAY_DATE)) return true;
            if (c.equals(CONTACT) || c.contains("." + CONTACT)) return true;
            if (c.equals(CALL) || c.contains("." + CALL)) return true;
            if (c.equals(LOCATION) || c.contains("." + LOCATION)) return true;
            if (c.equals(LINK) || c.contains("." + LINK)) return true;
            if (c.equals(NUMBER) || c.contains("." + NUMBER)) return true;
            if (c.equals(ATTENDANCE) || c.contains("." + ATTENDANCE)) return true;
            if (c.equals(REGION) || c.contains("." + REGION)) return true;
        }
        return false;
    }

}
