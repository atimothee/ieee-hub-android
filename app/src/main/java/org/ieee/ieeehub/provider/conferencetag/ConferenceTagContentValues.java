package org.ieee.ieeehub.provider.conferencetag;

import java.util.Date;

import android.content.ContentResolver;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import org.ieee.ieeehub.provider.base.AbstractContentValues;

/**
 * Content values wrapper for the {@code conference_tag} table.
 */
public class ConferenceTagContentValues extends AbstractContentValues {
    @Override
    public Uri uri() {
        return ConferenceTagColumns.CONTENT_URI;
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(ContentResolver contentResolver, @Nullable ConferenceTagSelection where) {
        return contentResolver.update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    public ConferenceTagContentValues putConferenceId(@Nullable Integer value) {
        mContentValues.put(ConferenceTagColumns.CONFERENCE_ID, value);
        return this;
    }

    public ConferenceTagContentValues putConferenceIdNull() {
        mContentValues.putNull(ConferenceTagColumns.CONFERENCE_ID);
        return this;
    }

    public ConferenceTagContentValues putName(@NonNull String value) {
        if (value == null) throw new IllegalArgumentException("name must not be null");
        mContentValues.put(ConferenceTagColumns.NAME, value);
        return this;
    }

}
