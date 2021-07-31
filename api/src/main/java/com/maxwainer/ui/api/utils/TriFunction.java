package com.maxwainer.ui.api.utils;

import org.jetbrains.annotations.Nullable;

/**
 * Function with 3 parameters
 *
 * @param <F> Type of first function argument
 * @param <S> Type of second function argument
 * @param <T> Type of third function argument
 * @param <R> Result type
 */
@FunctionalInterface
public interface TriFunction<F, S, T, R> {

  /**
   * Use it to apply on any builder
   *
   * @param f First function argument
   * @param s Second function argument
   * @param t Third function argument
   * @return Function result
   */
  @Nullable R apply(F f, S s, T t);

}
