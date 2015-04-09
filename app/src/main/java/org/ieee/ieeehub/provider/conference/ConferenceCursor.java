package org.ieee.ieeehub.provider.conference;

import java.util.Date;

import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import org.ieee.ieeehub.provider.base.AbstractCursor;

/**
 * Cursor wrapper for the {@code conference} table.
 */
public class ConferenceCursor extends AbstractCursor implements ConferenceModel {
    public ConferenceCursor(Cursor cursor) {
        super(cursor);
    }

    /**
     * Primary key.
     */
    public long getId() {
        Long res = getLongOrNull(ConferenceColumns._ID);
        if (res == null)
            throw new NullPointerException("The value of '_id' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Get the {@code title} value.
     * Cannot be {@code null}.
     */
    @NonNull
    public String getTitle() {
        String res = getStringOrNull(ConferenceColumns.TITLE);
        if (res == null)
            throw new NullPointerException("The value of 'title' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Get the {@code description} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getDescription() {
        String res = getStringOrNull(ConferenceColumns.DESCRIPTION);
        return res;
    }

    /**
     * Get the {@code start_date} value.
     * Can be {@code null}.
     */
    @Nullable
    public Date getStartDate() {
        Date res = getDateOrNull(ConferenceColumns.START_DATE);
        return res;
    }

    /**
     * Get the {@code end_date} value.
     * Can be {@code null}.
     */
    @Nullable
    public Date getEndDate() {
        Date res = getDateOrNull(ConferenceColumns.END_DATE);
        return res;
    }

    /**
     * Get the {@code display_date} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getDisplayDate() {
        String res = getStringOrNull(ConferenceColumns.DISPLAY_DATE);
        return res;
    }

    /**
     * Get the {@code contact} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getContact() {
        String res = getStringOrNull(ConferenceColumns.CONTACT);
        return res;
    }

    /**
     * Get the {@code call_url} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getCallUrl() {
        String res = getStringOrNull(ConferenceColumns.CALL_URL);
        return res;
    }

    /**
     * Get the {@code location} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getLocation() {
        String res = getStringOrNull(ConferenceColumns.LOCATION);
        return res;
    }

    /**
     * Get the {@code link} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getLink() {
        String res = getStringOrNull(ConferenceColumns.LINK);
        return res;
    }

    /**
     * Get the {@code number} value.
     * Can be {@code null}.
     */
    @Nullable
    public Integer getNumber() {
        Integer res = getIntegerOrNull(ConferenceColumns.NUMBER);
        return res;
    }

    /**
     * Get the {@code attendance} value.
     * Can be {@code null}.
     */
    @Nullable
    public Integer getAttendance() {
        Integer res = getIntegerOrNull(ConferenceColumns.ATTENDANCE);
        return res;
    }

    /**
     * Get the {@code region} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getRegion() {
        String res = getStringOrNull(ConferenceColumns.REGION);
        return res;
    }

    /**
     * Get the {@code website} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getWebsite() {
        String res = getStringOrNull(ConferenceColumns.WEBSITE);
        return res;
    }
}
