package org.ieee.ieeehub.provider.conferencesponsor;

import java.util.Date;

import android.content.ContentResolver;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import org.ieee.ieeehub.provider.base.AbstractContentValues;

/**
 * Content values wrapper for the {@code conference_sponsor} table.
 */
public class ConferenceSponsorContentValues extends AbstractContentValues {
    @Override
    public Uri uri() {
        return ConferenceSponsorColumns.CONTENT_URI;
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(ContentResolver contentResolver, @Nullable ConferenceSponsorSelection where) {
        return contentResolver.update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    public ConferenceSponsorContentValues putConferenceId(@Nullable Integer value) {
        mContentValues.put(ConferenceSponsorColumns.CONFERENCE_ID, value);
        return this;
    }

    public ConferenceSponsorContentValues putConferenceIdNull() {
        mContentValues.putNull(ConferenceSponsorColumns.CONFERENCE_ID);
        return this;
    }

    public ConferenceSponsorContentValues putName(@NonNull String value) {
        if (value == null) throw new IllegalArgumentException("name must not be null");
        mContentValues.put(ConferenceSponsorColumns.NAME, value);
        return this;
    }

}
