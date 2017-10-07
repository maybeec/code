/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.code.impl.java.operator;

import net.sf.mmm.code.api.operator.CodeNAryOperator;

/**
 * Implementation of {@link JavaNAryOperatorAggregateNumeric} for {@code int}.
 *
 * @author Joerg Hohwiller (hohwille at users.sourceforge.net)
 * @since 1.0.0
 */
@SuppressWarnings("javadoc")
class JavaNAryOperatorAggregateInt extends JavaNAryOperatorAggregateNumeric<Integer> {

  private int value;

  JavaNAryOperatorAggregateInt(CodeNAryOperator operator, int value) {

    super(operator);
    this.value = value;
  }

  @Override
  public Integer getValue() {

    return Integer.valueOf(this.value);
  }

  @Override
  public JavaNAryOperatorAggregate<?> evaluate(Object arg) {

    if (arg instanceof Long) {
      return new JavaNAryOperatorAggregateLong(this.operator, this.value).evaluate(arg);
    } else if (arg instanceof Float) {
      return new JavaNAryOperatorAggregateFloat(this.operator, this.value).evaluate(arg);
    } else if (arg instanceof Double) {
      return new JavaNAryOperatorAggregateDouble(this.operator, this.value).evaluate(arg);
    }
    return super.evaluate(arg);
  }

  @Override
  protected JavaNAryOperatorAggregateNumeric<?> add(Number arg) {

    this.value += arg.intValue();
    return this;
  }

  @Override
  protected JavaNAryOperatorAggregateNumeric<?> sub(Number arg) {

    this.value -= arg.intValue();
    return this;
  }

  @Override
  protected JavaNAryOperatorAggregateNumeric<?> mul(Number arg) {

    this.value *= arg.intValue();
    return this;
  }

  @Override
  protected JavaNAryOperatorAggregateNumeric<?> div(Number arg) {

    this.value /= arg.intValue();
    return this;
  }

  @Override
  protected JavaNAryOperatorAggregateNumeric<?> mod(Number arg) {

    this.value %= arg.intValue();
    return this;
  }

  @Override
  protected JavaNAryOperatorAggregateNumeric<?> xor(Number arg) {

    this.value ^= arg.intValue();
    return this;
  }

  @Override
  protected JavaNAryOperatorAggregateNumeric<?> shiftLeft(Number arg) {

    this.value <<= arg.intValue();
    return this;
  }

  @Override
  protected JavaNAryOperatorAggregateNumeric<?> shiftRightSigned(Number arg) {

    this.value >>= arg.intValue();
    return this;
  }

  @Override
  protected JavaNAryOperatorAggregateNumeric<?> shiftRightUnsigned(Number arg) {

    this.value >>>= arg.intValue();
    return this;
  }

  @Override
  protected JavaNAryOperatorAggregateNumeric<?> bitOr(Number arg) {

    this.value |= arg.intValue();
    return this;
  }

  @Override
  protected JavaNAryOperatorAggregateNumeric<?> bitAnd(Number arg) {

    this.value &= arg.intValue();
    return this;
  }

}
