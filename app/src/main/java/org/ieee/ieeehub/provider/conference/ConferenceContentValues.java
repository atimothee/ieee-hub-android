package org.ieee.ieeehub.provider.conference;

import java.util.Date;

import android.content.ContentResolver;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import org.ieee.ieeehub.provider.base.AbstractContentValues;

/**
 * Content values wrapper for the {@code conference} table.
 */
public class ConferenceContentValues extends AbstractContentValues {
    @Override
    public Uri uri() {
        return ConferenceColumns.CONTENT_URI;
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(ContentResolver contentResolver, @Nullable ConferenceSelection where) {
        return contentResolver.update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    public ConferenceContentValues putTitle(@NonNull String value) {
        if (value == null) throw new IllegalArgumentException("title must not be null");
        mContentValues.put(ConferenceColumns.TITLE, value);
        return this;
    }


    public ConferenceContentValues putDescription(@Nullable String value) {
        mContentValues.put(ConferenceColumns.DESCRIPTION, value);
        return this;
    }

    public ConferenceContentValues putDescriptionNull() {
        mContentValues.putNull(ConferenceColumns.DESCRIPTION);
        return this;
    }

    public ConferenceContentValues putStartDate(@Nullable Date value) {
        mContentValues.put(ConferenceColumns.START_DATE, value == null ? null : value.getTime());
        return this;
    }

    public ConferenceContentValues putStartDateNull() {
        mContentValues.putNull(ConferenceColumns.START_DATE);
        return this;
    }

    public ConferenceContentValues putStartDate(@Nullable Long value) {
        mContentValues.put(ConferenceColumns.START_DATE, value);
        return this;
    }

    public ConferenceContentValues putEndDate(@Nullable Date value) {
        mContentValues.put(ConferenceColumns.END_DATE, value == null ? null : value.getTime());
        return this;
    }

    public ConferenceContentValues putEndDateNull() {
        mContentValues.putNull(ConferenceColumns.END_DATE);
        return this;
    }

    public ConferenceContentValues putEndDate(@Nullable Long value) {
        mContentValues.put(ConferenceColumns.END_DATE, value);
        return this;
    }

    public ConferenceContentValues putDisplayDate(@Nullable String value) {
        mContentValues.put(ConferenceColumns.DISPLAY_DATE, value);
        return this;
    }

    public ConferenceContentValues putDisplayDateNull() {
        mContentValues.putNull(ConferenceColumns.DISPLAY_DATE);
        return this;
    }

    public ConferenceContentValues putContact(@Nullable String value) {
        mContentValues.put(ConferenceColumns.CONTACT, value);
        return this;
    }

    public ConferenceContentValues putContactNull() {
        mContentValues.putNull(ConferenceColumns.CONTACT);
        return this;
    }

    public ConferenceContentValues putCallUrl(@Nullable String value) {
        mContentValues.put(ConferenceColumns.CALL_URL, value);
        return this;
    }

    public ConferenceContentValues putCallUrlNull() {
        mContentValues.putNull(ConferenceColumns.CALL_URL);
        return this;
    }

    public ConferenceContentValues putLocation(@Nullable String value) {
        mContentValues.put(ConferenceColumns.LOCATION, value);
        return this;
    }

    public ConferenceContentValues putLocationNull() {
        mContentValues.putNull(ConferenceColumns.LOCATION);
        return this;
    }

    public ConferenceContentValues putLink(@Nullable String value) {
        mContentValues.put(ConferenceColumns.LINK, value);
        return this;
    }

    public ConferenceContentValues putLinkNull() {
        mContentValues.putNull(ConferenceColumns.LINK);
        return this;
    }

    public ConferenceContentValues putNumber(@Nullable Integer value) {
        mContentValues.put(ConferenceColumns.NUMBER, value);
        return this;
    }

    public ConferenceContentValues putNumberNull() {
        mContentValues.putNull(ConferenceColumns.NUMBER);
        return this;
    }

    public ConferenceContentValues putAttendance(@Nullable Integer value) {
        mContentValues.put(ConferenceColumns.ATTENDANCE, value);
        return this;
    }

    public ConferenceContentValues putAttendanceNull() {
        mContentValues.putNull(ConferenceColumns.ATTENDANCE);
        return this;
    }

    public ConferenceContentValues putRegion(@Nullable String value) {
        mContentValues.put(ConferenceColumns.REGION, value);
        return this;
    }

    public ConferenceContentValues putRegionNull() {
        mContentValues.putNull(ConferenceColumns.REGION);
        return this;
    }

    public ConferenceContentValues putWebsite(@Nullable String value) {
        mContentValues.put(ConferenceColumns.WEBSITE, value);
        return this;
    }

    public ConferenceContentValues putWebsiteNull() {
        mContentValues.putNull(ConferenceColumns.WEBSITE);
        return this;
    }
}
