package hu.bme.mit.dipterv.text.generator;

import com.google.common.collect.Iterables;
import hu.bme.mit.dipterv.text.minotorDsl.ContextFragment;
import hu.bme.mit.dipterv.text.minotorDsl.Domain;
import hu.bme.mit.dipterv.text.minotorDsl.Include;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.AbstractGenerator;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;
import org.eclipse.xtext.xbase.lib.ExclusiveRange;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class EventCreatorGenerator extends AbstractGenerator {
  @Override
  public void doGenerate(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    Iterable<Domain> _filter = Iterables.<Domain>filter(IteratorExtensions.<EObject>toIterable(resource.getAllContents()), Domain.class);
    for (final Domain m : _filter) {
      fsa.generateFile(
        "EventCreator.java", this.compile_eventcreator(m));
    }
  }
  
  public CharSequence compile_eventcreator(final Domain d) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public class EventCreator {");
    _builder.newLine();
    {
      EList<Include> _includes = d.getIncludes();
      for(final Include i : _includes) {
        _builder.append("\t");
        _builder.append("private ");
        String _firstUpper = StringExtensions.toFirstUpper(i.getContext().getName());
        _builder.append(_firstUpper, "\t");
        _builder.append(" ");
        String _firstLower = StringExtensions.toFirstLower(i.getContext().getName());
        _builder.append(_firstLower, "\t");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      EList<ContextFragment> _contextfragments = d.getContextfragments();
      for(final ContextFragment f : _contextfragments) {
        _builder.append("\t");
        _builder.append("private ");
        String _firstUpper_1 = StringExtensions.toFirstUpper(f.getName());
        _builder.append(_firstUpper_1, "\t");
        _builder.append(" ");
        String _firstLower_1 = StringExtensions.toFirstLower(f.getName());
        _builder.append(_firstLower_1, "\t");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.append("private Monitor monitorInterface;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public EventCreator(");
    _builder.newLine();
    {
      EList<Include> _includes_1 = d.getIncludes();
      for(final Include i_1 : _includes_1) {
        _builder.append("\t\t");
        String _firstUpper_2 = StringExtensions.toFirstUpper(i_1.getContext().getName());
        _builder.append(_firstUpper_2, "\t\t");
        _builder.append(" ");
        String _firstLower_2 = StringExtensions.toFirstLower(i_1.getContext().getName());
        _builder.append(_firstLower_2, "\t\t");
        _builder.append(",");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      EList<ContextFragment> _contextfragments_1 = d.getContextfragments();
      for(final ContextFragment f_1 : _contextfragments_1) {
        _builder.append("\t\t");
        String _firstUpper_3 = StringExtensions.toFirstUpper(f_1.getName());
        _builder.append(_firstUpper_3, "\t\t");
        _builder.append(" ");
        String _firstLower_3 = StringExtensions.toFirstLower(f_1.getName());
        _builder.append(_firstLower_3, "\t\t");
        _builder.append(",");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t");
    _builder.append("Monitor monitorInterface");
    _builder.newLine();
    _builder.append("\t");
    _builder.append(") {");
    _builder.newLine();
    {
      EList<Include> _includes_2 = d.getIncludes();
      for(final Include i_2 : _includes_2) {
        _builder.append("\t\t");
        _builder.append("this.");
        String _firstLower_4 = StringExtensions.toFirstLower(i_2.getContext().getName());
        _builder.append(_firstLower_4, "\t\t");
        _builder.append(" = ");
        String _firstLower_5 = StringExtensions.toFirstLower(i_2.getContext().getName());
        _builder.append(_firstLower_5, "\t\t");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      EList<ContextFragment> _contextfragments_2 = d.getContextfragments();
      for(final ContextFragment f_2 : _contextfragments_2) {
        _builder.append("\t\t");
        _builder.append("this.");
        String _firstLower_6 = StringExtensions.toFirstLower(f_2.getName());
        _builder.append(_firstLower_6, "\t\t");
        _builder.append(" = ");
        String _firstLower_7 = StringExtensions.toFirstLower(f_2.getName());
        _builder.append(_firstLower_7, "\t\t");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t");
    _builder.append("this.monitorInterface = monitorInterface;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    {
      EList<Include> _includes_3 = d.getIncludes();
      for(final Include i_3 : _includes_3) {
        _builder.append("\t");
        _builder.append("public void set");
        String _firstUpper_4 = StringExtensions.toFirstUpper(i_3.getContext().getName());
        _builder.append(_firstUpper_4, "\t");
        _builder.append("(");
        String _firstUpper_5 = StringExtensions.toFirstUpper(i_3.getContext().getName());
        _builder.append(_firstUpper_5, "\t");
        _builder.append(" ");
        String _firstLower_8 = StringExtensions.toFirstLower(i_3.getContext().getName());
        _builder.append(_firstLower_8, "\t");
        _builder.append(") {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("this.");
        String _firstLower_9 = StringExtensions.toFirstLower(i_3.getContext().getName());
        _builder.append(_firstLower_9, "\t\t");
        _builder.append(" = ");
        String _firstLower_10 = StringExtensions.toFirstLower(i_3.getContext().getName());
        _builder.append(_firstLower_10, "\t\t");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void appear(String name) {");
    _builder.newLine();
    {
      EList<Include> _includes_4 = d.getIncludes();
      for(final Include m : _includes_4) {
        _builder.append("\t\t");
        _builder.append("monitorInterface.update(\"appear(");
        String _firstUpper_6 = StringExtensions.toFirstUpper(m.getContext().getName());
        _builder.append(_firstUpper_6, "\t\t");
        _builder.append(".\" + name + \")\");");
        _builder.newLineIfNotEmpty();
        {
          EList<ContextFragment> _contextfragments_3 = d.getContextfragments();
          for(final ContextFragment f_3 : _contextfragments_3) {
            _builder.append("\t\t");
            _builder.append("if (");
            String _firstLower_11 = StringExtensions.toFirstLower(f_3.getName());
            _builder.append(_firstLower_11, "\t\t");
            _builder.append(".match(");
            _builder.newLineIfNotEmpty();
            {
              int _size = f_3.getEntities().size();
              ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size, true);
              for(final Integer e : _doubleDotLessThan) {
                _builder.append("\t\t");
                _builder.append("\t");
                String _firstLower_12 = StringExtensions.toFirstLower(m.getContext().getName());
                _builder.append(_firstLower_12, "\t\t\t");
                _builder.append(".get");
                String _firstUpper_7 = StringExtensions.toFirstUpper(f_3.getEntities().get((e).intValue()).getName());
                _builder.append(_firstUpper_7, "\t\t\t");
                _builder.append("()");
                _builder.newLineIfNotEmpty();
                {
                  if ((((e).intValue() != (f_3.getEntities().size() - 1)) || (f_3.getRelations().size() > 0))) {
                    _builder.append("\t\t");
                    _builder.append("\t");
                    _builder.append(",");
                    _builder.newLine();
                  }
                }
              }
            }
            {
              int _size_1 = f_3.getRelations().size();
              ExclusiveRange _doubleDotLessThan_1 = new ExclusiveRange(0, _size_1, true);
              for(final Integer r : _doubleDotLessThan_1) {
                _builder.append("\t\t");
                _builder.append("\t");
                String _firstLower_13 = StringExtensions.toFirstLower(m.getContext().getName());
                _builder.append(_firstLower_13, "\t\t\t");
                _builder.append(".get");
                String _firstUpper_8 = StringExtensions.toFirstUpper(f_3.getRelations().get((r).intValue()).getName());
                _builder.append(_firstUpper_8, "\t\t\t");
                _builder.append("()");
                _builder.newLineIfNotEmpty();
                {
                  int _size_2 = f_3.getRelations().size();
                  int _minus = (_size_2 - 1);
                  boolean _notEquals = ((r).intValue() != _minus);
                  if (_notEquals) {
                    _builder.append("\t\t");
                    _builder.append("\t");
                    _builder.append(",");
                    _builder.newLine();
                  }
                }
              }
            }
            _builder.append("\t\t");
            _builder.append(")) {");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("monitorInterface.update(\"match(");
            String _firstUpper_9 = StringExtensions.toFirstUpper(m.getContext().getName());
            _builder.append(_firstUpper_9, "\t\t\t");
            _builder.append(", ");
            String _firstUpper_10 = StringExtensions.toFirstUpper(f_3.getName());
            _builder.append(_firstUpper_10, "\t\t\t");
            _builder.append(")\");");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("}");
            _builder.newLine();
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
    _builder.append("public void disappear(String name) {");
    _builder.newLine();
    {
      EList<Include> _includes_5 = d.getIncludes();
      for(final Include m_1 : _includes_5) {
        _builder.append("\t\t");
        _builder.append("monitorInterface.update(\"disappear(");
        String _firstUpper_11 = StringExtensions.toFirstUpper(m_1.getContext().getName());
        _builder.append(_firstUpper_11, "\t\t");
        _builder.append(".\" + name + \")\"); ");
        _builder.newLineIfNotEmpty();
        {
          EList<ContextFragment> _contextfragments_4 = d.getContextfragments();
          for(final ContextFragment f_4 : _contextfragments_4) {
            _builder.append("\t\t");
            _builder.append("if (");
            String _firstLower_14 = StringExtensions.toFirstLower(f_4.getName());
            _builder.append(_firstLower_14, "\t\t");
            _builder.append(".match(");
            _builder.newLineIfNotEmpty();
            {
              int _size_3 = f_4.getEntities().size();
              ExclusiveRange _doubleDotLessThan_2 = new ExclusiveRange(0, _size_3, true);
              for(final Integer e_1 : _doubleDotLessThan_2) {
                _builder.append("\t\t");
                _builder.append("\t");
                String _firstLower_15 = StringExtensions.toFirstLower(m_1.getContext().getName());
                _builder.append(_firstLower_15, "\t\t\t");
                _builder.append(".get");
                String _firstUpper_12 = StringExtensions.toFirstUpper(f_4.getEntities().get((e_1).intValue()).getName());
                _builder.append(_firstUpper_12, "\t\t\t");
                _builder.append("()");
                _builder.newLineIfNotEmpty();
                {
                  if ((((e_1).intValue() != (f_4.getEntities().size() - 1)) || (f_4.getRelations().size() > 0))) {
                    _builder.append("\t\t");
                    _builder.append("\t");
                    _builder.append(",");
                    _builder.newLine();
                  }
                }
              }
            }
            {
              int _size_4 = f_4.getRelations().size();
              ExclusiveRange _doubleDotLessThan_3 = new ExclusiveRange(0, _size_4, true);
              for(final Integer r_1 : _doubleDotLessThan_3) {
                _builder.append("\t\t");
                _builder.append("\t");
                String _firstLower_16 = StringExtensions.toFirstLower(m_1.getContext().getName());
                _builder.append(_firstLower_16, "\t\t\t");
                _builder.append(".get");
                String _firstUpper_13 = StringExtensions.toFirstUpper(f_4.getRelations().get((r_1).intValue()).getName());
                _builder.append(_firstUpper_13, "\t\t\t");
                _builder.append("()");
                _builder.newLineIfNotEmpty();
                {
                  int _size_5 = f_4.getRelations().size();
                  int _minus_1 = (_size_5 - 1);
                  boolean _notEquals_1 = ((r_1).intValue() != _minus_1);
                  if (_notEquals_1) {
                    _builder.append("\t\t");
                    _builder.append("\t");
                    _builder.append(",");
                    _builder.newLine();
                  }
                }
              }
            }
            _builder.append("\t\t");
            _builder.append(")) {");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("monitorInterface.update(\"match(");
            String _firstUpper_14 = StringExtensions.toFirstUpper(m_1.getContext().getName());
            _builder.append(_firstUpper_14, "\t\t\t");
            _builder.append(", ");
            String _firstUpper_15 = StringExtensions.toFirstUpper(f_4.getName());
            _builder.append(_firstUpper_15, "\t\t\t");
            _builder.append(")\");");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("}");
            _builder.newLine();
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
    _builder.append("public void changeTo(String event) {");
    _builder.newLine();
    {
      EList<Include> _includes_6 = d.getIncludes();
      for(final Include m_2 : _includes_6) {
        _builder.append("\t\t");
        _builder.append("monitorInterface.update(\"changeTo(");
        String _firstUpper_16 = StringExtensions.toFirstUpper(m_2.getContext().getName());
        _builder.append(_firstUpper_16, "\t\t");
        _builder.append(".\" + event + \")\"); ");
        _builder.newLineIfNotEmpty();
        {
          EList<ContextFragment> _contextfragments_5 = d.getContextfragments();
          for(final ContextFragment f_5 : _contextfragments_5) {
            _builder.append("\t\t");
            _builder.append("if (");
            String _firstLower_17 = StringExtensions.toFirstLower(f_5.getName());
            _builder.append(_firstLower_17, "\t\t");
            _builder.append(".match(");
            _builder.newLineIfNotEmpty();
            {
              int _size_6 = f_5.getEntities().size();
              ExclusiveRange _doubleDotLessThan_4 = new ExclusiveRange(0, _size_6, true);
              for(final Integer e_2 : _doubleDotLessThan_4) {
                _builder.append("\t\t");
                _builder.append("\t");
                String _firstLower_18 = StringExtensions.toFirstLower(m_2.getContext().getName());
                _builder.append(_firstLower_18, "\t\t\t");
                _builder.append(".get");
                String _firstUpper_17 = StringExtensions.toFirstUpper(f_5.getEntities().get((e_2).intValue()).getName());
                _builder.append(_firstUpper_17, "\t\t\t");
                _builder.append("()");
                _builder.newLineIfNotEmpty();
                {
                  if ((((e_2).intValue() != (f_5.getEntities().size() - 1)) || (f_5.getRelations().size() > 0))) {
                    _builder.append("\t\t");
                    _builder.append("\t");
                    _builder.append(",");
                    _builder.newLine();
                  }
                }
              }
            }
            {
              int _size_7 = f_5.getRelations().size();
              ExclusiveRange _doubleDotLessThan_5 = new ExclusiveRange(0, _size_7, true);
              for(final Integer r_2 : _doubleDotLessThan_5) {
                _builder.append("\t\t");
                _builder.append("\t");
                String _firstLower_19 = StringExtensions.toFirstLower(m_2.getContext().getName());
                _builder.append(_firstLower_19, "\t\t\t");
                _builder.append(".get");
                String _firstUpper_18 = StringExtensions.toFirstUpper(f_5.getRelations().get((r_2).intValue()).getName());
                _builder.append(_firstUpper_18, "\t\t\t");
                _builder.append("()");
                _builder.newLineIfNotEmpty();
                {
                  int _size_8 = f_5.getRelations().size();
                  int _minus_2 = (_size_8 - 1);
                  boolean _notEquals_2 = ((r_2).intValue() != _minus_2);
                  if (_notEquals_2) {
                    _builder.append("\t\t");
                    _builder.append("\t");
                    _builder.append(",");
                    _builder.newLine();
                  }
                }
              }
            }
            _builder.append("\t\t");
            _builder.append(")) {");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("monitorInterface.update(\"match(");
            String _firstUpper_19 = StringExtensions.toFirstUpper(m_2.getContext().getName());
            _builder.append(_firstUpper_19, "\t\t\t");
            _builder.append(", ");
            String _firstUpper_20 = StringExtensions.toFirstUpper(f_5.getName());
            _builder.append(_firstUpper_20, "\t\t\t");
            _builder.append(")\");");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("}");
            _builder.newLine();
          }
        }
      }
    }
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
}
