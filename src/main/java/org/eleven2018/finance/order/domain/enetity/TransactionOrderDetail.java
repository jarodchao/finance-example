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
import org.eleven1028.framework.exception.ErrorCode;
import org.eleven1028.framework.exception.ErrorInfo;
import org.eleven1028.framework.exception.ExceptionChecker;
import org.eleven1028.framework.util.validate.FieldValidateUtils;
import org.eleven1028.framework.util.validate.FieldValidator;
import org.eleven2018.finance.order.domain.vo.OrderCustomer;
import org.eleven2018.finance.order.domain.vo.Term;
import org.eleven2018.finance.order.infrastructure.exception.OrderErrorCodes;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.eleven1028.framework.exception.ExceptionChecker.*;
import static org.eleven1028.framework.util.validate.FieldValidateUtils.*;
import static org.eleven2018.finance.order.infrastructure.exception.OrderErrorCodes.*;
import static org.eleven2018.finance.order.infrastructure.exception.OrderErrorCodes.AMOUNT_IS_ZERO;

/**
 * @author: <a herf="mailto:jarodchao@126.com>jarod </a>
 * @date: 2020-05-14
 */
public class TransactionOrderDetail implements FieldValidator {

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
    public ErrorInfo[] validate() {

        return new ErrorInfo[]{
                check(ORDER_SERIAL_NUMBER_IS_NULL, OBJECT_IS_EMPTY, orderSerialNo),
                check(ORDER_SERIAL_NUMBER_LENGTH_ERROR, STRING_LENGTH_IS_MATCH, orderSerialNo, 32),
                check(AMOUNT_IS_ZERO, DECIMAL_EQUALS_ZERO, amount),
                check(AMOUNT_IS_ZERO, DECIMAL_LESS_ZERO, amount),
                check(ORDER_PRODUCT_NUMBER_IS_NULL, OBJECT_IS_EMPTY, productNo),
                check(ORDER_PRODUCT_NUMBER_LENGTH_ERROR, STRING_LENGTH_IS_MATCH, orderSerialNo, 6),

        };
    }
}
