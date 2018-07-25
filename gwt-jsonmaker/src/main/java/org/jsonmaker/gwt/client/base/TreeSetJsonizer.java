/*
 * Copyright 2007 Gaurav Saxena&lt;gsaxena81@gmail.com&gt; < gsaxena81 AT gmail DOT com>
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

import java.util.Collection;
import java.util.TreeSet;

import org.jsonmaker.gwt.client.Jsonizer;

/**
 * 
 * @author Gaurav Saxena&lt;gsaxena81@gmail.com&gt; 
 * Credited to Andr�s Adolfo Testi
 *
 */
public class TreeSetJsonizer extends CollectionJsonizer {
	
	/**
	 * Constructs a new LinkedHashSetJsonizer
	 * 
	 * @param elemJsonizer jsonizer for inner elements
	 */
	public TreeSetJsonizer(Jsonizer elemJsonizer) {
		super(elemJsonizer);
	}
	protected Collection createCollection() {
		return new TreeSet();
	}	
}