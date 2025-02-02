/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2022. All rights reserved.
 */

package com.huawei.recordconsole.strategy;

import org.apache.kafka.clients.consumer.ConsumerRecord;

import java.io.IOException;
import java.util.List;

/**
 * 定义该接口的目的是抽象出消息的处理逻辑，不同的消息采取不同处理方式
 *
 * @author lihongjiang
 * @since 2021-02-19
 */
@FunctionalInterface
public interface InterfaceTopicHandleStrategy {
    /**
     * 按主题处理record记录
     *
     * @param records 记录数
     */
    void handleRecordByTopic(List<ConsumerRecord<String, String>> records) throws IOException;
}
