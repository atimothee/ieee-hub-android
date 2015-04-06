package org.ieee.ieeehub.provider.category;

import org.ieee.ieeehub.provider.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Data model for the {@code category} table.
 */
public interface CategoryModel extends BaseModel {

    /**
     * Get the {@code name} value.
     * Cannot be {@code null}.
     */
    @NonNull
    String getName();

    /**
     * Get the {@code link} value.
     * Can be {@code null}.
     */
    @Nullable
    String getLink();

    /**
     * Get the {@code color} value.
     * Can be {@code null}.
     */
    @Nullable
    String getColor();
}
