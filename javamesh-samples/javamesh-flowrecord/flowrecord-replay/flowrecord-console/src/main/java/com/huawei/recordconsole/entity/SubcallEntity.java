/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2022. All rights reserved.
 */

package com.huawei.recordconsole.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * Subcall Entity
 *
 * @author lihongjiang
 * @version 0.1
 * @since 2021-02-19
 *
 */

@Getter
@Setter
public class SubcallEntity implements Serializable {
    private String jobId;
    private String traceId;
    private String appType;
    private String methodName;
    private String subCallKey;
    private int subCallCount;
    private String requestBody;
    private String requestClass;
    private String responseBody;
    private String responseClass;
    private Date timestamp;
}
