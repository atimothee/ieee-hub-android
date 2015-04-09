package org.ieee.ieeehub.provider.conferencetag;

import java.util.Date;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;

import org.ieee.ieeehub.provider.base.AbstractSelection;
import org.ieee.ieeehub.provider.conference.*;

/**
 * Selection for the {@code conference_tag} table.
 */
public class ConferenceTagSelection extends AbstractSelection<ConferenceTagSelection> {
    @Override
    protected Uri baseUri() {
        return ConferenceTagColumns.CONTENT_URI;
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param contentResolver The content resolver to query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @param sortOrder How to order the rows, formatted as an SQL ORDER BY clause (excluding the ORDER BY itself). Passing null will use the default sort
     *            order, which may be unordered.
     * @return A {@code ConferenceTagCursor} object, which is positioned before the first entry, or null.
     */
    public ConferenceTagCursor query(ContentResolver contentResolver, String[] projection, String sortOrder) {
        Cursor cursor = contentResolver.query(uri(), projection, sel(), args(), sortOrder);
        if (cursor == null) return null;
        return new ConferenceTagCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, projection, null)}.
     */
    public ConferenceTagCursor query(ContentResolver contentResolver, String[] projection) {
        return query(contentResolver, projection, null);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, projection, null, null)}.
     */
    public ConferenceTagCursor query(ContentResolver contentResolver) {
        return query(contentResolver, null, null);
    }


    public ConferenceTagSelection id(long... value) {
        addEquals("conference_tag." + ConferenceTagColumns._ID, toObjectArray(value));
        return this;
    }

    public ConferenceTagSelection conferenceId(Integer... value) {
        addEquals(ConferenceTagColumns.CONFERENCE_ID, value);
        return this;
    }

    public ConferenceTagSelection conferenceIdNot(Integer... value) {
        addNotEquals(ConferenceTagColumns.CONFERENCE_ID, value);
        return this;
    }

    public ConferenceTagSelection conferenceIdGt(int value) {
        addGreaterThan(ConferenceTagColumns.CONFERENCE_ID, value);
        return this;
    }

    public ConferenceTagSelection conferenceIdGtEq(int value) {
        addGreaterThanOrEquals(ConferenceTagColumns.CONFERENCE_ID, value);
        return this;
    }

    public ConferenceTagSelection conferenceIdLt(int value) {
        addLessThan(ConferenceTagColumns.CONFERENCE_ID, value);
        return this;
    }

    public ConferenceTagSelection conferenceIdLtEq(int value) {
        addLessThanOrEquals(ConferenceTagColumns.CONFERENCE_ID, value);
        return this;
    }

    public ConferenceTagSelection conferenceTitle(String... value) {
        addEquals(ConferenceColumns.TITLE, value);
        return this;
    }

    public ConferenceTagSelection conferenceTitleNot(String... value) {
        addNotEquals(ConferenceColumns.TITLE, value);
        return this;
    }

    public ConferenceTagSelection conferenceTitleLike(String... value) {
        addLike(ConferenceColumns.TITLE, value);
        return this;
    }

    public ConferenceTagSelection conferenceTitleContains(String... value) {
        addContains(ConferenceColumns.TITLE, value);
        return this;
    }

    public ConferenceTagSelection conferenceTitleStartsWith(String... value) {
        addStartsWith(ConferenceColumns.TITLE, value);
        return this;
    }

    public ConferenceTagSelection conferenceTitleEndsWith(String... value) {
        addEndsWith(ConferenceColumns.TITLE, value);
        return this;
    }

    public ConferenceTagSelection conferenceDescription(String... value) {
        addEquals(ConferenceColumns.DESCRIPTION, value);
        return this;
    }

    public ConferenceTagSelection conferenceDescriptionNot(String... value) {
        addNotEquals(ConferenceColumns.DESCRIPTION, value);
        return this;
    }

    public ConferenceTagSelection conferenceDescriptionLike(String... value) {
        addLike(ConferenceColumns.DESCRIPTION, value);
        return this;
    }

    public ConferenceTagSelection conferenceDescriptionContains(String... value) {
        addContains(ConferenceColumns.DESCRIPTION, value);
        return this;
    }

    public ConferenceTagSelection conferenceDescriptionStartsWith(String... value) {
        addStartsWith(ConferenceColumns.DESCRIPTION, value);
        return this;
    }

    public ConferenceTagSelection conferenceDescriptionEndsWith(String... value) {
        addEndsWith(ConferenceColumns.DESCRIPTION, value);
        return this;
    }

    public ConferenceTagSelection conferenceStartDate(Date... value) {
        addEquals(ConferenceColumns.START_DATE, value);
        return this;
    }

    public ConferenceTagSelection conferenceStartDateNot(Date... value) {
        addNotEquals(ConferenceColumns.START_DATE, value);
        return this;
    }

    public ConferenceTagSelection conferenceStartDate(Long... value) {
        addEquals(ConferenceColumns.START_DATE, value);
        return this;
    }

    public ConferenceTagSelection conferenceStartDateAfter(Date value) {
        addGreaterThan(ConferenceColumns.START_DATE, value);
        return this;
    }

    public ConferenceTagSelection conferenceStartDateAfterEq(Date value) {
        addGreaterThanOrEquals(ConferenceColumns.START_DATE, value);
        return this;
    }

    public ConferenceTagSelection conferenceStartDateBefore(Date value) {
        addLessThan(ConferenceColumns.START_DATE, value);
        return this;
    }

    public ConferenceTagSelection conferenceStartDateBeforeEq(Date value) {
        addLessThanOrEquals(ConferenceColumns.START_DATE, value);
        return this;
    }

    public ConferenceTagSelection conferenceEndDate(Date... value) {
        addEquals(ConferenceColumns.END_DATE, value);
        return this;
    }

    public ConferenceTagSelection conferenceEndDateNot(Date... value) {
        addNotEquals(ConferenceColumns.END_DATE, value);
        return this;
    }

    public ConferenceTagSelection conferenceEndDate(Long... value) {
        addEquals(ConferenceColumns.END_DATE, value);
        return this;
    }

    public ConferenceTagSelection conferenceEndDateAfter(Date value) {
        addGreaterThan(ConferenceColumns.END_DATE, value);
        return this;
    }

    public ConferenceTagSelection conferenceEndDateAfterEq(Date value) {
        addGreaterThanOrEquals(ConferenceColumns.END_DATE, value);
        return this;
    }

    public ConferenceTagSelection conferenceEndDateBefore(Date value) {
        addLessThan(ConferenceColumns.END_DATE, value);
        return this;
    }

    public ConferenceTagSelection conferenceEndDateBeforeEq(Date value) {
        addLessThanOrEquals(ConferenceColumns.END_DATE, value);
        return this;
    }

    public ConferenceTagSelection conferenceDisplayDate(String... value) {
        addEquals(ConferenceColumns.DISPLAY_DATE, value);
        return this;
    }

    public ConferenceTagSelection conferenceDisplayDateNot(String... value) {
        addNotEquals(ConferenceColumns.DISPLAY_DATE, value);
        return this;
    }

    public ConferenceTagSelection conferenceDisplayDateLike(String... value) {
        addLike(ConferenceColumns.DISPLAY_DATE, value);
        return this;
    }

    public ConferenceTagSelection conferenceDisplayDateContains(String... value) {
        addContains(ConferenceColumns.DISPLAY_DATE, value);
        return this;
    }

    public ConferenceTagSelection conferenceDisplayDateStartsWith(String... value) {
        addStartsWith(ConferenceColumns.DISPLAY_DATE, value);
        return this;
    }

    public ConferenceTagSelection conferenceDisplayDateEndsWith(String... value) {
        addEndsWith(ConferenceColumns.DISPLAY_DATE, value);
        return this;
    }

    public ConferenceTagSelection conferenceContact(String... value) {
        addEquals(ConferenceColumns.CONTACT, value);
        return this;
    }

    public ConferenceTagSelection conferenceContactNot(String... value) {
        addNotEquals(ConferenceColumns.CONTACT, value);
        return this;
    }

    public ConferenceTagSelection conferenceContactLike(String... value) {
        addLike(ConferenceColumns.CONTACT, value);
        return this;
    }

    public ConferenceTagSelection conferenceContactContains(String... value) {
        addContains(ConferenceColumns.CONTACT, value);
        return this;
    }

    public ConferenceTagSelection conferenceContactStartsWith(String... value) {
        addStartsWith(ConferenceColumns.CONTACT, value);
        return this;
    }

    public ConferenceTagSelection conferenceContactEndsWith(String... value) {
        addEndsWith(ConferenceColumns.CONTACT, value);
        return this;
    }

    public ConferenceTagSelection conferenceCall(String... value) {
        addEquals(ConferenceColumns.CALL, value);
        return this;
    }

    public ConferenceTagSelection conferenceCallNot(String... value) {
        addNotEquals(ConferenceColumns.CALL, value);
        return this;
    }

    public ConferenceTagSelection conferenceCallLike(String... value) {
        addLike(ConferenceColumns.CALL, value);
        return this;
    }

    public ConferenceTagSelection conferenceCallContains(String... value) {
        addContains(ConferenceColumns.CALL, value);
        return this;
    }

    public ConferenceTagSelection conferenceCallStartsWith(String... value) {
        addStartsWith(ConferenceColumns.CALL, value);
        return this;
    }

    public ConferenceTagSelection conferenceCallEndsWith(String... value) {
        addEndsWith(ConferenceColumns.CALL, value);
        return this;
    }

    public ConferenceTagSelection conferenceLocation(String... value) {
        addEquals(ConferenceColumns.LOCATION, value);
        return this;
    }

    public ConferenceTagSelection conferenceLocationNot(String... value) {
        addNotEquals(ConferenceColumns.LOCATION, value);
        return this;
    }

    public ConferenceTagSelection conferenceLocationLike(String... value) {
        addLike(ConferenceColumns.LOCATION, value);
        return this;
    }

    public ConferenceTagSelection conferenceLocationContains(String... value) {
        addContains(ConferenceColumns.LOCATION, value);
        return this;
    }

    public ConferenceTagSelection conferenceLocationStartsWith(String... value) {
        addStartsWith(ConferenceColumns.LOCATION, value);
        return this;
    }

    public ConferenceTagSelection conferenceLocationEndsWith(String... value) {
        addEndsWith(ConferenceColumns.LOCATION, value);
        return this;
    }

    public ConferenceTagSelection conferenceLink(String... value) {
        addEquals(ConferenceColumns.LINK, value);
        return this;
    }

    public ConferenceTagSelection conferenceLinkNot(String... value) {
        addNotEquals(ConferenceColumns.LINK, value);
        return this;
    }

    public ConferenceTagSelection conferenceLinkLike(String... value) {
        addLike(ConferenceColumns.LINK, value);
        return this;
    }

    public ConferenceTagSelection conferenceLinkContains(String... value) {
        addContains(ConferenceColumns.LINK, value);
        return this;
    }

    public ConferenceTagSelection conferenceLinkStartsWith(String... value) {
        addStartsWith(ConferenceColumns.LINK, value);
        return this;
    }

    public ConferenceTagSelection conferenceLinkEndsWith(String... value) {
        addEndsWith(ConferenceColumns.LINK, value);
        return this;
    }

    public ConferenceTagSelection conferenceNumber(Integer... value) {
        addEquals(ConferenceColumns.NUMBER, value);
        return this;
    }

    public ConferenceTagSelection conferenceNumberNot(Integer... value) {
        addNotEquals(ConferenceColumns.NUMBER, value);
        return this;
    }

    public ConferenceTagSelection conferenceNumberGt(int value) {
        addGreaterThan(ConferenceColumns.NUMBER, value);
        return this;
    }

    public ConferenceTagSelection conferenceNumberGtEq(int value) {
        addGreaterThanOrEquals(ConferenceColumns.NUMBER, value);
        return this;
    }

    public ConferenceTagSelection conferenceNumberLt(int value) {
        addLessThan(ConferenceColumns.NUMBER, value);
        return this;
    }

    public ConferenceTagSelection conferenceNumberLtEq(int value) {
        addLessThanOrEquals(ConferenceColumns.NUMBER, value);
        return this;
    }

    public ConferenceTagSelection conferenceAttendance(Integer... value) {
        addEquals(ConferenceColumns.ATTENDANCE, value);
        return this;
    }

    public ConferenceTagSelection conferenceAttendanceNot(Integer... value) {
        addNotEquals(ConferenceColumns.ATTENDANCE, value);
        return this;
    }

    public ConferenceTagSelection conferenceAttendanceGt(int value) {
        addGreaterThan(ConferenceColumns.ATTENDANCE, value);
        return this;
    }

    public ConferenceTagSelection conferenceAttendanceGtEq(int value) {
        addGreaterThanOrEquals(ConferenceColumns.ATTENDANCE, value);
        return this;
    }

    public ConferenceTagSelection conferenceAttendanceLt(int value) {
        addLessThan(ConferenceColumns.ATTENDANCE, value);
        return this;
    }

    public ConferenceTagSelection conferenceAttendanceLtEq(int value) {
        addLessThanOrEquals(ConferenceColumns.ATTENDANCE, value);
        return this;
    }

    public ConferenceTagSelection conferenceRegion(String... value) {
        addEquals(ConferenceColumns.REGION, value);
        return this;
    }

    public ConferenceTagSelection conferenceRegionNot(String... value) {
        addNotEquals(ConferenceColumns.REGION, value);
        return this;
    }

    public ConferenceTagSelection conferenceRegionLike(String... value) {
        addLike(ConferenceColumns.REGION, value);
        return this;
    }

    public ConferenceTagSelection conferenceRegionContains(String... value) {
        addContains(ConferenceColumns.REGION, value);
        return this;
    }

    public ConferenceTagSelection conferenceRegionStartsWith(String... value) {
        addStartsWith(ConferenceColumns.REGION, value);
        return this;
    }

    public ConferenceTagSelection conferenceRegionEndsWith(String... value) {
        addEndsWith(ConferenceColumns.REGION, value);
        return this;
    }

    public ConferenceTagSelection name(String... value) {
        addEquals(ConferenceTagColumns.NAME, value);
        return this;
    }

    public ConferenceTagSelection nameNot(String... value) {
        addNotEquals(ConferenceTagColumns.NAME, value);
        return this;
    }

    public ConferenceTagSelection nameLike(String... value) {
        addLike(ConferenceTagColumns.NAME, value);
        return this;
    }

    public ConferenceTagSelection nameContains(String... value) {
        addContains(ConferenceTagColumns.NAME, value);
        return this;
    }

    public ConferenceTagSelection nameStartsWith(String... value) {
        addStartsWith(ConferenceTagColumns.NAME, value);
        return this;
    }

    public ConferenceTagSelection nameEndsWith(String... value) {
        addEndsWith(ConferenceTagColumns.NAME, value);
        return this;
    }
}
