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
package org.eleven2018.finance.order.domain.service.impl;

import org.eleven1028.framework.exception.ErrorInfo;
import org.eleven1028.framework.util.validate.ExceptionTigger;
import org.eleven1028.framework.util.validate.FieldValidateExecutor;
import org.eleven1028.framework.util.validate.FieldValidateUtils;
import org.eleven2018.finance.order.domain.enetity.TransactionOrderDetail;
import org.eleven2018.finance.order.domain.service.OrderService;
import org.eleven2018.finance.order.infrastructure.exception.OrderException;
import org.eleven2018.finance.order.infrastructure.service.OrderSerialNumberService;
import org.springframework.stereotype.Component;

import static org.eleven2018.finance.order.infrastructure.exception.OrderErrorCodes.CALL_ORDER_SERIAL_NUMBER_SERVICE_FAILURE;
import static org.eleven2018.finance.order.infrastructure.exception.OrderErrorCodes.CALL_ORDER_SERIAL_NUMBER_SERVICE_IS_NULL;
import static org.eleven2018.finance.order.infrastructure.exception.OrderException.*;

/**
 * @author: <a herf="mailto:jarodchao@126.com>jarod </a>
 * @date: 2020-05-14
 */
@Component
public class OrderServiceImpl implements OrderService {


    private final OrderSerialNumberService serialNumberService;

    public OrderServiceImpl(OrderSerialNumberService serialNumberService) {
        this.serialNumberService = serialNumberService;
    }

    private ExceptionTigger<OrderException> exceptionTigger = ExceptionTigger.of(errorInfo -> new OrderException());

    @Override
    public String placeOrder(TransactionOrderDetail transactionOrderDetail) {

        // 验证交易订单
        FieldValidateExecutor.of(FIELD_EXCEPTION_SUPPLIER).execute(transactionOrderDetail);

        // 取客户号

        // 生成订单流水号
        String orderSerailNo = null;
        try {
            orderSerailNo = serialNumberService.generate();
        } catch (Exception e) {
            exceptionTigger.tigger(CALL_ORDER_SERIAL_NUMBER_SERVICE_FAILURE);

        }

        exceptionTigger.tigger(ErrorInfo.of(CALL_ORDER_SERIAL_NUMBER_SERVICE_IS_NULL), FieldValidateUtils.OBJECT_IS_EMPTY, orderSerailNo);

        // 保存订单

        return orderSerailNo;

    }
}
