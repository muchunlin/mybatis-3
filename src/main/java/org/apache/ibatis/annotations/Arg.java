/*
 *    Copyright 2009-2023 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       https://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.apache.ibatis.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
import org.apache.ibatis.type.UnknownTypeHandler;

/**
 * 这个注解为构造函数中的参数，定义了一个映射定义。
 *
 * @see ConstructorArgs
 *
 * @author Clinton Begin
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(ConstructorArgs.class)
public @interface Arg {

  /**
   * 返回是否是id列
   *
   * @return {@code true} 如果id是列; {@code false} 否则
   */
  boolean id() default false;

  /**
   * Return the column name(or column label) to map to this argument.
   * 返回列的名字（或列的标签）来映射这个参数
   *
   * @return the column name(or column label)
   * @return 列的名字(列的标签)
   */
  String column() default "";

  /**
   * 返回这个参数的的java类型
   * @return 这个java类型
   */
  Class<?> javaType() default void.class;

  /**
   * Return the jdbc type for column that map to this argument.
   * 返回这个字段的jdbc的类型。
   * @return the jdbc type
   */
  JdbcType jdbcType() default JdbcType.UNDEFINED;

  /**
   * Returns the {@link TypeHandler} type for retrieving a column value from result set.
   * 返回用于从结果集中提取的列的值的{@link TypeHandler}的类型
   * @return the {@link TypeHandler} type
   */
  Class<? extends TypeHandler> typeHandler() default UnknownTypeHandler.class;

  /**
   * Return the statement id for retrieving a object that map to this argument.
   *
   * @return the statement id
   */
  String select() default "";

  /**
   * Returns the result map id for mapping to a object that map to this argument.
   *
   * @return the result map id
   */
  String resultMap() default "";

  /**
   * Returns the parameter name for applying this mapping.
   * 返回参数名字
   * @return the parameter name
   *
   * @since 3.4.3
   */
  String name() default "";

  /**
   * Returns the column prefix that use when applying {@link #resultMap()}.
   * 返回列的前缀
   * @return the column prefix
   *
   * @since 3.5.0
   */
  String columnPrefix() default "";
}
