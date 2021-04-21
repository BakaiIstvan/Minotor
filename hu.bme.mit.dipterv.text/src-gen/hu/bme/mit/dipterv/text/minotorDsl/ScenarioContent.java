/**
 * generated by Xtext 2.24.0
 */
package hu.bme.mit.dipterv.text.minotorDsl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Scenario Content</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hu.bme.mit.dipterv.text.minotorDsl.ScenarioContent#getAlt <em>Alt</em>}</li>
 *   <li>{@link hu.bme.mit.dipterv.text.minotorDsl.ScenarioContent#getMessage <em>Message</em>}</li>
 *   <li>{@link hu.bme.mit.dipterv.text.minotorDsl.ScenarioContent#getPar <em>Par</em>}</li>
 *   <li>{@link hu.bme.mit.dipterv.text.minotorDsl.ScenarioContent#getLoop <em>Loop</em>}</li>
 *   <li>{@link hu.bme.mit.dipterv.text.minotorDsl.ScenarioContent#getContextmessage <em>Contextmessage</em>}</li>
 *   <li>{@link hu.bme.mit.dipterv.text.minotorDsl.ScenarioContent#getParamConstraint <em>Param Constraint</em>}</li>
 *   <li>{@link hu.bme.mit.dipterv.text.minotorDsl.ScenarioContent#getAssertentity <em>Assertentity</em>}</li>
 *   <li>{@link hu.bme.mit.dipterv.text.minotorDsl.ScenarioContent#getAssertrelation <em>Assertrelation</em>}</li>
 * </ul>
 *
 * @see hu.bme.mit.dipterv.text.minotorDsl.MinotorDslPackage#getScenarioContent()
 * @model
 * @generated
 */
public interface ScenarioContent extends EObject
{
  /**
   * Returns the value of the '<em><b>Alt</b></em>' containment reference list.
   * The list contents are of type {@link hu.bme.mit.dipterv.text.minotorDsl.Alt}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Alt</em>' containment reference list.
   * @see hu.bme.mit.dipterv.text.minotorDsl.MinotorDslPackage#getScenarioContent_Alt()
   * @model containment="true"
   * @generated
   */
  EList<Alt> getAlt();

  /**
   * Returns the value of the '<em><b>Message</b></em>' containment reference list.
   * The list contents are of type {@link hu.bme.mit.dipterv.text.minotorDsl.Message}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Message</em>' containment reference list.
   * @see hu.bme.mit.dipterv.text.minotorDsl.MinotorDslPackage#getScenarioContent_Message()
   * @model containment="true"
   * @generated
   */
  EList<Message> getMessage();

  /**
   * Returns the value of the '<em><b>Par</b></em>' containment reference list.
   * The list contents are of type {@link hu.bme.mit.dipterv.text.minotorDsl.Par}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Par</em>' containment reference list.
   * @see hu.bme.mit.dipterv.text.minotorDsl.MinotorDslPackage#getScenarioContent_Par()
   * @model containment="true"
   * @generated
   */
  EList<Par> getPar();

  /**
   * Returns the value of the '<em><b>Loop</b></em>' containment reference list.
   * The list contents are of type {@link hu.bme.mit.dipterv.text.minotorDsl.Loop}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Loop</em>' containment reference list.
   * @see hu.bme.mit.dipterv.text.minotorDsl.MinotorDslPackage#getScenarioContent_Loop()
   * @model containment="true"
   * @generated
   */
  EList<Loop> getLoop();

  /**
   * Returns the value of the '<em><b>Contextmessage</b></em>' containment reference list.
   * The list contents are of type {@link hu.bme.mit.dipterv.text.minotorDsl.ContextMessage}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Contextmessage</em>' containment reference list.
   * @see hu.bme.mit.dipterv.text.minotorDsl.MinotorDslPackage#getScenarioContent_Contextmessage()
   * @model containment="true"
   * @generated
   */
  EList<ContextMessage> getContextmessage();

  /**
   * Returns the value of the '<em><b>Param Constraint</b></em>' containment reference list.
   * The list contents are of type {@link hu.bme.mit.dipterv.text.minotorDsl.ParameterConstraint}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Param Constraint</em>' containment reference list.
   * @see hu.bme.mit.dipterv.text.minotorDsl.MinotorDslPackage#getScenarioContent_ParamConstraint()
   * @model containment="true"
   * @generated
   */
  EList<ParameterConstraint> getParamConstraint();

  /**
   * Returns the value of the '<em><b>Assertentity</b></em>' containment reference list.
   * The list contents are of type {@link hu.bme.mit.dipterv.text.minotorDsl.AssertionEntity}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Assertentity</em>' containment reference list.
   * @see hu.bme.mit.dipterv.text.minotorDsl.MinotorDslPackage#getScenarioContent_Assertentity()
   * @model containment="true"
   * @generated
   */
  EList<AssertionEntity> getAssertentity();

  /**
   * Returns the value of the '<em><b>Assertrelation</b></em>' containment reference list.
   * The list contents are of type {@link hu.bme.mit.dipterv.text.minotorDsl.AssertionRelation}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Assertrelation</em>' containment reference list.
   * @see hu.bme.mit.dipterv.text.minotorDsl.MinotorDslPackage#getScenarioContent_Assertrelation()
   * @model containment="true"
   * @generated
   */
  EList<AssertionRelation> getAssertrelation();

} // ScenarioContent
