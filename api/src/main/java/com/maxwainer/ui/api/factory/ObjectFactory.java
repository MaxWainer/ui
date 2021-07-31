package com.maxwainer.ui.api.factory;

import org.jetbrains.annotations.NotNull;

public interface ObjectFactory<T> {

  @NotNull T createObject();

}
