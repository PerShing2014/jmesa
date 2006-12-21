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
package org.jmesa.core.match;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * <p>
 * Able to match up values based on a class type, table id and column property.
 * The class type is required. The table id is optional and is used to match up 
 * to a more specific filter. The column property is optional and is also used 
 * to match up to a more specific filter.
 * </p>  
 * 
 * <p>
 * For instance you could just register a class type, such as a Date, and use 
 * that across all tables. However, if you have a custom date to handle for 
 * a specific table and/or specific column property than you could specify 
 * the id and/or property value. 
 * </p>
 * 
 * @since 2.0
 * @author Jeff Johnston
 */
public class MatchKey {
	private final Class type;
	private final String id;
	private final String property;
	
	/**
	 * The more generic constructor. 
	 * 
	 * @param type
	 */
	public MatchKey(Class type) {
		this(type, null, null);
	}
	
	/**
	 * The second most generic constructor.
	 * 
	 * @param id
	 * @param type
	 */
	public MatchKey(Class type, String id) {
		this(type, id, null);
	}
	
	/**
	 * The most specific constructor.
	 * 
	 * @param id
	 * @param property
	 * @param type
	 */
	public MatchKey(Class type, String id, String property) {
		this.type = type;
		this.id = id;
		this.property = property;
	}

	public String getId() {
		return id;
	}

	public String getProperty() {
		return property;
	}

	public Class getType() {
		return type;
	}

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;

        if (!(o instanceof MatchKey))
            return false;

        MatchKey that = (MatchKey) o;
        
        return new EqualsBuilder()
        			.append(getType(), that.getType())
        			.append(getId(), that.getId())
        			.append(getProperty(), that.getProperty())
        			.isEquals();
    }
    
    @Override
    public int hashCode() {
    	return new HashCodeBuilder(17, 37)
        			.append(getType())
			        .append(getId())
			        .append(getProperty())
			        .toHashCode();
    }
    
    @Override
    public String toString() {
    	return new ToStringBuilder(this)
    				.append("type", getType())
	        		.append("id", getId())
	        		.append("property", getProperty())
	        		.toString();
    }
	
}
