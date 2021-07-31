package com.maxwainer.ui.api.action.window;

import com.maxwainer.ui.api.action.ActionHolder;
import com.maxwainer.ui.api.utils.Tickable;

public interface WindowActionHolder<T extends WindowActionHolder> extends ActionHolder<WindowAction<?>, T>,
    Tickable {

}
