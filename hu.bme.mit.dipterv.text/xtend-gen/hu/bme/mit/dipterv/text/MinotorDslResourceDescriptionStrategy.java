package hu.bme.mit.dipterv.text;

import com.google.inject.Inject;
import hu.bme.mit.dipterv.text.minotorDsl.Domain;
import hu.bme.mit.dipterv.text.minotorDsl.Include;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Consumer;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.impl.DefaultResourceDescriptionStrategy;
import org.eclipse.xtext.scoping.impl.ImportUriResolver;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class MinotorDslResourceDescriptionStrategy extends DefaultResourceDescriptionStrategy {
  public static final String INCLUDES = "includes";
  
  @Inject
  private ImportUriResolver uriResolver;
  
  @Override
  public boolean createEObjectDescriptions(final EObject eObject, final IAcceptor<IEObjectDescription> acceptor) {
    boolean _xifexpression = false;
    if ((eObject instanceof Domain)) {
      this.createEObjectDescriptionForDomain(((Domain)eObject), acceptor);
      return true;
    } else {
      _xifexpression = super.createEObjectDescriptions(eObject, acceptor);
    }
    return _xifexpression;
  }
  
  public void createEObjectDescriptionForDomain(final Domain model, final IAcceptor<IEObjectDescription> acceptor) {
    final ArrayList<Object> uris = CollectionLiterals.<Object>newArrayList();
    final Consumer<Include> _function = (Include it) -> {
      uris.add(this.uriResolver.apply(it));
    };
    model.getIncludes().forEach(_function);
    final HashMap<String, String> userData = new HashMap<String, String>();
    userData.put(MinotorDslResourceDescriptionStrategy.INCLUDES, IterableExtensions.join(uris, ","));
    acceptor.accept(EObjectDescription.create(QualifiedName.create(model.eResource().getURI().toString()), model, userData));
  }
}
