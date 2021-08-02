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

package com.maxwainer.ui.api.action.window.impl.actions;

import com.maxwainer.ui.api.action.window.impl.AbstractWindowAction;
import com.maxwainer.ui.api.utils.Tickable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import org.jetbrains.annotations.Nullable;

public class RefreshAction extends AbstractWindowAction implements Tickable {

  private final AtomicBoolean passed = new AtomicBoolean(false);
  private final AtomicBoolean stopped = new AtomicBoolean(true);

  private final AtomicLong tickCounter = new AtomicLong(0);
  private volatile long mustPass;

  public RefreshAction(long mustPass) {
    this.mustPass = mustPass;
  }

  @Override
  public void doTick() {

    tickCounter.decrementAndGet();
  }

  @Override
  public long currentTick() {
    return tickCounter.get();
  }

  @Override
  public long tickBeforeEnd() {
    return mustPass - tickCounter.get();
  }

  @Override
  public boolean isStopped() {
    return stopped.get();
  }

  @Override
  public void stop(@Nullable Runnable post, boolean async) {

    stopped.set(true);
  }

  @Override
  public void restart(@Nullable Runnable post, boolean async) {
    stopped.set(true);


    stopped.set(false);
  }

  @Override
  public void start(@Nullable Runnable post, boolean async) {
    stopped.set(false);
  }

  @Override
  public void markPassed() {
    passed.set(true);
  }
}
