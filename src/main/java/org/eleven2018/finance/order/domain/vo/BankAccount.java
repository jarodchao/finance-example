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
package org.eleven2018.finance.order.domain.vo;

import lombok.Getter;
import lombok.Setter;

/**
 * @author: <a herf="mailto:jarodchao@126.com>jarod </a>
 * @date: 2020-05-14
 */
public class BankAccount {

    @Setter
    @Getter
    /**
     * 借款人开户银行号
     */
    private String bankNo;

    @Setter
    @Getter
    /**
     * 银行账号
     */
    private String accountNo;

    @Setter
    @Getter
    /**
     * 开户支行号
     */
    private String branchNo;

    @Setter
    @Getter
    /**
     * 开户名
     */
    private String accountName;
}
