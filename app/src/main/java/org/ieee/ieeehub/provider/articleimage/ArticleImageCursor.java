package org.ieee.ieeehub.provider.articleimage;

import java.util.Date;

import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import org.ieee.ieeehub.provider.base.AbstractCursor;
import org.ieee.ieeehub.provider.conference.*;

/**
 * Cursor wrapper for the {@code article_image} table.
 */
public class ArticleImageCursor extends AbstractCursor implements ArticleImageModel {
    public ArticleImageCursor(Cursor cursor) {
        super(cursor);
    }

    /**
     * Primary key.
     */
    public long getId() {
        Long res = getLongOrNull(ArticleImageColumns._ID);
        if (res == null)
            throw new NullPointerException("The value of '_id' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Get the {@code article_id} value.
     * Can be {@code null}.
     */
    @Nullable
    public Long getArticleId() {
        Long res = getLongOrNull(ArticleImageColumns.ARTICLE_ID);
        return res;
    }

    /**
     * Get the {@code title} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getConferenceTitle() {
        String res = getStringOrNull(ConferenceColumns.TITLE);
        return res;
    }

    /**
     * Get the {@code description} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getConferenceDescription() {
        String res = getStringOrNull(ConferenceColumns.DESCRIPTION);
        return res;
    }

    /**
     * Get the {@code start_date} value.
     * Can be {@code null}.
     */
    @Nullable
    public Date getConferenceStartDate() {
        Date res = getDateOrNull(ConferenceColumns.START_DATE);
        return res;
    }

    /**
     * Get the {@code end_date} value.
     * Can be {@code null}.
     */
    @Nullable
    public Date getConferenceEndDate() {
        Date res = getDateOrNull(ConferenceColumns.END_DATE);
        return res;
    }

    /**
     * Get the {@code display_date} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getConferenceDisplayDate() {
        String res = getStringOrNull(ConferenceColumns.DISPLAY_DATE);
        return res;
    }

    /**
     * Get the {@code contact} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getConferenceContact() {
        String res = getStringOrNull(ConferenceColumns.CONTACT);
        return res;
    }

    /**
     * Get the {@code call_url} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getConferenceCallUrl() {
        String res = getStringOrNull(ConferenceColumns.CALL_URL);
        return res;
    }

    /**
     * Get the {@code location} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getConferenceLocation() {
        String res = getStringOrNull(ConferenceColumns.LOCATION);
        return res;
    }

    /**
     * Get the {@code link} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getConferenceLink() {
        String res = getStringOrNull(ConferenceColumns.LINK);
        return res;
    }

    /**
     * Get the {@code number} value.
     * Can be {@code null}.
     */
    @Nullable
    public Integer getConferenceNumber() {
        Integer res = getIntegerOrNull(ConferenceColumns.NUMBER);
        return res;
    }

    /**
     * Get the {@code attendance} value.
     * Can be {@code null}.
     */
    @Nullable
    public Integer getConferenceAttendance() {
        Integer res = getIntegerOrNull(ConferenceColumns.ATTENDANCE);
        return res;
    }

    /**
     * Get the {@code region} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getConferenceRegion() {
        String res = getStringOrNull(ConferenceColumns.REGION);
        return res;
    }

    /**
     * Get the {@code website} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getConferenceWebsite() {
        String res = getStringOrNull(ConferenceColumns.WEBSITE);
        return res;
    }

    /**
     * Get the {@code url} value.
     * Cannot be {@code null}.
     */
    @NonNull
    public String getUrl() {
        String res = getStringOrNull(ArticleImageColumns.URL);
        if (res == null)
            throw new NullPointerException("The value of 'url' in the database was null, which is not allowed according to the model definition");
        return res;
    }
}
