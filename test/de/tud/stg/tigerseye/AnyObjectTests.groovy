package de.tud.stg.tigerseye////////////////////////////////////////////////////////////////////////
// Copyright 2009-2015, Technische Universitaet Darmstadt (TUD), Germany
//
// The TUD licenses this file to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
//
//  http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.
///////////////////////////////////////////////////////////////////////////////
//package de.tud.stg.tigerseye.tests;
//
//import org.junit.Before;
//import org.junit.Test;
//
//import junit.framework.TestCase;
//import junit.framework.Assert;//
//import de.tud.stg.tigerseye.*;
//import de.tud.stg.tigerseye.exceptions.UndefinedIdentifierException;
//
///**
// * @author Tom Dinkelaker
// *
// */
//public class TestAnyObject extends TestCase {
//	
//	/**
//	 * @throws java.lang.Exception
//	 */
//	@Before
//	void setUp() throws Exception{
//		
//	}
//
//	
//	@Test
//	void testAnyObject() {
//		def o = new AnyObject();
//		o.hello();
//		o.goodbye();
//	}
//	
//	@Test
//	void testConcreteObject() {
//		try {
//		    def o = new Object();
//		    o.hello();
//		    asssert false == "should not been reached, since hello() is not defined"
//		    o.goodbye();
//		} catch (MissingMethodException mme) {
//			//missing methods correctly detected
//		}
//	}
//	
//	
//}
