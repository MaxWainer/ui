package com.maxwainer.ui.api.action.window.impl;

import com.maxwainer.ui.api.action.window.WindowAction;

public class AbstractWindowAction implements WindowAction<AbstractWindowAction> {

  @Override
  public AbstractWindowAction queued(boolean queue) {
    return null;
  }

  @Override
  public void markPassed() {

  }

  @Override
  public boolean isQueueable() {
    return false;
  }

  @Override
  public boolean passedQueue() {
    return false;
  }

  @Override
  public AbstractWindowAction markRemoveable(boolean remove) {
    return null;
  }

  @Override
  public boolean isRemoveable() {
    return false;
  }
}
