package hu.bme.mit.dipterv.text.generator;

import hu.bme.mit.dipterv.text.minotorDsl.ClockConstraint;
import hu.bme.mit.dipterv.text.minotorDsl.ClockConstraintExpression;
import hu.bme.mit.dipterv.text.minotorDsl.ConstantParams;
import hu.bme.mit.dipterv.text.minotorDsl.Message;
import hu.bme.mit.dipterv.text.minotorDsl.Params;
import hu.bme.mit.dipterv.text.minotorDsl.ResetClock;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.ExclusiveRange;

@SuppressWarnings("all")
public class ClockRegularMessage {
  public CharSequence compile_constraint_msg(final Message m) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("str1 = \"\" ");
    _builder.newLine();
    {
      EList<Message> _messages = m.getC().getMessages();
      for(final Message msg : _messages) {
        _builder.append("+ \"!(\" + \"");
        String _name = msg.getSender().getName();
        _builder.append(_name);
        _builder.append("\" + \".\" +");
        _builder.newLineIfNotEmpty();
        _builder.append("\"");
        String _name_1 = msg.getName();
        _builder.append(_name_1);
        _builder.append("\" + \"(\"");
        _builder.newLineIfNotEmpty();
        {
          EList<Params> _params = msg.getParams();
          for(final Params p : _params) {
            {
              int _size = p.getParams().size();
              ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size, true);
              for(final Integer param : _doubleDotLessThan) {
                _builder.append("+");
                _builder.newLine();
                {
                  boolean _startsWith = p.getParams().get((param).intValue()).getValue().getValue().startsWith("\"");
                  if (_startsWith) {
                    String _value = p.getParams().get((param).intValue()).getValue().getValue();
                    _builder.append(_value);
                    _builder.newLineIfNotEmpty();
                  } else {
                    _builder.append("\"");
                    String _value_1 = p.getParams().get((param).intValue()).getValue().getValue();
                    _builder.append(_value_1);
                    _builder.append("\"");
                    _builder.newLineIfNotEmpty();
                  }
                }
                {
                  int _size_1 = p.getParams().size();
                  int _minus = (_size_1 - 1);
                  boolean _notEquals = ((param).intValue() != _minus);
                  if (_notEquals) {
                    _builder.append("+ \", \"");
                    _builder.newLine();
                  }
                }
              }
            }
          }
        }
        {
          EList<ConstantParams> _constantparams = msg.getConstantparams();
          for(final ConstantParams p_1 : _constantparams) {
            {
              int _size_2 = p_1.getValues().size();
              ExclusiveRange _doubleDotLessThan_1 = new ExclusiveRange(0, _size_2, true);
              for(final Integer param_1 : _doubleDotLessThan_1) {
                _builder.append("+");
                _builder.newLine();
                {
                  boolean _startsWith_1 = p_1.getValues().get((param_1).intValue()).getValue().startsWith("\"");
                  if (_startsWith_1) {
                    String _value_2 = p_1.getValues().get((param_1).intValue()).getValue();
                    _builder.append(_value_2);
                    _builder.newLineIfNotEmpty();
                  } else {
                    _builder.append("\"");
                    String _value_3 = p_1.getValues().get((param_1).intValue()).getValue();
                    _builder.append(_value_3);
                    _builder.append("\"");
                    _builder.newLineIfNotEmpty();
                  }
                }
                {
                  int _size_3 = p_1.getValues().size();
                  int _minus_1 = (_size_3 - 1);
                  boolean _notEquals_1 = ((param_1).intValue() != _minus_1);
                  if (_notEquals_1) {
                    _builder.append("+ \", \"");
                    _builder.newLine();
                  }
                }
              }
            }
          }
        }
        _builder.append("+ \")\"");
        _builder.newLine();
        _builder.append("+ \".\" + \"");
        String _name_2 = msg.getReceiver().getName();
        _builder.append(_name_2);
        _builder.append(")\" + \" & \"");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
      }
    }
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("str1= str1.substring(0, str1.length() - 3);");
    _builder.newLine();
    _builder.newLine();
    {
      ClockConstraintExpression _constraintexp = m.getConstraintexp();
      boolean _tripleNotEquals = (_constraintexp != null);
      if (_tripleNotEquals) {
        _builder.append("str1+= \"; \" +");
        _builder.newLine();
        {
          ClockConstraint _rclockconstraint = m.getConstraintexp().getRclockconstraint();
          boolean _tripleEquals = (_rclockconstraint == null);
          if (_tripleEquals) {
            {
              boolean _isNot = m.getConstraintexp().isNot();
              if (_isNot) {
                _builder.append("\"!\" + ");
                _builder.newLine();
              }
            }
            {
              boolean _isGreater = m.getConstraintexp().getLclockconstraint().getOp().isGreater();
              if (_isGreater) {
                _builder.append("\"");
                String _name_3 = m.getConstraintexp().getLclockconstraint().getClock().getName();
                _builder.append(_name_3);
                _builder.append(" > ");
                String _constant = m.getConstraintexp().getLclockconstraint().getConstant();
                _builder.append(_constant);
                _builder.append("\"");
                _builder.newLineIfNotEmpty();
              }
            }
            {
              boolean _isSmaller = m.getConstraintexp().getLclockconstraint().getOp().isSmaller();
              if (_isSmaller) {
                _builder.append("\"");
                String _name_4 = m.getConstraintexp().getLclockconstraint().getClock().getName();
                _builder.append(_name_4);
                _builder.append(" < ");
                String _constant_1 = m.getConstraintexp().getLclockconstraint().getConstant();
                _builder.append(_constant_1);
                _builder.append("\"");
                _builder.newLineIfNotEmpty();
              }
            }
            {
              boolean _isGreaterequals = m.getConstraintexp().getLclockconstraint().getOp().isGreaterequals();
              if (_isGreaterequals) {
                _builder.append("\"");
                String _name_5 = m.getConstraintexp().getLclockconstraint().getClock().getName();
                _builder.append(_name_5);
                _builder.append(" >= ");
                String _constant_2 = m.getConstraintexp().getLclockconstraint().getConstant();
                _builder.append(_constant_2);
                _builder.append("\"");
                _builder.newLineIfNotEmpty();
              }
            }
            {
              boolean _isSmallerequals = m.getConstraintexp().getLclockconstraint().getOp().isSmallerequals();
              if (_isSmallerequals) {
                _builder.append("\"");
                String _name_6 = m.getConstraintexp().getLclockconstraint().getClock().getName();
                _builder.append(_name_6);
                _builder.append(" <= ");
                String _constant_3 = m.getConstraintexp().getLclockconstraint().getConstant();
                _builder.append(_constant_3);
                _builder.append("\"");
                _builder.newLineIfNotEmpty();
              }
            }
            {
              boolean _isEquals = m.getConstraintexp().getLclockconstraint().getOp().isEquals();
              if (_isEquals) {
                _builder.append("\"");
                String _name_7 = m.getConstraintexp().getLclockconstraint().getClock().getName();
                _builder.append(_name_7);
                _builder.append(" == ");
                String _constant_4 = m.getConstraintexp().getLclockconstraint().getConstant();
                _builder.append(_constant_4);
                _builder.append("\"");
                _builder.newLineIfNotEmpty();
              }
            }
            {
              boolean _isNotequals = m.getConstraintexp().getLclockconstraint().getOp().isNotequals();
              if (_isNotequals) {
                _builder.append("\"");
                String _name_8 = m.getConstraintexp().getLclockconstraint().getClock().getName();
                _builder.append(_name_8);
                _builder.append(" != ");
                String _constant_5 = m.getConstraintexp().getLclockconstraint().getConstant();
                _builder.append(_constant_5);
                _builder.append("\"");
                _builder.newLineIfNotEmpty();
              }
            }
          } else {
            {
              boolean _isGreater_1 = m.getConstraintexp().getLclockconstraint().getOp().isGreater();
              if (_isGreater_1) {
                _builder.append("\"");
                String _name_9 = m.getConstraintexp().getLclockconstraint().getClock().getName();
                _builder.append(_name_9);
                _builder.append(" > ");
                String _constant_6 = m.getConstraintexp().getLclockconstraint().getConstant();
                _builder.append(_constant_6);
                _builder.append("\"");
                _builder.newLineIfNotEmpty();
              }
            }
            {
              boolean _isSmaller_1 = m.getConstraintexp().getLclockconstraint().getOp().isSmaller();
              if (_isSmaller_1) {
                _builder.append("\"");
                String _name_10 = m.getConstraintexp().getLclockconstraint().getClock().getName();
                _builder.append(_name_10);
                _builder.append(" < ");
                String _constant_7 = m.getConstraintexp().getLclockconstraint().getConstant();
                _builder.append(_constant_7);
                _builder.append("\"");
                _builder.newLineIfNotEmpty();
              }
            }
            {
              boolean _isGreaterequals_1 = m.getConstraintexp().getLclockconstraint().getOp().isGreaterequals();
              if (_isGreaterequals_1) {
                _builder.append("\"");
                String _name_11 = m.getConstraintexp().getLclockconstraint().getClock().getName();
                _builder.append(_name_11);
                _builder.append(" >= ");
                String _constant_8 = m.getConstraintexp().getLclockconstraint().getConstant();
                _builder.append(_constant_8);
                _builder.append("\"");
                _builder.newLineIfNotEmpty();
              }
            }
            {
              boolean _isSmallerequals_1 = m.getConstraintexp().getLclockconstraint().getOp().isSmallerequals();
              if (_isSmallerequals_1) {
                _builder.append("\"");
                String _name_12 = m.getConstraintexp().getLclockconstraint().getClock().getName();
                _builder.append(_name_12);
                _builder.append(" <= ");
                String _constant_9 = m.getConstraintexp().getLclockconstraint().getConstant();
                _builder.append(_constant_9);
                _builder.append("\"");
                _builder.newLineIfNotEmpty();
              }
            }
            {
              boolean _isEquals_1 = m.getConstraintexp().getLclockconstraint().getOp().isEquals();
              if (_isEquals_1) {
                _builder.append("\"");
                String _name_13 = m.getConstraintexp().getLclockconstraint().getClock().getName();
                _builder.append(_name_13);
                _builder.append(" == ");
                String _constant_10 = m.getConstraintexp().getLclockconstraint().getConstant();
                _builder.append(_constant_10);
                _builder.append("\"");
                _builder.newLineIfNotEmpty();
              }
            }
            {
              boolean _isNotequals_1 = m.getConstraintexp().getLclockconstraint().getOp().isNotequals();
              if (_isNotequals_1) {
                _builder.append("\"");
                String _name_14 = m.getConstraintexp().getLclockconstraint().getClock().getName();
                _builder.append(_name_14);
                _builder.append(" != ");
                String _constant_11 = m.getConstraintexp().getLclockconstraint().getConstant();
                _builder.append(_constant_11);
                _builder.append("\"");
                _builder.newLineIfNotEmpty();
              }
            }
            _builder.newLine();
            _builder.append("+ \" & \" + ");
            _builder.newLine();
            _builder.newLine();
            {
              boolean _isGreater_2 = m.getConstraintexp().getRclockconstraint().getOp().isGreater();
              if (_isGreater_2) {
                _builder.append("\"");
                String _name_15 = m.getConstraintexp().getRclockconstraint().getClock().getName();
                _builder.append(_name_15);
                _builder.append(" > ");
                String _constant_12 = m.getConstraintexp().getRclockconstraint().getConstant();
                _builder.append(_constant_12);
                _builder.append("\"");
                _builder.newLineIfNotEmpty();
              }
            }
            {
              boolean _isSmaller_2 = m.getConstraintexp().getRclockconstraint().getOp().isSmaller();
              if (_isSmaller_2) {
                _builder.append("\"");
                String _name_16 = m.getConstraintexp().getRclockconstraint().getClock().getName();
                _builder.append(_name_16);
                _builder.append(" < ");
                String _constant_13 = m.getConstraintexp().getRclockconstraint().getConstant();
                _builder.append(_constant_13);
                _builder.append("\"");
                _builder.newLineIfNotEmpty();
              }
            }
            {
              boolean _isGreaterequals_2 = m.getConstraintexp().getRclockconstraint().getOp().isGreaterequals();
              if (_isGreaterequals_2) {
                _builder.append("\"");
                String _name_17 = m.getConstraintexp().getRclockconstraint().getClock().getName();
                _builder.append(_name_17);
                _builder.append(" >= ");
                String _constant_14 = m.getConstraintexp().getRclockconstraint().getConstant();
                _builder.append(_constant_14);
                _builder.append("\"");
                _builder.newLineIfNotEmpty();
              }
            }
            {
              boolean _isSmallerequals_2 = m.getConstraintexp().getRclockconstraint().getOp().isSmallerequals();
              if (_isSmallerequals_2) {
                _builder.append("\"");
                String _name_18 = m.getConstraintexp().getRclockconstraint().getClock().getName();
                _builder.append(_name_18);
                _builder.append(" <= ");
                String _constant_15 = m.getConstraintexp().getRclockconstraint().getConstant();
                _builder.append(_constant_15);
                _builder.append("\"");
                _builder.newLineIfNotEmpty();
              }
            }
            {
              boolean _isEquals_2 = m.getConstraintexp().getRclockconstraint().getOp().isEquals();
              if (_isEquals_2) {
                _builder.append("\"");
                String _name_19 = m.getConstraintexp().getRclockconstraint().getClock().getName();
                _builder.append(_name_19);
                _builder.append(" == ");
                String _constant_16 = m.getConstraintexp().getRclockconstraint().getConstant();
                _builder.append(_constant_16);
                _builder.append("\"");
                _builder.newLineIfNotEmpty();
              }
            }
            {
              boolean _isNotequals_2 = m.getConstraintexp().getRclockconstraint().getOp().isNotequals();
              if (_isNotequals_2) {
                _builder.append("\"");
                String _name_20 = m.getConstraintexp().getRclockconstraint().getClock().getName();
                _builder.append(_name_20);
                _builder.append(" != ");
                String _constant_17 = m.getConstraintexp().getRclockconstraint().getConstant();
                _builder.append(_constant_17);
                _builder.append("\"");
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
        _builder.append(";");
        _builder.newLine();
      }
    }
    return _builder;
  }
  
  public CharSequence compile_msg_clock(final Message m) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("b = new Automaton(\"auto30\");");
    _builder.newLine();
    _builder.append("actualState = new State(\"q\" + counter, StateType.NORMAL);");
    _builder.newLine();
    _builder.append("counter++;");
    _builder.newLine();
    _builder.append("b.addState(actualState);");
    _builder.newLine();
    _builder.append("b.setInitial(actualState);");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t\t");
    _builder.newLine();
    _builder.append("b.addTransition(new Transition(\"!(\" + \"");
    String _name = m.getSender().getName();
    _builder.append(_name);
    _builder.append("\" + \".\" +\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("\"");
    String _name_1 = m.getName();
    _builder.append(_name_1, "\t");
    _builder.append("\" + \"(\"");
    _builder.newLineIfNotEmpty();
    {
      EList<Params> _params = m.getParams();
      for(final Params p : _params) {
        {
          int _size = p.getParams().size();
          ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size, true);
          for(final Integer param : _doubleDotLessThan) {
            _builder.append("\t");
            _builder.append("+ \"");
            String _name_2 = p.getParams().get((param).intValue()).getName();
            _builder.append(_name_2, "\t");
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
            {
              int _size_1 = p.getParams().size();
              int _minus = (_size_1 - 1);
              boolean _notEquals = ((param).intValue() != _minus);
              if (_notEquals) {
                _builder.append("\t");
                _builder.append("+ \", \"");
                _builder.newLine();
              }
            }
          }
        }
      }
    }
    {
      EList<ConstantParams> _constantparams = m.getConstantparams();
      for(final ConstantParams p_1 : _constantparams) {
        {
          int _size_2 = p_1.getValues().size();
          ExclusiveRange _doubleDotLessThan_1 = new ExclusiveRange(0, _size_2, true);
          for(final Integer param_1 : _doubleDotLessThan_1) {
            _builder.append("\t");
            _builder.append("+");
            _builder.newLine();
            {
              boolean _startsWith = p_1.getValues().get((param_1).intValue()).getValue().startsWith("\"");
              if (_startsWith) {
                _builder.append("\t");
                String _value = p_1.getValues().get((param_1).intValue()).getValue();
                _builder.append(_value, "\t");
                _builder.newLineIfNotEmpty();
              } else {
                _builder.append("\t");
                _builder.append("\"");
                String _value_1 = p_1.getValues().get((param_1).intValue()).getValue();
                _builder.append(_value_1, "\t");
                _builder.append("\"");
                _builder.newLineIfNotEmpty();
              }
            }
            {
              int _size_3 = p_1.getValues().size();
              int _minus_1 = (_size_3 - 1);
              boolean _notEquals_1 = ((param_1).intValue() != _minus_1);
              if (_notEquals_1) {
                _builder.append("\t");
                _builder.append("+ \", \"");
                _builder.newLine();
              }
            }
          }
        }
      }
    }
    _builder.append("\t");
    _builder.append("+ \")\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("+ \".\" + \"");
    String _name_3 = m.getReceiver().getName();
    _builder.append(_name_3, "\t");
    _builder.append("); \"");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    {
      ClockConstraintExpression _cConstraint = m.getCConstraint();
      boolean _tripleNotEquals = (_cConstraint != null);
      if (_tripleNotEquals) {
        _builder.append("\t");
        _builder.append("+");
        _builder.newLine();
        {
          ClockConstraint _rclockconstraint = m.getCConstraint().getRclockconstraint();
          boolean _tripleEquals = (_rclockconstraint == null);
          if (_tripleEquals) {
            {
              boolean _isNot = m.getCConstraint().isNot();
              if (_isNot) {
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("\"!\" + ");
                _builder.newLine();
              }
            }
            {
              boolean _isGreater = m.getCConstraint().getLclockconstraint().getOp().isGreater();
              if (_isGreater) {
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("\"");
                String _name_4 = m.getCConstraint().getLclockconstraint().getClock().getName();
                _builder.append(_name_4, "\t\t");
                _builder.append(" > ");
                String _constant = m.getCConstraint().getLclockconstraint().getConstant();
                _builder.append(_constant, "\t\t");
                _builder.append("\"");
                _builder.newLineIfNotEmpty();
              }
            }
            {
              boolean _isSmaller = m.getCConstraint().getLclockconstraint().getOp().isSmaller();
              if (_isSmaller) {
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("\"");
                String _name_5 = m.getCConstraint().getLclockconstraint().getClock().getName();
                _builder.append(_name_5, "\t\t");
                _builder.append(" < ");
                String _constant_1 = m.getCConstraint().getLclockconstraint().getConstant();
                _builder.append(_constant_1, "\t\t");
                _builder.append("\"");
                _builder.newLineIfNotEmpty();
              }
            }
            {
              boolean _isGreaterequals = m.getCConstraint().getLclockconstraint().getOp().isGreaterequals();
              if (_isGreaterequals) {
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("\"");
                String _name_6 = m.getCConstraint().getLclockconstraint().getClock().getName();
                _builder.append(_name_6, "\t\t");
                _builder.append(" >= ");
                String _constant_2 = m.getCConstraint().getLclockconstraint().getConstant();
                _builder.append(_constant_2, "\t\t");
                _builder.append("\"");
                _builder.newLineIfNotEmpty();
              }
            }
            {
              boolean _isSmallerequals = m.getCConstraint().getLclockconstraint().getOp().isSmallerequals();
              if (_isSmallerequals) {
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("\"");
                String _name_7 = m.getCConstraint().getLclockconstraint().getClock().getName();
                _builder.append(_name_7, "\t\t");
                _builder.append(" <= ");
                String _constant_3 = m.getCConstraint().getLclockconstraint().getConstant();
                _builder.append(_constant_3, "\t\t");
                _builder.append("\"");
                _builder.newLineIfNotEmpty();
              }
            }
            {
              boolean _isEquals = m.getCConstraint().getLclockconstraint().getOp().isEquals();
              if (_isEquals) {
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("\"");
                String _name_8 = m.getCConstraint().getLclockconstraint().getClock().getName();
                _builder.append(_name_8, "\t\t");
                _builder.append(" == ");
                String _constant_4 = m.getCConstraint().getLclockconstraint().getConstant();
                _builder.append(_constant_4, "\t\t");
                _builder.append("\"");
                _builder.newLineIfNotEmpty();
              }
            }
            {
              boolean _isNotequals = m.getCConstraint().getLclockconstraint().getOp().isNotequals();
              if (_isNotequals) {
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("\"");
                String _name_9 = m.getCConstraint().getLclockconstraint().getClock().getName();
                _builder.append(_name_9, "\t\t");
                _builder.append(" != ");
                String _constant_5 = m.getCConstraint().getLclockconstraint().getConstant();
                _builder.append(_constant_5, "\t\t");
                _builder.append("\"");
                _builder.newLineIfNotEmpty();
              }
            }
          } else {
            {
              boolean _isGreater_1 = m.getCConstraint().getLclockconstraint().getOp().isGreater();
              if (_isGreater_1) {
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("\"");
                String _name_10 = m.getCConstraint().getLclockconstraint().getClock().getName();
                _builder.append(_name_10, "\t\t");
                _builder.append(" > ");
                String _constant_6 = m.getCConstraint().getLclockconstraint().getConstant();
                _builder.append(_constant_6, "\t\t");
                _builder.append("\"");
                _builder.newLineIfNotEmpty();
              }
            }
            {
              boolean _isSmaller_1 = m.getCConstraint().getLclockconstraint().getOp().isSmaller();
              if (_isSmaller_1) {
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("\"");
                String _name_11 = m.getCConstraint().getLclockconstraint().getClock().getName();
                _builder.append(_name_11, "\t\t");
                _builder.append(" < ");
                String _constant_7 = m.getCConstraint().getLclockconstraint().getConstant();
                _builder.append(_constant_7, "\t\t");
                _builder.append("\"");
                _builder.newLineIfNotEmpty();
              }
            }
            {
              boolean _isGreaterequals_1 = m.getCConstraint().getLclockconstraint().getOp().isGreaterequals();
              if (_isGreaterequals_1) {
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("\"");
                String _name_12 = m.getCConstraint().getLclockconstraint().getClock().getName();
                _builder.append(_name_12, "\t\t");
                _builder.append(" >= ");
                String _constant_8 = m.getCConstraint().getLclockconstraint().getConstant();
                _builder.append(_constant_8, "\t\t");
                _builder.append("\"");
                _builder.newLineIfNotEmpty();
              }
            }
            {
              boolean _isSmallerequals_1 = m.getCConstraint().getLclockconstraint().getOp().isSmallerequals();
              if (_isSmallerequals_1) {
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("\"");
                String _name_13 = m.getCConstraint().getLclockconstraint().getClock().getName();
                _builder.append(_name_13, "\t\t");
                _builder.append(" <= ");
                String _constant_9 = m.getCConstraint().getLclockconstraint().getConstant();
                _builder.append(_constant_9, "\t\t");
                _builder.append("\"");
                _builder.newLineIfNotEmpty();
              }
            }
            {
              boolean _isEquals_1 = m.getCConstraint().getLclockconstraint().getOp().isEquals();
              if (_isEquals_1) {
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("\"");
                String _name_14 = m.getCConstraint().getLclockconstraint().getClock().getName();
                _builder.append(_name_14, "\t\t");
                _builder.append(" == ");
                String _constant_10 = m.getCConstraint().getLclockconstraint().getConstant();
                _builder.append(_constant_10, "\t\t");
                _builder.append("\"");
                _builder.newLineIfNotEmpty();
              }
            }
            {
              boolean _isNotequals_1 = m.getCConstraint().getLclockconstraint().getOp().isNotequals();
              if (_isNotequals_1) {
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("\"");
                String _name_15 = m.getCConstraint().getLclockconstraint().getClock().getName();
                _builder.append(_name_15, "\t\t");
                _builder.append(" != ");
                String _constant_11 = m.getCConstraint().getLclockconstraint().getConstant();
                _builder.append(_constant_11, "\t\t");
                _builder.append("\"");
                _builder.newLineIfNotEmpty();
              }
            }
            _builder.append("\t");
            _builder.append("\t");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("+ \" & \" + ");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t");
            _builder.newLine();
            {
              boolean _isGreater_2 = m.getCConstraint().getRclockconstraint().getOp().isGreater();
              if (_isGreater_2) {
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("\"");
                String _name_16 = m.getCConstraint().getRclockconstraint().getClock().getName();
                _builder.append(_name_16, "\t\t");
                _builder.append(" > ");
                String _constant_12 = m.getCConstraint().getRclockconstraint().getConstant();
                _builder.append(_constant_12, "\t\t");
                _builder.append("\"");
                _builder.newLineIfNotEmpty();
              }
            }
            {
              boolean _isSmaller_2 = m.getCConstraint().getRclockconstraint().getOp().isSmaller();
              if (_isSmaller_2) {
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("\"");
                String _name_17 = m.getCConstraint().getRclockconstraint().getClock().getName();
                _builder.append(_name_17, "\t\t");
                _builder.append(" < ");
                String _constant_13 = m.getCConstraint().getRclockconstraint().getConstant();
                _builder.append(_constant_13, "\t\t");
                _builder.append("\"");
                _builder.newLineIfNotEmpty();
              }
            }
            {
              boolean _isGreaterequals_2 = m.getCConstraint().getRclockconstraint().getOp().isGreaterequals();
              if (_isGreaterequals_2) {
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("\"");
                String _name_18 = m.getCConstraint().getRclockconstraint().getClock().getName();
                _builder.append(_name_18, "\t\t");
                _builder.append(" >= ");
                String _constant_14 = m.getCConstraint().getRclockconstraint().getConstant();
                _builder.append(_constant_14, "\t\t");
                _builder.append("\"");
                _builder.newLineIfNotEmpty();
              }
            }
            {
              boolean _isSmallerequals_2 = m.getCConstraint().getRclockconstraint().getOp().isSmallerequals();
              if (_isSmallerequals_2) {
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("\"");
                String _name_19 = m.getCConstraint().getRclockconstraint().getClock().getName();
                _builder.append(_name_19, "\t\t");
                _builder.append(" <= ");
                String _constant_15 = m.getCConstraint().getRclockconstraint().getConstant();
                _builder.append(_constant_15, "\t\t");
                _builder.append("\"");
                _builder.newLineIfNotEmpty();
              }
            }
            {
              boolean _isEquals_2 = m.getCConstraint().getRclockconstraint().getOp().isEquals();
              if (_isEquals_2) {
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("\"");
                String _name_20 = m.getCConstraint().getRclockconstraint().getClock().getName();
                _builder.append(_name_20, "\t\t");
                _builder.append(" == ");
                String _constant_16 = m.getCConstraint().getRclockconstraint().getConstant();
                _builder.append(_constant_16, "\t\t");
                _builder.append("\"");
                _builder.newLineIfNotEmpty();
              }
            }
            {
              boolean _isNotequals_2 = m.getCConstraint().getRclockconstraint().getOp().isNotequals();
              if (_isNotequals_2) {
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("\"");
                String _name_21 = m.getCConstraint().getRclockconstraint().getClock().getName();
                _builder.append(_name_21, "\t\t");
                _builder.append(" != ");
                String _constant_17 = m.getCConstraint().getRclockconstraint().getConstant();
                _builder.append(_constant_17, "\t\t");
                _builder.append("\"");
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("+ \";\"");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append(", actualState, actualState));");
    _builder.newLine();
    _builder.newLine();
    _builder.append("newState = new State(\"q\" + counter, StateType.FINAL);");
    _builder.newLine();
    _builder.append("counter++;");
    _builder.newLine();
    _builder.append("b.addTransition(new Transition(\"");
    String _name_22 = m.getSender().getName();
    _builder.append(_name_22);
    _builder.append("\" + \".\" +");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\"");
    String _name_23 = m.getName();
    _builder.append(_name_23);
    _builder.append("\" + \"(\"");
    _builder.newLineIfNotEmpty();
    {
      EList<Params> _params_1 = m.getParams();
      for(final Params p_2 : _params_1) {
        {
          int _size_4 = p_2.getParams().size();
          ExclusiveRange _doubleDotLessThan_2 = new ExclusiveRange(0, _size_4, true);
          for(final Integer param_2 : _doubleDotLessThan_2) {
            _builder.append("+ \"");
            String _name_24 = p_2.getParams().get((param_2).intValue()).getName();
            _builder.append(_name_24);
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
            {
              int _size_5 = p_2.getParams().size();
              int _minus_2 = (_size_5 - 1);
              boolean _notEquals_2 = ((param_2).intValue() != _minus_2);
              if (_notEquals_2) {
                _builder.append("+ \", \"");
                _builder.newLine();
              }
            }
          }
        }
      }
    }
    {
      EList<ConstantParams> _constantparams_1 = m.getConstantparams();
      for(final ConstantParams p_3 : _constantparams_1) {
        {
          int _size_6 = p_3.getValues().size();
          ExclusiveRange _doubleDotLessThan_3 = new ExclusiveRange(0, _size_6, true);
          for(final Integer param_3 : _doubleDotLessThan_3) {
            _builder.append("+");
            _builder.newLine();
            {
              boolean _startsWith_1 = p_3.getValues().get((param_3).intValue()).getValue().startsWith("\"");
              if (_startsWith_1) {
                String _value_2 = p_3.getValues().get((param_3).intValue()).getValue();
                _builder.append(_value_2);
                _builder.newLineIfNotEmpty();
              } else {
                _builder.append("\"");
                String _value_3 = p_3.getValues().get((param_3).intValue()).getValue();
                _builder.append(_value_3);
                _builder.append("\"");
                _builder.newLineIfNotEmpty();
              }
            }
            {
              int _size_7 = p_3.getValues().size();
              int _minus_3 = (_size_7 - 1);
              boolean _notEquals_3 = ((param_3).intValue() != _minus_3);
              if (_notEquals_3) {
                _builder.append("+ \", \"");
                _builder.newLine();
              }
            }
          }
        }
      }
    }
    _builder.append("+ \")\"");
    _builder.newLine();
    _builder.newLine();
    _builder.append("+ \".\" + \"");
    String _name_25 = m.getReceiver().getName();
    _builder.append(_name_25);
    _builder.append("; \"");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    {
      ClockConstraintExpression _cConstraint_1 = m.getCConstraint();
      boolean _tripleNotEquals_1 = (_cConstraint_1 != null);
      if (_tripleNotEquals_1) {
        _builder.append("+");
        _builder.newLine();
        {
          ClockConstraint _rclockconstraint_1 = m.getCConstraint().getRclockconstraint();
          boolean _tripleEquals_1 = (_rclockconstraint_1 == null);
          if (_tripleEquals_1) {
            {
              boolean _isNot_1 = m.getCConstraint().isNot();
              if (_isNot_1) {
                _builder.append("\t");
                _builder.append("\"!\" + ");
                _builder.newLine();
              }
            }
            {
              boolean _isGreater_3 = m.getCConstraint().getLclockconstraint().getOp().isGreater();
              if (_isGreater_3) {
                _builder.append("\t");
                _builder.append("\"");
                String _name_26 = m.getCConstraint().getLclockconstraint().getClock().getName();
                _builder.append(_name_26, "\t");
                _builder.append(" > ");
                String _constant_18 = m.getCConstraint().getLclockconstraint().getConstant();
                _builder.append(_constant_18, "\t");
                _builder.append("\"");
                _builder.newLineIfNotEmpty();
              }
            }
            {
              boolean _isSmaller_3 = m.getCConstraint().getLclockconstraint().getOp().isSmaller();
              if (_isSmaller_3) {
                _builder.append("\t");
                _builder.append("\"");
                String _name_27 = m.getCConstraint().getLclockconstraint().getClock().getName();
                _builder.append(_name_27, "\t");
                _builder.append(" < ");
                String _constant_19 = m.getCConstraint().getLclockconstraint().getConstant();
                _builder.append(_constant_19, "\t");
                _builder.append("\"");
                _builder.newLineIfNotEmpty();
              }
            }
            {
              boolean _isGreaterequals_3 = m.getCConstraint().getLclockconstraint().getOp().isGreaterequals();
              if (_isGreaterequals_3) {
                _builder.append("\t");
                _builder.append("\"");
                String _name_28 = m.getCConstraint().getLclockconstraint().getClock().getName();
                _builder.append(_name_28, "\t");
                _builder.append(" >= ");
                String _constant_20 = m.getCConstraint().getLclockconstraint().getConstant();
                _builder.append(_constant_20, "\t");
                _builder.append("\"");
                _builder.newLineIfNotEmpty();
              }
            }
            {
              boolean _isSmallerequals_3 = m.getCConstraint().getLclockconstraint().getOp().isSmallerequals();
              if (_isSmallerequals_3) {
                _builder.append("\t");
                _builder.append("\"");
                String _name_29 = m.getCConstraint().getLclockconstraint().getClock().getName();
                _builder.append(_name_29, "\t");
                _builder.append(" <= ");
                String _constant_21 = m.getCConstraint().getLclockconstraint().getConstant();
                _builder.append(_constant_21, "\t");
                _builder.append("\"");
                _builder.newLineIfNotEmpty();
              }
            }
            {
              boolean _isEquals_3 = m.getCConstraint().getLclockconstraint().getOp().isEquals();
              if (_isEquals_3) {
                _builder.append("\t");
                _builder.append("\"");
                String _name_30 = m.getCConstraint().getLclockconstraint().getClock().getName();
                _builder.append(_name_30, "\t");
                _builder.append(" == ");
                String _constant_22 = m.getCConstraint().getLclockconstraint().getConstant();
                _builder.append(_constant_22, "\t");
                _builder.append("\"");
                _builder.newLineIfNotEmpty();
              }
            }
            {
              boolean _isNotequals_3 = m.getCConstraint().getLclockconstraint().getOp().isNotequals();
              if (_isNotequals_3) {
                _builder.append("\t");
                _builder.append("\"");
                String _name_31 = m.getCConstraint().getLclockconstraint().getClock().getName();
                _builder.append(_name_31, "\t");
                _builder.append(" != ");
                String _constant_23 = m.getCConstraint().getLclockconstraint().getConstant();
                _builder.append(_constant_23, "\t");
                _builder.append("\"");
                _builder.newLineIfNotEmpty();
              }
            }
          } else {
            {
              boolean _isGreater_4 = m.getCConstraint().getLclockconstraint().getOp().isGreater();
              if (_isGreater_4) {
                _builder.append("\t");
                _builder.append("\"");
                String _name_32 = m.getCConstraint().getLclockconstraint().getClock().getName();
                _builder.append(_name_32, "\t");
                _builder.append(" > ");
                String _constant_24 = m.getCConstraint().getLclockconstraint().getConstant();
                _builder.append(_constant_24, "\t");
                _builder.append("\"");
                _builder.newLineIfNotEmpty();
              }
            }
            {
              boolean _isSmaller_4 = m.getCConstraint().getLclockconstraint().getOp().isSmaller();
              if (_isSmaller_4) {
                _builder.append("\t");
                _builder.append("\"");
                String _name_33 = m.getCConstraint().getLclockconstraint().getClock().getName();
                _builder.append(_name_33, "\t");
                _builder.append(" < ");
                String _constant_25 = m.getCConstraint().getLclockconstraint().getConstant();
                _builder.append(_constant_25, "\t");
                _builder.append("\"");
                _builder.newLineIfNotEmpty();
              }
            }
            {
              boolean _isGreaterequals_4 = m.getCConstraint().getLclockconstraint().getOp().isGreaterequals();
              if (_isGreaterequals_4) {
                _builder.append("\t");
                _builder.append("\"");
                String _name_34 = m.getCConstraint().getLclockconstraint().getClock().getName();
                _builder.append(_name_34, "\t");
                _builder.append(" >= ");
                String _constant_26 = m.getCConstraint().getLclockconstraint().getConstant();
                _builder.append(_constant_26, "\t");
                _builder.append("\"");
                _builder.newLineIfNotEmpty();
              }
            }
            {
              boolean _isSmallerequals_4 = m.getCConstraint().getLclockconstraint().getOp().isSmallerequals();
              if (_isSmallerequals_4) {
                _builder.append("\t");
                _builder.append("\"");
                String _name_35 = m.getCConstraint().getLclockconstraint().getClock().getName();
                _builder.append(_name_35, "\t");
                _builder.append(" <= ");
                String _constant_27 = m.getCConstraint().getLclockconstraint().getConstant();
                _builder.append(_constant_27, "\t");
                _builder.append("\"");
                _builder.newLineIfNotEmpty();
              }
            }
            {
              boolean _isEquals_4 = m.getCConstraint().getLclockconstraint().getOp().isEquals();
              if (_isEquals_4) {
                _builder.append("\t");
                _builder.append("\"");
                String _name_36 = m.getCConstraint().getLclockconstraint().getClock().getName();
                _builder.append(_name_36, "\t");
                _builder.append(" == ");
                String _constant_28 = m.getCConstraint().getLclockconstraint().getConstant();
                _builder.append(_constant_28, "\t");
                _builder.append("\"");
                _builder.newLineIfNotEmpty();
              }
            }
            {
              boolean _isNotequals_4 = m.getCConstraint().getLclockconstraint().getOp().isNotequals();
              if (_isNotequals_4) {
                _builder.append("\t");
                _builder.append("\"");
                String _name_37 = m.getCConstraint().getLclockconstraint().getClock().getName();
                _builder.append(_name_37, "\t");
                _builder.append(" != ");
                String _constant_29 = m.getCConstraint().getLclockconstraint().getConstant();
                _builder.append(_constant_29, "\t");
                _builder.append("\"");
                _builder.newLineIfNotEmpty();
              }
            }
            _builder.append("\t");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("+ \" & \" + ");
            _builder.newLine();
            _builder.append("\t");
            _builder.newLine();
            {
              boolean _isGreater_5 = m.getCConstraint().getRclockconstraint().getOp().isGreater();
              if (_isGreater_5) {
                _builder.append("\t");
                _builder.append("\"");
                String _name_38 = m.getCConstraint().getRclockconstraint().getClock().getName();
                _builder.append(_name_38, "\t");
                _builder.append(" > ");
                String _constant_30 = m.getCConstraint().getRclockconstraint().getConstant();
                _builder.append(_constant_30, "\t");
                _builder.append("\"");
                _builder.newLineIfNotEmpty();
              }
            }
            {
              boolean _isSmaller_5 = m.getCConstraint().getRclockconstraint().getOp().isSmaller();
              if (_isSmaller_5) {
                _builder.append("\t");
                _builder.append("\"");
                String _name_39 = m.getCConstraint().getRclockconstraint().getClock().getName();
                _builder.append(_name_39, "\t");
                _builder.append(" < ");
                String _constant_31 = m.getCConstraint().getRclockconstraint().getConstant();
                _builder.append(_constant_31, "\t");
                _builder.append("\"");
                _builder.newLineIfNotEmpty();
              }
            }
            {
              boolean _isGreaterequals_5 = m.getCConstraint().getRclockconstraint().getOp().isGreaterequals();
              if (_isGreaterequals_5) {
                _builder.append("\t");
                _builder.append("\"");
                String _name_40 = m.getCConstraint().getRclockconstraint().getClock().getName();
                _builder.append(_name_40, "\t");
                _builder.append(" >= ");
                String _constant_32 = m.getCConstraint().getRclockconstraint().getConstant();
                _builder.append(_constant_32, "\t");
                _builder.append("\"");
                _builder.newLineIfNotEmpty();
              }
            }
            {
              boolean _isSmallerequals_5 = m.getCConstraint().getRclockconstraint().getOp().isSmallerequals();
              if (_isSmallerequals_5) {
                _builder.append("\t");
                _builder.append("\"");
                String _name_41 = m.getCConstraint().getRclockconstraint().getClock().getName();
                _builder.append(_name_41, "\t");
                _builder.append(" <= ");
                String _constant_33 = m.getCConstraint().getRclockconstraint().getConstant();
                _builder.append(_constant_33, "\t");
                _builder.append("\"");
                _builder.newLineIfNotEmpty();
              }
            }
            {
              boolean _isEquals_5 = m.getCConstraint().getRclockconstraint().getOp().isEquals();
              if (_isEquals_5) {
                _builder.append("\t");
                _builder.append("\"");
                String _name_42 = m.getCConstraint().getRclockconstraint().getClock().getName();
                _builder.append(_name_42, "\t");
                _builder.append(" == ");
                String _constant_34 = m.getCConstraint().getRclockconstraint().getConstant();
                _builder.append(_constant_34, "\t");
                _builder.append("\"");
                _builder.newLineIfNotEmpty();
              }
            }
            {
              boolean _isNotequals_5 = m.getCConstraint().getRclockconstraint().getOp().isNotequals();
              if (_isNotequals_5) {
                _builder.append("\t");
                _builder.append("\"");
                String _name_43 = m.getCConstraint().getRclockconstraint().getClock().getName();
                _builder.append(_name_43, "\t");
                _builder.append(" != ");
                String _constant_35 = m.getCConstraint().getRclockconstraint().getConstant();
                _builder.append(_constant_35, "\t");
                _builder.append("\"");
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
        _builder.append("\t");
        _builder.append("+ \";\"");
        _builder.newLine();
      }
    }
    _builder.newLine();
    {
      ResetClock _resetclock = m.getResetclock();
      boolean _tripleNotEquals_2 = (_resetclock != null);
      if (_tripleNotEquals_2) {
        _builder.append("+ \"");
        String _name_44 = m.getResetclock().getClock().getName();
        _builder.append(_name_44);
        _builder.append(" = 0\"");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    _builder.append(" ");
    _builder.append(", actualState, newState));");
    _builder.newLine();
    _builder.append("b.addState(newState);");
    _builder.newLine();
    _builder.append("b.setFinale(newState);");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence compile_strict_clock(final Message m) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("b = new Automaton(\"auto12\");");
    _builder.newLine();
    _builder.append("actualState = new State(\"q\" + counter, StateType.NORMAL);");
    _builder.newLine();
    _builder.append("counter++;");
    _builder.newLine();
    _builder.append("b.addState(actualState);");
    _builder.newLine();
    _builder.append("b.setInitial(actualState);");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t\t\t");
    _builder.newLine();
    _builder.append("newState = new State(\"q\" + counter, StateType.FINAL);");
    _builder.newLine();
    _builder.append("counter++;");
    _builder.newLine();
    _builder.append("b.addTransition(new Transition(\"");
    String _name = m.getSender().getName();
    _builder.append(_name);
    _builder.append("\" + \".\" +");
    _builder.newLineIfNotEmpty();
    _builder.append("\"");
    String _name_1 = m.getName();
    _builder.append(_name_1);
    _builder.append("\" + \"(\"");
    _builder.newLineIfNotEmpty();
    {
      EList<Params> _params = m.getParams();
      for(final Params p : _params) {
        {
          int _size = p.getParams().size();
          ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size, true);
          for(final Integer param : _doubleDotLessThan) {
            _builder.append("+ \"");
            String _name_2 = p.getParams().get((param).intValue()).getName();
            _builder.append(_name_2);
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
            {
              int _size_1 = p.getParams().size();
              int _minus = (_size_1 - 1);
              boolean _notEquals = ((param).intValue() != _minus);
              if (_notEquals) {
                _builder.append("+ \", \"");
                _builder.newLine();
              }
            }
          }
        }
      }
    }
    {
      EList<ConstantParams> _constantparams = m.getConstantparams();
      for(final ConstantParams p_1 : _constantparams) {
        {
          int _size_2 = p_1.getValues().size();
          ExclusiveRange _doubleDotLessThan_1 = new ExclusiveRange(0, _size_2, true);
          for(final Integer param_1 : _doubleDotLessThan_1) {
            _builder.append("+");
            _builder.newLine();
            {
              boolean _startsWith = p_1.getValues().get((param_1).intValue()).getValue().startsWith("\"");
              if (_startsWith) {
                String _value = p_1.getValues().get((param_1).intValue()).getValue();
                _builder.append(_value);
                _builder.newLineIfNotEmpty();
              } else {
                _builder.append("\"");
                String _value_1 = p_1.getValues().get((param_1).intValue()).getValue();
                _builder.append(_value_1);
                _builder.append("\"");
                _builder.newLineIfNotEmpty();
              }
            }
            {
              int _size_3 = p_1.getValues().size();
              int _minus_1 = (_size_3 - 1);
              boolean _notEquals_1 = ((param_1).intValue() != _minus_1);
              if (_notEquals_1) {
                _builder.append("+ \", \"");
                _builder.newLine();
              }
            }
          }
        }
      }
    }
    _builder.append("+ \")\"");
    _builder.newLine();
    _builder.append("+ \".\" + \"");
    String _name_3 = m.getReceiver().getName();
    _builder.append(_name_3);
    _builder.append(";\" +");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    {
      ClockConstraint _rclockconstraint = m.getCConstraint().getRclockconstraint();
      boolean _tripleEquals = (_rclockconstraint == null);
      if (_tripleEquals) {
        {
          boolean _isNot = m.getCConstraint().isNot();
          if (_isNot) {
            _builder.append("\"!\" + ");
            _builder.newLine();
          }
        }
        {
          boolean _isGreater = m.getCConstraint().getLclockconstraint().getOp().isGreater();
          if (_isGreater) {
            _builder.append("\"");
            String _name_4 = m.getCConstraint().getLclockconstraint().getClock().getName();
            _builder.append(_name_4);
            _builder.append(" > ");
            String _constant = m.getCConstraint().getLclockconstraint().getConstant();
            _builder.append(_constant);
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          boolean _isSmaller = m.getCConstraint().getLclockconstraint().getOp().isSmaller();
          if (_isSmaller) {
            _builder.append("\"");
            String _name_5 = m.getCConstraint().getLclockconstraint().getClock().getName();
            _builder.append(_name_5);
            _builder.append(" < ");
            String _constant_1 = m.getCConstraint().getLclockconstraint().getConstant();
            _builder.append(_constant_1);
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          boolean _isGreaterequals = m.getCConstraint().getLclockconstraint().getOp().isGreaterequals();
          if (_isGreaterequals) {
            _builder.append("\"");
            String _name_6 = m.getCConstraint().getLclockconstraint().getClock().getName();
            _builder.append(_name_6);
            _builder.append(" >= ");
            String _constant_2 = m.getCConstraint().getLclockconstraint().getConstant();
            _builder.append(_constant_2);
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          boolean _isSmallerequals = m.getCConstraint().getLclockconstraint().getOp().isSmallerequals();
          if (_isSmallerequals) {
            _builder.append("\"");
            String _name_7 = m.getCConstraint().getLclockconstraint().getClock().getName();
            _builder.append(_name_7);
            _builder.append(" <= ");
            String _constant_3 = m.getCConstraint().getLclockconstraint().getConstant();
            _builder.append(_constant_3);
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          boolean _isEquals = m.getCConstraint().getLclockconstraint().getOp().isEquals();
          if (_isEquals) {
            _builder.append("\"");
            String _name_8 = m.getCConstraint().getLclockconstraint().getClock().getName();
            _builder.append(_name_8);
            _builder.append(" == ");
            String _constant_4 = m.getCConstraint().getLclockconstraint().getConstant();
            _builder.append(_constant_4);
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          boolean _isNotequals = m.getCConstraint().getLclockconstraint().getOp().isNotequals();
          if (_isNotequals) {
            _builder.append("\"");
            String _name_9 = m.getCConstraint().getLclockconstraint().getClock().getName();
            _builder.append(_name_9);
            _builder.append(" != ");
            String _constant_5 = m.getCConstraint().getLclockconstraint().getConstant();
            _builder.append(_constant_5);
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
      } else {
        {
          boolean _isGreater_1 = m.getCConstraint().getLclockconstraint().getOp().isGreater();
          if (_isGreater_1) {
            _builder.append("\"");
            String _name_10 = m.getCConstraint().getLclockconstraint().getClock().getName();
            _builder.append(_name_10);
            _builder.append(" > ");
            String _constant_6 = m.getCConstraint().getLclockconstraint().getConstant();
            _builder.append(_constant_6);
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          boolean _isSmaller_1 = m.getCConstraint().getLclockconstraint().getOp().isSmaller();
          if (_isSmaller_1) {
            _builder.append("\"");
            String _name_11 = m.getCConstraint().getLclockconstraint().getClock().getName();
            _builder.append(_name_11);
            _builder.append(" < ");
            String _constant_7 = m.getCConstraint().getLclockconstraint().getConstant();
            _builder.append(_constant_7);
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          boolean _isGreaterequals_1 = m.getCConstraint().getLclockconstraint().getOp().isGreaterequals();
          if (_isGreaterequals_1) {
            _builder.append("\"");
            String _name_12 = m.getCConstraint().getLclockconstraint().getClock().getName();
            _builder.append(_name_12);
            _builder.append(" >= ");
            String _constant_8 = m.getCConstraint().getLclockconstraint().getConstant();
            _builder.append(_constant_8);
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          boolean _isSmallerequals_1 = m.getCConstraint().getLclockconstraint().getOp().isSmallerequals();
          if (_isSmallerequals_1) {
            _builder.append("\"");
            String _name_13 = m.getCConstraint().getLclockconstraint().getClock().getName();
            _builder.append(_name_13);
            _builder.append(" <= ");
            String _constant_9 = m.getCConstraint().getLclockconstraint().getConstant();
            _builder.append(_constant_9);
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          boolean _isEquals_1 = m.getCConstraint().getLclockconstraint().getOp().isEquals();
          if (_isEquals_1) {
            _builder.append("\"");
            String _name_14 = m.getCConstraint().getLclockconstraint().getClock().getName();
            _builder.append(_name_14);
            _builder.append(" == ");
            String _constant_10 = m.getCConstraint().getLclockconstraint().getConstant();
            _builder.append(_constant_10);
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          boolean _isNotequals_1 = m.getCConstraint().getLclockconstraint().getOp().isNotequals();
          if (_isNotequals_1) {
            _builder.append("\"");
            String _name_15 = m.getCConstraint().getLclockconstraint().getClock().getName();
            _builder.append(_name_15);
            _builder.append(" != ");
            String _constant_11 = m.getCConstraint().getLclockconstraint().getConstant();
            _builder.append(_constant_11);
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.newLine();
        _builder.append("+ \" & \" + ");
        _builder.newLine();
        _builder.newLine();
        {
          boolean _isGreater_2 = m.getCConstraint().getRclockconstraint().getOp().isGreater();
          if (_isGreater_2) {
            _builder.append("\"");
            String _name_16 = m.getCConstraint().getRclockconstraint().getClock().getName();
            _builder.append(_name_16);
            _builder.append(" > ");
            String _constant_12 = m.getCConstraint().getRclockconstraint().getConstant();
            _builder.append(_constant_12);
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          boolean _isSmaller_2 = m.getCConstraint().getRclockconstraint().getOp().isSmaller();
          if (_isSmaller_2) {
            _builder.append("\"");
            String _name_17 = m.getCConstraint().getRclockconstraint().getClock().getName();
            _builder.append(_name_17);
            _builder.append(" < ");
            String _constant_13 = m.getCConstraint().getRclockconstraint().getConstant();
            _builder.append(_constant_13);
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          boolean _isGreaterequals_2 = m.getCConstraint().getRclockconstraint().getOp().isGreaterequals();
          if (_isGreaterequals_2) {
            _builder.append("\"");
            String _name_18 = m.getCConstraint().getRclockconstraint().getClock().getName();
            _builder.append(_name_18);
            _builder.append(" >= ");
            String _constant_14 = m.getCConstraint().getRclockconstraint().getConstant();
            _builder.append(_constant_14);
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          boolean _isSmallerequals_2 = m.getCConstraint().getRclockconstraint().getOp().isSmallerequals();
          if (_isSmallerequals_2) {
            _builder.append("\"");
            String _name_19 = m.getCConstraint().getRclockconstraint().getClock().getName();
            _builder.append(_name_19);
            _builder.append(" <= ");
            String _constant_15 = m.getCConstraint().getRclockconstraint().getConstant();
            _builder.append(_constant_15);
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          boolean _isEquals_2 = m.getCConstraint().getRclockconstraint().getOp().isEquals();
          if (_isEquals_2) {
            _builder.append("\"");
            String _name_20 = m.getCConstraint().getRclockconstraint().getClock().getName();
            _builder.append(_name_20);
            _builder.append(" == ");
            String _constant_16 = m.getCConstraint().getRclockconstraint().getConstant();
            _builder.append(_constant_16);
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          boolean _isNotequals_2 = m.getCConstraint().getRclockconstraint().getOp().isNotequals();
          if (_isNotequals_2) {
            _builder.append("\"");
            String _name_21 = m.getCConstraint().getRclockconstraint().getClock().getName();
            _builder.append(_name_21);
            _builder.append(" != ");
            String _constant_17 = m.getCConstraint().getRclockconstraint().getConstant();
            _builder.append(_constant_17);
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    _builder.newLine();
    {
      ResetClock _resetclock = m.getResetclock();
      boolean _tripleNotEquals = (_resetclock != null);
      if (_tripleNotEquals) {
        _builder.append("+ \"; ");
        String _name_22 = m.getResetclock().getClock().getName();
        _builder.append(_name_22);
        _builder.append(" = 0\"");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    _builder.append(", actualState, newState));");
    _builder.newLine();
    _builder.append("b.addState(newState);");
    _builder.newLine();
    _builder.append("b.setFinale(newState);");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence compile_past_clock(final Message m) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("b = new Automaton(\"auto7\");");
    _builder.newLine();
    _builder.append("actualState = new State(\"q\" + counter, StateType.NORMAL);");
    _builder.newLine();
    _builder.append("counter++;");
    _builder.newLine();
    _builder.append("b.addState(actualState);");
    _builder.newLine();
    _builder.append("b.setInitial(actualState);");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t\t\t");
    _builder.newLine();
    _builder.append("b.addTransition(new Transition(str + \" & \" + \"!(\" + \"");
    String _name = m.getSender().getName();
    _builder.append(_name);
    _builder.append("\" + \".\" +\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("\"");
    String _name_1 = m.getName();
    _builder.append(_name_1, "\t");
    _builder.append("\" + \"(\"");
    _builder.newLineIfNotEmpty();
    {
      EList<Params> _params = m.getParams();
      for(final Params p : _params) {
        {
          int _size = p.getParams().size();
          ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size, true);
          for(final Integer param : _doubleDotLessThan) {
            _builder.append("\t");
            _builder.append("+ \"");
            String _name_2 = p.getParams().get((param).intValue()).getName();
            _builder.append(_name_2, "\t");
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
            {
              int _size_1 = p.getParams().size();
              int _minus = (_size_1 - 1);
              boolean _notEquals = ((param).intValue() != _minus);
              if (_notEquals) {
                _builder.append("\t");
                _builder.append("+ \", \"");
                _builder.newLine();
              }
            }
          }
        }
      }
    }
    {
      EList<ConstantParams> _constantparams = m.getConstantparams();
      for(final ConstantParams p_1 : _constantparams) {
        {
          int _size_2 = p_1.getValues().size();
          ExclusiveRange _doubleDotLessThan_1 = new ExclusiveRange(0, _size_2, true);
          for(final Integer param_1 : _doubleDotLessThan_1) {
            _builder.append("\t");
            _builder.append("+");
            _builder.newLine();
            {
              boolean _startsWith = p_1.getValues().get((param_1).intValue()).getValue().startsWith("\"");
              if (_startsWith) {
                _builder.append("\t");
                String _value = p_1.getValues().get((param_1).intValue()).getValue();
                _builder.append(_value, "\t");
                _builder.newLineIfNotEmpty();
              } else {
                _builder.append("\t");
                _builder.append("\"");
                String _value_1 = p_1.getValues().get((param_1).intValue()).getValue();
                _builder.append(_value_1, "\t");
                _builder.append("\"");
                _builder.newLineIfNotEmpty();
              }
            }
            {
              int _size_3 = p_1.getValues().size();
              int _minus_1 = (_size_3 - 1);
              boolean _notEquals_1 = ((param_1).intValue() != _minus_1);
              if (_notEquals_1) {
                _builder.append("\t");
                _builder.append("+ \", \"");
                _builder.newLine();
              }
            }
          }
        }
      }
    }
    _builder.append("\t");
    _builder.append("+ \")\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("+ \".\" + \"");
    String _name_3 = m.getReceiver().getName();
    _builder.append(_name_3, "\t");
    _builder.append("); \" + ");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    {
      ClockConstraint _rclockconstraint = m.getCConstraint().getRclockconstraint();
      boolean _tripleEquals = (_rclockconstraint == null);
      if (_tripleEquals) {
        {
          boolean _isNot = m.getCConstraint().isNot();
          if (_isNot) {
            _builder.append("\t");
            _builder.append("\"!\" + ");
            _builder.newLine();
          }
        }
        {
          boolean _isGreater = m.getCConstraint().getLclockconstraint().getOp().isGreater();
          if (_isGreater) {
            _builder.append("\t");
            _builder.append("\"");
            String _name_4 = m.getCConstraint().getLclockconstraint().getClock().getName();
            _builder.append(_name_4, "\t");
            _builder.append(" > ");
            String _constant = m.getCConstraint().getLclockconstraint().getConstant();
            _builder.append(_constant, "\t");
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          boolean _isSmaller = m.getCConstraint().getLclockconstraint().getOp().isSmaller();
          if (_isSmaller) {
            _builder.append("\t");
            _builder.append("\"");
            String _name_5 = m.getCConstraint().getLclockconstraint().getClock().getName();
            _builder.append(_name_5, "\t");
            _builder.append(" < ");
            String _constant_1 = m.getCConstraint().getLclockconstraint().getConstant();
            _builder.append(_constant_1, "\t");
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          boolean _isGreaterequals = m.getCConstraint().getLclockconstraint().getOp().isGreaterequals();
          if (_isGreaterequals) {
            _builder.append("\t");
            _builder.append("\"");
            String _name_6 = m.getCConstraint().getLclockconstraint().getClock().getName();
            _builder.append(_name_6, "\t");
            _builder.append(" >= ");
            String _constant_2 = m.getCConstraint().getLclockconstraint().getConstant();
            _builder.append(_constant_2, "\t");
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          boolean _isSmallerequals = m.getCConstraint().getLclockconstraint().getOp().isSmallerequals();
          if (_isSmallerequals) {
            _builder.append("\t");
            _builder.append("\"");
            String _name_7 = m.getCConstraint().getLclockconstraint().getClock().getName();
            _builder.append(_name_7, "\t");
            _builder.append(" <= ");
            String _constant_3 = m.getCConstraint().getLclockconstraint().getConstant();
            _builder.append(_constant_3, "\t");
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          boolean _isEquals = m.getCConstraint().getLclockconstraint().getOp().isEquals();
          if (_isEquals) {
            _builder.append("\t");
            _builder.append("\"");
            String _name_8 = m.getCConstraint().getLclockconstraint().getClock().getName();
            _builder.append(_name_8, "\t");
            _builder.append(" == ");
            String _constant_4 = m.getCConstraint().getLclockconstraint().getConstant();
            _builder.append(_constant_4, "\t");
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          boolean _isNotequals = m.getCConstraint().getLclockconstraint().getOp().isNotequals();
          if (_isNotequals) {
            _builder.append("\t");
            _builder.append("\"");
            String _name_9 = m.getCConstraint().getLclockconstraint().getClock().getName();
            _builder.append(_name_9, "\t");
            _builder.append(" != ");
            String _constant_5 = m.getCConstraint().getLclockconstraint().getConstant();
            _builder.append(_constant_5, "\t");
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
      } else {
        {
          boolean _isGreater_1 = m.getCConstraint().getLclockconstraint().getOp().isGreater();
          if (_isGreater_1) {
            _builder.append("\t");
            _builder.append("\"");
            String _name_10 = m.getCConstraint().getLclockconstraint().getClock().getName();
            _builder.append(_name_10, "\t");
            _builder.append(" > ");
            String _constant_6 = m.getCConstraint().getLclockconstraint().getConstant();
            _builder.append(_constant_6, "\t");
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          boolean _isSmaller_1 = m.getCConstraint().getLclockconstraint().getOp().isSmaller();
          if (_isSmaller_1) {
            _builder.append("\t");
            _builder.append("\"");
            String _name_11 = m.getCConstraint().getLclockconstraint().getClock().getName();
            _builder.append(_name_11, "\t");
            _builder.append(" < ");
            String _constant_7 = m.getCConstraint().getLclockconstraint().getConstant();
            _builder.append(_constant_7, "\t");
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          boolean _isGreaterequals_1 = m.getCConstraint().getLclockconstraint().getOp().isGreaterequals();
          if (_isGreaterequals_1) {
            _builder.append("\t");
            _builder.append("\"");
            String _name_12 = m.getCConstraint().getLclockconstraint().getClock().getName();
            _builder.append(_name_12, "\t");
            _builder.append(" >= ");
            String _constant_8 = m.getCConstraint().getLclockconstraint().getConstant();
            _builder.append(_constant_8, "\t");
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          boolean _isSmallerequals_1 = m.getCConstraint().getLclockconstraint().getOp().isSmallerequals();
          if (_isSmallerequals_1) {
            _builder.append("\t");
            _builder.append("\"");
            String _name_13 = m.getCConstraint().getLclockconstraint().getClock().getName();
            _builder.append(_name_13, "\t");
            _builder.append(" <= ");
            String _constant_9 = m.getCConstraint().getLclockconstraint().getConstant();
            _builder.append(_constant_9, "\t");
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          boolean _isEquals_1 = m.getCConstraint().getLclockconstraint().getOp().isEquals();
          if (_isEquals_1) {
            _builder.append("\t");
            _builder.append("\"");
            String _name_14 = m.getCConstraint().getLclockconstraint().getClock().getName();
            _builder.append(_name_14, "\t");
            _builder.append(" == ");
            String _constant_10 = m.getCConstraint().getLclockconstraint().getConstant();
            _builder.append(_constant_10, "\t");
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          boolean _isNotequals_1 = m.getCConstraint().getLclockconstraint().getOp().isNotequals();
          if (_isNotequals_1) {
            _builder.append("\t");
            _builder.append("\"");
            String _name_15 = m.getCConstraint().getLclockconstraint().getClock().getName();
            _builder.append(_name_15, "\t");
            _builder.append(" != ");
            String _constant_11 = m.getCConstraint().getLclockconstraint().getConstant();
            _builder.append(_constant_11, "\t");
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("+ \" & \" + ");
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
        {
          boolean _isGreater_2 = m.getCConstraint().getRclockconstraint().getOp().isGreater();
          if (_isGreater_2) {
            _builder.append("\t");
            _builder.append("\"");
            String _name_16 = m.getCConstraint().getRclockconstraint().getClock().getName();
            _builder.append(_name_16, "\t");
            _builder.append(" > ");
            String _constant_12 = m.getCConstraint().getRclockconstraint().getConstant();
            _builder.append(_constant_12, "\t");
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          boolean _isSmaller_2 = m.getCConstraint().getRclockconstraint().getOp().isSmaller();
          if (_isSmaller_2) {
            _builder.append("\t");
            _builder.append("\"");
            String _name_17 = m.getCConstraint().getRclockconstraint().getClock().getName();
            _builder.append(_name_17, "\t");
            _builder.append(" < ");
            String _constant_13 = m.getCConstraint().getRclockconstraint().getConstant();
            _builder.append(_constant_13, "\t");
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          boolean _isGreaterequals_2 = m.getCConstraint().getRclockconstraint().getOp().isGreaterequals();
          if (_isGreaterequals_2) {
            _builder.append("\t");
            _builder.append("\"");
            String _name_18 = m.getCConstraint().getRclockconstraint().getClock().getName();
            _builder.append(_name_18, "\t");
            _builder.append(" >= ");
            String _constant_14 = m.getCConstraint().getRclockconstraint().getConstant();
            _builder.append(_constant_14, "\t");
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          boolean _isSmallerequals_2 = m.getCConstraint().getRclockconstraint().getOp().isSmallerequals();
          if (_isSmallerequals_2) {
            _builder.append("\t");
            _builder.append("\"");
            String _name_19 = m.getCConstraint().getRclockconstraint().getClock().getName();
            _builder.append(_name_19, "\t");
            _builder.append(" <= ");
            String _constant_15 = m.getCConstraint().getRclockconstraint().getConstant();
            _builder.append(_constant_15, "\t");
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          boolean _isEquals_2 = m.getCConstraint().getRclockconstraint().getOp().isEquals();
          if (_isEquals_2) {
            _builder.append("\t");
            _builder.append("\"");
            String _name_20 = m.getCConstraint().getRclockconstraint().getClock().getName();
            _builder.append(_name_20, "\t");
            _builder.append(" == ");
            String _constant_16 = m.getCConstraint().getRclockconstraint().getConstant();
            _builder.append(_constant_16, "\t");
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          boolean _isNotequals_2 = m.getCConstraint().getRclockconstraint().getOp().isNotequals();
          if (_isNotequals_2) {
            _builder.append("\t");
            _builder.append("\"");
            String _name_21 = m.getCConstraint().getRclockconstraint().getClock().getName();
            _builder.append(_name_21, "\t");
            _builder.append(" != ");
            String _constant_17 = m.getCConstraint().getRclockconstraint().getConstant();
            _builder.append(_constant_17, "\t");
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append(", actualState, actualState));");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.newLine();
    _builder.append("newState = new State(\"q\" + counter, StateType.FINAL);");
    _builder.newLine();
    _builder.append("counter++;");
    _builder.newLine();
    _builder.append("b.addTransition(new Transition(\"");
    String _name_22 = m.getSender().getName();
    _builder.append(_name_22);
    _builder.append("\" + \".\" +");
    _builder.newLineIfNotEmpty();
    _builder.append("\"");
    String _name_23 = m.getName();
    _builder.append(_name_23);
    _builder.append("\" + \"(\"");
    _builder.newLineIfNotEmpty();
    {
      EList<Params> _params_1 = m.getParams();
      for(final Params p_2 : _params_1) {
        {
          int _size_4 = p_2.getParams().size();
          ExclusiveRange _doubleDotLessThan_2 = new ExclusiveRange(0, _size_4, true);
          for(final Integer param_2 : _doubleDotLessThan_2) {
            _builder.append("+ \"");
            String _name_24 = p_2.getParams().get((param_2).intValue()).getName();
            _builder.append(_name_24);
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    {
      EList<ConstantParams> _constantparams_1 = m.getConstantparams();
      for(final ConstantParams p_3 : _constantparams_1) {
        {
          int _size_5 = p_3.getValues().size();
          ExclusiveRange _doubleDotLessThan_3 = new ExclusiveRange(0, _size_5, true);
          for(final Integer param_3 : _doubleDotLessThan_3) {
            _builder.append("+");
            _builder.newLine();
            {
              boolean _startsWith_1 = p_3.getValues().get((param_3).intValue()).getValue().startsWith("\"");
              if (_startsWith_1) {
                String _value_2 = p_3.getValues().get((param_3).intValue()).getValue();
                _builder.append(_value_2);
                _builder.newLineIfNotEmpty();
              } else {
                _builder.append("\"");
                String _value_3 = p_3.getValues().get((param_3).intValue()).getValue();
                _builder.append(_value_3);
                _builder.append("\"");
                _builder.newLineIfNotEmpty();
              }
            }
            {
              int _size_6 = p_3.getValues().size();
              int _minus_2 = (_size_6 - 1);
              boolean _notEquals_2 = ((param_3).intValue() != _minus_2);
              if (_notEquals_2) {
                _builder.append("+ \", \"");
                _builder.newLine();
              }
            }
          }
        }
      }
    }
    _builder.append("+ \")\"");
    _builder.newLine();
    _builder.append("+ \".\" + \"");
    String _name_25 = m.getReceiver().getName();
    _builder.append(_name_25);
    _builder.append(";\" + ");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    {
      ClockConstraint _rclockconstraint_1 = m.getCConstraint().getRclockconstraint();
      boolean _tripleEquals_1 = (_rclockconstraint_1 == null);
      if (_tripleEquals_1) {
        {
          boolean _isNot_1 = m.getCConstraint().isNot();
          if (_isNot_1) {
            _builder.append("\"!\" + ");
            _builder.newLine();
          }
        }
        {
          boolean _isGreater_3 = m.getCConstraint().getLclockconstraint().getOp().isGreater();
          if (_isGreater_3) {
            _builder.append("\"");
            String _name_26 = m.getCConstraint().getLclockconstraint().getClock().getName();
            _builder.append(_name_26);
            _builder.append(" > ");
            String _constant_18 = m.getCConstraint().getLclockconstraint().getConstant();
            _builder.append(_constant_18);
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          boolean _isSmaller_3 = m.getCConstraint().getLclockconstraint().getOp().isSmaller();
          if (_isSmaller_3) {
            _builder.append("\"");
            String _name_27 = m.getCConstraint().getLclockconstraint().getClock().getName();
            _builder.append(_name_27);
            _builder.append(" < ");
            String _constant_19 = m.getCConstraint().getLclockconstraint().getConstant();
            _builder.append(_constant_19);
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          boolean _isGreaterequals_3 = m.getCConstraint().getLclockconstraint().getOp().isGreaterequals();
          if (_isGreaterequals_3) {
            _builder.append("\"");
            String _name_28 = m.getCConstraint().getLclockconstraint().getClock().getName();
            _builder.append(_name_28);
            _builder.append(" >= ");
            String _constant_20 = m.getCConstraint().getLclockconstraint().getConstant();
            _builder.append(_constant_20);
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          boolean _isSmallerequals_3 = m.getCConstraint().getLclockconstraint().getOp().isSmallerequals();
          if (_isSmallerequals_3) {
            _builder.append("\"");
            String _name_29 = m.getCConstraint().getLclockconstraint().getClock().getName();
            _builder.append(_name_29);
            _builder.append(" <= ");
            String _constant_21 = m.getCConstraint().getLclockconstraint().getConstant();
            _builder.append(_constant_21);
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          boolean _isEquals_3 = m.getCConstraint().getLclockconstraint().getOp().isEquals();
          if (_isEquals_3) {
            _builder.append("\"");
            String _name_30 = m.getCConstraint().getLclockconstraint().getClock().getName();
            _builder.append(_name_30);
            _builder.append(" == ");
            String _constant_22 = m.getCConstraint().getLclockconstraint().getConstant();
            _builder.append(_constant_22);
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          boolean _isNotequals_3 = m.getCConstraint().getLclockconstraint().getOp().isNotequals();
          if (_isNotequals_3) {
            _builder.append("\"");
            String _name_31 = m.getCConstraint().getLclockconstraint().getClock().getName();
            _builder.append(_name_31);
            _builder.append(" != ");
            String _constant_23 = m.getCConstraint().getLclockconstraint().getConstant();
            _builder.append(_constant_23);
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
      } else {
        {
          boolean _isGreater_4 = m.getCConstraint().getLclockconstraint().getOp().isGreater();
          if (_isGreater_4) {
            _builder.append("\"");
            String _name_32 = m.getCConstraint().getLclockconstraint().getClock().getName();
            _builder.append(_name_32);
            _builder.append(" > ");
            String _constant_24 = m.getCConstraint().getLclockconstraint().getConstant();
            _builder.append(_constant_24);
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          boolean _isSmaller_4 = m.getCConstraint().getLclockconstraint().getOp().isSmaller();
          if (_isSmaller_4) {
            _builder.append("\"");
            String _name_33 = m.getCConstraint().getLclockconstraint().getClock().getName();
            _builder.append(_name_33);
            _builder.append(" < ");
            String _constant_25 = m.getCConstraint().getLclockconstraint().getConstant();
            _builder.append(_constant_25);
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          boolean _isGreaterequals_4 = m.getCConstraint().getLclockconstraint().getOp().isGreaterequals();
          if (_isGreaterequals_4) {
            _builder.append("\"");
            String _name_34 = m.getCConstraint().getLclockconstraint().getClock().getName();
            _builder.append(_name_34);
            _builder.append(" >= ");
            String _constant_26 = m.getCConstraint().getLclockconstraint().getConstant();
            _builder.append(_constant_26);
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          boolean _isSmallerequals_4 = m.getCConstraint().getLclockconstraint().getOp().isSmallerequals();
          if (_isSmallerequals_4) {
            _builder.append("\"");
            String _name_35 = m.getCConstraint().getLclockconstraint().getClock().getName();
            _builder.append(_name_35);
            _builder.append(" <= ");
            String _constant_27 = m.getCConstraint().getLclockconstraint().getConstant();
            _builder.append(_constant_27);
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          boolean _isEquals_4 = m.getCConstraint().getLclockconstraint().getOp().isEquals();
          if (_isEquals_4) {
            _builder.append("\"");
            String _name_36 = m.getCConstraint().getLclockconstraint().getClock().getName();
            _builder.append(_name_36);
            _builder.append(" == ");
            String _constant_28 = m.getCConstraint().getLclockconstraint().getConstant();
            _builder.append(_constant_28);
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          boolean _isNotequals_4 = m.getCConstraint().getLclockconstraint().getOp().isNotequals();
          if (_isNotequals_4) {
            _builder.append("\"");
            String _name_37 = m.getCConstraint().getLclockconstraint().getClock().getName();
            _builder.append(_name_37);
            _builder.append(" != ");
            String _constant_29 = m.getCConstraint().getLclockconstraint().getConstant();
            _builder.append(_constant_29);
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.newLine();
        _builder.append("+ \" & \" + ");
        _builder.newLine();
        _builder.newLine();
        {
          boolean _isGreater_5 = m.getCConstraint().getRclockconstraint().getOp().isGreater();
          if (_isGreater_5) {
            _builder.append("\"");
            String _name_38 = m.getCConstraint().getRclockconstraint().getClock().getName();
            _builder.append(_name_38);
            _builder.append(" > ");
            String _constant_30 = m.getCConstraint().getRclockconstraint().getConstant();
            _builder.append(_constant_30);
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          boolean _isSmaller_5 = m.getCConstraint().getRclockconstraint().getOp().isSmaller();
          if (_isSmaller_5) {
            _builder.append("\"");
            String _name_39 = m.getCConstraint().getRclockconstraint().getClock().getName();
            _builder.append(_name_39);
            _builder.append(" < ");
            String _constant_31 = m.getCConstraint().getRclockconstraint().getConstant();
            _builder.append(_constant_31);
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          boolean _isGreaterequals_5 = m.getCConstraint().getRclockconstraint().getOp().isGreaterequals();
          if (_isGreaterequals_5) {
            _builder.append("\"");
            String _name_40 = m.getCConstraint().getRclockconstraint().getClock().getName();
            _builder.append(_name_40);
            _builder.append(" >= ");
            String _constant_32 = m.getCConstraint().getRclockconstraint().getConstant();
            _builder.append(_constant_32);
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          boolean _isSmallerequals_5 = m.getCConstraint().getRclockconstraint().getOp().isSmallerequals();
          if (_isSmallerequals_5) {
            _builder.append("\"");
            String _name_41 = m.getCConstraint().getRclockconstraint().getClock().getName();
            _builder.append(_name_41);
            _builder.append(" <= ");
            String _constant_33 = m.getCConstraint().getRclockconstraint().getConstant();
            _builder.append(_constant_33);
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          boolean _isEquals_5 = m.getCConstraint().getRclockconstraint().getOp().isEquals();
          if (_isEquals_5) {
            _builder.append("\"");
            String _name_42 = m.getCConstraint().getRclockconstraint().getClock().getName();
            _builder.append(_name_42);
            _builder.append(" == ");
            String _constant_34 = m.getCConstraint().getRclockconstraint().getConstant();
            _builder.append(_constant_34);
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          boolean _isNotequals_5 = m.getCConstraint().getRclockconstraint().getOp().isNotequals();
          if (_isNotequals_5) {
            _builder.append("\"");
            String _name_43 = m.getCConstraint().getRclockconstraint().getClock().getName();
            _builder.append(_name_43);
            _builder.append(" != ");
            String _constant_35 = m.getCConstraint().getRclockconstraint().getConstant();
            _builder.append(_constant_35);
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    _builder.newLine();
    {
      ResetClock _resetclock = m.getResetclock();
      boolean _tripleNotEquals = (_resetclock != null);
      if (_tripleNotEquals) {
        _builder.append("+ \"; ");
        String _name_44 = m.getResetclock().getClock().getName();
        _builder.append(_name_44);
        _builder.append(" = 0\"");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    _builder.append(", actualState, newState));");
    _builder.newLine();
    _builder.append("b.addState(newState);");
    _builder.newLine();
    _builder.append("b.setFinale(newState);");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence compile_future_clock(final Message m) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("b = new Automaton(\"auto30\");");
    _builder.newLine();
    _builder.append("actualState = new State(\"q\" + counter, StateType.NORMAL);");
    _builder.newLine();
    _builder.append("counter++;");
    _builder.newLine();
    _builder.append("b.addState(actualState);");
    _builder.newLine();
    _builder.append("b.setInitial(actualState);");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t\t");
    _builder.newLine();
    _builder.append("b.addTransition(new Transition(\"!(\" + \"");
    String _name = m.getSender().getName();
    _builder.append(_name);
    _builder.append("\" + \".\" +\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("\"");
    String _name_1 = m.getName();
    _builder.append(_name_1, "\t");
    _builder.append("\" + \"(\"");
    _builder.newLineIfNotEmpty();
    {
      EList<Params> _params = m.getParams();
      for(final Params p : _params) {
        {
          int _size = p.getParams().size();
          ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size, true);
          for(final Integer param : _doubleDotLessThan) {
            _builder.append("\t");
            _builder.append("+ \"");
            String _name_2 = p.getParams().get((param).intValue()).getName();
            _builder.append(_name_2, "\t");
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
            {
              int _size_1 = p.getParams().size();
              int _minus = (_size_1 - 1);
              boolean _notEquals = ((param).intValue() != _minus);
              if (_notEquals) {
                _builder.append("\t");
                _builder.append("+ \", \"");
                _builder.newLine();
              }
            }
          }
        }
      }
    }
    {
      EList<ConstantParams> _constantparams = m.getConstantparams();
      for(final ConstantParams p_1 : _constantparams) {
        {
          int _size_2 = p_1.getValues().size();
          ExclusiveRange _doubleDotLessThan_1 = new ExclusiveRange(0, _size_2, true);
          for(final Integer param_1 : _doubleDotLessThan_1) {
            _builder.append("\t");
            _builder.append("+");
            _builder.newLine();
            {
              boolean _startsWith = p_1.getValues().get((param_1).intValue()).getValue().startsWith("\"");
              if (_startsWith) {
                _builder.append("\t");
                String _value = p_1.getValues().get((param_1).intValue()).getValue();
                _builder.append(_value, "\t");
                _builder.newLineIfNotEmpty();
              } else {
                _builder.append("\t");
                _builder.append("\"");
                String _value_1 = p_1.getValues().get((param_1).intValue()).getValue();
                _builder.append(_value_1, "\t");
                _builder.append("\"");
                _builder.newLineIfNotEmpty();
              }
            }
            {
              int _size_3 = p_1.getValues().size();
              int _minus_1 = (_size_3 - 1);
              boolean _notEquals_1 = ((param_1).intValue() != _minus_1);
              if (_notEquals_1) {
                _builder.append("\t");
                _builder.append("+ \", \"");
                _builder.newLine();
              }
            }
          }
        }
      }
    }
    _builder.append("\t");
    _builder.append("+ \")\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("+ \".\" + \"");
    String _name_3 = m.getReceiver().getName();
    _builder.append(_name_3, "\t");
    _builder.append("); \" + ");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    {
      ClockConstraint _rclockconstraint = m.getCConstraint().getRclockconstraint();
      boolean _tripleEquals = (_rclockconstraint == null);
      if (_tripleEquals) {
        {
          boolean _isNot = m.getCConstraint().isNot();
          if (_isNot) {
            _builder.append("\t");
            _builder.append("\"!\" + ");
            _builder.newLine();
          }
        }
        {
          boolean _isGreater = m.getCConstraint().getLclockconstraint().getOp().isGreater();
          if (_isGreater) {
            _builder.append("\t");
            _builder.append("\"");
            String _name_4 = m.getCConstraint().getLclockconstraint().getClock().getName();
            _builder.append(_name_4, "\t");
            _builder.append(" > ");
            String _constant = m.getCConstraint().getLclockconstraint().getConstant();
            _builder.append(_constant, "\t");
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          boolean _isSmaller = m.getCConstraint().getLclockconstraint().getOp().isSmaller();
          if (_isSmaller) {
            _builder.append("\t");
            _builder.append("\"");
            String _name_5 = m.getCConstraint().getLclockconstraint().getClock().getName();
            _builder.append(_name_5, "\t");
            _builder.append(" < ");
            String _constant_1 = m.getCConstraint().getLclockconstraint().getConstant();
            _builder.append(_constant_1, "\t");
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          boolean _isGreaterequals = m.getCConstraint().getLclockconstraint().getOp().isGreaterequals();
          if (_isGreaterequals) {
            _builder.append("\t");
            _builder.append("\"");
            String _name_6 = m.getCConstraint().getLclockconstraint().getClock().getName();
            _builder.append(_name_6, "\t");
            _builder.append(" >= ");
            String _constant_2 = m.getCConstraint().getLclockconstraint().getConstant();
            _builder.append(_constant_2, "\t");
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          boolean _isSmallerequals = m.getCConstraint().getLclockconstraint().getOp().isSmallerequals();
          if (_isSmallerequals) {
            _builder.append("\t");
            _builder.append("\"");
            String _name_7 = m.getCConstraint().getLclockconstraint().getClock().getName();
            _builder.append(_name_7, "\t");
            _builder.append(" <= ");
            String _constant_3 = m.getCConstraint().getLclockconstraint().getConstant();
            _builder.append(_constant_3, "\t");
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          boolean _isEquals = m.getCConstraint().getLclockconstraint().getOp().isEquals();
          if (_isEquals) {
            _builder.append("\t");
            _builder.append("\"");
            String _name_8 = m.getCConstraint().getLclockconstraint().getClock().getName();
            _builder.append(_name_8, "\t");
            _builder.append(" == ");
            String _constant_4 = m.getCConstraint().getLclockconstraint().getConstant();
            _builder.append(_constant_4, "\t");
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          boolean _isNotequals = m.getCConstraint().getLclockconstraint().getOp().isNotequals();
          if (_isNotequals) {
            _builder.append("\t");
            _builder.append("\"");
            String _name_9 = m.getCConstraint().getLclockconstraint().getClock().getName();
            _builder.append(_name_9, "\t");
            _builder.append(" != ");
            String _constant_5 = m.getCConstraint().getLclockconstraint().getConstant();
            _builder.append(_constant_5, "\t");
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
      } else {
        {
          boolean _isGreater_1 = m.getCConstraint().getLclockconstraint().getOp().isGreater();
          if (_isGreater_1) {
            _builder.append("\t");
            _builder.append("\"");
            String _name_10 = m.getCConstraint().getLclockconstraint().getClock().getName();
            _builder.append(_name_10, "\t");
            _builder.append(" > ");
            String _constant_6 = m.getCConstraint().getLclockconstraint().getConstant();
            _builder.append(_constant_6, "\t");
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          boolean _isSmaller_1 = m.getCConstraint().getLclockconstraint().getOp().isSmaller();
          if (_isSmaller_1) {
            _builder.append("\t");
            _builder.append("\"");
            String _name_11 = m.getCConstraint().getLclockconstraint().getClock().getName();
            _builder.append(_name_11, "\t");
            _builder.append(" < ");
            String _constant_7 = m.getCConstraint().getLclockconstraint().getConstant();
            _builder.append(_constant_7, "\t");
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          boolean _isGreaterequals_1 = m.getCConstraint().getLclockconstraint().getOp().isGreaterequals();
          if (_isGreaterequals_1) {
            _builder.append("\t");
            _builder.append("\"");
            String _name_12 = m.getCConstraint().getLclockconstraint().getClock().getName();
            _builder.append(_name_12, "\t");
            _builder.append(" >= ");
            String _constant_8 = m.getCConstraint().getLclockconstraint().getConstant();
            _builder.append(_constant_8, "\t");
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          boolean _isSmallerequals_1 = m.getCConstraint().getLclockconstraint().getOp().isSmallerequals();
          if (_isSmallerequals_1) {
            _builder.append("\t");
            _builder.append("\"");
            String _name_13 = m.getCConstraint().getLclockconstraint().getClock().getName();
            _builder.append(_name_13, "\t");
            _builder.append(" <= ");
            String _constant_9 = m.getCConstraint().getLclockconstraint().getConstant();
            _builder.append(_constant_9, "\t");
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          boolean _isEquals_1 = m.getCConstraint().getLclockconstraint().getOp().isEquals();
          if (_isEquals_1) {
            _builder.append("\t");
            _builder.append("\"");
            String _name_14 = m.getCConstraint().getLclockconstraint().getClock().getName();
            _builder.append(_name_14, "\t");
            _builder.append(" == ");
            String _constant_10 = m.getCConstraint().getLclockconstraint().getConstant();
            _builder.append(_constant_10, "\t");
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          boolean _isNotequals_1 = m.getCConstraint().getLclockconstraint().getOp().isNotequals();
          if (_isNotequals_1) {
            _builder.append("\t");
            _builder.append("\"");
            String _name_15 = m.getCConstraint().getLclockconstraint().getClock().getName();
            _builder.append(_name_15, "\t");
            _builder.append(" != ");
            String _constant_11 = m.getCConstraint().getLclockconstraint().getConstant();
            _builder.append(_constant_11, "\t");
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("+ \" & \" + ");
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
        {
          boolean _isGreater_2 = m.getCConstraint().getRclockconstraint().getOp().isGreater();
          if (_isGreater_2) {
            _builder.append("\t");
            _builder.append("\"");
            String _name_16 = m.getCConstraint().getRclockconstraint().getClock().getName();
            _builder.append(_name_16, "\t");
            _builder.append(" > ");
            String _constant_12 = m.getCConstraint().getRclockconstraint().getConstant();
            _builder.append(_constant_12, "\t");
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          boolean _isSmaller_2 = m.getCConstraint().getRclockconstraint().getOp().isSmaller();
          if (_isSmaller_2) {
            _builder.append("\t");
            _builder.append("\"");
            String _name_17 = m.getCConstraint().getRclockconstraint().getClock().getName();
            _builder.append(_name_17, "\t");
            _builder.append(" < ");
            String _constant_13 = m.getCConstraint().getRclockconstraint().getConstant();
            _builder.append(_constant_13, "\t");
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          boolean _isGreaterequals_2 = m.getCConstraint().getRclockconstraint().getOp().isGreaterequals();
          if (_isGreaterequals_2) {
            _builder.append("\t");
            _builder.append("\"");
            String _name_18 = m.getCConstraint().getRclockconstraint().getClock().getName();
            _builder.append(_name_18, "\t");
            _builder.append(" >= ");
            String _constant_14 = m.getCConstraint().getRclockconstraint().getConstant();
            _builder.append(_constant_14, "\t");
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          boolean _isSmallerequals_2 = m.getCConstraint().getRclockconstraint().getOp().isSmallerequals();
          if (_isSmallerequals_2) {
            _builder.append("\t");
            _builder.append("\"");
            String _name_19 = m.getCConstraint().getRclockconstraint().getClock().getName();
            _builder.append(_name_19, "\t");
            _builder.append(" <= ");
            String _constant_15 = m.getCConstraint().getRclockconstraint().getConstant();
            _builder.append(_constant_15, "\t");
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          boolean _isEquals_2 = m.getCConstraint().getRclockconstraint().getOp().isEquals();
          if (_isEquals_2) {
            _builder.append("\t");
            _builder.append("\"");
            String _name_20 = m.getCConstraint().getRclockconstraint().getClock().getName();
            _builder.append(_name_20, "\t");
            _builder.append(" == ");
            String _constant_16 = m.getCConstraint().getRclockconstraint().getConstant();
            _builder.append(_constant_16, "\t");
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          boolean _isNotequals_2 = m.getCConstraint().getRclockconstraint().getOp().isNotequals();
          if (_isNotequals_2) {
            _builder.append("\t");
            _builder.append("\"");
            String _name_21 = m.getCConstraint().getRclockconstraint().getClock().getName();
            _builder.append(_name_21, "\t");
            _builder.append(" != ");
            String _constant_17 = m.getCConstraint().getRclockconstraint().getConstant();
            _builder.append(_constant_17, "\t");
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append(", actualState, actualState));");
    _builder.newLine();
    _builder.newLine();
    _builder.append("newState = new State(\"q\" + counter, StateType.NORMAL);");
    _builder.newLine();
    _builder.append("counter++;");
    _builder.newLine();
    _builder.append("b.addTransition(new Transition(str + \" & \" + \"");
    String _name_22 = m.getSender().getName();
    _builder.append(_name_22);
    _builder.append("\" + \".\" +");
    _builder.newLineIfNotEmpty();
    _builder.append("\"");
    String _name_23 = m.getName();
    _builder.append(_name_23);
    _builder.append("\" + \"(\"");
    _builder.newLineIfNotEmpty();
    {
      EList<Params> _params_1 = m.getParams();
      for(final Params p_2 : _params_1) {
        {
          int _size_4 = p_2.getParams().size();
          ExclusiveRange _doubleDotLessThan_2 = new ExclusiveRange(0, _size_4, true);
          for(final Integer param_2 : _doubleDotLessThan_2) {
            _builder.append("+ \"");
            String _name_24 = p_2.getParams().get((param_2).intValue()).getName();
            _builder.append(_name_24);
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
            {
              int _size_5 = p_2.getParams().size();
              int _minus_2 = (_size_5 - 1);
              boolean _notEquals_2 = ((param_2).intValue() != _minus_2);
              if (_notEquals_2) {
                _builder.append("+ \", \"");
                _builder.newLine();
              }
            }
          }
        }
      }
    }
    {
      EList<ConstantParams> _constantparams_1 = m.getConstantparams();
      for(final ConstantParams p_3 : _constantparams_1) {
        {
          int _size_6 = p_3.getValues().size();
          ExclusiveRange _doubleDotLessThan_3 = new ExclusiveRange(0, _size_6, true);
          for(final Integer param_3 : _doubleDotLessThan_3) {
            _builder.append("+");
            _builder.newLine();
            {
              boolean _startsWith_1 = p_3.getValues().get((param_3).intValue()).getValue().startsWith("\"");
              if (_startsWith_1) {
                String _value_2 = p_3.getValues().get((param_3).intValue()).getValue();
                _builder.append(_value_2);
                _builder.newLineIfNotEmpty();
              } else {
                _builder.append("\"");
                String _value_3 = p_3.getValues().get((param_3).intValue()).getValue();
                _builder.append(_value_3);
                _builder.append("\"");
                _builder.newLineIfNotEmpty();
              }
            }
            {
              int _size_7 = p_3.getValues().size();
              int _minus_3 = (_size_7 - 1);
              boolean _notEquals_3 = ((param_3).intValue() != _minus_3);
              if (_notEquals_3) {
                _builder.append("+ \", \"");
                _builder.newLine();
              }
            }
          }
        }
      }
    }
    _builder.append("+ \")\"");
    _builder.newLine();
    _builder.newLine();
    _builder.append("+ \".\" + \"");
    String _name_25 = m.getReceiver().getName();
    _builder.append(_name_25);
    _builder.append("; \" +");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    {
      ClockConstraint _rclockconstraint_1 = m.getCConstraint().getRclockconstraint();
      boolean _tripleEquals_1 = (_rclockconstraint_1 == null);
      if (_tripleEquals_1) {
        {
          boolean _isNot_1 = m.getCConstraint().isNot();
          if (_isNot_1) {
            _builder.append("\"!\" + ");
            _builder.newLine();
          }
        }
        {
          boolean _isGreater_3 = m.getCConstraint().getLclockconstraint().getOp().isGreater();
          if (_isGreater_3) {
            _builder.append("\"");
            String _name_26 = m.getCConstraint().getLclockconstraint().getClock().getName();
            _builder.append(_name_26);
            _builder.append(" > ");
            String _constant_18 = m.getCConstraint().getLclockconstraint().getConstant();
            _builder.append(_constant_18);
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          boolean _isSmaller_3 = m.getCConstraint().getLclockconstraint().getOp().isSmaller();
          if (_isSmaller_3) {
            _builder.append("\"");
            String _name_27 = m.getCConstraint().getLclockconstraint().getClock().getName();
            _builder.append(_name_27);
            _builder.append(" < ");
            String _constant_19 = m.getCConstraint().getLclockconstraint().getConstant();
            _builder.append(_constant_19);
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          boolean _isGreaterequals_3 = m.getCConstraint().getLclockconstraint().getOp().isGreaterequals();
          if (_isGreaterequals_3) {
            _builder.append("\"");
            String _name_28 = m.getCConstraint().getLclockconstraint().getClock().getName();
            _builder.append(_name_28);
            _builder.append(" >= ");
            String _constant_20 = m.getCConstraint().getLclockconstraint().getConstant();
            _builder.append(_constant_20);
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          boolean _isSmallerequals_3 = m.getCConstraint().getLclockconstraint().getOp().isSmallerequals();
          if (_isSmallerequals_3) {
            _builder.append("\"");
            String _name_29 = m.getCConstraint().getLclockconstraint().getClock().getName();
            _builder.append(_name_29);
            _builder.append(" <= ");
            String _constant_21 = m.getCConstraint().getLclockconstraint().getConstant();
            _builder.append(_constant_21);
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          boolean _isEquals_3 = m.getCConstraint().getLclockconstraint().getOp().isEquals();
          if (_isEquals_3) {
            _builder.append("\"");
            String _name_30 = m.getCConstraint().getLclockconstraint().getClock().getName();
            _builder.append(_name_30);
            _builder.append(" == ");
            String _constant_22 = m.getCConstraint().getLclockconstraint().getConstant();
            _builder.append(_constant_22);
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          boolean _isNotequals_3 = m.getCConstraint().getLclockconstraint().getOp().isNotequals();
          if (_isNotequals_3) {
            _builder.append("\"");
            String _name_31 = m.getCConstraint().getLclockconstraint().getClock().getName();
            _builder.append(_name_31);
            _builder.append(" != ");
            String _constant_23 = m.getCConstraint().getLclockconstraint().getConstant();
            _builder.append(_constant_23);
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
      } else {
        {
          boolean _isGreater_4 = m.getCConstraint().getLclockconstraint().getOp().isGreater();
          if (_isGreater_4) {
            _builder.append("\"");
            String _name_32 = m.getCConstraint().getLclockconstraint().getClock().getName();
            _builder.append(_name_32);
            _builder.append(" > ");
            String _constant_24 = m.getCConstraint().getLclockconstraint().getConstant();
            _builder.append(_constant_24);
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          boolean _isSmaller_4 = m.getCConstraint().getLclockconstraint().getOp().isSmaller();
          if (_isSmaller_4) {
            _builder.append("\"");
            String _name_33 = m.getCConstraint().getLclockconstraint().getClock().getName();
            _builder.append(_name_33);
            _builder.append(" < ");
            String _constant_25 = m.getCConstraint().getLclockconstraint().getConstant();
            _builder.append(_constant_25);
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          boolean _isGreaterequals_4 = m.getCConstraint().getLclockconstraint().getOp().isGreaterequals();
          if (_isGreaterequals_4) {
            _builder.append("\"");
            String _name_34 = m.getCConstraint().getLclockconstraint().getClock().getName();
            _builder.append(_name_34);
            _builder.append(" >= ");
            String _constant_26 = m.getCConstraint().getLclockconstraint().getConstant();
            _builder.append(_constant_26);
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          boolean _isSmallerequals_4 = m.getCConstraint().getLclockconstraint().getOp().isSmallerequals();
          if (_isSmallerequals_4) {
            _builder.append("\"");
            String _name_35 = m.getCConstraint().getLclockconstraint().getClock().getName();
            _builder.append(_name_35);
            _builder.append(" <= ");
            String _constant_27 = m.getCConstraint().getLclockconstraint().getConstant();
            _builder.append(_constant_27);
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          boolean _isEquals_4 = m.getCConstraint().getLclockconstraint().getOp().isEquals();
          if (_isEquals_4) {
            _builder.append("\"");
            String _name_36 = m.getCConstraint().getLclockconstraint().getClock().getName();
            _builder.append(_name_36);
            _builder.append(" == ");
            String _constant_28 = m.getCConstraint().getLclockconstraint().getConstant();
            _builder.append(_constant_28);
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          boolean _isNotequals_4 = m.getCConstraint().getLclockconstraint().getOp().isNotequals();
          if (_isNotequals_4) {
            _builder.append("\"");
            String _name_37 = m.getCConstraint().getLclockconstraint().getClock().getName();
            _builder.append(_name_37);
            _builder.append(" != ");
            String _constant_29 = m.getCConstraint().getLclockconstraint().getConstant();
            _builder.append(_constant_29);
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.newLine();
        _builder.append("+ \" & \" + ");
        _builder.newLine();
        _builder.newLine();
        {
          boolean _isGreater_5 = m.getCConstraint().getRclockconstraint().getOp().isGreater();
          if (_isGreater_5) {
            _builder.append("\"");
            String _name_38 = m.getCConstraint().getRclockconstraint().getClock().getName();
            _builder.append(_name_38);
            _builder.append(" > ");
            String _constant_30 = m.getCConstraint().getRclockconstraint().getConstant();
            _builder.append(_constant_30);
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          boolean _isSmaller_5 = m.getCConstraint().getRclockconstraint().getOp().isSmaller();
          if (_isSmaller_5) {
            _builder.append("\"");
            String _name_39 = m.getCConstraint().getRclockconstraint().getClock().getName();
            _builder.append(_name_39);
            _builder.append(" < ");
            String _constant_31 = m.getCConstraint().getRclockconstraint().getConstant();
            _builder.append(_constant_31);
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          boolean _isGreaterequals_5 = m.getCConstraint().getRclockconstraint().getOp().isGreaterequals();
          if (_isGreaterequals_5) {
            _builder.append("\"");
            String _name_40 = m.getCConstraint().getRclockconstraint().getClock().getName();
            _builder.append(_name_40);
            _builder.append(" >= ");
            String _constant_32 = m.getCConstraint().getRclockconstraint().getConstant();
            _builder.append(_constant_32);
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          boolean _isSmallerequals_5 = m.getCConstraint().getRclockconstraint().getOp().isSmallerequals();
          if (_isSmallerequals_5) {
            _builder.append("\"");
            String _name_41 = m.getCConstraint().getRclockconstraint().getClock().getName();
            _builder.append(_name_41);
            _builder.append(" <= ");
            String _constant_33 = m.getCConstraint().getRclockconstraint().getConstant();
            _builder.append(_constant_33);
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          boolean _isEquals_5 = m.getCConstraint().getRclockconstraint().getOp().isEquals();
          if (_isEquals_5) {
            _builder.append("\"");
            String _name_42 = m.getCConstraint().getRclockconstraint().getClock().getName();
            _builder.append(_name_42);
            _builder.append(" == ");
            String _constant_34 = m.getCConstraint().getRclockconstraint().getConstant();
            _builder.append(_constant_34);
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          boolean _isNotequals_5 = m.getCConstraint().getRclockconstraint().getOp().isNotequals();
          if (_isNotequals_5) {
            _builder.append("\"");
            String _name_43 = m.getCConstraint().getRclockconstraint().getClock().getName();
            _builder.append(_name_43);
            _builder.append(" != ");
            String _constant_35 = m.getCConstraint().getRclockconstraint().getConstant();
            _builder.append(_constant_35);
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    _builder.newLine();
    {
      ResetClock _resetclock = m.getResetclock();
      boolean _tripleNotEquals = (_resetclock != null);
      if (_tripleNotEquals) {
        _builder.append("+ \"; ");
        String _name_44 = m.getResetclock().getClock().getName();
        _builder.append(_name_44);
        _builder.append(" = 0\"");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    _builder.append(" ");
    _builder.append(", actualState, newState));");
    _builder.newLine();
    _builder.append("b.addState(newState);");
    _builder.newLine();
    _builder.newLine();
    CharSequence _compile_constraint_msg = this.compile_constraint_msg(m);
    _builder.append(_compile_constraint_msg);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("b.addTransition(new Transition(\"!\" + str1, newState, actualState));");
    _builder.newLine();
    _builder.newLine();
    _builder.append("finalState = new State(\"q\" + counter, StateType.FINAL);");
    _builder.newLine();
    _builder.append("b.addTransition(newTransition(str, newState, finalState));");
    _builder.newLine();
    _builder.append("b.addState(finalState);");
    _builder.newLine();
    _builder.append("b.setFinale(finalState);");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence compile_future_strict_clock(final Message m) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("b = new Automaton(\"auto12\");");
    _builder.newLine();
    _builder.append("actualState = new State(\"q\" + counter, StateType.NORMAL);");
    _builder.newLine();
    _builder.append("counter++;");
    _builder.newLine();
    _builder.append("b.addState(actualState);");
    _builder.newLine();
    _builder.append("b.setInitial(actualState);");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t\t\t");
    _builder.newLine();
    _builder.append("newState = new State(\"q\" + counter, StateType.FINAL);");
    _builder.newLine();
    _builder.append("counter++;");
    _builder.newLine();
    _builder.append("b.addTransition(new Transition(str + \" & \" + \"");
    String _name = m.getSender().getName();
    _builder.append(_name);
    _builder.append("\" + \".\" +");
    _builder.newLineIfNotEmpty();
    _builder.append("\"");
    String _name_1 = m.getName();
    _builder.append(_name_1);
    _builder.append("\" + \"(\"");
    _builder.newLineIfNotEmpty();
    {
      EList<Params> _params = m.getParams();
      for(final Params p : _params) {
        {
          int _size = p.getParams().size();
          ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size, true);
          for(final Integer param : _doubleDotLessThan) {
            _builder.append("+ \"");
            String _name_2 = p.getParams().get((param).intValue()).getName();
            _builder.append(_name_2);
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
            {
              int _size_1 = p.getParams().size();
              int _minus = (_size_1 - 1);
              boolean _notEquals = ((param).intValue() != _minus);
              if (_notEquals) {
                _builder.append("+ \", \"");
                _builder.newLine();
              }
            }
          }
        }
      }
    }
    {
      EList<ConstantParams> _constantparams = m.getConstantparams();
      for(final ConstantParams p_1 : _constantparams) {
        {
          int _size_2 = p_1.getValues().size();
          ExclusiveRange _doubleDotLessThan_1 = new ExclusiveRange(0, _size_2, true);
          for(final Integer param_1 : _doubleDotLessThan_1) {
            _builder.append("+");
            _builder.newLine();
            {
              boolean _startsWith = p_1.getValues().get((param_1).intValue()).getValue().startsWith("\"");
              if (_startsWith) {
                String _value = p_1.getValues().get((param_1).intValue()).getValue();
                _builder.append(_value);
                _builder.newLineIfNotEmpty();
              } else {
                _builder.append("\"");
                String _value_1 = p_1.getValues().get((param_1).intValue()).getValue();
                _builder.append(_value_1);
                _builder.append("\"");
                _builder.newLineIfNotEmpty();
              }
            }
            {
              int _size_3 = p_1.getValues().size();
              int _minus_1 = (_size_3 - 1);
              boolean _notEquals_1 = ((param_1).intValue() != _minus_1);
              if (_notEquals_1) {
                _builder.append("+ \", \"");
                _builder.newLine();
              }
            }
          }
        }
      }
    }
    _builder.append("+ \")\"");
    _builder.newLine();
    _builder.append("+ \".\" + \"");
    String _name_3 = m.getReceiver().getName();
    _builder.append(_name_3);
    _builder.append(";\" +");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    {
      ClockConstraint _rclockconstraint = m.getCConstraint().getRclockconstraint();
      boolean _tripleEquals = (_rclockconstraint == null);
      if (_tripleEquals) {
        {
          boolean _isNot = m.getCConstraint().isNot();
          if (_isNot) {
            _builder.append("\"!\" + ");
            _builder.newLine();
          }
        }
        {
          boolean _isGreater = m.getCConstraint().getLclockconstraint().getOp().isGreater();
          if (_isGreater) {
            _builder.append("\"");
            String _name_4 = m.getCConstraint().getLclockconstraint().getClock().getName();
            _builder.append(_name_4);
            _builder.append(" > ");
            String _constant = m.getCConstraint().getLclockconstraint().getConstant();
            _builder.append(_constant);
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          boolean _isSmaller = m.getCConstraint().getLclockconstraint().getOp().isSmaller();
          if (_isSmaller) {
            _builder.append("\"");
            String _name_5 = m.getCConstraint().getLclockconstraint().getClock().getName();
            _builder.append(_name_5);
            _builder.append(" < ");
            String _constant_1 = m.getCConstraint().getLclockconstraint().getConstant();
            _builder.append(_constant_1);
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          boolean _isGreaterequals = m.getCConstraint().getLclockconstraint().getOp().isGreaterequals();
          if (_isGreaterequals) {
            _builder.append("\"");
            String _name_6 = m.getCConstraint().getLclockconstraint().getClock().getName();
            _builder.append(_name_6);
            _builder.append(" >= ");
            String _constant_2 = m.getCConstraint().getLclockconstraint().getConstant();
            _builder.append(_constant_2);
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          boolean _isSmallerequals = m.getCConstraint().getLclockconstraint().getOp().isSmallerequals();
          if (_isSmallerequals) {
            _builder.append("\"");
            String _name_7 = m.getCConstraint().getLclockconstraint().getClock().getName();
            _builder.append(_name_7);
            _builder.append(" <= ");
            String _constant_3 = m.getCConstraint().getLclockconstraint().getConstant();
            _builder.append(_constant_3);
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          boolean _isEquals = m.getCConstraint().getLclockconstraint().getOp().isEquals();
          if (_isEquals) {
            _builder.append("\"");
            String _name_8 = m.getCConstraint().getLclockconstraint().getClock().getName();
            _builder.append(_name_8);
            _builder.append(" == ");
            String _constant_4 = m.getCConstraint().getLclockconstraint().getConstant();
            _builder.append(_constant_4);
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          boolean _isNotequals = m.getCConstraint().getLclockconstraint().getOp().isNotequals();
          if (_isNotequals) {
            _builder.append("\"");
            String _name_9 = m.getCConstraint().getLclockconstraint().getClock().getName();
            _builder.append(_name_9);
            _builder.append(" != ");
            String _constant_5 = m.getCConstraint().getLclockconstraint().getConstant();
            _builder.append(_constant_5);
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
      } else {
        {
          boolean _isGreater_1 = m.getCConstraint().getLclockconstraint().getOp().isGreater();
          if (_isGreater_1) {
            _builder.append("\"");
            String _name_10 = m.getCConstraint().getLclockconstraint().getClock().getName();
            _builder.append(_name_10);
            _builder.append(" > ");
            String _constant_6 = m.getCConstraint().getLclockconstraint().getConstant();
            _builder.append(_constant_6);
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          boolean _isSmaller_1 = m.getCConstraint().getLclockconstraint().getOp().isSmaller();
          if (_isSmaller_1) {
            _builder.append("\"");
            String _name_11 = m.getCConstraint().getLclockconstraint().getClock().getName();
            _builder.append(_name_11);
            _builder.append(" < ");
            String _constant_7 = m.getCConstraint().getLclockconstraint().getConstant();
            _builder.append(_constant_7);
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          boolean _isGreaterequals_1 = m.getCConstraint().getLclockconstraint().getOp().isGreaterequals();
          if (_isGreaterequals_1) {
            _builder.append("\"");
            String _name_12 = m.getCConstraint().getLclockconstraint().getClock().getName();
            _builder.append(_name_12);
            _builder.append(" >= ");
            String _constant_8 = m.getCConstraint().getLclockconstraint().getConstant();
            _builder.append(_constant_8);
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          boolean _isSmallerequals_1 = m.getCConstraint().getLclockconstraint().getOp().isSmallerequals();
          if (_isSmallerequals_1) {
            _builder.append("\"");
            String _name_13 = m.getCConstraint().getLclockconstraint().getClock().getName();
            _builder.append(_name_13);
            _builder.append(" <= ");
            String _constant_9 = m.getCConstraint().getLclockconstraint().getConstant();
            _builder.append(_constant_9);
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          boolean _isEquals_1 = m.getCConstraint().getLclockconstraint().getOp().isEquals();
          if (_isEquals_1) {
            _builder.append("\"");
            String _name_14 = m.getCConstraint().getLclockconstraint().getClock().getName();
            _builder.append(_name_14);
            _builder.append(" == ");
            String _constant_10 = m.getCConstraint().getLclockconstraint().getConstant();
            _builder.append(_constant_10);
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          boolean _isNotequals_1 = m.getCConstraint().getLclockconstraint().getOp().isNotequals();
          if (_isNotequals_1) {
            _builder.append("\"");
            String _name_15 = m.getCConstraint().getLclockconstraint().getClock().getName();
            _builder.append(_name_15);
            _builder.append(" != ");
            String _constant_11 = m.getCConstraint().getLclockconstraint().getConstant();
            _builder.append(_constant_11);
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.newLine();
        _builder.append("+ \" & \" + ");
        _builder.newLine();
        _builder.newLine();
        {
          boolean _isGreater_2 = m.getCConstraint().getRclockconstraint().getOp().isGreater();
          if (_isGreater_2) {
            _builder.append("\"");
            String _name_16 = m.getCConstraint().getRclockconstraint().getClock().getName();
            _builder.append(_name_16);
            _builder.append(" > ");
            String _constant_12 = m.getCConstraint().getRclockconstraint().getConstant();
            _builder.append(_constant_12);
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          boolean _isSmaller_2 = m.getCConstraint().getRclockconstraint().getOp().isSmaller();
          if (_isSmaller_2) {
            _builder.append("\"");
            String _name_17 = m.getCConstraint().getRclockconstraint().getClock().getName();
            _builder.append(_name_17);
            _builder.append(" < ");
            String _constant_13 = m.getCConstraint().getRclockconstraint().getConstant();
            _builder.append(_constant_13);
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          boolean _isGreaterequals_2 = m.getCConstraint().getRclockconstraint().getOp().isGreaterequals();
          if (_isGreaterequals_2) {
            _builder.append("\"");
            String _name_18 = m.getCConstraint().getRclockconstraint().getClock().getName();
            _builder.append(_name_18);
            _builder.append(" >= ");
            String _constant_14 = m.getCConstraint().getRclockconstraint().getConstant();
            _builder.append(_constant_14);
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          boolean _isSmallerequals_2 = m.getCConstraint().getRclockconstraint().getOp().isSmallerequals();
          if (_isSmallerequals_2) {
            _builder.append("\"");
            String _name_19 = m.getCConstraint().getRclockconstraint().getClock().getName();
            _builder.append(_name_19);
            _builder.append(" <= ");
            String _constant_15 = m.getCConstraint().getRclockconstraint().getConstant();
            _builder.append(_constant_15);
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          boolean _isEquals_2 = m.getCConstraint().getRclockconstraint().getOp().isEquals();
          if (_isEquals_2) {
            _builder.append("\"");
            String _name_20 = m.getCConstraint().getRclockconstraint().getClock().getName();
            _builder.append(_name_20);
            _builder.append(" == ");
            String _constant_16 = m.getCConstraint().getRclockconstraint().getConstant();
            _builder.append(_constant_16);
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          boolean _isNotequals_2 = m.getCConstraint().getRclockconstraint().getOp().isNotequals();
          if (_isNotequals_2) {
            _builder.append("\"");
            String _name_21 = m.getCConstraint().getRclockconstraint().getClock().getName();
            _builder.append(_name_21);
            _builder.append(" != ");
            String _constant_17 = m.getCConstraint().getRclockconstraint().getConstant();
            _builder.append(_constant_17);
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    _builder.newLine();
    {
      ResetClock _resetclock = m.getResetclock();
      boolean _tripleNotEquals = (_resetclock != null);
      if (_tripleNotEquals) {
        _builder.append("+ \"; ");
        String _name_22 = m.getResetclock().getClock().getName();
        _builder.append(_name_22);
        _builder.append(" = 0\"");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    _builder.append(", actualState, newState));");
    _builder.newLine();
    _builder.append("b.addState(newState);");
    _builder.newLine();
    CharSequence _compile_constraint_msg = this.compile_constraint_msg(m);
    _builder.append(_compile_constraint_msg);
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("b.addTransition(new Transition(\"!\" + str1, newState, actualState));");
    _builder.newLine();
    _builder.newLine();
    _builder.append("finalState = new State(\"q\" + counter, StateType.FINAL);");
    _builder.newLine();
    _builder.append("b.addTransition(newTransition(str, newState, finalState));");
    _builder.newLine();
    _builder.append("b.addState(finalState);");
    _builder.newLine();
    _builder.append("b.setFinale(finalState);");
    _builder.newLine();
    return _builder;
  }
}
