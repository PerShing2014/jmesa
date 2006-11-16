/*
 * Copyright 2004 original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jmesa.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

import static org.junit.Assert.*;

import org.junit.Test;


import org.apache.commons.beanutils.BeanComparator;
import org.apache.commons.collections.comparators.ComparatorChain;
import org.apache.commons.collections.comparators.NullComparator;
import org.apache.commons.collections.comparators.ReverseComparator;

public class ComparatorTest {
	@Test
	public void go() {
//		List<BeanComparator> sortFields = new ArrayList<BeanComparator>();
//		sortFields.add(new NullSafeBeanComparator("name", new NullComparator()));
//		sortFields.add(new NullSafeBeanComparator("zipCode", new ReverseComparator(new NullComparator())));
//		ComparatorChain multiSort = new ComparatorChain(sortFields);
		
		ComparatorChain compChain = new ComparatorChain();
		compChain.addComparator(new BeanComparator("name"));
		compChain.addComparator(new BeanComparator("zipCode"), true);
		
		
        Vector entries = new Vector();
        entries.add(new MyClass("Robert", 34547));
        entries.add(new MyClass("Albert", 57334));
        entries.add(new MyClass("Robert", 78425));

        
        Collections.sort(entries, compChain);
        
        assertNotNull(entries);
		
		

//			ComparatorChain compChain = new ComparatorChain();
//        compChain.addComparator(new MyClassNameComparator());
//        compChain.addComparator(new MyClassZipCodeComparator(), true);

        // let's sort a Vector

        // this will sort the Vector by the chain comparator's order
		
	}
	
	
	public class MyClass {
	    protected String name;
	    protected int zipCode;

	    public MyClass(String name, int zipCode) {
	        this.name = name;
	        this.zipCode = zipCode;
	    }
	    public String getName() {
	        return name;
	    }
	    public int getZipCode() {
	        return zipCode;
	    }

	    public String toString() {
	        return name + ":" + zipCode;
	    }

	}
}
