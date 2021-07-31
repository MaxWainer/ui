package com.maxwainer.ui.api.button.impl.types.animated;

import com.maxwainer.ui.api.button.impl.AbstractUIButton;
import com.maxwainer.ui.api.utils.Tickable;
import org.jetbrains.annotations.Nullable;

public class AnimatedUIButton extends AbstractUIButton implements Tickable {

  @Override
  public void doTick() {

  }

  @Override
  public long currentTick() {
    return 0;
  }

  @Override
  public long tickBeforeEnd() {
    return 0;
  }

  @Override
  public boolean isStopped() {
    return false;
  }

  @Override
  public void stop(@Nullable Runnable post, boolean async) {

  }

  @Override
  public void restart(@Nullable Runnable post, boolean async) {

  }

  @Override
  public void start(@Nullable Runnable post, boolean async) {

  }
}
