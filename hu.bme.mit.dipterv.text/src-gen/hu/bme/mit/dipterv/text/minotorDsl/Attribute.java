/**
 * generated by Xtext 2.24.0
 */
package hu.bme.mit.dipterv.text.minotorDsl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hu.bme.mit.dipterv.text.minotorDsl.Attribute#isInt <em>Int</em>}</li>
 *   <li>{@link hu.bme.mit.dipterv.text.minotorDsl.Attribute#isFloat <em>Float</em>}</li>
 *   <li>{@link hu.bme.mit.dipterv.text.minotorDsl.Attribute#isString <em>String</em>}</li>
 *   <li>{@link hu.bme.mit.dipterv.text.minotorDsl.Attribute#isBoolean <em>Boolean</em>}</li>
 *   <li>{@link hu.bme.mit.dipterv.text.minotorDsl.Attribute#getName <em>Name</em>}</li>
 *   <li>{@link hu.bme.mit.dipterv.text.minotorDsl.Attribute#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see hu.bme.mit.dipterv.text.minotorDsl.MinotorDslPackage#getAttribute()
 * @model
 * @generated
 */
public interface Attribute extends EObject
{
  /**
   * Returns the value of the '<em><b>Int</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Int</em>' attribute.
   * @see #setInt(boolean)
   * @see hu.bme.mit.dipterv.text.minotorDsl.MinotorDslPackage#getAttribute_Int()
   * @model
   * @generated
   */
  boolean isInt();

  /**
   * Sets the value of the '{@link hu.bme.mit.dipterv.text.minotorDsl.Attribute#isInt <em>Int</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Int</em>' attribute.
   * @see #isInt()
   * @generated
   */
  void setInt(boolean value);

  /**
   * Returns the value of the '<em><b>Float</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Float</em>' attribute.
   * @see #setFloat(boolean)
   * @see hu.bme.mit.dipterv.text.minotorDsl.MinotorDslPackage#getAttribute_Float()
   * @model
   * @generated
   */
  boolean isFloat();

  /**
   * Sets the value of the '{@link hu.bme.mit.dipterv.text.minotorDsl.Attribute#isFloat <em>Float</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Float</em>' attribute.
   * @see #isFloat()
   * @generated
   */
  void setFloat(boolean value);

  /**
   * Returns the value of the '<em><b>String</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>String</em>' attribute.
   * @see #setString(boolean)
   * @see hu.bme.mit.dipterv.text.minotorDsl.MinotorDslPackage#getAttribute_String()
   * @model
   * @generated
   */
  boolean isString();

  /**
   * Sets the value of the '{@link hu.bme.mit.dipterv.text.minotorDsl.Attribute#isString <em>String</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>String</em>' attribute.
   * @see #isString()
   * @generated
   */
  void setString(boolean value);

  /**
   * Returns the value of the '<em><b>Boolean</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Boolean</em>' attribute.
   * @see #setBoolean(boolean)
   * @see hu.bme.mit.dipterv.text.minotorDsl.MinotorDslPackage#getAttribute_Boolean()
   * @model
   * @generated
   */
  boolean isBoolean();

  /**
   * Sets the value of the '{@link hu.bme.mit.dipterv.text.minotorDsl.Attribute#isBoolean <em>Boolean</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Boolean</em>' attribute.
   * @see #isBoolean()
   * @generated
   */
  void setBoolean(boolean value);

  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see hu.bme.mit.dipterv.text.minotorDsl.MinotorDslPackage#getAttribute_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link hu.bme.mit.dipterv.text.minotorDsl.Attribute#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' containment reference.
   * @see #setValue(AttributeValue)
   * @see hu.bme.mit.dipterv.text.minotorDsl.MinotorDslPackage#getAttribute_Value()
   * @model containment="true"
   * @generated
   */
  AttributeValue getValue();

  /**
   * Sets the value of the '{@link hu.bme.mit.dipterv.text.minotorDsl.Attribute#getValue <em>Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' containment reference.
   * @see #getValue()
   * @generated
   */
  void setValue(AttributeValue value);

} // Attribute
