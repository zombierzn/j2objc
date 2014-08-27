/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.devtools.j2objc.ast;

import com.google.devtools.j2objc.types.Types;

/**
 * Either "true" or "false".
 */
public class BooleanLiteral extends Expression {

  private boolean booleanValue = false;

  public BooleanLiteral(org.eclipse.jdt.core.dom.BooleanLiteral jdtNode) {
    super(jdtNode);
    booleanValue = jdtNode.booleanValue();
  }

  public BooleanLiteral(BooleanLiteral other) {
    super(other);
    booleanValue = other.booleanValue();
  }

  public BooleanLiteral(boolean booleanValue) {
    super(Types.resolveJavaType("boolean"));
    this.booleanValue = booleanValue;
  }

  @Override
  public Kind getKind() {
    return Kind.BOOLEAN_LITERAL;
  }

  public boolean booleanValue() {
    return booleanValue;
  }

  public void setBooleanValue(boolean newBooleanValue) {
    booleanValue = newBooleanValue;
  }

  @Override
  protected void acceptInner(TreeVisitor visitor) {
    visitor.visit(this);
    visitor.endVisit(this);
  }

  @Override
  public BooleanLiteral copy() {
    return new BooleanLiteral(this);
  }
}
