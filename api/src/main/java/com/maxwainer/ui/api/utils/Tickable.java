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
