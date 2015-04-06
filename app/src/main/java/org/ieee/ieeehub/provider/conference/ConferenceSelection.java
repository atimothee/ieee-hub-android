package org.ieee.ieeehub.provider.conference;

import java.util.Date;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;

import org.ieee.ieeehub.provider.base.AbstractSelection;

/**
 * Selection for the {@code conference} table.
 */
public class ConferenceSelection extends AbstractSelection<ConferenceSelection> {
    @Override
    protected Uri baseUri() {
        return ConferenceColumns.CONTENT_URI;
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param contentResolver The content resolver to query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @param sortOrder How to order the rows, formatted as an SQL ORDER BY clause (excluding the ORDER BY itself). Passing null will use the default sort
     *            order, which may be unordered.
     * @return A {@code ConferenceCursor} object, which is positioned before the first entry, or null.
     */
    public ConferenceCursor query(ContentResolver contentResolver, String[] projection, String sortOrder) {
        Cursor cursor = contentResolver.query(uri(), projection, sel(), args(), sortOrder);
        if (cursor == null) return null;
        return new ConferenceCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, projection, null)}.
     */
    public ConferenceCursor query(ContentResolver contentResolver, String[] projection) {
        return query(contentResolver, projection, null);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, projection, null, null)}.
     */
    public ConferenceCursor query(ContentResolver contentResolver) {
        return query(contentResolver, null, null);
    }


    public ConferenceSelection id(long... value) {
        addEquals("conference." + ConferenceColumns._ID, toObjectArray(value));
        return this;
    }

    public ConferenceSelection title(String... value) {
        addEquals(ConferenceColumns.TITLE, value);
        return this;
    }

    public ConferenceSelection titleNot(String... value) {
        addNotEquals(ConferenceColumns.TITLE, value);
        return this;
    }

    public ConferenceSelection titleLike(String... value) {
        addLike(ConferenceColumns.TITLE, value);
        return this;
    }

    public ConferenceSelection titleContains(String... value) {
        addContains(ConferenceColumns.TITLE, value);
        return this;
    }

    public ConferenceSelection titleStartsWith(String... value) {
        addStartsWith(ConferenceColumns.TITLE, value);
        return this;
    }

    public ConferenceSelection titleEndsWith(String... value) {
        addEndsWith(ConferenceColumns.TITLE, value);
        return this;
    }

    public ConferenceSelection description(String... value) {
        addEquals(ConferenceColumns.DESCRIPTION, value);
        return this;
    }

    public ConferenceSelection descriptionNot(String... value) {
        addNotEquals(ConferenceColumns.DESCRIPTION, value);
        return this;
    }

    public ConferenceSelection descriptionLike(String... value) {
        addLike(ConferenceColumns.DESCRIPTION, value);
        return this;
    }

    public ConferenceSelection descriptionContains(String... value) {
        addContains(ConferenceColumns.DESCRIPTION, value);
        return this;
    }

    public ConferenceSelection descriptionStartsWith(String... value) {
        addStartsWith(ConferenceColumns.DESCRIPTION, value);
        return this;
    }

    public ConferenceSelection descriptionEndsWith(String... value) {
        addEndsWith(ConferenceColumns.DESCRIPTION, value);
        return this;
    }

    public ConferenceSelection startDate(Date... value) {
        addEquals(ConferenceColumns.START_DATE, value);
        return this;
    }

    public ConferenceSelection startDateNot(Date... value) {
        addNotEquals(ConferenceColumns.START_DATE, value);
        return this;
    }

    public ConferenceSelection startDate(Long... value) {
        addEquals(ConferenceColumns.START_DATE, value);
        return this;
    }

    public ConferenceSelection startDateAfter(Date value) {
        addGreaterThan(ConferenceColumns.START_DATE, value);
        return this;
    }

    public ConferenceSelection startDateAfterEq(Date value) {
        addGreaterThanOrEquals(ConferenceColumns.START_DATE, value);
        return this;
    }

    public ConferenceSelection startDateBefore(Date value) {
        addLessThan(ConferenceColumns.START_DATE, value);
        return this;
    }

    public ConferenceSelection startDateBeforeEq(Date value) {
        addLessThanOrEquals(ConferenceColumns.START_DATE, value);
        return this;
    }

    public ConferenceSelection endDate(Date... value) {
        addEquals(ConferenceColumns.END_DATE, value);
        return this;
    }

    public ConferenceSelection endDateNot(Date... value) {
        addNotEquals(ConferenceColumns.END_DATE, value);
        return this;
    }

    public ConferenceSelection endDate(Long... value) {
        addEquals(ConferenceColumns.END_DATE, value);
        return this;
    }

    public ConferenceSelection endDateAfter(Date value) {
        addGreaterThan(ConferenceColumns.END_DATE, value);
        return this;
    }

    public ConferenceSelection endDateAfterEq(Date value) {
        addGreaterThanOrEquals(ConferenceColumns.END_DATE, value);
        return this;
    }

    public ConferenceSelection endDateBefore(Date value) {
        addLessThan(ConferenceColumns.END_DATE, value);
        return this;
    }

    public ConferenceSelection endDateBeforeEq(Date value) {
        addLessThanOrEquals(ConferenceColumns.END_DATE, value);
        return this;
    }

    public ConferenceSelection displayDate(String... value) {
        addEquals(ConferenceColumns.DISPLAY_DATE, value);
        return this;
    }

    public ConferenceSelection displayDateNot(String... value) {
        addNotEquals(ConferenceColumns.DISPLAY_DATE, value);
        return this;
    }

    public ConferenceSelection displayDateLike(String... value) {
        addLike(ConferenceColumns.DISPLAY_DATE, value);
        return this;
    }

    public ConferenceSelection displayDateContains(String... value) {
        addContains(ConferenceColumns.DISPLAY_DATE, value);
        return this;
    }

    public ConferenceSelection displayDateStartsWith(String... value) {
        addStartsWith(ConferenceColumns.DISPLAY_DATE, value);
        return this;
    }

    public ConferenceSelection displayDateEndsWith(String... value) {
        addEndsWith(ConferenceColumns.DISPLAY_DATE, value);
        return this;
    }

    public ConferenceSelection contact(String... value) {
        addEquals(ConferenceColumns.CONTACT, value);
        return this;
    }

    public ConferenceSelection contactNot(String... value) {
        addNotEquals(ConferenceColumns.CONTACT, value);
        return this;
    }

    public ConferenceSelection contactLike(String... value) {
        addLike(ConferenceColumns.CONTACT, value);
        return this;
    }

    public ConferenceSelection contactContains(String... value) {
        addContains(ConferenceColumns.CONTACT, value);
        return this;
    }

    public ConferenceSelection contactStartsWith(String... value) {
        addStartsWith(ConferenceColumns.CONTACT, value);
        return this;
    }

    public ConferenceSelection contactEndsWith(String... value) {
        addEndsWith(ConferenceColumns.CONTACT, value);
        return this;
    }

    public ConferenceSelection call(String... value) {
        addEquals(ConferenceColumns.CALL, value);
        return this;
    }

    public ConferenceSelection callNot(String... value) {
        addNotEquals(ConferenceColumns.CALL, value);
        return this;
    }

    public ConferenceSelection callLike(String... value) {
        addLike(ConferenceColumns.CALL, value);
        return this;
    }

    public ConferenceSelection callContains(String... value) {
        addContains(ConferenceColumns.CALL, value);
        return this;
    }

    public ConferenceSelection callStartsWith(String... value) {
        addStartsWith(ConferenceColumns.CALL, value);
        return this;
    }

    public ConferenceSelection callEndsWith(String... value) {
        addEndsWith(ConferenceColumns.CALL, value);
        return this;
    }

    public ConferenceSelection location(String... value) {
        addEquals(ConferenceColumns.LOCATION, value);
        return this;
    }

    public ConferenceSelection locationNot(String... value) {
        addNotEquals(ConferenceColumns.LOCATION, value);
        return this;
    }

    public ConferenceSelection locationLike(String... value) {
        addLike(ConferenceColumns.LOCATION, value);
        return this;
    }

    public ConferenceSelection locationContains(String... value) {
        addContains(ConferenceColumns.LOCATION, value);
        return this;
    }

    public ConferenceSelection locationStartsWith(String... value) {
        addStartsWith(ConferenceColumns.LOCATION, value);
        return this;
    }

    public ConferenceSelection locationEndsWith(String... value) {
        addEndsWith(ConferenceColumns.LOCATION, value);
        return this;
    }

    public ConferenceSelection link(String... value) {
        addEquals(ConferenceColumns.LINK, value);
        return this;
    }

    public ConferenceSelection linkNot(String... value) {
        addNotEquals(ConferenceColumns.LINK, value);
        return this;
    }

    public ConferenceSelection linkLike(String... value) {
        addLike(ConferenceColumns.LINK, value);
        return this;
    }

    public ConferenceSelection linkContains(String... value) {
        addContains(ConferenceColumns.LINK, value);
        return this;
    }

    public ConferenceSelection linkStartsWith(String... value) {
        addStartsWith(ConferenceColumns.LINK, value);
        return this;
    }

    public ConferenceSelection linkEndsWith(String... value) {
        addEndsWith(ConferenceColumns.LINK, value);
        return this;
    }

    public ConferenceSelection number(Integer... value) {
        addEquals(ConferenceColumns.NUMBER, value);
        return this;
    }

    public ConferenceSelection numberNot(Integer... value) {
        addNotEquals(ConferenceColumns.NUMBER, value);
        return this;
    }

    public ConferenceSelection numberGt(int value) {
        addGreaterThan(ConferenceColumns.NUMBER, value);
        return this;
    }

    public ConferenceSelection numberGtEq(int value) {
        addGreaterThanOrEquals(ConferenceColumns.NUMBER, value);
        return this;
    }

    public ConferenceSelection numberLt(int value) {
        addLessThan(ConferenceColumns.NUMBER, value);
        return this;
    }

    public ConferenceSelection numberLtEq(int value) {
        addLessThanOrEquals(ConferenceColumns.NUMBER, value);
        return this;
    }

    public ConferenceSelection attendance(Integer... value) {
        addEquals(ConferenceColumns.ATTENDANCE, value);
        return this;
    }

    public ConferenceSelection attendanceNot(Integer... value) {
        addNotEquals(ConferenceColumns.ATTENDANCE, value);
        return this;
    }

    public ConferenceSelection attendanceGt(int value) {
        addGreaterThan(ConferenceColumns.ATTENDANCE, value);
        return this;
    }

    public ConferenceSelection attendanceGtEq(int value) {
        addGreaterThanOrEquals(ConferenceColumns.ATTENDANCE, value);
        return this;
    }

    public ConferenceSelection attendanceLt(int value) {
        addLessThan(ConferenceColumns.ATTENDANCE, value);
        return this;
    }

    public ConferenceSelection attendanceLtEq(int value) {
        addLessThanOrEquals(ConferenceColumns.ATTENDANCE, value);
        return this;
    }

    public ConferenceSelection region(String... value) {
        addEquals(ConferenceColumns.REGION, value);
        return this;
    }

    public ConferenceSelection regionNot(String... value) {
        addNotEquals(ConferenceColumns.REGION, value);
        return this;
    }

    public ConferenceSelection regionLike(String... value) {
        addLike(ConferenceColumns.REGION, value);
        return this;
    }

    public ConferenceSelection regionContains(String... value) {
        addContains(ConferenceColumns.REGION, value);
        return this;
    }

    public ConferenceSelection regionStartsWith(String... value) {
        addStartsWith(ConferenceColumns.REGION, value);
        return this;
    }

    public ConferenceSelection regionEndsWith(String... value) {
        addEndsWith(ConferenceColumns.REGION, value);
        return this;
    }
}
