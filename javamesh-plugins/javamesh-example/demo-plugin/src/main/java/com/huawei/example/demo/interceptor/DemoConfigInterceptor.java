/*
 * Copyright (C) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.example.demo.interceptor;

import java.lang.reflect.Method;

import com.huawei.javamesh.core.agent.common.BeforeResult;
import com.huawei.javamesh.core.agent.interceptor.StaticMethodInterceptor;
import com.huawei.javamesh.core.plugin.config.PluginConfigManager;
import com.huawei.example.demo.common.DemoLogger;
import com.huawei.example.demo.config.DemoConfig;

/**
 * 统一配置功能的拦截器示例，在本示例中，将展示如何在插件端获取统一配置
 *
 * @author HapThorin
 * @version 1.0.0
 * @since 2021/10/25
 */
public class DemoConfigInterceptor implements StaticMethodInterceptor {
    private DemoConfig config;

    @Override
    public void before(Class<?> clazz, Method method, Object[] arguments, BeforeResult beforeResult) throws Exception {
        DemoLogger.println(clazz.getSimpleName() + ": [DemoConfigInterceptor]-before");
        config = PluginConfigManager.getPluginConfig(DemoConfig.class);
    }

    @Override
    public Object after(Class<?> clazz, Method method, Object[] arguments, Object result) throws Exception {
        DemoLogger.println(clazz.getSimpleName() + ": " + config);
        DemoLogger.println(clazz.getSimpleName() + ": [DemoConfigInterceptor]-after");
        return result;
    }

    @Override
    public void onThrow(Class<?> clazz, Method method, Object[] arguments, Throwable t) {
        DemoLogger.println(clazz.getSimpleName() + ": [DemoConfigInterceptor]-onThrow");
    }
}