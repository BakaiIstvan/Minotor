package hu.bme.mit.dipterv.text.generator;

import hu.bme.mit.dipterv.text.minotorDsl.AssertionEntity;
import hu.bme.mit.dipterv.text.minotorDsl.AttributeValue;
import hu.bme.mit.dipterv.text.minotorDsl.Operator;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class AssertionEntities {
  public CharSequence compile_assertion_entity(final AssertionEntity entity) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("b = new Automaton(\"auto14\");");
    _builder.newLine();
    _builder.append("actualState = new State(\"q\" + counter, StateType.NORMAL);");
    _builder.newLine();
    _builder.append("counter++;");
    _builder.newLine();
    _builder.append("b.addState(actualState);");
    _builder.newLine();
    _builder.append("b.setInitial(actualState);");
    _builder.newLine();
    _builder.newLine();
    _builder.append("acceptState = new State(\"q\" + counter, StateType.ACCEPT);");
    _builder.newLine();
    _builder.append("counter++;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("b.addTransition(new Transition(\"!\" +");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("\"[\" + \"");
    String _name = entity.getContext().getName();
    _builder.append(_name, "\t\t");
    _builder.append(".");
    String _name_1 = entity.getEntity().getName();
    _builder.append(_name_1, "\t\t");
    _builder.append(".");
    String _name_2 = entity.getAttribute().getName();
    _builder.append(_name_2, "\t\t");
    _builder.append(" \" +");
    _builder.newLineIfNotEmpty();
    {
      EList<Operator> _operator = entity.getOperator();
      for(final Operator a : _operator) {
        {
          boolean _isGreater = a.isGreater();
          if (_isGreater) {
            _builder.append("\t\t");
            _builder.append("\">\"");
            _builder.newLine();
          }
        }
        {
          boolean _isSmaller = a.isSmaller();
          if (_isSmaller) {
            _builder.append("\t\t");
            _builder.append("\"<\"");
            _builder.newLine();
          }
        }
        {
          boolean _isGreaterequals = a.isGreaterequals();
          if (_isGreaterequals) {
            _builder.append("\t\t");
            _builder.append("\">=\"");
            _builder.newLine();
          }
        }
        {
          boolean _isSmallerequals = a.isSmallerequals();
          if (_isSmallerequals) {
            _builder.append("\t\t");
            _builder.append("\"<=\"");
            _builder.newLine();
          }
        }
        {
          boolean _isEquals = a.isEquals();
          if (_isEquals) {
            _builder.append("\t\t");
            _builder.append("\"==\"");
            _builder.newLine();
          }
        }
        {
          boolean _isNotequals = a.isNotequals();
          if (_isNotequals) {
            _builder.append("\t\t");
            _builder.append("\"!=\"");
            _builder.newLine();
          }
        }
      }
    }
    _builder.append("\t\t");
    _builder.append("+ ");
    _builder.newLine();
    {
      EList<AttributeValue> _value = entity.getValue();
      for(final AttributeValue v : _value) {
        {
          boolean _startsWith = v.getValue().startsWith("\"");
          if (_startsWith) {
            _builder.append("\t\t");
            String _value_1 = v.getValue();
            _builder.append(_value_1, "\t\t");
            _builder.newLineIfNotEmpty();
          } else {
            _builder.append("\t\t");
            _builder.append("\"");
            String _value_2 = v.getValue();
            _builder.append(_value_2, "\t\t");
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    _builder.append("\t\t");
    _builder.append("+ \"]\"");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append(", actualState, acceptState));");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("finalState = new State(\"q\" + counter, StateType.FINAL);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("counter++;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("b.addTransition(new Transition(");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("\"[\" + \"");
    String _name_3 = entity.getContext().getName();
    _builder.append(_name_3, "\t\t");
    _builder.append(".");
    String _name_4 = entity.getEntity().getName();
    _builder.append(_name_4, "\t\t");
    _builder.append(".");
    String _name_5 = entity.getAttribute().getName();
    _builder.append(_name_5, "\t\t");
    _builder.append(" \" +");
    _builder.newLineIfNotEmpty();
    {
      EList<Operator> _operator_1 = entity.getOperator();
      for(final Operator a_1 : _operator_1) {
        {
          boolean _isGreater_1 = a_1.isGreater();
          if (_isGreater_1) {
            _builder.append("\t\t");
            _builder.append("\">\"");
            _builder.newLine();
          }
        }
        {
          boolean _isSmaller_1 = a_1.isSmaller();
          if (_isSmaller_1) {
            _builder.append("\t\t");
            _builder.append("\"<\"");
            _builder.newLine();
          }
        }
        {
          boolean _isGreaterequals_1 = a_1.isGreaterequals();
          if (_isGreaterequals_1) {
            _builder.append("\t\t");
            _builder.append("\">=\"");
            _builder.newLine();
          }
        }
        {
          boolean _isSmallerequals_1 = a_1.isSmallerequals();
          if (_isSmallerequals_1) {
            _builder.append("\t\t");
            _builder.append("\"<=\"");
            _builder.newLine();
          }
        }
        {
          boolean _isEquals_1 = a_1.isEquals();
          if (_isEquals_1) {
            _builder.append("\t\t");
            _builder.append("\"==\"");
            _builder.newLine();
          }
        }
        {
          boolean _isNotequals_1 = a_1.isNotequals();
          if (_isNotequals_1) {
            _builder.append("\t\t");
            _builder.append("\"!=\"");
            _builder.newLine();
          }
        }
      }
    }
    _builder.append("\t\t");
    _builder.append("+ ");
    _builder.newLine();
    {
      EList<AttributeValue> _value_3 = entity.getValue();
      for(final AttributeValue v_1 : _value_3) {
        {
          boolean _startsWith_1 = v_1.getValue().startsWith("\"");
          if (_startsWith_1) {
            _builder.append("\t\t");
            String _value_4 = v_1.getValue();
            _builder.append(_value_4, "\t\t");
            _builder.newLineIfNotEmpty();
          } else {
            _builder.append("\t\t");
            _builder.append("\"");
            String _value_5 = v_1.getValue();
            _builder.append(_value_5, "\t\t");
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    _builder.append("\t\t");
    _builder.append("+ \"]\"");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append(", actualState, acceptState));");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("b.addState(acceptState);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("b.addState(finalState);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("b.setFinale(finalState);");
    _builder.newLine();
    return _builder;
  }
}
