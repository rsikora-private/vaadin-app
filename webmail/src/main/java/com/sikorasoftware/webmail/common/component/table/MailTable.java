package com.sikorasoftware.webmail.common.component.table;

import com.sikorasoftware.webmail.inbox.MailMessage;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.Table;
import com.vaadin.ui.themes.ValoTheme;

/**
 * Created by robertsikora on 08.01.2016.
 */
public class MailTable extends Table {

    public MailTable(final BeanItemContainer<MailMessage> dataSet, final String[] columns, final String[] headers, final String sortProperty){

        setSizeFull();
        addStyleName(ValoTheme.TABLE_BORDERLESS);
        addStyleName(ValoTheme.TABLE_NO_HORIZONTAL_LINES);
        addStyleName(ValoTheme.TABLE_COMPACT);
        setSelectable(true);

        setColumnCollapsingAllowed(true);
        setColumnReorderingAllowed(true);
        setContainerDataSource(dataSet);
        setSortContainerPropertyId(sortProperty);
        setSortAscending(false);

        setVisibleColumns(columns);
        setColumnHeaders(headers);

        setDragMode(TableDragMode.MULTIROW);
        setMultiSelect(false);

        setImmediate(true);
    }
}
