package hu.bme.mit.dipterv.text.scoping

import com.google.common.base.Splitter
import com.google.inject.Inject
import com.google.inject.Provider
import java.util.LinkedHashSet
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.resource.IResourceDescription
import org.eclipse.xtext.scoping.impl.ImportUriGlobalScopeProvider
import org.eclipse.xtext.util.IResourceScopeCache
import hu.bme.mit.dipterv.text.minotorDsl.MinotorDslPackage
import hu.bme.mit.dipterv.text.MinotorDslResourceDescriptionStrategy

class MinotorDslGlobalScopeProvider extends ImportUriGlobalScopeProvider {
	static final Splitter SPLITTER = Splitter.on(',');

	@Inject
	IResourceDescription.Manager descriptionManager;

	@Inject
	IResourceScopeCache cache;

	override protected getImportedUris(Resource resource) {
		return cache.get(MinotorDslGlobalScopeProvider.getSimpleName(), resource, new Provider<LinkedHashSet<URI>>() {
			override get() {
				val uniqueImportURIs = collectImportUris(resource, new LinkedHashSet<URI>(5))

				val uriIter = uniqueImportURIs.iterator()
				while(uriIter.hasNext()) {
					if (!EcoreUtil2.isValidUri(resource, uriIter.next()))
						uriIter.remove()
				}
				return uniqueImportURIs
			}

			def LinkedHashSet<URI> collectImportUris(Resource resource, LinkedHashSet<URI> uniqueImportURIs) {
				val resourceDescription = descriptionManager.getResourceDescription(resource)
				val models = resourceDescription.getExportedObjectsByType(MinotorDslPackage.Literals.DOMAIN)
				
				models.forEach[
					val userData = getUserData(MinotorDslResourceDescriptionStrategy.INCLUDES)
					if(userData !== null) {
						SPLITTER.split(userData).forEach[uri |
							var includedUri = URI.createURI(uri)
							includedUri = includedUri.resolve(resource.URI)
							if(uniqueImportURIs.add(includedUri)) {
								collectImportUris(resource.getResourceSet().getResource(includedUri, true), uniqueImportURIs)
							}
						]
					}
				]
				
				return uniqueImportURIs
			}
		});
	}
}