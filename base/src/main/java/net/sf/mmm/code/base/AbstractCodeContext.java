/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.code.base;

import java.util.ArrayList;
import java.util.List;

import net.sf.mmm.code.api.CodeContext;
import net.sf.mmm.code.api.CodePackage;
import net.sf.mmm.code.api.doc.CodeDocDescriptor;
import net.sf.mmm.code.api.type.CodeType;

/**
 * Base implementation of {@link CodeContext}.
 *
 * @author Joerg Hohwiller (hohwille at users.sourceforge.net)
 * @param <T> implementation of {@link CodeType}.
 * @param <P> implementation of {@link CodePackage}.
 * @since 1.0.0
 */
public abstract class AbstractCodeContext<T extends CodeType, P extends CodePackage> implements CodeContext {

  private P rootPackage;

  private T rootType;

  private T voidType;

  private final List<CodeDocDescriptor> docDescriptors;

  private String newline;

  /**
   * The constructor.
   */
  public AbstractCodeContext() {

    super();
    this.docDescriptors = new ArrayList<>();
    this.newline = "\n";
  }

  /**
   * @return the newline.
   */
  public CharSequence getNewline() {

    return this.newline;
  }

  /**
   * @return the docDescriptors
   */
  public List<CodeDocDescriptor> getDocDescriptors() {

    return this.docDescriptors;
  }

  @Override
  public P getRootPackage() {

    return this.rootPackage;
  }

  /**
   * @param rootPackage the {@link #getRootPackage() root package}. May be set only once during
   *        initialization.
   */
  protected void setRootPackage(P rootPackage) {

    if (this.rootPackage == null) {
      this.rootPackage = rootPackage;
    }
    if (this.rootPackage != rootPackage) {
      throw new IllegalStateException("Already initialized");
    }
  }

  @Override
  public T getRootType() {

    return this.rootType;
  }

  /**
   * @param rootType the new {@link #getRootType() root type}.
   */
  public void setRootType(T rootType) {

    if (this.rootType == null) {
      this.rootType = rootType;
    }
    if (this.rootType != rootType) {
      throw new IllegalStateException("Already initialized");
    }
  }

  @Override
  public T getVoidType() {

    return this.voidType;
  }

  /**
   * @param voidType the new {@link #getVoidType() void type}.
   */
  public void setVoidType(T voidType) {

    if (this.voidType == null) {
      this.voidType = voidType;
    }
    if (this.voidType != voidType) {
      throw new IllegalStateException("Already initialized");
    }
  }

}
