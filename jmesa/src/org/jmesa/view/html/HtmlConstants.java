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
package org.jmesa.view.html;

/**
 * @since 2.0
 * @author Jeff Johnston
 */
public class HtmlConstants {
    private HtmlConstants() {
    }

    public final static String IMAGES_PATH = "html.imagesPath";
    public final static String TOOLBAR_MAX_ROWS_DROPLIST_INCREMENTS = "html.toolbar.maxRowsDroplist.increments";

    // table
    public final static String TABLE_RENDERER_STYLE_CLASS = "html.table.renderer.styleClass";
    public final static String TABLE_COMPONENT_THEME = "html.table.component.theme";

    // row
    public final static String ROW_RENDERER_HIGHLIGHT_CLASS = "html.row.renderer.highlightClass";
    public final static String ROW_RENDERER_EVEN_CLASS = "html.row.renderer.evenClass";
    public final static String ROW_RENDERER_ODD_CLASS = "html.row.renderer.oddClass";

    // column
    public final static String COLUMN_RENDERER_HEADER_STYLE_CLASS = "html.column.header.renderer.styleClass";

    public final static String SORT_ASC_IMAGE = "html.column.header.renderer.image.sortAsc";
    public final static String SORT_DESC_IMAGE = "html.column.header.renderer.image.sortDesc";

    // css names
    public final static String TBODY_CLASS = "html.tbodyClass";
    public final static String TITLE_CLASS = "html.titleClass";
    public final static String FILTER_CLASS = "html.filterClass";
    public final static String TOOLBAR_CLASS = "html.toolbarClass";
    public final static String STATUS_BAR_CLASS = "html.statusBarClass";

    // toolbar image names
    public final static String TOOLBAR_IMAGE = "html.toolbar.image.";
    public final static String TOOLBAR_IMAGE_CLEAR = "html.toolbar.image.clear";
    public final static String TOOLBAR_IMAGE_FIRST_PAGE = "html.toolbar.image.firstPage";
    public final static String TOOLBAR_IMAGE_FIRST_PAGE_DISABLED = "html.toolbar.image.firstPageDisabled";
    public final static String TOOLBAR_IMAGE_LAST_PAGE = "html.toolbar.image.lastPage";
    public final static String TOOLBAR_IMAGE_LAST_PAGE_DISABLED = "html.toolbar.image.lastPageDisabled";
    public final static String TOOLBAR_IMAGE_NEXT_PAGE = "html.toolbar.image.nextPage";
    public final static String TOOLBAR_IMAGE_NEXT_PAGE_DISABLED = "html.toolbar.image.nextPageDisabled";
    public final static String TOOLBAR_IMAGE_PREV_PAGE = "html.toolbar.image.prevPage";
    public final static String TOOLBAR_IMAGE_PREV_PAGE_DISABLED = "html.toolbar.image.prevPageDisabled";
    public final static String TOOLBAR_IMAGE_FILTER = "html.toolbar.image.filter";
    public final static String TOOLBAR_IMAGE_SEPARATOR = "html.toolbar.image.separator";

    // toolbar text tooltip messages
    public final static String TOOLBAR_TOOLTIP = "html.toolbar.tooltip.";
    public final static String TOOLBAR_TOOLTIP_FIRST_PAGE = "html.toolbar.tooltip.firstPage";
    public final static String TOOLBAR_TOOLTIP_LAST_PAGE = "html.toolbar.tooltip.lastPage";
    public final static String TOOLBAR_TOOLTIP_PREV_PAGE = "html.toolbar.tooltip.prevPage";
    public final static String TOOLBAR_TOOLTIP_NEXT_PAGE = "html.toolbar.tooltip.nextPage";
    public final static String TOOLBAR_TOOLTIP_FILTER = "html.toolbar.tooltip.filter";
    public final static String TOOLBAR_TOOLTIP_CLEAR = "html.toolbar.tooltip.clear";

    // toolbar text messages
    public final static String TOOLBAR_TEXT_FIRST_PAGE = "html.toolbar.text.firstPage";
    public final static String TOOLBAR_TEXT_LAST_PAGE = "html.toolbar.text.lastPage";
    public final static String TOOLBAR_TEXT_NEXT_PAGE = "html.toolbar.text.nextPage";
    public final static String TOOLBAR_TEXT_PREV_PAGE = "html.toolbar.text.prevPage";
    public final static String TOOLBAR_TEXT_FILTER = "html.toolbar.text.filter";
    public final static String TOOLBAR_TEXT_CLEAR = "html.toolbar.text.clear";

    // statusbar text messages
    public final static String STATUSBAR_RESULTS_FOUND = "html.statusbar.resultsFound";
    public final static String STATUSBAR_NO_RESULTS_FOUND = "html.statusbar.noResultsFound";
}
