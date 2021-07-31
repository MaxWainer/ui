package com.maxwainer.ui.api.action.button.impl.actions;

import com.maxwainer.ui.api.action.button.impl.AbstractClickAction;
import com.maxwainer.ui.api.action.button.params.Cancellable;

public class ClickAction extends AbstractClickAction implements Cancellable {

  @Override
  public boolean isCancelled() {
    return false;
  }

  @Override
  public void cancel() {

  }
}
