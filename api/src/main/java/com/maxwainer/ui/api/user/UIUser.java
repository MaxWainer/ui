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

package com.maxwainer.ui.api.user;

import com.maxwainer.ui.api.abstraction.UI;
import com.maxwainer.ui.api.exception.UIAlreadyOpenException;
import com.maxwainer.ui.api.exception.UINotFoundException;
import java.util.Optional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Simple object which allow you to manipulate current UI and user itself
 */
public interface UIUser<T> {

  /**
   * Get user base provider
   *
   * @return User base provider
   */
  T baseProvider();

  /**
   * Get user current UI
   *
   * @return User current UI
   */
  @Nullable UI<?> getOpenUI();

  /**
   * Send to user message
   *
   * @param message Message which will be sent to user
   */
  void sendMessage(@NotNull String message);

  /**
   * Open for user new UI
   *
   * @param ui        UI which must be opened
   * @param post      Runs after open action is called
   * @param async     Run action async or no
   * @param overwrite Do we need to overwrite current UI (Close action will be called basing on
   *                  async parameter!)
   * @throws UIAlreadyOpenException Will be called if current UI not null and overwrite parameter is
   *                                false
   */
  void openUI(final @NotNull UI<?> ui, final @Nullable Runnable post, final boolean async,
      final boolean overwrite)
      throws UIAlreadyOpenException;

  /**
   * Open for user new UI, old will be overwritten
   *
   * @param ui    UI which must be opened
   * @param post  Runs after open action is called
   * @param async Run action async or no
   */
  default void openUISilent(final @NotNull UI<?> ui, final @Nullable Runnable post,
      final boolean async) {
    try {
      openUI(ui, post, async, true);
    } catch (UIAlreadyOpenException ignored) {
      sendMessage(
          "&cError while trying to open new UI for you, looks like old is not closed or error while overwriting it!");
    }
  }

  /**
   * Open for user new UI async
   *
   * @param ui        UI which must be opened
   * @param post      Runs after open action is called
   * @param overwrite Do we need to overwrite current UI (Close action will be called async)
   * @throws UIAlreadyOpenException Will be called if current UI not null and overwrite parameter is
   *                                false
   */
  default void openUIAsync(final @NotNull UI<?> ui, final @Nullable Runnable post,
      final boolean overwrite)
      throws UIAlreadyOpenException {
    openUI(ui, post, true, overwrite);
  }

  /**
   * Open for user new UI syncing
   *
   * @param ui        UI which must be opened
   * @param post      Runs after open action is called
   * @param overwrite Do we need to overwrite current UI (Close action will be called syncing)
   * @throws UIAlreadyOpenException Will be called if current UI not null and overwrite parameter is
   *                                false
   */
  default void openUISyncing(final @NotNull UI<?> ui, final @Nullable Runnable post,
      final boolean overwrite)
      throws UIAlreadyOpenException {
    openUI(ui, post, true, overwrite);
  }

  /**
   * Open for user new UI async
   *
   * @param ui        UI which must be opened
   * @param overwrite Do we need to overwrite current UI (Close action will be called async)
   * @throws UIAlreadyOpenException Will be called if current UI not null and overwrite parameter is
   *                                false
   */
  default void openUIAsync(final @NotNull UI<?> ui, final boolean overwrite)
      throws UIAlreadyOpenException {
    openUIAsync(ui, null, overwrite);
  }

  /**
   * Open for user new UI syncing
   *
   * @param ui        UI which must be opened
   * @param overwrite Do we need to overwrite current UI (Close action will be called syncing)
   * @throws UIAlreadyOpenException Will be called if current UI not null and overwrite parameter is
   *                                false
   */
  default void openUISyncing(final @NotNull UI<?> ui, final boolean overwrite)
      throws UIAlreadyOpenException {
    openUISyncing(ui, null, overwrite);
  }

  /**
   * Close user current UI
   *
   * @param post  Runs after close action is called
   * @param async Run action async or no
   * @throws UINotFoundException If user current UI is null, exception will be thrown
   */
  void closeCurrentUI(final @Nullable Runnable post, final boolean async)
      throws UINotFoundException;

  /**
   * Close user current UI async
   *
   * @param post Runs after close action is called
   * @throws UINotFoundException If user current UI is null, exception will be thrown
   */
  default void closeCurrentUIAsync(final @Nullable Runnable post) throws UINotFoundException {
    closeCurrentUI(post, true);
  }

  /**
   * Close user current UI syncing
   *
   * @param post Runs after close action is called
   * @throws UINotFoundException If user current UI is null, exception will be thrown
   */
  default void closeCurrentUISyncing(final @Nullable Runnable post) throws UINotFoundException {
    closeCurrentUI(post, false);
  }

  /**
   * Close user current UI async
   *
   * @throws UINotFoundException If user current UI is null, exception will be thrown
   */
  default void closeCurrentUIAsync() throws UINotFoundException {
    closeCurrentUIAsync(null);
  }

  /**
   * Close user current UI syncing
   *
   * @throws UINotFoundException If user current UI is null, exception will be thrown
   */
  default void closeCurrentUISyncing() throws UINotFoundException {
    closeCurrentUISyncing(null);
  }

  /**
   * Get user current UI as optional value
   *
   * @return User current UI, but as optional
   */
  @NotNull
  default Optional<UI<?>> getOpenUIAsOptional() {
    return Optional.ofNullable(getOpenUI());
  }

}
