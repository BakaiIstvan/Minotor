/**
 * generated by Xtext 2.24.0
 */
package hu.bme.mit.dipterv.text.minotorDsl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Relation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hu.bme.mit.dipterv.text.minotorDsl.Relation#getName <em>Name</em>}</li>
 *   <li>{@link hu.bme.mit.dipterv.text.minotorDsl.Relation#getSender <em>Sender</em>}</li>
 *   <li>{@link hu.bme.mit.dipterv.text.minotorDsl.Relation#getReceiver <em>Receiver</em>}</li>
 *   <li>{@link hu.bme.mit.dipterv.text.minotorDsl.Relation#getAttributes <em>Attributes</em>}</li>
 * </ul>
 *
 * @see hu.bme.mit.dipterv.text.minotorDsl.MinotorDslPackage#getRelation()
 * @model
 * @generated
 */
public interface Relation extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see hu.bme.mit.dipterv.text.minotorDsl.MinotorDslPackage#getRelation_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link hu.bme.mit.dipterv.text.minotorDsl.Relation#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Sender</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Sender</em>' reference.
   * @see #setSender(Entity)
   * @see hu.bme.mit.dipterv.text.minotorDsl.MinotorDslPackage#getRelation_Sender()
   * @model
   * @generated
   */
  Entity getSender();

  /**
   * Sets the value of the '{@link hu.bme.mit.dipterv.text.minotorDsl.Relation#getSender <em>Sender</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Sender</em>' reference.
   * @see #getSender()
   * @generated
   */
  void setSender(Entity value);

  /**
   * Returns the value of the '<em><b>Receiver</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Receiver</em>' reference.
   * @see #setReceiver(Entity)
   * @see hu.bme.mit.dipterv.text.minotorDsl.MinotorDslPackage#getRelation_Receiver()
   * @model
   * @generated
   */
  Entity getReceiver();

  /**
   * Sets the value of the '{@link hu.bme.mit.dipterv.text.minotorDsl.Relation#getReceiver <em>Receiver</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Receiver</em>' reference.
   * @see #getReceiver()
   * @generated
   */
  void setReceiver(Entity value);

  /**
   * Returns the value of the '<em><b>Attributes</b></em>' containment reference list.
   * The list contents are of type {@link hu.bme.mit.dipterv.text.minotorDsl.Attribute}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Attributes</em>' containment reference list.
   * @see hu.bme.mit.dipterv.text.minotorDsl.MinotorDslPackage#getRelation_Attributes()
   * @model containment="true"
   * @generated
   */
  EList<Attribute> getAttributes();

} // Relation
