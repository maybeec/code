/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.code.base.expression;

import java.io.IOException;

import net.sf.mmm.code.api.expression.CodeConstant;
import net.sf.mmm.code.api.expression.CodeExpression;
import net.sf.mmm.code.api.expression.CodeUnaryOperatorExpression;
import net.sf.mmm.code.api.operator.CodeUnaryOperator;
import net.sf.mmm.code.api.syntax.CodeSyntax;

/**
 * Generic implementation of {@link CodeUnaryOperatorExpression}.
 *
 * @author Joerg Hohwiller (hohwille at users.sourceforge.net)
 * @since 1.0.0
 */
public class GenericUnaryOperatorExpression extends GenericOperatorExpression implements CodeUnaryOperatorExpression {

  private final CodeUnaryOperator operator;

  private final CodeExpression argument;

  /**
   * The constructor.
   *
   * @param operator the {@link #getOperator() operator}.
   * @param argument the {@link #getArgument() argument}.
   */
  public GenericUnaryOperatorExpression(CodeUnaryOperator operator, CodeExpression argument) {

    super();
    this.operator = operator;
    this.argument = argument;
  }

  @Override
  public CodeConstant evaluate() {

    // can only be implemented in language specific sub-class
    return null;
  }

  @Override
  public CodeExpression getArgument() {

    return this.argument;
  }

  @Override
  public CodeUnaryOperator getOperator() {

    return this.operator;
  }

  @Override
  protected void doWrite(Appendable sink, String newline, String defaultIndent, String currentIndent, CodeSyntax syntax) throws IOException {

    sink.append(this.operator.getName());
    this.argument.write(sink, newline, defaultIndent, currentIndent);
  }

}
