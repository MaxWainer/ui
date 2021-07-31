package com.maxwainer.ui.api.utils;

import java.util.function.Function;
import org.jetbrains.annotations.NotNull;

/**
 * Better user for {@link com.maxwainer.ui.api.abstraction.UI}, best solution for title
 *
 * @param <T> Made for chaining
 */
public interface Customizable<T extends Customizable> {

  /**
   * @param name String name
   * @return Itself, for chaining
   */
  T named(final @NotNull String name);

  /**
   * Replace current name
   *
   * @param function Replace function
   * @param saveOld  Save first time initialized field
   * @return Itself, for chaining
   */
  T nameReplacer(final @NotNull Function<String, String> function, final boolean saveOld);

  /**
   * Replace current name, old will be saved
   *
   * @param function Replace function
   * @return Itself, for chaining
   */
  default T nameReplace(final @NotNull Function<String, String> function) {
    return nameReplacer(function, true);
  }

  /**
   * Get current name
   *
   * @return Current name
   */
  @NotNull String getName();

}
