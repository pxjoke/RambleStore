package com.pxjoke.special;


import com.pxjoke.requests.filtration.restrictions.Range;
import com.pxjoke.tables.AbstractTable;

import java.util.HashMap;
import java.util.Map;

public final class Arguments {
    private final Map<String, Object> parameters;

    public Arguments() {
        parameters = new HashMap<>();
    }

    public Arguments(final AbstractTable column, final Object value) {
        this();

        add(column, value);
    }

    public final void add(final AbstractTable column, final Object value) {
        parameters.put(column.toString(), value);
    }

    public final void add(final AbstractTable columnMin, final AbstractTable columnMax, final Range range) {
        parameters.put(columnMin.toString(), range == null ? null : range.min);
        parameters.put(columnMax.toString(), range == null ? null : range.max);
    }

    public final Map<String, Object> getParameters() {
        return parameters;
    }
}
