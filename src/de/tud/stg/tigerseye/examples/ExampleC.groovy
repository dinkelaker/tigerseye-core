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
package de.tud.stg.tigerseye.examples;

import de.tud.stg.tigerseye.DSL; 
import de.tud.stg.tigerseye.Interpreter;
import de.tud.stg.tigerseye.examples.ExampleA;

/**
 * An example language embedding that defines every different expression types.
 * @author Tom Dinkelaker
 */
public class ExampleC extends ExampleA implements DSL {
    
    public int keyword3() {
    	return 3;
    }
    
}
