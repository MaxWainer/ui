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
