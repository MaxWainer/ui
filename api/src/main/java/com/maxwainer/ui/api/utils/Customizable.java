/*
 * BSD 3-Clause License
 *
 * Copyright (c) 2021, Ilya
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * 3. Neither the name of the copyright holder nor the names of its
 *    contributors may be used to endorse or promote products derived from
 *    this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

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
