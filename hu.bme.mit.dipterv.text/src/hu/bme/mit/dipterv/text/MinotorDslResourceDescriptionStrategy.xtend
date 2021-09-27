package hu.bme.mit.dipterv.text

import hu.bme.mit.dipterv.text.minotorDsl.Domain
import com.google.inject.Inject
import org.eclipse.xtext.scoping.impl.ImportUriResolver
import org.eclipse.xtext.resource.IEObjectDescription
import org.eclipse.xtext.resource.impl.DefaultResourceDescriptionStrategy
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.util.IAcceptor
import java.util.HashMap
import org.eclipse.xtext.resource.EObjectDescription
import org.eclipse.xtext.naming.QualifiedName

class MinotorDslResourceDescriptionStrategy extends DefaultResourceDescriptionStrategy {
	public static final String INCLUDES = "includes"
	@Inject
	ImportUriResolver uriResolver

	override createEObjectDescriptions(EObject eObject, IAcceptor<IEObjectDescription> acceptor) {
		super.createEObjectDescriptions(eObject, acceptor)
	}
}