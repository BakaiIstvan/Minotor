package hu.bme.mit.dipterv.text.generator;

import hu.bme.mit.dipterv.text.minotorDsl.ConstantParams;
import hu.bme.mit.dipterv.text.minotorDsl.Message;
import hu.bme.mit.dipterv.text.minotorDsl.Params;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.ExclusiveRange;

@SuppressWarnings("all")
public class FailMessage {
  public CharSequence compile_fail_past(final Message m) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("b = new Automaton(\"auto4\");");
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
    _builder.append("\t\t\t\t\t\t\t\t\t");
    _builder.newLine();
    _builder.append("b.addTransition(new Transition(\"!(\" + \"");
    String _name = m.getSender().getName();
    _builder.append(_name);
    _builder.append("\" + \".\" +");
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
    _builder.append("+ \".\" + \"");
    String _name_3 = m.getReceiver().getName();
    _builder.append(_name_3, "\t");
    _builder.append("\" + \") & \" + str, actualState, actualState));");
    _builder.newLineIfNotEmpty();
    _builder.append("finalState = new State(\"q\" + counter, StateType.FINAL);");
    _builder.newLine();
    _builder.append("counter++;");
    _builder.newLine();
    _builder.append("acceptState = new State(\"q\" + counter, StateType.ACCEPT);");
    _builder.newLine();
    _builder.append("counter++;");
    _builder.newLine();
    _builder.append("b.addTransition(new Transition(\"!\" + \"(\" + str + \")\", actualState, finalState));");
    _builder.newLine();
    _builder.append("b.addTransition(new Transition(\"");
    String _name_4 = m.getSender().getName();
    _builder.append(_name_4);
    _builder.append("\" + \".\" +");
    _builder.newLineIfNotEmpty();
    _builder.append("\"");
    String _name_5 = m.getName();
    _builder.append(_name_5);
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
            String _name_6 = p_2.getParams().get((param_2).intValue()).getName();
            _builder.append(_name_6);
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
    _builder.append("+ \".\" + \"");
    String _name_7 = m.getReceiver().getName();
    _builder.append(_name_7);
    _builder.append("\" , actualState, acceptState));");
    _builder.newLineIfNotEmpty();
    _builder.append("b.addState(acceptState);");
    _builder.newLine();
    _builder.append("b.addState(finalState);");
    _builder.newLine();
    _builder.append("b.setFinale(finalState);");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence compile_fail(final Message m) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("b = new Automaton(\"auto5\");");
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
    _builder.newLine();
    _builder.append("finalState = new State(\"q\" + counter, StateType.FINAL);");
    _builder.newLine();
    _builder.append("counter++;");
    _builder.newLine();
    _builder.append("b.addState(finalState);");
    _builder.newLine();
    _builder.append("b.setFinale(finalState);");
    _builder.newLine();
    _builder.newLine();
    _builder.append("b.addTransition(new Transition(\"!(\" + \"");
    String _name = m.getSender().getName();
    _builder.append(_name);
    _builder.append("\" + \".\" +");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("\"");
    String _name_1 = m.getName();
    _builder.append(_name_1, "\t\t\t");
    _builder.append("\" + \"(\"");
    _builder.newLineIfNotEmpty();
    {
      EList<Params> _params = m.getParams();
      for(final Params p : _params) {
        {
          int _size = p.getParams().size();
          ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size, true);
          for(final Integer param : _doubleDotLessThan) {
            _builder.append("\t\t\t");
            _builder.append("+ \"");
            String _name_2 = p.getParams().get((param).intValue()).getName();
            _builder.append(_name_2, "\t\t\t");
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
            {
              int _size_1 = p.getParams().size();
              int _minus = (_size_1 - 1);
              boolean _notEquals = ((param).intValue() != _minus);
              if (_notEquals) {
                _builder.append("\t\t\t");
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
            _builder.append("\t\t\t");
            _builder.append("+");
            _builder.newLine();
            {
              boolean _startsWith = p_1.getValues().get((param_1).intValue()).getValue().startsWith("\"");
              if (_startsWith) {
                _builder.append("\t\t\t");
                String _value = p_1.getValues().get((param_1).intValue()).getValue();
                _builder.append(_value, "\t\t\t");
                _builder.newLineIfNotEmpty();
              } else {
                _builder.append("\t\t\t");
                _builder.append("\"");
                String _value_1 = p_1.getValues().get((param_1).intValue()).getValue();
                _builder.append(_value_1, "\t\t\t");
                _builder.append("\"");
                _builder.newLineIfNotEmpty();
              }
            }
            {
              int _size_3 = p_1.getValues().size();
              int _minus_1 = (_size_3 - 1);
              boolean _notEquals_1 = ((param_1).intValue() != _minus_1);
              if (_notEquals_1) {
                _builder.append("\t\t\t");
                _builder.append("+ \", \"");
                _builder.newLine();
              }
            }
          }
        }
      }
    }
    _builder.append("\t\t\t");
    _builder.append("+ \")\"");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("+ \".\" + \"");
    String _name_3 = m.getReceiver().getName();
    _builder.append(_name_3, "\t\t\t");
    _builder.append(")\", actualState, finalState));");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("b.addTransition(new Transition(\"!(\" + \"");
    String _name_4 = m.getSender().getName();
    _builder.append(_name_4);
    _builder.append("\" + \".\" +");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("\"");
    String _name_5 = m.getName();
    _builder.append(_name_5, "\t");
    _builder.append("\" + \"(\"");
    _builder.newLineIfNotEmpty();
    {
      EList<Params> _params_1 = m.getParams();
      for(final Params p_2 : _params_1) {
        {
          int _size_4 = p_2.getParams().size();
          ExclusiveRange _doubleDotLessThan_2 = new ExclusiveRange(0, _size_4, true);
          for(final Integer param_2 : _doubleDotLessThan_2) {
            _builder.append("\t");
            _builder.append("+ \"");
            String _name_6 = p_2.getParams().get((param_2).intValue()).getName();
            _builder.append(_name_6, "\t");
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
            {
              int _size_5 = p_2.getParams().size();
              int _minus_2 = (_size_5 - 1);
              boolean _notEquals_2 = ((param_2).intValue() != _minus_2);
              if (_notEquals_2) {
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
      EList<ConstantParams> _constantparams_1 = m.getConstantparams();
      for(final ConstantParams p_3 : _constantparams_1) {
        {
          int _size_6 = p_3.getValues().size();
          ExclusiveRange _doubleDotLessThan_3 = new ExclusiveRange(0, _size_6, true);
          for(final Integer param_3 : _doubleDotLessThan_3) {
            _builder.append("\t");
            _builder.append("+");
            _builder.newLine();
            {
              boolean _startsWith_1 = p_3.getValues().get((param_3).intValue()).getValue().startsWith("\"");
              if (_startsWith_1) {
                _builder.append("\t");
                String _value_2 = p_3.getValues().get((param_3).intValue()).getValue();
                _builder.append(_value_2, "\t");
                _builder.newLineIfNotEmpty();
              } else {
                _builder.append("\t");
                _builder.append("\"");
                String _value_3 = p_3.getValues().get((param_3).intValue()).getValue();
                _builder.append(_value_3, "\t");
                _builder.append("\"");
                _builder.newLineIfNotEmpty();
              }
            }
            {
              int _size_7 = p_3.getValues().size();
              int _minus_3 = (_size_7 - 1);
              boolean _notEquals_3 = ((param_3).intValue() != _minus_3);
              if (_notEquals_3) {
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
    _builder.append("+ \".\" + \"");
    String _name_7 = m.getReceiver().getName();
    _builder.append(_name_7, "\t");
    _builder.append(")\", actualState, actualState));");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("newState = new State(\"q\" + counter, StateType.ACCEPT);");
    _builder.newLine();
    _builder.append("counter++;");
    _builder.newLine();
    _builder.append("b.addTransition(new Transition(\"");
    String _name_8 = m.getSender().getName();
    _builder.append(_name_8);
    _builder.append("\" + \".\" +");
    _builder.newLineIfNotEmpty();
    _builder.append("\"");
    String _name_9 = m.getName();
    _builder.append(_name_9);
    _builder.append("\" + \"(\"");
    _builder.newLineIfNotEmpty();
    {
      EList<Params> _params_2 = m.getParams();
      for(final Params p_4 : _params_2) {
        {
          int _size_8 = p_4.getParams().size();
          ExclusiveRange _doubleDotLessThan_4 = new ExclusiveRange(0, _size_8, true);
          for(final Integer param_4 : _doubleDotLessThan_4) {
            _builder.append("+ \"");
            String _name_10 = p_4.getParams().get((param_4).intValue()).getName();
            _builder.append(_name_10);
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
            {
              int _size_9 = p_4.getParams().size();
              int _minus_4 = (_size_9 - 1);
              boolean _notEquals_4 = ((param_4).intValue() != _minus_4);
              if (_notEquals_4) {
                _builder.append("+ \", \"");
                _builder.newLine();
              }
            }
          }
        }
      }
    }
    {
      EList<ConstantParams> _constantparams_2 = m.getConstantparams();
      for(final ConstantParams p_5 : _constantparams_2) {
        {
          int _size_10 = p_5.getValues().size();
          ExclusiveRange _doubleDotLessThan_5 = new ExclusiveRange(0, _size_10, true);
          for(final Integer param_5 : _doubleDotLessThan_5) {
            _builder.append("+");
            _builder.newLine();
            {
              boolean _startsWith_2 = p_5.getValues().get((param_5).intValue()).getValue().startsWith("\"");
              if (_startsWith_2) {
                String _value_4 = p_5.getValues().get((param_5).intValue()).getValue();
                _builder.append(_value_4);
                _builder.newLineIfNotEmpty();
              } else {
                _builder.append("\"");
                String _value_5 = p_5.getValues().get((param_5).intValue()).getValue();
                _builder.append(_value_5);
                _builder.append("\"");
                _builder.newLineIfNotEmpty();
              }
            }
            {
              int _size_11 = p_5.getValues().size();
              int _minus_5 = (_size_11 - 1);
              boolean _notEquals_5 = ((param_5).intValue() != _minus_5);
              if (_notEquals_5) {
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
    String _name_11 = m.getReceiver().getName();
    _builder.append(_name_11);
    _builder.append("\" , actualState, newState));");
    _builder.newLineIfNotEmpty();
    _builder.append("b.addState(newState);");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence compile_strict_fail(final Message m) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("b = new Automaton(\"auto10\");");
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
    _builder.append("finalState = new State(\"q\" + counter, StateType.FINAL);");
    _builder.newLine();
    _builder.append("counter++;");
    _builder.newLine();
    _builder.append("acceptState = new State(\"q\" + counter, StateType.ACCEPT);");
    _builder.newLine();
    _builder.append("counter++;");
    _builder.newLine();
    _builder.append("b.addTransition(new Transition(\"!(\" + \"");
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
    _builder.append("\" + \")\", actualState, finalState));");
    _builder.newLineIfNotEmpty();
    _builder.append("b.addTransition(new Transition(\"");
    String _name_4 = m.getSender().getName();
    _builder.append(_name_4);
    _builder.append("\" + \".\" +");
    _builder.newLineIfNotEmpty();
    _builder.append("\"");
    String _name_5 = m.getName();
    _builder.append(_name_5);
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
            String _name_6 = p_2.getParams().get((param_2).intValue()).getName();
            _builder.append(_name_6);
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
    _builder.append("+ \".\" + \"");
    String _name_7 = m.getReceiver().getName();
    _builder.append(_name_7);
    _builder.append("\", actualState, acceptState));");
    _builder.newLineIfNotEmpty();
    _builder.append("b.addState(finalState);");
    _builder.newLine();
    _builder.append("b.addState(acceptState);");
    _builder.newLine();
    _builder.append("b.setFinale(finalState);");
    _builder.newLine();
    return _builder;
  }
}
