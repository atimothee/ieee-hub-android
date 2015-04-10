package org.ieee.ieeehub.provider.articleimage;

import java.util.Date;

import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import org.ieee.ieeehub.provider.base.AbstractCursor;
import org.ieee.ieeehub.provider.article.*;
import org.ieee.ieeehub.provider.category.*;

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
    public Long getArticleCategoryId() {
        Long res = getLongOrNull(ArticleColumns.CATEGORY_ID);
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
