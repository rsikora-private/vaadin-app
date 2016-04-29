package com.sikorasoftware.webmail.common.component.table;

import com.sikorasoftware.webmail.inbox.Email;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.Table;
import com.vaadin.ui.themes.ValoTheme;

/**
 * Created by robertsikora on 08.01.2016.
 */
public class MailTable extends Table {

    private final static String STYLE_NAME = "unread";

    public MailTable() {
        setSizeFull();
        addStyleName(ValoTheme.TABLE_BORDERLESS);
        addStyleName(ValoTheme.TABLE_NO_HORIZONTAL_LINES);
        addStyleName(ValoTheme.TABLE_COMPACT);
        setSelectable(true);
        setColumnCollapsingAllowed(true);
        setColumnReorderingAllowed(true);
        setDragMode(TableDragMode.MULTIROW);
        setMultiSelect(false);
        setCellStyleGenerator((CellStyleGenerator) (source, itemId, propertyId) -> {
            final Email mailEmail = (Email) itemId;
            if (mailEmail.isUnread()) {
                return STYLE_NAME;
            }
            return null;
        });
        setImmediate(true);
    }

    public void setDataSet(final BeanItemContainer<Email> dataSet) {
        setContainerDataSource(dataSet);
    }

    public BeanItemContainer getDataSet() {
        return (BeanItemContainer) super.getContainerDataSource();
    }

    public void setVisibleColumns(final String[] columns) {
        super.setVisibleColumns(columns);
    }

    public void setColumnHeaders(final String[] headers) {
        super.setColumnHeaders(headers);
    }

    public void setSortProperty(final String sortProperty, final boolean isAsc) {
        setSortContainerPropertyId(sortProperty);
        setSortAscending(isAsc);
    }
}
