package com.maxwainer.ui.api.action;

import com.maxwainer.ui.api.factory.ObjectFactory;
import org.jetbrains.annotations.NotNull;

public interface ActionFactory<T extends Action> extends ObjectFactory<T> {

  T createAction();

  @Override
  default @NotNull T createObject() {
    return createAction();
  }
}
