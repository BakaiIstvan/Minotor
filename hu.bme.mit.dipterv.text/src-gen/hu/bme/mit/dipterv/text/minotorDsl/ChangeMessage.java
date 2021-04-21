/**
 * generated by Xtext 2.24.0
 */
package hu.bme.mit.dipterv.text.minotorDsl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Change Message</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hu.bme.mit.dipterv.text.minotorDsl.ChangeMessage#getDisappear <em>Disappear</em>}</li>
 *   <li>{@link hu.bme.mit.dipterv.text.minotorDsl.ChangeMessage#getAppear <em>Appear</em>}</li>
 *   <li>{@link hu.bme.mit.dipterv.text.minotorDsl.ChangeMessage#getChangeto <em>Changeto</em>}</li>
 *   <li>{@link hu.bme.mit.dipterv.text.minotorDsl.ChangeMessage#getChangetor <em>Changetor</em>}</li>
 * </ul>
 *
 * @see hu.bme.mit.dipterv.text.minotorDsl.MinotorDslPackage#getChangeMessage()
 * @model
 * @generated
 */
public interface ChangeMessage extends EObject
{
  /**
   * Returns the value of the '<em><b>Disappear</b></em>' containment reference list.
   * The list contents are of type {@link hu.bme.mit.dipterv.text.minotorDsl.DisappearMessage}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Disappear</em>' containment reference list.
   * @see hu.bme.mit.dipterv.text.minotorDsl.MinotorDslPackage#getChangeMessage_Disappear()
   * @model containment="true"
   * @generated
   */
  EList<DisappearMessage> getDisappear();

  /**
   * Returns the value of the '<em><b>Appear</b></em>' containment reference list.
   * The list contents are of type {@link hu.bme.mit.dipterv.text.minotorDsl.AppearMessage}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Appear</em>' containment reference list.
   * @see hu.bme.mit.dipterv.text.minotorDsl.MinotorDslPackage#getChangeMessage_Appear()
   * @model containment="true"
   * @generated
   */
  EList<AppearMessage> getAppear();

  /**
   * Returns the value of the '<em><b>Changeto</b></em>' containment reference list.
   * The list contents are of type {@link hu.bme.mit.dipterv.text.minotorDsl.ChangeToMessage}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Changeto</em>' containment reference list.
   * @see hu.bme.mit.dipterv.text.minotorDsl.MinotorDslPackage#getChangeMessage_Changeto()
   * @model containment="true"
   * @generated
   */
  EList<ChangeToMessage> getChangeto();

  /**
   * Returns the value of the '<em><b>Changetor</b></em>' containment reference list.
   * The list contents are of type {@link hu.bme.mit.dipterv.text.minotorDsl.ChangeToRelation}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Changetor</em>' containment reference list.
   * @see hu.bme.mit.dipterv.text.minotorDsl.MinotorDslPackage#getChangeMessage_Changetor()
   * @model containment="true"
   * @generated
   */
  EList<ChangeToRelation> getChangetor();

} // ChangeMessage
