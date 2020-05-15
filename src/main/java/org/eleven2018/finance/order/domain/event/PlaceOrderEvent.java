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
import org.eleven2018.finance.order.domain.vo.BankAccount;
import org.eleven2018.finance.order.infrastructure.util.validate.FieldValidateUtils;
import org.eleven2018.finance.order.infrastructure.util.validate.ValidateExecutor;
import org.eleven2018.finance.order.infrastructure.util.validate.DomainValidator;
import org.eleven2018.finance.order.infrastructure.exception.FinanceBizException;

import java.math.BigDecimal;

import static org.eleven2018.finance.order.infrastructure.exception.ExceptionTigger.tigger;
import static org.eleven2018.finance.order.infrastructure.exception.OrderErrorCodes.*;

/**
 * @author: <a herf="mailto:jarodchao@126.com>jarod </a>
 * @date: 2020-05-14
 */
@AllArgsConstructor
public class PlaceOrderEvent implements DomainValidator {

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
    public void validate() throws FinanceBizException {

        tigger(ORDER_NUMBER_IS_NULL, FieldValidateUtils.OBJECT_IS_EMPTY, orderNo);
        tigger(ORDER_NUMBER_LENGTH_ERROR, FieldValidateUtils.STRING_LENGTH_IS_MATCH, orderNo,16, 19);
        tigger(AMOUNT_IS_ZERO, FieldValidateUtils.DECIMAL_EQUALS_ZERO, amount);
        tigger(AMOUNT_IS_ZERO, FieldValidateUtils.DECIMAL_LESS_ZERO, amount);

    }

    public static PlaceOrderEvent of(String orderNo, BigDecimal amount, BankAccount bankAccount) {

        PlaceOrderEvent event = new PlaceOrderEvent(orderNo, amount, bankAccount);

        ValidateExecutor.execute(event, bankAccount);

        return event;
    }
}
