/**
 * generated by Xtext 2.24.0
 */
package hu.bme.mit.dipterv.text.minotorDsl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Loop</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hu.bme.mit.dipterv.text.minotorDsl.Loop#getMin <em>Min</em>}</li>
 *   <li>{@link hu.bme.mit.dipterv.text.minotorDsl.Loop#getMax <em>Max</em>}</li>
 *   <li>{@link hu.bme.mit.dipterv.text.minotorDsl.Loop#getMessages <em>Messages</em>}</li>
 * </ul>
 *
 * @see hu.bme.mit.dipterv.text.minotorDsl.MinotorDslPackage#getLoop()
 * @model
 * @generated
 */
public interface Loop extends EObject
{
  /**
   * Returns the value of the '<em><b>Min</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Min</em>' attribute.
   * @see #setMin(String)
   * @see hu.bme.mit.dipterv.text.minotorDsl.MinotorDslPackage#getLoop_Min()
   * @model
   * @generated
   */
  String getMin();

  /**
   * Sets the value of the '{@link hu.bme.mit.dipterv.text.minotorDsl.Loop#getMin <em>Min</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Min</em>' attribute.
   * @see #getMin()
   * @generated
   */
  void setMin(String value);

  /**
   * Returns the value of the '<em><b>Max</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Max</em>' attribute.
   * @see #setMax(String)
   * @see hu.bme.mit.dipterv.text.minotorDsl.MinotorDslPackage#getLoop_Max()
   * @model
   * @generated
   */
  String getMax();

  /**
   * Sets the value of the '{@link hu.bme.mit.dipterv.text.minotorDsl.Loop#getMax <em>Max</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Max</em>' attribute.
   * @see #getMax()
   * @generated
   */
  void setMax(String value);

  /**
   * Returns the value of the '<em><b>Messages</b></em>' containment reference list.
   * The list contents are of type {@link hu.bme.mit.dipterv.text.minotorDsl.Message}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Messages</em>' containment reference list.
   * @see hu.bme.mit.dipterv.text.minotorDsl.MinotorDslPackage#getLoop_Messages()
   * @model containment="true"
   * @generated
   */
  EList<Message> getMessages();

} // Loop
