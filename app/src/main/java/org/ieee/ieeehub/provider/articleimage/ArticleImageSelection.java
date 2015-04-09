package org.ieee.ieeehub.provider.articleimage;

import java.util.Date;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;

import org.ieee.ieeehub.provider.base.AbstractSelection;
import org.ieee.ieeehub.provider.article.*;
import org.ieee.ieeehub.provider.category.*;

/**
 * Selection for the {@code article_image} table.
 */
public class ArticleImageSelection extends AbstractSelection<ArticleImageSelection> {
    @Override
    protected Uri baseUri() {
        return ArticleImageColumns.CONTENT_URI;
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param contentResolver The content resolver to query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @param sortOrder How to order the rows, formatted as an SQL ORDER BY clause (excluding the ORDER BY itself). Passing null will use the default sort
     *            order, which may be unordered.
     * @return A {@code ArticleImageCursor} object, which is positioned before the first entry, or null.
     */
    public ArticleImageCursor query(ContentResolver contentResolver, String[] projection, String sortOrder) {
        Cursor cursor = contentResolver.query(uri(), projection, sel(), args(), sortOrder);
        if (cursor == null) return null;
        return new ArticleImageCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, projection, null)}.
     */
    public ArticleImageCursor query(ContentResolver contentResolver, String[] projection) {
        return query(contentResolver, projection, null);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, projection, null, null)}.
     */
    public ArticleImageCursor query(ContentResolver contentResolver) {
        return query(contentResolver, null, null);
    }


    public ArticleImageSelection id(long... value) {
        addEquals("article_image." + ArticleImageColumns._ID, toObjectArray(value));
        return this;
    }

    public ArticleImageSelection articleId(Long... value) {
        addEquals(ArticleImageColumns.ARTICLE_ID, value);
        return this;
    }

    public ArticleImageSelection articleIdNot(Long... value) {
        addNotEquals(ArticleImageColumns.ARTICLE_ID, value);
        return this;
    }

    public ArticleImageSelection articleIdGt(long value) {
        addGreaterThan(ArticleImageColumns.ARTICLE_ID, value);
        return this;
    }

    public ArticleImageSelection articleIdGtEq(long value) {
        addGreaterThanOrEquals(ArticleImageColumns.ARTICLE_ID, value);
        return this;
    }

    public ArticleImageSelection articleIdLt(long value) {
        addLessThan(ArticleImageColumns.ARTICLE_ID, value);
        return this;
    }

    public ArticleImageSelection articleIdLtEq(long value) {
        addLessThanOrEquals(ArticleImageColumns.ARTICLE_ID, value);
        return this;
    }

    public ArticleImageSelection articleTitle(String... value) {
        addEquals(ArticleColumns.TITLE, value);
        return this;
    }

    public ArticleImageSelection articleTitleNot(String... value) {
        addNotEquals(ArticleColumns.TITLE, value);
        return this;
    }

    public ArticleImageSelection articleTitleLike(String... value) {
        addLike(ArticleColumns.TITLE, value);
        return this;
    }

    public ArticleImageSelection articleTitleContains(String... value) {
        addContains(ArticleColumns.TITLE, value);
        return this;
    }

    public ArticleImageSelection articleTitleStartsWith(String... value) {
        addStartsWith(ArticleColumns.TITLE, value);
        return this;
    }

    public ArticleImageSelection articleTitleEndsWith(String... value) {
        addEndsWith(ArticleColumns.TITLE, value);
        return this;
    }

    public ArticleImageSelection articleText(String... value) {
        addEquals(ArticleColumns.TEXT, value);
        return this;
    }

    public ArticleImageSelection articleTextNot(String... value) {
        addNotEquals(ArticleColumns.TEXT, value);
        return this;
    }

    public ArticleImageSelection articleTextLike(String... value) {
        addLike(ArticleColumns.TEXT, value);
        return this;
    }

    public ArticleImageSelection articleTextContains(String... value) {
        addContains(ArticleColumns.TEXT, value);
        return this;
    }

    public ArticleImageSelection articleTextStartsWith(String... value) {
        addStartsWith(ArticleColumns.TEXT, value);
        return this;
    }

    public ArticleImageSelection articleTextEndsWith(String... value) {
        addEndsWith(ArticleColumns.TEXT, value);
        return this;
    }

    public ArticleImageSelection articlePubDate(Date... value) {
        addEquals(ArticleColumns.PUB_DATE, value);
        return this;
    }

    public ArticleImageSelection articlePubDateNot(Date... value) {
        addNotEquals(ArticleColumns.PUB_DATE, value);
        return this;
    }

    public ArticleImageSelection articlePubDate(Long... value) {
        addEquals(ArticleColumns.PUB_DATE, value);
        return this;
    }

    public ArticleImageSelection articlePubDateAfter(Date value) {
        addGreaterThan(ArticleColumns.PUB_DATE, value);
        return this;
    }

    public ArticleImageSelection articlePubDateAfterEq(Date value) {
        addGreaterThanOrEquals(ArticleColumns.PUB_DATE, value);
        return this;
    }

    public ArticleImageSelection articlePubDateBefore(Date value) {
        addLessThan(ArticleColumns.PUB_DATE, value);
        return this;
    }

    public ArticleImageSelection articlePubDateBeforeEq(Date value) {
        addLessThanOrEquals(ArticleColumns.PUB_DATE, value);
        return this;
    }

    public ArticleImageSelection articleCategoryId(Integer... value) {
        addEquals(ArticleColumns.CATEGORY_ID, value);
        return this;
    }

    public ArticleImageSelection articleCategoryIdNot(Integer... value) {
        addNotEquals(ArticleColumns.CATEGORY_ID, value);
        return this;
    }

    public ArticleImageSelection articleCategoryIdGt(int value) {
        addGreaterThan(ArticleColumns.CATEGORY_ID, value);
        return this;
    }

    public ArticleImageSelection articleCategoryIdGtEq(int value) {
        addGreaterThanOrEquals(ArticleColumns.CATEGORY_ID, value);
        return this;
    }

    public ArticleImageSelection articleCategoryIdLt(int value) {
        addLessThan(ArticleColumns.CATEGORY_ID, value);
        return this;
    }

    public ArticleImageSelection articleCategoryIdLtEq(int value) {
        addLessThanOrEquals(ArticleColumns.CATEGORY_ID, value);
        return this;
    }

    public ArticleImageSelection articleCategoryName(String... value) {
        addEquals(CategoryColumns.NAME, value);
        return this;
    }

    public ArticleImageSelection articleCategoryNameNot(String... value) {
        addNotEquals(CategoryColumns.NAME, value);
        return this;
    }

    public ArticleImageSelection articleCategoryNameLike(String... value) {
        addLike(CategoryColumns.NAME, value);
        return this;
    }

    public ArticleImageSelection articleCategoryNameContains(String... value) {
        addContains(CategoryColumns.NAME, value);
        return this;
    }

    public ArticleImageSelection articleCategoryNameStartsWith(String... value) {
        addStartsWith(CategoryColumns.NAME, value);
        return this;
    }

    public ArticleImageSelection articleCategoryNameEndsWith(String... value) {
        addEndsWith(CategoryColumns.NAME, value);
        return this;
    }

    public ArticleImageSelection articleCategoryLink(String... value) {
        addEquals(CategoryColumns.LINK, value);
        return this;
    }

    public ArticleImageSelection articleCategoryLinkNot(String... value) {
        addNotEquals(CategoryColumns.LINK, value);
        return this;
    }

    public ArticleImageSelection articleCategoryLinkLike(String... value) {
        addLike(CategoryColumns.LINK, value);
        return this;
    }

    public ArticleImageSelection articleCategoryLinkContains(String... value) {
        addContains(CategoryColumns.LINK, value);
        return this;
    }

    public ArticleImageSelection articleCategoryLinkStartsWith(String... value) {
        addStartsWith(CategoryColumns.LINK, value);
        return this;
    }

    public ArticleImageSelection articleCategoryLinkEndsWith(String... value) {
        addEndsWith(CategoryColumns.LINK, value);
        return this;
    }

    public ArticleImageSelection articleCategoryColor(String... value) {
        addEquals(CategoryColumns.COLOR, value);
        return this;
    }

    public ArticleImageSelection articleCategoryColorNot(String... value) {
        addNotEquals(CategoryColumns.COLOR, value);
        return this;
    }

    public ArticleImageSelection articleCategoryColorLike(String... value) {
        addLike(CategoryColumns.COLOR, value);
        return this;
    }

    public ArticleImageSelection articleCategoryColorContains(String... value) {
        addContains(CategoryColumns.COLOR, value);
        return this;
    }

    public ArticleImageSelection articleCategoryColorStartsWith(String... value) {
        addStartsWith(CategoryColumns.COLOR, value);
        return this;
    }

    public ArticleImageSelection articleCategoryColorEndsWith(String... value) {
        addEndsWith(CategoryColumns.COLOR, value);
        return this;
    }

    public ArticleImageSelection articleImage(String... value) {
        addEquals(ArticleColumns.IMAGE, value);
        return this;
    }

    public ArticleImageSelection articleImageNot(String... value) {
        addNotEquals(ArticleColumns.IMAGE, value);
        return this;
    }

    public ArticleImageSelection articleImageLike(String... value) {
        addLike(ArticleColumns.IMAGE, value);
        return this;
    }

    public ArticleImageSelection articleImageContains(String... value) {
        addContains(ArticleColumns.IMAGE, value);
        return this;
    }

    public ArticleImageSelection articleImageStartsWith(String... value) {
        addStartsWith(ArticleColumns.IMAGE, value);
        return this;
    }

    public ArticleImageSelection articleImageEndsWith(String... value) {
        addEndsWith(ArticleColumns.IMAGE, value);
        return this;
    }

    public ArticleImageSelection articleLink(String... value) {
        addEquals(ArticleColumns.LINK, value);
        return this;
    }

    public ArticleImageSelection articleLinkNot(String... value) {
        addNotEquals(ArticleColumns.LINK, value);
        return this;
    }

    public ArticleImageSelection articleLinkLike(String... value) {
        addLike(ArticleColumns.LINK, value);
        return this;
    }

    public ArticleImageSelection articleLinkContains(String... value) {
        addContains(ArticleColumns.LINK, value);
        return this;
    }

    public ArticleImageSelection articleLinkStartsWith(String... value) {
        addStartsWith(ArticleColumns.LINK, value);
        return this;
    }

    public ArticleImageSelection articleLinkEndsWith(String... value) {
        addEndsWith(ArticleColumns.LINK, value);
        return this;
    }

    public ArticleImageSelection url(String... value) {
        addEquals(ArticleImageColumns.URL, value);
        return this;
    }

    public ArticleImageSelection urlNot(String... value) {
        addNotEquals(ArticleImageColumns.URL, value);
        return this;
    }

    public ArticleImageSelection urlLike(String... value) {
        addLike(ArticleImageColumns.URL, value);
        return this;
    }

    public ArticleImageSelection urlContains(String... value) {
        addContains(ArticleImageColumns.URL, value);
        return this;
    }

    public ArticleImageSelection urlStartsWith(String... value) {
        addStartsWith(ArticleImageColumns.URL, value);
        return this;
    }

    public ArticleImageSelection urlEndsWith(String... value) {
        addEndsWith(ArticleImageColumns.URL, value);
        return this;
    }
}
