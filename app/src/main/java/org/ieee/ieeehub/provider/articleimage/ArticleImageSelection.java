package org.ieee.ieeehub.provider.articleimage;

import java.util.Date;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;

import org.ieee.ieeehub.provider.base.AbstractSelection;
import org.ieee.ieeehub.provider.conference.*;

/**
 * Selection for the {@code article_image} table.
 */
public class ArticleImageSelection extends AbstractSelection<ArticleImageSelection> {
    @Override
    protected Uri baseUri() {
        return ArticleImageColumns.CONTENT_URI;
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param contentResolver The content resolver to query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @param sortOrder How to order the rows, formatted as an SQL ORDER BY clause (excluding the ORDER BY itself). Passing null will use the default sort
     *            order, which may be unordered.
     * @return A {@code ArticleImageCursor} object, which is positioned before the first entry, or null.
     */
    public ArticleImageCursor query(ContentResolver contentResolver, String[] projection, String sortOrder) {
        Cursor cursor = contentResolver.query(uri(), projection, sel(), args(), sortOrder);
        if (cursor == null) return null;
        return new ArticleImageCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, projection, null)}.
     */
    public ArticleImageCursor query(ContentResolver contentResolver, String[] projection) {
        return query(contentResolver, projection, null);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, projection, null, null)}.
     */
    public ArticleImageCursor query(ContentResolver contentResolver) {
        return query(contentResolver, null, null);
    }


    public ArticleImageSelection id(long... value) {
        addEquals("article_image." + ArticleImageColumns._ID, toObjectArray(value));
        return this;
    }

    public ArticleImageSelection articleId(Long... value) {
        addEquals(ArticleImageColumns.ARTICLE_ID, value);
        return this;
    }

    public ArticleImageSelection articleIdNot(Long... value) {
        addNotEquals(ArticleImageColumns.ARTICLE_ID, value);
        return this;
    }

    public ArticleImageSelection articleIdGt(long value) {
        addGreaterThan(ArticleImageColumns.ARTICLE_ID, value);
        return this;
    }

    public ArticleImageSelection articleIdGtEq(long value) {
        addGreaterThanOrEquals(ArticleImageColumns.ARTICLE_ID, value);
        return this;
    }

    public ArticleImageSelection articleIdLt(long value) {
        addLessThan(ArticleImageColumns.ARTICLE_ID, value);
        return this;
    }

    public ArticleImageSelection articleIdLtEq(long value) {
        addLessThanOrEquals(ArticleImageColumns.ARTICLE_ID, value);
        return this;
    }

    public ArticleImageSelection conferenceTitle(String... value) {
        addEquals(ConferenceColumns.TITLE, value);
        return this;
    }

    public ArticleImageSelection conferenceTitleNot(String... value) {
        addNotEquals(ConferenceColumns.TITLE, value);
        return this;
    }

    public ArticleImageSelection conferenceTitleLike(String... value) {
        addLike(ConferenceColumns.TITLE, value);
        return this;
    }

    public ArticleImageSelection conferenceTitleContains(String... value) {
        addContains(ConferenceColumns.TITLE, value);
        return this;
    }

    public ArticleImageSelection conferenceTitleStartsWith(String... value) {
        addStartsWith(ConferenceColumns.TITLE, value);
        return this;
    }

    public ArticleImageSelection conferenceTitleEndsWith(String... value) {
        addEndsWith(ConferenceColumns.TITLE, value);
        return this;
    }

    public ArticleImageSelection conferenceDescription(String... value) {
        addEquals(ConferenceColumns.DESCRIPTION, value);
        return this;
    }

    public ArticleImageSelection conferenceDescriptionNot(String... value) {
        addNotEquals(ConferenceColumns.DESCRIPTION, value);
        return this;
    }

    public ArticleImageSelection conferenceDescriptionLike(String... value) {
        addLike(ConferenceColumns.DESCRIPTION, value);
        return this;
    }

    public ArticleImageSelection conferenceDescriptionContains(String... value) {
        addContains(ConferenceColumns.DESCRIPTION, value);
        return this;
    }

    public ArticleImageSelection conferenceDescriptionStartsWith(String... value) {
        addStartsWith(ConferenceColumns.DESCRIPTION, value);
        return this;
    }

    public ArticleImageSelection conferenceDescriptionEndsWith(String... value) {
        addEndsWith(ConferenceColumns.DESCRIPTION, value);
        return this;
    }

    public ArticleImageSelection conferenceStartDate(Date... value) {
        addEquals(ConferenceColumns.START_DATE, value);
        return this;
    }

    public ArticleImageSelection conferenceStartDateNot(Date... value) {
        addNotEquals(ConferenceColumns.START_DATE, value);
        return this;
    }

    public ArticleImageSelection conferenceStartDate(Long... value) {
        addEquals(ConferenceColumns.START_DATE, value);
        return this;
    }

    public ArticleImageSelection conferenceStartDateAfter(Date value) {
        addGreaterThan(ConferenceColumns.START_DATE, value);
        return this;
    }

    public ArticleImageSelection conferenceStartDateAfterEq(Date value) {
        addGreaterThanOrEquals(ConferenceColumns.START_DATE, value);
        return this;
    }

    public ArticleImageSelection conferenceStartDateBefore(Date value) {
        addLessThan(ConferenceColumns.START_DATE, value);
        return this;
    }

    public ArticleImageSelection conferenceStartDateBeforeEq(Date value) {
        addLessThanOrEquals(ConferenceColumns.START_DATE, value);
        return this;
    }

    public ArticleImageSelection conferenceEndDate(Date... value) {
        addEquals(ConferenceColumns.END_DATE, value);
        return this;
    }

    public ArticleImageSelection conferenceEndDateNot(Date... value) {
        addNotEquals(ConferenceColumns.END_DATE, value);
        return this;
    }

    public ArticleImageSelection conferenceEndDate(Long... value) {
        addEquals(ConferenceColumns.END_DATE, value);
        return this;
    }

    public ArticleImageSelection conferenceEndDateAfter(Date value) {
        addGreaterThan(ConferenceColumns.END_DATE, value);
        return this;
    }

    public ArticleImageSelection conferenceEndDateAfterEq(Date value) {
        addGreaterThanOrEquals(ConferenceColumns.END_DATE, value);
        return this;
    }

    public ArticleImageSelection conferenceEndDateBefore(Date value) {
        addLessThan(ConferenceColumns.END_DATE, value);
        return this;
    }

    public ArticleImageSelection conferenceEndDateBeforeEq(Date value) {
        addLessThanOrEquals(ConferenceColumns.END_DATE, value);
        return this;
    }

    public ArticleImageSelection conferenceDisplayDate(String... value) {
        addEquals(ConferenceColumns.DISPLAY_DATE, value);
        return this;
    }

    public ArticleImageSelection conferenceDisplayDateNot(String... value) {
        addNotEquals(ConferenceColumns.DISPLAY_DATE, value);
        return this;
    }

    public ArticleImageSelection conferenceDisplayDateLike(String... value) {
        addLike(ConferenceColumns.DISPLAY_DATE, value);
        return this;
    }

    public ArticleImageSelection conferenceDisplayDateContains(String... value) {
        addContains(ConferenceColumns.DISPLAY_DATE, value);
        return this;
    }

    public ArticleImageSelection conferenceDisplayDateStartsWith(String... value) {
        addStartsWith(ConferenceColumns.DISPLAY_DATE, value);
        return this;
    }

    public ArticleImageSelection conferenceDisplayDateEndsWith(String... value) {
        addEndsWith(ConferenceColumns.DISPLAY_DATE, value);
        return this;
    }

    public ArticleImageSelection conferenceContact(String... value) {
        addEquals(ConferenceColumns.CONTACT, value);
        return this;
    }

    public ArticleImageSelection conferenceContactNot(String... value) {
        addNotEquals(ConferenceColumns.CONTACT, value);
        return this;
    }

    public ArticleImageSelection conferenceContactLike(String... value) {
        addLike(ConferenceColumns.CONTACT, value);
        return this;
    }

    public ArticleImageSelection conferenceContactContains(String... value) {
        addContains(ConferenceColumns.CONTACT, value);
        return this;
    }

    public ArticleImageSelection conferenceContactStartsWith(String... value) {
        addStartsWith(ConferenceColumns.CONTACT, value);
        return this;
    }

    public ArticleImageSelection conferenceContactEndsWith(String... value) {
        addEndsWith(ConferenceColumns.CONTACT, value);
        return this;
    }

    public ArticleImageSelection conferenceCallUrl(String... value) {
        addEquals(ConferenceColumns.CALL_URL, value);
        return this;
    }

    public ArticleImageSelection conferenceCallUrlNot(String... value) {
        addNotEquals(ConferenceColumns.CALL_URL, value);
        return this;
    }

    public ArticleImageSelection conferenceCallUrlLike(String... value) {
        addLike(ConferenceColumns.CALL_URL, value);
        return this;
    }

    public ArticleImageSelection conferenceCallUrlContains(String... value) {
        addContains(ConferenceColumns.CALL_URL, value);
        return this;
    }

    public ArticleImageSelection conferenceCallUrlStartsWith(String... value) {
        addStartsWith(ConferenceColumns.CALL_URL, value);
        return this;
    }

    public ArticleImageSelection conferenceCallUrlEndsWith(String... value) {
        addEndsWith(ConferenceColumns.CALL_URL, value);
        return this;
    }

    public ArticleImageSelection conferenceLocation(String... value) {
        addEquals(ConferenceColumns.LOCATION, value);
        return this;
    }

    public ArticleImageSelection conferenceLocationNot(String... value) {
        addNotEquals(ConferenceColumns.LOCATION, value);
        return this;
    }

    public ArticleImageSelection conferenceLocationLike(String... value) {
        addLike(ConferenceColumns.LOCATION, value);
        return this;
    }

    public ArticleImageSelection conferenceLocationContains(String... value) {
        addContains(ConferenceColumns.LOCATION, value);
        return this;
    }

    public ArticleImageSelection conferenceLocationStartsWith(String... value) {
        addStartsWith(ConferenceColumns.LOCATION, value);
        return this;
    }

    public ArticleImageSelection conferenceLocationEndsWith(String... value) {
        addEndsWith(ConferenceColumns.LOCATION, value);
        return this;
    }

    public ArticleImageSelection conferenceLink(String... value) {
        addEquals(ConferenceColumns.LINK, value);
        return this;
    }

    public ArticleImageSelection conferenceLinkNot(String... value) {
        addNotEquals(ConferenceColumns.LINK, value);
        return this;
    }

    public ArticleImageSelection conferenceLinkLike(String... value) {
        addLike(ConferenceColumns.LINK, value);
        return this;
    }

    public ArticleImageSelection conferenceLinkContains(String... value) {
        addContains(ConferenceColumns.LINK, value);
        return this;
    }

    public ArticleImageSelection conferenceLinkStartsWith(String... value) {
        addStartsWith(ConferenceColumns.LINK, value);
        return this;
    }

    public ArticleImageSelection conferenceLinkEndsWith(String... value) {
        addEndsWith(ConferenceColumns.LINK, value);
        return this;
    }

    public ArticleImageSelection conferenceNumber(Integer... value) {
        addEquals(ConferenceColumns.NUMBER, value);
        return this;
    }

    public ArticleImageSelection conferenceNumberNot(Integer... value) {
        addNotEquals(ConferenceColumns.NUMBER, value);
        return this;
    }

    public ArticleImageSelection conferenceNumberGt(int value) {
        addGreaterThan(ConferenceColumns.NUMBER, value);
        return this;
    }

    public ArticleImageSelection conferenceNumberGtEq(int value) {
        addGreaterThanOrEquals(ConferenceColumns.NUMBER, value);
        return this;
    }

    public ArticleImageSelection conferenceNumberLt(int value) {
        addLessThan(ConferenceColumns.NUMBER, value);
        return this;
    }

    public ArticleImageSelection conferenceNumberLtEq(int value) {
        addLessThanOrEquals(ConferenceColumns.NUMBER, value);
        return this;
    }

    public ArticleImageSelection conferenceAttendance(Integer... value) {
        addEquals(ConferenceColumns.ATTENDANCE, value);
        return this;
    }

    public ArticleImageSelection conferenceAttendanceNot(Integer... value) {
        addNotEquals(ConferenceColumns.ATTENDANCE, value);
        return this;
    }

    public ArticleImageSelection conferenceAttendanceGt(int value) {
        addGreaterThan(ConferenceColumns.ATTENDANCE, value);
        return this;
    }

    public ArticleImageSelection conferenceAttendanceGtEq(int value) {
        addGreaterThanOrEquals(ConferenceColumns.ATTENDANCE, value);
        return this;
    }

    public ArticleImageSelection conferenceAttendanceLt(int value) {
        addLessThan(ConferenceColumns.ATTENDANCE, value);
        return this;
    }

    public ArticleImageSelection conferenceAttendanceLtEq(int value) {
        addLessThanOrEquals(ConferenceColumns.ATTENDANCE, value);
        return this;
    }

    public ArticleImageSelection conferenceRegion(String... value) {
        addEquals(ConferenceColumns.REGION, value);
        return this;
    }

    public ArticleImageSelection conferenceRegionNot(String... value) {
        addNotEquals(ConferenceColumns.REGION, value);
        return this;
    }

    public ArticleImageSelection conferenceRegionLike(String... value) {
        addLike(ConferenceColumns.REGION, value);
        return this;
    }

    public ArticleImageSelection conferenceRegionContains(String... value) {
        addContains(ConferenceColumns.REGION, value);
        return this;
    }

    public ArticleImageSelection conferenceRegionStartsWith(String... value) {
        addStartsWith(ConferenceColumns.REGION, value);
        return this;
    }

    public ArticleImageSelection conferenceRegionEndsWith(String... value) {
        addEndsWith(ConferenceColumns.REGION, value);
        return this;
    }

    public ArticleImageSelection conferenceWebsite(String... value) {
        addEquals(ConferenceColumns.WEBSITE, value);
        return this;
    }

    public ArticleImageSelection conferenceWebsiteNot(String... value) {
        addNotEquals(ConferenceColumns.WEBSITE, value);
        return this;
    }

    public ArticleImageSelection conferenceWebsiteLike(String... value) {
        addLike(ConferenceColumns.WEBSITE, value);
        return this;
    }

    public ArticleImageSelection conferenceWebsiteContains(String... value) {
        addContains(ConferenceColumns.WEBSITE, value);
        return this;
    }

    public ArticleImageSelection conferenceWebsiteStartsWith(String... value) {
        addStartsWith(ConferenceColumns.WEBSITE, value);
        return this;
    }

    public ArticleImageSelection conferenceWebsiteEndsWith(String... value) {
        addEndsWith(ConferenceColumns.WEBSITE, value);
        return this;
    }

    public ArticleImageSelection url(String... value) {
        addEquals(ArticleImageColumns.URL, value);
        return this;
    }

    public ArticleImageSelection urlNot(String... value) {
        addNotEquals(ArticleImageColumns.URL, value);
        return this;
    }

    public ArticleImageSelection urlLike(String... value) {
        addLike(ArticleImageColumns.URL, value);
        return this;
    }

    public ArticleImageSelection urlContains(String... value) {
        addContains(ArticleImageColumns.URL, value);
        return this;
    }

    public ArticleImageSelection urlStartsWith(String... value) {
        addStartsWith(ArticleImageColumns.URL, value);
        return this;
    }

    public ArticleImageSelection urlEndsWith(String... value) {
        addEndsWith(ArticleImageColumns.URL, value);
        return this;
    }
}
