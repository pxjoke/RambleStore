package com.pxjoke.dao;


import com.pxjoke.entities.AbstractEntity;
import com.pxjoke.mappers.AbstractMapper;
import com.pxjoke.requests.filtration.AbstractFilter;
import com.pxjoke.requests.filtration.restrictions.Limitation;
import com.pxjoke.requests.filtration.restrictions.Sorting;
import com.pxjoke.special.Arguments;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractDAO<E extends AbstractEntity> extends NamedParameterJdbcDaoSupport {
    private final AbstractMapper<E> mapper;

    public AbstractDAO(final AbstractMapper<E> mapper) {
        this.mapper = mapper;
    }

    protected final Long insert(final String query, final Arguments arguments) {
        final KeyHolder keyHolder = new GeneratedKeyHolder();

        if (arguments == null) {
            getNamedParameterJdbcTemplate().update(query, new MapSqlParameterSource(), keyHolder);
            return keyHolder.getKey().longValue();
        }

        getNamedParameterJdbcTemplate().update(query, new MapSqlParameterSource(arguments.getParameters()), keyHolder);
        return keyHolder.getKey().longValue();
    }

    protected final Boolean update(final String query, final Arguments arguments) {
        return getNamedParameterJdbcTemplate().update(query, arguments.getParameters()) > 0;
    }

    protected final List<E> search(final String query, final Arguments arguments) {
        if (arguments == null)
            return getNamedParameterJdbcTemplate().query(query, new HashMap<>(), mapper);

        return getNamedParameterJdbcTemplate().query(query, arguments.getParameters(), mapper);
    }

    protected final E get(final String query, Arguments arguments) {
        final List<E> results = search(query, arguments);
        if ((results == null)||(results.isEmpty()))
            return null;

        return results.get(0);
    }

    protected final Boolean isEmpty(final String query, final Arguments arguments) {
        return search(query, arguments).isEmpty();
    }

    protected final String applyFilter(final String query, final AbstractFilter filter) throws RuntimeException {
        if (query == null)
            return null;

        final StringBuilder builder = new StringBuilder(query);

        if (filter.sorting != null)
            builder.append(getSortingClause(filter.sorting));

        if (filter.limitation != null)
            builder.append(getLimitationClause(filter.limitation));

        return builder.toString();
    }

    private String getSortingClause(final Sorting sorting) throws RuntimeException {
        if ((sorting.column == null)||(sorting.order == null))
            throw new RuntimeException("Wrong sorting clause");

        return " ORDER BY " + sorting.column + " " + sorting.order.getClause();
    }

    private String getLimitationClause(final Limitation limitation) {
        return " LIMIT " + ifNull(limitation.startRow, 0) + ", " + ifNull(limitation.count, Integer.MAX_VALUE);
    }

    protected final <T> T ifNull(final T value, final T ifNullValue) {
        return (value == null) ? ifNullValue : value;
    }

    protected final <T> List<String> convert(final List<T> entities) {
        if (entities == null || entities.isEmpty())
            return null;

        return entities.stream().map(Object::toString).collect(Collectors.toList());
    }
}
