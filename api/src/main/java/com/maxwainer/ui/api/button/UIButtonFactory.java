package com.maxwainer.ui.api.button;

import com.maxwainer.ui.api.factory.ObjectFactory;
import org.jetbrains.annotations.NotNull;

public interface UIButtonFactory<T extends UIButton> extends ObjectFactory<T> {

  @NotNull
  T createButton();

  @Override
  default @NotNull T createObject() {
    return createButton();
  }
}
