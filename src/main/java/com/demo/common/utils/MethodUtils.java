package com.demo.common.utils;

import java.lang.reflect.Method;

/**
 * Created by wang_haichun on 2016/11/15.
 */
public class MethodUtils {
    public MethodUtils() {
    }

    public static Method getDeclaredMethod(Class<?> clazz, String methodName) {
        Method[] methodList = clazz.getDeclaredMethods();
        Method method = null;
        Method[] arr$ = methodList;
        int len$ = methodList.length;

        for(int i$ = 0; i$ < len$; ++i$) {
            Method declaredMethod = arr$[i$];
            String declaredMethodName = declaredMethod.getName();
            if(declaredMethodName.equals(methodName)) {
                method = declaredMethod;
                break;
            }
        }

        return method;
    }
}
