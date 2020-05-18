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

import org.eleven1028.framework.exception.ErrorCode;

/**
 * @author: <a herf="matilto:jarodchao@126.com>jarod </a>
 * @date: 2020-05-15
 */
public enum OrderErrorCodes implements ErrorCode {

    /** 合法性检查 */
    /** 订单信息 */
    AMOUNT_IS_ZERO("0101000001","订单金额等于0."),
    AMOUNT_LESS_ZERO("0101000002","订单金额小于0."),

    ORDER_NUMBER_IS_NULL("0101000003","订单号为空."),
    ORDER_NUMBER_LENGTH_ERROR("0101000004","订单号长度错误，正确长度为{}."),

    ORDER_SERIAL_NUMBER_IS_NULL("0101000005","订单流水号为空."),
    ORDER_SERIAL_NUMBER_LENGTH_ERROR("0101000006","订单流水号长度错误，正确长度为{}."),

    ORDER_PRODUCT_NUMBER_IS_NULL("0101000007","借款产品号为空."),
    ORDER_PRODUCT_NUMBER_LENGTH_ERROR("0101000008","借款产品号长度错误，正确长度为{}."),

    /** 银行账户信息 */
    BANK_NUMBER_IS_NULL("0102000001","银行编码为空."),
    BANK_NUMBER_LENGTH_ERROR("0102000002","银行编码长度错误，正确长度为{}."),
    BANK_BRANCH_NUMBER_IS_NULL("0102000003","银行编码为空."),
    BANK_BRANCH_NUMBER_LENGTH_ERROR("0102000004","银行编码长度错误，正确长度为{}."),
    BANK_ACCOUNT_NUMBER_IS_NULL("0102000005","银行编码为空."),
    BANK_ACCOUNT_NUMBER_LENGTH_ERROR("0102000006","银行编码长度错误，正确长度为{}."),
    BANK_ACCOUNT_NAME_IS_NULL("0102000007","银行编码长度错误，正确长度为{}."),
    /** 合法性检查 */

    /** 调用方法失败 */
    CALL_ORDER_SERIAL_NUMBER_SERVICE_FAILURE("0201000001","调用生成订单流水号基础服务失败!"),
    CALL_ORDER_SERIAL_NUMBER_SERVICE_IS_NULL("0201000002","调用生成订单流水号基础服务结果为空!"),

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
