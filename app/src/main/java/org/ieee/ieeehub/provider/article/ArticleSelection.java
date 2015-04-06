package org.ieee.ieeehub.provider.article;

import java.util.Date;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;

import org.ieee.ieeehub.provider.base.AbstractSelection;
import org.ieee.ieeehub.provider.category.*;

/**
 * Selection for the {@code article} table.
 */
public class ArticleSelection extends AbstractSelection<ArticleSelection> {
    @Override
    protected Uri baseUri() {
        return ArticleColumns.CONTENT_URI;
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param contentResolver The content resolver to query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @param sortOrder How to order the rows, formatted as an SQL ORDER BY clause (excluding the ORDER BY itself). Passing null will use the default sort
     *            order, which may be unordered.
     * @return A {@code ArticleCursor} object, which is positioned before the first entry, or null.
     */
    public ArticleCursor query(ContentResolver contentResolver, String[] projection, String sortOrder) {
        Cursor cursor = contentResolver.query(uri(), projection, sel(), args(), sortOrder);
        if (cursor == null) return null;
        return new ArticleCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, projection, null)}.
     */
    public ArticleCursor query(ContentResolver contentResolver, String[] projection) {
        return query(contentResolver, projection, null);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, projection, null, null)}.
     */
    public ArticleCursor query(ContentResolver contentResolver) {
        return query(contentResolver, null, null);
    }


    public ArticleSelection id(long... value) {
        addEquals("article." + ArticleColumns._ID, toObjectArray(value));
        return this;
    }

    public ArticleSelection title(String... value) {
        addEquals(ArticleColumns.TITLE, value);
        return this;
    }

    public ArticleSelection titleNot(String... value) {
        addNotEquals(ArticleColumns.TITLE, value);
        return this;
    }

    public ArticleSelection titleLike(String... value) {
        addLike(ArticleColumns.TITLE, value);
        return this;
    }

    public ArticleSelection titleContains(String... value) {
        addContains(ArticleColumns.TITLE, value);
        return this;
    }

    public ArticleSelection titleStartsWith(String... value) {
        addStartsWith(ArticleColumns.TITLE, value);
        return this;
    }

    public ArticleSelection titleEndsWith(String... value) {
        addEndsWith(ArticleColumns.TITLE, value);
        return this;
    }

    public ArticleSelection text(String... value) {
        addEquals(ArticleColumns.TEXT, value);
        return this;
    }

    public ArticleSelection textNot(String... value) {
        addNotEquals(ArticleColumns.TEXT, value);
        return this;
    }

    public ArticleSelection textLike(String... value) {
        addLike(ArticleColumns.TEXT, value);
        return this;
    }

    public ArticleSelection textContains(String... value) {
        addContains(ArticleColumns.TEXT, value);
        return this;
    }

    public ArticleSelection textStartsWith(String... value) {
        addStartsWith(ArticleColumns.TEXT, value);
        return this;
    }

    public ArticleSelection textEndsWith(String... value) {
        addEndsWith(ArticleColumns.TEXT, value);
        return this;
    }

    public ArticleSelection pubDate(Date... value) {
        addEquals(ArticleColumns.PUB_DATE, value);
        return this;
    }

    public ArticleSelection pubDateNot(Date... value) {
        addNotEquals(ArticleColumns.PUB_DATE, value);
        return this;
    }

    public ArticleSelection pubDate(Long... value) {
        addEquals(ArticleColumns.PUB_DATE, value);
        return this;
    }

    public ArticleSelection pubDateAfter(Date value) {
        addGreaterThan(ArticleColumns.PUB_DATE, value);
        return this;
    }

    public ArticleSelection pubDateAfterEq(Date value) {
        addGreaterThanOrEquals(ArticleColumns.PUB_DATE, value);
        return this;
    }

    public ArticleSelection pubDateBefore(Date value) {
        addLessThan(ArticleColumns.PUB_DATE, value);
        return this;
    }

    public ArticleSelection pubDateBeforeEq(Date value) {
        addLessThanOrEquals(ArticleColumns.PUB_DATE, value);
        return this;
    }

    public ArticleSelection categoryId(Integer... value) {
        addEquals(ArticleColumns.CATEGORY_ID, value);
        return this;
    }

    public ArticleSelection categoryIdNot(Integer... value) {
        addNotEquals(ArticleColumns.CATEGORY_ID, value);
        return this;
    }

    public ArticleSelection categoryIdGt(int value) {
        addGreaterThan(ArticleColumns.CATEGORY_ID, value);
        return this;
    }

    public ArticleSelection categoryIdGtEq(int value) {
        addGreaterThanOrEquals(ArticleColumns.CATEGORY_ID, value);
        return this;
    }

    public ArticleSelection categoryIdLt(int value) {
        addLessThan(ArticleColumns.CATEGORY_ID, value);
        return this;
    }

    public ArticleSelection categoryIdLtEq(int value) {
        addLessThanOrEquals(ArticleColumns.CATEGORY_ID, value);
        return this;
    }

    public ArticleSelection categoryName(String... value) {
        addEquals(CategoryColumns.NAME, value);
        return this;
    }

    public ArticleSelection categoryNameNot(String... value) {
        addNotEquals(CategoryColumns.NAME, value);
        return this;
    }

    public ArticleSelection categoryNameLike(String... value) {
        addLike(CategoryColumns.NAME, value);
        return this;
    }

    public ArticleSelection categoryNameContains(String... value) {
        addContains(CategoryColumns.NAME, value);
        return this;
    }

    public ArticleSelection categoryNameStartsWith(String... value) {
        addStartsWith(CategoryColumns.NAME, value);
        return this;
    }

    public ArticleSelection categoryNameEndsWith(String... value) {
        addEndsWith(CategoryColumns.NAME, value);
        return this;
    }

    public ArticleSelection categoryLink(String... value) {
        addEquals(CategoryColumns.LINK, value);
        return this;
    }

    public ArticleSelection categoryLinkNot(String... value) {
        addNotEquals(CategoryColumns.LINK, value);
        return this;
    }

    public ArticleSelection categoryLinkLike(String... value) {
        addLike(CategoryColumns.LINK, value);
        return this;
    }

    public ArticleSelection categoryLinkContains(String... value) {
        addContains(CategoryColumns.LINK, value);
        return this;
    }

    public ArticleSelection categoryLinkStartsWith(String... value) {
        addStartsWith(CategoryColumns.LINK, value);
        return this;
    }

    public ArticleSelection categoryLinkEndsWith(String... value) {
        addEndsWith(CategoryColumns.LINK, value);
        return this;
    }

    public ArticleSelection categoryColor(String... value) {
        addEquals(CategoryColumns.COLOR, value);
        return this;
    }

    public ArticleSelection categoryColorNot(String... value) {
        addNotEquals(CategoryColumns.COLOR, value);
        return this;
    }

    public ArticleSelection categoryColorLike(String... value) {
        addLike(CategoryColumns.COLOR, value);
        return this;
    }

    public ArticleSelection categoryColorContains(String... value) {
        addContains(CategoryColumns.COLOR, value);
        return this;
    }

    public ArticleSelection categoryColorStartsWith(String... value) {
        addStartsWith(CategoryColumns.COLOR, value);
        return this;
    }

    public ArticleSelection categoryColorEndsWith(String... value) {
        addEndsWith(CategoryColumns.COLOR, value);
        return this;
    }

    public ArticleSelection image(String... value) {
        addEquals(ArticleColumns.IMAGE, value);
        return this;
    }

    public ArticleSelection imageNot(String... value) {
        addNotEquals(ArticleColumns.IMAGE, value);
        return this;
    }

    public ArticleSelection imageLike(String... value) {
        addLike(ArticleColumns.IMAGE, value);
        return this;
    }

    public ArticleSelection imageContains(String... value) {
        addContains(ArticleColumns.IMAGE, value);
        return this;
    }

    public ArticleSelection imageStartsWith(String... value) {
        addStartsWith(ArticleColumns.IMAGE, value);
        return this;
    }

    public ArticleSelection imageEndsWith(String... value) {
        addEndsWith(ArticleColumns.IMAGE, value);
        return this;
    }

    public ArticleSelection link(String... value) {
        addEquals(ArticleColumns.LINK, value);
        return this;
    }

    public ArticleSelection linkNot(String... value) {
        addNotEquals(ArticleColumns.LINK, value);
        return this;
    }

    public ArticleSelection linkLike(String... value) {
        addLike(ArticleColumns.LINK, value);
        return this;
    }

    public ArticleSelection linkContains(String... value) {
        addContains(ArticleColumns.LINK, value);
        return this;
    }

    public ArticleSelection linkStartsWith(String... value) {
        addStartsWith(ArticleColumns.LINK, value);
        return this;
    }

    public ArticleSelection linkEndsWith(String... value) {
        addEndsWith(ArticleColumns.LINK, value);
        return this;
    }
}
