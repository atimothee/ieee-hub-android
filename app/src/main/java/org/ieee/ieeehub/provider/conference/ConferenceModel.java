package org.ieee.ieeehub.provider.conference;

import org.ieee.ieeehub.provider.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Data model for the {@code conference} table.
 */
public interface ConferenceModel extends BaseModel {

    /**
     * Get the {@code title} value.
     * Cannot be {@code null}.
     */
    @NonNull
    String getTitle();

    /**
     * Get the {@code description} value.
     * Can be {@code null}.
     */
    @Nullable
    String getDescription();

    /**
     * Get the {@code start_date} value.
     * Can be {@code null}.
     */
    @Nullable
    Date getStartDate();

    /**
     * Get the {@code end_date} value.
     * Can be {@code null}.
     */
    @Nullable
    Date getEndDate();

    /**
     * Get the {@code display_date} value.
     * Can be {@code null}.
     */
    @Nullable
    String getDisplayDate();

    /**
     * Get the {@code contact} value.
     * Can be {@code null}.
     */
    @Nullable
    String getContact();

    /**
     * Get the {@code call} value.
     * Can be {@code null}.
     */
    @Nullable
    String getCall();

    /**
     * Get the {@code location} value.
     * Can be {@code null}.
     */
    @Nullable
    String getLocation();

    /**
     * Get the {@code link} value.
     * Can be {@code null}.
     */
    @Nullable
    String getLink();

    /**
     * Get the {@code number} value.
     * Can be {@code null}.
     */
    @Nullable
    Integer getNumber();

    /**
     * Get the {@code attendance} value.
     * Can be {@code null}.
     */
    @Nullable
    Integer getAttendance();

    /**
     * Get the {@code region} value.
     * Can be {@code null}.
     */
    @Nullable
    String getRegion();
}
