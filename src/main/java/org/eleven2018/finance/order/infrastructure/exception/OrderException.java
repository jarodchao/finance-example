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
package org.eleven2018.finance.order.infrastructure.exception;

import org.eleven1028.framework.ExtendedExceptionSupplier;
import org.eleven1028.framework.exception.ErrorCode;
import org.eleven1028.framework.exception.ErrorInfo;
import org.eleven1028.framework.exception.FrameworkBaseException;
import org.eleven1028.framework.util.validate.FieldValidateExceptionSupplier;

/**
 * @author: <a herf="mailto:jarodchao@126.com>jarod </a>
 * @date: 2020-05-15
 */
public class OrderException extends FrameworkBaseException {

    public static FieldValidateExceptionSupplier<OrderException> FIELD_EXCEPTION_SUPPLIER = errorInfos -> new OrderException(errorInfos);

    public static ExtendedExceptionSupplier<OrderException> EXCEPTION_SUPPLIER = errorInfo -> new OrderException(errorInfo);

    public OrderException(ErrorInfo... errorInfos) {
        super(errorInfos);
    }

    public OrderException(ErrorInfo errorInfo) {
        super(errorInfo);
    }

    public OrderException(ErrorCode errorCode, Object... fields) {
        super(errorCode, fields);
    }
}
