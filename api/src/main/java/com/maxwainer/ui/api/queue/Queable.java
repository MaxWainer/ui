package com.maxwainer.ui.api.queue;

/**
 * Interface which indicates that object can be queued
 *
 * @param <T> Class which implements/extends {@link Queable} interface for chaining
 */
public interface Queable<T extends Queable> {

  /**
   * Help with marking object as queable or no
   *
   * @param queue Mark object as queable
   * @return Itself, for chaining
   */
  T queued(final boolean queue);

  /**
   * Mark object as queue passer
   */
  void markPassed();

  /**
   * Mark object as queable
   *
   * @return Itself, for chaining
   */
  default T queued() {
    return queued(true);
  }

  /**
   * Check is object queable
   *
   * @return Is object queable
   */
  boolean isQueueable();

  /**
   * Check is object passed queue
   *
   * @return Is object passed queue
   */
  boolean passedQueue();

}
