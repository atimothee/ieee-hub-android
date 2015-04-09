package org.ieee.ieeehub.provider.articletag;

import org.ieee.ieeehub.provider.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Data model for the {@code article_tag} table.
 */
public interface ArticleTagModel extends BaseModel {

    /**
     * Get the {@code article_id} value.
     * Can be {@code null}.
     */
    @Nullable
    Long getArticleId();

    /**
     * Get the {@code name} value.
     * Cannot be {@code null}.
     */
    @NonNull
    String getName();
}
