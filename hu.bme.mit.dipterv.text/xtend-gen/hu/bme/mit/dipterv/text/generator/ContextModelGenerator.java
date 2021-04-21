package hu.bme.mit.dipterv.text.generator;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import hu.bme.mit.dipterv.text.minotorDsl.ContextModel;
import hu.bme.mit.dipterv.text.minotorDsl.Entity;
import hu.bme.mit.dipterv.text.minotorDsl.Relation;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.AbstractGenerator;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class ContextModelGenerator extends AbstractGenerator {
  @Inject
  @Extension
  private IQualifiedNameProvider _iQualifiedNameProvider;
  
  public CharSequence compile(final ContextModel m) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public class ");
    String _firstUpper = StringExtensions.toFirstUpper(m.getName());
    _builder.append(_firstUpper);
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    {
      EList<Entity> _entities = m.getEntities();
      for(final Entity e : _entities) {
        _builder.append("\t");
        _builder.append("private ");
        String _firstUpper_1 = StringExtensions.toFirstUpper(e.getName());
        _builder.append(_firstUpper_1, "\t");
        _builder.append(" ");
        String _firstLower = StringExtensions.toFirstLower(e.getName());
        _builder.append(_firstLower, "\t");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      EList<Relation> _relations = m.getRelations();
      for(final Relation r : _relations) {
        _builder.append("\t");
        _builder.append("private ");
        String _firstUpper_2 = StringExtensions.toFirstUpper(r.getName());
        _builder.append(_firstUpper_2, "\t");
        _builder.append(" ");
        String _firstLower_1 = StringExtensions.toFirstLower(r.getName());
        _builder.append(_firstLower_1, "\t");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ");
    String _firstUpper_3 = StringExtensions.toFirstUpper(m.getName());
    _builder.append(_firstUpper_3, "\t");
    _builder.append("() {");
    _builder.newLineIfNotEmpty();
    {
      EList<Entity> _entities_1 = m.getEntities();
      for(final Entity e_1 : _entities_1) {
        _builder.append("\t\t");
        String _firstLower_2 = StringExtensions.toFirstLower(e_1.getName());
        _builder.append(_firstLower_2, "\t\t");
        _builder.append(" = new ");
        String _firstUpper_4 = StringExtensions.toFirstUpper(e_1.getName());
        _builder.append(_firstUpper_4, "\t\t");
        _builder.append("();");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      EList<Relation> _relations_1 = m.getRelations();
      for(final Relation r_1 : _relations_1) {
        _builder.append("\t\t");
        String _firstLower_3 = StringExtensions.toFirstLower(r_1.getName());
        _builder.append(_firstLower_3, "\t\t");
        _builder.append(" = new ");
        String _firstUpper_5 = StringExtensions.toFirstUpper(r_1.getName());
        _builder.append(_firstUpper_5, "\t\t");
        _builder.append("(");
        String _firstLower_4 = StringExtensions.toFirstLower(r_1.getSender().getName());
        _builder.append(_firstLower_4, "\t\t");
        _builder.append(", ");
        String _firstLower_5 = StringExtensions.toFirstLower(r_1.getReceiver().getName());
        _builder.append(_firstLower_5, "\t\t");
        _builder.append(");");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ");
    String _firstUpper_6 = StringExtensions.toFirstUpper(m.getName());
    _builder.append(_firstUpper_6, "\t");
    _builder.append("(EventCreator eventCreator) {");
    _builder.newLineIfNotEmpty();
    {
      EList<Entity> _entities_2 = m.getEntities();
      for(final Entity e_2 : _entities_2) {
        _builder.append("\t\t");
        String _firstLower_6 = StringExtensions.toFirstLower(e_2.getName());
        _builder.append(_firstLower_6, "\t\t");
        _builder.append(" = new ");
        String _firstUpper_7 = StringExtensions.toFirstUpper(e_2.getName());
        _builder.append(_firstUpper_7, "\t\t");
        _builder.append("(eventCreator);");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      EList<Relation> _relations_2 = m.getRelations();
      for(final Relation r_2 : _relations_2) {
        _builder.append("\t\t");
        String _firstLower_7 = StringExtensions.toFirstLower(r_2.getName());
        _builder.append(_firstLower_7, "\t\t");
        _builder.append(" = new ");
        String _firstUpper_8 = StringExtensions.toFirstUpper(r_2.getName());
        _builder.append(_firstUpper_8, "\t\t");
        _builder.append("(");
        String _firstLower_8 = StringExtensions.toFirstLower(r_2.getSender().getName());
        _builder.append(_firstLower_8, "\t\t");
        _builder.append(", ");
        String _firstLower_9 = StringExtensions.toFirstLower(r_2.getReceiver().getName());
        _builder.append(_firstLower_9, "\t\t");
        _builder.append(", eventCreator);");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    {
      EList<Entity> _entities_3 = m.getEntities();
      for(final Entity e_3 : _entities_3) {
        _builder.append("\t");
        _builder.append("public ");
        String _firstUpper_9 = StringExtensions.toFirstUpper(e_3.getName());
        _builder.append(_firstUpper_9, "\t");
        _builder.append(" get");
        String _firstUpper_10 = StringExtensions.toFirstUpper(e_3.getName());
        _builder.append(_firstUpper_10, "\t");
        _builder.append("() {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("return ");
        String _firstLower_10 = StringExtensions.toFirstLower(e_3.getName());
        _builder.append(_firstLower_10, "\t\t");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
      }
    }
    {
      EList<Relation> _relations_3 = m.getRelations();
      for(final Relation r_3 : _relations_3) {
        _builder.append("\t");
        _builder.append("public ");
        String _firstUpper_11 = StringExtensions.toFirstUpper(r_3.getName());
        _builder.append(_firstUpper_11, "\t");
        _builder.append(" get");
        String _firstUpper_12 = StringExtensions.toFirstUpper(r_3.getName());
        _builder.append(_firstUpper_12, "\t");
        _builder.append("() {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("return ");
        String _firstLower_11 = StringExtensions.toFirstLower(r_3.getName());
        _builder.append(_firstLower_11, "\t\t");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  @Override
  public void doGenerate(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    Iterable<ContextModel> _filter = Iterables.<ContextModel>filter(IteratorExtensions.<EObject>toIterable(resource.getAllContents()), ContextModel.class);
    for (final ContextModel m : _filter) {
      String _string = this._iQualifiedNameProvider.getFullyQualifiedName(m).toString("/");
      String _plus = (_string + ".java");
      fsa.generateFile(_plus, this.compile(m));
    }
  }
}
