package hu.bme.mit.dipterv.text.generator;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import hu.bme.mit.dipterv.text.minotorDsl.ContextFragment;
import hu.bme.mit.dipterv.text.minotorDsl.FEntity;
import hu.bme.mit.dipterv.text.minotorDsl.FRelation;
import hu.bme.mit.dipterv.text.minotorDsl.FragmentAttribute;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.AbstractGenerator;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.xbase.lib.ExclusiveRange;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class ContextFragmentGenerator extends AbstractGenerator {
  @Inject
  @Extension
  private IQualifiedNameProvider _iQualifiedNameProvider;
  
  @Override
  public void doGenerate(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    Iterable<ContextFragment> _filter = Iterables.<ContextFragment>filter(IteratorExtensions.<EObject>toIterable(resource.getAllContents()), ContextFragment.class);
    for (final ContextFragment m : _filter) {
      String _string = this._iQualifiedNameProvider.getFullyQualifiedName(m).toString("/");
      String _plus = (_string + ".java");
      fsa.generateFile(_plus, this.compile(m));
    }
  }
  
  public CharSequence compile(final ContextFragment m) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public class ");
    String _firstUpper = StringExtensions.toFirstUpper(m.getName());
    _builder.append(_firstUpper);
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("public boolean match(");
    _builder.newLine();
    {
      int _size = m.getEntities().size();
      ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size, true);
      for(final Integer e : _doubleDotLessThan) {
        _builder.append("\t\t");
        String _firstUpper_1 = StringExtensions.toFirstUpper(m.getEntities().get((e).intValue()).getName());
        _builder.append(_firstUpper_1, "\t\t");
        _builder.append(" ");
        String _firstLower = StringExtensions.toFirstLower(m.getEntities().get((e).intValue()).getName());
        _builder.append(_firstLower, "\t\t");
        _builder.newLineIfNotEmpty();
        {
          if ((((e).intValue() != (m.getEntities().size() - 1)) || (m.getRelations().size() > 0))) {
            _builder.append("\t\t");
            _builder.append(",");
            _builder.newLine();
          }
        }
      }
    }
    {
      int _size_1 = m.getRelations().size();
      ExclusiveRange _doubleDotLessThan_1 = new ExclusiveRange(0, _size_1, true);
      for(final Integer r : _doubleDotLessThan_1) {
        _builder.append("\t\t");
        String _firstUpper_2 = StringExtensions.toFirstUpper(m.getRelations().get((r).intValue()).getName());
        _builder.append(_firstUpper_2, "\t\t");
        _builder.append(" ");
        String _firstLower_1 = StringExtensions.toFirstLower(m.getRelations().get((r).intValue()).getName());
        _builder.append(_firstLower_1, "\t\t");
        _builder.newLineIfNotEmpty();
        {
          int _size_2 = m.getRelations().size();
          int _minus = (_size_2 - 1);
          boolean _notEquals = ((r).intValue() != _minus);
          if (_notEquals) {
            _builder.append("\t\t");
            _builder.append(",");
            _builder.newLine();
          }
        }
      }
    }
    _builder.append("\t");
    _builder.append(") {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if(");
    _builder.newLine();
    {
      int _size_3 = m.getEntities().size();
      ExclusiveRange _doubleDotLessThan_2 = new ExclusiveRange(0, _size_3, true);
      for(final Integer e_1 : _doubleDotLessThan_2) {
        _builder.append("\t\t\t");
        _builder.append("check");
        String _firstUpper_3 = StringExtensions.toFirstUpper(m.getEntities().get((e_1).intValue()).getName());
        _builder.append(_firstUpper_3, "\t\t\t");
        _builder.append("Constraint(");
        _builder.newLineIfNotEmpty();
        {
          EList<FEntity> _entities = m.getEntities();
          for(final FEntity entity : _entities) {
            {
              String _firstLower_2 = StringExtensions.toFirstLower(m.getEntities().get((e_1).intValue()).getName());
              String _firstLower_3 = StringExtensions.toFirstLower(entity.getName());
              boolean _equals = Objects.equal(_firstLower_2, _firstLower_3);
              if (_equals) {
                _builder.append("\t\t\t");
                _builder.append("\t");
                String _firstLower_4 = StringExtensions.toFirstLower(entity.getName());
                _builder.append(_firstLower_4, "\t\t\t\t");
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
        _builder.append("\t\t\t");
        _builder.append(")");
        _builder.newLine();
        {
          if ((((e_1).intValue() != (m.getEntities().size() - 1)) || (m.getRelations().size() != 0))) {
            _builder.append("\t\t\t");
            _builder.append("&&");
            _builder.newLine();
          }
        }
      }
    }
    {
      int _size_4 = m.getRelations().size();
      ExclusiveRange _doubleDotLessThan_3 = new ExclusiveRange(0, _size_4, true);
      for(final Integer r_1 : _doubleDotLessThan_3) {
        _builder.append("\t\t\t");
        _builder.append("\t");
        _builder.append("check");
        String _firstUpper_4 = StringExtensions.toFirstUpper(m.getRelations().get((r_1).intValue()).getName());
        _builder.append(_firstUpper_4, "\t\t\t\t");
        _builder.append("Constraint(");
        _builder.newLineIfNotEmpty();
        {
          EList<FRelation> _relations = m.getRelations();
          for(final FRelation relation : _relations) {
            {
              String _firstLower_5 = StringExtensions.toFirstLower(m.getRelations().get((r_1).intValue()).getName());
              String _firstLower_6 = StringExtensions.toFirstLower(relation.getName());
              boolean _equals_1 = Objects.equal(_firstLower_5, _firstLower_6);
              if (_equals_1) {
                _builder.append("\t\t\t");
                _builder.append("\t");
                String _firstLower_7 = StringExtensions.toFirstLower(relation.getName());
                _builder.append(_firstLower_7, "\t\t\t\t");
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
        _builder.append("\t\t\t");
        _builder.append(")");
        _builder.newLine();
        {
          int _size_5 = m.getRelations().size();
          int _minus_1 = (_size_5 - 1);
          boolean _notEquals_1 = ((r_1).intValue() != _minus_1);
          if (_notEquals_1) {
            _builder.append("\t\t\t");
            _builder.append("\t");
            _builder.append("&&");
            _builder.newLine();
          }
        }
      }
    }
    _builder.append("\t\t");
    _builder.append(") {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("return true;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return false;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    {
      EList<FEntity> _entities_1 = m.getEntities();
      for(final FEntity e_2 : _entities_1) {
        _builder.append("\t");
        _builder.append("public boolean check");
        String _firstUpper_5 = StringExtensions.toFirstUpper(e_2.getName());
        _builder.append(_firstUpper_5, "\t");
        _builder.append("Constraint(");
        String _firstUpper_6 = StringExtensions.toFirstUpper(e_2.getName());
        _builder.append(_firstUpper_6, "\t");
        _builder.append(" ");
        String _firstLower_8 = StringExtensions.toFirstLower(e_2.getName());
        _builder.append(_firstLower_8, "\t");
        _builder.append(") {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("if (");
        {
          EList<FragmentAttribute> _attributes = e_2.getAttributes();
          for(final FragmentAttribute a : _attributes) {
            _builder.newLineIfNotEmpty();
            {
              boolean _isInt = a.isInt();
              if (_isInt) {
                {
                  boolean _isGreater = a.isGreater();
                  if (_isGreater) {
                    _builder.append("\t");
                    _builder.append("\t");
                    String _firstLower_9 = StringExtensions.toFirstLower(e_2.getName());
                    _builder.append(_firstLower_9, "\t\t");
                    _builder.append(".get");
                    String _firstUpper_7 = StringExtensions.toFirstUpper(a.getName());
                    _builder.append(_firstUpper_7, "\t\t");
                    _builder.append("() > ");
                    String _value = a.getValue().getValue();
                    _builder.append(_value, "\t\t");
                    _builder.newLineIfNotEmpty();
                  }
                }
                {
                  boolean _isSmaller = a.isSmaller();
                  if (_isSmaller) {
                    _builder.append("\t");
                    _builder.append("\t");
                    String _firstLower_10 = StringExtensions.toFirstLower(e_2.getName());
                    _builder.append(_firstLower_10, "\t\t");
                    _builder.append(".get");
                    String _firstUpper_8 = StringExtensions.toFirstUpper(a.getName());
                    _builder.append(_firstUpper_8, "\t\t");
                    _builder.append("() < ");
                    String _value_1 = a.getValue().getValue();
                    _builder.append(_value_1, "\t\t");
                    _builder.newLineIfNotEmpty();
                  }
                }
                {
                  boolean _isGreaterequals = a.isGreaterequals();
                  if (_isGreaterequals) {
                    _builder.append("\t");
                    _builder.append("\t");
                    String _firstLower_11 = StringExtensions.toFirstLower(e_2.getName());
                    _builder.append(_firstLower_11, "\t\t");
                    _builder.append(".get");
                    String _firstUpper_9 = StringExtensions.toFirstUpper(a.getName());
                    _builder.append(_firstUpper_9, "\t\t");
                    _builder.append("()>= ");
                    String _value_2 = a.getValue().getValue();
                    _builder.append(_value_2, "\t\t");
                    _builder.newLineIfNotEmpty();
                  }
                }
                {
                  boolean _isSmallerequals = a.isSmallerequals();
                  if (_isSmallerequals) {
                    _builder.append("\t");
                    _builder.append("\t");
                    String _firstLower_12 = StringExtensions.toFirstLower(e_2.getName());
                    _builder.append(_firstLower_12, "\t\t");
                    _builder.append(".get");
                    String _firstUpper_10 = StringExtensions.toFirstUpper(a.getName());
                    _builder.append(_firstUpper_10, "\t\t");
                    _builder.append("() <= ");
                    String _value_3 = a.getValue().getValue();
                    _builder.append(_value_3, "\t\t");
                    _builder.newLineIfNotEmpty();
                  }
                }
                {
                  boolean _isEquals = a.isEquals();
                  if (_isEquals) {
                    _builder.append("\t");
                    _builder.append("\t");
                    String _firstLower_13 = StringExtensions.toFirstLower(e_2.getName());
                    _builder.append(_firstLower_13, "\t\t");
                    _builder.append(".get");
                    String _firstUpper_11 = StringExtensions.toFirstUpper(a.getName());
                    _builder.append(_firstUpper_11, "\t\t");
                    _builder.append("().equals(");
                    String _value_4 = a.getValue().getValue();
                    _builder.append(_value_4, "\t\t");
                    _builder.append(")");
                    _builder.newLineIfNotEmpty();
                  }
                }
                {
                  boolean _isNotequals = a.isNotequals();
                  if (_isNotequals) {
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("!");
                    String _firstLower_14 = StringExtensions.toFirstLower(e_2.getName());
                    _builder.append(_firstLower_14, "\t\t");
                    _builder.append(".get");
                    String _firstUpper_12 = StringExtensions.toFirstUpper(a.getName());
                    _builder.append(_firstUpper_12, "\t\t");
                    _builder.append("().equals(");
                    String _value_5 = a.getValue().getValue();
                    _builder.append(_value_5, "\t\t");
                    _builder.append(")");
                    _builder.newLineIfNotEmpty();
                  }
                }
              }
            }
            {
              boolean _isFloat = a.isFloat();
              if (_isFloat) {
                {
                  boolean _isGreater_1 = a.isGreater();
                  if (_isGreater_1) {
                    _builder.append("\t");
                    _builder.append("\t");
                    String _firstLower_15 = StringExtensions.toFirstLower(e_2.getName());
                    _builder.append(_firstLower_15, "\t\t");
                    _builder.append(".get");
                    String _firstUpper_13 = StringExtensions.toFirstUpper(a.getName());
                    _builder.append(_firstUpper_13, "\t\t");
                    _builder.append("() > ");
                    String _value_6 = a.getValue().getValue();
                    _builder.append(_value_6, "\t\t");
                    _builder.newLineIfNotEmpty();
                  }
                }
                {
                  boolean _isSmaller_1 = a.isSmaller();
                  if (_isSmaller_1) {
                    _builder.append("\t");
                    _builder.append("\t");
                    String _firstLower_16 = StringExtensions.toFirstLower(e_2.getName());
                    _builder.append(_firstLower_16, "\t\t");
                    _builder.append(".get");
                    String _firstUpper_14 = StringExtensions.toFirstUpper(a.getName());
                    _builder.append(_firstUpper_14, "\t\t");
                    _builder.append("() < ");
                    String _value_7 = a.getValue().getValue();
                    _builder.append(_value_7, "\t\t");
                    _builder.newLineIfNotEmpty();
                  }
                }
                {
                  boolean _isGreaterequals_1 = a.isGreaterequals();
                  if (_isGreaterequals_1) {
                    _builder.append("\t");
                    _builder.append("\t");
                    String _firstLower_17 = StringExtensions.toFirstLower(e_2.getName());
                    _builder.append(_firstLower_17, "\t\t");
                    _builder.append(".get");
                    String _firstUpper_15 = StringExtensions.toFirstUpper(a.getName());
                    _builder.append(_firstUpper_15, "\t\t");
                    _builder.append("()>= ");
                    String _value_8 = a.getValue().getValue();
                    _builder.append(_value_8, "\t\t");
                    _builder.newLineIfNotEmpty();
                  }
                }
                {
                  boolean _isSmallerequals_1 = a.isSmallerequals();
                  if (_isSmallerequals_1) {
                    _builder.append("\t");
                    _builder.append("\t");
                    String _firstLower_18 = StringExtensions.toFirstLower(e_2.getName());
                    _builder.append(_firstLower_18, "\t\t");
                    _builder.append(".get");
                    String _firstUpper_16 = StringExtensions.toFirstUpper(a.getName());
                    _builder.append(_firstUpper_16, "\t\t");
                    _builder.append("() <= ");
                    String _value_9 = a.getValue().getValue();
                    _builder.append(_value_9, "\t\t");
                    _builder.newLineIfNotEmpty();
                  }
                }
                {
                  boolean _isEquals_1 = a.isEquals();
                  if (_isEquals_1) {
                    _builder.append("\t");
                    _builder.append("\t");
                    String _firstLower_19 = StringExtensions.toFirstLower(e_2.getName());
                    _builder.append(_firstLower_19, "\t\t");
                    _builder.append(".get");
                    String _firstUpper_17 = StringExtensions.toFirstUpper(a.getName());
                    _builder.append(_firstUpper_17, "\t\t");
                    _builder.append("().equals(");
                    String _value_10 = a.getValue().getValue();
                    _builder.append(_value_10, "\t\t");
                    _builder.append(")");
                    _builder.newLineIfNotEmpty();
                  }
                }
                {
                  boolean _isNotequals_1 = a.isNotequals();
                  if (_isNotequals_1) {
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("!");
                    String _firstLower_20 = StringExtensions.toFirstLower(e_2.getName());
                    _builder.append(_firstLower_20, "\t\t");
                    _builder.append(".get");
                    String _firstUpper_18 = StringExtensions.toFirstUpper(a.getName());
                    _builder.append(_firstUpper_18, "\t\t");
                    _builder.append("().equals(");
                    String _value_11 = a.getValue().getValue();
                    _builder.append(_value_11, "\t\t");
                    _builder.append(")");
                    _builder.newLineIfNotEmpty();
                  }
                }
              }
            }
            {
              boolean _isString = a.isString();
              if (_isString) {
                {
                  boolean _isEquals_2 = a.isEquals();
                  if (_isEquals_2) {
                    _builder.append("\t");
                    _builder.append("\t");
                    String _firstLower_21 = StringExtensions.toFirstLower(e_2.getName());
                    _builder.append(_firstLower_21, "\t\t");
                    _builder.append(".get");
                    String _firstUpper_19 = StringExtensions.toFirstUpper(a.getName());
                    _builder.append(_firstUpper_19, "\t\t");
                    _builder.append("().equals(\"");
                    String _value_12 = a.getValue().getValue();
                    _builder.append(_value_12, "\t\t");
                    _builder.append("\")");
                    _builder.newLineIfNotEmpty();
                  }
                }
                {
                  boolean _isNotequals_2 = a.isNotequals();
                  if (_isNotequals_2) {
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("!");
                    String _firstLower_22 = StringExtensions.toFirstLower(e_2.getName());
                    _builder.append(_firstLower_22, "\t\t");
                    _builder.append(".get");
                    String _firstUpper_20 = StringExtensions.toFirstUpper(a.getName());
                    _builder.append(_firstUpper_20, "\t\t");
                    _builder.append("().equals(\"");
                    String _value_13 = a.getValue().getValue();
                    _builder.append(_value_13, "\t\t");
                    _builder.append("\")");
                    _builder.newLineIfNotEmpty();
                  }
                }
              }
            }
            {
              boolean _isBoolean = a.isBoolean();
              if (_isBoolean) {
                {
                  boolean _isEquals_3 = a.isEquals();
                  if (_isEquals_3) {
                    _builder.append("\t");
                    _builder.append("\t");
                    String _firstLower_23 = StringExtensions.toFirstLower(e_2.getName());
                    _builder.append(_firstLower_23, "\t\t");
                    _builder.append(".get");
                    String _firstUpper_21 = StringExtensions.toFirstUpper(a.getName());
                    _builder.append(_firstUpper_21, "\t\t");
                    _builder.append("().equals(");
                    String _value_14 = a.getValue().getValue();
                    _builder.append(_value_14, "\t\t");
                    _builder.append(")");
                    _builder.newLineIfNotEmpty();
                  }
                }
                {
                  boolean _isNotequals_3 = a.isNotequals();
                  if (_isNotequals_3) {
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("!");
                    String _firstLower_24 = StringExtensions.toFirstLower(e_2.getName());
                    _builder.append(_firstLower_24, "\t\t");
                    _builder.append(".get");
                    String _firstUpper_22 = StringExtensions.toFirstUpper(a.getName());
                    _builder.append(_firstUpper_22, "\t\t");
                    _builder.append("().equals(");
                    String _value_15 = a.getValue().getValue();
                    _builder.append(_value_15, "\t\t");
                    _builder.append(")");
                    _builder.newLineIfNotEmpty();
                  }
                }
                _builder.append("\t\t\t\t\t\t\t");
              }
            }
            _builder.append(" &&");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t");
        _builder.append("\t\t");
        String _firstLower_25 = StringExtensions.toFirstLower(e_2.getName());
        _builder.append(_firstLower_25, "\t\t\t");
        _builder.append(".getExists()) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t\t");
        _builder.append("return true;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("return false;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
      }
    }
    {
      EList<FRelation> _relations_1 = m.getRelations();
      for(final FRelation r_2 : _relations_1) {
        _builder.append("\t");
        _builder.append("public boolean check");
        String _firstUpper_23 = StringExtensions.toFirstUpper(r_2.getName());
        _builder.append(_firstUpper_23, "\t");
        _builder.append("Constraint(");
        String _firstUpper_24 = StringExtensions.toFirstUpper(r_2.getName());
        _builder.append(_firstUpper_24, "\t");
        _builder.append(" ");
        String _firstLower_26 = StringExtensions.toFirstLower(r_2.getName());
        _builder.append(_firstLower_26, "\t");
        _builder.append(") {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("if (");
        {
          int _size_6 = r_2.getAttributes().size();
          ExclusiveRange _doubleDotLessThan_4 = new ExclusiveRange(0, _size_6, true);
          for(final Integer a_1 : _doubleDotLessThan_4) {
            _builder.newLineIfNotEmpty();
            {
              boolean _isInt_1 = r_2.getAttributes().get((a_1).intValue()).isInt();
              if (_isInt_1) {
                {
                  boolean _isGreater_2 = r_2.getAttributes().get((a_1).intValue()).isGreater();
                  if (_isGreater_2) {
                    _builder.append("\t");
                    _builder.append("\t");
                    String _firstLower_27 = StringExtensions.toFirstLower(r_2.getName());
                    _builder.append(_firstLower_27, "\t\t");
                    _builder.append(".get");
                    String _firstUpper_25 = StringExtensions.toFirstUpper(r_2.getAttributes().get((a_1).intValue()).getName());
                    _builder.append(_firstUpper_25, "\t\t");
                    _builder.append("() > ");
                    String _value_16 = r_2.getAttributes().get((a_1).intValue()).getValue().getValue();
                    _builder.append(_value_16, "\t\t");
                    _builder.newLineIfNotEmpty();
                  }
                }
                {
                  boolean _isSmaller_2 = r_2.getAttributes().get((a_1).intValue()).isSmaller();
                  if (_isSmaller_2) {
                    _builder.append("\t");
                    _builder.append("\t");
                    String _firstLower_28 = StringExtensions.toFirstLower(r_2.getName());
                    _builder.append(_firstLower_28, "\t\t");
                    _builder.append(".get");
                    String _firstUpper_26 = StringExtensions.toFirstUpper(r_2.getAttributes().get((a_1).intValue()).getName());
                    _builder.append(_firstUpper_26, "\t\t");
                    _builder.append("() < ");
                    String _value_17 = r_2.getAttributes().get((a_1).intValue()).getValue().getValue();
                    _builder.append(_value_17, "\t\t");
                    _builder.newLineIfNotEmpty();
                  }
                }
                {
                  boolean _isGreaterequals_2 = r_2.getAttributes().get((a_1).intValue()).isGreaterequals();
                  if (_isGreaterequals_2) {
                    _builder.append("\t");
                    _builder.append("\t");
                    String _firstLower_29 = StringExtensions.toFirstLower(r_2.getName());
                    _builder.append(_firstLower_29, "\t\t");
                    _builder.append(".get");
                    String _firstUpper_27 = StringExtensions.toFirstUpper(r_2.getAttributes().get((a_1).intValue()).getName());
                    _builder.append(_firstUpper_27, "\t\t");
                    _builder.append("()>= ");
                    String _value_18 = r_2.getAttributes().get((a_1).intValue()).getValue().getValue();
                    _builder.append(_value_18, "\t\t");
                    _builder.newLineIfNotEmpty();
                  }
                }
                {
                  boolean _isSmallerequals_2 = r_2.getAttributes().get((a_1).intValue()).isSmallerequals();
                  if (_isSmallerequals_2) {
                    _builder.append("\t");
                    _builder.append("\t");
                    String _firstLower_30 = StringExtensions.toFirstLower(r_2.getName());
                    _builder.append(_firstLower_30, "\t\t");
                    _builder.append(".get");
                    String _firstUpper_28 = StringExtensions.toFirstUpper(r_2.getAttributes().get((a_1).intValue()).getName());
                    _builder.append(_firstUpper_28, "\t\t");
                    _builder.append("() <= ");
                    String _value_19 = r_2.getAttributes().get((a_1).intValue()).getValue().getValue();
                    _builder.append(_value_19, "\t\t");
                    _builder.newLineIfNotEmpty();
                  }
                }
                {
                  boolean _isEquals_4 = r_2.getAttributes().get((a_1).intValue()).isEquals();
                  if (_isEquals_4) {
                    _builder.append("\t");
                    _builder.append("\t");
                    String _firstLower_31 = StringExtensions.toFirstLower(r_2.getName());
                    _builder.append(_firstLower_31, "\t\t");
                    _builder.append(".get");
                    String _firstUpper_29 = StringExtensions.toFirstUpper(r_2.getAttributes().get((a_1).intValue()).getName());
                    _builder.append(_firstUpper_29, "\t\t");
                    _builder.append("().equals(");
                    String _value_20 = r_2.getAttributes().get((a_1).intValue()).getValue().getValue();
                    _builder.append(_value_20, "\t\t");
                    _builder.append(")");
                    _builder.newLineIfNotEmpty();
                  }
                }
                {
                  boolean _isNotequals_4 = r_2.getAttributes().get((a_1).intValue()).isNotequals();
                  if (_isNotequals_4) {
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("!");
                    String _firstLower_32 = StringExtensions.toFirstLower(r_2.getName());
                    _builder.append(_firstLower_32, "\t\t");
                    _builder.append(".get");
                    String _firstUpper_30 = StringExtensions.toFirstUpper(r_2.getAttributes().get((a_1).intValue()).getName());
                    _builder.append(_firstUpper_30, "\t\t");
                    _builder.append("().equals(");
                    String _value_21 = r_2.getAttributes().get((a_1).intValue()).getValue().getValue();
                    _builder.append(_value_21, "\t\t");
                    _builder.append(")");
                    _builder.newLineIfNotEmpty();
                  }
                }
              }
            }
            {
              boolean _isFloat_1 = r_2.getAttributes().get((a_1).intValue()).isFloat();
              if (_isFloat_1) {
                {
                  boolean _isGreater_3 = r_2.getAttributes().get((a_1).intValue()).isGreater();
                  if (_isGreater_3) {
                    _builder.append("\t");
                    _builder.append("\t");
                    String _firstLower_33 = StringExtensions.toFirstLower(r_2.getName());
                    _builder.append(_firstLower_33, "\t\t");
                    _builder.append(".get");
                    String _firstUpper_31 = StringExtensions.toFirstUpper(r_2.getAttributes().get((a_1).intValue()).getName());
                    _builder.append(_firstUpper_31, "\t\t");
                    _builder.append("() > ");
                    String _value_22 = r_2.getAttributes().get((a_1).intValue()).getValue().getValue();
                    _builder.append(_value_22, "\t\t");
                    _builder.newLineIfNotEmpty();
                  }
                }
                {
                  boolean _isSmaller_3 = r_2.getAttributes().get((a_1).intValue()).isSmaller();
                  if (_isSmaller_3) {
                    _builder.append("\t");
                    _builder.append("\t");
                    String _firstLower_34 = StringExtensions.toFirstLower(r_2.getName());
                    _builder.append(_firstLower_34, "\t\t");
                    _builder.append(".get");
                    String _firstUpper_32 = StringExtensions.toFirstUpper(r_2.getAttributes().get((a_1).intValue()).getName());
                    _builder.append(_firstUpper_32, "\t\t");
                    _builder.append("() < ");
                    String _value_23 = r_2.getAttributes().get((a_1).intValue()).getValue().getValue();
                    _builder.append(_value_23, "\t\t");
                    _builder.newLineIfNotEmpty();
                  }
                }
                {
                  boolean _isGreaterequals_3 = r_2.getAttributes().get((a_1).intValue()).isGreaterequals();
                  if (_isGreaterequals_3) {
                    _builder.append("\t");
                    _builder.append("\t");
                    String _firstLower_35 = StringExtensions.toFirstLower(r_2.getName());
                    _builder.append(_firstLower_35, "\t\t");
                    _builder.append(".get");
                    String _firstUpper_33 = StringExtensions.toFirstUpper(r_2.getAttributes().get((a_1).intValue()).getName());
                    _builder.append(_firstUpper_33, "\t\t");
                    _builder.append("()>= ");
                    String _value_24 = r_2.getAttributes().get((a_1).intValue()).getValue().getValue();
                    _builder.append(_value_24, "\t\t");
                    _builder.newLineIfNotEmpty();
                  }
                }
                {
                  boolean _isSmallerequals_3 = r_2.getAttributes().get((a_1).intValue()).isSmallerequals();
                  if (_isSmallerequals_3) {
                    _builder.append("\t");
                    _builder.append("\t");
                    String _firstLower_36 = StringExtensions.toFirstLower(r_2.getName());
                    _builder.append(_firstLower_36, "\t\t");
                    _builder.append(".get");
                    String _firstUpper_34 = StringExtensions.toFirstUpper(r_2.getAttributes().get((a_1).intValue()).getName());
                    _builder.append(_firstUpper_34, "\t\t");
                    _builder.append("() <= ");
                    String _value_25 = r_2.getAttributes().get((a_1).intValue()).getValue().getValue();
                    _builder.append(_value_25, "\t\t");
                    _builder.newLineIfNotEmpty();
                  }
                }
                {
                  boolean _isEquals_5 = r_2.getAttributes().get((a_1).intValue()).isEquals();
                  if (_isEquals_5) {
                    _builder.append("\t");
                    _builder.append("\t");
                    String _firstLower_37 = StringExtensions.toFirstLower(r_2.getName());
                    _builder.append(_firstLower_37, "\t\t");
                    _builder.append(".get");
                    String _firstUpper_35 = StringExtensions.toFirstUpper(r_2.getAttributes().get((a_1).intValue()).getName());
                    _builder.append(_firstUpper_35, "\t\t");
                    _builder.append("().equals(");
                    String _value_26 = r_2.getAttributes().get((a_1).intValue()).getValue().getValue();
                    _builder.append(_value_26, "\t\t");
                    _builder.append(")");
                    _builder.newLineIfNotEmpty();
                  }
                }
                {
                  boolean _isNotequals_5 = r_2.getAttributes().get((a_1).intValue()).isNotequals();
                  if (_isNotequals_5) {
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("!");
                    String _firstLower_38 = StringExtensions.toFirstLower(r_2.getName());
                    _builder.append(_firstLower_38, "\t\t");
                    _builder.append(".get");
                    String _firstUpper_36 = StringExtensions.toFirstUpper(r_2.getAttributes().get((a_1).intValue()).getName());
                    _builder.append(_firstUpper_36, "\t\t");
                    _builder.append("().equals(");
                    String _value_27 = r_2.getAttributes().get((a_1).intValue()).getValue().getValue();
                    _builder.append(_value_27, "\t\t");
                    _builder.append(")");
                    _builder.newLineIfNotEmpty();
                  }
                }
              }
            }
            {
              boolean _isString_1 = r_2.getAttributes().get((a_1).intValue()).isString();
              if (_isString_1) {
                {
                  boolean _isEquals_6 = r_2.getAttributes().get((a_1).intValue()).isEquals();
                  if (_isEquals_6) {
                    _builder.append("\t");
                    _builder.append("\t");
                    String _firstLower_39 = StringExtensions.toFirstLower(r_2.getName());
                    _builder.append(_firstLower_39, "\t\t");
                    _builder.append(".get");
                    String _firstUpper_37 = StringExtensions.toFirstUpper(r_2.getAttributes().get((a_1).intValue()).getName());
                    _builder.append(_firstUpper_37, "\t\t");
                    _builder.append("().equals(\"");
                    String _value_28 = r_2.getAttributes().get((a_1).intValue()).getValue().getValue();
                    _builder.append(_value_28, "\t\t");
                    _builder.append("\")");
                    _builder.newLineIfNotEmpty();
                  }
                }
                {
                  boolean _isNotequals_6 = r_2.getAttributes().get((a_1).intValue()).isNotequals();
                  if (_isNotequals_6) {
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("!");
                    String _firstLower_40 = StringExtensions.toFirstLower(r_2.getName());
                    _builder.append(_firstLower_40, "\t\t");
                    _builder.append(".get");
                    String _firstUpper_38 = StringExtensions.toFirstUpper(r_2.getAttributes().get((a_1).intValue()).getName());
                    _builder.append(_firstUpper_38, "\t\t");
                    _builder.append("().equals(\"");
                    String _value_29 = r_2.getAttributes().get((a_1).intValue()).getValue().getValue();
                    _builder.append(_value_29, "\t\t");
                    _builder.append("\")");
                    _builder.newLineIfNotEmpty();
                  }
                }
              }
            }
            {
              boolean _isBoolean_1 = r_2.getAttributes().get((a_1).intValue()).isBoolean();
              if (_isBoolean_1) {
                {
                  boolean _equals_2 = this.equals(a_1);
                  if (_equals_2) {
                    _builder.append("\t");
                    _builder.append("\t");
                    String _firstLower_41 = StringExtensions.toFirstLower(r_2.getName());
                    _builder.append(_firstLower_41, "\t\t");
                    _builder.append(".get");
                    String _firstUpper_39 = StringExtensions.toFirstUpper(r_2.getAttributes().get((a_1).intValue()).getName());
                    _builder.append(_firstUpper_39, "\t\t");
                    _builder.append("().equals(");
                    String _value_30 = r_2.getAttributes().get((a_1).intValue()).getValue().getValue();
                    _builder.append(_value_30, "\t\t");
                    _builder.append(")");
                    _builder.newLineIfNotEmpty();
                  }
                }
                {
                  boolean _isNotequals_7 = r_2.getAttributes().get((a_1).intValue()).isNotequals();
                  if (_isNotequals_7) {
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("!");
                    String _firstLower_42 = StringExtensions.toFirstLower(r_2.getName());
                    _builder.append(_firstLower_42, "\t\t");
                    _builder.append(".get");
                    String _firstUpper_40 = StringExtensions.toFirstUpper(r_2.getAttributes().get((a_1).intValue()).getName());
                    _builder.append(_firstUpper_40, "\t\t");
                    _builder.append("().equals(");
                    String _value_31 = r_2.getAttributes().get((a_1).intValue()).getValue().getValue();
                    _builder.append(_value_31, "\t\t");
                    _builder.append(")");
                    _builder.newLineIfNotEmpty();
                  }
                }
              }
            }
            _builder.append("\t");
            _builder.append("\t");
            {
              int _size_7 = r_2.getAttributes().size();
              int _minus_2 = (_size_7 - 1);
              boolean _notEquals_2 = ((a_1).intValue() != _minus_2);
              if (_notEquals_2) {
                _builder.append(" && ");
              }
            }
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t\t\t\t\t");
          }
        }
        _builder.append(" ){");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t\t");
        _builder.append("return true;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("return false;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
}
