package hu.bme.mit.dipterv.text.generator;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import hu.bme.mit.dipterv.text.minotorDsl.Attribute;
import hu.bme.mit.dipterv.text.minotorDsl.AttributeValue;
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
public class RelationGenerator extends AbstractGenerator {
  @Inject
  @Extension
  private IQualifiedNameProvider _iQualifiedNameProvider;
  
  @Override
  public void doGenerate(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    Iterable<Relation> _filter = Iterables.<Relation>filter(IteratorExtensions.<EObject>toIterable(resource.getAllContents()), Relation.class);
    for (final Relation m : _filter) {
      String _string = this._iQualifiedNameProvider.getFullyQualifiedName(m).toString("/");
      String _plus = (_string + ".java");
      fsa.generateFile(_plus, this.compile(m));
    }
  }
  
  public CharSequence compile(final Relation r) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public class ");
    String _firstUpper = StringExtensions.toFirstUpper(r.getName());
    _builder.append(_firstUpper);
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("private ");
    String _firstUpper_1 = StringExtensions.toFirstUpper(r.getSender().getName());
    _builder.append(_firstUpper_1, "\t");
    _builder.append(" sender;");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("private ");
    String _firstUpper_2 = StringExtensions.toFirstUpper(r.getReceiver().getName());
    _builder.append(_firstUpper_2, "\t");
    _builder.append(" receiver;");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("private EventCreator eventCreator;");
    _builder.newLine();
    {
      EList<Attribute> _attributes = r.getAttributes();
      for(final Attribute a : _attributes) {
        {
          boolean _isInt = a.isInt();
          if (_isInt) {
            _builder.append("\t");
            _builder.append("private int ");
            String _firstLower = StringExtensions.toFirstLower(a.getName());
            _builder.append(_firstLower, "\t");
            _builder.append(";");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          boolean _isFloat = a.isFloat();
          if (_isFloat) {
            _builder.append("\t");
            _builder.append("private float ");
            String _firstLower_1 = StringExtensions.toFirstLower(a.getName());
            _builder.append(_firstLower_1, "\t");
            _builder.append(";");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          boolean _isString = a.isString();
          if (_isString) {
            _builder.append("\t");
            _builder.append("private String ");
            String _firstLower_2 = StringExtensions.toFirstLower(a.getName());
            _builder.append(_firstLower_2, "\t");
            _builder.append(";");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          boolean _isBoolean = a.isBoolean();
          if (_isBoolean) {
            _builder.append("\t");
            _builder.append("private boolean ");
            String _firstLower_3 = StringExtensions.toFirstLower(a.getName());
            _builder.append(_firstLower_3, "\t");
            _builder.append(";");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ");
    String _firstUpper_3 = StringExtensions.toFirstUpper(r.getName());
    _builder.append(_firstUpper_3, "\t");
    _builder.append("(");
    String _firstUpper_4 = StringExtensions.toFirstUpper(r.getSender().getName());
    _builder.append(_firstUpper_4, "\t");
    _builder.append(" sender, ");
    String _firstUpper_5 = StringExtensions.toFirstUpper(r.getReceiver().getName());
    _builder.append(_firstUpper_5, "\t");
    _builder.append(" receiver) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("this.sender = sender;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.receiver = receiver;");
    _builder.newLine();
    {
      EList<Attribute> _attributes_1 = r.getAttributes();
      for(final Attribute a_1 : _attributes_1) {
        {
          boolean _isInt_1 = a_1.isInt();
          if (_isInt_1) {
            {
              AttributeValue _value = a_1.getValue();
              boolean _tripleEquals = (_value == null);
              if (_tripleEquals) {
                _builder.append("\t\t");
                String _firstLower_4 = StringExtensions.toFirstLower(a_1.getName());
                _builder.append(_firstLower_4, "\t\t");
                _builder.append(" = 0;");
                _builder.newLineIfNotEmpty();
              } else {
                _builder.append("\t\t");
                String _firstLower_5 = StringExtensions.toFirstLower(a_1.getName());
                _builder.append(_firstLower_5, "\t\t");
                _builder.append(" = ");
                String _value_1 = a_1.getValue().getValue();
                _builder.append(_value_1, "\t\t");
                _builder.append(";");
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
        {
          boolean _isFloat_1 = a_1.isFloat();
          if (_isFloat_1) {
            {
              AttributeValue _value_2 = a_1.getValue();
              boolean _tripleEquals_1 = (_value_2 == null);
              if (_tripleEquals_1) {
                _builder.append("\t\t");
                String _firstLower_6 = StringExtensions.toFirstLower(a_1.getName());
                _builder.append(_firstLower_6, "\t\t");
                _builder.append(" = 0;");
                _builder.newLineIfNotEmpty();
              } else {
                _builder.append("\t\t");
                String _firstLower_7 = StringExtensions.toFirstLower(a_1.getName());
                _builder.append(_firstLower_7, "\t\t");
                _builder.append(" = ");
                String _value_3 = a_1.getValue().getValue();
                _builder.append(_value_3, "\t\t");
                _builder.append(";");
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
        {
          boolean _isString_1 = a_1.isString();
          if (_isString_1) {
            {
              AttributeValue _value_4 = a_1.getValue();
              boolean _tripleEquals_2 = (_value_4 == null);
              if (_tripleEquals_2) {
                _builder.append("\t\t");
                String _firstLower_8 = StringExtensions.toFirstLower(a_1.getName());
                _builder.append(_firstLower_8, "\t\t");
                _builder.append(" = \"default\";");
                _builder.newLineIfNotEmpty();
              } else {
                _builder.append("\t\t");
                String _firstLower_9 = StringExtensions.toFirstLower(a_1.getName());
                _builder.append(_firstLower_9, "\t\t");
                _builder.append(" = \"");
                String _value_5 = a_1.getValue().getValue();
                _builder.append(_value_5, "\t\t");
                _builder.append("\";");
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
        {
          boolean _isBoolean_1 = a_1.isBoolean();
          if (_isBoolean_1) {
            {
              AttributeValue _value_6 = a_1.getValue();
              boolean _tripleEquals_3 = (_value_6 == null);
              if (_tripleEquals_3) {
                _builder.append("\t\t");
                String _firstLower_10 = StringExtensions.toFirstLower(a_1.getName());
                _builder.append(_firstLower_10, "\t\t");
                _builder.append(" = false;");
                _builder.newLineIfNotEmpty();
              } else {
                _builder.append("\t\t");
                String _firstLower_11 = StringExtensions.toFirstLower(a_1.getName());
                _builder.append(_firstLower_11, "\t\t");
                _builder.append(" = ");
                String _value_7 = a_1.getValue().getValue();
                _builder.append(_value_7, "\t\t");
                _builder.append(";");
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
      }
    }
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ");
    String _firstUpper_6 = StringExtensions.toFirstUpper(r.getName());
    _builder.append(_firstUpper_6, "\t");
    _builder.append("(");
    String _firstUpper_7 = StringExtensions.toFirstUpper(r.getSender().getName());
    _builder.append(_firstUpper_7, "\t");
    _builder.append(" sender, ");
    String _firstUpper_8 = StringExtensions.toFirstUpper(r.getReceiver().getName());
    _builder.append(_firstUpper_8, "\t");
    _builder.append(" receiver, EventCreator eventCreator) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("this.sender = sender;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.receiver = receiver;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.eventCreator = eventCreator;");
    _builder.newLine();
    {
      EList<Attribute> _attributes_2 = r.getAttributes();
      for(final Attribute a_2 : _attributes_2) {
        {
          boolean _isInt_2 = a_2.isInt();
          if (_isInt_2) {
            {
              AttributeValue _value_8 = a_2.getValue();
              boolean _tripleEquals_4 = (_value_8 == null);
              if (_tripleEquals_4) {
                _builder.append("\t\t");
                String _firstLower_12 = StringExtensions.toFirstLower(a_2.getName());
                _builder.append(_firstLower_12, "\t\t");
                _builder.append(" = 0;");
                _builder.newLineIfNotEmpty();
              } else {
                _builder.append("\t\t");
                String _firstLower_13 = StringExtensions.toFirstLower(a_2.getName());
                _builder.append(_firstLower_13, "\t\t");
                _builder.append(" = ");
                String _value_9 = a_2.getValue().getValue();
                _builder.append(_value_9, "\t\t");
                _builder.append(";");
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
        {
          boolean _isFloat_2 = a_2.isFloat();
          if (_isFloat_2) {
            {
              AttributeValue _value_10 = a_2.getValue();
              boolean _tripleEquals_5 = (_value_10 == null);
              if (_tripleEquals_5) {
                _builder.append("\t\t");
                String _firstLower_14 = StringExtensions.toFirstLower(a_2.getName());
                _builder.append(_firstLower_14, "\t\t");
                _builder.append(" = 0;");
                _builder.newLineIfNotEmpty();
              } else {
                _builder.append("\t\t");
                String _firstLower_15 = StringExtensions.toFirstLower(a_2.getName());
                _builder.append(_firstLower_15, "\t\t");
                _builder.append(" = ");
                String _value_11 = a_2.getValue().getValue();
                _builder.append(_value_11, "\t\t");
                _builder.append(";");
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
        {
          boolean _isString_2 = a_2.isString();
          if (_isString_2) {
            {
              AttributeValue _value_12 = a_2.getValue();
              boolean _tripleEquals_6 = (_value_12 == null);
              if (_tripleEquals_6) {
                _builder.append("\t\t");
                String _firstLower_16 = StringExtensions.toFirstLower(a_2.getName());
                _builder.append(_firstLower_16, "\t\t");
                _builder.append(" = \"default\";");
                _builder.newLineIfNotEmpty();
              } else {
                _builder.append("\t\t");
                String _firstLower_17 = StringExtensions.toFirstLower(a_2.getName());
                _builder.append(_firstLower_17, "\t\t");
                _builder.append(" = \"");
                String _value_13 = a_2.getValue().getValue();
                _builder.append(_value_13, "\t\t");
                _builder.append("\";");
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
        {
          boolean _isBoolean_2 = a_2.isBoolean();
          if (_isBoolean_2) {
            {
              AttributeValue _value_14 = a_2.getValue();
              boolean _tripleEquals_7 = (_value_14 == null);
              if (_tripleEquals_7) {
                _builder.append("\t\t");
                String _firstLower_18 = StringExtensions.toFirstLower(a_2.getName());
                _builder.append(_firstLower_18, "\t\t");
                _builder.append(" = false;");
                _builder.newLineIfNotEmpty();
              } else {
                _builder.append("\t\t");
                String _firstLower_19 = StringExtensions.toFirstLower(a_2.getName());
                _builder.append(_firstLower_19, "\t\t");
                _builder.append(" = ");
                String _value_15 = a_2.getValue().getValue();
                _builder.append(_value_15, "\t\t");
                _builder.append(";");
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
      }
    }
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    {
      EList<Attribute> _attributes_3 = r.getAttributes();
      for(final Attribute a_3 : _attributes_3) {
        {
          boolean _isInt_3 = a_3.isInt();
          if (_isInt_3) {
            _builder.append("\t");
            _builder.append("public int get");
            String _firstUpper_9 = StringExtensions.toFirstUpper(a_3.getName());
            _builder.append(_firstUpper_9, "\t");
            _builder.append("() { return ");
            String _firstLower_20 = StringExtensions.toFirstLower(a_3.getName());
            _builder.append(_firstLower_20, "\t");
            _builder.append("; }");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("public void set");
            String _firstUpper_10 = StringExtensions.toFirstUpper(a_3.getName());
            _builder.append(_firstUpper_10, "\t");
            _builder.append("(int ");
            String _firstLower_21 = StringExtensions.toFirstLower(a_3.getName());
            _builder.append(_firstLower_21, "\t");
            _builder.append(") { ");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("this.");
            String _firstLower_22 = StringExtensions.toFirstLower(a_3.getName());
            _builder.append(_firstLower_22, "\t\t");
            _builder.append(" = ");
            String _firstLower_23 = StringExtensions.toFirstLower(a_3.getName());
            _builder.append(_firstLower_23, "\t\t");
            _builder.append(";");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("eventCreator.changeTo(\"");
            String _firstUpper_11 = StringExtensions.toFirstUpper(r.getName());
            _builder.append(_firstUpper_11, "\t\t");
            _builder.append(".");
            String _firstLower_24 = StringExtensions.toFirstLower(a_3.getName());
            _builder.append(_firstLower_24, "\t\t");
            _builder.append(", \" + ");
            String _firstLower_25 = StringExtensions.toFirstLower(a_3.getName());
            _builder.append(_firstLower_25, "\t\t");
            _builder.append(");");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
          }
        }
        {
          boolean _isFloat_3 = a_3.isFloat();
          if (_isFloat_3) {
            _builder.append("\t");
            _builder.append("public float get");
            String _firstUpper_12 = StringExtensions.toFirstUpper(a_3.getName());
            _builder.append(_firstUpper_12, "\t");
            _builder.append("() { return ");
            String _firstLower_26 = StringExtensions.toFirstLower(a_3.getName());
            _builder.append(_firstLower_26, "\t");
            _builder.append("; }");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t\t\t\t\t\t");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("public void set");
            String _firstUpper_13 = StringExtensions.toFirstUpper(a_3.getName());
            _builder.append(_firstUpper_13, "\t");
            _builder.append("(float ");
            String _firstLower_27 = StringExtensions.toFirstLower(a_3.getName());
            _builder.append(_firstLower_27, "\t");
            _builder.append(") { ");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("this.");
            String _firstLower_28 = StringExtensions.toFirstLower(a_3.getName());
            _builder.append(_firstLower_28, "\t\t");
            _builder.append(" = ");
            String _firstLower_29 = StringExtensions.toFirstLower(a_3.getName());
            _builder.append(_firstLower_29, "\t\t");
            _builder.append(";");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("eventCreator.changeTo(\"");
            String _firstUpper_14 = StringExtensions.toFirstUpper(r.getName());
            _builder.append(_firstUpper_14, "\t\t");
            _builder.append(".");
            String _firstLower_30 = StringExtensions.toFirstLower(a_3.getName());
            _builder.append(_firstLower_30, "\t\t");
            _builder.append(", \" + ");
            String _firstLower_31 = StringExtensions.toFirstLower(a_3.getName());
            _builder.append(_firstLower_31, "\t\t");
            _builder.append(");");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
          }
        }
        {
          boolean _isString_3 = a_3.isString();
          if (_isString_3) {
            _builder.append("\t");
            _builder.append("public String get");
            String _firstUpper_15 = StringExtensions.toFirstUpper(a_3.getName());
            _builder.append(_firstUpper_15, "\t");
            _builder.append("() { return ");
            String _firstLower_32 = StringExtensions.toFirstLower(a_3.getName());
            _builder.append(_firstLower_32, "\t");
            _builder.append("; }");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t\t\t\t\t\t");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("public void set");
            String _firstUpper_16 = StringExtensions.toFirstUpper(a_3.getName());
            _builder.append(_firstUpper_16, "\t");
            _builder.append("(String ");
            String _firstLower_33 = StringExtensions.toFirstLower(a_3.getName());
            _builder.append(_firstLower_33, "\t");
            _builder.append(") { ");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("this.");
            String _firstLower_34 = StringExtensions.toFirstLower(a_3.getName());
            _builder.append(_firstLower_34, "\t\t");
            _builder.append(" = ");
            String _firstLower_35 = StringExtensions.toFirstLower(a_3.getName());
            _builder.append(_firstLower_35, "\t\t");
            _builder.append(";");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("eventCreator.changeTo(\"");
            String _firstUpper_17 = StringExtensions.toFirstUpper(r.getName());
            _builder.append(_firstUpper_17, "\t\t");
            _builder.append(".");
            String _firstLower_36 = StringExtensions.toFirstLower(a_3.getName());
            _builder.append(_firstLower_36, "\t\t");
            _builder.append(", \" + ");
            String _firstLower_37 = StringExtensions.toFirstLower(a_3.getName());
            _builder.append(_firstLower_37, "\t\t");
            _builder.append(");");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
          }
        }
        {
          boolean _isBoolean_3 = a_3.isBoolean();
          if (_isBoolean_3) {
            _builder.append("\t");
            _builder.append("public boolean get");
            String _firstUpper_18 = StringExtensions.toFirstUpper(a_3.getName());
            _builder.append(_firstUpper_18, "\t");
            _builder.append("() { return ");
            String _firstLower_38 = StringExtensions.toFirstLower(a_3.getName());
            _builder.append(_firstLower_38, "\t");
            _builder.append("; }");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t\t\t\t\t\t");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("public void set");
            String _firstUpper_19 = StringExtensions.toFirstUpper(a_3.getName());
            _builder.append(_firstUpper_19, "\t");
            _builder.append("(boolean ");
            String _firstLower_39 = StringExtensions.toFirstLower(a_3.getName());
            _builder.append(_firstLower_39, "\t");
            _builder.append(") { ");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("this.");
            String _firstLower_40 = StringExtensions.toFirstLower(a_3.getName());
            _builder.append(_firstLower_40, "\t\t");
            _builder.append(" = ");
            String _firstLower_41 = StringExtensions.toFirstLower(a_3.getName());
            _builder.append(_firstLower_41, "\t\t");
            _builder.append(";");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("eventCreator.changeTo(\"");
            String _firstUpper_20 = StringExtensions.toFirstUpper(r.getName());
            _builder.append(_firstUpper_20, "\t\t");
            _builder.append(".");
            String _firstLower_42 = StringExtensions.toFirstLower(a_3.getName());
            _builder.append(_firstLower_42, "\t\t");
            _builder.append(", \" + ");
            String _firstLower_43 = StringExtensions.toFirstLower(a_3.getName());
            _builder.append(_firstLower_43, "\t\t");
            _builder.append(");");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
          }
        }
      }
    }
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ");
    String _firstUpper_21 = StringExtensions.toFirstUpper(r.getSender().getName());
    _builder.append(_firstUpper_21, "\t");
    _builder.append(" getSender() { return sender; }");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ");
    String _firstUpper_22 = StringExtensions.toFirstUpper(r.getReceiver().getName());
    _builder.append(_firstUpper_22, "\t");
    _builder.append(" getReceiver() { return receiver; }");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
}
