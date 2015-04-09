package org.ieee.ieeehub.provider.articleimage;

import java.util.Date;

import android.content.ContentResolver;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import org.ieee.ieeehub.provider.base.AbstractContentValues;

/**
 * Content values wrapper for the {@code article_image} table.
 */
public class ArticleImageContentValues extends AbstractContentValues {
    @Override
    public Uri uri() {
        return ArticleImageColumns.CONTENT_URI;
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(ContentResolver contentResolver, @Nullable ArticleImageSelection where) {
        return contentResolver.update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    public ArticleImageContentValues putArticleId(@Nullable Long value) {
        mContentValues.put(ArticleImageColumns.ARTICLE_ID, value);
        return this;
    }

    public ArticleImageContentValues putArticleIdNull() {
        mContentValues.putNull(ArticleImageColumns.ARTICLE_ID);
        return this;
    }

    public ArticleImageContentValues putUrl(@NonNull String value) {
        if (value == null) throw new IllegalArgumentException("url must not be null");
        mContentValues.put(ArticleImageColumns.URL, value);
        return this;
    }

}
