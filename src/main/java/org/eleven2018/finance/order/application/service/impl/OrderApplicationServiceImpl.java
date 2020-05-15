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
package org.eleven2018.finance.order.application.service.impl;

import org.eleven2018.finance.order.application.event.publish.OrderPublisher;
import org.eleven2018.finance.order.application.service.OrderApplicationService;
import org.eleven2018.finance.order.domain.enetity.TransactionOrderDetail;
import org.eleven2018.finance.order.domain.event.PlaceOrderEvent;
import org.eleven2018.finance.order.domain.service.OrderService;
import org.springframework.stereotype.Service;

/**
 * @author: <a herf="mailto:jarodchao@126.com>jarod </a>
 * @date: 2020-05-14
 */
@Service
public class OrderApplicationServiceImpl implements OrderApplicationService {

    private final OrderPublisher orderPublisher;

    private final OrderService orderService;

    public OrderApplicationServiceImpl(OrderPublisher orderPublisher, OrderService orderService) {
        this.orderPublisher = orderPublisher;
        this.orderService = orderService;
    }

    @Override
    public String placeOrder(TransactionOrderDetail orderDetail) {

        String orderNo = orderService.placeOrder(orderDetail);

        PlaceOrderEvent event = PlaceOrderEvent.of(orderNo, orderDetail.getAmount(), orderDetail.getOrderCustomer().getBankAccount());

        orderPublisher.publishPlaceOrderEvent(event);

        return orderNo;
    }
}
