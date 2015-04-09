package org.ieee.ieeehub.provider.conferencetag;

import org.ieee.ieeehub.provider.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Data model for the {@code conference_tag} table.
 */
public interface ConferenceTagModel extends BaseModel {

    /**
     * Get the {@code conference_id} value.
     * Can be {@code null}.
     */
    @Nullable
    Integer getConferenceId();

    /**
     * Get the {@code name} value.
     * Cannot be {@code null}.
     */
    @NonNull
    String getName();
}
