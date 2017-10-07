/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.code.base.block;

import java.io.IOException;
import java.util.List;

import net.sf.mmm.code.api.block.CodeBlock;
import net.sf.mmm.code.api.block.CodeBlockFor;
import net.sf.mmm.code.api.expression.CodeForExpression;
import net.sf.mmm.code.api.node.CodeNodeItemWithGenericParent;
import net.sf.mmm.code.api.statement.CodeStatement;

/**
 * Generic implementation of {@link CodeBlockFor}.
 *
 * @author Joerg Hohwiller (hohwille at users.sourceforge.net)
 * @since 1.0.0
 */
public class GenericBlockFor extends GenericBlockStatement implements CodeBlockFor, CodeNodeItemWithGenericParent<CodeBlock, GenericBlockFor> {

  private CodeForExpression expression;

  /**
   * The constructor.
   *
   * @param parent the {@link #getParent() parent}.
   * @param expression the {@link #getExpression() expression}.
   * @param statements the {@link #getStatements() statements}.
   */
  public GenericBlockFor(CodeBlock parent, CodeForExpression expression, CodeStatement... statements) {

    super(parent, statements);
    this.expression = expression;
  }

  /**
   * The constructor.
   *
   * @param parent the {@link #getParent() parent}.
   * @param expression the {@link #getExpression() expression}.
   * @param statements the {@link #getStatements() statements}.
   */
  public GenericBlockFor(CodeBlock parent, CodeForExpression expression, List<CodeStatement> statements) {

    super(parent, statements);
    this.expression = expression;
  }

  /**
   * The copy-constructor.
   *
   * @param parent the {@link #getParent() parent}.
   * @param template the {@link GenericBlockStatement} to copy.
   */
  public GenericBlockFor(GenericBlockFor template, CodeBlock parent) {

    super(template, parent);
    this.expression = template.expression;
  }

  @Override
  public CodeForExpression getExpression() {

    return this.expression;
  }

  @Override
  public GenericBlockFor copy() {

    return copy(getParent());
  }

  @Override
  public GenericBlockFor copy(CodeBlock newParent) {

    return new GenericBlockFor(this, newParent);
  }

  @Override
  protected void writePrefix(Appendable sink, String newline, String defaultIndent, String currentIndent) throws IOException {

    sink.append("for (");
    this.expression.write(sink, newline, defaultIndent, currentIndent);
    sink.append(") ");
  }

}
