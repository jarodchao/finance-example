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
package org.eleven2018.finance.order.domain.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.eleven1028.framework.exception.ErrorCode;
import org.eleven1028.framework.exception.ErrorInfo;
import org.eleven1028.framework.exception.ExceptionChecker;
import org.eleven1028.framework.util.validate.FieldValidateUtils;
import org.eleven1028.framework.util.validate.FieldValidator;
import org.eleven2018.finance.order.domain.vo.BankAccount;

import java.math.BigDecimal;

import static org.eleven1028.framework.exception.ExceptionChecker.*;
import static org.eleven1028.framework.util.validate.FieldValidateUtils.*;
import static org.eleven2018.finance.order.infrastructure.exception.OrderErrorCodes.*;

/**
 * @author: <a herf="mailto:jarodchao@126.com>jarod </a>
 * @date: 2020-05-14
 */
@AllArgsConstructor
public class PlaceOrderEvent implements FieldValidator {

    @Setter
    @Getter
    private String orderNo;

    @Setter
    @Getter
    private BigDecimal amount;

    @Setter
    @Getter
    private BankAccount bankAccount;

    @Override
    public ErrorInfo[] validate() {

        return new ErrorInfo[]{
                check(ORDER_NUMBER_IS_NULL, OBJECT_IS_EMPTY, orderNo),
                check(ORDER_NUMBER_LENGTH_ERROR, STRING_LENGTH_IS_MATCH, orderNo, 16, 19),
                check(AMOUNT_IS_ZERO, DECIMAL_EQUALS_ZERO, amount),
                check(AMOUNT_IS_ZERO, DECIMAL_LESS_ZERO, amount),

        };
    }

    public static PlaceOrderEvent of(String orderNo, BigDecimal amount, BankAccount bankAccount) {

        return new PlaceOrderEvent(orderNo, amount, bankAccount);
    }
}
