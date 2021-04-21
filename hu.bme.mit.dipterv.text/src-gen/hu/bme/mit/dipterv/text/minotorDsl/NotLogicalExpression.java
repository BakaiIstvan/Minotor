/**
 * generated by Xtext 2.24.0
 */
package hu.bme.mit.dipterv.text.minotorDsl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Not Logical Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hu.bme.mit.dipterv.text.minotorDsl.NotLogicalExpression#getOperand <em>Operand</em>}</li>
 * </ul>
 *
 * @see hu.bme.mit.dipterv.text.minotorDsl.MinotorDslPackage#getNotLogicalExpression()
 * @model
 * @generated
 */
public interface NotLogicalExpression extends UnaryLogicalExpression
{
  /**
   * Returns the value of the '<em><b>Operand</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operand</em>' containment reference.
   * @see #setOperand(LogicalExpression)
   * @see hu.bme.mit.dipterv.text.minotorDsl.MinotorDslPackage#getNotLogicalExpression_Operand()
   * @model containment="true"
   * @generated
   */
  LogicalExpression getOperand();

  /**
   * Sets the value of the '{@link hu.bme.mit.dipterv.text.minotorDsl.NotLogicalExpression#getOperand <em>Operand</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Operand</em>' containment reference.
   * @see #getOperand()
   * @generated
   */
  void setOperand(LogicalExpression value);

} // NotLogicalExpression
