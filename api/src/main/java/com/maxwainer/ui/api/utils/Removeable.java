package com.maxwainer.ui.api.utils;

public interface Removeable<T extends Removeable> {

  T markRemoveable(final boolean remove);

  boolean isRemoveable();

}
