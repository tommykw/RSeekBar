package com.github.tommykw.fabflex.lib;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Internal FAB action type
 */
@IntDef({
        FabActionType.HORIZONTAL,
        FabActionType.VERTICAL,
        FabActionType.HORIZONTAL_AND_VERTICAL,
        FabActionType.CIRCLE,
        FabActionType.DOUBLE_CIRCLE
})
@Retention(RetentionPolicy.SOURCE) @interface FabSourceAnnotation {}