package hu.bme.mit.dipterv.text.generator

import hu.bme.mit.dipterv.text.minotorDsl.ClockConstraint
import hu.bme.mit.dipterv.text.minotorDsl.GreaterEqualClockConstraint
import hu.bme.mit.dipterv.text.minotorDsl.SmallerClockConstraint
import hu.bme.mit.dipterv.text.minotorDsl.GreaterClockConstraint
import hu.bme.mit.dipterv.text.minotorDsl.SmallerEqualClockConstraint
import hu.bme.mit.dipterv.text.minotorDsl.ClockConstraintExpression
import hu.bme.mit.dipterv.text.minotorDsl.NotClockConstraintExpression
import hu.bme.mit.dipterv.text.minotorDsl.AndClockConstraintExpression

class ClockConstraintGenerator {
	def compile_clockConstraint(ClockConstraint c)
	'''«c.generateClockConstraint»'''
	
	def dispatch generateClockConstraint(GreaterClockConstraint c)
	'''«c.clock.name» > «c.constant»'''
	
	def dispatch generateClockConstraint(SmallerClockConstraint c)
	'''«c.clock.name» < «c.constant»'''
	
	def dispatch generateClockConstraint(GreaterEqualClockConstraint c)
	'''«c.clock.name» >= «c.constant»'''
	
	def dispatch generateClockConstraint(SmallerEqualClockConstraint c)
	'''«c.clock.name» <= «c.constant»'''
	
	def compile_ClockConstraintExpression(ClockConstraintExpression ce)
	'''(«ce.compile_clockConstraintName») -> «ce.generateClockConstraintExpression»'''
	
	def dispatch generateClockConstraintExpression(ClockConstraint c)
	'''«c.compile_clockConstraint»'''
	
	def dispatch generateClockConstraintExpression(NotClockConstraintExpression ce)
	'''!«ce.notClockConstraint.compile_clockConstraint»'''
	
	def dispatch generateClockConstraintExpression(AndClockConstraintExpression ce)
	'''«ce.lclockconstraint.compile_clockConstraint» && «ce.rclockconstraint.compile_clockConstraint»'''
	
	def compile_Pre(ClockConstraintExpression ce)
	'''(«ce.compile_clockConstraintName») -> «ce.generatePre»'''
	
	def dispatch generatePre(ClockConstraint c)
	'''«c.clock.name» < «c.constant»'''
	
	def dispatch generatePre(NotClockConstraintExpression ce)
	'''!(«ce.notClockConstraint.clock.name» < «ce.notClockConstraint.constant»)'''
	
	def dispatch generatePre(AndClockConstraintExpression ce)
	'''«IF Integer::parseInt(ce.lclockconstraint.constant) < Integer::parseInt(ce.rclockconstraint.constant)»
		«ce.lclockconstraint.clock.name» < «ce.lclockconstraint.constant»
		«ELSE»«ce.rclockconstraint.clock.name» < «ce.rclockconstraint.constant»«ENDIF»
	'''
	
	def compile_Succ(ClockConstraintExpression ce)
	'''(«ce.compile_clockConstraintName») -> «ce.generateSucc»'''
	
	def dispatch generateSucc(ClockConstraint c)
	'''«c.clock.name» > «c.constant»'''
	
	def dispatch generateSucc(NotClockConstraintExpression ce)
	'''!(«ce.notClockConstraint.clock.name» > «ce.notClockConstraint.constant»)'''
	
	def dispatch generateSucc(AndClockConstraintExpression ce)
	'''«IF Integer::parseInt(ce.lclockconstraint.constant) > Integer::parseInt(ce.rclockconstraint.constant)»
	   «ce.lclockconstraint.clock.name» > «ce.lclockconstraint.constant»
	   «ELSE»«ce.rclockconstraint.clock.name» > «ce.rclockconstraint.constant»«ENDIF»
	'''
	
	def compile_clockConstraintName(ClockConstraintExpression ce)
	'''«ce.generateClockConstraintName»'''
	
	def dispatch generateClockConstraintName(ClockConstraint c)
	'''«c.clock.name»'''
	
	def dispatch generateClockConstraintName(NotClockConstraintExpression ce)
	'''«ce.notClockConstraint.clock.name»'''
	
	def dispatch generateClockConstraintName(AndClockConstraintExpression ce)
	'''«ce.lclockconstraint.clock.name»'''
}