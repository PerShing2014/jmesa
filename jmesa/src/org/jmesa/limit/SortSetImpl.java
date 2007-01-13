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
package org.jmesa.limit;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * <p>
 * The SortSet is an Collection of Sort objects. A Sort contains a bean property
 * and the sort order. Or, in other words, it is simply the column that the user
 * is trying to sort in the correct order.
 * </p>
 * 
 * @since 2.0
 * @author Jeff Johnston
 */
public class SortSetImpl implements Serializable, SortSet {
    private static Log logger = LogFactory.getLog(SortSetImpl.class);
    private List<Sort> sorts;

    public SortSetImpl() {
        sorts = new ArrayList<Sort>();
    }

    /**
     * @return Is true if there are any columns that need to be sorted.
     */
    public boolean isSorted() {
        return sorts != null && !sorts.isEmpty();
    }

    /**
     * @return The Set of Sort objects.
     */
    public Collection<Sort> getSorts() {
        return sorts;
    }

    /**
     * For a given property, retrieve the Sort.
     * 
     * @param property
     *            The Sort property.
     * @return The Sort object.
     */
    public Sort getSort(String property) {
        for (Iterator iter = sorts.iterator(); iter.hasNext();) {
            Sort sort = (Sort) iter.next();
            if (sort.getProperty().equals(property)) {
                return sort;
            }
        }

        return null;
    }

    /**
     * For a given property, retrieve the Sort Order.
     * 
     * @param property
     *            The Sort property.
     * @return The Sort Order.
     */
    public Order getSortOrder(String property) {
        return getSort(property).getOrder();
    }

    /**
     * <p>
     * The Sort to add to the set in the given postion.
     * </p>
     * 
     * @param property
     *            The column property to sort.
     * @param order
     *            The order to sort the column.
     */
    public void addSort(int position, String property, Order order) {
        addSort(new Sort(position, property, order));
    }

    /**
     * <p>
     * The Sort to add to the set. Will also set the sort position to be when
     * the sort was added.
     * </p>
     * 
     * <p>
     * For example if there is already a Sort in the set then calling this
     * method will add a Sort to the end. If you need to include a Sort in a
     * given position of the Set then call the other convenience method that
     * includes the position.
     * </p>
     * 
     * @param property
     *            The column property to sort.
     * @param order
     *            The order to sort the column.
     */
    public void addSort(String property, Order order) {
        addSort(new Sort(sorts.size(), property, order));
    }

    /**
     * @param sort
     *            The Sort to add to the set.
     */
    public void addSort(Sort sort) {
        if (!sorts.contains(sort)) {
            sorts.add(sort);
            Collections.sort(sorts);
            if (logger.isDebugEnabled()) {
                logger.debug("Added Sort: " + sort.toString());
            }
        }
    }

    @Override
    public String toString() {
        ToStringBuilder builder = new ToStringBuilder(this);

        if (sorts != null) {
            for (Iterator iter = sorts.iterator(); iter.hasNext();) {
                Sort sort = (Sort) iter.next();
                builder.append(sort.toString());
            }
        }

        return builder.toString();
    }
}
