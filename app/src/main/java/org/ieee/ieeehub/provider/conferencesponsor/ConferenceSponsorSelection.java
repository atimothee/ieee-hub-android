package org.ieee.ieeehub.provider.conferencesponsor;

import java.util.Date;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;

import org.ieee.ieeehub.provider.base.AbstractSelection;
import org.ieee.ieeehub.provider.conference.*;

/**
 * Selection for the {@code conference_sponsor} table.
 */
public class ConferenceSponsorSelection extends AbstractSelection<ConferenceSponsorSelection> {
    @Override
    protected Uri baseUri() {
        return ConferenceSponsorColumns.CONTENT_URI;
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param contentResolver The content resolver to query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @param sortOrder How to order the rows, formatted as an SQL ORDER BY clause (excluding the ORDER BY itself). Passing null will use the default sort
     *            order, which may be unordered.
     * @return A {@code ConferenceSponsorCursor} object, which is positioned before the first entry, or null.
     */
    public ConferenceSponsorCursor query(ContentResolver contentResolver, String[] projection, String sortOrder) {
        Cursor cursor = contentResolver.query(uri(), projection, sel(), args(), sortOrder);
        if (cursor == null) return null;
        return new ConferenceSponsorCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, projection, null)}.
     */
    public ConferenceSponsorCursor query(ContentResolver contentResolver, String[] projection) {
        return query(contentResolver, projection, null);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, projection, null, null)}.
     */
    public ConferenceSponsorCursor query(ContentResolver contentResolver) {
        return query(contentResolver, null, null);
    }


    public ConferenceSponsorSelection id(long... value) {
        addEquals("conference_sponsor." + ConferenceSponsorColumns._ID, toObjectArray(value));
        return this;
    }

    public ConferenceSponsorSelection conferenceId(Long... value) {
        addEquals(ConferenceSponsorColumns.CONFERENCE_ID, value);
        return this;
    }

    public ConferenceSponsorSelection conferenceIdNot(Long... value) {
        addNotEquals(ConferenceSponsorColumns.CONFERENCE_ID, value);
        return this;
    }

    public ConferenceSponsorSelection conferenceIdGt(long value) {
        addGreaterThan(ConferenceSponsorColumns.CONFERENCE_ID, value);
        return this;
    }

    public ConferenceSponsorSelection conferenceIdGtEq(long value) {
        addGreaterThanOrEquals(ConferenceSponsorColumns.CONFERENCE_ID, value);
        return this;
    }

    public ConferenceSponsorSelection conferenceIdLt(long value) {
        addLessThan(ConferenceSponsorColumns.CONFERENCE_ID, value);
        return this;
    }

    public ConferenceSponsorSelection conferenceIdLtEq(long value) {
        addLessThanOrEquals(ConferenceSponsorColumns.CONFERENCE_ID, value);
        return this;
    }

    public ConferenceSponsorSelection conferenceTitle(String... value) {
        addEquals(ConferenceColumns.TITLE, value);
        return this;
    }

    public ConferenceSponsorSelection conferenceTitleNot(String... value) {
        addNotEquals(ConferenceColumns.TITLE, value);
        return this;
    }

    public ConferenceSponsorSelection conferenceTitleLike(String... value) {
        addLike(ConferenceColumns.TITLE, value);
        return this;
    }

    public ConferenceSponsorSelection conferenceTitleContains(String... value) {
        addContains(ConferenceColumns.TITLE, value);
        return this;
    }

    public ConferenceSponsorSelection conferenceTitleStartsWith(String... value) {
        addStartsWith(ConferenceColumns.TITLE, value);
        return this;
    }

    public ConferenceSponsorSelection conferenceTitleEndsWith(String... value) {
        addEndsWith(ConferenceColumns.TITLE, value);
        return this;
    }

    public ConferenceSponsorSelection conferenceDescription(String... value) {
        addEquals(ConferenceColumns.DESCRIPTION, value);
        return this;
    }

    public ConferenceSponsorSelection conferenceDescriptionNot(String... value) {
        addNotEquals(ConferenceColumns.DESCRIPTION, value);
        return this;
    }

    public ConferenceSponsorSelection conferenceDescriptionLike(String... value) {
        addLike(ConferenceColumns.DESCRIPTION, value);
        return this;
    }

    public ConferenceSponsorSelection conferenceDescriptionContains(String... value) {
        addContains(ConferenceColumns.DESCRIPTION, value);
        return this;
    }

    public ConferenceSponsorSelection conferenceDescriptionStartsWith(String... value) {
        addStartsWith(ConferenceColumns.DESCRIPTION, value);
        return this;
    }

    public ConferenceSponsorSelection conferenceDescriptionEndsWith(String... value) {
        addEndsWith(ConferenceColumns.DESCRIPTION, value);
        return this;
    }

    public ConferenceSponsorSelection conferenceStartDate(Date... value) {
        addEquals(ConferenceColumns.START_DATE, value);
        return this;
    }

    public ConferenceSponsorSelection conferenceStartDateNot(Date... value) {
        addNotEquals(ConferenceColumns.START_DATE, value);
        return this;
    }

    public ConferenceSponsorSelection conferenceStartDate(Long... value) {
        addEquals(ConferenceColumns.START_DATE, value);
        return this;
    }

    public ConferenceSponsorSelection conferenceStartDateAfter(Date value) {
        addGreaterThan(ConferenceColumns.START_DATE, value);
        return this;
    }

    public ConferenceSponsorSelection conferenceStartDateAfterEq(Date value) {
        addGreaterThanOrEquals(ConferenceColumns.START_DATE, value);
        return this;
    }

    public ConferenceSponsorSelection conferenceStartDateBefore(Date value) {
        addLessThan(ConferenceColumns.START_DATE, value);
        return this;
    }

    public ConferenceSponsorSelection conferenceStartDateBeforeEq(Date value) {
        addLessThanOrEquals(ConferenceColumns.START_DATE, value);
        return this;
    }

    public ConferenceSponsorSelection conferenceEndDate(Date... value) {
        addEquals(ConferenceColumns.END_DATE, value);
        return this;
    }

    public ConferenceSponsorSelection conferenceEndDateNot(Date... value) {
        addNotEquals(ConferenceColumns.END_DATE, value);
        return this;
    }

    public ConferenceSponsorSelection conferenceEndDate(Long... value) {
        addEquals(ConferenceColumns.END_DATE, value);
        return this;
    }

    public ConferenceSponsorSelection conferenceEndDateAfter(Date value) {
        addGreaterThan(ConferenceColumns.END_DATE, value);
        return this;
    }

    public ConferenceSponsorSelection conferenceEndDateAfterEq(Date value) {
        addGreaterThanOrEquals(ConferenceColumns.END_DATE, value);
        return this;
    }

    public ConferenceSponsorSelection conferenceEndDateBefore(Date value) {
        addLessThan(ConferenceColumns.END_DATE, value);
        return this;
    }

    public ConferenceSponsorSelection conferenceEndDateBeforeEq(Date value) {
        addLessThanOrEquals(ConferenceColumns.END_DATE, value);
        return this;
    }

    public ConferenceSponsorSelection conferenceDisplayDate(String... value) {
        addEquals(ConferenceColumns.DISPLAY_DATE, value);
        return this;
    }

    public ConferenceSponsorSelection conferenceDisplayDateNot(String... value) {
        addNotEquals(ConferenceColumns.DISPLAY_DATE, value);
        return this;
    }

    public ConferenceSponsorSelection conferenceDisplayDateLike(String... value) {
        addLike(ConferenceColumns.DISPLAY_DATE, value);
        return this;
    }

    public ConferenceSponsorSelection conferenceDisplayDateContains(String... value) {
        addContains(ConferenceColumns.DISPLAY_DATE, value);
        return this;
    }

    public ConferenceSponsorSelection conferenceDisplayDateStartsWith(String... value) {
        addStartsWith(ConferenceColumns.DISPLAY_DATE, value);
        return this;
    }

    public ConferenceSponsorSelection conferenceDisplayDateEndsWith(String... value) {
        addEndsWith(ConferenceColumns.DISPLAY_DATE, value);
        return this;
    }

    public ConferenceSponsorSelection conferenceContact(String... value) {
        addEquals(ConferenceColumns.CONTACT, value);
        return this;
    }

    public ConferenceSponsorSelection conferenceContactNot(String... value) {
        addNotEquals(ConferenceColumns.CONTACT, value);
        return this;
    }

    public ConferenceSponsorSelection conferenceContactLike(String... value) {
        addLike(ConferenceColumns.CONTACT, value);
        return this;
    }

    public ConferenceSponsorSelection conferenceContactContains(String... value) {
        addContains(ConferenceColumns.CONTACT, value);
        return this;
    }

    public ConferenceSponsorSelection conferenceContactStartsWith(String... value) {
        addStartsWith(ConferenceColumns.CONTACT, value);
        return this;
    }

    public ConferenceSponsorSelection conferenceContactEndsWith(String... value) {
        addEndsWith(ConferenceColumns.CONTACT, value);
        return this;
    }

    public ConferenceSponsorSelection conferenceCallUrl(String... value) {
        addEquals(ConferenceColumns.CALL_URL, value);
        return this;
    }

    public ConferenceSponsorSelection conferenceCallUrlNot(String... value) {
        addNotEquals(ConferenceColumns.CALL_URL, value);
        return this;
    }

    public ConferenceSponsorSelection conferenceCallUrlLike(String... value) {
        addLike(ConferenceColumns.CALL_URL, value);
        return this;
    }

    public ConferenceSponsorSelection conferenceCallUrlContains(String... value) {
        addContains(ConferenceColumns.CALL_URL, value);
        return this;
    }

    public ConferenceSponsorSelection conferenceCallUrlStartsWith(String... value) {
        addStartsWith(ConferenceColumns.CALL_URL, value);
        return this;
    }

    public ConferenceSponsorSelection conferenceCallUrlEndsWith(String... value) {
        addEndsWith(ConferenceColumns.CALL_URL, value);
        return this;
    }

    public ConferenceSponsorSelection conferenceLocation(String... value) {
        addEquals(ConferenceColumns.LOCATION, value);
        return this;
    }

    public ConferenceSponsorSelection conferenceLocationNot(String... value) {
        addNotEquals(ConferenceColumns.LOCATION, value);
        return this;
    }

    public ConferenceSponsorSelection conferenceLocationLike(String... value) {
        addLike(ConferenceColumns.LOCATION, value);
        return this;
    }

    public ConferenceSponsorSelection conferenceLocationContains(String... value) {
        addContains(ConferenceColumns.LOCATION, value);
        return this;
    }

    public ConferenceSponsorSelection conferenceLocationStartsWith(String... value) {
        addStartsWith(ConferenceColumns.LOCATION, value);
        return this;
    }

    public ConferenceSponsorSelection conferenceLocationEndsWith(String... value) {
        addEndsWith(ConferenceColumns.LOCATION, value);
        return this;
    }

    public ConferenceSponsorSelection conferenceLink(String... value) {
        addEquals(ConferenceColumns.LINK, value);
        return this;
    }

    public ConferenceSponsorSelection conferenceLinkNot(String... value) {
        addNotEquals(ConferenceColumns.LINK, value);
        return this;
    }

    public ConferenceSponsorSelection conferenceLinkLike(String... value) {
        addLike(ConferenceColumns.LINK, value);
        return this;
    }

    public ConferenceSponsorSelection conferenceLinkContains(String... value) {
        addContains(ConferenceColumns.LINK, value);
        return this;
    }

    public ConferenceSponsorSelection conferenceLinkStartsWith(String... value) {
        addStartsWith(ConferenceColumns.LINK, value);
        return this;
    }

    public ConferenceSponsorSelection conferenceLinkEndsWith(String... value) {
        addEndsWith(ConferenceColumns.LINK, value);
        return this;
    }

    public ConferenceSponsorSelection conferenceNumber(Integer... value) {
        addEquals(ConferenceColumns.NUMBER, value);
        return this;
    }

    public ConferenceSponsorSelection conferenceNumberNot(Integer... value) {
        addNotEquals(ConferenceColumns.NUMBER, value);
        return this;
    }

    public ConferenceSponsorSelection conferenceNumberGt(int value) {
        addGreaterThan(ConferenceColumns.NUMBER, value);
        return this;
    }

    public ConferenceSponsorSelection conferenceNumberGtEq(int value) {
        addGreaterThanOrEquals(ConferenceColumns.NUMBER, value);
        return this;
    }

    public ConferenceSponsorSelection conferenceNumberLt(int value) {
        addLessThan(ConferenceColumns.NUMBER, value);
        return this;
    }

    public ConferenceSponsorSelection conferenceNumberLtEq(int value) {
        addLessThanOrEquals(ConferenceColumns.NUMBER, value);
        return this;
    }

    public ConferenceSponsorSelection conferenceAttendance(Integer... value) {
        addEquals(ConferenceColumns.ATTENDANCE, value);
        return this;
    }

    public ConferenceSponsorSelection conferenceAttendanceNot(Integer... value) {
        addNotEquals(ConferenceColumns.ATTENDANCE, value);
        return this;
    }

    public ConferenceSponsorSelection conferenceAttendanceGt(int value) {
        addGreaterThan(ConferenceColumns.ATTENDANCE, value);
        return this;
    }

    public ConferenceSponsorSelection conferenceAttendanceGtEq(int value) {
        addGreaterThanOrEquals(ConferenceColumns.ATTENDANCE, value);
        return this;
    }

    public ConferenceSponsorSelection conferenceAttendanceLt(int value) {
        addLessThan(ConferenceColumns.ATTENDANCE, value);
        return this;
    }

    public ConferenceSponsorSelection conferenceAttendanceLtEq(int value) {
        addLessThanOrEquals(ConferenceColumns.ATTENDANCE, value);
        return this;
    }

    public ConferenceSponsorSelection conferenceRegion(String... value) {
        addEquals(ConferenceColumns.REGION, value);
        return this;
    }

    public ConferenceSponsorSelection conferenceRegionNot(String... value) {
        addNotEquals(ConferenceColumns.REGION, value);
        return this;
    }

    public ConferenceSponsorSelection conferenceRegionLike(String... value) {
        addLike(ConferenceColumns.REGION, value);
        return this;
    }

    public ConferenceSponsorSelection conferenceRegionContains(String... value) {
        addContains(ConferenceColumns.REGION, value);
        return this;
    }

    public ConferenceSponsorSelection conferenceRegionStartsWith(String... value) {
        addStartsWith(ConferenceColumns.REGION, value);
        return this;
    }

    public ConferenceSponsorSelection conferenceRegionEndsWith(String... value) {
        addEndsWith(ConferenceColumns.REGION, value);
        return this;
    }

    public ConferenceSponsorSelection conferenceWebsite(String... value) {
        addEquals(ConferenceColumns.WEBSITE, value);
        return this;
    }

    public ConferenceSponsorSelection conferenceWebsiteNot(String... value) {
        addNotEquals(ConferenceColumns.WEBSITE, value);
        return this;
    }

    public ConferenceSponsorSelection conferenceWebsiteLike(String... value) {
        addLike(ConferenceColumns.WEBSITE, value);
        return this;
    }

    public ConferenceSponsorSelection conferenceWebsiteContains(String... value) {
        addContains(ConferenceColumns.WEBSITE, value);
        return this;
    }

    public ConferenceSponsorSelection conferenceWebsiteStartsWith(String... value) {
        addStartsWith(ConferenceColumns.WEBSITE, value);
        return this;
    }

    public ConferenceSponsorSelection conferenceWebsiteEndsWith(String... value) {
        addEndsWith(ConferenceColumns.WEBSITE, value);
        return this;
    }

    public ConferenceSponsorSelection name(String... value) {
        addEquals(ConferenceSponsorColumns.NAME, value);
        return this;
    }

    public ConferenceSponsorSelection nameNot(String... value) {
        addNotEquals(ConferenceSponsorColumns.NAME, value);
        return this;
    }

    public ConferenceSponsorSelection nameLike(String... value) {
        addLike(ConferenceSponsorColumns.NAME, value);
        return this;
    }

    public ConferenceSponsorSelection nameContains(String... value) {
        addContains(ConferenceSponsorColumns.NAME, value);
        return this;
    }

    public ConferenceSponsorSelection nameStartsWith(String... value) {
        addStartsWith(ConferenceSponsorColumns.NAME, value);
        return this;
    }

    public ConferenceSponsorSelection nameEndsWith(String... value) {
        addEndsWith(ConferenceSponsorColumns.NAME, value);
        return this;
    }
}
