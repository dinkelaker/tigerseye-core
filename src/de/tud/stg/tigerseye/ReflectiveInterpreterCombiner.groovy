///////////////////////////////////////////////////////////////////////////////
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
package de.tud.stg.tigerseye;

import org.codehaus.groovy.runtime.InvokerHelper;
import de.tud.stg.tigerseye.exceptions.DSLException
import groovy.lang.Closure;

/**
 * A InterpreterCombiner that combines the results of several interpreter operations
 * using a closure that gets passed the method objects for the current DSL element (under interpretation)  
 * from all combined DSL interpreters (i.e., each domain operations as a first-class GroovyMethod)
 * The passed DSL elements then can be executed by the closure.
 */
public class ReflectiveInterpreterCombiner extends InterpreterCombiner {
	
	private final boolean DEBUG = false;

	/**
	 * The reflectiveZipWithClosure must define the following parameters:
	 * <code>
	 *   Closure cl = { name, args, dslElements ->
     *     ...
	 *   }
	 * </code>
	 * @param name         The name of the currently invoked domain element.
	 * @param args         The arguments of a method call (is null for properties).
	 * @param dslElements  A list of all methods that are defined in the combined interpreters.
	 */
	protected Closure reflectiveZipWithClosure;
	
	public ReflectiveInterpreterCombiner(DSL dslDefinition, Closure reflectiveZipWithClosure, Object context) {
		super(dslDefinition,context);
		this.reflectiveZipWithClosure = reflectiveZipWithClosure;
	} 
	
	public ReflectiveInterpreterCombiner(Set<DSL> dslDefinitions, Closure reflectiveZipWithClosure, Object context) {
		super(dslDefinitions,context);
		this.reflectiveZipWithClosure = reflectiveZipWithClosure;
	} 
	
	public ReflectiveInterpreterCombiner(DSL dslDefinition1, DSL dslDefinition2, Closure reflectiveZipWithClosure, Object context) {
		super(new LinkedList(),context);
		dslDefinitions.add(dslDefinition1);
		dslDefinitions.add(dslDefinition2);		
		this.reflectiveZipWithClosure = reflectiveZipWithClosure;
	} 
	
	public Object eval(Closure dslClosure) {
		/** @todo ReflectiveInterpreterCombiner was not specialized yet. */
		throw new IllegalStateException("Not yet implemented/specialized.")
		dslClosure.setResolveStrategy(Closure.DELEGATE_FIRST); //Closure.DELEGATE_FIRST enables writing into properties defined by DSLs and prevent the creation of a local variable
		dslClosure.setDelegate(this);
		return dslClosure.call();
	}
	
    public Object methodMissing(String name, Object args) {
    	if (DEBUG) System.our.println("ReflectiveInterpreterCombiner: methodMissing $name $args ");
        List dslElements = new LinkedList();
    	try {
		    return DSLInvoker.zipMethodOnDslDefs(dslDefinitions,zipWithClosure,name,args);
        } catch (MissingMethodException e1) {
            if (DEBUG) println "ReflectiveInterpreterCombiner: methodMissing $name $args ";
            throw new MissingMethodException(name,this.class,args);
        }  catch (Exception e2) {
          if (DEBUG) println "ReflectiveInterpreterCombiner: error in the implementation of a DSL operation (keyword=$name,args=$args).";
          if (DEBUG) println "--- ERROR IN THE DSL IMPLEMENTATION ---"
          if (DEBUG) e2.printStackTrace();
          if (DEBUG) println "---------------------------------------"
          throw new DSLException("Error in the implementation of a DSL operation (keyword=$name,args=$args).",e2);
        }
	}
    
    public void propertyMissing(String name, value) { 
		if (DEBUG) println "ReflectiveInterpreterCombiner: propertyMissing $name $value";
    	internalContext[name] = value 
    }
    
    public Object propertyMissing(String name) { 
		if (DEBUG) println "ZipWithDSL: propertyMissing $name ";
		Object result = null;
		Iterator it = dslDefinitions.iterator();
		if (DEBUG && (!it.hasNext())) println "ZipWithDSL: empty DSL list";
		try {
			Object dsl = it.next();
			if (DEBUG) println "ZipWithDSL: getting propertyMissing $name from "+dsl;
			return result = DSLInvoker.zipPropertyOnDslDefs().getProperty(dsl,name);
		} catch (Exception e1) {
			throw new MissingPropertyException(name,this.class);
		}
    }
    
}
