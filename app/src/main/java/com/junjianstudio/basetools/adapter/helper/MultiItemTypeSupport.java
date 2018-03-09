package com.junjianstudio.basetools.adapter.helper;

/**
 * Created by Administrator on 2017/9/12.
 */

public interface MultiItemTypeSupport<T> {
    int getLayoutId(int itemType);

    int getItemViewType(int position, T t);
}
