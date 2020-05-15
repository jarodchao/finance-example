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
package org.eleven2018.finance.order.interfaces.facade;

import org.eleven2018.finance.order.application.service.OrderApplicationService;
import org.eleven2018.finance.order.domain.enetity.TransactionOrderDetail;
import org.eleven2018.finance.order.interfaces.assembler.OrderAssembler;
import org.eleven2018.finance.order.interfaces.dto.OrderDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author: <a herf="mailto:jarodchao@126.com>jarod </a>
 * @date: 2020-05-14
 */
@RestController
public class OrderController {

    private final OrderApplicationService orderApplicationService;

    public OrderController(OrderApplicationService orderApplicationService) {
        this.orderApplicationService = orderApplicationService;
    }

    @PostMapping(path = "/order")
    public Mono<String> postOrder(@RequestBody OrderDto orderDto) {

        // 转换成领域对象
        TransactionOrderDetail orderDetail = OrderAssembler.toTransactionOrderDetail(orderDto);

        return Mono.fromRunnable(() -> orderApplicationService.placeOrder(orderDetail));

    }
}
