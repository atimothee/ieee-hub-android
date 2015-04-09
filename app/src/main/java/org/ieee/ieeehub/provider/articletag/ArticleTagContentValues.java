package org.ieee.ieeehub.provider.articletag;

import java.util.Date;

import android.content.ContentResolver;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import org.ieee.ieeehub.provider.base.AbstractContentValues;

/**
 * Content values wrapper for the {@code article_tag} table.
 */
public class ArticleTagContentValues extends AbstractContentValues {
    @Override
    public Uri uri() {
        return ArticleTagColumns.CONTENT_URI;
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(ContentResolver contentResolver, @Nullable ArticleTagSelection where) {
        return contentResolver.update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    public ArticleTagContentValues putArticleId(@Nullable Long value) {
        mContentValues.put(ArticleTagColumns.ARTICLE_ID, value);
        return this;
    }

    public ArticleTagContentValues putArticleIdNull() {
        mContentValues.putNull(ArticleTagColumns.ARTICLE_ID);
        return this;
    }

    public ArticleTagContentValues putName(@NonNull String value) {
        if (value == null) throw new IllegalArgumentException("name must not be null");
        mContentValues.put(ArticleTagColumns.NAME, value);
        return this;
    }

}
