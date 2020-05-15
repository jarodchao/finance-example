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
package org.eleven2018.finance.order.infrastructure.util.validate;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.Objects;
import java.util.function.Predicate;

/**
 * @author: <a herf="mailto:jarodchao@126.com>jarod </a>
 * @date: 2020-05-15
 */
public class FieldValidateUtils {


    public static Predicate<Object> OBJECT_IS_EMPTY = o -> Objects.isNull(o);

    public static Comparator<Object> OBJECT_EQUALS = (o1, o2) -> o1.equals(o2) ? 0 : -1;

    public static Predicate<BigDecimal> DECIMAL_EQUALS_ZERO = bigDecimal -> bigDecimal.equals(BigDecimal.ZERO);

    public static Predicate<BigDecimal> DECIMAL_LESS_ZERO =
                            bigDecimal -> bigDecimal.compareTo(BigDecimal.ZERO) == -1 ? true : false;

    public static Predicate<BigDecimal> DECIMAL_MORE_ZERO =
                            bigDecimal -> bigDecimal.compareTo(BigDecimal.ZERO) == 1 ? true : false;

    public static Comparator<BigDecimal> DECIMAL_LESS = (o1, o2) -> o1.compareTo(o2) == -1 ? 0 : -1;

    public static Comparator<BigDecimal> DECIMAL_MORE = (o1, o2) -> o1.compareTo(o2) == 1 ? 0 : -1;

    public static FieldLengthComparator<String> STRING_LENGTH_IS_MATCH =
            (s, length) -> s.length() != length ? true : false;

}
