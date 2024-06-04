/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */

package com.javatunes.catalog;

import java.util.Collection;

public interface Catalog {

    /**
     * This is a part of the "contract"- a spec that classes that implement Catalog interface HAVE to have
     * Returns the item with the given id, or null if not found.
     */
    public MusicItem findById(Long id);

    /**
     * another SPEC that implementing classes must have
     * Returns a collection of items that match the supplied keyword.
     * This is basically a search method.
     * <p>
     * A match is defined as any item whose title or artist contains the keyword.
     * Searches are to be case in-sensitive.
     * <p>
     * A no-matches result should return an empty collection (not null).
     */
    public Collection<MusicItem> findByKeyword(String keyword);

    /**
     * another SPEC that implementing classes must have
     * Returns a collection of items that are of the supplied genre (category).
     */
    public Collection<MusicItem> findByCategory(MusicCategory category);

    /**
     * another SPEC that implementing classes must have
     * Size of the catalog.
     */
    public int size();

    /**
     * another SPEC that implementing classes must have
     * Read-only view of the entire catalog.
     * See java.util.Collections class (an all-static utility class) for help here.
     */
    public Collection<MusicItem> getAll();
}