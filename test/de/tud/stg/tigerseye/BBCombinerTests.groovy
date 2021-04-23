//////////////////////////////////////////////////////////////////////////
//// Copyright 2009-2015, Technische Universitaet Darmstadt (TUD), Germany
////
//// The TUD licenses this file to you under the Apache License, Version 2.0 (the
//// "License"); you may not use this file except in compliance
//// with the License.  You may obtain a copy of the License at
////
////  http://www.apache.org/licenses/LICENSE-2.0
////
//// Unless required by applicable law or agreed to in writing,
//// software distributed under the License is distributed on an
//// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
//// KIND, either express or implied.  See the License for the
//// specific language governing permissions and limitations
//// under the License.
/////////////////////////////////////////////////////////////////////////////////
package de.tud.stg.tigerseye;

import groovy.lang.Closure;
import groovy.lang.MissingMethodException;
import junit.framework.TestCase 
import org.junit.Before
import org.junit.Test

import de.tud.stg.tigerseye.*;
import de.tud.stg.tigerseye.examples.*;

import de.tud.stg.tigerseye.exceptions.SyntaxConflictException;

/**
 * @author Tom Dinkelaker
 *
 */
public class BBCombinerTests extends TestCase {
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	void setUp() throws Exception{
	}

	@Test
	void testBBCombinerDisjoint() {
		DSL composedDsl = new BlackBoxCombiner(new BaseLanguageA(),new BaseLanguageB());
		composedDsl.eval {
	    	// A DSL PROGRAM - BEGIN
	    	
	    	assert (keyword1() + keyword2()) == 3

	    	// A DSL PROGRAM - END
	    }

	    println "disjoint no conflicts had to be detected"
	    
	    //Thread.currentThread().sleep(1000);
	}
	
	@Test
	void testBBCombinerWithNoConflictBecauseSameInstance() {
		DSL constituentDsl = new BaseLanguageA();
		DSL composedDsl = new BlackBoxCombiner(constituentDsl,constituentDsl);

	    composedDsl.eval {
	    	// A DSL PROGRAM - BEGIN
	    	
	    	assert (keyword1() + keyword1()) == 2

	    	// A DSL PROGRAM - END
	    }
	    
	    println "disjoint no conflicts had to be detected"
	}
	
	@Test
	void testBBCombinerWithConflict() {
		DSL composedDsl 
		try {
			composedDsl = new BlackBoxCombiner(new BaseLanguageA(),new BaseLanguageA());
		    assert false; //should not be reached, if the undefined syntax conflict was detected correctly
	    } catch (SyntaxConflictException sce) {
		    //ignore since detected error was correctly
	        println "syntax conflict detected correctly"
	    }
	}
	
	@Test
	void testBBCombinerWithConflictByInheritance() {
		DSL composedDsl 
		try {
			composedDsl = new BlackBoxCombiner(new BaseLanguageA(),new CLanguageExtensionForA());
		    assert false; //should not be reached, if the undefined syntax conflict was detected correctly
	    } catch (SyntaxConflictException sce) {
		    //ignore since detected error was correctly
	        println "syntax conflict with inherited keyword detected correctly"
	    }
	    
	    //Thread.currentThread().sleep(1000);
	}
	
	@Test(expected = RuntimeException.class)
	void testCannotCombineLanguageWithItself() {
		def baseLangA = new BaseLanguageA()
		new BlackBoxCombiner(baseLangA, baseLangA);
	}
	
	@Test(expected = RuntimeException.class)
	void testCannotCombineLanguageWithItself3Times() {
		def baseLangA = new BaseLanguageA()
		new BlackBoxCombiner(baseLangA, baseLangA, baseLangA);
	}
	
	@Test(expected = RuntimeException.class)
	void testCannotCombineLanguageWithItself4Times() {
		def baseLangA = new BaseLanguageA()
		new BlackBoxCombiner(baseLangA, baseLangA, baseLangA, baseLangA);
	}
	
	@Test(expected = RuntimeException.class)
	void testCannotCombineLanguageWithItselfNTimes() {
		def baseLangA = new BaseLanguageA()
		new BlackBoxCombiner([baseLangA, baseLangA, baseLangA, baseLangA, baseLangA, baseLangA]);
	}
	

}
