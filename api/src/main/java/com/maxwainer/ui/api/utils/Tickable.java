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

import org.jetbrains.annotations.Nullable;

// TODO: Add later here animated button

/**
 * Useful interface for creating animations or refresh actions
 *
 * @see com.maxwainer.ui.api.abstraction.UI
 */
public interface Tickable {

  /**
   * Will do tick
   */
  void doTick();

  /**
   * Get current tick
   *
   * @return Current tick
   */
  long currentTick();

  /**
   * Will return how many ticks before end
   *
   * @return How many ticks we must pass before end
   */
  long tickBeforeEnd();

  /**
   * Check is timer stopped right now
   *
   * @return Is timer current stopped
   */
  boolean isStopped();

  /**
   * Stop current timer (With saving object and current tick)
   *
   * @param post  Run before stop action is passed
   * @param async Run it async or no
   */
  void stop(final @Nullable Runnable post, final boolean async);

  /**
   * Restart current timer (currentTick will be erased)
   *
   * @param post  Run before restart action is passed
   * @param async Run it async or no
   */
  void restart(final @Nullable Runnable post, final boolean async);

  /**
   * Start current timer (If it was stopped, previous tick value will be used)
   *
   * @param post  Run before start action is passed
   * @param async Run it async or no
   */
  void start(final @Nullable Runnable post, final boolean async);

  /**
   * Stop current timer async (With saving object and current tick)
   *
   * @param post Run before stop action is passed
   */
  default void stopAsync(final @Nullable Runnable post) {
    stop(post, true);
  }

  /**
   * Restart current timer async (currentTick will be erased)
   *
   * @param post Run before stop action is passed
   */
  default void restartAsync(final @Nullable Runnable post) {
    restart(post, true);
  }

  /**
   * Start current timer async (If it was stopped, previous tick value will be used)
   *
   * @param post Run before stop action is passed
   */
  default void startAsync(final @Nullable Runnable post) {
    start(post, true);
  }

  /**
   * Stop current timer async (With saving object and current tick)
   */
  default void stopAsync() {
    stopAsync(null);
  }

  /**
   * Restart current timer async (currentTick will be erased)
   */
  default void restartAsync() {
    restartAsync(null);
  }

  /**
   * Start current timer async (If it was stopped, previous tick value will be used)
   */
  default void startAsync() {
    startAsync(null);
  }

}
