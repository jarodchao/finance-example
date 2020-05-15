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
package org.eleven2018.finance.order.domain.enetity;

import lombok.Getter;
import lombok.Setter;
import org.eleven2018.finance.order.domain.vo.OrderCustomer;
import org.eleven2018.finance.order.domain.vo.Term;
import org.eleven2018.finance.order.infrastructure.exception.FinanceBizException;
import org.eleven2018.finance.order.infrastructure.exception.OrderErrorCodes;
import org.eleven2018.finance.order.infrastructure.util.validate.DomainValidator;
import org.eleven2018.finance.order.infrastructure.util.validate.FieldValidateUtils;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.eleven2018.finance.order.infrastructure.exception.ExceptionTigger.tigger;
import static org.eleven2018.finance.order.infrastructure.exception.OrderErrorCodes.*;
import static org.eleven2018.finance.order.infrastructure.exception.OrderErrorCodes.AMOUNT_IS_ZERO;

/**
 * @author: <a herf="mailto:jarodchao@126.com>jarod </a>
 * @date: 2020-05-14
 */
public class TransactionOrderDetail implements DomainValidator {

    @Setter
    @Getter
    /**
     * 进件流水号
     */
    private String orderSerialNo;

    @Setter
    @Getter
    /**
     * 进件客户信息
     */
    private OrderCustomer orderCustomer;

    @Setter
    @Getter
    /**
     * 进件日期
     */
    private LocalDate transactionDate;

    @Setter
    @Getter
    /**
     * 进件产品号
     */
    private String productNo;

    @Setter
    @Getter
    /**
     * 借款金额
     */
    private BigDecimal amount;

    @Setter
    @Getter
    /**
     * 借款周期
     */
    private Term term;

    @Override
    public void validate() throws FinanceBizException {

        tigger(OrderErrorCodes.ORDER_SERIAL_NUMBER_IS_NULL, FieldValidateUtils.OBJECT_IS_EMPTY, orderSerialNo);
        tigger(OrderErrorCodes.ORDER_SERIAL_NUMBER_LENGTH_ERROR, FieldValidateUtils.STRING_LENGTH_IS_MATCH, orderSerialNo,32);
        tigger(AMOUNT_IS_ZERO, FieldValidateUtils.DECIMAL_EQUALS_ZERO, amount);
        tigger(AMOUNT_IS_ZERO, FieldValidateUtils.DECIMAL_LESS_ZERO, amount);
        tigger(OrderErrorCodes.ORDER_PRODUCT_NUMBER_IS_NULL, FieldValidateUtils.OBJECT_IS_EMPTY, productNo);
        tigger(OrderErrorCodes.ORDER_PRODUCT_NUMBER_LENGTH_ERROR, FieldValidateUtils.STRING_LENGTH_IS_MATCH, orderSerialNo,6);
    }
}
