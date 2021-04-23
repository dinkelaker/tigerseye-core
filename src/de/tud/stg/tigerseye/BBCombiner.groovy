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

import de.tud.stg.tigerseye.exceptions.DSLException
import java.util.Map;
import java.util.Set;

public class BBCombiner extends BlackBoxCombiner {

	public BBCombiner(DSL... dslDefinitions) {
		super(dslDefinitions);
	}

	public BBCombiner(DSL dslDefinition, Map<String, Object> context) {
		super(dslDefinition, context);
	}

	public BBCombiner(DSL dslDefinition1, DSL dslDefinition2,
			Map<String, Object> context) {
		super(dslDefinition1, dslDefinition2, context);
		if (dslDefinition1.is(dslDefinition2)) throw new DSLException(Messages.DSL_NOT_UNIQUE);
	}

	public BBCombiner(DSL dslDefinition1, DSL dslDefinition2, 
		DSL dslDefinition3, Map<String, Object> context) {
		super([dslDefinition1, dslDefinition2, dslDefinition3] as Set, context);
	}

	public BBCombiner(DSL dslDefinition1, DSL dslDefinition2, 
		DSL dslDefinition3, DSL dslDefinition4,
		Map<String, Object> context) {
		super([dslDefinition1, dslDefinition2, dslDefinition3, dslDefinition4] as Set, context);
	}

	public BBCombiner(Set<DSL> dslDefinitions) {
		super(dslDefinitions);
	}

	public BBCombiner(Set<DSL> dslDefinitions, Map<String, Object> context) {
		super(dslDefinitions, context);
	}

	public BBCombiner(List<DSL> dslDefinitions) {
		//Black-box composition only accepts sets, so we need to convert it 
		super(dslDefinitions as Set);
	}

	public BBCombiner(List<DSL> dslDefinitions, Map<String, Object> context) {
		//Black-box composition only accepts sets, so we need to convert it 
		super(dslDefinitions as Set, context);
	}

}
