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
package org.eleven2018.finance.order.application.event.publish.impl;

import org.eleven1028.framework.util.validate.FieldValidateExecutor;
import org.eleven2018.finance.order.application.event.publish.OrderPublisher;
import org.eleven2018.finance.order.domain.event.PlaceOrderEvent;
import org.eleven2018.finance.order.infrastructure.exception.OrderException;
import org.springframework.stereotype.Component;

/**
 * @author: <a herf="mailto:jarodchao@126.com>jarod </a>
 * @date: 2020-05-15
 */
@Component
public class OrderPublisherImpl implements OrderPublisher {

    @Override
    public void publishPlaceOrderEvent(PlaceOrderEvent event) {

        // 验证event是否合法
        FieldValidateExecutor.of(errorInfos -> new OrderException(errorInfos))
                .execute(event, event.getBankAccount());

        // 验证通过后push到消息中间件中
    }
}
