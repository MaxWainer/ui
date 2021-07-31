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
