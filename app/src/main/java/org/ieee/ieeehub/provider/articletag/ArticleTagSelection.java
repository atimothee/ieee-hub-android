package org.ieee.ieeehub.provider.articletag;

import java.util.Date;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;

import org.ieee.ieeehub.provider.base.AbstractSelection;
import org.ieee.ieeehub.provider.article.*;
import org.ieee.ieeehub.provider.category.*;

/**
 * Selection for the {@code article_tag} table.
 */
public class ArticleTagSelection extends AbstractSelection<ArticleTagSelection> {
    @Override
    protected Uri baseUri() {
        return ArticleTagColumns.CONTENT_URI;
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param contentResolver The content resolver to query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @param sortOrder How to order the rows, formatted as an SQL ORDER BY clause (excluding the ORDER BY itself). Passing null will use the default sort
     *            order, which may be unordered.
     * @return A {@code ArticleTagCursor} object, which is positioned before the first entry, or null.
     */
    public ArticleTagCursor query(ContentResolver contentResolver, String[] projection, String sortOrder) {
        Cursor cursor = contentResolver.query(uri(), projection, sel(), args(), sortOrder);
        if (cursor == null) return null;
        return new ArticleTagCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, projection, null)}.
     */
    public ArticleTagCursor query(ContentResolver contentResolver, String[] projection) {
        return query(contentResolver, projection, null);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, projection, null, null)}.
     */
    public ArticleTagCursor query(ContentResolver contentResolver) {
        return query(contentResolver, null, null);
    }


    public ArticleTagSelection id(long... value) {
        addEquals("article_tag." + ArticleTagColumns._ID, toObjectArray(value));
        return this;
    }

    public ArticleTagSelection articleId(Long... value) {
        addEquals(ArticleTagColumns.ARTICLE_ID, value);
        return this;
    }

    public ArticleTagSelection articleIdNot(Long... value) {
        addNotEquals(ArticleTagColumns.ARTICLE_ID, value);
        return this;
    }

    public ArticleTagSelection articleIdGt(long value) {
        addGreaterThan(ArticleTagColumns.ARTICLE_ID, value);
        return this;
    }

    public ArticleTagSelection articleIdGtEq(long value) {
        addGreaterThanOrEquals(ArticleTagColumns.ARTICLE_ID, value);
        return this;
    }

    public ArticleTagSelection articleIdLt(long value) {
        addLessThan(ArticleTagColumns.ARTICLE_ID, value);
        return this;
    }

    public ArticleTagSelection articleIdLtEq(long value) {
        addLessThanOrEquals(ArticleTagColumns.ARTICLE_ID, value);
        return this;
    }

    public ArticleTagSelection articleTitle(String... value) {
        addEquals(ArticleColumns.TITLE, value);
        return this;
    }

    public ArticleTagSelection articleTitleNot(String... value) {
        addNotEquals(ArticleColumns.TITLE, value);
        return this;
    }

    public ArticleTagSelection articleTitleLike(String... value) {
        addLike(ArticleColumns.TITLE, value);
        return this;
    }

    public ArticleTagSelection articleTitleContains(String... value) {
        addContains(ArticleColumns.TITLE, value);
        return this;
    }

    public ArticleTagSelection articleTitleStartsWith(String... value) {
        addStartsWith(ArticleColumns.TITLE, value);
        return this;
    }

    public ArticleTagSelection articleTitleEndsWith(String... value) {
        addEndsWith(ArticleColumns.TITLE, value);
        return this;
    }

    public ArticleTagSelection articleText(String... value) {
        addEquals(ArticleColumns.TEXT, value);
        return this;
    }

    public ArticleTagSelection articleTextNot(String... value) {
        addNotEquals(ArticleColumns.TEXT, value);
        return this;
    }

    public ArticleTagSelection articleTextLike(String... value) {
        addLike(ArticleColumns.TEXT, value);
        return this;
    }

    public ArticleTagSelection articleTextContains(String... value) {
        addContains(ArticleColumns.TEXT, value);
        return this;
    }

    public ArticleTagSelection articleTextStartsWith(String... value) {
        addStartsWith(ArticleColumns.TEXT, value);
        return this;
    }

    public ArticleTagSelection articleTextEndsWith(String... value) {
        addEndsWith(ArticleColumns.TEXT, value);
        return this;
    }

    public ArticleTagSelection articlePubDate(Date... value) {
        addEquals(ArticleColumns.PUB_DATE, value);
        return this;
    }

    public ArticleTagSelection articlePubDateNot(Date... value) {
        addNotEquals(ArticleColumns.PUB_DATE, value);
        return this;
    }

    public ArticleTagSelection articlePubDate(Long... value) {
        addEquals(ArticleColumns.PUB_DATE, value);
        return this;
    }

    public ArticleTagSelection articlePubDateAfter(Date value) {
        addGreaterThan(ArticleColumns.PUB_DATE, value);
        return this;
    }

    public ArticleTagSelection articlePubDateAfterEq(Date value) {
        addGreaterThanOrEquals(ArticleColumns.PUB_DATE, value);
        return this;
    }

    public ArticleTagSelection articlePubDateBefore(Date value) {
        addLessThan(ArticleColumns.PUB_DATE, value);
        return this;
    }

    public ArticleTagSelection articlePubDateBeforeEq(Date value) {
        addLessThanOrEquals(ArticleColumns.PUB_DATE, value);
        return this;
    }

    public ArticleTagSelection articleCategoryId(Long... value) {
        addEquals(ArticleColumns.CATEGORY_ID, value);
        return this;
    }

    public ArticleTagSelection articleCategoryIdNot(Long... value) {
        addNotEquals(ArticleColumns.CATEGORY_ID, value);
        return this;
    }

    public ArticleTagSelection articleCategoryIdGt(long value) {
        addGreaterThan(ArticleColumns.CATEGORY_ID, value);
        return this;
    }

    public ArticleTagSelection articleCategoryIdGtEq(long value) {
        addGreaterThanOrEquals(ArticleColumns.CATEGORY_ID, value);
        return this;
    }

    public ArticleTagSelection articleCategoryIdLt(long value) {
        addLessThan(ArticleColumns.CATEGORY_ID, value);
        return this;
    }

    public ArticleTagSelection articleCategoryIdLtEq(long value) {
        addLessThanOrEquals(ArticleColumns.CATEGORY_ID, value);
        return this;
    }

    public ArticleTagSelection articleCategoryName(String... value) {
        addEquals(CategoryColumns.NAME, value);
        return this;
    }

    public ArticleTagSelection articleCategoryNameNot(String... value) {
        addNotEquals(CategoryColumns.NAME, value);
        return this;
    }

    public ArticleTagSelection articleCategoryNameLike(String... value) {
        addLike(CategoryColumns.NAME, value);
        return this;
    }

    public ArticleTagSelection articleCategoryNameContains(String... value) {
        addContains(CategoryColumns.NAME, value);
        return this;
    }

    public ArticleTagSelection articleCategoryNameStartsWith(String... value) {
        addStartsWith(CategoryColumns.NAME, value);
        return this;
    }

    public ArticleTagSelection articleCategoryNameEndsWith(String... value) {
        addEndsWith(CategoryColumns.NAME, value);
        return this;
    }

    public ArticleTagSelection articleCategoryLink(String... value) {
        addEquals(CategoryColumns.LINK, value);
        return this;
    }

    public ArticleTagSelection articleCategoryLinkNot(String... value) {
        addNotEquals(CategoryColumns.LINK, value);
        return this;
    }

    public ArticleTagSelection articleCategoryLinkLike(String... value) {
        addLike(CategoryColumns.LINK, value);
        return this;
    }

    public ArticleTagSelection articleCategoryLinkContains(String... value) {
        addContains(CategoryColumns.LINK, value);
        return this;
    }

    public ArticleTagSelection articleCategoryLinkStartsWith(String... value) {
        addStartsWith(CategoryColumns.LINK, value);
        return this;
    }

    public ArticleTagSelection articleCategoryLinkEndsWith(String... value) {
        addEndsWith(CategoryColumns.LINK, value);
        return this;
    }

    public ArticleTagSelection articleCategoryColor(String... value) {
        addEquals(CategoryColumns.COLOR, value);
        return this;
    }

    public ArticleTagSelection articleCategoryColorNot(String... value) {
        addNotEquals(CategoryColumns.COLOR, value);
        return this;
    }

    public ArticleTagSelection articleCategoryColorLike(String... value) {
        addLike(CategoryColumns.COLOR, value);
        return this;
    }

    public ArticleTagSelection articleCategoryColorContains(String... value) {
        addContains(CategoryColumns.COLOR, value);
        return this;
    }

    public ArticleTagSelection articleCategoryColorStartsWith(String... value) {
        addStartsWith(CategoryColumns.COLOR, value);
        return this;
    }

    public ArticleTagSelection articleCategoryColorEndsWith(String... value) {
        addEndsWith(CategoryColumns.COLOR, value);
        return this;
    }

    public ArticleTagSelection articleImage(String... value) {
        addEquals(ArticleColumns.IMAGE, value);
        return this;
    }

    public ArticleTagSelection articleImageNot(String... value) {
        addNotEquals(ArticleColumns.IMAGE, value);
        return this;
    }

    public ArticleTagSelection articleImageLike(String... value) {
        addLike(ArticleColumns.IMAGE, value);
        return this;
    }

    public ArticleTagSelection articleImageContains(String... value) {
        addContains(ArticleColumns.IMAGE, value);
        return this;
    }

    public ArticleTagSelection articleImageStartsWith(String... value) {
        addStartsWith(ArticleColumns.IMAGE, value);
        return this;
    }

    public ArticleTagSelection articleImageEndsWith(String... value) {
        addEndsWith(ArticleColumns.IMAGE, value);
        return this;
    }

    public ArticleTagSelection articleLink(String... value) {
        addEquals(ArticleColumns.LINK, value);
        return this;
    }

    public ArticleTagSelection articleLinkNot(String... value) {
        addNotEquals(ArticleColumns.LINK, value);
        return this;
    }

    public ArticleTagSelection articleLinkLike(String... value) {
        addLike(ArticleColumns.LINK, value);
        return this;
    }

    public ArticleTagSelection articleLinkContains(String... value) {
        addContains(ArticleColumns.LINK, value);
        return this;
    }

    public ArticleTagSelection articleLinkStartsWith(String... value) {
        addStartsWith(ArticleColumns.LINK, value);
        return this;
    }

    public ArticleTagSelection articleLinkEndsWith(String... value) {
        addEndsWith(ArticleColumns.LINK, value);
        return this;
    }

    public ArticleTagSelection name(String... value) {
        addEquals(ArticleTagColumns.NAME, value);
        return this;
    }

    public ArticleTagSelection nameNot(String... value) {
        addNotEquals(ArticleTagColumns.NAME, value);
        return this;
    }

    public ArticleTagSelection nameLike(String... value) {
        addLike(ArticleTagColumns.NAME, value);
        return this;
    }

    public ArticleTagSelection nameContains(String... value) {
        addContains(ArticleTagColumns.NAME, value);
        return this;
    }

    public ArticleTagSelection nameStartsWith(String... value) {
        addStartsWith(ArticleTagColumns.NAME, value);
        return this;
    }

    public ArticleTagSelection nameEndsWith(String... value) {
        addEndsWith(ArticleTagColumns.NAME, value);
        return this;
    }
}
