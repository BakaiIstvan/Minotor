package hu.bme.mit.dipterv.text.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import hu.bme.mit.dipterv.text.services.MinotorDslGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalMinotorDslParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_REAL", "RULE_NUMBER", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'specification'", "'{'", "'}'", "'import'", "'from'", "'contextmodel'", "'contextfragment'", "'attribute'", "'int'", "'float'", "'string'", "'boolean'", "'='", "';'", "'true'", "'false'", "'attributeconstraint'", "'>'", "'<'", "'>='", "'<='", "'=='", "'!='", "'entity'", "'entityconstraint'", "'relation'", "'('", "','", "')'", "'relationconstraint'", "'scenario'", "'message'", "'required'", "'fail'", "'strict'", "'->'", "'pastConstraint'", "'futureConstraint'", "'clockConstraint'", "'reset'", "'not'", "'and'", "'match'", "'appear'", "'.'", "'disappear'", "'changeTo'", "'relationChangeTo'", "'assertEntityAttribute'", "'['", "']'", "'assertRelationAttribute'", "'assertParameter'", "'in'", "'clock'", "'object'", "'constraint'", "'alt'", "'or'", "'equals'", "'greater'", "'lesser'", "'par'", "'case'", "'loop'", "'integer'", "'bool'"
    };
    public static final int T__50=50;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__59=59;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__13=13;
    public static final int T__57=57;
    public static final int T__14=14;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int RULE_ID=4;
    public static final int RULE_REAL=6;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=8;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=9;
    public static final int T__23=23;
    public static final int T__67=67;
    public static final int T__24=24;
    public static final int T__68=68;
    public static final int T__25=25;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__20=20;
    public static final int T__64=64;
    public static final int T__21=21;
    public static final int T__65=65;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int RULE_STRING=5;
    public static final int RULE_SL_COMMENT=10;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__77=77;
    public static final int T__34=34;
    public static final int T__78=78;
    public static final int T__35=35;
    public static final int T__79=79;
    public static final int T__36=36;
    public static final int T__73=73;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__74=74;
    public static final int T__31=31;
    public static final int T__75=75;
    public static final int T__32=32;
    public static final int T__76=76;
    public static final int RULE_WS=11;
    public static final int RULE_ANY_OTHER=12;
    public static final int RULE_NUMBER=7;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;

    // delegates
    // delegators


        public InternalMinotorDslParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalMinotorDslParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalMinotorDslParser.tokenNames; }
    public String getGrammarFileName() { return "InternalMinotorDsl.g"; }



     	private MinotorDslGrammarAccess grammarAccess;

        public InternalMinotorDslParser(TokenStream input, MinotorDslGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Domain";
       	}

       	@Override
       	protected MinotorDslGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleDomain"
    // InternalMinotorDsl.g:65:1: entryRuleDomain returns [EObject current=null] : iv_ruleDomain= ruleDomain EOF ;
    public final EObject entryRuleDomain() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDomain = null;


        try {
            // InternalMinotorDsl.g:65:47: (iv_ruleDomain= ruleDomain EOF )
            // InternalMinotorDsl.g:66:2: iv_ruleDomain= ruleDomain EOF
            {
             newCompositeNode(grammarAccess.getDomainRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDomain=ruleDomain();

            state._fsp--;

             current =iv_ruleDomain; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDomain"


    // $ANTLR start "ruleDomain"
    // InternalMinotorDsl.g:72:1: ruleDomain returns [EObject current=null] : ( ( (lv_specification_0_0= 'specification' ) )? ( (lv_name_1_0= RULE_ID ) )? (otherlv_2= '{' )? ( (lv_includes_3_0= ruleInclude ) )* ( (lv_contextmodels_4_0= ruleContextModel ) )* ( (lv_contextfragments_5_0= ruleContextFragment ) )* ( (lv_objects_6_0= ruleObject ) )* ( (lv_parameters_7_0= ruleParameter ) )* ( (lv_clocks_8_0= ruleClock ) )* ( (lv_constraints_9_0= ruleConstraint ) )* ( (lv_scenarios_10_0= ruleScenario ) )* (otherlv_11= '}' )? ) ;
    public final EObject ruleDomain() throws RecognitionException {
        EObject current = null;

        Token lv_specification_0_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_11=null;
        EObject lv_includes_3_0 = null;

        EObject lv_contextmodels_4_0 = null;

        EObject lv_contextfragments_5_0 = null;

        EObject lv_objects_6_0 = null;

        EObject lv_parameters_7_0 = null;

        EObject lv_clocks_8_0 = null;

        EObject lv_constraints_9_0 = null;

        EObject lv_scenarios_10_0 = null;



        	enterRule();

        try {
            // InternalMinotorDsl.g:78:2: ( ( ( (lv_specification_0_0= 'specification' ) )? ( (lv_name_1_0= RULE_ID ) )? (otherlv_2= '{' )? ( (lv_includes_3_0= ruleInclude ) )* ( (lv_contextmodels_4_0= ruleContextModel ) )* ( (lv_contextfragments_5_0= ruleContextFragment ) )* ( (lv_objects_6_0= ruleObject ) )* ( (lv_parameters_7_0= ruleParameter ) )* ( (lv_clocks_8_0= ruleClock ) )* ( (lv_constraints_9_0= ruleConstraint ) )* ( (lv_scenarios_10_0= ruleScenario ) )* (otherlv_11= '}' )? ) )
            // InternalMinotorDsl.g:79:2: ( ( (lv_specification_0_0= 'specification' ) )? ( (lv_name_1_0= RULE_ID ) )? (otherlv_2= '{' )? ( (lv_includes_3_0= ruleInclude ) )* ( (lv_contextmodels_4_0= ruleContextModel ) )* ( (lv_contextfragments_5_0= ruleContextFragment ) )* ( (lv_objects_6_0= ruleObject ) )* ( (lv_parameters_7_0= ruleParameter ) )* ( (lv_clocks_8_0= ruleClock ) )* ( (lv_constraints_9_0= ruleConstraint ) )* ( (lv_scenarios_10_0= ruleScenario ) )* (otherlv_11= '}' )? )
            {
            // InternalMinotorDsl.g:79:2: ( ( (lv_specification_0_0= 'specification' ) )? ( (lv_name_1_0= RULE_ID ) )? (otherlv_2= '{' )? ( (lv_includes_3_0= ruleInclude ) )* ( (lv_contextmodels_4_0= ruleContextModel ) )* ( (lv_contextfragments_5_0= ruleContextFragment ) )* ( (lv_objects_6_0= ruleObject ) )* ( (lv_parameters_7_0= ruleParameter ) )* ( (lv_clocks_8_0= ruleClock ) )* ( (lv_constraints_9_0= ruleConstraint ) )* ( (lv_scenarios_10_0= ruleScenario ) )* (otherlv_11= '}' )? )
            // InternalMinotorDsl.g:80:3: ( (lv_specification_0_0= 'specification' ) )? ( (lv_name_1_0= RULE_ID ) )? (otherlv_2= '{' )? ( (lv_includes_3_0= ruleInclude ) )* ( (lv_contextmodels_4_0= ruleContextModel ) )* ( (lv_contextfragments_5_0= ruleContextFragment ) )* ( (lv_objects_6_0= ruleObject ) )* ( (lv_parameters_7_0= ruleParameter ) )* ( (lv_clocks_8_0= ruleClock ) )* ( (lv_constraints_9_0= ruleConstraint ) )* ( (lv_scenarios_10_0= ruleScenario ) )* (otherlv_11= '}' )?
            {
            // InternalMinotorDsl.g:80:3: ( (lv_specification_0_0= 'specification' ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==13) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // InternalMinotorDsl.g:81:4: (lv_specification_0_0= 'specification' )
                    {
                    // InternalMinotorDsl.g:81:4: (lv_specification_0_0= 'specification' )
                    // InternalMinotorDsl.g:82:5: lv_specification_0_0= 'specification'
                    {
                    lv_specification_0_0=(Token)match(input,13,FOLLOW_3); 

                    					newLeafNode(lv_specification_0_0, grammarAccess.getDomainAccess().getSpecificationSpecificationKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getDomainRule());
                    					}
                    					setWithLastConsumed(current, "specification", lv_specification_0_0, "specification");
                    				

                    }


                    }
                    break;

            }

            // InternalMinotorDsl.g:94:3: ( (lv_name_1_0= RULE_ID ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_ID) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalMinotorDsl.g:95:4: (lv_name_1_0= RULE_ID )
                    {
                    // InternalMinotorDsl.g:95:4: (lv_name_1_0= RULE_ID )
                    // InternalMinotorDsl.g:96:5: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_4); 

                    					newLeafNode(lv_name_1_0, grammarAccess.getDomainAccess().getNameIDTerminalRuleCall_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getDomainRule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"name",
                    						lv_name_1_0,
                    						"org.eclipse.xtext.common.Terminals.ID");
                    				

                    }


                    }
                    break;

            }

            // InternalMinotorDsl.g:112:3: (otherlv_2= '{' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==14) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalMinotorDsl.g:113:4: otherlv_2= '{'
                    {
                    otherlv_2=(Token)match(input,14,FOLLOW_5); 

                    				newLeafNode(otherlv_2, grammarAccess.getDomainAccess().getLeftCurlyBracketKeyword_2());
                    			

                    }
                    break;

            }

            // InternalMinotorDsl.g:118:3: ( (lv_includes_3_0= ruleInclude ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==16) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalMinotorDsl.g:119:4: (lv_includes_3_0= ruleInclude )
            	    {
            	    // InternalMinotorDsl.g:119:4: (lv_includes_3_0= ruleInclude )
            	    // InternalMinotorDsl.g:120:5: lv_includes_3_0= ruleInclude
            	    {

            	    					newCompositeNode(grammarAccess.getDomainAccess().getIncludesIncludeParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_5);
            	    lv_includes_3_0=ruleInclude();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getDomainRule());
            	    					}
            	    					add(
            	    						current,
            	    						"includes",
            	    						lv_includes_3_0,
            	    						"hu.bme.mit.dipterv.text.MinotorDsl.Include");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            // InternalMinotorDsl.g:137:3: ( (lv_contextmodels_4_0= ruleContextModel ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==18) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalMinotorDsl.g:138:4: (lv_contextmodels_4_0= ruleContextModel )
            	    {
            	    // InternalMinotorDsl.g:138:4: (lv_contextmodels_4_0= ruleContextModel )
            	    // InternalMinotorDsl.g:139:5: lv_contextmodels_4_0= ruleContextModel
            	    {

            	    					newCompositeNode(grammarAccess.getDomainAccess().getContextmodelsContextModelParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_6);
            	    lv_contextmodels_4_0=ruleContextModel();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getDomainRule());
            	    					}
            	    					add(
            	    						current,
            	    						"contextmodels",
            	    						lv_contextmodels_4_0,
            	    						"hu.bme.mit.dipterv.text.MinotorDsl.ContextModel");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            // InternalMinotorDsl.g:156:3: ( (lv_contextfragments_5_0= ruleContextFragment ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==19) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalMinotorDsl.g:157:4: (lv_contextfragments_5_0= ruleContextFragment )
            	    {
            	    // InternalMinotorDsl.g:157:4: (lv_contextfragments_5_0= ruleContextFragment )
            	    // InternalMinotorDsl.g:158:5: lv_contextfragments_5_0= ruleContextFragment
            	    {

            	    					newCompositeNode(grammarAccess.getDomainAccess().getContextfragmentsContextFragmentParserRuleCall_5_0());
            	    				
            	    pushFollow(FOLLOW_7);
            	    lv_contextfragments_5_0=ruleContextFragment();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getDomainRule());
            	    					}
            	    					add(
            	    						current,
            	    						"contextfragments",
            	    						lv_contextfragments_5_0,
            	    						"hu.bme.mit.dipterv.text.MinotorDsl.ContextFragment");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            // InternalMinotorDsl.g:175:3: ( (lv_objects_6_0= ruleObject ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==68) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalMinotorDsl.g:176:4: (lv_objects_6_0= ruleObject )
            	    {
            	    // InternalMinotorDsl.g:176:4: (lv_objects_6_0= ruleObject )
            	    // InternalMinotorDsl.g:177:5: lv_objects_6_0= ruleObject
            	    {

            	    					newCompositeNode(grammarAccess.getDomainAccess().getObjectsObjectParserRuleCall_6_0());
            	    				
            	    pushFollow(FOLLOW_8);
            	    lv_objects_6_0=ruleObject();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getDomainRule());
            	    					}
            	    					add(
            	    						current,
            	    						"objects",
            	    						lv_objects_6_0,
            	    						"hu.bme.mit.dipterv.text.MinotorDsl.Object");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            // InternalMinotorDsl.g:194:3: ( (lv_parameters_7_0= ruleParameter ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>=22 && LA8_0<=23)||(LA8_0>=78 && LA8_0<=79)) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalMinotorDsl.g:195:4: (lv_parameters_7_0= ruleParameter )
            	    {
            	    // InternalMinotorDsl.g:195:4: (lv_parameters_7_0= ruleParameter )
            	    // InternalMinotorDsl.g:196:5: lv_parameters_7_0= ruleParameter
            	    {

            	    					newCompositeNode(grammarAccess.getDomainAccess().getParametersParameterParserRuleCall_7_0());
            	    				
            	    pushFollow(FOLLOW_9);
            	    lv_parameters_7_0=ruleParameter();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getDomainRule());
            	    					}
            	    					add(
            	    						current,
            	    						"parameters",
            	    						lv_parameters_7_0,
            	    						"hu.bme.mit.dipterv.text.MinotorDsl.Parameter");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            // InternalMinotorDsl.g:213:3: ( (lv_clocks_8_0= ruleClock ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==67) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalMinotorDsl.g:214:4: (lv_clocks_8_0= ruleClock )
            	    {
            	    // InternalMinotorDsl.g:214:4: (lv_clocks_8_0= ruleClock )
            	    // InternalMinotorDsl.g:215:5: lv_clocks_8_0= ruleClock
            	    {

            	    					newCompositeNode(grammarAccess.getDomainAccess().getClocksClockParserRuleCall_8_0());
            	    				
            	    pushFollow(FOLLOW_10);
            	    lv_clocks_8_0=ruleClock();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getDomainRule());
            	    					}
            	    					add(
            	    						current,
            	    						"clocks",
            	    						lv_clocks_8_0,
            	    						"hu.bme.mit.dipterv.text.MinotorDsl.Clock");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            // InternalMinotorDsl.g:232:3: ( (lv_constraints_9_0= ruleConstraint ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==69) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalMinotorDsl.g:233:4: (lv_constraints_9_0= ruleConstraint )
            	    {
            	    // InternalMinotorDsl.g:233:4: (lv_constraints_9_0= ruleConstraint )
            	    // InternalMinotorDsl.g:234:5: lv_constraints_9_0= ruleConstraint
            	    {

            	    					newCompositeNode(grammarAccess.getDomainAccess().getConstraintsConstraintParserRuleCall_9_0());
            	    				
            	    pushFollow(FOLLOW_11);
            	    lv_constraints_9_0=ruleConstraint();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getDomainRule());
            	    					}
            	    					add(
            	    						current,
            	    						"constraints",
            	    						lv_constraints_9_0,
            	    						"hu.bme.mit.dipterv.text.MinotorDsl.Constraint");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            // InternalMinotorDsl.g:251:3: ( (lv_scenarios_10_0= ruleScenario ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==43) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalMinotorDsl.g:252:4: (lv_scenarios_10_0= ruleScenario )
            	    {
            	    // InternalMinotorDsl.g:252:4: (lv_scenarios_10_0= ruleScenario )
            	    // InternalMinotorDsl.g:253:5: lv_scenarios_10_0= ruleScenario
            	    {

            	    					newCompositeNode(grammarAccess.getDomainAccess().getScenariosScenarioParserRuleCall_10_0());
            	    				
            	    pushFollow(FOLLOW_12);
            	    lv_scenarios_10_0=ruleScenario();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getDomainRule());
            	    					}
            	    					add(
            	    						current,
            	    						"scenarios",
            	    						lv_scenarios_10_0,
            	    						"hu.bme.mit.dipterv.text.MinotorDsl.Scenario");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            // InternalMinotorDsl.g:270:3: (otherlv_11= '}' )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==15) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalMinotorDsl.g:271:4: otherlv_11= '}'
                    {
                    otherlv_11=(Token)match(input,15,FOLLOW_2); 

                    				newLeafNode(otherlv_11, grammarAccess.getDomainAccess().getRightCurlyBracketKeyword_11());
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDomain"


    // $ANTLR start "entryRuleInclude"
    // InternalMinotorDsl.g:280:1: entryRuleInclude returns [EObject current=null] : iv_ruleInclude= ruleInclude EOF ;
    public final EObject entryRuleInclude() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInclude = null;


        try {
            // InternalMinotorDsl.g:280:48: (iv_ruleInclude= ruleInclude EOF )
            // InternalMinotorDsl.g:281:2: iv_ruleInclude= ruleInclude EOF
            {
             newCompositeNode(grammarAccess.getIncludeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleInclude=ruleInclude();

            state._fsp--;

             current =iv_ruleInclude; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInclude"


    // $ANTLR start "ruleInclude"
    // InternalMinotorDsl.g:287:1: ruleInclude returns [EObject current=null] : (otherlv_0= 'import' ( (otherlv_1= RULE_ID ) ) otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) ) ;
    public final EObject ruleInclude() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_importURI_3_0=null;


        	enterRule();

        try {
            // InternalMinotorDsl.g:293:2: ( (otherlv_0= 'import' ( (otherlv_1= RULE_ID ) ) otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) ) )
            // InternalMinotorDsl.g:294:2: (otherlv_0= 'import' ( (otherlv_1= RULE_ID ) ) otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) )
            {
            // InternalMinotorDsl.g:294:2: (otherlv_0= 'import' ( (otherlv_1= RULE_ID ) ) otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) )
            // InternalMinotorDsl.g:295:3: otherlv_0= 'import' ( (otherlv_1= RULE_ID ) ) otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,16,FOLLOW_13); 

            			newLeafNode(otherlv_0, grammarAccess.getIncludeAccess().getImportKeyword_0());
            		
            // InternalMinotorDsl.g:299:3: ( (otherlv_1= RULE_ID ) )
            // InternalMinotorDsl.g:300:4: (otherlv_1= RULE_ID )
            {
            // InternalMinotorDsl.g:300:4: (otherlv_1= RULE_ID )
            // InternalMinotorDsl.g:301:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getIncludeRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_14); 

            					newLeafNode(otherlv_1, grammarAccess.getIncludeAccess().getContextContextModelCrossReference_1_0());
            				

            }


            }

            otherlv_2=(Token)match(input,17,FOLLOW_15); 

            			newLeafNode(otherlv_2, grammarAccess.getIncludeAccess().getFromKeyword_2());
            		
            // InternalMinotorDsl.g:316:3: ( (lv_importURI_3_0= RULE_STRING ) )
            // InternalMinotorDsl.g:317:4: (lv_importURI_3_0= RULE_STRING )
            {
            // InternalMinotorDsl.g:317:4: (lv_importURI_3_0= RULE_STRING )
            // InternalMinotorDsl.g:318:5: lv_importURI_3_0= RULE_STRING
            {
            lv_importURI_3_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            					newLeafNode(lv_importURI_3_0, grammarAccess.getIncludeAccess().getImportURISTRINGTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getIncludeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"importURI",
            						lv_importURI_3_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInclude"


    // $ANTLR start "entryRuleContextModel"
    // InternalMinotorDsl.g:338:1: entryRuleContextModel returns [EObject current=null] : iv_ruleContextModel= ruleContextModel EOF ;
    public final EObject entryRuleContextModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContextModel = null;


        try {
            // InternalMinotorDsl.g:338:53: (iv_ruleContextModel= ruleContextModel EOF )
            // InternalMinotorDsl.g:339:2: iv_ruleContextModel= ruleContextModel EOF
            {
             newCompositeNode(grammarAccess.getContextModelRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleContextModel=ruleContextModel();

            state._fsp--;

             current =iv_ruleContextModel; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleContextModel"


    // $ANTLR start "ruleContextModel"
    // InternalMinotorDsl.g:345:1: ruleContextModel returns [EObject current=null] : (otherlv_0= 'contextmodel' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_entities_3_0= ruleEntity ) )* ( (lv_relations_4_0= ruleRelation ) )* otherlv_5= '}' ) ;
    public final EObject ruleContextModel() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        EObject lv_entities_3_0 = null;

        EObject lv_relations_4_0 = null;



        	enterRule();

        try {
            // InternalMinotorDsl.g:351:2: ( (otherlv_0= 'contextmodel' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_entities_3_0= ruleEntity ) )* ( (lv_relations_4_0= ruleRelation ) )* otherlv_5= '}' ) )
            // InternalMinotorDsl.g:352:2: (otherlv_0= 'contextmodel' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_entities_3_0= ruleEntity ) )* ( (lv_relations_4_0= ruleRelation ) )* otherlv_5= '}' )
            {
            // InternalMinotorDsl.g:352:2: (otherlv_0= 'contextmodel' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_entities_3_0= ruleEntity ) )* ( (lv_relations_4_0= ruleRelation ) )* otherlv_5= '}' )
            // InternalMinotorDsl.g:353:3: otherlv_0= 'contextmodel' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_entities_3_0= ruleEntity ) )* ( (lv_relations_4_0= ruleRelation ) )* otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,18,FOLLOW_13); 

            			newLeafNode(otherlv_0, grammarAccess.getContextModelAccess().getContextmodelKeyword_0());
            		
            // InternalMinotorDsl.g:357:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMinotorDsl.g:358:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMinotorDsl.g:358:4: (lv_name_1_0= RULE_ID )
            // InternalMinotorDsl.g:359:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_16); 

            					newLeafNode(lv_name_1_0, grammarAccess.getContextModelAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getContextModelRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,14,FOLLOW_17); 

            			newLeafNode(otherlv_2, grammarAccess.getContextModelAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalMinotorDsl.g:379:3: ( (lv_entities_3_0= ruleEntity ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==36) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalMinotorDsl.g:380:4: (lv_entities_3_0= ruleEntity )
            	    {
            	    // InternalMinotorDsl.g:380:4: (lv_entities_3_0= ruleEntity )
            	    // InternalMinotorDsl.g:381:5: lv_entities_3_0= ruleEntity
            	    {

            	    					newCompositeNode(grammarAccess.getContextModelAccess().getEntitiesEntityParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_17);
            	    lv_entities_3_0=ruleEntity();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getContextModelRule());
            	    					}
            	    					add(
            	    						current,
            	    						"entities",
            	    						lv_entities_3_0,
            	    						"hu.bme.mit.dipterv.text.MinotorDsl.Entity");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            // InternalMinotorDsl.g:398:3: ( (lv_relations_4_0= ruleRelation ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==38) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalMinotorDsl.g:399:4: (lv_relations_4_0= ruleRelation )
            	    {
            	    // InternalMinotorDsl.g:399:4: (lv_relations_4_0= ruleRelation )
            	    // InternalMinotorDsl.g:400:5: lv_relations_4_0= ruleRelation
            	    {

            	    					newCompositeNode(grammarAccess.getContextModelAccess().getRelationsRelationParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_18);
            	    lv_relations_4_0=ruleRelation();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getContextModelRule());
            	    					}
            	    					add(
            	    						current,
            	    						"relations",
            	    						lv_relations_4_0,
            	    						"hu.bme.mit.dipterv.text.MinotorDsl.Relation");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

            otherlv_5=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getContextModelAccess().getRightCurlyBracketKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleContextModel"


    // $ANTLR start "entryRuleContextFragment"
    // InternalMinotorDsl.g:425:1: entryRuleContextFragment returns [EObject current=null] : iv_ruleContextFragment= ruleContextFragment EOF ;
    public final EObject entryRuleContextFragment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContextFragment = null;


        try {
            // InternalMinotorDsl.g:425:56: (iv_ruleContextFragment= ruleContextFragment EOF )
            // InternalMinotorDsl.g:426:2: iv_ruleContextFragment= ruleContextFragment EOF
            {
             newCompositeNode(grammarAccess.getContextFragmentRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleContextFragment=ruleContextFragment();

            state._fsp--;

             current =iv_ruleContextFragment; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleContextFragment"


    // $ANTLR start "ruleContextFragment"
    // InternalMinotorDsl.g:432:1: ruleContextFragment returns [EObject current=null] : (otherlv_0= 'contextfragment' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_entities_3_0= ruleFEntity ) )* ( (lv_relations_4_0= ruleFRelation ) )* otherlv_5= '}' ) ;
    public final EObject ruleContextFragment() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        EObject lv_entities_3_0 = null;

        EObject lv_relations_4_0 = null;



        	enterRule();

        try {
            // InternalMinotorDsl.g:438:2: ( (otherlv_0= 'contextfragment' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_entities_3_0= ruleFEntity ) )* ( (lv_relations_4_0= ruleFRelation ) )* otherlv_5= '}' ) )
            // InternalMinotorDsl.g:439:2: (otherlv_0= 'contextfragment' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_entities_3_0= ruleFEntity ) )* ( (lv_relations_4_0= ruleFRelation ) )* otherlv_5= '}' )
            {
            // InternalMinotorDsl.g:439:2: (otherlv_0= 'contextfragment' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_entities_3_0= ruleFEntity ) )* ( (lv_relations_4_0= ruleFRelation ) )* otherlv_5= '}' )
            // InternalMinotorDsl.g:440:3: otherlv_0= 'contextfragment' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_entities_3_0= ruleFEntity ) )* ( (lv_relations_4_0= ruleFRelation ) )* otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,19,FOLLOW_13); 

            			newLeafNode(otherlv_0, grammarAccess.getContextFragmentAccess().getContextfragmentKeyword_0());
            		
            // InternalMinotorDsl.g:444:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMinotorDsl.g:445:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMinotorDsl.g:445:4: (lv_name_1_0= RULE_ID )
            // InternalMinotorDsl.g:446:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_16); 

            					newLeafNode(lv_name_1_0, grammarAccess.getContextFragmentAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getContextFragmentRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,14,FOLLOW_19); 

            			newLeafNode(otherlv_2, grammarAccess.getContextFragmentAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalMinotorDsl.g:466:3: ( (lv_entities_3_0= ruleFEntity ) )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==37) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalMinotorDsl.g:467:4: (lv_entities_3_0= ruleFEntity )
            	    {
            	    // InternalMinotorDsl.g:467:4: (lv_entities_3_0= ruleFEntity )
            	    // InternalMinotorDsl.g:468:5: lv_entities_3_0= ruleFEntity
            	    {

            	    					newCompositeNode(grammarAccess.getContextFragmentAccess().getEntitiesFEntityParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_19);
            	    lv_entities_3_0=ruleFEntity();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getContextFragmentRule());
            	    					}
            	    					add(
            	    						current,
            	    						"entities",
            	    						lv_entities_3_0,
            	    						"hu.bme.mit.dipterv.text.MinotorDsl.FEntity");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

            // InternalMinotorDsl.g:485:3: ( (lv_relations_4_0= ruleFRelation ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==42) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalMinotorDsl.g:486:4: (lv_relations_4_0= ruleFRelation )
            	    {
            	    // InternalMinotorDsl.g:486:4: (lv_relations_4_0= ruleFRelation )
            	    // InternalMinotorDsl.g:487:5: lv_relations_4_0= ruleFRelation
            	    {

            	    					newCompositeNode(grammarAccess.getContextFragmentAccess().getRelationsFRelationParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_20);
            	    lv_relations_4_0=ruleFRelation();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getContextFragmentRule());
            	    					}
            	    					add(
            	    						current,
            	    						"relations",
            	    						lv_relations_4_0,
            	    						"hu.bme.mit.dipterv.text.MinotorDsl.FRelation");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

            otherlv_5=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getContextFragmentAccess().getRightCurlyBracketKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleContextFragment"


    // $ANTLR start "entryRuleAttribute"
    // InternalMinotorDsl.g:512:1: entryRuleAttribute returns [EObject current=null] : iv_ruleAttribute= ruleAttribute EOF ;
    public final EObject entryRuleAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttribute = null;


        try {
            // InternalMinotorDsl.g:512:50: (iv_ruleAttribute= ruleAttribute EOF )
            // InternalMinotorDsl.g:513:2: iv_ruleAttribute= ruleAttribute EOF
            {
             newCompositeNode(grammarAccess.getAttributeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAttribute=ruleAttribute();

            state._fsp--;

             current =iv_ruleAttribute; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAttribute"


    // $ANTLR start "ruleAttribute"
    // InternalMinotorDsl.g:519:1: ruleAttribute returns [EObject current=null] : (otherlv_0= 'attribute' ( (lv_int_1_0= 'int' ) )? ( (lv_float_2_0= 'float' ) )? ( (lv_string_3_0= 'string' ) )? ( (lv_boolean_4_0= 'boolean' ) )? ( (lv_name_5_0= RULE_ID ) ) (otherlv_6= '=' )? ( (lv_value_7_0= ruleAttributeValue ) )? otherlv_8= ';' ) ;
    public final EObject ruleAttribute() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_int_1_0=null;
        Token lv_float_2_0=null;
        Token lv_string_3_0=null;
        Token lv_boolean_4_0=null;
        Token lv_name_5_0=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        EObject lv_value_7_0 = null;



        	enterRule();

        try {
            // InternalMinotorDsl.g:525:2: ( (otherlv_0= 'attribute' ( (lv_int_1_0= 'int' ) )? ( (lv_float_2_0= 'float' ) )? ( (lv_string_3_0= 'string' ) )? ( (lv_boolean_4_0= 'boolean' ) )? ( (lv_name_5_0= RULE_ID ) ) (otherlv_6= '=' )? ( (lv_value_7_0= ruleAttributeValue ) )? otherlv_8= ';' ) )
            // InternalMinotorDsl.g:526:2: (otherlv_0= 'attribute' ( (lv_int_1_0= 'int' ) )? ( (lv_float_2_0= 'float' ) )? ( (lv_string_3_0= 'string' ) )? ( (lv_boolean_4_0= 'boolean' ) )? ( (lv_name_5_0= RULE_ID ) ) (otherlv_6= '=' )? ( (lv_value_7_0= ruleAttributeValue ) )? otherlv_8= ';' )
            {
            // InternalMinotorDsl.g:526:2: (otherlv_0= 'attribute' ( (lv_int_1_0= 'int' ) )? ( (lv_float_2_0= 'float' ) )? ( (lv_string_3_0= 'string' ) )? ( (lv_boolean_4_0= 'boolean' ) )? ( (lv_name_5_0= RULE_ID ) ) (otherlv_6= '=' )? ( (lv_value_7_0= ruleAttributeValue ) )? otherlv_8= ';' )
            // InternalMinotorDsl.g:527:3: otherlv_0= 'attribute' ( (lv_int_1_0= 'int' ) )? ( (lv_float_2_0= 'float' ) )? ( (lv_string_3_0= 'string' ) )? ( (lv_boolean_4_0= 'boolean' ) )? ( (lv_name_5_0= RULE_ID ) ) (otherlv_6= '=' )? ( (lv_value_7_0= ruleAttributeValue ) )? otherlv_8= ';'
            {
            otherlv_0=(Token)match(input,20,FOLLOW_21); 

            			newLeafNode(otherlv_0, grammarAccess.getAttributeAccess().getAttributeKeyword_0());
            		
            // InternalMinotorDsl.g:531:3: ( (lv_int_1_0= 'int' ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==21) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalMinotorDsl.g:532:4: (lv_int_1_0= 'int' )
                    {
                    // InternalMinotorDsl.g:532:4: (lv_int_1_0= 'int' )
                    // InternalMinotorDsl.g:533:5: lv_int_1_0= 'int'
                    {
                    lv_int_1_0=(Token)match(input,21,FOLLOW_22); 

                    					newLeafNode(lv_int_1_0, grammarAccess.getAttributeAccess().getIntIntKeyword_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getAttributeRule());
                    					}
                    					setWithLastConsumed(current, "int", lv_int_1_0 != null, "int");
                    				

                    }


                    }
                    break;

            }

            // InternalMinotorDsl.g:545:3: ( (lv_float_2_0= 'float' ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==22) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalMinotorDsl.g:546:4: (lv_float_2_0= 'float' )
                    {
                    // InternalMinotorDsl.g:546:4: (lv_float_2_0= 'float' )
                    // InternalMinotorDsl.g:547:5: lv_float_2_0= 'float'
                    {
                    lv_float_2_0=(Token)match(input,22,FOLLOW_23); 

                    					newLeafNode(lv_float_2_0, grammarAccess.getAttributeAccess().getFloatFloatKeyword_2_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getAttributeRule());
                    					}
                    					setWithLastConsumed(current, "float", lv_float_2_0 != null, "float");
                    				

                    }


                    }
                    break;

            }

            // InternalMinotorDsl.g:559:3: ( (lv_string_3_0= 'string' ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==23) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalMinotorDsl.g:560:4: (lv_string_3_0= 'string' )
                    {
                    // InternalMinotorDsl.g:560:4: (lv_string_3_0= 'string' )
                    // InternalMinotorDsl.g:561:5: lv_string_3_0= 'string'
                    {
                    lv_string_3_0=(Token)match(input,23,FOLLOW_24); 

                    					newLeafNode(lv_string_3_0, grammarAccess.getAttributeAccess().getStringStringKeyword_3_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getAttributeRule());
                    					}
                    					setWithLastConsumed(current, "string", lv_string_3_0 != null, "string");
                    				

                    }


                    }
                    break;

            }

            // InternalMinotorDsl.g:573:3: ( (lv_boolean_4_0= 'boolean' ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==24) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalMinotorDsl.g:574:4: (lv_boolean_4_0= 'boolean' )
                    {
                    // InternalMinotorDsl.g:574:4: (lv_boolean_4_0= 'boolean' )
                    // InternalMinotorDsl.g:575:5: lv_boolean_4_0= 'boolean'
                    {
                    lv_boolean_4_0=(Token)match(input,24,FOLLOW_13); 

                    					newLeafNode(lv_boolean_4_0, grammarAccess.getAttributeAccess().getBooleanBooleanKeyword_4_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getAttributeRule());
                    					}
                    					setWithLastConsumed(current, "boolean", lv_boolean_4_0 != null, "boolean");
                    				

                    }


                    }
                    break;

            }

            // InternalMinotorDsl.g:587:3: ( (lv_name_5_0= RULE_ID ) )
            // InternalMinotorDsl.g:588:4: (lv_name_5_0= RULE_ID )
            {
            // InternalMinotorDsl.g:588:4: (lv_name_5_0= RULE_ID )
            // InternalMinotorDsl.g:589:5: lv_name_5_0= RULE_ID
            {
            lv_name_5_0=(Token)match(input,RULE_ID,FOLLOW_25); 

            					newLeafNode(lv_name_5_0, grammarAccess.getAttributeAccess().getNameIDTerminalRuleCall_5_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAttributeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_5_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalMinotorDsl.g:605:3: (otherlv_6= '=' )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==25) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalMinotorDsl.g:606:4: otherlv_6= '='
                    {
                    otherlv_6=(Token)match(input,25,FOLLOW_26); 

                    				newLeafNode(otherlv_6, grammarAccess.getAttributeAccess().getEqualsSignKeyword_6());
                    			

                    }
                    break;

            }

            // InternalMinotorDsl.g:611:3: ( (lv_value_7_0= ruleAttributeValue ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( ((LA22_0>=RULE_STRING && LA22_0<=RULE_NUMBER)||(LA22_0>=27 && LA22_0<=28)) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalMinotorDsl.g:612:4: (lv_value_7_0= ruleAttributeValue )
                    {
                    // InternalMinotorDsl.g:612:4: (lv_value_7_0= ruleAttributeValue )
                    // InternalMinotorDsl.g:613:5: lv_value_7_0= ruleAttributeValue
                    {

                    					newCompositeNode(grammarAccess.getAttributeAccess().getValueAttributeValueParserRuleCall_7_0());
                    				
                    pushFollow(FOLLOW_27);
                    lv_value_7_0=ruleAttributeValue();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getAttributeRule());
                    					}
                    					set(
                    						current,
                    						"value",
                    						lv_value_7_0,
                    						"hu.bme.mit.dipterv.text.MinotorDsl.AttributeValue");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            otherlv_8=(Token)match(input,26,FOLLOW_2); 

            			newLeafNode(otherlv_8, grammarAccess.getAttributeAccess().getSemicolonKeyword_8());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAttribute"


    // $ANTLR start "entryRuleAttributeValue"
    // InternalMinotorDsl.g:638:1: entryRuleAttributeValue returns [EObject current=null] : iv_ruleAttributeValue= ruleAttributeValue EOF ;
    public final EObject entryRuleAttributeValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeValue = null;


        try {
            // InternalMinotorDsl.g:638:55: (iv_ruleAttributeValue= ruleAttributeValue EOF )
            // InternalMinotorDsl.g:639:2: iv_ruleAttributeValue= ruleAttributeValue EOF
            {
             newCompositeNode(grammarAccess.getAttributeValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAttributeValue=ruleAttributeValue();

            state._fsp--;

             current =iv_ruleAttributeValue; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAttributeValue"


    // $ANTLR start "ruleAttributeValue"
    // InternalMinotorDsl.g:645:1: ruleAttributeValue returns [EObject current=null] : ( ( (lv_value_0_0= RULE_STRING ) ) | ( (lv_value_1_0= RULE_REAL ) ) | ( (lv_value_2_0= RULE_NUMBER ) ) | ( (lv_value_3_0= 'true' ) ) | ( (lv_value_4_0= 'false' ) ) ) ;
    public final EObject ruleAttributeValue() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;
        Token lv_value_1_0=null;
        Token lv_value_2_0=null;
        Token lv_value_3_0=null;
        Token lv_value_4_0=null;


        	enterRule();

        try {
            // InternalMinotorDsl.g:651:2: ( ( ( (lv_value_0_0= RULE_STRING ) ) | ( (lv_value_1_0= RULE_REAL ) ) | ( (lv_value_2_0= RULE_NUMBER ) ) | ( (lv_value_3_0= 'true' ) ) | ( (lv_value_4_0= 'false' ) ) ) )
            // InternalMinotorDsl.g:652:2: ( ( (lv_value_0_0= RULE_STRING ) ) | ( (lv_value_1_0= RULE_REAL ) ) | ( (lv_value_2_0= RULE_NUMBER ) ) | ( (lv_value_3_0= 'true' ) ) | ( (lv_value_4_0= 'false' ) ) )
            {
            // InternalMinotorDsl.g:652:2: ( ( (lv_value_0_0= RULE_STRING ) ) | ( (lv_value_1_0= RULE_REAL ) ) | ( (lv_value_2_0= RULE_NUMBER ) ) | ( (lv_value_3_0= 'true' ) ) | ( (lv_value_4_0= 'false' ) ) )
            int alt23=5;
            switch ( input.LA(1) ) {
            case RULE_STRING:
                {
                alt23=1;
                }
                break;
            case RULE_REAL:
                {
                alt23=2;
                }
                break;
            case RULE_NUMBER:
                {
                alt23=3;
                }
                break;
            case 27:
                {
                alt23=4;
                }
                break;
            case 28:
                {
                alt23=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }

            switch (alt23) {
                case 1 :
                    // InternalMinotorDsl.g:653:3: ( (lv_value_0_0= RULE_STRING ) )
                    {
                    // InternalMinotorDsl.g:653:3: ( (lv_value_0_0= RULE_STRING ) )
                    // InternalMinotorDsl.g:654:4: (lv_value_0_0= RULE_STRING )
                    {
                    // InternalMinotorDsl.g:654:4: (lv_value_0_0= RULE_STRING )
                    // InternalMinotorDsl.g:655:5: lv_value_0_0= RULE_STRING
                    {
                    lv_value_0_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    					newLeafNode(lv_value_0_0, grammarAccess.getAttributeValueAccess().getValueSTRINGTerminalRuleCall_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getAttributeValueRule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"value",
                    						lv_value_0_0,
                    						"org.eclipse.xtext.common.Terminals.STRING");
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalMinotorDsl.g:672:3: ( (lv_value_1_0= RULE_REAL ) )
                    {
                    // InternalMinotorDsl.g:672:3: ( (lv_value_1_0= RULE_REAL ) )
                    // InternalMinotorDsl.g:673:4: (lv_value_1_0= RULE_REAL )
                    {
                    // InternalMinotorDsl.g:673:4: (lv_value_1_0= RULE_REAL )
                    // InternalMinotorDsl.g:674:5: lv_value_1_0= RULE_REAL
                    {
                    lv_value_1_0=(Token)match(input,RULE_REAL,FOLLOW_2); 

                    					newLeafNode(lv_value_1_0, grammarAccess.getAttributeValueAccess().getValueREALTerminalRuleCall_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getAttributeValueRule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"value",
                    						lv_value_1_0,
                    						"hu.bme.mit.dipterv.text.MinotorDsl.REAL");
                    				

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalMinotorDsl.g:691:3: ( (lv_value_2_0= RULE_NUMBER ) )
                    {
                    // InternalMinotorDsl.g:691:3: ( (lv_value_2_0= RULE_NUMBER ) )
                    // InternalMinotorDsl.g:692:4: (lv_value_2_0= RULE_NUMBER )
                    {
                    // InternalMinotorDsl.g:692:4: (lv_value_2_0= RULE_NUMBER )
                    // InternalMinotorDsl.g:693:5: lv_value_2_0= RULE_NUMBER
                    {
                    lv_value_2_0=(Token)match(input,RULE_NUMBER,FOLLOW_2); 

                    					newLeafNode(lv_value_2_0, grammarAccess.getAttributeValueAccess().getValueNUMBERTerminalRuleCall_2_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getAttributeValueRule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"value",
                    						lv_value_2_0,
                    						"hu.bme.mit.dipterv.text.MinotorDsl.NUMBER");
                    				

                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalMinotorDsl.g:710:3: ( (lv_value_3_0= 'true' ) )
                    {
                    // InternalMinotorDsl.g:710:3: ( (lv_value_3_0= 'true' ) )
                    // InternalMinotorDsl.g:711:4: (lv_value_3_0= 'true' )
                    {
                    // InternalMinotorDsl.g:711:4: (lv_value_3_0= 'true' )
                    // InternalMinotorDsl.g:712:5: lv_value_3_0= 'true'
                    {
                    lv_value_3_0=(Token)match(input,27,FOLLOW_2); 

                    					newLeafNode(lv_value_3_0, grammarAccess.getAttributeValueAccess().getValueTrueKeyword_3_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getAttributeValueRule());
                    					}
                    					setWithLastConsumed(current, "value", lv_value_3_0, "true");
                    				

                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalMinotorDsl.g:725:3: ( (lv_value_4_0= 'false' ) )
                    {
                    // InternalMinotorDsl.g:725:3: ( (lv_value_4_0= 'false' ) )
                    // InternalMinotorDsl.g:726:4: (lv_value_4_0= 'false' )
                    {
                    // InternalMinotorDsl.g:726:4: (lv_value_4_0= 'false' )
                    // InternalMinotorDsl.g:727:5: lv_value_4_0= 'false'
                    {
                    lv_value_4_0=(Token)match(input,28,FOLLOW_2); 

                    					newLeafNode(lv_value_4_0, grammarAccess.getAttributeValueAccess().getValueFalseKeyword_4_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getAttributeValueRule());
                    					}
                    					setWithLastConsumed(current, "value", lv_value_4_0, "false");
                    				

                    }


                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAttributeValue"


    // $ANTLR start "entryRuleFragmentAttribute"
    // InternalMinotorDsl.g:743:1: entryRuleFragmentAttribute returns [EObject current=null] : iv_ruleFragmentAttribute= ruleFragmentAttribute EOF ;
    public final EObject entryRuleFragmentAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFragmentAttribute = null;


        try {
            // InternalMinotorDsl.g:743:58: (iv_ruleFragmentAttribute= ruleFragmentAttribute EOF )
            // InternalMinotorDsl.g:744:2: iv_ruleFragmentAttribute= ruleFragmentAttribute EOF
            {
             newCompositeNode(grammarAccess.getFragmentAttributeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFragmentAttribute=ruleFragmentAttribute();

            state._fsp--;

             current =iv_ruleFragmentAttribute; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFragmentAttribute"


    // $ANTLR start "ruleFragmentAttribute"
    // InternalMinotorDsl.g:750:1: ruleFragmentAttribute returns [EObject current=null] : (otherlv_0= 'attributeconstraint' ( (lv_int_1_0= 'int' ) )? ( (lv_float_2_0= 'float' ) )? ( (lv_string_3_0= 'string' ) )? ( (lv_boolean_4_0= 'boolean' ) )? ( (lv_name_5_0= RULE_ID ) ) ( (lv_greater_6_0= '>' ) )? ( (lv_smaller_7_0= '<' ) )? ( (lv_greaterequals_8_0= '>=' ) )? ( (lv_smallerequals_9_0= '<=' ) )? ( (lv_equals_10_0= '==' ) )? ( (lv_notequals_11_0= '!=' ) )? ( (lv_value_12_0= ruleAttributeValue ) ) otherlv_13= ';' ) ;
    public final EObject ruleFragmentAttribute() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_int_1_0=null;
        Token lv_float_2_0=null;
        Token lv_string_3_0=null;
        Token lv_boolean_4_0=null;
        Token lv_name_5_0=null;
        Token lv_greater_6_0=null;
        Token lv_smaller_7_0=null;
        Token lv_greaterequals_8_0=null;
        Token lv_smallerequals_9_0=null;
        Token lv_equals_10_0=null;
        Token lv_notequals_11_0=null;
        Token otherlv_13=null;
        EObject lv_value_12_0 = null;



        	enterRule();

        try {
            // InternalMinotorDsl.g:756:2: ( (otherlv_0= 'attributeconstraint' ( (lv_int_1_0= 'int' ) )? ( (lv_float_2_0= 'float' ) )? ( (lv_string_3_0= 'string' ) )? ( (lv_boolean_4_0= 'boolean' ) )? ( (lv_name_5_0= RULE_ID ) ) ( (lv_greater_6_0= '>' ) )? ( (lv_smaller_7_0= '<' ) )? ( (lv_greaterequals_8_0= '>=' ) )? ( (lv_smallerequals_9_0= '<=' ) )? ( (lv_equals_10_0= '==' ) )? ( (lv_notequals_11_0= '!=' ) )? ( (lv_value_12_0= ruleAttributeValue ) ) otherlv_13= ';' ) )
            // InternalMinotorDsl.g:757:2: (otherlv_0= 'attributeconstraint' ( (lv_int_1_0= 'int' ) )? ( (lv_float_2_0= 'float' ) )? ( (lv_string_3_0= 'string' ) )? ( (lv_boolean_4_0= 'boolean' ) )? ( (lv_name_5_0= RULE_ID ) ) ( (lv_greater_6_0= '>' ) )? ( (lv_smaller_7_0= '<' ) )? ( (lv_greaterequals_8_0= '>=' ) )? ( (lv_smallerequals_9_0= '<=' ) )? ( (lv_equals_10_0= '==' ) )? ( (lv_notequals_11_0= '!=' ) )? ( (lv_value_12_0= ruleAttributeValue ) ) otherlv_13= ';' )
            {
            // InternalMinotorDsl.g:757:2: (otherlv_0= 'attributeconstraint' ( (lv_int_1_0= 'int' ) )? ( (lv_float_2_0= 'float' ) )? ( (lv_string_3_0= 'string' ) )? ( (lv_boolean_4_0= 'boolean' ) )? ( (lv_name_5_0= RULE_ID ) ) ( (lv_greater_6_0= '>' ) )? ( (lv_smaller_7_0= '<' ) )? ( (lv_greaterequals_8_0= '>=' ) )? ( (lv_smallerequals_9_0= '<=' ) )? ( (lv_equals_10_0= '==' ) )? ( (lv_notequals_11_0= '!=' ) )? ( (lv_value_12_0= ruleAttributeValue ) ) otherlv_13= ';' )
            // InternalMinotorDsl.g:758:3: otherlv_0= 'attributeconstraint' ( (lv_int_1_0= 'int' ) )? ( (lv_float_2_0= 'float' ) )? ( (lv_string_3_0= 'string' ) )? ( (lv_boolean_4_0= 'boolean' ) )? ( (lv_name_5_0= RULE_ID ) ) ( (lv_greater_6_0= '>' ) )? ( (lv_smaller_7_0= '<' ) )? ( (lv_greaterequals_8_0= '>=' ) )? ( (lv_smallerequals_9_0= '<=' ) )? ( (lv_equals_10_0= '==' ) )? ( (lv_notequals_11_0= '!=' ) )? ( (lv_value_12_0= ruleAttributeValue ) ) otherlv_13= ';'
            {
            otherlv_0=(Token)match(input,29,FOLLOW_21); 

            			newLeafNode(otherlv_0, grammarAccess.getFragmentAttributeAccess().getAttributeconstraintKeyword_0());
            		
            // InternalMinotorDsl.g:762:3: ( (lv_int_1_0= 'int' ) )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==21) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalMinotorDsl.g:763:4: (lv_int_1_0= 'int' )
                    {
                    // InternalMinotorDsl.g:763:4: (lv_int_1_0= 'int' )
                    // InternalMinotorDsl.g:764:5: lv_int_1_0= 'int'
                    {
                    lv_int_1_0=(Token)match(input,21,FOLLOW_22); 

                    					newLeafNode(lv_int_1_0, grammarAccess.getFragmentAttributeAccess().getIntIntKeyword_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getFragmentAttributeRule());
                    					}
                    					setWithLastConsumed(current, "int", lv_int_1_0 != null, "int");
                    				

                    }


                    }
                    break;

            }

            // InternalMinotorDsl.g:776:3: ( (lv_float_2_0= 'float' ) )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==22) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalMinotorDsl.g:777:4: (lv_float_2_0= 'float' )
                    {
                    // InternalMinotorDsl.g:777:4: (lv_float_2_0= 'float' )
                    // InternalMinotorDsl.g:778:5: lv_float_2_0= 'float'
                    {
                    lv_float_2_0=(Token)match(input,22,FOLLOW_23); 

                    					newLeafNode(lv_float_2_0, grammarAccess.getFragmentAttributeAccess().getFloatFloatKeyword_2_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getFragmentAttributeRule());
                    					}
                    					setWithLastConsumed(current, "float", lv_float_2_0 != null, "float");
                    				

                    }


                    }
                    break;

            }

            // InternalMinotorDsl.g:790:3: ( (lv_string_3_0= 'string' ) )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==23) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalMinotorDsl.g:791:4: (lv_string_3_0= 'string' )
                    {
                    // InternalMinotorDsl.g:791:4: (lv_string_3_0= 'string' )
                    // InternalMinotorDsl.g:792:5: lv_string_3_0= 'string'
                    {
                    lv_string_3_0=(Token)match(input,23,FOLLOW_24); 

                    					newLeafNode(lv_string_3_0, grammarAccess.getFragmentAttributeAccess().getStringStringKeyword_3_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getFragmentAttributeRule());
                    					}
                    					setWithLastConsumed(current, "string", lv_string_3_0 != null, "string");
                    				

                    }


                    }
                    break;

            }

            // InternalMinotorDsl.g:804:3: ( (lv_boolean_4_0= 'boolean' ) )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==24) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalMinotorDsl.g:805:4: (lv_boolean_4_0= 'boolean' )
                    {
                    // InternalMinotorDsl.g:805:4: (lv_boolean_4_0= 'boolean' )
                    // InternalMinotorDsl.g:806:5: lv_boolean_4_0= 'boolean'
                    {
                    lv_boolean_4_0=(Token)match(input,24,FOLLOW_13); 

                    					newLeafNode(lv_boolean_4_0, grammarAccess.getFragmentAttributeAccess().getBooleanBooleanKeyword_4_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getFragmentAttributeRule());
                    					}
                    					setWithLastConsumed(current, "boolean", lv_boolean_4_0 != null, "boolean");
                    				

                    }


                    }
                    break;

            }

            // InternalMinotorDsl.g:818:3: ( (lv_name_5_0= RULE_ID ) )
            // InternalMinotorDsl.g:819:4: (lv_name_5_0= RULE_ID )
            {
            // InternalMinotorDsl.g:819:4: (lv_name_5_0= RULE_ID )
            // InternalMinotorDsl.g:820:5: lv_name_5_0= RULE_ID
            {
            lv_name_5_0=(Token)match(input,RULE_ID,FOLLOW_28); 

            					newLeafNode(lv_name_5_0, grammarAccess.getFragmentAttributeAccess().getNameIDTerminalRuleCall_5_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getFragmentAttributeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_5_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalMinotorDsl.g:836:3: ( (lv_greater_6_0= '>' ) )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==30) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalMinotorDsl.g:837:4: (lv_greater_6_0= '>' )
                    {
                    // InternalMinotorDsl.g:837:4: (lv_greater_6_0= '>' )
                    // InternalMinotorDsl.g:838:5: lv_greater_6_0= '>'
                    {
                    lv_greater_6_0=(Token)match(input,30,FOLLOW_29); 

                    					newLeafNode(lv_greater_6_0, grammarAccess.getFragmentAttributeAccess().getGreaterGreaterThanSignKeyword_6_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getFragmentAttributeRule());
                    					}
                    					setWithLastConsumed(current, "greater", lv_greater_6_0 != null, ">");
                    				

                    }


                    }
                    break;

            }

            // InternalMinotorDsl.g:850:3: ( (lv_smaller_7_0= '<' ) )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==31) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalMinotorDsl.g:851:4: (lv_smaller_7_0= '<' )
                    {
                    // InternalMinotorDsl.g:851:4: (lv_smaller_7_0= '<' )
                    // InternalMinotorDsl.g:852:5: lv_smaller_7_0= '<'
                    {
                    lv_smaller_7_0=(Token)match(input,31,FOLLOW_30); 

                    					newLeafNode(lv_smaller_7_0, grammarAccess.getFragmentAttributeAccess().getSmallerLessThanSignKeyword_7_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getFragmentAttributeRule());
                    					}
                    					setWithLastConsumed(current, "smaller", lv_smaller_7_0 != null, "<");
                    				

                    }


                    }
                    break;

            }

            // InternalMinotorDsl.g:864:3: ( (lv_greaterequals_8_0= '>=' ) )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==32) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalMinotorDsl.g:865:4: (lv_greaterequals_8_0= '>=' )
                    {
                    // InternalMinotorDsl.g:865:4: (lv_greaterequals_8_0= '>=' )
                    // InternalMinotorDsl.g:866:5: lv_greaterequals_8_0= '>='
                    {
                    lv_greaterequals_8_0=(Token)match(input,32,FOLLOW_31); 

                    					newLeafNode(lv_greaterequals_8_0, grammarAccess.getFragmentAttributeAccess().getGreaterequalsGreaterThanSignEqualsSignKeyword_8_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getFragmentAttributeRule());
                    					}
                    					setWithLastConsumed(current, "greaterequals", lv_greaterequals_8_0 != null, ">=");
                    				

                    }


                    }
                    break;

            }

            // InternalMinotorDsl.g:878:3: ( (lv_smallerequals_9_0= '<=' ) )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==33) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalMinotorDsl.g:879:4: (lv_smallerequals_9_0= '<=' )
                    {
                    // InternalMinotorDsl.g:879:4: (lv_smallerequals_9_0= '<=' )
                    // InternalMinotorDsl.g:880:5: lv_smallerequals_9_0= '<='
                    {
                    lv_smallerequals_9_0=(Token)match(input,33,FOLLOW_32); 

                    					newLeafNode(lv_smallerequals_9_0, grammarAccess.getFragmentAttributeAccess().getSmallerequalsLessThanSignEqualsSignKeyword_9_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getFragmentAttributeRule());
                    					}
                    					setWithLastConsumed(current, "smallerequals", lv_smallerequals_9_0 != null, "<=");
                    				

                    }


                    }
                    break;

            }

            // InternalMinotorDsl.g:892:3: ( (lv_equals_10_0= '==' ) )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==34) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalMinotorDsl.g:893:4: (lv_equals_10_0= '==' )
                    {
                    // InternalMinotorDsl.g:893:4: (lv_equals_10_0= '==' )
                    // InternalMinotorDsl.g:894:5: lv_equals_10_0= '=='
                    {
                    lv_equals_10_0=(Token)match(input,34,FOLLOW_33); 

                    					newLeafNode(lv_equals_10_0, grammarAccess.getFragmentAttributeAccess().getEqualsEqualsSignEqualsSignKeyword_10_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getFragmentAttributeRule());
                    					}
                    					setWithLastConsumed(current, "equals", lv_equals_10_0 != null, "==");
                    				

                    }


                    }
                    break;

            }

            // InternalMinotorDsl.g:906:3: ( (lv_notequals_11_0= '!=' ) )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==35) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalMinotorDsl.g:907:4: (lv_notequals_11_0= '!=' )
                    {
                    // InternalMinotorDsl.g:907:4: (lv_notequals_11_0= '!=' )
                    // InternalMinotorDsl.g:908:5: lv_notequals_11_0= '!='
                    {
                    lv_notequals_11_0=(Token)match(input,35,FOLLOW_34); 

                    					newLeafNode(lv_notequals_11_0, grammarAccess.getFragmentAttributeAccess().getNotequalsExclamationMarkEqualsSignKeyword_11_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getFragmentAttributeRule());
                    					}
                    					setWithLastConsumed(current, "notequals", lv_notequals_11_0 != null, "!=");
                    				

                    }


                    }
                    break;

            }

            // InternalMinotorDsl.g:920:3: ( (lv_value_12_0= ruleAttributeValue ) )
            // InternalMinotorDsl.g:921:4: (lv_value_12_0= ruleAttributeValue )
            {
            // InternalMinotorDsl.g:921:4: (lv_value_12_0= ruleAttributeValue )
            // InternalMinotorDsl.g:922:5: lv_value_12_0= ruleAttributeValue
            {

            					newCompositeNode(grammarAccess.getFragmentAttributeAccess().getValueAttributeValueParserRuleCall_12_0());
            				
            pushFollow(FOLLOW_27);
            lv_value_12_0=ruleAttributeValue();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getFragmentAttributeRule());
            					}
            					set(
            						current,
            						"value",
            						lv_value_12_0,
            						"hu.bme.mit.dipterv.text.MinotorDsl.AttributeValue");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_13=(Token)match(input,26,FOLLOW_2); 

            			newLeafNode(otherlv_13, grammarAccess.getFragmentAttributeAccess().getSemicolonKeyword_13());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFragmentAttribute"


    // $ANTLR start "entryRuleEntity"
    // InternalMinotorDsl.g:947:1: entryRuleEntity returns [EObject current=null] : iv_ruleEntity= ruleEntity EOF ;
    public final EObject entryRuleEntity() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntity = null;


        try {
            // InternalMinotorDsl.g:947:47: (iv_ruleEntity= ruleEntity EOF )
            // InternalMinotorDsl.g:948:2: iv_ruleEntity= ruleEntity EOF
            {
             newCompositeNode(grammarAccess.getEntityRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEntity=ruleEntity();

            state._fsp--;

             current =iv_ruleEntity; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEntity"


    // $ANTLR start "ruleEntity"
    // InternalMinotorDsl.g:954:1: ruleEntity returns [EObject current=null] : (otherlv_0= 'entity' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= '}' ) ;
    public final EObject ruleEntity() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_attributes_3_0 = null;



        	enterRule();

        try {
            // InternalMinotorDsl.g:960:2: ( (otherlv_0= 'entity' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= '}' ) )
            // InternalMinotorDsl.g:961:2: (otherlv_0= 'entity' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= '}' )
            {
            // InternalMinotorDsl.g:961:2: (otherlv_0= 'entity' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= '}' )
            // InternalMinotorDsl.g:962:3: otherlv_0= 'entity' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,36,FOLLOW_13); 

            			newLeafNode(otherlv_0, grammarAccess.getEntityAccess().getEntityKeyword_0());
            		
            // InternalMinotorDsl.g:966:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMinotorDsl.g:967:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMinotorDsl.g:967:4: (lv_name_1_0= RULE_ID )
            // InternalMinotorDsl.g:968:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_16); 

            					newLeafNode(lv_name_1_0, grammarAccess.getEntityAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,14,FOLLOW_35); 

            			newLeafNode(otherlv_2, grammarAccess.getEntityAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalMinotorDsl.g:988:3: ( (lv_attributes_3_0= ruleAttribute ) )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==20) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // InternalMinotorDsl.g:989:4: (lv_attributes_3_0= ruleAttribute )
            	    {
            	    // InternalMinotorDsl.g:989:4: (lv_attributes_3_0= ruleAttribute )
            	    // InternalMinotorDsl.g:990:5: lv_attributes_3_0= ruleAttribute
            	    {

            	    					newCompositeNode(grammarAccess.getEntityAccess().getAttributesAttributeParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_35);
            	    lv_attributes_3_0=ruleAttribute();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getEntityRule());
            	    					}
            	    					add(
            	    						current,
            	    						"attributes",
            	    						lv_attributes_3_0,
            	    						"hu.bme.mit.dipterv.text.MinotorDsl.Attribute");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);

            otherlv_4=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getEntityAccess().getRightCurlyBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEntity"


    // $ANTLR start "entryRuleFEntity"
    // InternalMinotorDsl.g:1015:1: entryRuleFEntity returns [EObject current=null] : iv_ruleFEntity= ruleFEntity EOF ;
    public final EObject entryRuleFEntity() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFEntity = null;


        try {
            // InternalMinotorDsl.g:1015:48: (iv_ruleFEntity= ruleFEntity EOF )
            // InternalMinotorDsl.g:1016:2: iv_ruleFEntity= ruleFEntity EOF
            {
             newCompositeNode(grammarAccess.getFEntityRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFEntity=ruleFEntity();

            state._fsp--;

             current =iv_ruleFEntity; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFEntity"


    // $ANTLR start "ruleFEntity"
    // InternalMinotorDsl.g:1022:1: ruleFEntity returns [EObject current=null] : (otherlv_0= 'entityconstraint' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_attributes_3_0= ruleFragmentAttribute ) )* otherlv_4= '}' ) ;
    public final EObject ruleFEntity() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_attributes_3_0 = null;



        	enterRule();

        try {
            // InternalMinotorDsl.g:1028:2: ( (otherlv_0= 'entityconstraint' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_attributes_3_0= ruleFragmentAttribute ) )* otherlv_4= '}' ) )
            // InternalMinotorDsl.g:1029:2: (otherlv_0= 'entityconstraint' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_attributes_3_0= ruleFragmentAttribute ) )* otherlv_4= '}' )
            {
            // InternalMinotorDsl.g:1029:2: (otherlv_0= 'entityconstraint' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_attributes_3_0= ruleFragmentAttribute ) )* otherlv_4= '}' )
            // InternalMinotorDsl.g:1030:3: otherlv_0= 'entityconstraint' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_attributes_3_0= ruleFragmentAttribute ) )* otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,37,FOLLOW_13); 

            			newLeafNode(otherlv_0, grammarAccess.getFEntityAccess().getEntityconstraintKeyword_0());
            		
            // InternalMinotorDsl.g:1034:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMinotorDsl.g:1035:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMinotorDsl.g:1035:4: (lv_name_1_0= RULE_ID )
            // InternalMinotorDsl.g:1036:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_16); 

            					newLeafNode(lv_name_1_0, grammarAccess.getFEntityAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getFEntityRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,14,FOLLOW_36); 

            			newLeafNode(otherlv_2, grammarAccess.getFEntityAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalMinotorDsl.g:1056:3: ( (lv_attributes_3_0= ruleFragmentAttribute ) )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==29) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // InternalMinotorDsl.g:1057:4: (lv_attributes_3_0= ruleFragmentAttribute )
            	    {
            	    // InternalMinotorDsl.g:1057:4: (lv_attributes_3_0= ruleFragmentAttribute )
            	    // InternalMinotorDsl.g:1058:5: lv_attributes_3_0= ruleFragmentAttribute
            	    {

            	    					newCompositeNode(grammarAccess.getFEntityAccess().getAttributesFragmentAttributeParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_36);
            	    lv_attributes_3_0=ruleFragmentAttribute();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getFEntityRule());
            	    					}
            	    					add(
            	    						current,
            	    						"attributes",
            	    						lv_attributes_3_0,
            	    						"hu.bme.mit.dipterv.text.MinotorDsl.FragmentAttribute");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop35;
                }
            } while (true);

            otherlv_4=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getFEntityAccess().getRightCurlyBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFEntity"


    // $ANTLR start "entryRuleRelation"
    // InternalMinotorDsl.g:1083:1: entryRuleRelation returns [EObject current=null] : iv_ruleRelation= ruleRelation EOF ;
    public final EObject entryRuleRelation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelation = null;


        try {
            // InternalMinotorDsl.g:1083:49: (iv_ruleRelation= ruleRelation EOF )
            // InternalMinotorDsl.g:1084:2: iv_ruleRelation= ruleRelation EOF
            {
             newCompositeNode(grammarAccess.getRelationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRelation=ruleRelation();

            state._fsp--;

             current =iv_ruleRelation; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRelation"


    // $ANTLR start "ruleRelation"
    // InternalMinotorDsl.g:1090:1: ruleRelation returns [EObject current=null] : (otherlv_0= 'relation' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ',' ( (otherlv_5= RULE_ID ) ) otherlv_6= ')' otherlv_7= '{' ( (lv_attributes_8_0= ruleAttribute ) )* otherlv_9= '}' ) ;
    public final EObject ruleRelation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        EObject lv_attributes_8_0 = null;



        	enterRule();

        try {
            // InternalMinotorDsl.g:1096:2: ( (otherlv_0= 'relation' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ',' ( (otherlv_5= RULE_ID ) ) otherlv_6= ')' otherlv_7= '{' ( (lv_attributes_8_0= ruleAttribute ) )* otherlv_9= '}' ) )
            // InternalMinotorDsl.g:1097:2: (otherlv_0= 'relation' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ',' ( (otherlv_5= RULE_ID ) ) otherlv_6= ')' otherlv_7= '{' ( (lv_attributes_8_0= ruleAttribute ) )* otherlv_9= '}' )
            {
            // InternalMinotorDsl.g:1097:2: (otherlv_0= 'relation' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ',' ( (otherlv_5= RULE_ID ) ) otherlv_6= ')' otherlv_7= '{' ( (lv_attributes_8_0= ruleAttribute ) )* otherlv_9= '}' )
            // InternalMinotorDsl.g:1098:3: otherlv_0= 'relation' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ',' ( (otherlv_5= RULE_ID ) ) otherlv_6= ')' otherlv_7= '{' ( (lv_attributes_8_0= ruleAttribute ) )* otherlv_9= '}'
            {
            otherlv_0=(Token)match(input,38,FOLLOW_13); 

            			newLeafNode(otherlv_0, grammarAccess.getRelationAccess().getRelationKeyword_0());
            		
            // InternalMinotorDsl.g:1102:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMinotorDsl.g:1103:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMinotorDsl.g:1103:4: (lv_name_1_0= RULE_ID )
            // InternalMinotorDsl.g:1104:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_37); 

            					newLeafNode(lv_name_1_0, grammarAccess.getRelationAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getRelationRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,39,FOLLOW_13); 

            			newLeafNode(otherlv_2, grammarAccess.getRelationAccess().getLeftParenthesisKeyword_2());
            		
            // InternalMinotorDsl.g:1124:3: ( (otherlv_3= RULE_ID ) )
            // InternalMinotorDsl.g:1125:4: (otherlv_3= RULE_ID )
            {
            // InternalMinotorDsl.g:1125:4: (otherlv_3= RULE_ID )
            // InternalMinotorDsl.g:1126:5: otherlv_3= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getRelationRule());
            					}
            				
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_38); 

            					newLeafNode(otherlv_3, grammarAccess.getRelationAccess().getSenderEntityCrossReference_3_0());
            				

            }


            }

            otherlv_4=(Token)match(input,40,FOLLOW_13); 

            			newLeafNode(otherlv_4, grammarAccess.getRelationAccess().getCommaKeyword_4());
            		
            // InternalMinotorDsl.g:1141:3: ( (otherlv_5= RULE_ID ) )
            // InternalMinotorDsl.g:1142:4: (otherlv_5= RULE_ID )
            {
            // InternalMinotorDsl.g:1142:4: (otherlv_5= RULE_ID )
            // InternalMinotorDsl.g:1143:5: otherlv_5= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getRelationRule());
            					}
            				
            otherlv_5=(Token)match(input,RULE_ID,FOLLOW_39); 

            					newLeafNode(otherlv_5, grammarAccess.getRelationAccess().getReceiverEntityCrossReference_5_0());
            				

            }


            }

            otherlv_6=(Token)match(input,41,FOLLOW_16); 

            			newLeafNode(otherlv_6, grammarAccess.getRelationAccess().getRightParenthesisKeyword_6());
            		
            otherlv_7=(Token)match(input,14,FOLLOW_35); 

            			newLeafNode(otherlv_7, grammarAccess.getRelationAccess().getLeftCurlyBracketKeyword_7());
            		
            // InternalMinotorDsl.g:1162:3: ( (lv_attributes_8_0= ruleAttribute ) )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==20) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // InternalMinotorDsl.g:1163:4: (lv_attributes_8_0= ruleAttribute )
            	    {
            	    // InternalMinotorDsl.g:1163:4: (lv_attributes_8_0= ruleAttribute )
            	    // InternalMinotorDsl.g:1164:5: lv_attributes_8_0= ruleAttribute
            	    {

            	    					newCompositeNode(grammarAccess.getRelationAccess().getAttributesAttributeParserRuleCall_8_0());
            	    				
            	    pushFollow(FOLLOW_35);
            	    lv_attributes_8_0=ruleAttribute();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getRelationRule());
            	    					}
            	    					add(
            	    						current,
            	    						"attributes",
            	    						lv_attributes_8_0,
            	    						"hu.bme.mit.dipterv.text.MinotorDsl.Attribute");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop36;
                }
            } while (true);

            otherlv_9=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_9, grammarAccess.getRelationAccess().getRightCurlyBracketKeyword_9());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRelation"


    // $ANTLR start "entryRuleFRelation"
    // InternalMinotorDsl.g:1189:1: entryRuleFRelation returns [EObject current=null] : iv_ruleFRelation= ruleFRelation EOF ;
    public final EObject entryRuleFRelation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFRelation = null;


        try {
            // InternalMinotorDsl.g:1189:50: (iv_ruleFRelation= ruleFRelation EOF )
            // InternalMinotorDsl.g:1190:2: iv_ruleFRelation= ruleFRelation EOF
            {
             newCompositeNode(grammarAccess.getFRelationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFRelation=ruleFRelation();

            state._fsp--;

             current =iv_ruleFRelation; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFRelation"


    // $ANTLR start "ruleFRelation"
    // InternalMinotorDsl.g:1196:1: ruleFRelation returns [EObject current=null] : (otherlv_0= 'relationconstraint' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ',' ( (otherlv_5= RULE_ID ) ) otherlv_6= ')' otherlv_7= '{' ( (lv_attributes_8_0= ruleFragmentAttribute ) )* otherlv_9= '}' ) ;
    public final EObject ruleFRelation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        EObject lv_attributes_8_0 = null;



        	enterRule();

        try {
            // InternalMinotorDsl.g:1202:2: ( (otherlv_0= 'relationconstraint' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ',' ( (otherlv_5= RULE_ID ) ) otherlv_6= ')' otherlv_7= '{' ( (lv_attributes_8_0= ruleFragmentAttribute ) )* otherlv_9= '}' ) )
            // InternalMinotorDsl.g:1203:2: (otherlv_0= 'relationconstraint' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ',' ( (otherlv_5= RULE_ID ) ) otherlv_6= ')' otherlv_7= '{' ( (lv_attributes_8_0= ruleFragmentAttribute ) )* otherlv_9= '}' )
            {
            // InternalMinotorDsl.g:1203:2: (otherlv_0= 'relationconstraint' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ',' ( (otherlv_5= RULE_ID ) ) otherlv_6= ')' otherlv_7= '{' ( (lv_attributes_8_0= ruleFragmentAttribute ) )* otherlv_9= '}' )
            // InternalMinotorDsl.g:1204:3: otherlv_0= 'relationconstraint' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ',' ( (otherlv_5= RULE_ID ) ) otherlv_6= ')' otherlv_7= '{' ( (lv_attributes_8_0= ruleFragmentAttribute ) )* otherlv_9= '}'
            {
            otherlv_0=(Token)match(input,42,FOLLOW_13); 

            			newLeafNode(otherlv_0, grammarAccess.getFRelationAccess().getRelationconstraintKeyword_0());
            		
            // InternalMinotorDsl.g:1208:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMinotorDsl.g:1209:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMinotorDsl.g:1209:4: (lv_name_1_0= RULE_ID )
            // InternalMinotorDsl.g:1210:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_37); 

            					newLeafNode(lv_name_1_0, grammarAccess.getFRelationAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getFRelationRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,39,FOLLOW_13); 

            			newLeafNode(otherlv_2, grammarAccess.getFRelationAccess().getLeftParenthesisKeyword_2());
            		
            // InternalMinotorDsl.g:1230:3: ( (otherlv_3= RULE_ID ) )
            // InternalMinotorDsl.g:1231:4: (otherlv_3= RULE_ID )
            {
            // InternalMinotorDsl.g:1231:4: (otherlv_3= RULE_ID )
            // InternalMinotorDsl.g:1232:5: otherlv_3= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getFRelationRule());
            					}
            				
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_38); 

            					newLeafNode(otherlv_3, grammarAccess.getFRelationAccess().getSenderFEntityCrossReference_3_0());
            				

            }


            }

            otherlv_4=(Token)match(input,40,FOLLOW_13); 

            			newLeafNode(otherlv_4, grammarAccess.getFRelationAccess().getCommaKeyword_4());
            		
            // InternalMinotorDsl.g:1247:3: ( (otherlv_5= RULE_ID ) )
            // InternalMinotorDsl.g:1248:4: (otherlv_5= RULE_ID )
            {
            // InternalMinotorDsl.g:1248:4: (otherlv_5= RULE_ID )
            // InternalMinotorDsl.g:1249:5: otherlv_5= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getFRelationRule());
            					}
            				
            otherlv_5=(Token)match(input,RULE_ID,FOLLOW_39); 

            					newLeafNode(otherlv_5, grammarAccess.getFRelationAccess().getReceiverFEntityCrossReference_5_0());
            				

            }


            }

            otherlv_6=(Token)match(input,41,FOLLOW_16); 

            			newLeafNode(otherlv_6, grammarAccess.getFRelationAccess().getRightParenthesisKeyword_6());
            		
            otherlv_7=(Token)match(input,14,FOLLOW_36); 

            			newLeafNode(otherlv_7, grammarAccess.getFRelationAccess().getLeftCurlyBracketKeyword_7());
            		
            // InternalMinotorDsl.g:1268:3: ( (lv_attributes_8_0= ruleFragmentAttribute ) )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==29) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // InternalMinotorDsl.g:1269:4: (lv_attributes_8_0= ruleFragmentAttribute )
            	    {
            	    // InternalMinotorDsl.g:1269:4: (lv_attributes_8_0= ruleFragmentAttribute )
            	    // InternalMinotorDsl.g:1270:5: lv_attributes_8_0= ruleFragmentAttribute
            	    {

            	    					newCompositeNode(grammarAccess.getFRelationAccess().getAttributesFragmentAttributeParserRuleCall_8_0());
            	    				
            	    pushFollow(FOLLOW_36);
            	    lv_attributes_8_0=ruleFragmentAttribute();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getFRelationRule());
            	    					}
            	    					add(
            	    						current,
            	    						"attributes",
            	    						lv_attributes_8_0,
            	    						"hu.bme.mit.dipterv.text.MinotorDsl.FragmentAttribute");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop37;
                }
            } while (true);

            otherlv_9=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_9, grammarAccess.getFRelationAccess().getRightCurlyBracketKeyword_9());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFRelation"


    // $ANTLR start "entryRuleScenario"
    // InternalMinotorDsl.g:1295:1: entryRuleScenario returns [EObject current=null] : iv_ruleScenario= ruleScenario EOF ;
    public final EObject entryRuleScenario() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScenario = null;


        try {
            // InternalMinotorDsl.g:1295:49: (iv_ruleScenario= ruleScenario EOF )
            // InternalMinotorDsl.g:1296:2: iv_ruleScenario= ruleScenario EOF
            {
             newCompositeNode(grammarAccess.getScenarioRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleScenario=ruleScenario();

            state._fsp--;

             current =iv_ruleScenario; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleScenario"


    // $ANTLR start "ruleScenario"
    // InternalMinotorDsl.g:1302:1: ruleScenario returns [EObject current=null] : (otherlv_0= 'scenario' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_scenariocontents_3_0= ruleScenarioContent ) )* otherlv_4= '}' ) ;
    public final EObject ruleScenario() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_scenariocontents_3_0 = null;



        	enterRule();

        try {
            // InternalMinotorDsl.g:1308:2: ( (otherlv_0= 'scenario' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_scenariocontents_3_0= ruleScenarioContent ) )* otherlv_4= '}' ) )
            // InternalMinotorDsl.g:1309:2: (otherlv_0= 'scenario' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_scenariocontents_3_0= ruleScenarioContent ) )* otherlv_4= '}' )
            {
            // InternalMinotorDsl.g:1309:2: (otherlv_0= 'scenario' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_scenariocontents_3_0= ruleScenarioContent ) )* otherlv_4= '}' )
            // InternalMinotorDsl.g:1310:3: otherlv_0= 'scenario' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_scenariocontents_3_0= ruleScenarioContent ) )* otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,43,FOLLOW_13); 

            			newLeafNode(otherlv_0, grammarAccess.getScenarioAccess().getScenarioKeyword_0());
            		
            // InternalMinotorDsl.g:1314:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMinotorDsl.g:1315:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMinotorDsl.g:1315:4: (lv_name_1_0= RULE_ID )
            // InternalMinotorDsl.g:1316:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_16); 

            					newLeafNode(lv_name_1_0, grammarAccess.getScenarioAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getScenarioRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,14,FOLLOW_40); 

            			newLeafNode(otherlv_2, grammarAccess.getScenarioAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalMinotorDsl.g:1336:3: ( (lv_scenariocontents_3_0= ruleScenarioContent ) )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( (LA38_0==44||(LA38_0>=55 && LA38_0<=56)||(LA38_0>=58 && LA38_0<=61)||(LA38_0>=64 && LA38_0<=65)||LA38_0==70||LA38_0==75||LA38_0==77) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // InternalMinotorDsl.g:1337:4: (lv_scenariocontents_3_0= ruleScenarioContent )
            	    {
            	    // InternalMinotorDsl.g:1337:4: (lv_scenariocontents_3_0= ruleScenarioContent )
            	    // InternalMinotorDsl.g:1338:5: lv_scenariocontents_3_0= ruleScenarioContent
            	    {

            	    					newCompositeNode(grammarAccess.getScenarioAccess().getScenariocontentsScenarioContentParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_40);
            	    lv_scenariocontents_3_0=ruleScenarioContent();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getScenarioRule());
            	    					}
            	    					add(
            	    						current,
            	    						"scenariocontents",
            	    						lv_scenariocontents_3_0,
            	    						"hu.bme.mit.dipterv.text.MinotorDsl.ScenarioContent");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop38;
                }
            } while (true);

            otherlv_4=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getScenarioAccess().getRightCurlyBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleScenario"


    // $ANTLR start "entryRuleScenarioContent"
    // InternalMinotorDsl.g:1363:1: entryRuleScenarioContent returns [EObject current=null] : iv_ruleScenarioContent= ruleScenarioContent EOF ;
    public final EObject entryRuleScenarioContent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScenarioContent = null;


        try {
            // InternalMinotorDsl.g:1363:56: (iv_ruleScenarioContent= ruleScenarioContent EOF )
            // InternalMinotorDsl.g:1364:2: iv_ruleScenarioContent= ruleScenarioContent EOF
            {
             newCompositeNode(grammarAccess.getScenarioContentRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleScenarioContent=ruleScenarioContent();

            state._fsp--;

             current =iv_ruleScenarioContent; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleScenarioContent"


    // $ANTLR start "ruleScenarioContent"
    // InternalMinotorDsl.g:1370:1: ruleScenarioContent returns [EObject current=null] : ( ( (lv_alt_0_0= ruleAlt ) ) | ( (lv_message_1_0= ruleMessage ) ) | ( (lv_par_2_0= rulePar ) ) | ( (lv_loop_3_0= ruleLoop ) ) | ( (lv_contextmessage_4_0= ruleContextMessage ) ) | ( (lv_paramConstraint_5_0= ruleParameterConstraint ) ) | ( (lv_assertentity_6_0= ruleAssertionEntity ) ) | ( (lv_assertrelation_7_0= ruleAssertionRelation ) ) ) ;
    public final EObject ruleScenarioContent() throws RecognitionException {
        EObject current = null;

        EObject lv_alt_0_0 = null;

        EObject lv_message_1_0 = null;

        EObject lv_par_2_0 = null;

        EObject lv_loop_3_0 = null;

        EObject lv_contextmessage_4_0 = null;

        EObject lv_paramConstraint_5_0 = null;

        EObject lv_assertentity_6_0 = null;

        EObject lv_assertrelation_7_0 = null;



        	enterRule();

        try {
            // InternalMinotorDsl.g:1376:2: ( ( ( (lv_alt_0_0= ruleAlt ) ) | ( (lv_message_1_0= ruleMessage ) ) | ( (lv_par_2_0= rulePar ) ) | ( (lv_loop_3_0= ruleLoop ) ) | ( (lv_contextmessage_4_0= ruleContextMessage ) ) | ( (lv_paramConstraint_5_0= ruleParameterConstraint ) ) | ( (lv_assertentity_6_0= ruleAssertionEntity ) ) | ( (lv_assertrelation_7_0= ruleAssertionRelation ) ) ) )
            // InternalMinotorDsl.g:1377:2: ( ( (lv_alt_0_0= ruleAlt ) ) | ( (lv_message_1_0= ruleMessage ) ) | ( (lv_par_2_0= rulePar ) ) | ( (lv_loop_3_0= ruleLoop ) ) | ( (lv_contextmessage_4_0= ruleContextMessage ) ) | ( (lv_paramConstraint_5_0= ruleParameterConstraint ) ) | ( (lv_assertentity_6_0= ruleAssertionEntity ) ) | ( (lv_assertrelation_7_0= ruleAssertionRelation ) ) )
            {
            // InternalMinotorDsl.g:1377:2: ( ( (lv_alt_0_0= ruleAlt ) ) | ( (lv_message_1_0= ruleMessage ) ) | ( (lv_par_2_0= rulePar ) ) | ( (lv_loop_3_0= ruleLoop ) ) | ( (lv_contextmessage_4_0= ruleContextMessage ) ) | ( (lv_paramConstraint_5_0= ruleParameterConstraint ) ) | ( (lv_assertentity_6_0= ruleAssertionEntity ) ) | ( (lv_assertrelation_7_0= ruleAssertionRelation ) ) )
            int alt39=8;
            switch ( input.LA(1) ) {
            case 70:
                {
                alt39=1;
                }
                break;
            case 44:
                {
                alt39=2;
                }
                break;
            case 75:
                {
                alt39=3;
                }
                break;
            case 77:
                {
                alt39=4;
                }
                break;
            case 55:
            case 56:
            case 58:
            case 59:
            case 60:
                {
                alt39=5;
                }
                break;
            case 65:
                {
                alt39=6;
                }
                break;
            case 61:
                {
                alt39=7;
                }
                break;
            case 64:
                {
                alt39=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 39, 0, input);

                throw nvae;
            }

            switch (alt39) {
                case 1 :
                    // InternalMinotorDsl.g:1378:3: ( (lv_alt_0_0= ruleAlt ) )
                    {
                    // InternalMinotorDsl.g:1378:3: ( (lv_alt_0_0= ruleAlt ) )
                    // InternalMinotorDsl.g:1379:4: (lv_alt_0_0= ruleAlt )
                    {
                    // InternalMinotorDsl.g:1379:4: (lv_alt_0_0= ruleAlt )
                    // InternalMinotorDsl.g:1380:5: lv_alt_0_0= ruleAlt
                    {

                    					newCompositeNode(grammarAccess.getScenarioContentAccess().getAltAltParserRuleCall_0_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_alt_0_0=ruleAlt();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getScenarioContentRule());
                    					}
                    					add(
                    						current,
                    						"alt",
                    						lv_alt_0_0,
                    						"hu.bme.mit.dipterv.text.MinotorDsl.Alt");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalMinotorDsl.g:1398:3: ( (lv_message_1_0= ruleMessage ) )
                    {
                    // InternalMinotorDsl.g:1398:3: ( (lv_message_1_0= ruleMessage ) )
                    // InternalMinotorDsl.g:1399:4: (lv_message_1_0= ruleMessage )
                    {
                    // InternalMinotorDsl.g:1399:4: (lv_message_1_0= ruleMessage )
                    // InternalMinotorDsl.g:1400:5: lv_message_1_0= ruleMessage
                    {

                    					newCompositeNode(grammarAccess.getScenarioContentAccess().getMessageMessageParserRuleCall_1_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_message_1_0=ruleMessage();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getScenarioContentRule());
                    					}
                    					add(
                    						current,
                    						"message",
                    						lv_message_1_0,
                    						"hu.bme.mit.dipterv.text.MinotorDsl.Message");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalMinotorDsl.g:1418:3: ( (lv_par_2_0= rulePar ) )
                    {
                    // InternalMinotorDsl.g:1418:3: ( (lv_par_2_0= rulePar ) )
                    // InternalMinotorDsl.g:1419:4: (lv_par_2_0= rulePar )
                    {
                    // InternalMinotorDsl.g:1419:4: (lv_par_2_0= rulePar )
                    // InternalMinotorDsl.g:1420:5: lv_par_2_0= rulePar
                    {

                    					newCompositeNode(grammarAccess.getScenarioContentAccess().getParParParserRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_par_2_0=rulePar();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getScenarioContentRule());
                    					}
                    					add(
                    						current,
                    						"par",
                    						lv_par_2_0,
                    						"hu.bme.mit.dipterv.text.MinotorDsl.Par");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalMinotorDsl.g:1438:3: ( (lv_loop_3_0= ruleLoop ) )
                    {
                    // InternalMinotorDsl.g:1438:3: ( (lv_loop_3_0= ruleLoop ) )
                    // InternalMinotorDsl.g:1439:4: (lv_loop_3_0= ruleLoop )
                    {
                    // InternalMinotorDsl.g:1439:4: (lv_loop_3_0= ruleLoop )
                    // InternalMinotorDsl.g:1440:5: lv_loop_3_0= ruleLoop
                    {

                    					newCompositeNode(grammarAccess.getScenarioContentAccess().getLoopLoopParserRuleCall_3_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_loop_3_0=ruleLoop();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getScenarioContentRule());
                    					}
                    					add(
                    						current,
                    						"loop",
                    						lv_loop_3_0,
                    						"hu.bme.mit.dipterv.text.MinotorDsl.Loop");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalMinotorDsl.g:1458:3: ( (lv_contextmessage_4_0= ruleContextMessage ) )
                    {
                    // InternalMinotorDsl.g:1458:3: ( (lv_contextmessage_4_0= ruleContextMessage ) )
                    // InternalMinotorDsl.g:1459:4: (lv_contextmessage_4_0= ruleContextMessage )
                    {
                    // InternalMinotorDsl.g:1459:4: (lv_contextmessage_4_0= ruleContextMessage )
                    // InternalMinotorDsl.g:1460:5: lv_contextmessage_4_0= ruleContextMessage
                    {

                    					newCompositeNode(grammarAccess.getScenarioContentAccess().getContextmessageContextMessageParserRuleCall_4_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_contextmessage_4_0=ruleContextMessage();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getScenarioContentRule());
                    					}
                    					add(
                    						current,
                    						"contextmessage",
                    						lv_contextmessage_4_0,
                    						"hu.bme.mit.dipterv.text.MinotorDsl.ContextMessage");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 6 :
                    // InternalMinotorDsl.g:1478:3: ( (lv_paramConstraint_5_0= ruleParameterConstraint ) )
                    {
                    // InternalMinotorDsl.g:1478:3: ( (lv_paramConstraint_5_0= ruleParameterConstraint ) )
                    // InternalMinotorDsl.g:1479:4: (lv_paramConstraint_5_0= ruleParameterConstraint )
                    {
                    // InternalMinotorDsl.g:1479:4: (lv_paramConstraint_5_0= ruleParameterConstraint )
                    // InternalMinotorDsl.g:1480:5: lv_paramConstraint_5_0= ruleParameterConstraint
                    {

                    					newCompositeNode(grammarAccess.getScenarioContentAccess().getParamConstraintParameterConstraintParserRuleCall_5_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_paramConstraint_5_0=ruleParameterConstraint();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getScenarioContentRule());
                    					}
                    					add(
                    						current,
                    						"paramConstraint",
                    						lv_paramConstraint_5_0,
                    						"hu.bme.mit.dipterv.text.MinotorDsl.ParameterConstraint");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 7 :
                    // InternalMinotorDsl.g:1498:3: ( (lv_assertentity_6_0= ruleAssertionEntity ) )
                    {
                    // InternalMinotorDsl.g:1498:3: ( (lv_assertentity_6_0= ruleAssertionEntity ) )
                    // InternalMinotorDsl.g:1499:4: (lv_assertentity_6_0= ruleAssertionEntity )
                    {
                    // InternalMinotorDsl.g:1499:4: (lv_assertentity_6_0= ruleAssertionEntity )
                    // InternalMinotorDsl.g:1500:5: lv_assertentity_6_0= ruleAssertionEntity
                    {

                    					newCompositeNode(grammarAccess.getScenarioContentAccess().getAssertentityAssertionEntityParserRuleCall_6_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_assertentity_6_0=ruleAssertionEntity();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getScenarioContentRule());
                    					}
                    					add(
                    						current,
                    						"assertentity",
                    						lv_assertentity_6_0,
                    						"hu.bme.mit.dipterv.text.MinotorDsl.AssertionEntity");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 8 :
                    // InternalMinotorDsl.g:1518:3: ( (lv_assertrelation_7_0= ruleAssertionRelation ) )
                    {
                    // InternalMinotorDsl.g:1518:3: ( (lv_assertrelation_7_0= ruleAssertionRelation ) )
                    // InternalMinotorDsl.g:1519:4: (lv_assertrelation_7_0= ruleAssertionRelation )
                    {
                    // InternalMinotorDsl.g:1519:4: (lv_assertrelation_7_0= ruleAssertionRelation )
                    // InternalMinotorDsl.g:1520:5: lv_assertrelation_7_0= ruleAssertionRelation
                    {

                    					newCompositeNode(grammarAccess.getScenarioContentAccess().getAssertrelationAssertionRelationParserRuleCall_7_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_assertrelation_7_0=ruleAssertionRelation();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getScenarioContentRule());
                    					}
                    					add(
                    						current,
                    						"assertrelation",
                    						lv_assertrelation_7_0,
                    						"hu.bme.mit.dipterv.text.MinotorDsl.AssertionRelation");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleScenarioContent"


    // $ANTLR start "entryRuleMessage"
    // InternalMinotorDsl.g:1541:1: entryRuleMessage returns [EObject current=null] : iv_ruleMessage= ruleMessage EOF ;
    public final EObject entryRuleMessage() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMessage = null;


        try {
            // InternalMinotorDsl.g:1541:48: (iv_ruleMessage= ruleMessage EOF )
            // InternalMinotorDsl.g:1542:2: iv_ruleMessage= ruleMessage EOF
            {
             newCompositeNode(grammarAccess.getMessageRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMessage=ruleMessage();

            state._fsp--;

             current =iv_ruleMessage; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMessage"


    // $ANTLR start "ruleMessage"
    // InternalMinotorDsl.g:1548:1: ruleMessage returns [EObject current=null] : (otherlv_0= 'message' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_params_3_0= ruleParams ) ) | ( (lv_constantparams_4_0= ruleConstantParams ) ) ) otherlv_5= ')' ( (lv_required_6_0= 'required' ) )? ( (lv_fail_7_0= 'fail' ) )? ( (lv_strict_8_0= 'strict' ) )? ( (otherlv_9= RULE_ID ) ) otherlv_10= '->' ( (otherlv_11= RULE_ID ) ) ( (lv_past_12_0= 'pastConstraint' ) )? ( (lv_future_13_0= 'futureConstraint' ) )? (otherlv_14= '{' ( (otherlv_15= RULE_ID ) )? (otherlv_16= ',' )? ( (lv_constraintexp_17_0= ruleClockConstraintExpression ) )? (otherlv_18= ',' )? ( (lv_resetinconstraint_19_0= ruleResetClock ) )? otherlv_20= '}' )? ( (lv_clockconstraint_21_0= 'clockConstraint' ) )? (otherlv_22= '{' )? ( (lv_cConstraint_23_0= ruleClockConstraintExpression ) )? (otherlv_24= '}' )? ( (lv_resetclock_25_0= ruleResetClock ) )? otherlv_26= ';' ) ;
    public final EObject ruleMessage() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        Token lv_required_6_0=null;
        Token lv_fail_7_0=null;
        Token lv_strict_8_0=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token lv_past_12_0=null;
        Token lv_future_13_0=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        Token otherlv_18=null;
        Token otherlv_20=null;
        Token lv_clockconstraint_21_0=null;
        Token otherlv_22=null;
        Token otherlv_24=null;
        Token otherlv_26=null;
        EObject lv_params_3_0 = null;

        EObject lv_constantparams_4_0 = null;

        EObject lv_constraintexp_17_0 = null;

        EObject lv_resetinconstraint_19_0 = null;

        EObject lv_cConstraint_23_0 = null;

        EObject lv_resetclock_25_0 = null;



        	enterRule();

        try {
            // InternalMinotorDsl.g:1554:2: ( (otherlv_0= 'message' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_params_3_0= ruleParams ) ) | ( (lv_constantparams_4_0= ruleConstantParams ) ) ) otherlv_5= ')' ( (lv_required_6_0= 'required' ) )? ( (lv_fail_7_0= 'fail' ) )? ( (lv_strict_8_0= 'strict' ) )? ( (otherlv_9= RULE_ID ) ) otherlv_10= '->' ( (otherlv_11= RULE_ID ) ) ( (lv_past_12_0= 'pastConstraint' ) )? ( (lv_future_13_0= 'futureConstraint' ) )? (otherlv_14= '{' ( (otherlv_15= RULE_ID ) )? (otherlv_16= ',' )? ( (lv_constraintexp_17_0= ruleClockConstraintExpression ) )? (otherlv_18= ',' )? ( (lv_resetinconstraint_19_0= ruleResetClock ) )? otherlv_20= '}' )? ( (lv_clockconstraint_21_0= 'clockConstraint' ) )? (otherlv_22= '{' )? ( (lv_cConstraint_23_0= ruleClockConstraintExpression ) )? (otherlv_24= '}' )? ( (lv_resetclock_25_0= ruleResetClock ) )? otherlv_26= ';' ) )
            // InternalMinotorDsl.g:1555:2: (otherlv_0= 'message' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_params_3_0= ruleParams ) ) | ( (lv_constantparams_4_0= ruleConstantParams ) ) ) otherlv_5= ')' ( (lv_required_6_0= 'required' ) )? ( (lv_fail_7_0= 'fail' ) )? ( (lv_strict_8_0= 'strict' ) )? ( (otherlv_9= RULE_ID ) ) otherlv_10= '->' ( (otherlv_11= RULE_ID ) ) ( (lv_past_12_0= 'pastConstraint' ) )? ( (lv_future_13_0= 'futureConstraint' ) )? (otherlv_14= '{' ( (otherlv_15= RULE_ID ) )? (otherlv_16= ',' )? ( (lv_constraintexp_17_0= ruleClockConstraintExpression ) )? (otherlv_18= ',' )? ( (lv_resetinconstraint_19_0= ruleResetClock ) )? otherlv_20= '}' )? ( (lv_clockconstraint_21_0= 'clockConstraint' ) )? (otherlv_22= '{' )? ( (lv_cConstraint_23_0= ruleClockConstraintExpression ) )? (otherlv_24= '}' )? ( (lv_resetclock_25_0= ruleResetClock ) )? otherlv_26= ';' )
            {
            // InternalMinotorDsl.g:1555:2: (otherlv_0= 'message' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_params_3_0= ruleParams ) ) | ( (lv_constantparams_4_0= ruleConstantParams ) ) ) otherlv_5= ')' ( (lv_required_6_0= 'required' ) )? ( (lv_fail_7_0= 'fail' ) )? ( (lv_strict_8_0= 'strict' ) )? ( (otherlv_9= RULE_ID ) ) otherlv_10= '->' ( (otherlv_11= RULE_ID ) ) ( (lv_past_12_0= 'pastConstraint' ) )? ( (lv_future_13_0= 'futureConstraint' ) )? (otherlv_14= '{' ( (otherlv_15= RULE_ID ) )? (otherlv_16= ',' )? ( (lv_constraintexp_17_0= ruleClockConstraintExpression ) )? (otherlv_18= ',' )? ( (lv_resetinconstraint_19_0= ruleResetClock ) )? otherlv_20= '}' )? ( (lv_clockconstraint_21_0= 'clockConstraint' ) )? (otherlv_22= '{' )? ( (lv_cConstraint_23_0= ruleClockConstraintExpression ) )? (otherlv_24= '}' )? ( (lv_resetclock_25_0= ruleResetClock ) )? otherlv_26= ';' )
            // InternalMinotorDsl.g:1556:3: otherlv_0= 'message' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_params_3_0= ruleParams ) ) | ( (lv_constantparams_4_0= ruleConstantParams ) ) ) otherlv_5= ')' ( (lv_required_6_0= 'required' ) )? ( (lv_fail_7_0= 'fail' ) )? ( (lv_strict_8_0= 'strict' ) )? ( (otherlv_9= RULE_ID ) ) otherlv_10= '->' ( (otherlv_11= RULE_ID ) ) ( (lv_past_12_0= 'pastConstraint' ) )? ( (lv_future_13_0= 'futureConstraint' ) )? (otherlv_14= '{' ( (otherlv_15= RULE_ID ) )? (otherlv_16= ',' )? ( (lv_constraintexp_17_0= ruleClockConstraintExpression ) )? (otherlv_18= ',' )? ( (lv_resetinconstraint_19_0= ruleResetClock ) )? otherlv_20= '}' )? ( (lv_clockconstraint_21_0= 'clockConstraint' ) )? (otherlv_22= '{' )? ( (lv_cConstraint_23_0= ruleClockConstraintExpression ) )? (otherlv_24= '}' )? ( (lv_resetclock_25_0= ruleResetClock ) )? otherlv_26= ';'
            {
            otherlv_0=(Token)match(input,44,FOLLOW_13); 

            			newLeafNode(otherlv_0, grammarAccess.getMessageAccess().getMessageKeyword_0());
            		
            // InternalMinotorDsl.g:1560:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMinotorDsl.g:1561:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMinotorDsl.g:1561:4: (lv_name_1_0= RULE_ID )
            // InternalMinotorDsl.g:1562:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_37); 

            					newLeafNode(lv_name_1_0, grammarAccess.getMessageAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getMessageRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,39,FOLLOW_41); 

            			newLeafNode(otherlv_2, grammarAccess.getMessageAccess().getLeftParenthesisKeyword_2());
            		
            // InternalMinotorDsl.g:1582:3: ( ( (lv_params_3_0= ruleParams ) ) | ( (lv_constantparams_4_0= ruleConstantParams ) ) )
            int alt40=2;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt40=1;
                }
                break;
            case 40:
                {
                int LA40_2 = input.LA(2);

                if ( (LA40_2==RULE_ID) ) {
                    alt40=1;
                }
                else if ( ((LA40_2>=RULE_STRING && LA40_2<=RULE_NUMBER)||(LA40_2>=27 && LA40_2<=28)) ) {
                    alt40=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 40, 2, input);

                    throw nvae;
                }
                }
                break;
            case 41:
                {
                alt40=1;
                }
                break;
            case RULE_STRING:
            case RULE_REAL:
            case RULE_NUMBER:
            case 27:
            case 28:
                {
                alt40=2;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;
            }

            switch (alt40) {
                case 1 :
                    // InternalMinotorDsl.g:1583:4: ( (lv_params_3_0= ruleParams ) )
                    {
                    // InternalMinotorDsl.g:1583:4: ( (lv_params_3_0= ruleParams ) )
                    // InternalMinotorDsl.g:1584:5: (lv_params_3_0= ruleParams )
                    {
                    // InternalMinotorDsl.g:1584:5: (lv_params_3_0= ruleParams )
                    // InternalMinotorDsl.g:1585:6: lv_params_3_0= ruleParams
                    {

                    						newCompositeNode(grammarAccess.getMessageAccess().getParamsParamsParserRuleCall_3_0_0());
                    					
                    pushFollow(FOLLOW_39);
                    lv_params_3_0=ruleParams();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getMessageRule());
                    						}
                    						add(
                    							current,
                    							"params",
                    							lv_params_3_0,
                    							"hu.bme.mit.dipterv.text.MinotorDsl.Params");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalMinotorDsl.g:1603:4: ( (lv_constantparams_4_0= ruleConstantParams ) )
                    {
                    // InternalMinotorDsl.g:1603:4: ( (lv_constantparams_4_0= ruleConstantParams ) )
                    // InternalMinotorDsl.g:1604:5: (lv_constantparams_4_0= ruleConstantParams )
                    {
                    // InternalMinotorDsl.g:1604:5: (lv_constantparams_4_0= ruleConstantParams )
                    // InternalMinotorDsl.g:1605:6: lv_constantparams_4_0= ruleConstantParams
                    {

                    						newCompositeNode(grammarAccess.getMessageAccess().getConstantparamsConstantParamsParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_39);
                    lv_constantparams_4_0=ruleConstantParams();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getMessageRule());
                    						}
                    						add(
                    							current,
                    							"constantparams",
                    							lv_constantparams_4_0,
                    							"hu.bme.mit.dipterv.text.MinotorDsl.ConstantParams");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,41,FOLLOW_42); 

            			newLeafNode(otherlv_5, grammarAccess.getMessageAccess().getRightParenthesisKeyword_4());
            		
            // InternalMinotorDsl.g:1627:3: ( (lv_required_6_0= 'required' ) )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==45) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // InternalMinotorDsl.g:1628:4: (lv_required_6_0= 'required' )
                    {
                    // InternalMinotorDsl.g:1628:4: (lv_required_6_0= 'required' )
                    // InternalMinotorDsl.g:1629:5: lv_required_6_0= 'required'
                    {
                    lv_required_6_0=(Token)match(input,45,FOLLOW_43); 

                    					newLeafNode(lv_required_6_0, grammarAccess.getMessageAccess().getRequiredRequiredKeyword_5_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getMessageRule());
                    					}
                    					setWithLastConsumed(current, "required", lv_required_6_0 != null, "required");
                    				

                    }


                    }
                    break;

            }

            // InternalMinotorDsl.g:1641:3: ( (lv_fail_7_0= 'fail' ) )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==46) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // InternalMinotorDsl.g:1642:4: (lv_fail_7_0= 'fail' )
                    {
                    // InternalMinotorDsl.g:1642:4: (lv_fail_7_0= 'fail' )
                    // InternalMinotorDsl.g:1643:5: lv_fail_7_0= 'fail'
                    {
                    lv_fail_7_0=(Token)match(input,46,FOLLOW_44); 

                    					newLeafNode(lv_fail_7_0, grammarAccess.getMessageAccess().getFailFailKeyword_6_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getMessageRule());
                    					}
                    					setWithLastConsumed(current, "fail", lv_fail_7_0 != null, "fail");
                    				

                    }


                    }
                    break;

            }

            // InternalMinotorDsl.g:1655:3: ( (lv_strict_8_0= 'strict' ) )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==47) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // InternalMinotorDsl.g:1656:4: (lv_strict_8_0= 'strict' )
                    {
                    // InternalMinotorDsl.g:1656:4: (lv_strict_8_0= 'strict' )
                    // InternalMinotorDsl.g:1657:5: lv_strict_8_0= 'strict'
                    {
                    lv_strict_8_0=(Token)match(input,47,FOLLOW_13); 

                    					newLeafNode(lv_strict_8_0, grammarAccess.getMessageAccess().getStrictStrictKeyword_7_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getMessageRule());
                    					}
                    					setWithLastConsumed(current, "strict", lv_strict_8_0 != null, "strict");
                    				

                    }


                    }
                    break;

            }

            // InternalMinotorDsl.g:1669:3: ( (otherlv_9= RULE_ID ) )
            // InternalMinotorDsl.g:1670:4: (otherlv_9= RULE_ID )
            {
            // InternalMinotorDsl.g:1670:4: (otherlv_9= RULE_ID )
            // InternalMinotorDsl.g:1671:5: otherlv_9= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getMessageRule());
            					}
            				
            otherlv_9=(Token)match(input,RULE_ID,FOLLOW_45); 

            					newLeafNode(otherlv_9, grammarAccess.getMessageAccess().getSenderObjectCrossReference_8_0());
            				

            }


            }

            otherlv_10=(Token)match(input,48,FOLLOW_13); 

            			newLeafNode(otherlv_10, grammarAccess.getMessageAccess().getHyphenMinusGreaterThanSignKeyword_9());
            		
            // InternalMinotorDsl.g:1686:3: ( (otherlv_11= RULE_ID ) )
            // InternalMinotorDsl.g:1687:4: (otherlv_11= RULE_ID )
            {
            // InternalMinotorDsl.g:1687:4: (otherlv_11= RULE_ID )
            // InternalMinotorDsl.g:1688:5: otherlv_11= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getMessageRule());
            					}
            				
            otherlv_11=(Token)match(input,RULE_ID,FOLLOW_46); 

            					newLeafNode(otherlv_11, grammarAccess.getMessageAccess().getReceiverObjectCrossReference_10_0());
            				

            }


            }

            // InternalMinotorDsl.g:1699:3: ( (lv_past_12_0= 'pastConstraint' ) )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==49) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // InternalMinotorDsl.g:1700:4: (lv_past_12_0= 'pastConstraint' )
                    {
                    // InternalMinotorDsl.g:1700:4: (lv_past_12_0= 'pastConstraint' )
                    // InternalMinotorDsl.g:1701:5: lv_past_12_0= 'pastConstraint'
                    {
                    lv_past_12_0=(Token)match(input,49,FOLLOW_47); 

                    					newLeafNode(lv_past_12_0, grammarAccess.getMessageAccess().getPastPastConstraintKeyword_11_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getMessageRule());
                    					}
                    					setWithLastConsumed(current, "past", lv_past_12_0 != null, "pastConstraint");
                    				

                    }


                    }
                    break;

            }

            // InternalMinotorDsl.g:1713:3: ( (lv_future_13_0= 'futureConstraint' ) )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==50) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // InternalMinotorDsl.g:1714:4: (lv_future_13_0= 'futureConstraint' )
                    {
                    // InternalMinotorDsl.g:1714:4: (lv_future_13_0= 'futureConstraint' )
                    // InternalMinotorDsl.g:1715:5: lv_future_13_0= 'futureConstraint'
                    {
                    lv_future_13_0=(Token)match(input,50,FOLLOW_48); 

                    					newLeafNode(lv_future_13_0, grammarAccess.getMessageAccess().getFutureFutureConstraintKeyword_12_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getMessageRule());
                    					}
                    					setWithLastConsumed(current, "future", lv_future_13_0 != null, "futureConstraint");
                    				

                    }


                    }
                    break;

            }

            // InternalMinotorDsl.g:1727:3: (otherlv_14= '{' ( (otherlv_15= RULE_ID ) )? (otherlv_16= ',' )? ( (lv_constraintexp_17_0= ruleClockConstraintExpression ) )? (otherlv_18= ',' )? ( (lv_resetinconstraint_19_0= ruleResetClock ) )? otherlv_20= '}' )?
            int alt51=2;
            alt51 = dfa51.predict(input);
            switch (alt51) {
                case 1 :
                    // InternalMinotorDsl.g:1728:4: otherlv_14= '{' ( (otherlv_15= RULE_ID ) )? (otherlv_16= ',' )? ( (lv_constraintexp_17_0= ruleClockConstraintExpression ) )? (otherlv_18= ',' )? ( (lv_resetinconstraint_19_0= ruleResetClock ) )? otherlv_20= '}'
                    {
                    otherlv_14=(Token)match(input,14,FOLLOW_49); 

                    				newLeafNode(otherlv_14, grammarAccess.getMessageAccess().getLeftCurlyBracketKeyword_13_0());
                    			
                    // InternalMinotorDsl.g:1732:4: ( (otherlv_15= RULE_ID ) )?
                    int alt46=2;
                    int LA46_0 = input.LA(1);

                    if ( (LA46_0==RULE_ID) ) {
                        int LA46_1 = input.LA(2);

                        if ( (LA46_1==RULE_ID||LA46_1==15||(LA46_1>=39 && LA46_1<=40)||(LA46_1>=52 && LA46_1<=53)) ) {
                            alt46=1;
                        }
                    }
                    switch (alt46) {
                        case 1 :
                            // InternalMinotorDsl.g:1733:5: (otherlv_15= RULE_ID )
                            {
                            // InternalMinotorDsl.g:1733:5: (otherlv_15= RULE_ID )
                            // InternalMinotorDsl.g:1734:6: otherlv_15= RULE_ID
                            {

                            						if (current==null) {
                            							current = createModelElement(grammarAccess.getMessageRule());
                            						}
                            					
                            otherlv_15=(Token)match(input,RULE_ID,FOLLOW_49); 

                            						newLeafNode(otherlv_15, grammarAccess.getMessageAccess().getCConstraintCrossReference_13_1_0());
                            					

                            }


                            }
                            break;

                    }

                    // InternalMinotorDsl.g:1745:4: (otherlv_16= ',' )?
                    int alt47=2;
                    int LA47_0 = input.LA(1);

                    if ( (LA47_0==40) ) {
                        alt47=1;
                    }
                    switch (alt47) {
                        case 1 :
                            // InternalMinotorDsl.g:1746:5: otherlv_16= ','
                            {
                            otherlv_16=(Token)match(input,40,FOLLOW_49); 

                            					newLeafNode(otherlv_16, grammarAccess.getMessageAccess().getCommaKeyword_13_2());
                            				

                            }
                            break;

                    }

                    // InternalMinotorDsl.g:1751:4: ( (lv_constraintexp_17_0= ruleClockConstraintExpression ) )?
                    int alt48=2;
                    int LA48_0 = input.LA(1);

                    if ( (LA48_0==RULE_ID||LA48_0==39||LA48_0==53) ) {
                        alt48=1;
                    }
                    switch (alt48) {
                        case 1 :
                            // InternalMinotorDsl.g:1752:5: (lv_constraintexp_17_0= ruleClockConstraintExpression )
                            {
                            // InternalMinotorDsl.g:1752:5: (lv_constraintexp_17_0= ruleClockConstraintExpression )
                            // InternalMinotorDsl.g:1753:6: lv_constraintexp_17_0= ruleClockConstraintExpression
                            {

                            						newCompositeNode(grammarAccess.getMessageAccess().getConstraintexpClockConstraintExpressionParserRuleCall_13_3_0());
                            					
                            pushFollow(FOLLOW_50);
                            lv_constraintexp_17_0=ruleClockConstraintExpression();

                            state._fsp--;


                            						if (current==null) {
                            							current = createModelElementForParent(grammarAccess.getMessageRule());
                            						}
                            						set(
                            							current,
                            							"constraintexp",
                            							lv_constraintexp_17_0,
                            							"hu.bme.mit.dipterv.text.MinotorDsl.ClockConstraintExpression");
                            						afterParserOrEnumRuleCall();
                            					

                            }


                            }
                            break;

                    }

                    // InternalMinotorDsl.g:1770:4: (otherlv_18= ',' )?
                    int alt49=2;
                    int LA49_0 = input.LA(1);

                    if ( (LA49_0==40) ) {
                        alt49=1;
                    }
                    switch (alt49) {
                        case 1 :
                            // InternalMinotorDsl.g:1771:5: otherlv_18= ','
                            {
                            otherlv_18=(Token)match(input,40,FOLLOW_51); 

                            					newLeafNode(otherlv_18, grammarAccess.getMessageAccess().getCommaKeyword_13_4());
                            				

                            }
                            break;

                    }

                    // InternalMinotorDsl.g:1776:4: ( (lv_resetinconstraint_19_0= ruleResetClock ) )?
                    int alt50=2;
                    int LA50_0 = input.LA(1);

                    if ( (LA50_0==52) ) {
                        alt50=1;
                    }
                    switch (alt50) {
                        case 1 :
                            // InternalMinotorDsl.g:1777:5: (lv_resetinconstraint_19_0= ruleResetClock )
                            {
                            // InternalMinotorDsl.g:1777:5: (lv_resetinconstraint_19_0= ruleResetClock )
                            // InternalMinotorDsl.g:1778:6: lv_resetinconstraint_19_0= ruleResetClock
                            {

                            						newCompositeNode(grammarAccess.getMessageAccess().getResetinconstraintResetClockParserRuleCall_13_5_0());
                            					
                            pushFollow(FOLLOW_52);
                            lv_resetinconstraint_19_0=ruleResetClock();

                            state._fsp--;


                            						if (current==null) {
                            							current = createModelElementForParent(grammarAccess.getMessageRule());
                            						}
                            						set(
                            							current,
                            							"resetinconstraint",
                            							lv_resetinconstraint_19_0,
                            							"hu.bme.mit.dipterv.text.MinotorDsl.ResetClock");
                            						afterParserOrEnumRuleCall();
                            					

                            }


                            }
                            break;

                    }

                    otherlv_20=(Token)match(input,15,FOLLOW_48); 

                    				newLeafNode(otherlv_20, grammarAccess.getMessageAccess().getRightCurlyBracketKeyword_13_6());
                    			

                    }
                    break;

            }

            // InternalMinotorDsl.g:1800:3: ( (lv_clockconstraint_21_0= 'clockConstraint' ) )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==51) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // InternalMinotorDsl.g:1801:4: (lv_clockconstraint_21_0= 'clockConstraint' )
                    {
                    // InternalMinotorDsl.g:1801:4: (lv_clockconstraint_21_0= 'clockConstraint' )
                    // InternalMinotorDsl.g:1802:5: lv_clockconstraint_21_0= 'clockConstraint'
                    {
                    lv_clockconstraint_21_0=(Token)match(input,51,FOLLOW_53); 

                    					newLeafNode(lv_clockconstraint_21_0, grammarAccess.getMessageAccess().getClockconstraintClockConstraintKeyword_14_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getMessageRule());
                    					}
                    					setWithLastConsumed(current, "clockconstraint", lv_clockconstraint_21_0 != null, "clockConstraint");
                    				

                    }


                    }
                    break;

            }

            // InternalMinotorDsl.g:1814:3: (otherlv_22= '{' )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==14) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // InternalMinotorDsl.g:1815:4: otherlv_22= '{'
                    {
                    otherlv_22=(Token)match(input,14,FOLLOW_54); 

                    				newLeafNode(otherlv_22, grammarAccess.getMessageAccess().getLeftCurlyBracketKeyword_15());
                    			

                    }
                    break;

            }

            // InternalMinotorDsl.g:1820:3: ( (lv_cConstraint_23_0= ruleClockConstraintExpression ) )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==RULE_ID||LA54_0==39||LA54_0==53) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // InternalMinotorDsl.g:1821:4: (lv_cConstraint_23_0= ruleClockConstraintExpression )
                    {
                    // InternalMinotorDsl.g:1821:4: (lv_cConstraint_23_0= ruleClockConstraintExpression )
                    // InternalMinotorDsl.g:1822:5: lv_cConstraint_23_0= ruleClockConstraintExpression
                    {

                    					newCompositeNode(grammarAccess.getMessageAccess().getCConstraintClockConstraintExpressionParserRuleCall_16_0());
                    				
                    pushFollow(FOLLOW_55);
                    lv_cConstraint_23_0=ruleClockConstraintExpression();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getMessageRule());
                    					}
                    					set(
                    						current,
                    						"cConstraint",
                    						lv_cConstraint_23_0,
                    						"hu.bme.mit.dipterv.text.MinotorDsl.ClockConstraintExpression");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalMinotorDsl.g:1839:3: (otherlv_24= '}' )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==15) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // InternalMinotorDsl.g:1840:4: otherlv_24= '}'
                    {
                    otherlv_24=(Token)match(input,15,FOLLOW_56); 

                    				newLeafNode(otherlv_24, grammarAccess.getMessageAccess().getRightCurlyBracketKeyword_17());
                    			

                    }
                    break;

            }

            // InternalMinotorDsl.g:1845:3: ( (lv_resetclock_25_0= ruleResetClock ) )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==52) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // InternalMinotorDsl.g:1846:4: (lv_resetclock_25_0= ruleResetClock )
                    {
                    // InternalMinotorDsl.g:1846:4: (lv_resetclock_25_0= ruleResetClock )
                    // InternalMinotorDsl.g:1847:5: lv_resetclock_25_0= ruleResetClock
                    {

                    					newCompositeNode(grammarAccess.getMessageAccess().getResetclockResetClockParserRuleCall_18_0());
                    				
                    pushFollow(FOLLOW_27);
                    lv_resetclock_25_0=ruleResetClock();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getMessageRule());
                    					}
                    					set(
                    						current,
                    						"resetclock",
                    						lv_resetclock_25_0,
                    						"hu.bme.mit.dipterv.text.MinotorDsl.ResetClock");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            otherlv_26=(Token)match(input,26,FOLLOW_2); 

            			newLeafNode(otherlv_26, grammarAccess.getMessageAccess().getSemicolonKeyword_19());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMessage"


    // $ANTLR start "entryRuleResetClock"
    // InternalMinotorDsl.g:1872:1: entryRuleResetClock returns [EObject current=null] : iv_ruleResetClock= ruleResetClock EOF ;
    public final EObject entryRuleResetClock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleResetClock = null;


        try {
            // InternalMinotorDsl.g:1872:51: (iv_ruleResetClock= ruleResetClock EOF )
            // InternalMinotorDsl.g:1873:2: iv_ruleResetClock= ruleResetClock EOF
            {
             newCompositeNode(grammarAccess.getResetClockRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleResetClock=ruleResetClock();

            state._fsp--;

             current =iv_ruleResetClock; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleResetClock"


    // $ANTLR start "ruleResetClock"
    // InternalMinotorDsl.g:1879:1: ruleResetClock returns [EObject current=null] : (otherlv_0= 'reset' ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleResetClock() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalMinotorDsl.g:1885:2: ( (otherlv_0= 'reset' ( (otherlv_1= RULE_ID ) ) ) )
            // InternalMinotorDsl.g:1886:2: (otherlv_0= 'reset' ( (otherlv_1= RULE_ID ) ) )
            {
            // InternalMinotorDsl.g:1886:2: (otherlv_0= 'reset' ( (otherlv_1= RULE_ID ) ) )
            // InternalMinotorDsl.g:1887:3: otherlv_0= 'reset' ( (otherlv_1= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,52,FOLLOW_13); 

            			newLeafNode(otherlv_0, grammarAccess.getResetClockAccess().getResetKeyword_0());
            		
            // InternalMinotorDsl.g:1891:3: ( (otherlv_1= RULE_ID ) )
            // InternalMinotorDsl.g:1892:4: (otherlv_1= RULE_ID )
            {
            // InternalMinotorDsl.g:1892:4: (otherlv_1= RULE_ID )
            // InternalMinotorDsl.g:1893:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getResetClockRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(otherlv_1, grammarAccess.getResetClockAccess().getClockClockCrossReference_1_0());
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleResetClock"


    // $ANTLR start "entryRuleClockConstraint"
    // InternalMinotorDsl.g:1908:1: entryRuleClockConstraint returns [EObject current=null] : iv_ruleClockConstraint= ruleClockConstraint EOF ;
    public final EObject entryRuleClockConstraint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClockConstraint = null;


        try {
            // InternalMinotorDsl.g:1908:56: (iv_ruleClockConstraint= ruleClockConstraint EOF )
            // InternalMinotorDsl.g:1909:2: iv_ruleClockConstraint= ruleClockConstraint EOF
            {
             newCompositeNode(grammarAccess.getClockConstraintRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleClockConstraint=ruleClockConstraint();

            state._fsp--;

             current =iv_ruleClockConstraint; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleClockConstraint"


    // $ANTLR start "ruleClockConstraint"
    // InternalMinotorDsl.g:1915:1: ruleClockConstraint returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) ( (lv_op_1_0= ruleOperator ) ) ( (lv_constant_2_0= RULE_NUMBER ) ) ) ;
    public final EObject ruleClockConstraint() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_constant_2_0=null;
        EObject lv_op_1_0 = null;



        	enterRule();

        try {
            // InternalMinotorDsl.g:1921:2: ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_op_1_0= ruleOperator ) ) ( (lv_constant_2_0= RULE_NUMBER ) ) ) )
            // InternalMinotorDsl.g:1922:2: ( ( (otherlv_0= RULE_ID ) ) ( (lv_op_1_0= ruleOperator ) ) ( (lv_constant_2_0= RULE_NUMBER ) ) )
            {
            // InternalMinotorDsl.g:1922:2: ( ( (otherlv_0= RULE_ID ) ) ( (lv_op_1_0= ruleOperator ) ) ( (lv_constant_2_0= RULE_NUMBER ) ) )
            // InternalMinotorDsl.g:1923:3: ( (otherlv_0= RULE_ID ) ) ( (lv_op_1_0= ruleOperator ) ) ( (lv_constant_2_0= RULE_NUMBER ) )
            {
            // InternalMinotorDsl.g:1923:3: ( (otherlv_0= RULE_ID ) )
            // InternalMinotorDsl.g:1924:4: (otherlv_0= RULE_ID )
            {
            // InternalMinotorDsl.g:1924:4: (otherlv_0= RULE_ID )
            // InternalMinotorDsl.g:1925:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getClockConstraintRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_57); 

            					newLeafNode(otherlv_0, grammarAccess.getClockConstraintAccess().getClockClockCrossReference_0_0());
            				

            }


            }

            // InternalMinotorDsl.g:1936:3: ( (lv_op_1_0= ruleOperator ) )
            // InternalMinotorDsl.g:1937:4: (lv_op_1_0= ruleOperator )
            {
            // InternalMinotorDsl.g:1937:4: (lv_op_1_0= ruleOperator )
            // InternalMinotorDsl.g:1938:5: lv_op_1_0= ruleOperator
            {

            					newCompositeNode(grammarAccess.getClockConstraintAccess().getOpOperatorParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_58);
            lv_op_1_0=ruleOperator();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getClockConstraintRule());
            					}
            					set(
            						current,
            						"op",
            						lv_op_1_0,
            						"hu.bme.mit.dipterv.text.MinotorDsl.Operator");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMinotorDsl.g:1955:3: ( (lv_constant_2_0= RULE_NUMBER ) )
            // InternalMinotorDsl.g:1956:4: (lv_constant_2_0= RULE_NUMBER )
            {
            // InternalMinotorDsl.g:1956:4: (lv_constant_2_0= RULE_NUMBER )
            // InternalMinotorDsl.g:1957:5: lv_constant_2_0= RULE_NUMBER
            {
            lv_constant_2_0=(Token)match(input,RULE_NUMBER,FOLLOW_2); 

            					newLeafNode(lv_constant_2_0, grammarAccess.getClockConstraintAccess().getConstantNUMBERTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getClockConstraintRule());
            					}
            					setWithLastConsumed(
            						current,
            						"constant",
            						lv_constant_2_0,
            						"hu.bme.mit.dipterv.text.MinotorDsl.NUMBER");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleClockConstraint"


    // $ANTLR start "entryRuleClockConstraintExpression"
    // InternalMinotorDsl.g:1977:1: entryRuleClockConstraintExpression returns [EObject current=null] : iv_ruleClockConstraintExpression= ruleClockConstraintExpression EOF ;
    public final EObject entryRuleClockConstraintExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClockConstraintExpression = null;


        try {
            // InternalMinotorDsl.g:1977:66: (iv_ruleClockConstraintExpression= ruleClockConstraintExpression EOF )
            // InternalMinotorDsl.g:1978:2: iv_ruleClockConstraintExpression= ruleClockConstraintExpression EOF
            {
             newCompositeNode(grammarAccess.getClockConstraintExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleClockConstraintExpression=ruleClockConstraintExpression();

            state._fsp--;

             current =iv_ruleClockConstraintExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleClockConstraintExpression"


    // $ANTLR start "ruleClockConstraintExpression"
    // InternalMinotorDsl.g:1984:1: ruleClockConstraintExpression returns [EObject current=null] : ( ( ( (lv_not_0_0= 'not' ) )? (otherlv_1= '(' )? ( (lv_lclockconstraint_2_0= ruleClockConstraint ) ) (otherlv_3= ')' )? ) | ( ( (lv_lclockconstraint_4_0= ruleClockConstraint ) ) otherlv_5= 'and' ( (lv_rclockconstraint_6_0= ruleClockConstraint ) ) ) ) ;
    public final EObject ruleClockConstraintExpression() throws RecognitionException {
        EObject current = null;

        Token lv_not_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_lclockconstraint_2_0 = null;

        EObject lv_lclockconstraint_4_0 = null;

        EObject lv_rclockconstraint_6_0 = null;



        	enterRule();

        try {
            // InternalMinotorDsl.g:1990:2: ( ( ( ( (lv_not_0_0= 'not' ) )? (otherlv_1= '(' )? ( (lv_lclockconstraint_2_0= ruleClockConstraint ) ) (otherlv_3= ')' )? ) | ( ( (lv_lclockconstraint_4_0= ruleClockConstraint ) ) otherlv_5= 'and' ( (lv_rclockconstraint_6_0= ruleClockConstraint ) ) ) ) )
            // InternalMinotorDsl.g:1991:2: ( ( ( (lv_not_0_0= 'not' ) )? (otherlv_1= '(' )? ( (lv_lclockconstraint_2_0= ruleClockConstraint ) ) (otherlv_3= ')' )? ) | ( ( (lv_lclockconstraint_4_0= ruleClockConstraint ) ) otherlv_5= 'and' ( (lv_rclockconstraint_6_0= ruleClockConstraint ) ) ) )
            {
            // InternalMinotorDsl.g:1991:2: ( ( ( (lv_not_0_0= 'not' ) )? (otherlv_1= '(' )? ( (lv_lclockconstraint_2_0= ruleClockConstraint ) ) (otherlv_3= ')' )? ) | ( ( (lv_lclockconstraint_4_0= ruleClockConstraint ) ) otherlv_5= 'and' ( (lv_rclockconstraint_6_0= ruleClockConstraint ) ) ) )
            int alt60=2;
            alt60 = dfa60.predict(input);
            switch (alt60) {
                case 1 :
                    // InternalMinotorDsl.g:1992:3: ( ( (lv_not_0_0= 'not' ) )? (otherlv_1= '(' )? ( (lv_lclockconstraint_2_0= ruleClockConstraint ) ) (otherlv_3= ')' )? )
                    {
                    // InternalMinotorDsl.g:1992:3: ( ( (lv_not_0_0= 'not' ) )? (otherlv_1= '(' )? ( (lv_lclockconstraint_2_0= ruleClockConstraint ) ) (otherlv_3= ')' )? )
                    // InternalMinotorDsl.g:1993:4: ( (lv_not_0_0= 'not' ) )? (otherlv_1= '(' )? ( (lv_lclockconstraint_2_0= ruleClockConstraint ) ) (otherlv_3= ')' )?
                    {
                    // InternalMinotorDsl.g:1993:4: ( (lv_not_0_0= 'not' ) )?
                    int alt57=2;
                    int LA57_0 = input.LA(1);

                    if ( (LA57_0==53) ) {
                        alt57=1;
                    }
                    switch (alt57) {
                        case 1 :
                            // InternalMinotorDsl.g:1994:5: (lv_not_0_0= 'not' )
                            {
                            // InternalMinotorDsl.g:1994:5: (lv_not_0_0= 'not' )
                            // InternalMinotorDsl.g:1995:6: lv_not_0_0= 'not'
                            {
                            lv_not_0_0=(Token)match(input,53,FOLLOW_59); 

                            						newLeafNode(lv_not_0_0, grammarAccess.getClockConstraintExpressionAccess().getNotNotKeyword_0_0_0());
                            					

                            						if (current==null) {
                            							current = createModelElement(grammarAccess.getClockConstraintExpressionRule());
                            						}
                            						setWithLastConsumed(current, "not", lv_not_0_0 != null, "not");
                            					

                            }


                            }
                            break;

                    }

                    // InternalMinotorDsl.g:2007:4: (otherlv_1= '(' )?
                    int alt58=2;
                    int LA58_0 = input.LA(1);

                    if ( (LA58_0==39) ) {
                        alt58=1;
                    }
                    switch (alt58) {
                        case 1 :
                            // InternalMinotorDsl.g:2008:5: otherlv_1= '('
                            {
                            otherlv_1=(Token)match(input,39,FOLLOW_59); 

                            					newLeafNode(otherlv_1, grammarAccess.getClockConstraintExpressionAccess().getLeftParenthesisKeyword_0_1());
                            				

                            }
                            break;

                    }

                    // InternalMinotorDsl.g:2013:4: ( (lv_lclockconstraint_2_0= ruleClockConstraint ) )
                    // InternalMinotorDsl.g:2014:5: (lv_lclockconstraint_2_0= ruleClockConstraint )
                    {
                    // InternalMinotorDsl.g:2014:5: (lv_lclockconstraint_2_0= ruleClockConstraint )
                    // InternalMinotorDsl.g:2015:6: lv_lclockconstraint_2_0= ruleClockConstraint
                    {

                    						newCompositeNode(grammarAccess.getClockConstraintExpressionAccess().getLclockconstraintClockConstraintParserRuleCall_0_2_0());
                    					
                    pushFollow(FOLLOW_60);
                    lv_lclockconstraint_2_0=ruleClockConstraint();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getClockConstraintExpressionRule());
                    						}
                    						set(
                    							current,
                    							"lclockconstraint",
                    							lv_lclockconstraint_2_0,
                    							"hu.bme.mit.dipterv.text.MinotorDsl.ClockConstraint");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalMinotorDsl.g:2032:4: (otherlv_3= ')' )?
                    int alt59=2;
                    int LA59_0 = input.LA(1);

                    if ( (LA59_0==41) ) {
                        alt59=1;
                    }
                    switch (alt59) {
                        case 1 :
                            // InternalMinotorDsl.g:2033:5: otherlv_3= ')'
                            {
                            otherlv_3=(Token)match(input,41,FOLLOW_2); 

                            					newLeafNode(otherlv_3, grammarAccess.getClockConstraintExpressionAccess().getRightParenthesisKeyword_0_3());
                            				

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalMinotorDsl.g:2040:3: ( ( (lv_lclockconstraint_4_0= ruleClockConstraint ) ) otherlv_5= 'and' ( (lv_rclockconstraint_6_0= ruleClockConstraint ) ) )
                    {
                    // InternalMinotorDsl.g:2040:3: ( ( (lv_lclockconstraint_4_0= ruleClockConstraint ) ) otherlv_5= 'and' ( (lv_rclockconstraint_6_0= ruleClockConstraint ) ) )
                    // InternalMinotorDsl.g:2041:4: ( (lv_lclockconstraint_4_0= ruleClockConstraint ) ) otherlv_5= 'and' ( (lv_rclockconstraint_6_0= ruleClockConstraint ) )
                    {
                    // InternalMinotorDsl.g:2041:4: ( (lv_lclockconstraint_4_0= ruleClockConstraint ) )
                    // InternalMinotorDsl.g:2042:5: (lv_lclockconstraint_4_0= ruleClockConstraint )
                    {
                    // InternalMinotorDsl.g:2042:5: (lv_lclockconstraint_4_0= ruleClockConstraint )
                    // InternalMinotorDsl.g:2043:6: lv_lclockconstraint_4_0= ruleClockConstraint
                    {

                    						newCompositeNode(grammarAccess.getClockConstraintExpressionAccess().getLclockconstraintClockConstraintParserRuleCall_1_0_0());
                    					
                    pushFollow(FOLLOW_61);
                    lv_lclockconstraint_4_0=ruleClockConstraint();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getClockConstraintExpressionRule());
                    						}
                    						set(
                    							current,
                    							"lclockconstraint",
                    							lv_lclockconstraint_4_0,
                    							"hu.bme.mit.dipterv.text.MinotorDsl.ClockConstraint");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_5=(Token)match(input,54,FOLLOW_59); 

                    				newLeafNode(otherlv_5, grammarAccess.getClockConstraintExpressionAccess().getAndKeyword_1_1());
                    			
                    // InternalMinotorDsl.g:2064:4: ( (lv_rclockconstraint_6_0= ruleClockConstraint ) )
                    // InternalMinotorDsl.g:2065:5: (lv_rclockconstraint_6_0= ruleClockConstraint )
                    {
                    // InternalMinotorDsl.g:2065:5: (lv_rclockconstraint_6_0= ruleClockConstraint )
                    // InternalMinotorDsl.g:2066:6: lv_rclockconstraint_6_0= ruleClockConstraint
                    {

                    						newCompositeNode(grammarAccess.getClockConstraintExpressionAccess().getRclockconstraintClockConstraintParserRuleCall_1_2_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_rclockconstraint_6_0=ruleClockConstraint();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getClockConstraintExpressionRule());
                    						}
                    						set(
                    							current,
                    							"rclockconstraint",
                    							lv_rclockconstraint_6_0,
                    							"hu.bme.mit.dipterv.text.MinotorDsl.ClockConstraint");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleClockConstraintExpression"


    // $ANTLR start "entryRuleContextMessage"
    // InternalMinotorDsl.g:2088:1: entryRuleContextMessage returns [EObject current=null] : iv_ruleContextMessage= ruleContextMessage EOF ;
    public final EObject entryRuleContextMessage() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContextMessage = null;


        try {
            // InternalMinotorDsl.g:2088:55: (iv_ruleContextMessage= ruleContextMessage EOF )
            // InternalMinotorDsl.g:2089:2: iv_ruleContextMessage= ruleContextMessage EOF
            {
             newCompositeNode(grammarAccess.getContextMessageRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleContextMessage=ruleContextMessage();

            state._fsp--;

             current =iv_ruleContextMessage; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleContextMessage"


    // $ANTLR start "ruleContextMessage"
    // InternalMinotorDsl.g:2095:1: ruleContextMessage returns [EObject current=null] : ( ( (lv_content_0_0= ruleContextMessageContent ) ) ( (lv_required_1_0= 'required' ) )? ( (lv_fail_2_0= 'fail' ) )? ( (lv_strict_3_0= 'strict' ) )? otherlv_4= ';' ) ;
    public final EObject ruleContextMessage() throws RecognitionException {
        EObject current = null;

        Token lv_required_1_0=null;
        Token lv_fail_2_0=null;
        Token lv_strict_3_0=null;
        Token otherlv_4=null;
        EObject lv_content_0_0 = null;



        	enterRule();

        try {
            // InternalMinotorDsl.g:2101:2: ( ( ( (lv_content_0_0= ruleContextMessageContent ) ) ( (lv_required_1_0= 'required' ) )? ( (lv_fail_2_0= 'fail' ) )? ( (lv_strict_3_0= 'strict' ) )? otherlv_4= ';' ) )
            // InternalMinotorDsl.g:2102:2: ( ( (lv_content_0_0= ruleContextMessageContent ) ) ( (lv_required_1_0= 'required' ) )? ( (lv_fail_2_0= 'fail' ) )? ( (lv_strict_3_0= 'strict' ) )? otherlv_4= ';' )
            {
            // InternalMinotorDsl.g:2102:2: ( ( (lv_content_0_0= ruleContextMessageContent ) ) ( (lv_required_1_0= 'required' ) )? ( (lv_fail_2_0= 'fail' ) )? ( (lv_strict_3_0= 'strict' ) )? otherlv_4= ';' )
            // InternalMinotorDsl.g:2103:3: ( (lv_content_0_0= ruleContextMessageContent ) ) ( (lv_required_1_0= 'required' ) )? ( (lv_fail_2_0= 'fail' ) )? ( (lv_strict_3_0= 'strict' ) )? otherlv_4= ';'
            {
            // InternalMinotorDsl.g:2103:3: ( (lv_content_0_0= ruleContextMessageContent ) )
            // InternalMinotorDsl.g:2104:4: (lv_content_0_0= ruleContextMessageContent )
            {
            // InternalMinotorDsl.g:2104:4: (lv_content_0_0= ruleContextMessageContent )
            // InternalMinotorDsl.g:2105:5: lv_content_0_0= ruleContextMessageContent
            {

            					newCompositeNode(grammarAccess.getContextMessageAccess().getContentContextMessageContentParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_62);
            lv_content_0_0=ruleContextMessageContent();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getContextMessageRule());
            					}
            					add(
            						current,
            						"content",
            						lv_content_0_0,
            						"hu.bme.mit.dipterv.text.MinotorDsl.ContextMessageContent");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMinotorDsl.g:2122:3: ( (lv_required_1_0= 'required' ) )?
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==45) ) {
                alt61=1;
            }
            switch (alt61) {
                case 1 :
                    // InternalMinotorDsl.g:2123:4: (lv_required_1_0= 'required' )
                    {
                    // InternalMinotorDsl.g:2123:4: (lv_required_1_0= 'required' )
                    // InternalMinotorDsl.g:2124:5: lv_required_1_0= 'required'
                    {
                    lv_required_1_0=(Token)match(input,45,FOLLOW_63); 

                    					newLeafNode(lv_required_1_0, grammarAccess.getContextMessageAccess().getRequiredRequiredKeyword_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getContextMessageRule());
                    					}
                    					setWithLastConsumed(current, "required", lv_required_1_0 != null, "required");
                    				

                    }


                    }
                    break;

            }

            // InternalMinotorDsl.g:2136:3: ( (lv_fail_2_0= 'fail' ) )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==46) ) {
                alt62=1;
            }
            switch (alt62) {
                case 1 :
                    // InternalMinotorDsl.g:2137:4: (lv_fail_2_0= 'fail' )
                    {
                    // InternalMinotorDsl.g:2137:4: (lv_fail_2_0= 'fail' )
                    // InternalMinotorDsl.g:2138:5: lv_fail_2_0= 'fail'
                    {
                    lv_fail_2_0=(Token)match(input,46,FOLLOW_64); 

                    					newLeafNode(lv_fail_2_0, grammarAccess.getContextMessageAccess().getFailFailKeyword_2_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getContextMessageRule());
                    					}
                    					setWithLastConsumed(current, "fail", lv_fail_2_0 != null, "fail");
                    				

                    }


                    }
                    break;

            }

            // InternalMinotorDsl.g:2150:3: ( (lv_strict_3_0= 'strict' ) )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==47) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // InternalMinotorDsl.g:2151:4: (lv_strict_3_0= 'strict' )
                    {
                    // InternalMinotorDsl.g:2151:4: (lv_strict_3_0= 'strict' )
                    // InternalMinotorDsl.g:2152:5: lv_strict_3_0= 'strict'
                    {
                    lv_strict_3_0=(Token)match(input,47,FOLLOW_27); 

                    					newLeafNode(lv_strict_3_0, grammarAccess.getContextMessageAccess().getStrictStrictKeyword_3_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getContextMessageRule());
                    					}
                    					setWithLastConsumed(current, "strict", lv_strict_3_0 != null, "strict");
                    				

                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,26,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getContextMessageAccess().getSemicolonKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleContextMessage"


    // $ANTLR start "entryRuleContextMessageContent"
    // InternalMinotorDsl.g:2172:1: entryRuleContextMessageContent returns [EObject current=null] : iv_ruleContextMessageContent= ruleContextMessageContent EOF ;
    public final EObject entryRuleContextMessageContent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContextMessageContent = null;


        try {
            // InternalMinotorDsl.g:2172:62: (iv_ruleContextMessageContent= ruleContextMessageContent EOF )
            // InternalMinotorDsl.g:2173:2: iv_ruleContextMessageContent= ruleContextMessageContent EOF
            {
             newCompositeNode(grammarAccess.getContextMessageContentRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleContextMessageContent=ruleContextMessageContent();

            state._fsp--;

             current =iv_ruleContextMessageContent; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleContextMessageContent"


    // $ANTLR start "ruleContextMessageContent"
    // InternalMinotorDsl.g:2179:1: ruleContextMessageContent returns [EObject current=null] : ( ( (lv_match_0_0= ruleMatchMessage ) ) | ( (lv_change_1_0= ruleChangeMessage ) ) ) ;
    public final EObject ruleContextMessageContent() throws RecognitionException {
        EObject current = null;

        EObject lv_match_0_0 = null;

        EObject lv_change_1_0 = null;



        	enterRule();

        try {
            // InternalMinotorDsl.g:2185:2: ( ( ( (lv_match_0_0= ruleMatchMessage ) ) | ( (lv_change_1_0= ruleChangeMessage ) ) ) )
            // InternalMinotorDsl.g:2186:2: ( ( (lv_match_0_0= ruleMatchMessage ) ) | ( (lv_change_1_0= ruleChangeMessage ) ) )
            {
            // InternalMinotorDsl.g:2186:2: ( ( (lv_match_0_0= ruleMatchMessage ) ) | ( (lv_change_1_0= ruleChangeMessage ) ) )
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==55) ) {
                alt64=1;
            }
            else if ( (LA64_0==56||(LA64_0>=58 && LA64_0<=60)) ) {
                alt64=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 64, 0, input);

                throw nvae;
            }
            switch (alt64) {
                case 1 :
                    // InternalMinotorDsl.g:2187:3: ( (lv_match_0_0= ruleMatchMessage ) )
                    {
                    // InternalMinotorDsl.g:2187:3: ( (lv_match_0_0= ruleMatchMessage ) )
                    // InternalMinotorDsl.g:2188:4: (lv_match_0_0= ruleMatchMessage )
                    {
                    // InternalMinotorDsl.g:2188:4: (lv_match_0_0= ruleMatchMessage )
                    // InternalMinotorDsl.g:2189:5: lv_match_0_0= ruleMatchMessage
                    {

                    					newCompositeNode(grammarAccess.getContextMessageContentAccess().getMatchMatchMessageParserRuleCall_0_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_match_0_0=ruleMatchMessage();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getContextMessageContentRule());
                    					}
                    					add(
                    						current,
                    						"match",
                    						lv_match_0_0,
                    						"hu.bme.mit.dipterv.text.MinotorDsl.MatchMessage");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalMinotorDsl.g:2207:3: ( (lv_change_1_0= ruleChangeMessage ) )
                    {
                    // InternalMinotorDsl.g:2207:3: ( (lv_change_1_0= ruleChangeMessage ) )
                    // InternalMinotorDsl.g:2208:4: (lv_change_1_0= ruleChangeMessage )
                    {
                    // InternalMinotorDsl.g:2208:4: (lv_change_1_0= ruleChangeMessage )
                    // InternalMinotorDsl.g:2209:5: lv_change_1_0= ruleChangeMessage
                    {

                    					newCompositeNode(grammarAccess.getContextMessageContentAccess().getChangeChangeMessageParserRuleCall_1_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_change_1_0=ruleChangeMessage();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getContextMessageContentRule());
                    					}
                    					add(
                    						current,
                    						"change",
                    						lv_change_1_0,
                    						"hu.bme.mit.dipterv.text.MinotorDsl.ChangeMessage");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleContextMessageContent"


    // $ANTLR start "entryRuleMatchMessage"
    // InternalMinotorDsl.g:2230:1: entryRuleMatchMessage returns [EObject current=null] : iv_ruleMatchMessage= ruleMatchMessage EOF ;
    public final EObject entryRuleMatchMessage() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMatchMessage = null;


        try {
            // InternalMinotorDsl.g:2230:53: (iv_ruleMatchMessage= ruleMatchMessage EOF )
            // InternalMinotorDsl.g:2231:2: iv_ruleMatchMessage= ruleMatchMessage EOF
            {
             newCompositeNode(grammarAccess.getMatchMessageRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMatchMessage=ruleMatchMessage();

            state._fsp--;

             current =iv_ruleMatchMessage; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMatchMessage"


    // $ANTLR start "ruleMatchMessage"
    // InternalMinotorDsl.g:2237:1: ruleMatchMessage returns [EObject current=null] : (otherlv_0= 'match' otherlv_1= '(' ( (otherlv_2= RULE_ID ) )? (otherlv_3= ',' )? ( (otherlv_4= RULE_ID ) )? otherlv_5= ')' ) ;
    public final EObject ruleMatchMessage() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;


        	enterRule();

        try {
            // InternalMinotorDsl.g:2243:2: ( (otherlv_0= 'match' otherlv_1= '(' ( (otherlv_2= RULE_ID ) )? (otherlv_3= ',' )? ( (otherlv_4= RULE_ID ) )? otherlv_5= ')' ) )
            // InternalMinotorDsl.g:2244:2: (otherlv_0= 'match' otherlv_1= '(' ( (otherlv_2= RULE_ID ) )? (otherlv_3= ',' )? ( (otherlv_4= RULE_ID ) )? otherlv_5= ')' )
            {
            // InternalMinotorDsl.g:2244:2: (otherlv_0= 'match' otherlv_1= '(' ( (otherlv_2= RULE_ID ) )? (otherlv_3= ',' )? ( (otherlv_4= RULE_ID ) )? otherlv_5= ')' )
            // InternalMinotorDsl.g:2245:3: otherlv_0= 'match' otherlv_1= '(' ( (otherlv_2= RULE_ID ) )? (otherlv_3= ',' )? ( (otherlv_4= RULE_ID ) )? otherlv_5= ')'
            {
            otherlv_0=(Token)match(input,55,FOLLOW_37); 

            			newLeafNode(otherlv_0, grammarAccess.getMatchMessageAccess().getMatchKeyword_0());
            		
            otherlv_1=(Token)match(input,39,FOLLOW_65); 

            			newLeafNode(otherlv_1, grammarAccess.getMatchMessageAccess().getLeftParenthesisKeyword_1());
            		
            // InternalMinotorDsl.g:2253:3: ( (otherlv_2= RULE_ID ) )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==RULE_ID) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // InternalMinotorDsl.g:2254:4: (otherlv_2= RULE_ID )
                    {
                    // InternalMinotorDsl.g:2254:4: (otherlv_2= RULE_ID )
                    // InternalMinotorDsl.g:2255:5: otherlv_2= RULE_ID
                    {

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getMatchMessageRule());
                    					}
                    				
                    otherlv_2=(Token)match(input,RULE_ID,FOLLOW_65); 

                    					newLeafNode(otherlv_2, grammarAccess.getMatchMessageAccess().getContextContextModelCrossReference_2_0());
                    				

                    }


                    }
                    break;

            }

            // InternalMinotorDsl.g:2266:3: (otherlv_3= ',' )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==40) ) {
                alt66=1;
            }
            switch (alt66) {
                case 1 :
                    // InternalMinotorDsl.g:2267:4: otherlv_3= ','
                    {
                    otherlv_3=(Token)match(input,40,FOLLOW_66); 

                    				newLeafNode(otherlv_3, grammarAccess.getMatchMessageAccess().getCommaKeyword_3());
                    			

                    }
                    break;

            }

            // InternalMinotorDsl.g:2272:3: ( (otherlv_4= RULE_ID ) )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==RULE_ID) ) {
                alt67=1;
            }
            switch (alt67) {
                case 1 :
                    // InternalMinotorDsl.g:2273:4: (otherlv_4= RULE_ID )
                    {
                    // InternalMinotorDsl.g:2273:4: (otherlv_4= RULE_ID )
                    // InternalMinotorDsl.g:2274:5: otherlv_4= RULE_ID
                    {

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getMatchMessageRule());
                    					}
                    				
                    otherlv_4=(Token)match(input,RULE_ID,FOLLOW_39); 

                    					newLeafNode(otherlv_4, grammarAccess.getMatchMessageAccess().getContentContextFragmentCrossReference_4_0());
                    				

                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,41,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getMatchMessageAccess().getRightParenthesisKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMatchMessage"


    // $ANTLR start "entryRuleChangeMessage"
    // InternalMinotorDsl.g:2293:1: entryRuleChangeMessage returns [EObject current=null] : iv_ruleChangeMessage= ruleChangeMessage EOF ;
    public final EObject entryRuleChangeMessage() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleChangeMessage = null;


        try {
            // InternalMinotorDsl.g:2293:54: (iv_ruleChangeMessage= ruleChangeMessage EOF )
            // InternalMinotorDsl.g:2294:2: iv_ruleChangeMessage= ruleChangeMessage EOF
            {
             newCompositeNode(grammarAccess.getChangeMessageRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleChangeMessage=ruleChangeMessage();

            state._fsp--;

             current =iv_ruleChangeMessage; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleChangeMessage"


    // $ANTLR start "ruleChangeMessage"
    // InternalMinotorDsl.g:2300:1: ruleChangeMessage returns [EObject current=null] : ( ( (lv_disappear_0_0= ruleDisappearMessage ) ) | ( (lv_appear_1_0= ruleAppearMessage ) ) | ( (lv_changeto_2_0= ruleChangeToMessage ) ) | ( (lv_changetor_3_0= ruleChangeToRelation ) ) ) ;
    public final EObject ruleChangeMessage() throws RecognitionException {
        EObject current = null;

        EObject lv_disappear_0_0 = null;

        EObject lv_appear_1_0 = null;

        EObject lv_changeto_2_0 = null;

        EObject lv_changetor_3_0 = null;



        	enterRule();

        try {
            // InternalMinotorDsl.g:2306:2: ( ( ( (lv_disappear_0_0= ruleDisappearMessage ) ) | ( (lv_appear_1_0= ruleAppearMessage ) ) | ( (lv_changeto_2_0= ruleChangeToMessage ) ) | ( (lv_changetor_3_0= ruleChangeToRelation ) ) ) )
            // InternalMinotorDsl.g:2307:2: ( ( (lv_disappear_0_0= ruleDisappearMessage ) ) | ( (lv_appear_1_0= ruleAppearMessage ) ) | ( (lv_changeto_2_0= ruleChangeToMessage ) ) | ( (lv_changetor_3_0= ruleChangeToRelation ) ) )
            {
            // InternalMinotorDsl.g:2307:2: ( ( (lv_disappear_0_0= ruleDisappearMessage ) ) | ( (lv_appear_1_0= ruleAppearMessage ) ) | ( (lv_changeto_2_0= ruleChangeToMessage ) ) | ( (lv_changetor_3_0= ruleChangeToRelation ) ) )
            int alt68=4;
            switch ( input.LA(1) ) {
            case 58:
                {
                alt68=1;
                }
                break;
            case 56:
                {
                alt68=2;
                }
                break;
            case 59:
                {
                alt68=3;
                }
                break;
            case 60:
                {
                alt68=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 68, 0, input);

                throw nvae;
            }

            switch (alt68) {
                case 1 :
                    // InternalMinotorDsl.g:2308:3: ( (lv_disappear_0_0= ruleDisappearMessage ) )
                    {
                    // InternalMinotorDsl.g:2308:3: ( (lv_disappear_0_0= ruleDisappearMessage ) )
                    // InternalMinotorDsl.g:2309:4: (lv_disappear_0_0= ruleDisappearMessage )
                    {
                    // InternalMinotorDsl.g:2309:4: (lv_disappear_0_0= ruleDisappearMessage )
                    // InternalMinotorDsl.g:2310:5: lv_disappear_0_0= ruleDisappearMessage
                    {

                    					newCompositeNode(grammarAccess.getChangeMessageAccess().getDisappearDisappearMessageParserRuleCall_0_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_disappear_0_0=ruleDisappearMessage();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getChangeMessageRule());
                    					}
                    					add(
                    						current,
                    						"disappear",
                    						lv_disappear_0_0,
                    						"hu.bme.mit.dipterv.text.MinotorDsl.DisappearMessage");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalMinotorDsl.g:2328:3: ( (lv_appear_1_0= ruleAppearMessage ) )
                    {
                    // InternalMinotorDsl.g:2328:3: ( (lv_appear_1_0= ruleAppearMessage ) )
                    // InternalMinotorDsl.g:2329:4: (lv_appear_1_0= ruleAppearMessage )
                    {
                    // InternalMinotorDsl.g:2329:4: (lv_appear_1_0= ruleAppearMessage )
                    // InternalMinotorDsl.g:2330:5: lv_appear_1_0= ruleAppearMessage
                    {

                    					newCompositeNode(grammarAccess.getChangeMessageAccess().getAppearAppearMessageParserRuleCall_1_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_appear_1_0=ruleAppearMessage();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getChangeMessageRule());
                    					}
                    					add(
                    						current,
                    						"appear",
                    						lv_appear_1_0,
                    						"hu.bme.mit.dipterv.text.MinotorDsl.AppearMessage");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalMinotorDsl.g:2348:3: ( (lv_changeto_2_0= ruleChangeToMessage ) )
                    {
                    // InternalMinotorDsl.g:2348:3: ( (lv_changeto_2_0= ruleChangeToMessage ) )
                    // InternalMinotorDsl.g:2349:4: (lv_changeto_2_0= ruleChangeToMessage )
                    {
                    // InternalMinotorDsl.g:2349:4: (lv_changeto_2_0= ruleChangeToMessage )
                    // InternalMinotorDsl.g:2350:5: lv_changeto_2_0= ruleChangeToMessage
                    {

                    					newCompositeNode(grammarAccess.getChangeMessageAccess().getChangetoChangeToMessageParserRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_changeto_2_0=ruleChangeToMessage();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getChangeMessageRule());
                    					}
                    					add(
                    						current,
                    						"changeto",
                    						lv_changeto_2_0,
                    						"hu.bme.mit.dipterv.text.MinotorDsl.ChangeToMessage");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalMinotorDsl.g:2368:3: ( (lv_changetor_3_0= ruleChangeToRelation ) )
                    {
                    // InternalMinotorDsl.g:2368:3: ( (lv_changetor_3_0= ruleChangeToRelation ) )
                    // InternalMinotorDsl.g:2369:4: (lv_changetor_3_0= ruleChangeToRelation )
                    {
                    // InternalMinotorDsl.g:2369:4: (lv_changetor_3_0= ruleChangeToRelation )
                    // InternalMinotorDsl.g:2370:5: lv_changetor_3_0= ruleChangeToRelation
                    {

                    					newCompositeNode(grammarAccess.getChangeMessageAccess().getChangetorChangeToRelationParserRuleCall_3_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_changetor_3_0=ruleChangeToRelation();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getChangeMessageRule());
                    					}
                    					add(
                    						current,
                    						"changetor",
                    						lv_changetor_3_0,
                    						"hu.bme.mit.dipterv.text.MinotorDsl.ChangeToRelation");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleChangeMessage"


    // $ANTLR start "entryRuleAppearMessage"
    // InternalMinotorDsl.g:2391:1: entryRuleAppearMessage returns [EObject current=null] : iv_ruleAppearMessage= ruleAppearMessage EOF ;
    public final EObject entryRuleAppearMessage() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAppearMessage = null;


        try {
            // InternalMinotorDsl.g:2391:54: (iv_ruleAppearMessage= ruleAppearMessage EOF )
            // InternalMinotorDsl.g:2392:2: iv_ruleAppearMessage= ruleAppearMessage EOF
            {
             newCompositeNode(grammarAccess.getAppearMessageRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAppearMessage=ruleAppearMessage();

            state._fsp--;

             current =iv_ruleAppearMessage; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAppearMessage"


    // $ANTLR start "ruleAppearMessage"
    // InternalMinotorDsl.g:2398:1: ruleAppearMessage returns [EObject current=null] : (otherlv_0= 'appear' otherlv_1= '(' ( ( (otherlv_2= RULE_ID ) ) otherlv_3= '.' ( (otherlv_4= RULE_ID ) ) )? otherlv_5= ')' ) ;
    public final EObject ruleAppearMessage() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;


        	enterRule();

        try {
            // InternalMinotorDsl.g:2404:2: ( (otherlv_0= 'appear' otherlv_1= '(' ( ( (otherlv_2= RULE_ID ) ) otherlv_3= '.' ( (otherlv_4= RULE_ID ) ) )? otherlv_5= ')' ) )
            // InternalMinotorDsl.g:2405:2: (otherlv_0= 'appear' otherlv_1= '(' ( ( (otherlv_2= RULE_ID ) ) otherlv_3= '.' ( (otherlv_4= RULE_ID ) ) )? otherlv_5= ')' )
            {
            // InternalMinotorDsl.g:2405:2: (otherlv_0= 'appear' otherlv_1= '(' ( ( (otherlv_2= RULE_ID ) ) otherlv_3= '.' ( (otherlv_4= RULE_ID ) ) )? otherlv_5= ')' )
            // InternalMinotorDsl.g:2406:3: otherlv_0= 'appear' otherlv_1= '(' ( ( (otherlv_2= RULE_ID ) ) otherlv_3= '.' ( (otherlv_4= RULE_ID ) ) )? otherlv_5= ')'
            {
            otherlv_0=(Token)match(input,56,FOLLOW_37); 

            			newLeafNode(otherlv_0, grammarAccess.getAppearMessageAccess().getAppearKeyword_0());
            		
            otherlv_1=(Token)match(input,39,FOLLOW_66); 

            			newLeafNode(otherlv_1, grammarAccess.getAppearMessageAccess().getLeftParenthesisKeyword_1());
            		
            // InternalMinotorDsl.g:2414:3: ( ( (otherlv_2= RULE_ID ) ) otherlv_3= '.' ( (otherlv_4= RULE_ID ) ) )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==RULE_ID) ) {
                alt69=1;
            }
            switch (alt69) {
                case 1 :
                    // InternalMinotorDsl.g:2415:4: ( (otherlv_2= RULE_ID ) ) otherlv_3= '.' ( (otherlv_4= RULE_ID ) )
                    {
                    // InternalMinotorDsl.g:2415:4: ( (otherlv_2= RULE_ID ) )
                    // InternalMinotorDsl.g:2416:5: (otherlv_2= RULE_ID )
                    {
                    // InternalMinotorDsl.g:2416:5: (otherlv_2= RULE_ID )
                    // InternalMinotorDsl.g:2417:6: otherlv_2= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getAppearMessageRule());
                    						}
                    					
                    otherlv_2=(Token)match(input,RULE_ID,FOLLOW_67); 

                    						newLeafNode(otherlv_2, grammarAccess.getAppearMessageAccess().getContextContextModelCrossReference_2_0_0());
                    					

                    }


                    }

                    otherlv_3=(Token)match(input,57,FOLLOW_13); 

                    				newLeafNode(otherlv_3, grammarAccess.getAppearMessageAccess().getFullStopKeyword_2_1());
                    			
                    // InternalMinotorDsl.g:2432:4: ( (otherlv_4= RULE_ID ) )
                    // InternalMinotorDsl.g:2433:5: (otherlv_4= RULE_ID )
                    {
                    // InternalMinotorDsl.g:2433:5: (otherlv_4= RULE_ID )
                    // InternalMinotorDsl.g:2434:6: otherlv_4= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getAppearMessageRule());
                    						}
                    					
                    otherlv_4=(Token)match(input,RULE_ID,FOLLOW_39); 

                    						newLeafNode(otherlv_4, grammarAccess.getAppearMessageAccess().getEntityEntityCrossReference_2_2_0());
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,41,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getAppearMessageAccess().getRightParenthesisKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAppearMessage"


    // $ANTLR start "entryRuleDisappearMessage"
    // InternalMinotorDsl.g:2454:1: entryRuleDisappearMessage returns [EObject current=null] : iv_ruleDisappearMessage= ruleDisappearMessage EOF ;
    public final EObject entryRuleDisappearMessage() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDisappearMessage = null;


        try {
            // InternalMinotorDsl.g:2454:57: (iv_ruleDisappearMessage= ruleDisappearMessage EOF )
            // InternalMinotorDsl.g:2455:2: iv_ruleDisappearMessage= ruleDisappearMessage EOF
            {
             newCompositeNode(grammarAccess.getDisappearMessageRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDisappearMessage=ruleDisappearMessage();

            state._fsp--;

             current =iv_ruleDisappearMessage; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDisappearMessage"


    // $ANTLR start "ruleDisappearMessage"
    // InternalMinotorDsl.g:2461:1: ruleDisappearMessage returns [EObject current=null] : (otherlv_0= 'disappear' otherlv_1= '(' ( ( (otherlv_2= RULE_ID ) ) otherlv_3= '.' ( (otherlv_4= RULE_ID ) ) )? otherlv_5= ')' ) ;
    public final EObject ruleDisappearMessage() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;


        	enterRule();

        try {
            // InternalMinotorDsl.g:2467:2: ( (otherlv_0= 'disappear' otherlv_1= '(' ( ( (otherlv_2= RULE_ID ) ) otherlv_3= '.' ( (otherlv_4= RULE_ID ) ) )? otherlv_5= ')' ) )
            // InternalMinotorDsl.g:2468:2: (otherlv_0= 'disappear' otherlv_1= '(' ( ( (otherlv_2= RULE_ID ) ) otherlv_3= '.' ( (otherlv_4= RULE_ID ) ) )? otherlv_5= ')' )
            {
            // InternalMinotorDsl.g:2468:2: (otherlv_0= 'disappear' otherlv_1= '(' ( ( (otherlv_2= RULE_ID ) ) otherlv_3= '.' ( (otherlv_4= RULE_ID ) ) )? otherlv_5= ')' )
            // InternalMinotorDsl.g:2469:3: otherlv_0= 'disappear' otherlv_1= '(' ( ( (otherlv_2= RULE_ID ) ) otherlv_3= '.' ( (otherlv_4= RULE_ID ) ) )? otherlv_5= ')'
            {
            otherlv_0=(Token)match(input,58,FOLLOW_37); 

            			newLeafNode(otherlv_0, grammarAccess.getDisappearMessageAccess().getDisappearKeyword_0());
            		
            otherlv_1=(Token)match(input,39,FOLLOW_66); 

            			newLeafNode(otherlv_1, grammarAccess.getDisappearMessageAccess().getLeftParenthesisKeyword_1());
            		
            // InternalMinotorDsl.g:2477:3: ( ( (otherlv_2= RULE_ID ) ) otherlv_3= '.' ( (otherlv_4= RULE_ID ) ) )?
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==RULE_ID) ) {
                alt70=1;
            }
            switch (alt70) {
                case 1 :
                    // InternalMinotorDsl.g:2478:4: ( (otherlv_2= RULE_ID ) ) otherlv_3= '.' ( (otherlv_4= RULE_ID ) )
                    {
                    // InternalMinotorDsl.g:2478:4: ( (otherlv_2= RULE_ID ) )
                    // InternalMinotorDsl.g:2479:5: (otherlv_2= RULE_ID )
                    {
                    // InternalMinotorDsl.g:2479:5: (otherlv_2= RULE_ID )
                    // InternalMinotorDsl.g:2480:6: otherlv_2= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDisappearMessageRule());
                    						}
                    					
                    otherlv_2=(Token)match(input,RULE_ID,FOLLOW_67); 

                    						newLeafNode(otherlv_2, grammarAccess.getDisappearMessageAccess().getContextContextModelCrossReference_2_0_0());
                    					

                    }


                    }

                    otherlv_3=(Token)match(input,57,FOLLOW_13); 

                    				newLeafNode(otherlv_3, grammarAccess.getDisappearMessageAccess().getFullStopKeyword_2_1());
                    			
                    // InternalMinotorDsl.g:2495:4: ( (otherlv_4= RULE_ID ) )
                    // InternalMinotorDsl.g:2496:5: (otherlv_4= RULE_ID )
                    {
                    // InternalMinotorDsl.g:2496:5: (otherlv_4= RULE_ID )
                    // InternalMinotorDsl.g:2497:6: otherlv_4= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDisappearMessageRule());
                    						}
                    					
                    otherlv_4=(Token)match(input,RULE_ID,FOLLOW_39); 

                    						newLeafNode(otherlv_4, grammarAccess.getDisappearMessageAccess().getEntityEntityCrossReference_2_2_0());
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,41,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getDisappearMessageAccess().getRightParenthesisKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDisappearMessage"


    // $ANTLR start "entryRuleChangeToMessage"
    // InternalMinotorDsl.g:2517:1: entryRuleChangeToMessage returns [EObject current=null] : iv_ruleChangeToMessage= ruleChangeToMessage EOF ;
    public final EObject entryRuleChangeToMessage() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleChangeToMessage = null;


        try {
            // InternalMinotorDsl.g:2517:56: (iv_ruleChangeToMessage= ruleChangeToMessage EOF )
            // InternalMinotorDsl.g:2518:2: iv_ruleChangeToMessage= ruleChangeToMessage EOF
            {
             newCompositeNode(grammarAccess.getChangeToMessageRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleChangeToMessage=ruleChangeToMessage();

            state._fsp--;

             current =iv_ruleChangeToMessage; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleChangeToMessage"


    // $ANTLR start "ruleChangeToMessage"
    // InternalMinotorDsl.g:2524:1: ruleChangeToMessage returns [EObject current=null] : (otherlv_0= 'changeTo' otherlv_1= '(' ( ( (otherlv_2= RULE_ID ) ) otherlv_3= '.' ( (otherlv_4= RULE_ID ) ) otherlv_5= '.' ( (otherlv_6= RULE_ID ) ) )? (otherlv_7= ',' )? ( (lv_changevalue_8_0= ruleAttributeValue ) )? otherlv_9= ')' ) ;
    public final EObject ruleChangeToMessage() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        EObject lv_changevalue_8_0 = null;



        	enterRule();

        try {
            // InternalMinotorDsl.g:2530:2: ( (otherlv_0= 'changeTo' otherlv_1= '(' ( ( (otherlv_2= RULE_ID ) ) otherlv_3= '.' ( (otherlv_4= RULE_ID ) ) otherlv_5= '.' ( (otherlv_6= RULE_ID ) ) )? (otherlv_7= ',' )? ( (lv_changevalue_8_0= ruleAttributeValue ) )? otherlv_9= ')' ) )
            // InternalMinotorDsl.g:2531:2: (otherlv_0= 'changeTo' otherlv_1= '(' ( ( (otherlv_2= RULE_ID ) ) otherlv_3= '.' ( (otherlv_4= RULE_ID ) ) otherlv_5= '.' ( (otherlv_6= RULE_ID ) ) )? (otherlv_7= ',' )? ( (lv_changevalue_8_0= ruleAttributeValue ) )? otherlv_9= ')' )
            {
            // InternalMinotorDsl.g:2531:2: (otherlv_0= 'changeTo' otherlv_1= '(' ( ( (otherlv_2= RULE_ID ) ) otherlv_3= '.' ( (otherlv_4= RULE_ID ) ) otherlv_5= '.' ( (otherlv_6= RULE_ID ) ) )? (otherlv_7= ',' )? ( (lv_changevalue_8_0= ruleAttributeValue ) )? otherlv_9= ')' )
            // InternalMinotorDsl.g:2532:3: otherlv_0= 'changeTo' otherlv_1= '(' ( ( (otherlv_2= RULE_ID ) ) otherlv_3= '.' ( (otherlv_4= RULE_ID ) ) otherlv_5= '.' ( (otherlv_6= RULE_ID ) ) )? (otherlv_7= ',' )? ( (lv_changevalue_8_0= ruleAttributeValue ) )? otherlv_9= ')'
            {
            otherlv_0=(Token)match(input,59,FOLLOW_37); 

            			newLeafNode(otherlv_0, grammarAccess.getChangeToMessageAccess().getChangeToKeyword_0());
            		
            otherlv_1=(Token)match(input,39,FOLLOW_41); 

            			newLeafNode(otherlv_1, grammarAccess.getChangeToMessageAccess().getLeftParenthesisKeyword_1());
            		
            // InternalMinotorDsl.g:2540:3: ( ( (otherlv_2= RULE_ID ) ) otherlv_3= '.' ( (otherlv_4= RULE_ID ) ) otherlv_5= '.' ( (otherlv_6= RULE_ID ) ) )?
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==RULE_ID) ) {
                alt71=1;
            }
            switch (alt71) {
                case 1 :
                    // InternalMinotorDsl.g:2541:4: ( (otherlv_2= RULE_ID ) ) otherlv_3= '.' ( (otherlv_4= RULE_ID ) ) otherlv_5= '.' ( (otherlv_6= RULE_ID ) )
                    {
                    // InternalMinotorDsl.g:2541:4: ( (otherlv_2= RULE_ID ) )
                    // InternalMinotorDsl.g:2542:5: (otherlv_2= RULE_ID )
                    {
                    // InternalMinotorDsl.g:2542:5: (otherlv_2= RULE_ID )
                    // InternalMinotorDsl.g:2543:6: otherlv_2= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getChangeToMessageRule());
                    						}
                    					
                    otherlv_2=(Token)match(input,RULE_ID,FOLLOW_67); 

                    						newLeafNode(otherlv_2, grammarAccess.getChangeToMessageAccess().getContextContextModelCrossReference_2_0_0());
                    					

                    }


                    }

                    otherlv_3=(Token)match(input,57,FOLLOW_13); 

                    				newLeafNode(otherlv_3, grammarAccess.getChangeToMessageAccess().getFullStopKeyword_2_1());
                    			
                    // InternalMinotorDsl.g:2558:4: ( (otherlv_4= RULE_ID ) )
                    // InternalMinotorDsl.g:2559:5: (otherlv_4= RULE_ID )
                    {
                    // InternalMinotorDsl.g:2559:5: (otherlv_4= RULE_ID )
                    // InternalMinotorDsl.g:2560:6: otherlv_4= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getChangeToMessageRule());
                    						}
                    					
                    otherlv_4=(Token)match(input,RULE_ID,FOLLOW_67); 

                    						newLeafNode(otherlv_4, grammarAccess.getChangeToMessageAccess().getEntityEntityCrossReference_2_2_0());
                    					

                    }


                    }

                    otherlv_5=(Token)match(input,57,FOLLOW_13); 

                    				newLeafNode(otherlv_5, grammarAccess.getChangeToMessageAccess().getFullStopKeyword_2_3());
                    			
                    // InternalMinotorDsl.g:2575:4: ( (otherlv_6= RULE_ID ) )
                    // InternalMinotorDsl.g:2576:5: (otherlv_6= RULE_ID )
                    {
                    // InternalMinotorDsl.g:2576:5: (otherlv_6= RULE_ID )
                    // InternalMinotorDsl.g:2577:6: otherlv_6= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getChangeToMessageRule());
                    						}
                    					
                    otherlv_6=(Token)match(input,RULE_ID,FOLLOW_68); 

                    						newLeafNode(otherlv_6, grammarAccess.getChangeToMessageAccess().getAttributeAttributeCrossReference_2_4_0());
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalMinotorDsl.g:2589:3: (otherlv_7= ',' )?
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==40) ) {
                alt72=1;
            }
            switch (alt72) {
                case 1 :
                    // InternalMinotorDsl.g:2590:4: otherlv_7= ','
                    {
                    otherlv_7=(Token)match(input,40,FOLLOW_69); 

                    				newLeafNode(otherlv_7, grammarAccess.getChangeToMessageAccess().getCommaKeyword_3());
                    			

                    }
                    break;

            }

            // InternalMinotorDsl.g:2595:3: ( (lv_changevalue_8_0= ruleAttributeValue ) )?
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( ((LA73_0>=RULE_STRING && LA73_0<=RULE_NUMBER)||(LA73_0>=27 && LA73_0<=28)) ) {
                alt73=1;
            }
            switch (alt73) {
                case 1 :
                    // InternalMinotorDsl.g:2596:4: (lv_changevalue_8_0= ruleAttributeValue )
                    {
                    // InternalMinotorDsl.g:2596:4: (lv_changevalue_8_0= ruleAttributeValue )
                    // InternalMinotorDsl.g:2597:5: lv_changevalue_8_0= ruleAttributeValue
                    {

                    					newCompositeNode(grammarAccess.getChangeToMessageAccess().getChangevalueAttributeValueParserRuleCall_4_0());
                    				
                    pushFollow(FOLLOW_39);
                    lv_changevalue_8_0=ruleAttributeValue();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getChangeToMessageRule());
                    					}
                    					set(
                    						current,
                    						"changevalue",
                    						lv_changevalue_8_0,
                    						"hu.bme.mit.dipterv.text.MinotorDsl.AttributeValue");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            otherlv_9=(Token)match(input,41,FOLLOW_2); 

            			newLeafNode(otherlv_9, grammarAccess.getChangeToMessageAccess().getRightParenthesisKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleChangeToMessage"


    // $ANTLR start "entryRuleChangeToRelation"
    // InternalMinotorDsl.g:2622:1: entryRuleChangeToRelation returns [EObject current=null] : iv_ruleChangeToRelation= ruleChangeToRelation EOF ;
    public final EObject entryRuleChangeToRelation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleChangeToRelation = null;


        try {
            // InternalMinotorDsl.g:2622:57: (iv_ruleChangeToRelation= ruleChangeToRelation EOF )
            // InternalMinotorDsl.g:2623:2: iv_ruleChangeToRelation= ruleChangeToRelation EOF
            {
             newCompositeNode(grammarAccess.getChangeToRelationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleChangeToRelation=ruleChangeToRelation();

            state._fsp--;

             current =iv_ruleChangeToRelation; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleChangeToRelation"


    // $ANTLR start "ruleChangeToRelation"
    // InternalMinotorDsl.g:2629:1: ruleChangeToRelation returns [EObject current=null] : (otherlv_0= 'relationChangeTo' otherlv_1= '(' ( ( (otherlv_2= RULE_ID ) ) otherlv_3= '.' ( (otherlv_4= RULE_ID ) ) otherlv_5= '.' ( (otherlv_6= RULE_ID ) ) )? (otherlv_7= ',' )? ( (lv_changevalue_8_0= ruleAttributeValue ) )? otherlv_9= ')' ) ;
    public final EObject ruleChangeToRelation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        EObject lv_changevalue_8_0 = null;



        	enterRule();

        try {
            // InternalMinotorDsl.g:2635:2: ( (otherlv_0= 'relationChangeTo' otherlv_1= '(' ( ( (otherlv_2= RULE_ID ) ) otherlv_3= '.' ( (otherlv_4= RULE_ID ) ) otherlv_5= '.' ( (otherlv_6= RULE_ID ) ) )? (otherlv_7= ',' )? ( (lv_changevalue_8_0= ruleAttributeValue ) )? otherlv_9= ')' ) )
            // InternalMinotorDsl.g:2636:2: (otherlv_0= 'relationChangeTo' otherlv_1= '(' ( ( (otherlv_2= RULE_ID ) ) otherlv_3= '.' ( (otherlv_4= RULE_ID ) ) otherlv_5= '.' ( (otherlv_6= RULE_ID ) ) )? (otherlv_7= ',' )? ( (lv_changevalue_8_0= ruleAttributeValue ) )? otherlv_9= ')' )
            {
            // InternalMinotorDsl.g:2636:2: (otherlv_0= 'relationChangeTo' otherlv_1= '(' ( ( (otherlv_2= RULE_ID ) ) otherlv_3= '.' ( (otherlv_4= RULE_ID ) ) otherlv_5= '.' ( (otherlv_6= RULE_ID ) ) )? (otherlv_7= ',' )? ( (lv_changevalue_8_0= ruleAttributeValue ) )? otherlv_9= ')' )
            // InternalMinotorDsl.g:2637:3: otherlv_0= 'relationChangeTo' otherlv_1= '(' ( ( (otherlv_2= RULE_ID ) ) otherlv_3= '.' ( (otherlv_4= RULE_ID ) ) otherlv_5= '.' ( (otherlv_6= RULE_ID ) ) )? (otherlv_7= ',' )? ( (lv_changevalue_8_0= ruleAttributeValue ) )? otherlv_9= ')'
            {
            otherlv_0=(Token)match(input,60,FOLLOW_37); 

            			newLeafNode(otherlv_0, grammarAccess.getChangeToRelationAccess().getRelationChangeToKeyword_0());
            		
            otherlv_1=(Token)match(input,39,FOLLOW_41); 

            			newLeafNode(otherlv_1, grammarAccess.getChangeToRelationAccess().getLeftParenthesisKeyword_1());
            		
            // InternalMinotorDsl.g:2645:3: ( ( (otherlv_2= RULE_ID ) ) otherlv_3= '.' ( (otherlv_4= RULE_ID ) ) otherlv_5= '.' ( (otherlv_6= RULE_ID ) ) )?
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==RULE_ID) ) {
                alt74=1;
            }
            switch (alt74) {
                case 1 :
                    // InternalMinotorDsl.g:2646:4: ( (otherlv_2= RULE_ID ) ) otherlv_3= '.' ( (otherlv_4= RULE_ID ) ) otherlv_5= '.' ( (otherlv_6= RULE_ID ) )
                    {
                    // InternalMinotorDsl.g:2646:4: ( (otherlv_2= RULE_ID ) )
                    // InternalMinotorDsl.g:2647:5: (otherlv_2= RULE_ID )
                    {
                    // InternalMinotorDsl.g:2647:5: (otherlv_2= RULE_ID )
                    // InternalMinotorDsl.g:2648:6: otherlv_2= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getChangeToRelationRule());
                    						}
                    					
                    otherlv_2=(Token)match(input,RULE_ID,FOLLOW_67); 

                    						newLeafNode(otherlv_2, grammarAccess.getChangeToRelationAccess().getContextContextModelCrossReference_2_0_0());
                    					

                    }


                    }

                    otherlv_3=(Token)match(input,57,FOLLOW_13); 

                    				newLeafNode(otherlv_3, grammarAccess.getChangeToRelationAccess().getFullStopKeyword_2_1());
                    			
                    // InternalMinotorDsl.g:2663:4: ( (otherlv_4= RULE_ID ) )
                    // InternalMinotorDsl.g:2664:5: (otherlv_4= RULE_ID )
                    {
                    // InternalMinotorDsl.g:2664:5: (otherlv_4= RULE_ID )
                    // InternalMinotorDsl.g:2665:6: otherlv_4= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getChangeToRelationRule());
                    						}
                    					
                    otherlv_4=(Token)match(input,RULE_ID,FOLLOW_67); 

                    						newLeafNode(otherlv_4, grammarAccess.getChangeToRelationAccess().getRelationRelationCrossReference_2_2_0());
                    					

                    }


                    }

                    otherlv_5=(Token)match(input,57,FOLLOW_13); 

                    				newLeafNode(otherlv_5, grammarAccess.getChangeToRelationAccess().getFullStopKeyword_2_3());
                    			
                    // InternalMinotorDsl.g:2680:4: ( (otherlv_6= RULE_ID ) )
                    // InternalMinotorDsl.g:2681:5: (otherlv_6= RULE_ID )
                    {
                    // InternalMinotorDsl.g:2681:5: (otherlv_6= RULE_ID )
                    // InternalMinotorDsl.g:2682:6: otherlv_6= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getChangeToRelationRule());
                    						}
                    					
                    otherlv_6=(Token)match(input,RULE_ID,FOLLOW_68); 

                    						newLeafNode(otherlv_6, grammarAccess.getChangeToRelationAccess().getAttributeAttributeCrossReference_2_4_0());
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalMinotorDsl.g:2694:3: (otherlv_7= ',' )?
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==40) ) {
                alt75=1;
            }
            switch (alt75) {
                case 1 :
                    // InternalMinotorDsl.g:2695:4: otherlv_7= ','
                    {
                    otherlv_7=(Token)match(input,40,FOLLOW_69); 

                    				newLeafNode(otherlv_7, grammarAccess.getChangeToRelationAccess().getCommaKeyword_3());
                    			

                    }
                    break;

            }

            // InternalMinotorDsl.g:2700:3: ( (lv_changevalue_8_0= ruleAttributeValue ) )?
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( ((LA76_0>=RULE_STRING && LA76_0<=RULE_NUMBER)||(LA76_0>=27 && LA76_0<=28)) ) {
                alt76=1;
            }
            switch (alt76) {
                case 1 :
                    // InternalMinotorDsl.g:2701:4: (lv_changevalue_8_0= ruleAttributeValue )
                    {
                    // InternalMinotorDsl.g:2701:4: (lv_changevalue_8_0= ruleAttributeValue )
                    // InternalMinotorDsl.g:2702:5: lv_changevalue_8_0= ruleAttributeValue
                    {

                    					newCompositeNode(grammarAccess.getChangeToRelationAccess().getChangevalueAttributeValueParserRuleCall_4_0());
                    				
                    pushFollow(FOLLOW_39);
                    lv_changevalue_8_0=ruleAttributeValue();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getChangeToRelationRule());
                    					}
                    					set(
                    						current,
                    						"changevalue",
                    						lv_changevalue_8_0,
                    						"hu.bme.mit.dipterv.text.MinotorDsl.AttributeValue");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            otherlv_9=(Token)match(input,41,FOLLOW_2); 

            			newLeafNode(otherlv_9, grammarAccess.getChangeToRelationAccess().getRightParenthesisKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleChangeToRelation"


    // $ANTLR start "entryRuleAssertionEntity"
    // InternalMinotorDsl.g:2727:1: entryRuleAssertionEntity returns [EObject current=null] : iv_ruleAssertionEntity= ruleAssertionEntity EOF ;
    public final EObject entryRuleAssertionEntity() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssertionEntity = null;


        try {
            // InternalMinotorDsl.g:2727:56: (iv_ruleAssertionEntity= ruleAssertionEntity EOF )
            // InternalMinotorDsl.g:2728:2: iv_ruleAssertionEntity= ruleAssertionEntity EOF
            {
             newCompositeNode(grammarAccess.getAssertionEntityRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAssertionEntity=ruleAssertionEntity();

            state._fsp--;

             current =iv_ruleAssertionEntity; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAssertionEntity"


    // $ANTLR start "ruleAssertionEntity"
    // InternalMinotorDsl.g:2734:1: ruleAssertionEntity returns [EObject current=null] : (otherlv_0= 'assertEntityAttribute' otherlv_1= '[' ( (otherlv_2= RULE_ID ) ) otherlv_3= '.' ( (otherlv_4= RULE_ID ) ) otherlv_5= '.' ( (otherlv_6= RULE_ID ) ) ( (lv_operator_7_0= ruleOperator ) ) ( (lv_value_8_0= ruleAttributeValue ) ) otherlv_9= ']' otherlv_10= ';' ) ;
    public final EObject ruleAssertionEntity() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        EObject lv_operator_7_0 = null;

        EObject lv_value_8_0 = null;



        	enterRule();

        try {
            // InternalMinotorDsl.g:2740:2: ( (otherlv_0= 'assertEntityAttribute' otherlv_1= '[' ( (otherlv_2= RULE_ID ) ) otherlv_3= '.' ( (otherlv_4= RULE_ID ) ) otherlv_5= '.' ( (otherlv_6= RULE_ID ) ) ( (lv_operator_7_0= ruleOperator ) ) ( (lv_value_8_0= ruleAttributeValue ) ) otherlv_9= ']' otherlv_10= ';' ) )
            // InternalMinotorDsl.g:2741:2: (otherlv_0= 'assertEntityAttribute' otherlv_1= '[' ( (otherlv_2= RULE_ID ) ) otherlv_3= '.' ( (otherlv_4= RULE_ID ) ) otherlv_5= '.' ( (otherlv_6= RULE_ID ) ) ( (lv_operator_7_0= ruleOperator ) ) ( (lv_value_8_0= ruleAttributeValue ) ) otherlv_9= ']' otherlv_10= ';' )
            {
            // InternalMinotorDsl.g:2741:2: (otherlv_0= 'assertEntityAttribute' otherlv_1= '[' ( (otherlv_2= RULE_ID ) ) otherlv_3= '.' ( (otherlv_4= RULE_ID ) ) otherlv_5= '.' ( (otherlv_6= RULE_ID ) ) ( (lv_operator_7_0= ruleOperator ) ) ( (lv_value_8_0= ruleAttributeValue ) ) otherlv_9= ']' otherlv_10= ';' )
            // InternalMinotorDsl.g:2742:3: otherlv_0= 'assertEntityAttribute' otherlv_1= '[' ( (otherlv_2= RULE_ID ) ) otherlv_3= '.' ( (otherlv_4= RULE_ID ) ) otherlv_5= '.' ( (otherlv_6= RULE_ID ) ) ( (lv_operator_7_0= ruleOperator ) ) ( (lv_value_8_0= ruleAttributeValue ) ) otherlv_9= ']' otherlv_10= ';'
            {
            otherlv_0=(Token)match(input,61,FOLLOW_70); 

            			newLeafNode(otherlv_0, grammarAccess.getAssertionEntityAccess().getAssertEntityAttributeKeyword_0());
            		
            otherlv_1=(Token)match(input,62,FOLLOW_13); 

            			newLeafNode(otherlv_1, grammarAccess.getAssertionEntityAccess().getLeftSquareBracketKeyword_1());
            		
            // InternalMinotorDsl.g:2750:3: ( (otherlv_2= RULE_ID ) )
            // InternalMinotorDsl.g:2751:4: (otherlv_2= RULE_ID )
            {
            // InternalMinotorDsl.g:2751:4: (otherlv_2= RULE_ID )
            // InternalMinotorDsl.g:2752:5: otherlv_2= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAssertionEntityRule());
            					}
            				
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_67); 

            					newLeafNode(otherlv_2, grammarAccess.getAssertionEntityAccess().getContextContextModelCrossReference_2_0());
            				

            }


            }

            otherlv_3=(Token)match(input,57,FOLLOW_13); 

            			newLeafNode(otherlv_3, grammarAccess.getAssertionEntityAccess().getFullStopKeyword_3());
            		
            // InternalMinotorDsl.g:2767:3: ( (otherlv_4= RULE_ID ) )
            // InternalMinotorDsl.g:2768:4: (otherlv_4= RULE_ID )
            {
            // InternalMinotorDsl.g:2768:4: (otherlv_4= RULE_ID )
            // InternalMinotorDsl.g:2769:5: otherlv_4= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAssertionEntityRule());
            					}
            				
            otherlv_4=(Token)match(input,RULE_ID,FOLLOW_67); 

            					newLeafNode(otherlv_4, grammarAccess.getAssertionEntityAccess().getEntityEntityCrossReference_4_0());
            				

            }


            }

            otherlv_5=(Token)match(input,57,FOLLOW_13); 

            			newLeafNode(otherlv_5, grammarAccess.getAssertionEntityAccess().getFullStopKeyword_5());
            		
            // InternalMinotorDsl.g:2784:3: ( (otherlv_6= RULE_ID ) )
            // InternalMinotorDsl.g:2785:4: (otherlv_6= RULE_ID )
            {
            // InternalMinotorDsl.g:2785:4: (otherlv_6= RULE_ID )
            // InternalMinotorDsl.g:2786:5: otherlv_6= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAssertionEntityRule());
            					}
            				
            otherlv_6=(Token)match(input,RULE_ID,FOLLOW_57); 

            					newLeafNode(otherlv_6, grammarAccess.getAssertionEntityAccess().getAttributeAttributeCrossReference_6_0());
            				

            }


            }

            // InternalMinotorDsl.g:2797:3: ( (lv_operator_7_0= ruleOperator ) )
            // InternalMinotorDsl.g:2798:4: (lv_operator_7_0= ruleOperator )
            {
            // InternalMinotorDsl.g:2798:4: (lv_operator_7_0= ruleOperator )
            // InternalMinotorDsl.g:2799:5: lv_operator_7_0= ruleOperator
            {

            					newCompositeNode(grammarAccess.getAssertionEntityAccess().getOperatorOperatorParserRuleCall_7_0());
            				
            pushFollow(FOLLOW_34);
            lv_operator_7_0=ruleOperator();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAssertionEntityRule());
            					}
            					add(
            						current,
            						"operator",
            						lv_operator_7_0,
            						"hu.bme.mit.dipterv.text.MinotorDsl.Operator");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMinotorDsl.g:2816:3: ( (lv_value_8_0= ruleAttributeValue ) )
            // InternalMinotorDsl.g:2817:4: (lv_value_8_0= ruleAttributeValue )
            {
            // InternalMinotorDsl.g:2817:4: (lv_value_8_0= ruleAttributeValue )
            // InternalMinotorDsl.g:2818:5: lv_value_8_0= ruleAttributeValue
            {

            					newCompositeNode(grammarAccess.getAssertionEntityAccess().getValueAttributeValueParserRuleCall_8_0());
            				
            pushFollow(FOLLOW_71);
            lv_value_8_0=ruleAttributeValue();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAssertionEntityRule());
            					}
            					add(
            						current,
            						"value",
            						lv_value_8_0,
            						"hu.bme.mit.dipterv.text.MinotorDsl.AttributeValue");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_9=(Token)match(input,63,FOLLOW_27); 

            			newLeafNode(otherlv_9, grammarAccess.getAssertionEntityAccess().getRightSquareBracketKeyword_9());
            		
            otherlv_10=(Token)match(input,26,FOLLOW_2); 

            			newLeafNode(otherlv_10, grammarAccess.getAssertionEntityAccess().getSemicolonKeyword_10());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAssertionEntity"


    // $ANTLR start "entryRuleAssertionRelation"
    // InternalMinotorDsl.g:2847:1: entryRuleAssertionRelation returns [EObject current=null] : iv_ruleAssertionRelation= ruleAssertionRelation EOF ;
    public final EObject entryRuleAssertionRelation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssertionRelation = null;


        try {
            // InternalMinotorDsl.g:2847:58: (iv_ruleAssertionRelation= ruleAssertionRelation EOF )
            // InternalMinotorDsl.g:2848:2: iv_ruleAssertionRelation= ruleAssertionRelation EOF
            {
             newCompositeNode(grammarAccess.getAssertionRelationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAssertionRelation=ruleAssertionRelation();

            state._fsp--;

             current =iv_ruleAssertionRelation; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAssertionRelation"


    // $ANTLR start "ruleAssertionRelation"
    // InternalMinotorDsl.g:2854:1: ruleAssertionRelation returns [EObject current=null] : (otherlv_0= 'assertRelationAttribute' otherlv_1= '[' ( (otherlv_2= RULE_ID ) ) otherlv_3= '.' ( (otherlv_4= RULE_ID ) ) otherlv_5= '.' ( (otherlv_6= RULE_ID ) ) ( (lv_operator_7_0= ruleOperator ) ) ( (lv_value_8_0= ruleAttributeValue ) ) otherlv_9= ']' otherlv_10= ';' ) ;
    public final EObject ruleAssertionRelation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        EObject lv_operator_7_0 = null;

        EObject lv_value_8_0 = null;



        	enterRule();

        try {
            // InternalMinotorDsl.g:2860:2: ( (otherlv_0= 'assertRelationAttribute' otherlv_1= '[' ( (otherlv_2= RULE_ID ) ) otherlv_3= '.' ( (otherlv_4= RULE_ID ) ) otherlv_5= '.' ( (otherlv_6= RULE_ID ) ) ( (lv_operator_7_0= ruleOperator ) ) ( (lv_value_8_0= ruleAttributeValue ) ) otherlv_9= ']' otherlv_10= ';' ) )
            // InternalMinotorDsl.g:2861:2: (otherlv_0= 'assertRelationAttribute' otherlv_1= '[' ( (otherlv_2= RULE_ID ) ) otherlv_3= '.' ( (otherlv_4= RULE_ID ) ) otherlv_5= '.' ( (otherlv_6= RULE_ID ) ) ( (lv_operator_7_0= ruleOperator ) ) ( (lv_value_8_0= ruleAttributeValue ) ) otherlv_9= ']' otherlv_10= ';' )
            {
            // InternalMinotorDsl.g:2861:2: (otherlv_0= 'assertRelationAttribute' otherlv_1= '[' ( (otherlv_2= RULE_ID ) ) otherlv_3= '.' ( (otherlv_4= RULE_ID ) ) otherlv_5= '.' ( (otherlv_6= RULE_ID ) ) ( (lv_operator_7_0= ruleOperator ) ) ( (lv_value_8_0= ruleAttributeValue ) ) otherlv_9= ']' otherlv_10= ';' )
            // InternalMinotorDsl.g:2862:3: otherlv_0= 'assertRelationAttribute' otherlv_1= '[' ( (otherlv_2= RULE_ID ) ) otherlv_3= '.' ( (otherlv_4= RULE_ID ) ) otherlv_5= '.' ( (otherlv_6= RULE_ID ) ) ( (lv_operator_7_0= ruleOperator ) ) ( (lv_value_8_0= ruleAttributeValue ) ) otherlv_9= ']' otherlv_10= ';'
            {
            otherlv_0=(Token)match(input,64,FOLLOW_70); 

            			newLeafNode(otherlv_0, grammarAccess.getAssertionRelationAccess().getAssertRelationAttributeKeyword_0());
            		
            otherlv_1=(Token)match(input,62,FOLLOW_13); 

            			newLeafNode(otherlv_1, grammarAccess.getAssertionRelationAccess().getLeftSquareBracketKeyword_1());
            		
            // InternalMinotorDsl.g:2870:3: ( (otherlv_2= RULE_ID ) )
            // InternalMinotorDsl.g:2871:4: (otherlv_2= RULE_ID )
            {
            // InternalMinotorDsl.g:2871:4: (otherlv_2= RULE_ID )
            // InternalMinotorDsl.g:2872:5: otherlv_2= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAssertionRelationRule());
            					}
            				
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_67); 

            					newLeafNode(otherlv_2, grammarAccess.getAssertionRelationAccess().getContextContextModelCrossReference_2_0());
            				

            }


            }

            otherlv_3=(Token)match(input,57,FOLLOW_13); 

            			newLeafNode(otherlv_3, grammarAccess.getAssertionRelationAccess().getFullStopKeyword_3());
            		
            // InternalMinotorDsl.g:2887:3: ( (otherlv_4= RULE_ID ) )
            // InternalMinotorDsl.g:2888:4: (otherlv_4= RULE_ID )
            {
            // InternalMinotorDsl.g:2888:4: (otherlv_4= RULE_ID )
            // InternalMinotorDsl.g:2889:5: otherlv_4= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAssertionRelationRule());
            					}
            				
            otherlv_4=(Token)match(input,RULE_ID,FOLLOW_67); 

            					newLeafNode(otherlv_4, grammarAccess.getAssertionRelationAccess().getRelationRelationCrossReference_4_0());
            				

            }


            }

            otherlv_5=(Token)match(input,57,FOLLOW_13); 

            			newLeafNode(otherlv_5, grammarAccess.getAssertionRelationAccess().getFullStopKeyword_5());
            		
            // InternalMinotorDsl.g:2904:3: ( (otherlv_6= RULE_ID ) )
            // InternalMinotorDsl.g:2905:4: (otherlv_6= RULE_ID )
            {
            // InternalMinotorDsl.g:2905:4: (otherlv_6= RULE_ID )
            // InternalMinotorDsl.g:2906:5: otherlv_6= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAssertionRelationRule());
            					}
            				
            otherlv_6=(Token)match(input,RULE_ID,FOLLOW_57); 

            					newLeafNode(otherlv_6, grammarAccess.getAssertionRelationAccess().getAttributeAttributeCrossReference_6_0());
            				

            }


            }

            // InternalMinotorDsl.g:2917:3: ( (lv_operator_7_0= ruleOperator ) )
            // InternalMinotorDsl.g:2918:4: (lv_operator_7_0= ruleOperator )
            {
            // InternalMinotorDsl.g:2918:4: (lv_operator_7_0= ruleOperator )
            // InternalMinotorDsl.g:2919:5: lv_operator_7_0= ruleOperator
            {

            					newCompositeNode(grammarAccess.getAssertionRelationAccess().getOperatorOperatorParserRuleCall_7_0());
            				
            pushFollow(FOLLOW_34);
            lv_operator_7_0=ruleOperator();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAssertionRelationRule());
            					}
            					add(
            						current,
            						"operator",
            						lv_operator_7_0,
            						"hu.bme.mit.dipterv.text.MinotorDsl.Operator");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMinotorDsl.g:2936:3: ( (lv_value_8_0= ruleAttributeValue ) )
            // InternalMinotorDsl.g:2937:4: (lv_value_8_0= ruleAttributeValue )
            {
            // InternalMinotorDsl.g:2937:4: (lv_value_8_0= ruleAttributeValue )
            // InternalMinotorDsl.g:2938:5: lv_value_8_0= ruleAttributeValue
            {

            					newCompositeNode(grammarAccess.getAssertionRelationAccess().getValueAttributeValueParserRuleCall_8_0());
            				
            pushFollow(FOLLOW_71);
            lv_value_8_0=ruleAttributeValue();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAssertionRelationRule());
            					}
            					add(
            						current,
            						"value",
            						lv_value_8_0,
            						"hu.bme.mit.dipterv.text.MinotorDsl.AttributeValue");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_9=(Token)match(input,63,FOLLOW_27); 

            			newLeafNode(otherlv_9, grammarAccess.getAssertionRelationAccess().getRightSquareBracketKeyword_9());
            		
            otherlv_10=(Token)match(input,26,FOLLOW_2); 

            			newLeafNode(otherlv_10, grammarAccess.getAssertionRelationAccess().getSemicolonKeyword_10());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAssertionRelation"


    // $ANTLR start "entryRuleParams"
    // InternalMinotorDsl.g:2967:1: entryRuleParams returns [EObject current=null] : iv_ruleParams= ruleParams EOF ;
    public final EObject entryRuleParams() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParams = null;


        try {
            // InternalMinotorDsl.g:2967:47: (iv_ruleParams= ruleParams EOF )
            // InternalMinotorDsl.g:2968:2: iv_ruleParams= ruleParams EOF
            {
             newCompositeNode(grammarAccess.getParamsRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleParams=ruleParams();

            state._fsp--;

             current =iv_ruleParams; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParams"


    // $ANTLR start "ruleParams"
    // InternalMinotorDsl.g:2974:1: ruleParams returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) )? (otherlv_1= ',' ( (otherlv_2= RULE_ID ) ) )* ) ;
    public final EObject ruleParams() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalMinotorDsl.g:2980:2: ( ( ( (otherlv_0= RULE_ID ) )? (otherlv_1= ',' ( (otherlv_2= RULE_ID ) ) )* ) )
            // InternalMinotorDsl.g:2981:2: ( ( (otherlv_0= RULE_ID ) )? (otherlv_1= ',' ( (otherlv_2= RULE_ID ) ) )* )
            {
            // InternalMinotorDsl.g:2981:2: ( ( (otherlv_0= RULE_ID ) )? (otherlv_1= ',' ( (otherlv_2= RULE_ID ) ) )* )
            // InternalMinotorDsl.g:2982:3: ( (otherlv_0= RULE_ID ) )? (otherlv_1= ',' ( (otherlv_2= RULE_ID ) ) )*
            {
            // InternalMinotorDsl.g:2982:3: ( (otherlv_0= RULE_ID ) )?
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==RULE_ID) ) {
                alt77=1;
            }
            switch (alt77) {
                case 1 :
                    // InternalMinotorDsl.g:2983:4: (otherlv_0= RULE_ID )
                    {
                    // InternalMinotorDsl.g:2983:4: (otherlv_0= RULE_ID )
                    // InternalMinotorDsl.g:2984:5: otherlv_0= RULE_ID
                    {

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getParamsRule());
                    					}
                    				
                    otherlv_0=(Token)match(input,RULE_ID,FOLLOW_72); 

                    					newLeafNode(otherlv_0, grammarAccess.getParamsAccess().getParamsParameterCrossReference_0_0());
                    				

                    }


                    }
                    break;

            }

            // InternalMinotorDsl.g:2995:3: (otherlv_1= ',' ( (otherlv_2= RULE_ID ) ) )*
            loop78:
            do {
                int alt78=2;
                int LA78_0 = input.LA(1);

                if ( (LA78_0==40) ) {
                    alt78=1;
                }


                switch (alt78) {
            	case 1 :
            	    // InternalMinotorDsl.g:2996:4: otherlv_1= ',' ( (otherlv_2= RULE_ID ) )
            	    {
            	    otherlv_1=(Token)match(input,40,FOLLOW_13); 

            	    				newLeafNode(otherlv_1, grammarAccess.getParamsAccess().getCommaKeyword_1_0());
            	    			
            	    // InternalMinotorDsl.g:3000:4: ( (otherlv_2= RULE_ID ) )
            	    // InternalMinotorDsl.g:3001:5: (otherlv_2= RULE_ID )
            	    {
            	    // InternalMinotorDsl.g:3001:5: (otherlv_2= RULE_ID )
            	    // InternalMinotorDsl.g:3002:6: otherlv_2= RULE_ID
            	    {

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getParamsRule());
            	    						}
            	    					
            	    otherlv_2=(Token)match(input,RULE_ID,FOLLOW_72); 

            	    						newLeafNode(otherlv_2, grammarAccess.getParamsAccess().getParamsParameterCrossReference_1_1_0());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop78;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParams"


    // $ANTLR start "entryRuleConstantParams"
    // InternalMinotorDsl.g:3018:1: entryRuleConstantParams returns [EObject current=null] : iv_ruleConstantParams= ruleConstantParams EOF ;
    public final EObject entryRuleConstantParams() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstantParams = null;


        try {
            // InternalMinotorDsl.g:3018:55: (iv_ruleConstantParams= ruleConstantParams EOF )
            // InternalMinotorDsl.g:3019:2: iv_ruleConstantParams= ruleConstantParams EOF
            {
             newCompositeNode(grammarAccess.getConstantParamsRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleConstantParams=ruleConstantParams();

            state._fsp--;

             current =iv_ruleConstantParams; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConstantParams"


    // $ANTLR start "ruleConstantParams"
    // InternalMinotorDsl.g:3025:1: ruleConstantParams returns [EObject current=null] : ( ( (lv_values_0_0= ruleAttributeValue ) )? (otherlv_1= ',' ( (lv_values_2_0= ruleAttributeValue ) ) )* ) ;
    public final EObject ruleConstantParams() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_values_0_0 = null;

        EObject lv_values_2_0 = null;



        	enterRule();

        try {
            // InternalMinotorDsl.g:3031:2: ( ( ( (lv_values_0_0= ruleAttributeValue ) )? (otherlv_1= ',' ( (lv_values_2_0= ruleAttributeValue ) ) )* ) )
            // InternalMinotorDsl.g:3032:2: ( ( (lv_values_0_0= ruleAttributeValue ) )? (otherlv_1= ',' ( (lv_values_2_0= ruleAttributeValue ) ) )* )
            {
            // InternalMinotorDsl.g:3032:2: ( ( (lv_values_0_0= ruleAttributeValue ) )? (otherlv_1= ',' ( (lv_values_2_0= ruleAttributeValue ) ) )* )
            // InternalMinotorDsl.g:3033:3: ( (lv_values_0_0= ruleAttributeValue ) )? (otherlv_1= ',' ( (lv_values_2_0= ruleAttributeValue ) ) )*
            {
            // InternalMinotorDsl.g:3033:3: ( (lv_values_0_0= ruleAttributeValue ) )?
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( ((LA79_0>=RULE_STRING && LA79_0<=RULE_NUMBER)||(LA79_0>=27 && LA79_0<=28)) ) {
                alt79=1;
            }
            switch (alt79) {
                case 1 :
                    // InternalMinotorDsl.g:3034:4: (lv_values_0_0= ruleAttributeValue )
                    {
                    // InternalMinotorDsl.g:3034:4: (lv_values_0_0= ruleAttributeValue )
                    // InternalMinotorDsl.g:3035:5: lv_values_0_0= ruleAttributeValue
                    {

                    					newCompositeNode(grammarAccess.getConstantParamsAccess().getValuesAttributeValueParserRuleCall_0_0());
                    				
                    pushFollow(FOLLOW_72);
                    lv_values_0_0=ruleAttributeValue();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getConstantParamsRule());
                    					}
                    					add(
                    						current,
                    						"values",
                    						lv_values_0_0,
                    						"hu.bme.mit.dipterv.text.MinotorDsl.AttributeValue");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalMinotorDsl.g:3052:3: (otherlv_1= ',' ( (lv_values_2_0= ruleAttributeValue ) ) )*
            loop80:
            do {
                int alt80=2;
                int LA80_0 = input.LA(1);

                if ( (LA80_0==40) ) {
                    alt80=1;
                }


                switch (alt80) {
            	case 1 :
            	    // InternalMinotorDsl.g:3053:4: otherlv_1= ',' ( (lv_values_2_0= ruleAttributeValue ) )
            	    {
            	    otherlv_1=(Token)match(input,40,FOLLOW_34); 

            	    				newLeafNode(otherlv_1, grammarAccess.getConstantParamsAccess().getCommaKeyword_1_0());
            	    			
            	    // InternalMinotorDsl.g:3057:4: ( (lv_values_2_0= ruleAttributeValue ) )
            	    // InternalMinotorDsl.g:3058:5: (lv_values_2_0= ruleAttributeValue )
            	    {
            	    // InternalMinotorDsl.g:3058:5: (lv_values_2_0= ruleAttributeValue )
            	    // InternalMinotorDsl.g:3059:6: lv_values_2_0= ruleAttributeValue
            	    {

            	    						newCompositeNode(grammarAccess.getConstantParamsAccess().getValuesAttributeValueParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_72);
            	    lv_values_2_0=ruleAttributeValue();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getConstantParamsRule());
            	    						}
            	    						add(
            	    							current,
            	    							"values",
            	    							lv_values_2_0,
            	    							"hu.bme.mit.dipterv.text.MinotorDsl.AttributeValue");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop80;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConstantParams"


    // $ANTLR start "entryRuleParameter"
    // InternalMinotorDsl.g:3081:1: entryRuleParameter returns [EObject current=null] : iv_ruleParameter= ruleParameter EOF ;
    public final EObject entryRuleParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter = null;


        try {
            // InternalMinotorDsl.g:3081:50: (iv_ruleParameter= ruleParameter EOF )
            // InternalMinotorDsl.g:3082:2: iv_ruleParameter= ruleParameter EOF
            {
             newCompositeNode(grammarAccess.getParameterRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleParameter=ruleParameter();

            state._fsp--;

             current =iv_ruleParameter; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameter"


    // $ANTLR start "ruleParameter"
    // InternalMinotorDsl.g:3088:1: ruleParameter returns [EObject current=null] : ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '=' )? ( (lv_value_3_0= ruleAttributeValue ) )? otherlv_4= ';' ) ;
    public final EObject ruleParameter() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Enumerator lv_type_0_0 = null;

        EObject lv_value_3_0 = null;



        	enterRule();

        try {
            // InternalMinotorDsl.g:3094:2: ( ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '=' )? ( (lv_value_3_0= ruleAttributeValue ) )? otherlv_4= ';' ) )
            // InternalMinotorDsl.g:3095:2: ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '=' )? ( (lv_value_3_0= ruleAttributeValue ) )? otherlv_4= ';' )
            {
            // InternalMinotorDsl.g:3095:2: ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '=' )? ( (lv_value_3_0= ruleAttributeValue ) )? otherlv_4= ';' )
            // InternalMinotorDsl.g:3096:3: ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '=' )? ( (lv_value_3_0= ruleAttributeValue ) )? otherlv_4= ';'
            {
            // InternalMinotorDsl.g:3096:3: ( (lv_type_0_0= ruleType ) )
            // InternalMinotorDsl.g:3097:4: (lv_type_0_0= ruleType )
            {
            // InternalMinotorDsl.g:3097:4: (lv_type_0_0= ruleType )
            // InternalMinotorDsl.g:3098:5: lv_type_0_0= ruleType
            {

            					newCompositeNode(grammarAccess.getParameterAccess().getTypeTypeEnumRuleCall_0_0());
            				
            pushFollow(FOLLOW_13);
            lv_type_0_0=ruleType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getParameterRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_0_0,
            						"hu.bme.mit.dipterv.text.MinotorDsl.Type");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMinotorDsl.g:3115:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMinotorDsl.g:3116:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMinotorDsl.g:3116:4: (lv_name_1_0= RULE_ID )
            // InternalMinotorDsl.g:3117:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_25); 

            					newLeafNode(lv_name_1_0, grammarAccess.getParameterAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getParameterRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalMinotorDsl.g:3133:3: (otherlv_2= '=' )?
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( (LA81_0==25) ) {
                alt81=1;
            }
            switch (alt81) {
                case 1 :
                    // InternalMinotorDsl.g:3134:4: otherlv_2= '='
                    {
                    otherlv_2=(Token)match(input,25,FOLLOW_26); 

                    				newLeafNode(otherlv_2, grammarAccess.getParameterAccess().getEqualsSignKeyword_2());
                    			

                    }
                    break;

            }

            // InternalMinotorDsl.g:3139:3: ( (lv_value_3_0= ruleAttributeValue ) )?
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( ((LA82_0>=RULE_STRING && LA82_0<=RULE_NUMBER)||(LA82_0>=27 && LA82_0<=28)) ) {
                alt82=1;
            }
            switch (alt82) {
                case 1 :
                    // InternalMinotorDsl.g:3140:4: (lv_value_3_0= ruleAttributeValue )
                    {
                    // InternalMinotorDsl.g:3140:4: (lv_value_3_0= ruleAttributeValue )
                    // InternalMinotorDsl.g:3141:5: lv_value_3_0= ruleAttributeValue
                    {

                    					newCompositeNode(grammarAccess.getParameterAccess().getValueAttributeValueParserRuleCall_3_0());
                    				
                    pushFollow(FOLLOW_27);
                    lv_value_3_0=ruleAttributeValue();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getParameterRule());
                    					}
                    					set(
                    						current,
                    						"value",
                    						lv_value_3_0,
                    						"hu.bme.mit.dipterv.text.MinotorDsl.AttributeValue");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,26,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getParameterAccess().getSemicolonKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameter"


    // $ANTLR start "entryRuleParameterConstraint"
    // InternalMinotorDsl.g:3166:1: entryRuleParameterConstraint returns [EObject current=null] : iv_ruleParameterConstraint= ruleParameterConstraint EOF ;
    public final EObject entryRuleParameterConstraint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterConstraint = null;


        try {
            // InternalMinotorDsl.g:3166:60: (iv_ruleParameterConstraint= ruleParameterConstraint EOF )
            // InternalMinotorDsl.g:3167:2: iv_ruleParameterConstraint= ruleParameterConstraint EOF
            {
             newCompositeNode(grammarAccess.getParameterConstraintRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleParameterConstraint=ruleParameterConstraint();

            state._fsp--;

             current =iv_ruleParameterConstraint; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameterConstraint"


    // $ANTLR start "ruleParameterConstraint"
    // InternalMinotorDsl.g:3173:1: ruleParameterConstraint returns [EObject current=null] : (otherlv_0= 'assertParameter' otherlv_1= '[' ( (otherlv_2= RULE_ID ) ) ( (lv_operator_3_0= ruleOperator ) ) ( (lv_value_4_0= ruleAttributeValue ) ) otherlv_5= ']' otherlv_6= 'in' ( (otherlv_7= RULE_ID ) ) otherlv_8= ';' ) ;
    public final EObject ruleParameterConstraint() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        EObject lv_operator_3_0 = null;

        EObject lv_value_4_0 = null;



        	enterRule();

        try {
            // InternalMinotorDsl.g:3179:2: ( (otherlv_0= 'assertParameter' otherlv_1= '[' ( (otherlv_2= RULE_ID ) ) ( (lv_operator_3_0= ruleOperator ) ) ( (lv_value_4_0= ruleAttributeValue ) ) otherlv_5= ']' otherlv_6= 'in' ( (otherlv_7= RULE_ID ) ) otherlv_8= ';' ) )
            // InternalMinotorDsl.g:3180:2: (otherlv_0= 'assertParameter' otherlv_1= '[' ( (otherlv_2= RULE_ID ) ) ( (lv_operator_3_0= ruleOperator ) ) ( (lv_value_4_0= ruleAttributeValue ) ) otherlv_5= ']' otherlv_6= 'in' ( (otherlv_7= RULE_ID ) ) otherlv_8= ';' )
            {
            // InternalMinotorDsl.g:3180:2: (otherlv_0= 'assertParameter' otherlv_1= '[' ( (otherlv_2= RULE_ID ) ) ( (lv_operator_3_0= ruleOperator ) ) ( (lv_value_4_0= ruleAttributeValue ) ) otherlv_5= ']' otherlv_6= 'in' ( (otherlv_7= RULE_ID ) ) otherlv_8= ';' )
            // InternalMinotorDsl.g:3181:3: otherlv_0= 'assertParameter' otherlv_1= '[' ( (otherlv_2= RULE_ID ) ) ( (lv_operator_3_0= ruleOperator ) ) ( (lv_value_4_0= ruleAttributeValue ) ) otherlv_5= ']' otherlv_6= 'in' ( (otherlv_7= RULE_ID ) ) otherlv_8= ';'
            {
            otherlv_0=(Token)match(input,65,FOLLOW_70); 

            			newLeafNode(otherlv_0, grammarAccess.getParameterConstraintAccess().getAssertParameterKeyword_0());
            		
            otherlv_1=(Token)match(input,62,FOLLOW_13); 

            			newLeafNode(otherlv_1, grammarAccess.getParameterConstraintAccess().getLeftSquareBracketKeyword_1());
            		
            // InternalMinotorDsl.g:3189:3: ( (otherlv_2= RULE_ID ) )
            // InternalMinotorDsl.g:3190:4: (otherlv_2= RULE_ID )
            {
            // InternalMinotorDsl.g:3190:4: (otherlv_2= RULE_ID )
            // InternalMinotorDsl.g:3191:5: otherlv_2= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getParameterConstraintRule());
            					}
            				
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_57); 

            					newLeafNode(otherlv_2, grammarAccess.getParameterConstraintAccess().getParamParameterCrossReference_2_0());
            				

            }


            }

            // InternalMinotorDsl.g:3202:3: ( (lv_operator_3_0= ruleOperator ) )
            // InternalMinotorDsl.g:3203:4: (lv_operator_3_0= ruleOperator )
            {
            // InternalMinotorDsl.g:3203:4: (lv_operator_3_0= ruleOperator )
            // InternalMinotorDsl.g:3204:5: lv_operator_3_0= ruleOperator
            {

            					newCompositeNode(grammarAccess.getParameterConstraintAccess().getOperatorOperatorParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_34);
            lv_operator_3_0=ruleOperator();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getParameterConstraintRule());
            					}
            					add(
            						current,
            						"operator",
            						lv_operator_3_0,
            						"hu.bme.mit.dipterv.text.MinotorDsl.Operator");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMinotorDsl.g:3221:3: ( (lv_value_4_0= ruleAttributeValue ) )
            // InternalMinotorDsl.g:3222:4: (lv_value_4_0= ruleAttributeValue )
            {
            // InternalMinotorDsl.g:3222:4: (lv_value_4_0= ruleAttributeValue )
            // InternalMinotorDsl.g:3223:5: lv_value_4_0= ruleAttributeValue
            {

            					newCompositeNode(grammarAccess.getParameterConstraintAccess().getValueAttributeValueParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_71);
            lv_value_4_0=ruleAttributeValue();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getParameterConstraintRule());
            					}
            					add(
            						current,
            						"value",
            						lv_value_4_0,
            						"hu.bme.mit.dipterv.text.MinotorDsl.AttributeValue");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,63,FOLLOW_73); 

            			newLeafNode(otherlv_5, grammarAccess.getParameterConstraintAccess().getRightSquareBracketKeyword_5());
            		
            otherlv_6=(Token)match(input,66,FOLLOW_13); 

            			newLeafNode(otherlv_6, grammarAccess.getParameterConstraintAccess().getInKeyword_6());
            		
            // InternalMinotorDsl.g:3248:3: ( (otherlv_7= RULE_ID ) )
            // InternalMinotorDsl.g:3249:4: (otherlv_7= RULE_ID )
            {
            // InternalMinotorDsl.g:3249:4: (otherlv_7= RULE_ID )
            // InternalMinotorDsl.g:3250:5: otherlv_7= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getParameterConstraintRule());
            					}
            				
            otherlv_7=(Token)match(input,RULE_ID,FOLLOW_27); 

            					newLeafNode(otherlv_7, grammarAccess.getParameterConstraintAccess().getObjectObjectCrossReference_7_0());
            				

            }


            }

            otherlv_8=(Token)match(input,26,FOLLOW_2); 

            			newLeafNode(otherlv_8, grammarAccess.getParameterConstraintAccess().getSemicolonKeyword_8());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameterConstraint"


    // $ANTLR start "entryRuleOperator"
    // InternalMinotorDsl.g:3269:1: entryRuleOperator returns [EObject current=null] : iv_ruleOperator= ruleOperator EOF ;
    public final EObject entryRuleOperator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperator = null;


        try {
            // InternalMinotorDsl.g:3269:49: (iv_ruleOperator= ruleOperator EOF )
            // InternalMinotorDsl.g:3270:2: iv_ruleOperator= ruleOperator EOF
            {
             newCompositeNode(grammarAccess.getOperatorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOperator=ruleOperator();

            state._fsp--;

             current =iv_ruleOperator; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOperator"


    // $ANTLR start "ruleOperator"
    // InternalMinotorDsl.g:3276:1: ruleOperator returns [EObject current=null] : ( ( (lv_greater_0_0= '>' ) ) | ( (lv_smaller_1_0= '<' ) ) | ( (lv_greaterequals_2_0= '>=' ) ) | ( (lv_smallerequals_3_0= '<=' ) ) | ( (lv_equals_4_0= '==' ) ) | ( (lv_notequals_5_0= '!=' ) ) ) ;
    public final EObject ruleOperator() throws RecognitionException {
        EObject current = null;

        Token lv_greater_0_0=null;
        Token lv_smaller_1_0=null;
        Token lv_greaterequals_2_0=null;
        Token lv_smallerequals_3_0=null;
        Token lv_equals_4_0=null;
        Token lv_notequals_5_0=null;


        	enterRule();

        try {
            // InternalMinotorDsl.g:3282:2: ( ( ( (lv_greater_0_0= '>' ) ) | ( (lv_smaller_1_0= '<' ) ) | ( (lv_greaterequals_2_0= '>=' ) ) | ( (lv_smallerequals_3_0= '<=' ) ) | ( (lv_equals_4_0= '==' ) ) | ( (lv_notequals_5_0= '!=' ) ) ) )
            // InternalMinotorDsl.g:3283:2: ( ( (lv_greater_0_0= '>' ) ) | ( (lv_smaller_1_0= '<' ) ) | ( (lv_greaterequals_2_0= '>=' ) ) | ( (lv_smallerequals_3_0= '<=' ) ) | ( (lv_equals_4_0= '==' ) ) | ( (lv_notequals_5_0= '!=' ) ) )
            {
            // InternalMinotorDsl.g:3283:2: ( ( (lv_greater_0_0= '>' ) ) | ( (lv_smaller_1_0= '<' ) ) | ( (lv_greaterequals_2_0= '>=' ) ) | ( (lv_smallerequals_3_0= '<=' ) ) | ( (lv_equals_4_0= '==' ) ) | ( (lv_notequals_5_0= '!=' ) ) )
            int alt83=6;
            switch ( input.LA(1) ) {
            case 30:
                {
                alt83=1;
                }
                break;
            case 31:
                {
                alt83=2;
                }
                break;
            case 32:
                {
                alt83=3;
                }
                break;
            case 33:
                {
                alt83=4;
                }
                break;
            case 34:
                {
                alt83=5;
                }
                break;
            case 35:
                {
                alt83=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 83, 0, input);

                throw nvae;
            }

            switch (alt83) {
                case 1 :
                    // InternalMinotorDsl.g:3284:3: ( (lv_greater_0_0= '>' ) )
                    {
                    // InternalMinotorDsl.g:3284:3: ( (lv_greater_0_0= '>' ) )
                    // InternalMinotorDsl.g:3285:4: (lv_greater_0_0= '>' )
                    {
                    // InternalMinotorDsl.g:3285:4: (lv_greater_0_0= '>' )
                    // InternalMinotorDsl.g:3286:5: lv_greater_0_0= '>'
                    {
                    lv_greater_0_0=(Token)match(input,30,FOLLOW_2); 

                    					newLeafNode(lv_greater_0_0, grammarAccess.getOperatorAccess().getGreaterGreaterThanSignKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getOperatorRule());
                    					}
                    					setWithLastConsumed(current, "greater", lv_greater_0_0 != null, ">");
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalMinotorDsl.g:3299:3: ( (lv_smaller_1_0= '<' ) )
                    {
                    // InternalMinotorDsl.g:3299:3: ( (lv_smaller_1_0= '<' ) )
                    // InternalMinotorDsl.g:3300:4: (lv_smaller_1_0= '<' )
                    {
                    // InternalMinotorDsl.g:3300:4: (lv_smaller_1_0= '<' )
                    // InternalMinotorDsl.g:3301:5: lv_smaller_1_0= '<'
                    {
                    lv_smaller_1_0=(Token)match(input,31,FOLLOW_2); 

                    					newLeafNode(lv_smaller_1_0, grammarAccess.getOperatorAccess().getSmallerLessThanSignKeyword_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getOperatorRule());
                    					}
                    					setWithLastConsumed(current, "smaller", lv_smaller_1_0 != null, "<");
                    				

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalMinotorDsl.g:3314:3: ( (lv_greaterequals_2_0= '>=' ) )
                    {
                    // InternalMinotorDsl.g:3314:3: ( (lv_greaterequals_2_0= '>=' ) )
                    // InternalMinotorDsl.g:3315:4: (lv_greaterequals_2_0= '>=' )
                    {
                    // InternalMinotorDsl.g:3315:4: (lv_greaterequals_2_0= '>=' )
                    // InternalMinotorDsl.g:3316:5: lv_greaterequals_2_0= '>='
                    {
                    lv_greaterequals_2_0=(Token)match(input,32,FOLLOW_2); 

                    					newLeafNode(lv_greaterequals_2_0, grammarAccess.getOperatorAccess().getGreaterequalsGreaterThanSignEqualsSignKeyword_2_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getOperatorRule());
                    					}
                    					setWithLastConsumed(current, "greaterequals", lv_greaterequals_2_0 != null, ">=");
                    				

                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalMinotorDsl.g:3329:3: ( (lv_smallerequals_3_0= '<=' ) )
                    {
                    // InternalMinotorDsl.g:3329:3: ( (lv_smallerequals_3_0= '<=' ) )
                    // InternalMinotorDsl.g:3330:4: (lv_smallerequals_3_0= '<=' )
                    {
                    // InternalMinotorDsl.g:3330:4: (lv_smallerequals_3_0= '<=' )
                    // InternalMinotorDsl.g:3331:5: lv_smallerequals_3_0= '<='
                    {
                    lv_smallerequals_3_0=(Token)match(input,33,FOLLOW_2); 

                    					newLeafNode(lv_smallerequals_3_0, grammarAccess.getOperatorAccess().getSmallerequalsLessThanSignEqualsSignKeyword_3_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getOperatorRule());
                    					}
                    					setWithLastConsumed(current, "smallerequals", lv_smallerequals_3_0 != null, "<=");
                    				

                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalMinotorDsl.g:3344:3: ( (lv_equals_4_0= '==' ) )
                    {
                    // InternalMinotorDsl.g:3344:3: ( (lv_equals_4_0= '==' ) )
                    // InternalMinotorDsl.g:3345:4: (lv_equals_4_0= '==' )
                    {
                    // InternalMinotorDsl.g:3345:4: (lv_equals_4_0= '==' )
                    // InternalMinotorDsl.g:3346:5: lv_equals_4_0= '=='
                    {
                    lv_equals_4_0=(Token)match(input,34,FOLLOW_2); 

                    					newLeafNode(lv_equals_4_0, grammarAccess.getOperatorAccess().getEqualsEqualsSignEqualsSignKeyword_4_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getOperatorRule());
                    					}
                    					setWithLastConsumed(current, "equals", lv_equals_4_0 != null, "==");
                    				

                    }


                    }


                    }
                    break;
                case 6 :
                    // InternalMinotorDsl.g:3359:3: ( (lv_notequals_5_0= '!=' ) )
                    {
                    // InternalMinotorDsl.g:3359:3: ( (lv_notequals_5_0= '!=' ) )
                    // InternalMinotorDsl.g:3360:4: (lv_notequals_5_0= '!=' )
                    {
                    // InternalMinotorDsl.g:3360:4: (lv_notequals_5_0= '!=' )
                    // InternalMinotorDsl.g:3361:5: lv_notequals_5_0= '!='
                    {
                    lv_notequals_5_0=(Token)match(input,35,FOLLOW_2); 

                    					newLeafNode(lv_notequals_5_0, grammarAccess.getOperatorAccess().getNotequalsExclamationMarkEqualsSignKeyword_5_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getOperatorRule());
                    					}
                    					setWithLastConsumed(current, "notequals", lv_notequals_5_0 != null, "!=");
                    				

                    }


                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOperator"


    // $ANTLR start "entryRuleClock"
    // InternalMinotorDsl.g:3377:1: entryRuleClock returns [EObject current=null] : iv_ruleClock= ruleClock EOF ;
    public final EObject entryRuleClock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClock = null;


        try {
            // InternalMinotorDsl.g:3377:46: (iv_ruleClock= ruleClock EOF )
            // InternalMinotorDsl.g:3378:2: iv_ruleClock= ruleClock EOF
            {
             newCompositeNode(grammarAccess.getClockRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleClock=ruleClock();

            state._fsp--;

             current =iv_ruleClock; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleClock"


    // $ANTLR start "ruleClock"
    // InternalMinotorDsl.g:3384:1: ruleClock returns [EObject current=null] : (otherlv_0= 'clock' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) ;
    public final EObject ruleClock() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalMinotorDsl.g:3390:2: ( (otherlv_0= 'clock' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) )
            // InternalMinotorDsl.g:3391:2: (otherlv_0= 'clock' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            {
            // InternalMinotorDsl.g:3391:2: (otherlv_0= 'clock' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            // InternalMinotorDsl.g:3392:3: otherlv_0= 'clock' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,67,FOLLOW_13); 

            			newLeafNode(otherlv_0, grammarAccess.getClockAccess().getClockKeyword_0());
            		
            // InternalMinotorDsl.g:3396:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMinotorDsl.g:3397:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMinotorDsl.g:3397:4: (lv_name_1_0= RULE_ID )
            // InternalMinotorDsl.g:3398:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_27); 

            					newLeafNode(lv_name_1_0, grammarAccess.getClockAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getClockRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,26,FOLLOW_2); 

            			newLeafNode(otherlv_2, grammarAccess.getClockAccess().getSemicolonKeyword_2());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleClock"


    // $ANTLR start "entryRuleObjectType"
    // InternalMinotorDsl.g:3422:1: entryRuleObjectType returns [EObject current=null] : iv_ruleObjectType= ruleObjectType EOF ;
    public final EObject entryRuleObjectType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleObjectType = null;


        try {
            // InternalMinotorDsl.g:3422:51: (iv_ruleObjectType= ruleObjectType EOF )
            // InternalMinotorDsl.g:3423:2: iv_ruleObjectType= ruleObjectType EOF
            {
             newCompositeNode(grammarAccess.getObjectTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleObjectType=ruleObjectType();

            state._fsp--;

             current =iv_ruleObjectType; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleObjectType"


    // $ANTLR start "ruleObjectType"
    // InternalMinotorDsl.g:3429:1: ruleObjectType returns [EObject current=null] : (otherlv_0= 'object' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleObjectType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;


        	enterRule();

        try {
            // InternalMinotorDsl.g:3435:2: ( (otherlv_0= 'object' ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalMinotorDsl.g:3436:2: (otherlv_0= 'object' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalMinotorDsl.g:3436:2: (otherlv_0= 'object' ( (lv_name_1_0= RULE_ID ) ) )
            // InternalMinotorDsl.g:3437:3: otherlv_0= 'object' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,68,FOLLOW_13); 

            			newLeafNode(otherlv_0, grammarAccess.getObjectTypeAccess().getObjectKeyword_0());
            		
            // InternalMinotorDsl.g:3441:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMinotorDsl.g:3442:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMinotorDsl.g:3442:4: (lv_name_1_0= RULE_ID )
            // InternalMinotorDsl.g:3443:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(lv_name_1_0, grammarAccess.getObjectTypeAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getObjectTypeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleObjectType"


    // $ANTLR start "entryRuleObject"
    // InternalMinotorDsl.g:3463:1: entryRuleObject returns [EObject current=null] : iv_ruleObject= ruleObject EOF ;
    public final EObject entryRuleObject() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleObject = null;


        try {
            // InternalMinotorDsl.g:3463:47: (iv_ruleObject= ruleObject EOF )
            // InternalMinotorDsl.g:3464:2: iv_ruleObject= ruleObject EOF
            {
             newCompositeNode(grammarAccess.getObjectRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleObject=ruleObject();

            state._fsp--;

             current =iv_ruleObject; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleObject"


    // $ANTLR start "ruleObject"
    // InternalMinotorDsl.g:3470:1: ruleObject returns [EObject current=null] : ( ( (lv_object_0_0= ruleObjectType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) ;
    public final EObject ruleObject() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        EObject lv_object_0_0 = null;



        	enterRule();

        try {
            // InternalMinotorDsl.g:3476:2: ( ( ( (lv_object_0_0= ruleObjectType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) )
            // InternalMinotorDsl.g:3477:2: ( ( (lv_object_0_0= ruleObjectType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            {
            // InternalMinotorDsl.g:3477:2: ( ( (lv_object_0_0= ruleObjectType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            // InternalMinotorDsl.g:3478:3: ( (lv_object_0_0= ruleObjectType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';'
            {
            // InternalMinotorDsl.g:3478:3: ( (lv_object_0_0= ruleObjectType ) )
            // InternalMinotorDsl.g:3479:4: (lv_object_0_0= ruleObjectType )
            {
            // InternalMinotorDsl.g:3479:4: (lv_object_0_0= ruleObjectType )
            // InternalMinotorDsl.g:3480:5: lv_object_0_0= ruleObjectType
            {

            					newCompositeNode(grammarAccess.getObjectAccess().getObjectObjectTypeParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_13);
            lv_object_0_0=ruleObjectType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getObjectRule());
            					}
            					add(
            						current,
            						"object",
            						lv_object_0_0,
            						"hu.bme.mit.dipterv.text.MinotorDsl.ObjectType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMinotorDsl.g:3497:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMinotorDsl.g:3498:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMinotorDsl.g:3498:4: (lv_name_1_0= RULE_ID )
            // InternalMinotorDsl.g:3499:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_27); 

            					newLeafNode(lv_name_1_0, grammarAccess.getObjectAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getObjectRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,26,FOLLOW_2); 

            			newLeafNode(otherlv_2, grammarAccess.getObjectAccess().getSemicolonKeyword_2());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleObject"


    // $ANTLR start "entryRuleConstraint"
    // InternalMinotorDsl.g:3523:1: entryRuleConstraint returns [EObject current=null] : iv_ruleConstraint= ruleConstraint EOF ;
    public final EObject entryRuleConstraint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstraint = null;


        try {
            // InternalMinotorDsl.g:3523:51: (iv_ruleConstraint= ruleConstraint EOF )
            // InternalMinotorDsl.g:3524:2: iv_ruleConstraint= ruleConstraint EOF
            {
             newCompositeNode(grammarAccess.getConstraintRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleConstraint=ruleConstraint();

            state._fsp--;

             current =iv_ruleConstraint; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConstraint"


    // $ANTLR start "ruleConstraint"
    // InternalMinotorDsl.g:3530:1: ruleConstraint returns [EObject current=null] : (otherlv_0= 'constraint' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_messages_3_0= ruleMessage ) )* otherlv_4= '}' ) ;
    public final EObject ruleConstraint() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_messages_3_0 = null;



        	enterRule();

        try {
            // InternalMinotorDsl.g:3536:2: ( (otherlv_0= 'constraint' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_messages_3_0= ruleMessage ) )* otherlv_4= '}' ) )
            // InternalMinotorDsl.g:3537:2: (otherlv_0= 'constraint' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_messages_3_0= ruleMessage ) )* otherlv_4= '}' )
            {
            // InternalMinotorDsl.g:3537:2: (otherlv_0= 'constraint' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_messages_3_0= ruleMessage ) )* otherlv_4= '}' )
            // InternalMinotorDsl.g:3538:3: otherlv_0= 'constraint' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_messages_3_0= ruleMessage ) )* otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,69,FOLLOW_13); 

            			newLeafNode(otherlv_0, grammarAccess.getConstraintAccess().getConstraintKeyword_0());
            		
            // InternalMinotorDsl.g:3542:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMinotorDsl.g:3543:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMinotorDsl.g:3543:4: (lv_name_1_0= RULE_ID )
            // InternalMinotorDsl.g:3544:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_16); 

            					newLeafNode(lv_name_1_0, grammarAccess.getConstraintAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getConstraintRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,14,FOLLOW_74); 

            			newLeafNode(otherlv_2, grammarAccess.getConstraintAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalMinotorDsl.g:3564:3: ( (lv_messages_3_0= ruleMessage ) )*
            loop84:
            do {
                int alt84=2;
                int LA84_0 = input.LA(1);

                if ( (LA84_0==44) ) {
                    alt84=1;
                }


                switch (alt84) {
            	case 1 :
            	    // InternalMinotorDsl.g:3565:4: (lv_messages_3_0= ruleMessage )
            	    {
            	    // InternalMinotorDsl.g:3565:4: (lv_messages_3_0= ruleMessage )
            	    // InternalMinotorDsl.g:3566:5: lv_messages_3_0= ruleMessage
            	    {

            	    					newCompositeNode(grammarAccess.getConstraintAccess().getMessagesMessageParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_74);
            	    lv_messages_3_0=ruleMessage();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getConstraintRule());
            	    					}
            	    					add(
            	    						current,
            	    						"messages",
            	    						lv_messages_3_0,
            	    						"hu.bme.mit.dipterv.text.MinotorDsl.Message");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop84;
                }
            } while (true);

            otherlv_4=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getConstraintAccess().getRightCurlyBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConstraint"


    // $ANTLR start "entryRuleAlt"
    // InternalMinotorDsl.g:3591:1: entryRuleAlt returns [EObject current=null] : iv_ruleAlt= ruleAlt EOF ;
    public final EObject entryRuleAlt() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAlt = null;


        try {
            // InternalMinotorDsl.g:3591:44: (iv_ruleAlt= ruleAlt EOF )
            // InternalMinotorDsl.g:3592:2: iv_ruleAlt= ruleAlt EOF
            {
             newCompositeNode(grammarAccess.getAltRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAlt=ruleAlt();

            state._fsp--;

             current =iv_ruleAlt; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAlt"


    // $ANTLR start "ruleAlt"
    // InternalMinotorDsl.g:3598:1: ruleAlt returns [EObject current=null] : (otherlv_0= 'alt' ( (lv_expressions_1_0= ruleExpression ) )* ) ;
    public final EObject ruleAlt() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_expressions_1_0 = null;



        	enterRule();

        try {
            // InternalMinotorDsl.g:3604:2: ( (otherlv_0= 'alt' ( (lv_expressions_1_0= ruleExpression ) )* ) )
            // InternalMinotorDsl.g:3605:2: (otherlv_0= 'alt' ( (lv_expressions_1_0= ruleExpression ) )* )
            {
            // InternalMinotorDsl.g:3605:2: (otherlv_0= 'alt' ( (lv_expressions_1_0= ruleExpression ) )* )
            // InternalMinotorDsl.g:3606:3: otherlv_0= 'alt' ( (lv_expressions_1_0= ruleExpression ) )*
            {
            otherlv_0=(Token)match(input,70,FOLLOW_75); 

            			newLeafNode(otherlv_0, grammarAccess.getAltAccess().getAltKeyword_0());
            		
            // InternalMinotorDsl.g:3610:3: ( (lv_expressions_1_0= ruleExpression ) )*
            loop85:
            do {
                int alt85=2;
                int LA85_0 = input.LA(1);

                if ( (LA85_0==39) ) {
                    alt85=1;
                }


                switch (alt85) {
            	case 1 :
            	    // InternalMinotorDsl.g:3611:4: (lv_expressions_1_0= ruleExpression )
            	    {
            	    // InternalMinotorDsl.g:3611:4: (lv_expressions_1_0= ruleExpression )
            	    // InternalMinotorDsl.g:3612:5: lv_expressions_1_0= ruleExpression
            	    {

            	    					newCompositeNode(grammarAccess.getAltAccess().getExpressionsExpressionParserRuleCall_1_0());
            	    				
            	    pushFollow(FOLLOW_75);
            	    lv_expressions_1_0=ruleExpression();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getAltRule());
            	    					}
            	    					add(
            	    						current,
            	    						"expressions",
            	    						lv_expressions_1_0,
            	    						"hu.bme.mit.dipterv.text.MinotorDsl.Expression");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop85;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAlt"


    // $ANTLR start "entryRuleExpression"
    // InternalMinotorDsl.g:3633:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // InternalMinotorDsl.g:3633:51: (iv_ruleExpression= ruleExpression EOF )
            // InternalMinotorDsl.g:3634:2: iv_ruleExpression= ruleExpression EOF
            {
             newCompositeNode(grammarAccess.getExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleExpression=ruleExpression();

            state._fsp--;

             current =iv_ruleExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExpression"


    // $ANTLR start "ruleExpression"
    // InternalMinotorDsl.g:3640:1: ruleExpression returns [EObject current=null] : (otherlv_0= '(' ( (lv_altCondition_1_0= ruleLogicalExpression ) ) otherlv_2= ')' otherlv_3= '{' ( (lv_messages_4_0= ruleMessage ) )* otherlv_5= '}' ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_altCondition_1_0 = null;

        EObject lv_messages_4_0 = null;



        	enterRule();

        try {
            // InternalMinotorDsl.g:3646:2: ( (otherlv_0= '(' ( (lv_altCondition_1_0= ruleLogicalExpression ) ) otherlv_2= ')' otherlv_3= '{' ( (lv_messages_4_0= ruleMessage ) )* otherlv_5= '}' ) )
            // InternalMinotorDsl.g:3647:2: (otherlv_0= '(' ( (lv_altCondition_1_0= ruleLogicalExpression ) ) otherlv_2= ')' otherlv_3= '{' ( (lv_messages_4_0= ruleMessage ) )* otherlv_5= '}' )
            {
            // InternalMinotorDsl.g:3647:2: (otherlv_0= '(' ( (lv_altCondition_1_0= ruleLogicalExpression ) ) otherlv_2= ')' otherlv_3= '{' ( (lv_messages_4_0= ruleMessage ) )* otherlv_5= '}' )
            // InternalMinotorDsl.g:3648:3: otherlv_0= '(' ( (lv_altCondition_1_0= ruleLogicalExpression ) ) otherlv_2= ')' otherlv_3= '{' ( (lv_messages_4_0= ruleMessage ) )* otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,39,FOLLOW_76); 

            			newLeafNode(otherlv_0, grammarAccess.getExpressionAccess().getLeftParenthesisKeyword_0());
            		
            // InternalMinotorDsl.g:3652:3: ( (lv_altCondition_1_0= ruleLogicalExpression ) )
            // InternalMinotorDsl.g:3653:4: (lv_altCondition_1_0= ruleLogicalExpression )
            {
            // InternalMinotorDsl.g:3653:4: (lv_altCondition_1_0= ruleLogicalExpression )
            // InternalMinotorDsl.g:3654:5: lv_altCondition_1_0= ruleLogicalExpression
            {

            					newCompositeNode(grammarAccess.getExpressionAccess().getAltConditionLogicalExpressionParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_39);
            lv_altCondition_1_0=ruleLogicalExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getExpressionRule());
            					}
            					set(
            						current,
            						"altCondition",
            						lv_altCondition_1_0,
            						"hu.bme.mit.dipterv.text.MinotorDsl.LogicalExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,41,FOLLOW_16); 

            			newLeafNode(otherlv_2, grammarAccess.getExpressionAccess().getRightParenthesisKeyword_2());
            		
            otherlv_3=(Token)match(input,14,FOLLOW_74); 

            			newLeafNode(otherlv_3, grammarAccess.getExpressionAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalMinotorDsl.g:3679:3: ( (lv_messages_4_0= ruleMessage ) )*
            loop86:
            do {
                int alt86=2;
                int LA86_0 = input.LA(1);

                if ( (LA86_0==44) ) {
                    alt86=1;
                }


                switch (alt86) {
            	case 1 :
            	    // InternalMinotorDsl.g:3680:4: (lv_messages_4_0= ruleMessage )
            	    {
            	    // InternalMinotorDsl.g:3680:4: (lv_messages_4_0= ruleMessage )
            	    // InternalMinotorDsl.g:3681:5: lv_messages_4_0= ruleMessage
            	    {

            	    					newCompositeNode(grammarAccess.getExpressionAccess().getMessagesMessageParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_74);
            	    lv_messages_4_0=ruleMessage();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getExpressionRule());
            	    					}
            	    					add(
            	    						current,
            	    						"messages",
            	    						lv_messages_4_0,
            	    						"hu.bme.mit.dipterv.text.MinotorDsl.Message");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop86;
                }
            } while (true);

            otherlv_5=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getExpressionAccess().getRightCurlyBracketKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRuleLogicalExpression"
    // InternalMinotorDsl.g:3706:1: entryRuleLogicalExpression returns [EObject current=null] : iv_ruleLogicalExpression= ruleLogicalExpression EOF ;
    public final EObject entryRuleLogicalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalExpression = null;


        try {
            // InternalMinotorDsl.g:3706:58: (iv_ruleLogicalExpression= ruleLogicalExpression EOF )
            // InternalMinotorDsl.g:3707:2: iv_ruleLogicalExpression= ruleLogicalExpression EOF
            {
             newCompositeNode(grammarAccess.getLogicalExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLogicalExpression=ruleLogicalExpression();

            state._fsp--;

             current =iv_ruleLogicalExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLogicalExpression"


    // $ANTLR start "ruleLogicalExpression"
    // InternalMinotorDsl.g:3713:1: ruleLogicalExpression returns [EObject current=null] : (this_UnaryLogicalExpression_0= ruleUnaryLogicalExpression | this_BinaryLogicalExpression_1= ruleBinaryLogicalExpression ) ;
    public final EObject ruleLogicalExpression() throws RecognitionException {
        EObject current = null;

        EObject this_UnaryLogicalExpression_0 = null;

        EObject this_BinaryLogicalExpression_1 = null;



        	enterRule();

        try {
            // InternalMinotorDsl.g:3719:2: ( (this_UnaryLogicalExpression_0= ruleUnaryLogicalExpression | this_BinaryLogicalExpression_1= ruleBinaryLogicalExpression ) )
            // InternalMinotorDsl.g:3720:2: (this_UnaryLogicalExpression_0= ruleUnaryLogicalExpression | this_BinaryLogicalExpression_1= ruleBinaryLogicalExpression )
            {
            // InternalMinotorDsl.g:3720:2: (this_UnaryLogicalExpression_0= ruleUnaryLogicalExpression | this_BinaryLogicalExpression_1= ruleBinaryLogicalExpression )
            int alt87=2;
            int LA87_0 = input.LA(1);

            if ( (LA87_0==53) ) {
                alt87=1;
            }
            else if ( (LA87_0==54||(LA87_0>=71 && LA87_0<=74)) ) {
                alt87=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 87, 0, input);

                throw nvae;
            }
            switch (alt87) {
                case 1 :
                    // InternalMinotorDsl.g:3721:3: this_UnaryLogicalExpression_0= ruleUnaryLogicalExpression
                    {

                    			newCompositeNode(grammarAccess.getLogicalExpressionAccess().getUnaryLogicalExpressionParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_UnaryLogicalExpression_0=ruleUnaryLogicalExpression();

                    state._fsp--;


                    			current = this_UnaryLogicalExpression_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalMinotorDsl.g:3730:3: this_BinaryLogicalExpression_1= ruleBinaryLogicalExpression
                    {

                    			newCompositeNode(grammarAccess.getLogicalExpressionAccess().getBinaryLogicalExpressionParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_BinaryLogicalExpression_1=ruleBinaryLogicalExpression();

                    state._fsp--;


                    			current = this_BinaryLogicalExpression_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLogicalExpression"


    // $ANTLR start "entryRuleBinaryLogicalExpression"
    // InternalMinotorDsl.g:3742:1: entryRuleBinaryLogicalExpression returns [EObject current=null] : iv_ruleBinaryLogicalExpression= ruleBinaryLogicalExpression EOF ;
    public final EObject entryRuleBinaryLogicalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBinaryLogicalExpression = null;


        try {
            // InternalMinotorDsl.g:3742:64: (iv_ruleBinaryLogicalExpression= ruleBinaryLogicalExpression EOF )
            // InternalMinotorDsl.g:3743:2: iv_ruleBinaryLogicalExpression= ruleBinaryLogicalExpression EOF
            {
             newCompositeNode(grammarAccess.getBinaryLogicalExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBinaryLogicalExpression=ruleBinaryLogicalExpression();

            state._fsp--;

             current =iv_ruleBinaryLogicalExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBinaryLogicalExpression"


    // $ANTLR start "ruleBinaryLogicalExpression"
    // InternalMinotorDsl.g:3749:1: ruleBinaryLogicalExpression returns [EObject current=null] : (this_EqualsExpression_0= ruleEqualsExpression | this_EqualsBooleanExpression_1= ruleEqualsBooleanExpression | this_GreaterThanExpression_2= ruleGreaterThanExpression | this_LesserThanExpression_3= ruleLesserThanExpression | this_AndExpression_4= ruleAndExpression | this_OrExpression_5= ruleOrExpression ) ;
    public final EObject ruleBinaryLogicalExpression() throws RecognitionException {
        EObject current = null;

        EObject this_EqualsExpression_0 = null;

        EObject this_EqualsBooleanExpression_1 = null;

        EObject this_GreaterThanExpression_2 = null;

        EObject this_LesserThanExpression_3 = null;

        EObject this_AndExpression_4 = null;

        EObject this_OrExpression_5 = null;



        	enterRule();

        try {
            // InternalMinotorDsl.g:3755:2: ( (this_EqualsExpression_0= ruleEqualsExpression | this_EqualsBooleanExpression_1= ruleEqualsBooleanExpression | this_GreaterThanExpression_2= ruleGreaterThanExpression | this_LesserThanExpression_3= ruleLesserThanExpression | this_AndExpression_4= ruleAndExpression | this_OrExpression_5= ruleOrExpression ) )
            // InternalMinotorDsl.g:3756:2: (this_EqualsExpression_0= ruleEqualsExpression | this_EqualsBooleanExpression_1= ruleEqualsBooleanExpression | this_GreaterThanExpression_2= ruleGreaterThanExpression | this_LesserThanExpression_3= ruleLesserThanExpression | this_AndExpression_4= ruleAndExpression | this_OrExpression_5= ruleOrExpression )
            {
            // InternalMinotorDsl.g:3756:2: (this_EqualsExpression_0= ruleEqualsExpression | this_EqualsBooleanExpression_1= ruleEqualsBooleanExpression | this_GreaterThanExpression_2= ruleGreaterThanExpression | this_LesserThanExpression_3= ruleLesserThanExpression | this_AndExpression_4= ruleAndExpression | this_OrExpression_5= ruleOrExpression )
            int alt88=6;
            alt88 = dfa88.predict(input);
            switch (alt88) {
                case 1 :
                    // InternalMinotorDsl.g:3757:3: this_EqualsExpression_0= ruleEqualsExpression
                    {

                    			newCompositeNode(grammarAccess.getBinaryLogicalExpressionAccess().getEqualsExpressionParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_EqualsExpression_0=ruleEqualsExpression();

                    state._fsp--;


                    			current = this_EqualsExpression_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalMinotorDsl.g:3766:3: this_EqualsBooleanExpression_1= ruleEqualsBooleanExpression
                    {

                    			newCompositeNode(grammarAccess.getBinaryLogicalExpressionAccess().getEqualsBooleanExpressionParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_EqualsBooleanExpression_1=ruleEqualsBooleanExpression();

                    state._fsp--;


                    			current = this_EqualsBooleanExpression_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalMinotorDsl.g:3775:3: this_GreaterThanExpression_2= ruleGreaterThanExpression
                    {

                    			newCompositeNode(grammarAccess.getBinaryLogicalExpressionAccess().getGreaterThanExpressionParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_GreaterThanExpression_2=ruleGreaterThanExpression();

                    state._fsp--;


                    			current = this_GreaterThanExpression_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalMinotorDsl.g:3784:3: this_LesserThanExpression_3= ruleLesserThanExpression
                    {

                    			newCompositeNode(grammarAccess.getBinaryLogicalExpressionAccess().getLesserThanExpressionParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_LesserThanExpression_3=ruleLesserThanExpression();

                    state._fsp--;


                    			current = this_LesserThanExpression_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalMinotorDsl.g:3793:3: this_AndExpression_4= ruleAndExpression
                    {

                    			newCompositeNode(grammarAccess.getBinaryLogicalExpressionAccess().getAndExpressionParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_AndExpression_4=ruleAndExpression();

                    state._fsp--;


                    			current = this_AndExpression_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 6 :
                    // InternalMinotorDsl.g:3802:3: this_OrExpression_5= ruleOrExpression
                    {

                    			newCompositeNode(grammarAccess.getBinaryLogicalExpressionAccess().getOrExpressionParserRuleCall_5());
                    		
                    pushFollow(FOLLOW_2);
                    this_OrExpression_5=ruleOrExpression();

                    state._fsp--;


                    			current = this_OrExpression_5;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBinaryLogicalExpression"


    // $ANTLR start "entryRuleAndExpression"
    // InternalMinotorDsl.g:3814:1: entryRuleAndExpression returns [EObject current=null] : iv_ruleAndExpression= ruleAndExpression EOF ;
    public final EObject entryRuleAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndExpression = null;


        try {
            // InternalMinotorDsl.g:3814:54: (iv_ruleAndExpression= ruleAndExpression EOF )
            // InternalMinotorDsl.g:3815:2: iv_ruleAndExpression= ruleAndExpression EOF
            {
             newCompositeNode(grammarAccess.getAndExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAndExpression=ruleAndExpression();

            state._fsp--;

             current =iv_ruleAndExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAndExpression"


    // $ANTLR start "ruleAndExpression"
    // InternalMinotorDsl.g:3821:1: ruleAndExpression returns [EObject current=null] : (otherlv_0= 'and' otherlv_1= '(' ( (lv_lhs_2_0= ruleLogicalExpression ) ) otherlv_3= ',' ( (lv_rhs_4_0= ruleLogicalExpression ) ) otherlv_5= ')' ) ;
    public final EObject ruleAndExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_lhs_2_0 = null;

        EObject lv_rhs_4_0 = null;



        	enterRule();

        try {
            // InternalMinotorDsl.g:3827:2: ( (otherlv_0= 'and' otherlv_1= '(' ( (lv_lhs_2_0= ruleLogicalExpression ) ) otherlv_3= ',' ( (lv_rhs_4_0= ruleLogicalExpression ) ) otherlv_5= ')' ) )
            // InternalMinotorDsl.g:3828:2: (otherlv_0= 'and' otherlv_1= '(' ( (lv_lhs_2_0= ruleLogicalExpression ) ) otherlv_3= ',' ( (lv_rhs_4_0= ruleLogicalExpression ) ) otherlv_5= ')' )
            {
            // InternalMinotorDsl.g:3828:2: (otherlv_0= 'and' otherlv_1= '(' ( (lv_lhs_2_0= ruleLogicalExpression ) ) otherlv_3= ',' ( (lv_rhs_4_0= ruleLogicalExpression ) ) otherlv_5= ')' )
            // InternalMinotorDsl.g:3829:3: otherlv_0= 'and' otherlv_1= '(' ( (lv_lhs_2_0= ruleLogicalExpression ) ) otherlv_3= ',' ( (lv_rhs_4_0= ruleLogicalExpression ) ) otherlv_5= ')'
            {
            otherlv_0=(Token)match(input,54,FOLLOW_37); 

            			newLeafNode(otherlv_0, grammarAccess.getAndExpressionAccess().getAndKeyword_0());
            		
            otherlv_1=(Token)match(input,39,FOLLOW_76); 

            			newLeafNode(otherlv_1, grammarAccess.getAndExpressionAccess().getLeftParenthesisKeyword_1());
            		
            // InternalMinotorDsl.g:3837:3: ( (lv_lhs_2_0= ruleLogicalExpression ) )
            // InternalMinotorDsl.g:3838:4: (lv_lhs_2_0= ruleLogicalExpression )
            {
            // InternalMinotorDsl.g:3838:4: (lv_lhs_2_0= ruleLogicalExpression )
            // InternalMinotorDsl.g:3839:5: lv_lhs_2_0= ruleLogicalExpression
            {

            					newCompositeNode(grammarAccess.getAndExpressionAccess().getLhsLogicalExpressionParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_38);
            lv_lhs_2_0=ruleLogicalExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAndExpressionRule());
            					}
            					set(
            						current,
            						"lhs",
            						lv_lhs_2_0,
            						"hu.bme.mit.dipterv.text.MinotorDsl.LogicalExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,40,FOLLOW_76); 

            			newLeafNode(otherlv_3, grammarAccess.getAndExpressionAccess().getCommaKeyword_3());
            		
            // InternalMinotorDsl.g:3860:3: ( (lv_rhs_4_0= ruleLogicalExpression ) )
            // InternalMinotorDsl.g:3861:4: (lv_rhs_4_0= ruleLogicalExpression )
            {
            // InternalMinotorDsl.g:3861:4: (lv_rhs_4_0= ruleLogicalExpression )
            // InternalMinotorDsl.g:3862:5: lv_rhs_4_0= ruleLogicalExpression
            {

            					newCompositeNode(grammarAccess.getAndExpressionAccess().getRhsLogicalExpressionParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_39);
            lv_rhs_4_0=ruleLogicalExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAndExpressionRule());
            					}
            					set(
            						current,
            						"rhs",
            						lv_rhs_4_0,
            						"hu.bme.mit.dipterv.text.MinotorDsl.LogicalExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,41,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getAndExpressionAccess().getRightParenthesisKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAndExpression"


    // $ANTLR start "entryRuleOrExpression"
    // InternalMinotorDsl.g:3887:1: entryRuleOrExpression returns [EObject current=null] : iv_ruleOrExpression= ruleOrExpression EOF ;
    public final EObject entryRuleOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrExpression = null;


        try {
            // InternalMinotorDsl.g:3887:53: (iv_ruleOrExpression= ruleOrExpression EOF )
            // InternalMinotorDsl.g:3888:2: iv_ruleOrExpression= ruleOrExpression EOF
            {
             newCompositeNode(grammarAccess.getOrExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOrExpression=ruleOrExpression();

            state._fsp--;

             current =iv_ruleOrExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOrExpression"


    // $ANTLR start "ruleOrExpression"
    // InternalMinotorDsl.g:3894:1: ruleOrExpression returns [EObject current=null] : (otherlv_0= 'or' otherlv_1= '(' ( (lv_lhs_2_0= ruleLogicalExpression ) ) otherlv_3= ',' ( (lv_rhs_4_0= ruleLogicalExpression ) ) otherlv_5= ')' ) ;
    public final EObject ruleOrExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_lhs_2_0 = null;

        EObject lv_rhs_4_0 = null;



        	enterRule();

        try {
            // InternalMinotorDsl.g:3900:2: ( (otherlv_0= 'or' otherlv_1= '(' ( (lv_lhs_2_0= ruleLogicalExpression ) ) otherlv_3= ',' ( (lv_rhs_4_0= ruleLogicalExpression ) ) otherlv_5= ')' ) )
            // InternalMinotorDsl.g:3901:2: (otherlv_0= 'or' otherlv_1= '(' ( (lv_lhs_2_0= ruleLogicalExpression ) ) otherlv_3= ',' ( (lv_rhs_4_0= ruleLogicalExpression ) ) otherlv_5= ')' )
            {
            // InternalMinotorDsl.g:3901:2: (otherlv_0= 'or' otherlv_1= '(' ( (lv_lhs_2_0= ruleLogicalExpression ) ) otherlv_3= ',' ( (lv_rhs_4_0= ruleLogicalExpression ) ) otherlv_5= ')' )
            // InternalMinotorDsl.g:3902:3: otherlv_0= 'or' otherlv_1= '(' ( (lv_lhs_2_0= ruleLogicalExpression ) ) otherlv_3= ',' ( (lv_rhs_4_0= ruleLogicalExpression ) ) otherlv_5= ')'
            {
            otherlv_0=(Token)match(input,71,FOLLOW_37); 

            			newLeafNode(otherlv_0, grammarAccess.getOrExpressionAccess().getOrKeyword_0());
            		
            otherlv_1=(Token)match(input,39,FOLLOW_76); 

            			newLeafNode(otherlv_1, grammarAccess.getOrExpressionAccess().getLeftParenthesisKeyword_1());
            		
            // InternalMinotorDsl.g:3910:3: ( (lv_lhs_2_0= ruleLogicalExpression ) )
            // InternalMinotorDsl.g:3911:4: (lv_lhs_2_0= ruleLogicalExpression )
            {
            // InternalMinotorDsl.g:3911:4: (lv_lhs_2_0= ruleLogicalExpression )
            // InternalMinotorDsl.g:3912:5: lv_lhs_2_0= ruleLogicalExpression
            {

            					newCompositeNode(grammarAccess.getOrExpressionAccess().getLhsLogicalExpressionParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_38);
            lv_lhs_2_0=ruleLogicalExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getOrExpressionRule());
            					}
            					set(
            						current,
            						"lhs",
            						lv_lhs_2_0,
            						"hu.bme.mit.dipterv.text.MinotorDsl.LogicalExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,40,FOLLOW_76); 

            			newLeafNode(otherlv_3, grammarAccess.getOrExpressionAccess().getCommaKeyword_3());
            		
            // InternalMinotorDsl.g:3933:3: ( (lv_rhs_4_0= ruleLogicalExpression ) )
            // InternalMinotorDsl.g:3934:4: (lv_rhs_4_0= ruleLogicalExpression )
            {
            // InternalMinotorDsl.g:3934:4: (lv_rhs_4_0= ruleLogicalExpression )
            // InternalMinotorDsl.g:3935:5: lv_rhs_4_0= ruleLogicalExpression
            {

            					newCompositeNode(grammarAccess.getOrExpressionAccess().getRhsLogicalExpressionParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_39);
            lv_rhs_4_0=ruleLogicalExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getOrExpressionRule());
            					}
            					set(
            						current,
            						"rhs",
            						lv_rhs_4_0,
            						"hu.bme.mit.dipterv.text.MinotorDsl.LogicalExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,41,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getOrExpressionAccess().getRightParenthesisKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOrExpression"


    // $ANTLR start "entryRuleEqualsExpression"
    // InternalMinotorDsl.g:3960:1: entryRuleEqualsExpression returns [EObject current=null] : iv_ruleEqualsExpression= ruleEqualsExpression EOF ;
    public final EObject entryRuleEqualsExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEqualsExpression = null;


        try {
            // InternalMinotorDsl.g:3960:57: (iv_ruleEqualsExpression= ruleEqualsExpression EOF )
            // InternalMinotorDsl.g:3961:2: iv_ruleEqualsExpression= ruleEqualsExpression EOF
            {
             newCompositeNode(grammarAccess.getEqualsExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEqualsExpression=ruleEqualsExpression();

            state._fsp--;

             current =iv_ruleEqualsExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEqualsExpression"


    // $ANTLR start "ruleEqualsExpression"
    // InternalMinotorDsl.g:3967:1: ruleEqualsExpression returns [EObject current=null] : (otherlv_0= 'equals' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ',' ( (lv_rhs_4_0= RULE_NUMBER ) ) otherlv_5= ')' ) ;
    public final EObject ruleEqualsExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_rhs_4_0=null;
        Token otherlv_5=null;


        	enterRule();

        try {
            // InternalMinotorDsl.g:3973:2: ( (otherlv_0= 'equals' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ',' ( (lv_rhs_4_0= RULE_NUMBER ) ) otherlv_5= ')' ) )
            // InternalMinotorDsl.g:3974:2: (otherlv_0= 'equals' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ',' ( (lv_rhs_4_0= RULE_NUMBER ) ) otherlv_5= ')' )
            {
            // InternalMinotorDsl.g:3974:2: (otherlv_0= 'equals' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ',' ( (lv_rhs_4_0= RULE_NUMBER ) ) otherlv_5= ')' )
            // InternalMinotorDsl.g:3975:3: otherlv_0= 'equals' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ',' ( (lv_rhs_4_0= RULE_NUMBER ) ) otherlv_5= ')'
            {
            otherlv_0=(Token)match(input,72,FOLLOW_37); 

            			newLeafNode(otherlv_0, grammarAccess.getEqualsExpressionAccess().getEqualsKeyword_0());
            		
            otherlv_1=(Token)match(input,39,FOLLOW_13); 

            			newLeafNode(otherlv_1, grammarAccess.getEqualsExpressionAccess().getLeftParenthesisKeyword_1());
            		
            // InternalMinotorDsl.g:3983:3: ( (otherlv_2= RULE_ID ) )
            // InternalMinotorDsl.g:3984:4: (otherlv_2= RULE_ID )
            {
            // InternalMinotorDsl.g:3984:4: (otherlv_2= RULE_ID )
            // InternalMinotorDsl.g:3985:5: otherlv_2= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEqualsExpressionRule());
            					}
            				
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_38); 

            					newLeafNode(otherlv_2, grammarAccess.getEqualsExpressionAccess().getLhsParameterCrossReference_2_0());
            				

            }


            }

            otherlv_3=(Token)match(input,40,FOLLOW_58); 

            			newLeafNode(otherlv_3, grammarAccess.getEqualsExpressionAccess().getCommaKeyword_3());
            		
            // InternalMinotorDsl.g:4000:3: ( (lv_rhs_4_0= RULE_NUMBER ) )
            // InternalMinotorDsl.g:4001:4: (lv_rhs_4_0= RULE_NUMBER )
            {
            // InternalMinotorDsl.g:4001:4: (lv_rhs_4_0= RULE_NUMBER )
            // InternalMinotorDsl.g:4002:5: lv_rhs_4_0= RULE_NUMBER
            {
            lv_rhs_4_0=(Token)match(input,RULE_NUMBER,FOLLOW_39); 

            					newLeafNode(lv_rhs_4_0, grammarAccess.getEqualsExpressionAccess().getRhsNUMBERTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEqualsExpressionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"rhs",
            						lv_rhs_4_0,
            						"hu.bme.mit.dipterv.text.MinotorDsl.NUMBER");
            				

            }


            }

            otherlv_5=(Token)match(input,41,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getEqualsExpressionAccess().getRightParenthesisKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEqualsExpression"


    // $ANTLR start "entryRuleEqualsBooleanExpression"
    // InternalMinotorDsl.g:4026:1: entryRuleEqualsBooleanExpression returns [EObject current=null] : iv_ruleEqualsBooleanExpression= ruleEqualsBooleanExpression EOF ;
    public final EObject entryRuleEqualsBooleanExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEqualsBooleanExpression = null;


        try {
            // InternalMinotorDsl.g:4026:64: (iv_ruleEqualsBooleanExpression= ruleEqualsBooleanExpression EOF )
            // InternalMinotorDsl.g:4027:2: iv_ruleEqualsBooleanExpression= ruleEqualsBooleanExpression EOF
            {
             newCompositeNode(grammarAccess.getEqualsBooleanExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEqualsBooleanExpression=ruleEqualsBooleanExpression();

            state._fsp--;

             current =iv_ruleEqualsBooleanExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEqualsBooleanExpression"


    // $ANTLR start "ruleEqualsBooleanExpression"
    // InternalMinotorDsl.g:4033:1: ruleEqualsBooleanExpression returns [EObject current=null] : ( (otherlv_0= 'equals' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ',' ( (lv_rhs_4_0= 'true' ) ) otherlv_5= ')' ) | (otherlv_6= 'equals' otherlv_7= '(' ( (otherlv_8= RULE_ID ) ) otherlv_9= ',' ( (lv_rhs_10_0= 'false' ) ) otherlv_11= ')' ) ) ;
    public final EObject ruleEqualsBooleanExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_rhs_4_0=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token lv_rhs_10_0=null;
        Token otherlv_11=null;


        	enterRule();

        try {
            // InternalMinotorDsl.g:4039:2: ( ( (otherlv_0= 'equals' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ',' ( (lv_rhs_4_0= 'true' ) ) otherlv_5= ')' ) | (otherlv_6= 'equals' otherlv_7= '(' ( (otherlv_8= RULE_ID ) ) otherlv_9= ',' ( (lv_rhs_10_0= 'false' ) ) otherlv_11= ')' ) ) )
            // InternalMinotorDsl.g:4040:2: ( (otherlv_0= 'equals' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ',' ( (lv_rhs_4_0= 'true' ) ) otherlv_5= ')' ) | (otherlv_6= 'equals' otherlv_7= '(' ( (otherlv_8= RULE_ID ) ) otherlv_9= ',' ( (lv_rhs_10_0= 'false' ) ) otherlv_11= ')' ) )
            {
            // InternalMinotorDsl.g:4040:2: ( (otherlv_0= 'equals' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ',' ( (lv_rhs_4_0= 'true' ) ) otherlv_5= ')' ) | (otherlv_6= 'equals' otherlv_7= '(' ( (otherlv_8= RULE_ID ) ) otherlv_9= ',' ( (lv_rhs_10_0= 'false' ) ) otherlv_11= ')' ) )
            int alt89=2;
            int LA89_0 = input.LA(1);

            if ( (LA89_0==72) ) {
                int LA89_1 = input.LA(2);

                if ( (LA89_1==39) ) {
                    int LA89_2 = input.LA(3);

                    if ( (LA89_2==RULE_ID) ) {
                        int LA89_3 = input.LA(4);

                        if ( (LA89_3==40) ) {
                            int LA89_4 = input.LA(5);

                            if ( (LA89_4==27) ) {
                                alt89=1;
                            }
                            else if ( (LA89_4==28) ) {
                                alt89=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 89, 4, input);

                                throw nvae;
                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 89, 3, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 89, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 89, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 89, 0, input);

                throw nvae;
            }
            switch (alt89) {
                case 1 :
                    // InternalMinotorDsl.g:4041:3: (otherlv_0= 'equals' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ',' ( (lv_rhs_4_0= 'true' ) ) otherlv_5= ')' )
                    {
                    // InternalMinotorDsl.g:4041:3: (otherlv_0= 'equals' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ',' ( (lv_rhs_4_0= 'true' ) ) otherlv_5= ')' )
                    // InternalMinotorDsl.g:4042:4: otherlv_0= 'equals' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ',' ( (lv_rhs_4_0= 'true' ) ) otherlv_5= ')'
                    {
                    otherlv_0=(Token)match(input,72,FOLLOW_37); 

                    				newLeafNode(otherlv_0, grammarAccess.getEqualsBooleanExpressionAccess().getEqualsKeyword_0_0());
                    			
                    otherlv_1=(Token)match(input,39,FOLLOW_13); 

                    				newLeafNode(otherlv_1, grammarAccess.getEqualsBooleanExpressionAccess().getLeftParenthesisKeyword_0_1());
                    			
                    // InternalMinotorDsl.g:4050:4: ( (otherlv_2= RULE_ID ) )
                    // InternalMinotorDsl.g:4051:5: (otherlv_2= RULE_ID )
                    {
                    // InternalMinotorDsl.g:4051:5: (otherlv_2= RULE_ID )
                    // InternalMinotorDsl.g:4052:6: otherlv_2= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getEqualsBooleanExpressionRule());
                    						}
                    					
                    otherlv_2=(Token)match(input,RULE_ID,FOLLOW_38); 

                    						newLeafNode(otherlv_2, grammarAccess.getEqualsBooleanExpressionAccess().getLhsParameterCrossReference_0_2_0());
                    					

                    }


                    }

                    otherlv_3=(Token)match(input,40,FOLLOW_77); 

                    				newLeafNode(otherlv_3, grammarAccess.getEqualsBooleanExpressionAccess().getCommaKeyword_0_3());
                    			
                    // InternalMinotorDsl.g:4067:4: ( (lv_rhs_4_0= 'true' ) )
                    // InternalMinotorDsl.g:4068:5: (lv_rhs_4_0= 'true' )
                    {
                    // InternalMinotorDsl.g:4068:5: (lv_rhs_4_0= 'true' )
                    // InternalMinotorDsl.g:4069:6: lv_rhs_4_0= 'true'
                    {
                    lv_rhs_4_0=(Token)match(input,27,FOLLOW_39); 

                    						newLeafNode(lv_rhs_4_0, grammarAccess.getEqualsBooleanExpressionAccess().getRhsTrueKeyword_0_4_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getEqualsBooleanExpressionRule());
                    						}
                    						setWithLastConsumed(current, "rhs", lv_rhs_4_0, "true");
                    					

                    }


                    }

                    otherlv_5=(Token)match(input,41,FOLLOW_2); 

                    				newLeafNode(otherlv_5, grammarAccess.getEqualsBooleanExpressionAccess().getRightParenthesisKeyword_0_5());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMinotorDsl.g:4087:3: (otherlv_6= 'equals' otherlv_7= '(' ( (otherlv_8= RULE_ID ) ) otherlv_9= ',' ( (lv_rhs_10_0= 'false' ) ) otherlv_11= ')' )
                    {
                    // InternalMinotorDsl.g:4087:3: (otherlv_6= 'equals' otherlv_7= '(' ( (otherlv_8= RULE_ID ) ) otherlv_9= ',' ( (lv_rhs_10_0= 'false' ) ) otherlv_11= ')' )
                    // InternalMinotorDsl.g:4088:4: otherlv_6= 'equals' otherlv_7= '(' ( (otherlv_8= RULE_ID ) ) otherlv_9= ',' ( (lv_rhs_10_0= 'false' ) ) otherlv_11= ')'
                    {
                    otherlv_6=(Token)match(input,72,FOLLOW_37); 

                    				newLeafNode(otherlv_6, grammarAccess.getEqualsBooleanExpressionAccess().getEqualsKeyword_1_0());
                    			
                    otherlv_7=(Token)match(input,39,FOLLOW_13); 

                    				newLeafNode(otherlv_7, grammarAccess.getEqualsBooleanExpressionAccess().getLeftParenthesisKeyword_1_1());
                    			
                    // InternalMinotorDsl.g:4096:4: ( (otherlv_8= RULE_ID ) )
                    // InternalMinotorDsl.g:4097:5: (otherlv_8= RULE_ID )
                    {
                    // InternalMinotorDsl.g:4097:5: (otherlv_8= RULE_ID )
                    // InternalMinotorDsl.g:4098:6: otherlv_8= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getEqualsBooleanExpressionRule());
                    						}
                    					
                    otherlv_8=(Token)match(input,RULE_ID,FOLLOW_38); 

                    						newLeafNode(otherlv_8, grammarAccess.getEqualsBooleanExpressionAccess().getLhsParameterCrossReference_1_2_0());
                    					

                    }


                    }

                    otherlv_9=(Token)match(input,40,FOLLOW_78); 

                    				newLeafNode(otherlv_9, grammarAccess.getEqualsBooleanExpressionAccess().getCommaKeyword_1_3());
                    			
                    // InternalMinotorDsl.g:4113:4: ( (lv_rhs_10_0= 'false' ) )
                    // InternalMinotorDsl.g:4114:5: (lv_rhs_10_0= 'false' )
                    {
                    // InternalMinotorDsl.g:4114:5: (lv_rhs_10_0= 'false' )
                    // InternalMinotorDsl.g:4115:6: lv_rhs_10_0= 'false'
                    {
                    lv_rhs_10_0=(Token)match(input,28,FOLLOW_39); 

                    						newLeafNode(lv_rhs_10_0, grammarAccess.getEqualsBooleanExpressionAccess().getRhsFalseKeyword_1_4_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getEqualsBooleanExpressionRule());
                    						}
                    						setWithLastConsumed(current, "rhs", lv_rhs_10_0, "false");
                    					

                    }


                    }

                    otherlv_11=(Token)match(input,41,FOLLOW_2); 

                    				newLeafNode(otherlv_11, grammarAccess.getEqualsBooleanExpressionAccess().getRightParenthesisKeyword_1_5());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEqualsBooleanExpression"


    // $ANTLR start "entryRuleGreaterThanExpression"
    // InternalMinotorDsl.g:4136:1: entryRuleGreaterThanExpression returns [EObject current=null] : iv_ruleGreaterThanExpression= ruleGreaterThanExpression EOF ;
    public final EObject entryRuleGreaterThanExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGreaterThanExpression = null;


        try {
            // InternalMinotorDsl.g:4136:62: (iv_ruleGreaterThanExpression= ruleGreaterThanExpression EOF )
            // InternalMinotorDsl.g:4137:2: iv_ruleGreaterThanExpression= ruleGreaterThanExpression EOF
            {
             newCompositeNode(grammarAccess.getGreaterThanExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleGreaterThanExpression=ruleGreaterThanExpression();

            state._fsp--;

             current =iv_ruleGreaterThanExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGreaterThanExpression"


    // $ANTLR start "ruleGreaterThanExpression"
    // InternalMinotorDsl.g:4143:1: ruleGreaterThanExpression returns [EObject current=null] : (otherlv_0= 'greater' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ',' ( (lv_rhs_4_0= RULE_NUMBER ) ) otherlv_5= ')' ) ;
    public final EObject ruleGreaterThanExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_rhs_4_0=null;
        Token otherlv_5=null;


        	enterRule();

        try {
            // InternalMinotorDsl.g:4149:2: ( (otherlv_0= 'greater' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ',' ( (lv_rhs_4_0= RULE_NUMBER ) ) otherlv_5= ')' ) )
            // InternalMinotorDsl.g:4150:2: (otherlv_0= 'greater' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ',' ( (lv_rhs_4_0= RULE_NUMBER ) ) otherlv_5= ')' )
            {
            // InternalMinotorDsl.g:4150:2: (otherlv_0= 'greater' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ',' ( (lv_rhs_4_0= RULE_NUMBER ) ) otherlv_5= ')' )
            // InternalMinotorDsl.g:4151:3: otherlv_0= 'greater' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ',' ( (lv_rhs_4_0= RULE_NUMBER ) ) otherlv_5= ')'
            {
            otherlv_0=(Token)match(input,73,FOLLOW_37); 

            			newLeafNode(otherlv_0, grammarAccess.getGreaterThanExpressionAccess().getGreaterKeyword_0());
            		
            otherlv_1=(Token)match(input,39,FOLLOW_13); 

            			newLeafNode(otherlv_1, grammarAccess.getGreaterThanExpressionAccess().getLeftParenthesisKeyword_1());
            		
            // InternalMinotorDsl.g:4159:3: ( (otherlv_2= RULE_ID ) )
            // InternalMinotorDsl.g:4160:4: (otherlv_2= RULE_ID )
            {
            // InternalMinotorDsl.g:4160:4: (otherlv_2= RULE_ID )
            // InternalMinotorDsl.g:4161:5: otherlv_2= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getGreaterThanExpressionRule());
            					}
            				
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_38); 

            					newLeafNode(otherlv_2, grammarAccess.getGreaterThanExpressionAccess().getLhsParameterCrossReference_2_0());
            				

            }


            }

            otherlv_3=(Token)match(input,40,FOLLOW_58); 

            			newLeafNode(otherlv_3, grammarAccess.getGreaterThanExpressionAccess().getCommaKeyword_3());
            		
            // InternalMinotorDsl.g:4176:3: ( (lv_rhs_4_0= RULE_NUMBER ) )
            // InternalMinotorDsl.g:4177:4: (lv_rhs_4_0= RULE_NUMBER )
            {
            // InternalMinotorDsl.g:4177:4: (lv_rhs_4_0= RULE_NUMBER )
            // InternalMinotorDsl.g:4178:5: lv_rhs_4_0= RULE_NUMBER
            {
            lv_rhs_4_0=(Token)match(input,RULE_NUMBER,FOLLOW_39); 

            					newLeafNode(lv_rhs_4_0, grammarAccess.getGreaterThanExpressionAccess().getRhsNUMBERTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getGreaterThanExpressionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"rhs",
            						lv_rhs_4_0,
            						"hu.bme.mit.dipterv.text.MinotorDsl.NUMBER");
            				

            }


            }

            otherlv_5=(Token)match(input,41,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getGreaterThanExpressionAccess().getRightParenthesisKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGreaterThanExpression"


    // $ANTLR start "entryRuleLesserThanExpression"
    // InternalMinotorDsl.g:4202:1: entryRuleLesserThanExpression returns [EObject current=null] : iv_ruleLesserThanExpression= ruleLesserThanExpression EOF ;
    public final EObject entryRuleLesserThanExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLesserThanExpression = null;


        try {
            // InternalMinotorDsl.g:4202:61: (iv_ruleLesserThanExpression= ruleLesserThanExpression EOF )
            // InternalMinotorDsl.g:4203:2: iv_ruleLesserThanExpression= ruleLesserThanExpression EOF
            {
             newCompositeNode(grammarAccess.getLesserThanExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLesserThanExpression=ruleLesserThanExpression();

            state._fsp--;

             current =iv_ruleLesserThanExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLesserThanExpression"


    // $ANTLR start "ruleLesserThanExpression"
    // InternalMinotorDsl.g:4209:1: ruleLesserThanExpression returns [EObject current=null] : (otherlv_0= 'lesser' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ',' ( (lv_rhs_4_0= RULE_NUMBER ) ) otherlv_5= ')' ) ;
    public final EObject ruleLesserThanExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_rhs_4_0=null;
        Token otherlv_5=null;


        	enterRule();

        try {
            // InternalMinotorDsl.g:4215:2: ( (otherlv_0= 'lesser' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ',' ( (lv_rhs_4_0= RULE_NUMBER ) ) otherlv_5= ')' ) )
            // InternalMinotorDsl.g:4216:2: (otherlv_0= 'lesser' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ',' ( (lv_rhs_4_0= RULE_NUMBER ) ) otherlv_5= ')' )
            {
            // InternalMinotorDsl.g:4216:2: (otherlv_0= 'lesser' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ',' ( (lv_rhs_4_0= RULE_NUMBER ) ) otherlv_5= ')' )
            // InternalMinotorDsl.g:4217:3: otherlv_0= 'lesser' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ',' ( (lv_rhs_4_0= RULE_NUMBER ) ) otherlv_5= ')'
            {
            otherlv_0=(Token)match(input,74,FOLLOW_37); 

            			newLeafNode(otherlv_0, grammarAccess.getLesserThanExpressionAccess().getLesserKeyword_0());
            		
            otherlv_1=(Token)match(input,39,FOLLOW_13); 

            			newLeafNode(otherlv_1, grammarAccess.getLesserThanExpressionAccess().getLeftParenthesisKeyword_1());
            		
            // InternalMinotorDsl.g:4225:3: ( (otherlv_2= RULE_ID ) )
            // InternalMinotorDsl.g:4226:4: (otherlv_2= RULE_ID )
            {
            // InternalMinotorDsl.g:4226:4: (otherlv_2= RULE_ID )
            // InternalMinotorDsl.g:4227:5: otherlv_2= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLesserThanExpressionRule());
            					}
            				
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_38); 

            					newLeafNode(otherlv_2, grammarAccess.getLesserThanExpressionAccess().getLhsParameterCrossReference_2_0());
            				

            }


            }

            otherlv_3=(Token)match(input,40,FOLLOW_58); 

            			newLeafNode(otherlv_3, grammarAccess.getLesserThanExpressionAccess().getCommaKeyword_3());
            		
            // InternalMinotorDsl.g:4242:3: ( (lv_rhs_4_0= RULE_NUMBER ) )
            // InternalMinotorDsl.g:4243:4: (lv_rhs_4_0= RULE_NUMBER )
            {
            // InternalMinotorDsl.g:4243:4: (lv_rhs_4_0= RULE_NUMBER )
            // InternalMinotorDsl.g:4244:5: lv_rhs_4_0= RULE_NUMBER
            {
            lv_rhs_4_0=(Token)match(input,RULE_NUMBER,FOLLOW_39); 

            					newLeafNode(lv_rhs_4_0, grammarAccess.getLesserThanExpressionAccess().getRhsNUMBERTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLesserThanExpressionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"rhs",
            						lv_rhs_4_0,
            						"hu.bme.mit.dipterv.text.MinotorDsl.NUMBER");
            				

            }


            }

            otherlv_5=(Token)match(input,41,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getLesserThanExpressionAccess().getRightParenthesisKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLesserThanExpression"


    // $ANTLR start "entryRuleUnaryLogicalExpression"
    // InternalMinotorDsl.g:4268:1: entryRuleUnaryLogicalExpression returns [EObject current=null] : iv_ruleUnaryLogicalExpression= ruleUnaryLogicalExpression EOF ;
    public final EObject entryRuleUnaryLogicalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryLogicalExpression = null;


        try {
            // InternalMinotorDsl.g:4268:63: (iv_ruleUnaryLogicalExpression= ruleUnaryLogicalExpression EOF )
            // InternalMinotorDsl.g:4269:2: iv_ruleUnaryLogicalExpression= ruleUnaryLogicalExpression EOF
            {
             newCompositeNode(grammarAccess.getUnaryLogicalExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleUnaryLogicalExpression=ruleUnaryLogicalExpression();

            state._fsp--;

             current =iv_ruleUnaryLogicalExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUnaryLogicalExpression"


    // $ANTLR start "ruleUnaryLogicalExpression"
    // InternalMinotorDsl.g:4275:1: ruleUnaryLogicalExpression returns [EObject current=null] : this_NotLogicalExpression_0= ruleNotLogicalExpression ;
    public final EObject ruleUnaryLogicalExpression() throws RecognitionException {
        EObject current = null;

        EObject this_NotLogicalExpression_0 = null;



        	enterRule();

        try {
            // InternalMinotorDsl.g:4281:2: (this_NotLogicalExpression_0= ruleNotLogicalExpression )
            // InternalMinotorDsl.g:4282:2: this_NotLogicalExpression_0= ruleNotLogicalExpression
            {

            		newCompositeNode(grammarAccess.getUnaryLogicalExpressionAccess().getNotLogicalExpressionParserRuleCall());
            	
            pushFollow(FOLLOW_2);
            this_NotLogicalExpression_0=ruleNotLogicalExpression();

            state._fsp--;


            		current = this_NotLogicalExpression_0;
            		afterParserOrEnumRuleCall();
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnaryLogicalExpression"


    // $ANTLR start "entryRuleNotLogicalExpression"
    // InternalMinotorDsl.g:4293:1: entryRuleNotLogicalExpression returns [EObject current=null] : iv_ruleNotLogicalExpression= ruleNotLogicalExpression EOF ;
    public final EObject entryRuleNotLogicalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNotLogicalExpression = null;


        try {
            // InternalMinotorDsl.g:4293:61: (iv_ruleNotLogicalExpression= ruleNotLogicalExpression EOF )
            // InternalMinotorDsl.g:4294:2: iv_ruleNotLogicalExpression= ruleNotLogicalExpression EOF
            {
             newCompositeNode(grammarAccess.getNotLogicalExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNotLogicalExpression=ruleNotLogicalExpression();

            state._fsp--;

             current =iv_ruleNotLogicalExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNotLogicalExpression"


    // $ANTLR start "ruleNotLogicalExpression"
    // InternalMinotorDsl.g:4300:1: ruleNotLogicalExpression returns [EObject current=null] : (otherlv_0= 'not' otherlv_1= '(' ( (lv_operand_2_0= ruleLogicalExpression ) ) otherlv_3= ')' ) ;
    public final EObject ruleNotLogicalExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_operand_2_0 = null;



        	enterRule();

        try {
            // InternalMinotorDsl.g:4306:2: ( (otherlv_0= 'not' otherlv_1= '(' ( (lv_operand_2_0= ruleLogicalExpression ) ) otherlv_3= ')' ) )
            // InternalMinotorDsl.g:4307:2: (otherlv_0= 'not' otherlv_1= '(' ( (lv_operand_2_0= ruleLogicalExpression ) ) otherlv_3= ')' )
            {
            // InternalMinotorDsl.g:4307:2: (otherlv_0= 'not' otherlv_1= '(' ( (lv_operand_2_0= ruleLogicalExpression ) ) otherlv_3= ')' )
            // InternalMinotorDsl.g:4308:3: otherlv_0= 'not' otherlv_1= '(' ( (lv_operand_2_0= ruleLogicalExpression ) ) otherlv_3= ')'
            {
            otherlv_0=(Token)match(input,53,FOLLOW_37); 

            			newLeafNode(otherlv_0, grammarAccess.getNotLogicalExpressionAccess().getNotKeyword_0());
            		
            otherlv_1=(Token)match(input,39,FOLLOW_76); 

            			newLeafNode(otherlv_1, grammarAccess.getNotLogicalExpressionAccess().getLeftParenthesisKeyword_1());
            		
            // InternalMinotorDsl.g:4316:3: ( (lv_operand_2_0= ruleLogicalExpression ) )
            // InternalMinotorDsl.g:4317:4: (lv_operand_2_0= ruleLogicalExpression )
            {
            // InternalMinotorDsl.g:4317:4: (lv_operand_2_0= ruleLogicalExpression )
            // InternalMinotorDsl.g:4318:5: lv_operand_2_0= ruleLogicalExpression
            {

            					newCompositeNode(grammarAccess.getNotLogicalExpressionAccess().getOperandLogicalExpressionParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_39);
            lv_operand_2_0=ruleLogicalExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getNotLogicalExpressionRule());
            					}
            					set(
            						current,
            						"operand",
            						lv_operand_2_0,
            						"hu.bme.mit.dipterv.text.MinotorDsl.LogicalExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,41,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getNotLogicalExpressionAccess().getRightParenthesisKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNotLogicalExpression"


    // $ANTLR start "entryRulePar"
    // InternalMinotorDsl.g:4343:1: entryRulePar returns [EObject current=null] : iv_rulePar= rulePar EOF ;
    public final EObject entryRulePar() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePar = null;


        try {
            // InternalMinotorDsl.g:4343:44: (iv_rulePar= rulePar EOF )
            // InternalMinotorDsl.g:4344:2: iv_rulePar= rulePar EOF
            {
             newCompositeNode(grammarAccess.getParRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePar=rulePar();

            state._fsp--;

             current =iv_rulePar; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePar"


    // $ANTLR start "rulePar"
    // InternalMinotorDsl.g:4350:1: rulePar returns [EObject current=null] : (otherlv_0= 'par' otherlv_1= '{' ( (lv_parexpression_2_0= ruleParExpression ) )* otherlv_3= '}' ) ;
    public final EObject rulePar() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_parexpression_2_0 = null;



        	enterRule();

        try {
            // InternalMinotorDsl.g:4356:2: ( (otherlv_0= 'par' otherlv_1= '{' ( (lv_parexpression_2_0= ruleParExpression ) )* otherlv_3= '}' ) )
            // InternalMinotorDsl.g:4357:2: (otherlv_0= 'par' otherlv_1= '{' ( (lv_parexpression_2_0= ruleParExpression ) )* otherlv_3= '}' )
            {
            // InternalMinotorDsl.g:4357:2: (otherlv_0= 'par' otherlv_1= '{' ( (lv_parexpression_2_0= ruleParExpression ) )* otherlv_3= '}' )
            // InternalMinotorDsl.g:4358:3: otherlv_0= 'par' otherlv_1= '{' ( (lv_parexpression_2_0= ruleParExpression ) )* otherlv_3= '}'
            {
            otherlv_0=(Token)match(input,75,FOLLOW_16); 

            			newLeafNode(otherlv_0, grammarAccess.getParAccess().getParKeyword_0());
            		
            otherlv_1=(Token)match(input,14,FOLLOW_79); 

            			newLeafNode(otherlv_1, grammarAccess.getParAccess().getLeftCurlyBracketKeyword_1());
            		
            // InternalMinotorDsl.g:4366:3: ( (lv_parexpression_2_0= ruleParExpression ) )*
            loop90:
            do {
                int alt90=2;
                int LA90_0 = input.LA(1);

                if ( (LA90_0==76) ) {
                    alt90=1;
                }


                switch (alt90) {
            	case 1 :
            	    // InternalMinotorDsl.g:4367:4: (lv_parexpression_2_0= ruleParExpression )
            	    {
            	    // InternalMinotorDsl.g:4367:4: (lv_parexpression_2_0= ruleParExpression )
            	    // InternalMinotorDsl.g:4368:5: lv_parexpression_2_0= ruleParExpression
            	    {

            	    					newCompositeNode(grammarAccess.getParAccess().getParexpressionParExpressionParserRuleCall_2_0());
            	    				
            	    pushFollow(FOLLOW_79);
            	    lv_parexpression_2_0=ruleParExpression();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getParRule());
            	    					}
            	    					add(
            	    						current,
            	    						"parexpression",
            	    						lv_parexpression_2_0,
            	    						"hu.bme.mit.dipterv.text.MinotorDsl.ParExpression");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop90;
                }
            } while (true);

            otherlv_3=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getParAccess().getRightCurlyBracketKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePar"


    // $ANTLR start "entryRuleParExpression"
    // InternalMinotorDsl.g:4393:1: entryRuleParExpression returns [EObject current=null] : iv_ruleParExpression= ruleParExpression EOF ;
    public final EObject entryRuleParExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParExpression = null;


        try {
            // InternalMinotorDsl.g:4393:54: (iv_ruleParExpression= ruleParExpression EOF )
            // InternalMinotorDsl.g:4394:2: iv_ruleParExpression= ruleParExpression EOF
            {
             newCompositeNode(grammarAccess.getParExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleParExpression=ruleParExpression();

            state._fsp--;

             current =iv_ruleParExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParExpression"


    // $ANTLR start "ruleParExpression"
    // InternalMinotorDsl.g:4400:1: ruleParExpression returns [EObject current=null] : (otherlv_0= 'case' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_messages_3_0= ruleMessage ) )* otherlv_4= '}' ) ;
    public final EObject ruleParExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_messages_3_0 = null;



        	enterRule();

        try {
            // InternalMinotorDsl.g:4406:2: ( (otherlv_0= 'case' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_messages_3_0= ruleMessage ) )* otherlv_4= '}' ) )
            // InternalMinotorDsl.g:4407:2: (otherlv_0= 'case' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_messages_3_0= ruleMessage ) )* otherlv_4= '}' )
            {
            // InternalMinotorDsl.g:4407:2: (otherlv_0= 'case' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_messages_3_0= ruleMessage ) )* otherlv_4= '}' )
            // InternalMinotorDsl.g:4408:3: otherlv_0= 'case' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_messages_3_0= ruleMessage ) )* otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,76,FOLLOW_13); 

            			newLeafNode(otherlv_0, grammarAccess.getParExpressionAccess().getCaseKeyword_0());
            		
            // InternalMinotorDsl.g:4412:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMinotorDsl.g:4413:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMinotorDsl.g:4413:4: (lv_name_1_0= RULE_ID )
            // InternalMinotorDsl.g:4414:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_16); 

            					newLeafNode(lv_name_1_0, grammarAccess.getParExpressionAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getParExpressionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,14,FOLLOW_74); 

            			newLeafNode(otherlv_2, grammarAccess.getParExpressionAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalMinotorDsl.g:4434:3: ( (lv_messages_3_0= ruleMessage ) )*
            loop91:
            do {
                int alt91=2;
                int LA91_0 = input.LA(1);

                if ( (LA91_0==44) ) {
                    alt91=1;
                }


                switch (alt91) {
            	case 1 :
            	    // InternalMinotorDsl.g:4435:4: (lv_messages_3_0= ruleMessage )
            	    {
            	    // InternalMinotorDsl.g:4435:4: (lv_messages_3_0= ruleMessage )
            	    // InternalMinotorDsl.g:4436:5: lv_messages_3_0= ruleMessage
            	    {

            	    					newCompositeNode(grammarAccess.getParExpressionAccess().getMessagesMessageParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_74);
            	    lv_messages_3_0=ruleMessage();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getParExpressionRule());
            	    					}
            	    					add(
            	    						current,
            	    						"messages",
            	    						lv_messages_3_0,
            	    						"hu.bme.mit.dipterv.text.MinotorDsl.Message");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop91;
                }
            } while (true);

            otherlv_4=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getParExpressionAccess().getRightCurlyBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParExpression"


    // $ANTLR start "entryRuleLoop"
    // InternalMinotorDsl.g:4461:1: entryRuleLoop returns [EObject current=null] : iv_ruleLoop= ruleLoop EOF ;
    public final EObject entryRuleLoop() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLoop = null;


        try {
            // InternalMinotorDsl.g:4461:45: (iv_ruleLoop= ruleLoop EOF )
            // InternalMinotorDsl.g:4462:2: iv_ruleLoop= ruleLoop EOF
            {
             newCompositeNode(grammarAccess.getLoopRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLoop=ruleLoop();

            state._fsp--;

             current =iv_ruleLoop; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLoop"


    // $ANTLR start "ruleLoop"
    // InternalMinotorDsl.g:4468:1: ruleLoop returns [EObject current=null] : (otherlv_0= 'loop' otherlv_1= '(' ( (lv_min_2_0= RULE_NUMBER ) ) otherlv_3= ',' ( (lv_max_4_0= RULE_NUMBER ) ) otherlv_5= ')' otherlv_6= '{' ( (lv_messages_7_0= ruleMessage ) )* otherlv_8= '}' ) ;
    public final EObject ruleLoop() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_min_2_0=null;
        Token otherlv_3=null;
        Token lv_max_4_0=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        EObject lv_messages_7_0 = null;



        	enterRule();

        try {
            // InternalMinotorDsl.g:4474:2: ( (otherlv_0= 'loop' otherlv_1= '(' ( (lv_min_2_0= RULE_NUMBER ) ) otherlv_3= ',' ( (lv_max_4_0= RULE_NUMBER ) ) otherlv_5= ')' otherlv_6= '{' ( (lv_messages_7_0= ruleMessage ) )* otherlv_8= '}' ) )
            // InternalMinotorDsl.g:4475:2: (otherlv_0= 'loop' otherlv_1= '(' ( (lv_min_2_0= RULE_NUMBER ) ) otherlv_3= ',' ( (lv_max_4_0= RULE_NUMBER ) ) otherlv_5= ')' otherlv_6= '{' ( (lv_messages_7_0= ruleMessage ) )* otherlv_8= '}' )
            {
            // InternalMinotorDsl.g:4475:2: (otherlv_0= 'loop' otherlv_1= '(' ( (lv_min_2_0= RULE_NUMBER ) ) otherlv_3= ',' ( (lv_max_4_0= RULE_NUMBER ) ) otherlv_5= ')' otherlv_6= '{' ( (lv_messages_7_0= ruleMessage ) )* otherlv_8= '}' )
            // InternalMinotorDsl.g:4476:3: otherlv_0= 'loop' otherlv_1= '(' ( (lv_min_2_0= RULE_NUMBER ) ) otherlv_3= ',' ( (lv_max_4_0= RULE_NUMBER ) ) otherlv_5= ')' otherlv_6= '{' ( (lv_messages_7_0= ruleMessage ) )* otherlv_8= '}'
            {
            otherlv_0=(Token)match(input,77,FOLLOW_37); 

            			newLeafNode(otherlv_0, grammarAccess.getLoopAccess().getLoopKeyword_0());
            		
            otherlv_1=(Token)match(input,39,FOLLOW_58); 

            			newLeafNode(otherlv_1, grammarAccess.getLoopAccess().getLeftParenthesisKeyword_1());
            		
            // InternalMinotorDsl.g:4484:3: ( (lv_min_2_0= RULE_NUMBER ) )
            // InternalMinotorDsl.g:4485:4: (lv_min_2_0= RULE_NUMBER )
            {
            // InternalMinotorDsl.g:4485:4: (lv_min_2_0= RULE_NUMBER )
            // InternalMinotorDsl.g:4486:5: lv_min_2_0= RULE_NUMBER
            {
            lv_min_2_0=(Token)match(input,RULE_NUMBER,FOLLOW_38); 

            					newLeafNode(lv_min_2_0, grammarAccess.getLoopAccess().getMinNUMBERTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLoopRule());
            					}
            					setWithLastConsumed(
            						current,
            						"min",
            						lv_min_2_0,
            						"hu.bme.mit.dipterv.text.MinotorDsl.NUMBER");
            				

            }


            }

            otherlv_3=(Token)match(input,40,FOLLOW_58); 

            			newLeafNode(otherlv_3, grammarAccess.getLoopAccess().getCommaKeyword_3());
            		
            // InternalMinotorDsl.g:4506:3: ( (lv_max_4_0= RULE_NUMBER ) )
            // InternalMinotorDsl.g:4507:4: (lv_max_4_0= RULE_NUMBER )
            {
            // InternalMinotorDsl.g:4507:4: (lv_max_4_0= RULE_NUMBER )
            // InternalMinotorDsl.g:4508:5: lv_max_4_0= RULE_NUMBER
            {
            lv_max_4_0=(Token)match(input,RULE_NUMBER,FOLLOW_39); 

            					newLeafNode(lv_max_4_0, grammarAccess.getLoopAccess().getMaxNUMBERTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLoopRule());
            					}
            					setWithLastConsumed(
            						current,
            						"max",
            						lv_max_4_0,
            						"hu.bme.mit.dipterv.text.MinotorDsl.NUMBER");
            				

            }


            }

            otherlv_5=(Token)match(input,41,FOLLOW_16); 

            			newLeafNode(otherlv_5, grammarAccess.getLoopAccess().getRightParenthesisKeyword_5());
            		
            otherlv_6=(Token)match(input,14,FOLLOW_74); 

            			newLeafNode(otherlv_6, grammarAccess.getLoopAccess().getLeftCurlyBracketKeyword_6());
            		
            // InternalMinotorDsl.g:4532:3: ( (lv_messages_7_0= ruleMessage ) )*
            loop92:
            do {
                int alt92=2;
                int LA92_0 = input.LA(1);

                if ( (LA92_0==44) ) {
                    alt92=1;
                }


                switch (alt92) {
            	case 1 :
            	    // InternalMinotorDsl.g:4533:4: (lv_messages_7_0= ruleMessage )
            	    {
            	    // InternalMinotorDsl.g:4533:4: (lv_messages_7_0= ruleMessage )
            	    // InternalMinotorDsl.g:4534:5: lv_messages_7_0= ruleMessage
            	    {

            	    					newCompositeNode(grammarAccess.getLoopAccess().getMessagesMessageParserRuleCall_7_0());
            	    				
            	    pushFollow(FOLLOW_74);
            	    lv_messages_7_0=ruleMessage();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getLoopRule());
            	    					}
            	    					add(
            	    						current,
            	    						"messages",
            	    						lv_messages_7_0,
            	    						"hu.bme.mit.dipterv.text.MinotorDsl.Message");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop92;
                }
            } while (true);

            otherlv_8=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_8, grammarAccess.getLoopAccess().getRightCurlyBracketKeyword_8());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLoop"


    // $ANTLR start "ruleType"
    // InternalMinotorDsl.g:4559:1: ruleType returns [Enumerator current=null] : ( (enumLiteral_0= 'integer' ) | (enumLiteral_1= 'float' ) | (enumLiteral_2= 'bool' ) | (enumLiteral_3= 'string' ) ) ;
    public final Enumerator ruleType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalMinotorDsl.g:4565:2: ( ( (enumLiteral_0= 'integer' ) | (enumLiteral_1= 'float' ) | (enumLiteral_2= 'bool' ) | (enumLiteral_3= 'string' ) ) )
            // InternalMinotorDsl.g:4566:2: ( (enumLiteral_0= 'integer' ) | (enumLiteral_1= 'float' ) | (enumLiteral_2= 'bool' ) | (enumLiteral_3= 'string' ) )
            {
            // InternalMinotorDsl.g:4566:2: ( (enumLiteral_0= 'integer' ) | (enumLiteral_1= 'float' ) | (enumLiteral_2= 'bool' ) | (enumLiteral_3= 'string' ) )
            int alt93=4;
            switch ( input.LA(1) ) {
            case 78:
                {
                alt93=1;
                }
                break;
            case 22:
                {
                alt93=2;
                }
                break;
            case 79:
                {
                alt93=3;
                }
                break;
            case 23:
                {
                alt93=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 93, 0, input);

                throw nvae;
            }

            switch (alt93) {
                case 1 :
                    // InternalMinotorDsl.g:4567:3: (enumLiteral_0= 'integer' )
                    {
                    // InternalMinotorDsl.g:4567:3: (enumLiteral_0= 'integer' )
                    // InternalMinotorDsl.g:4568:4: enumLiteral_0= 'integer'
                    {
                    enumLiteral_0=(Token)match(input,78,FOLLOW_2); 

                    				current = grammarAccess.getTypeAccess().getIntegerEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getTypeAccess().getIntegerEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMinotorDsl.g:4575:3: (enumLiteral_1= 'float' )
                    {
                    // InternalMinotorDsl.g:4575:3: (enumLiteral_1= 'float' )
                    // InternalMinotorDsl.g:4576:4: enumLiteral_1= 'float'
                    {
                    enumLiteral_1=(Token)match(input,22,FOLLOW_2); 

                    				current = grammarAccess.getTypeAccess().getFloatEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getTypeAccess().getFloatEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalMinotorDsl.g:4583:3: (enumLiteral_2= 'bool' )
                    {
                    // InternalMinotorDsl.g:4583:3: (enumLiteral_2= 'bool' )
                    // InternalMinotorDsl.g:4584:4: enumLiteral_2= 'bool'
                    {
                    enumLiteral_2=(Token)match(input,79,FOLLOW_2); 

                    				current = grammarAccess.getTypeAccess().getBoolEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getTypeAccess().getBoolEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalMinotorDsl.g:4591:3: (enumLiteral_3= 'string' )
                    {
                    // InternalMinotorDsl.g:4591:3: (enumLiteral_3= 'string' )
                    // InternalMinotorDsl.g:4592:4: enumLiteral_3= 'string'
                    {
                    enumLiteral_3=(Token)match(input,23,FOLLOW_2); 

                    				current = grammarAccess.getTypeAccess().getStringEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getTypeAccess().getStringEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleType"

    // Delegated rules


    protected DFA51 dfa51 = new DFA51(this);
    protected DFA60 dfa60 = new DFA60(this);
    protected DFA88 dfa88 = new DFA88(this);
    static final String dfa_1s = "\43\uffff";
    static final String dfa_2s = "\2\4\1\uffff\1\4\1\uffff\3\4\1\uffff\6\7\1\36\2\17\6\7\1\17\1\4\1\17\1\36\6\7\1\17";
    static final String dfa_3s = "\2\65\1\uffff\1\65\1\uffff\1\47\2\4\1\uffff\6\7\1\43\1\32\1\66\6\7\1\64\1\4\1\64\1\43\6\7\1\64";
    static final String dfa_4s = "\2\uffff\1\2\1\uffff\1\1\3\uffff\1\1\32\uffff";
    static final String dfa_5s = "\43\uffff}>";
    static final String[] dfa_6s = {
            "\1\2\11\uffff\1\1\1\2\12\uffff\1\2\14\uffff\1\2\13\uffff\3\2",
            "\1\3\12\uffff\1\10\12\uffff\1\2\14\uffff\1\6\1\4\13\uffff\1\7\1\5",
            "",
            "\1\10\12\uffff\1\10\16\uffff\1\11\1\12\1\13\1\14\1\15\1\16\3\uffff\1\10\1\4\13\uffff\2\10",
            "",
            "\1\17\42\uffff\1\6",
            "\1\17",
            "\1\20",
            "",
            "\1\21",
            "\1\21",
            "\1\21",
            "\1\21",
            "\1\21",
            "\1\21",
            "\1\22\1\23\1\24\1\25\1\26\1\27",
            "\1\10\12\uffff\1\2",
            "\1\10\12\uffff\1\2\15\uffff\1\10\1\30\12\uffff\1\7\1\uffff\1\31",
            "\1\32",
            "\1\32",
            "\1\32",
            "\1\32",
            "\1\32",
            "\1\32",
            "\1\10\12\uffff\1\2\15\uffff\1\10\13\uffff\1\7",
            "\1\33",
            "\1\10\12\uffff\1\2\15\uffff\1\10\1\30\12\uffff\1\7",
            "\1\34\1\35\1\36\1\37\1\40\1\41",
            "\1\42",
            "\1\42",
            "\1\42",
            "\1\42",
            "\1\42",
            "\1\42",
            "\1\10\12\uffff\1\2\15\uffff\1\10\13\uffff\1\7"
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final char[] dfa_2 = DFA.unpackEncodedStringToUnsignedChars(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final short[] dfa_4 = DFA.unpackEncodedString(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[][] dfa_6 = unpackEncodedStringArray(dfa_6s);

    class DFA51 extends DFA {

        public DFA51(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 51;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "1727:3: (otherlv_14= '{' ( (otherlv_15= RULE_ID ) )? (otherlv_16= ',' )? ( (lv_constraintexp_17_0= ruleClockConstraintExpression ) )? (otherlv_18= ',' )? ( (lv_resetinconstraint_19_0= ruleResetClock ) )? otherlv_20= '}' )?";
        }
    }
    static final String dfa_7s = "\13\uffff";
    static final String dfa_8s = "\11\uffff\1\1\1\uffff";
    static final String dfa_9s = "\1\4\1\uffff\1\36\6\7\1\17\1\uffff";
    static final String dfa_10s = "\1\65\1\uffff\1\43\6\7\1\66\1\uffff";
    static final String dfa_11s = "\1\uffff\1\1\10\uffff\1\2";
    static final String dfa_12s = "\13\uffff}>";
    static final String[] dfa_13s = {
            "\1\2\42\uffff\1\1\15\uffff\1\1",
            "",
            "\1\3\1\4\1\5\1\6\1\7\1\10",
            "\1\11",
            "\1\11",
            "\1\11",
            "\1\11",
            "\1\11",
            "\1\11",
            "\1\1\12\uffff\1\1\15\uffff\2\1\12\uffff\1\1\1\uffff\1\12",
            ""
    };

    static final short[] dfa_7 = DFA.unpackEncodedString(dfa_7s);
    static final short[] dfa_8 = DFA.unpackEncodedString(dfa_8s);
    static final char[] dfa_9 = DFA.unpackEncodedStringToUnsignedChars(dfa_9s);
    static final char[] dfa_10 = DFA.unpackEncodedStringToUnsignedChars(dfa_10s);
    static final short[] dfa_11 = DFA.unpackEncodedString(dfa_11s);
    static final short[] dfa_12 = DFA.unpackEncodedString(dfa_12s);
    static final short[][] dfa_13 = unpackEncodedStringArray(dfa_13s);

    class DFA60 extends DFA {

        public DFA60(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 60;
            this.eot = dfa_7;
            this.eof = dfa_8;
            this.min = dfa_9;
            this.max = dfa_10;
            this.accept = dfa_11;
            this.special = dfa_12;
            this.transition = dfa_13;
        }
        public String getDescription() {
            return "1991:2: ( ( ( (lv_not_0_0= 'not' ) )? (otherlv_1= '(' )? ( (lv_lclockconstraint_2_0= ruleClockConstraint ) ) (otherlv_3= ')' )? ) | ( ( (lv_lclockconstraint_4_0= ruleClockConstraint ) ) otherlv_5= 'and' ( (lv_rclockconstraint_6_0= ruleClockConstraint ) ) ) )";
        }
    }
    static final String dfa_14s = "\1\66\1\47\4\uffff\1\4\1\50\1\7\2\uffff";
    static final String dfa_15s = "\1\112\1\47\4\uffff\1\4\1\50\1\34\2\uffff";
    static final String dfa_16s = "\2\uffff\1\3\1\4\1\5\1\6\3\uffff\1\1\1\2";
    static final String[] dfa_17s = {
            "\1\4\20\uffff\1\5\1\1\1\2\1\3",
            "\1\6",
            "",
            "",
            "",
            "",
            "\1\7",
            "\1\10",
            "\1\11\23\uffff\2\12",
            "",
            ""
    };
    static final char[] dfa_14 = DFA.unpackEncodedStringToUnsignedChars(dfa_14s);
    static final char[] dfa_15 = DFA.unpackEncodedStringToUnsignedChars(dfa_15s);
    static final short[] dfa_16 = DFA.unpackEncodedString(dfa_16s);
    static final short[][] dfa_17 = unpackEncodedStringArray(dfa_17s);

    class DFA88 extends DFA {

        public DFA88(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 88;
            this.eot = dfa_7;
            this.eof = dfa_7;
            this.min = dfa_14;
            this.max = dfa_15;
            this.accept = dfa_16;
            this.special = dfa_12;
            this.transition = dfa_17;
        }
        public String getDescription() {
            return "3756:2: (this_EqualsExpression_0= ruleEqualsExpression | this_EqualsBooleanExpression_1= ruleEqualsBooleanExpression | this_GreaterThanExpression_2= ruleGreaterThanExpression | this_LesserThanExpression_3= ruleLesserThanExpression | this_AndExpression_4= ruleAndExpression | this_OrExpression_5= ruleOrExpression )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000080000CDC012L,0x000000000000C038L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000080000CDC002L,0x000000000000C038L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000080000CD8002L,0x000000000000C038L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000080000CC8002L,0x000000000000C038L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000080000C88002L,0x000000000000C038L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000080000C08002L,0x000000000000C038L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000080000C08002L,0x000000000000C028L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000080000008002L,0x0000000000000028L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000080000008002L,0x0000000000000020L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000080000008002L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000005000008000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000004000008000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000042000008000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000040000008000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000001E00010L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000001C00010L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000001800010L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000001000010L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x000000001E0000E0L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x000000001C0000E0L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000FD80000E0L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000F980000E0L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000F180000E0L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000E180000E0L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000C180000E0L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x00000008180000E0L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x00000000180000E0L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000000108000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000020008000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x3D80100000008000L,0x0000000000002843L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x00000300180000F0L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000E00000000010L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000C00000000010L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000800000000010L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x003E00800400C010L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x003C00800400C010L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x003800800400C010L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0030018000008010L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0010010000008000L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0010000000008000L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x003000800400C010L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0030008004008010L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0010000004008000L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0010000004000000L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000000FC0000000L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0020008000000010L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0000E00004000000L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0000C00004000000L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0000800004000000L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0000030000000010L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0000020000000010L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x00000300180000E0L});
    public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x00000200180000E0L});
    public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_71 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_72 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_73 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_74 = new BitSet(new long[]{0x0000100000008000L});
    public static final BitSet FOLLOW_75 = new BitSet(new long[]{0x0000008000000002L});
    public static final BitSet FOLLOW_76 = new BitSet(new long[]{0x0060000000000000L,0x0000000000000780L});
    public static final BitSet FOLLOW_77 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_78 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_79 = new BitSet(new long[]{0x0000000000008000L,0x0000000000001000L});

}