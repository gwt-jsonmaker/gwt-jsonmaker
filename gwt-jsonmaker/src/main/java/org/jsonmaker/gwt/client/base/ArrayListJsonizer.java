/*
 * Copyright 2007 Andr�s Adolfo Testi < andres.a.testi AT gmail.com >
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.jsonmaker.gwt.client.base;

import java.util.ArrayList;
import java.util.Collection;

import org.jsonmaker.gwt.client.Jsonizer;

/**
 * Translates objects of type java.util.ArrayList.
 * 
 * @author Gaurav Saxena<gsaxena81@gmail.com> 
 * Credited to Andr�s Adolfo Testi
 *
 */
public class ArrayListJsonizer extends CollectionJsonizer{
	
	/**
	 * Constructs a new ArrayListJsonizer
	 * 
	 * @param elemJsonizer jsonizer for inner elements
	 */
	public ArrayListJsonizer(Jsonizer elemJsonizer) {
		super(elemJsonizer);
	}
 
	@SuppressWarnings("rawtypes")
	protected Collection createCollection() {
		return new ArrayList();
	}
	
}
