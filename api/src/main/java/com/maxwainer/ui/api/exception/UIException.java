package com.maxwainer.ui.api.exception;

import com.maxwainer.ui.api.abstraction.UI;
import com.maxwainer.ui.api.user.UIUser;
import org.jetbrains.annotations.Nullable;

public interface UIException {

  @Nullable UI<?> thrownUI();

  @Nullable UIUser<?> thrownUser();

}
