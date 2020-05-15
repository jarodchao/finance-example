/*
 * Copyright 2019 The  Project
 *
 * The   Project licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package org.eleven2018.finance.order.infrastructure.exception;

/**
 * @author: <a herf="matilto:jarodchao@126.com>jarod </a>
 * @date: 2020-05-15
 */
public enum OrderErrorCodes implements BizErrorCode {

    AMOUNT_IS_ZERO("000001","金额等于0."),
    AMOUNT_LESS_ZERO("000002","金额小于0."),
    ORDER_NUMBER_IS_NULL("000003","订单号为空.")
    ;

    private String code;

    private String desc;

    OrderErrorCodes(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getDesc() {
        return desc;
    }
}
