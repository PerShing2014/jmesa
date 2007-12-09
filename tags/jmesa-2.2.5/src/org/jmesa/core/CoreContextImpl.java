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
package org.jmesa.core;

import java.util.Collection;

import org.jmesa.core.message.Messages;
import org.jmesa.core.preference.Preferences;
import org.jmesa.limit.Limit;
import org.jmesa.worksheet.state.WorksheetState;

/**
 * <p>
 * The CoreContext encapsulates the core package and is used to Filter and Sort the items. It also
 * gives easy access to the Preferences and Messages as well as a reference to the Limit.
 * </p>
 * 
 * @since 2.0
 * @author Jeff Johnston
 */
public class CoreContextImpl implements CoreContext {
    private Items items;
    private Limit limit;
    private Preferences preferences;
    private Messages messages;
    private WorksheetState worksheetState;
    private boolean editable;

    public CoreContextImpl(Items items, Limit limit, Preferences preferences, Messages messages) {
        this.items = items;
        this.limit = limit;
        this.preferences = preferences;
        this.messages = messages;
    }

    public Collection<?> getAllItems() {
        return items.getAllItems();
    }

    public Collection<?> getFilteredItems() {
        return items.getFilteredItems();
    }

    public Collection<?> getSortedItems() {
        return items.getSortedItems();
    }

    public Collection<?> getPageItems() {
        return items.getPageItems();
    }
    
    public void setPageItems(Collection<?> pageItems) {
        this.items.setPageItems(pageItems);
    }

    public String getMessage(String code) {
        return messages.getMessage(code);
    }

    public String getMessage(String code, Object[] args) {
        return messages.getMessage(code, args);
    }

    public String getPreference(String code) {
        return preferences.getPreference(code);
    }

    public WorksheetState getWorksheetState() {
        return worksheetState;
    }
    
    public void setWorksheetState(WorksheetState worksheetState) {
        this.worksheetState = worksheetState;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    public Limit getLimit() {
        return limit;
    }
}
