/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.code.impl.java.expression;

import net.sf.mmm.code.api.expression.CodeExpression;
import net.sf.mmm.code.impl.java.expression.constant.JavaConstant;

/**
 * Implementation of {@link CodeExpression} for Java.
 *
 * @author Joerg Hohwiller (hohwille at users.sourceforge.net)
 * @since 1.0.0
 */
public abstract interface JavaExpression extends CodeExpression {

  @Override
  JavaConstant<?> evaluate();

}
