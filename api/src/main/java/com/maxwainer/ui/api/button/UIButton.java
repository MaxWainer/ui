package com.maxwainer.ui.api.button;

import com.maxwainer.ui.api.action.button.ClickActionHolder;
import com.maxwainer.ui.api.item.WrappedItemStack;
import com.maxwainer.ui.api.utils.Removeable;
import org.jetbrains.annotations.NotNull;

public interface UIButton<T extends UIButton> extends ClickActionHolder<T>, Removeable<T> {

  T itemStack(@NotNull WrappedItemStack stack);

}
