/**
 * generated by Xtext 2.24.0
 */
package hu.bme.mit.dipterv.text.minotorDsl.impl;

import hu.bme.mit.dipterv.text.minotorDsl.ContextFragment;
import hu.bme.mit.dipterv.text.minotorDsl.ContextModel;
import hu.bme.mit.dipterv.text.minotorDsl.MatchMessage;
import hu.bme.mit.dipterv.text.minotorDsl.MinotorDslPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Match Message</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link hu.bme.mit.dipterv.text.minotorDsl.impl.MatchMessageImpl#getContext <em>Context</em>}</li>
 *   <li>{@link hu.bme.mit.dipterv.text.minotorDsl.impl.MatchMessageImpl#getContent <em>Content</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MatchMessageImpl extends MinimalEObjectImpl.Container implements MatchMessage
{
  /**
   * The cached value of the '{@link #getContext() <em>Context</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getContext()
   * @generated
   * @ordered
   */
  protected ContextModel context;

  /**
   * The cached value of the '{@link #getContent() <em>Content</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getContent()
   * @generated
   * @ordered
   */
  protected ContextFragment content;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MatchMessageImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return MinotorDslPackage.Literals.MATCH_MESSAGE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ContextModel getContext()
  {
    if (context != null && context.eIsProxy())
    {
      InternalEObject oldContext = (InternalEObject)context;
      context = (ContextModel)eResolveProxy(oldContext);
      if (context != oldContext)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, MinotorDslPackage.MATCH_MESSAGE__CONTEXT, oldContext, context));
      }
    }
    return context;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ContextModel basicGetContext()
  {
    return context;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setContext(ContextModel newContext)
  {
    ContextModel oldContext = context;
    context = newContext;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MinotorDslPackage.MATCH_MESSAGE__CONTEXT, oldContext, context));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ContextFragment getContent()
  {
    if (content != null && content.eIsProxy())
    {
      InternalEObject oldContent = (InternalEObject)content;
      content = (ContextFragment)eResolveProxy(oldContent);
      if (content != oldContent)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, MinotorDslPackage.MATCH_MESSAGE__CONTENT, oldContent, content));
      }
    }
    return content;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ContextFragment basicGetContent()
  {
    return content;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setContent(ContextFragment newContent)
  {
    ContextFragment oldContent = content;
    content = newContent;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MinotorDslPackage.MATCH_MESSAGE__CONTENT, oldContent, content));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case MinotorDslPackage.MATCH_MESSAGE__CONTEXT:
        if (resolve) return getContext();
        return basicGetContext();
      case MinotorDslPackage.MATCH_MESSAGE__CONTENT:
        if (resolve) return getContent();
        return basicGetContent();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case MinotorDslPackage.MATCH_MESSAGE__CONTEXT:
        setContext((ContextModel)newValue);
        return;
      case MinotorDslPackage.MATCH_MESSAGE__CONTENT:
        setContent((ContextFragment)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case MinotorDslPackage.MATCH_MESSAGE__CONTEXT:
        setContext((ContextModel)null);
        return;
      case MinotorDslPackage.MATCH_MESSAGE__CONTENT:
        setContent((ContextFragment)null);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case MinotorDslPackage.MATCH_MESSAGE__CONTEXT:
        return context != null;
      case MinotorDslPackage.MATCH_MESSAGE__CONTENT:
        return content != null;
    }
    return super.eIsSet(featureID);
  }

} //MatchMessageImpl
