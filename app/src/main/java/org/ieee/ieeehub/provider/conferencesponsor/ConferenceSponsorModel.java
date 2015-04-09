package org.ieee.ieeehub.provider.conferencesponsor;

import org.ieee.ieeehub.provider.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Data model for the {@code conference_sponsor} table.
 */
public interface ConferenceSponsorModel extends BaseModel {

    /**
     * Get the {@code conference_id} value.
     * Can be {@code null}.
     */
    @Nullable
    Long getConferenceId();

    /**
     * Get the {@code name} value.
     * Cannot be {@code null}.
     */
    @NonNull
    String getName();
}
