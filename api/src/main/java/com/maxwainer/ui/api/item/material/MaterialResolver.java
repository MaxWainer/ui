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

package com.maxwainer.ui.api.item.material;

import com.maxwainer.ui.api.exception.MaterialOutOfBoundException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Helps to resolve materials by internal id system
 *
 * @param <T> Enum which hold every material
 */
public interface MaterialResolver<T extends Enum<T>> {

  /**
   * Get material by internal id system
   *
   * @param value Value which is in version range
   * @return Resolved material value
   * @throws MaterialOutOfBoundException If entered value out of allowed range (Version-related
   *                                     thing)
   */
  @Nullable T resolveByValue(final short value) throws MaterialOutOfBoundException;

  /**
   * Get material by internal id system
   *
   * @param value Value which is in version range
   * @return Resolved material value
   */
  default @NotNull T resolveMaterial(final short value) {
    final T nullMaterial = getNullMaterial();
    try {
      final T outValue = resolveByValue(value);

      return outValue == null ? nullMaterial : outValue;
    } catch (MaterialOutOfBoundException ignored) {
    }
    return nullMaterial;
  }

  /**
   * Get material which is exists on every supported version
   *
   * @return Null material, such as STONE
   */
  @NotNull T getNullMaterial();

}
