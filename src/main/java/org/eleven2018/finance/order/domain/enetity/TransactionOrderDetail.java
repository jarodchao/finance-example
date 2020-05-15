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

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @author: <a herf="mailto:jarodchao@126.com>jarod </a>
 * @date: 2020-05-14
 */
public class TransactionOrderDetail {

    @Setter
    @Getter
    /**
     * 进件流水号
     */
    private String orderNo;

    @Setter
    @Getter
    /**
     * 进件客户信息
     */
    private OrderCustomer orderCustomer;

    @Setter
    @Getter
    /**
     * 进件客户信息
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
}