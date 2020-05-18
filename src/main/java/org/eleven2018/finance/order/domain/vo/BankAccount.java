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
import org.eleven1028.framework.exception.ErrorCode;
import org.eleven1028.framework.exception.ErrorInfo;
import org.eleven1028.framework.util.validate.FieldValidator;

import static org.eleven1028.framework.exception.ExceptionChecker.check;
import static org.eleven1028.framework.util.validate.FieldValidateUtils.OBJECT_IS_EMPTY;
import static org.eleven1028.framework.util.validate.FieldValidateUtils.STRING_LENGTH_IS_MATCH;
import static org.eleven2018.finance.order.infrastructure.exception.OrderErrorCodes.*;


/**
 * @author: <a herf="mailto:jarodchao@126.com>jarod </a>
 * @date: 2020-05-14
 */
public class BankAccount implements FieldValidator {

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


    @Override
    public ErrorInfo[] validate() {
        return new ErrorInfo[]{
            check(BANK_NUMBER_IS_NULL, OBJECT_IS_EMPTY, bankNo),
            check(BANK_ACCOUNT_NAME_IS_NULL, STRING_LENGTH_IS_MATCH, bankNo, 6),
            check(BANK_BRANCH_NUMBER_IS_NULL, OBJECT_IS_EMPTY, branchNo),
            check(BANK_BRANCH_NUMBER_LENGTH_ERROR, STRING_LENGTH_IS_MATCH, branchNo, 6),
            check(BANK_ACCOUNT_NAME_IS_NULL, OBJECT_IS_EMPTY, accountName),
            check(BANK_ACCOUNT_NUMBER_IS_NULL, OBJECT_IS_EMPTY, accountNo),
            check(BANK_BRANCH_NUMBER_LENGTH_ERROR, STRING_LENGTH_IS_MATCH, accountNo, 16, 19),
        };

    }
}
