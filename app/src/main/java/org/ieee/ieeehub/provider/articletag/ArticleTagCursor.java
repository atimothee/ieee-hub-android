package org.ieee.ieeehub.provider.articletag;

import java.util.Date;

import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import org.ieee.ieeehub.provider.base.AbstractCursor;
import org.ieee.ieeehub.provider.article.*;
import org.ieee.ieeehub.provider.category.*;

/**
 * Cursor wrapper for the {@code article_tag} table.
 */
public class ArticleTagCursor extends AbstractCursor implements ArticleTagModel {
    public ArticleTagCursor(Cursor cursor) {
        super(cursor);
    }

    /**
     * Primary key.
     */
    public long getId() {
        Long res = getLongOrNull(ArticleTagColumns._ID);
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
        Long res = getLongOrNull(ArticleTagColumns.ARTICLE_ID);
        return res;
    }

    /**
     * Get the {@code title} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getArticleTitle() {
        String res = getStringOrNull(ArticleColumns.TITLE);
        return res;
    }

    /**
     * Get the {@code text} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getArticleText() {
        String res = getStringOrNull(ArticleColumns.TEXT);
        return res;
    }

    /**
     * Get the {@code pub_date} value.
     * Can be {@code null}.
     */
    @Nullable
    public Date getArticlePubDate() {
        Date res = getDateOrNull(ArticleColumns.PUB_DATE);
        return res;
    }

    /**
     * Get the {@code category_id} value.
     * Can be {@code null}.
     */
    @Nullable
    public Integer getArticleCategoryId() {
        Integer res = getIntegerOrNull(ArticleColumns.CATEGORY_ID);
        return res;
    }

    /**
     * Get the {@code name} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getArticleCategoryName() {
        String res = getStringOrNull(CategoryColumns.NAME);
        return res;
    }

    /**
     * Get the {@code link} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getArticleCategoryLink() {
        String res = getStringOrNull(CategoryColumns.LINK);
        return res;
    }

    /**
     * Get the {@code color} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getArticleCategoryColor() {
        String res = getStringOrNull(CategoryColumns.COLOR);
        return res;
    }

    /**
     * Get the {@code image} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getArticleImage() {
        String res = getStringOrNull(ArticleColumns.IMAGE);
        return res;
    }

    /**
     * Get the {@code link} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getArticleLink() {
        String res = getStringOrNull(ArticleColumns.LINK);
        return res;
    }

    /**
     * Get the {@code name} value.
     * Cannot be {@code null}.
     */
    @NonNull
    public String getName() {
        String res = getStringOrNull(ArticleTagColumns.NAME);
        if (res == null)
            throw new NullPointerException("The value of 'name' in the database was null, which is not allowed according to the model definition");
        return res;
    }
}
