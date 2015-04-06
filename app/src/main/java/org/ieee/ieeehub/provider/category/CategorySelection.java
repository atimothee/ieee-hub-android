package org.ieee.ieeehub.provider.category;

import java.util.Date;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;

import org.ieee.ieeehub.provider.base.AbstractSelection;

/**
 * Selection for the {@code category} table.
 */
public class CategorySelection extends AbstractSelection<CategorySelection> {
    @Override
    protected Uri baseUri() {
        return CategoryColumns.CONTENT_URI;
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param contentResolver The content resolver to query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @param sortOrder How to order the rows, formatted as an SQL ORDER BY clause (excluding the ORDER BY itself). Passing null will use the default sort
     *            order, which may be unordered.
     * @return A {@code CategoryCursor} object, which is positioned before the first entry, or null.
     */
    public CategoryCursor query(ContentResolver contentResolver, String[] projection, String sortOrder) {
        Cursor cursor = contentResolver.query(uri(), projection, sel(), args(), sortOrder);
        if (cursor == null) return null;
        return new CategoryCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, projection, null)}.
     */
    public CategoryCursor query(ContentResolver contentResolver, String[] projection) {
        return query(contentResolver, projection, null);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, projection, null, null)}.
     */
    public CategoryCursor query(ContentResolver contentResolver) {
        return query(contentResolver, null, null);
    }


    public CategorySelection id(long... value) {
        addEquals("category." + CategoryColumns._ID, toObjectArray(value));
        return this;
    }

    public CategorySelection name(String... value) {
        addEquals(CategoryColumns.NAME, value);
        return this;
    }

    public CategorySelection nameNot(String... value) {
        addNotEquals(CategoryColumns.NAME, value);
        return this;
    }

    public CategorySelection nameLike(String... value) {
        addLike(CategoryColumns.NAME, value);
        return this;
    }

    public CategorySelection nameContains(String... value) {
        addContains(CategoryColumns.NAME, value);
        return this;
    }

    public CategorySelection nameStartsWith(String... value) {
        addStartsWith(CategoryColumns.NAME, value);
        return this;
    }

    public CategorySelection nameEndsWith(String... value) {
        addEndsWith(CategoryColumns.NAME, value);
        return this;
    }

    public CategorySelection link(String... value) {
        addEquals(CategoryColumns.LINK, value);
        return this;
    }

    public CategorySelection linkNot(String... value) {
        addNotEquals(CategoryColumns.LINK, value);
        return this;
    }

    public CategorySelection linkLike(String... value) {
        addLike(CategoryColumns.LINK, value);
        return this;
    }

    public CategorySelection linkContains(String... value) {
        addContains(CategoryColumns.LINK, value);
        return this;
    }

    public CategorySelection linkStartsWith(String... value) {
        addStartsWith(CategoryColumns.LINK, value);
        return this;
    }

    public CategorySelection linkEndsWith(String... value) {
        addEndsWith(CategoryColumns.LINK, value);
        return this;
    }

    public CategorySelection color(String... value) {
        addEquals(CategoryColumns.COLOR, value);
        return this;
    }

    public CategorySelection colorNot(String... value) {
        addNotEquals(CategoryColumns.COLOR, value);
        return this;
    }

    public CategorySelection colorLike(String... value) {
        addLike(CategoryColumns.COLOR, value);
        return this;
    }

    public CategorySelection colorContains(String... value) {
        addContains(CategoryColumns.COLOR, value);
        return this;
    }

    public CategorySelection colorStartsWith(String... value) {
        addStartsWith(CategoryColumns.COLOR, value);
        return this;
    }

    public CategorySelection colorEndsWith(String... value) {
        addEndsWith(CategoryColumns.COLOR, value);
        return this;
    }
}
