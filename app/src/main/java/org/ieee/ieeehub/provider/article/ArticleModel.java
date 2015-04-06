package org.ieee.ieeehub.provider.article;

import org.ieee.ieeehub.provider.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Data model for the {@code article} table.
 */
public interface ArticleModel extends BaseModel {

    /**
     * Get the {@code title} value.
     * Cannot be {@code null}.
     */
    @NonNull
    String getTitle();

    /**
     * Get the {@code text} value.
     * Can be {@code null}.
     */
    @Nullable
    String getText();

    /**
     * Get the {@code pub_date} value.
     * Can be {@code null}.
     */
    @Nullable
    Date getPubDate();

    /**
     * Get the {@code category_id} value.
     * Can be {@code null}.
     */
    @Nullable
    Integer getCategoryId();

    /**
     * Get the {@code image} value.
     * Can be {@code null}.
     */
    @Nullable
    String getImage();

    /**
     * Get the {@code link} value.
     * Can be {@code null}.
     */
    @Nullable
    String getLink();
}
