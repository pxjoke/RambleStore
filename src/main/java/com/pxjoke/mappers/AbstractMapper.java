package com.pxjoke.mappers;


import com.pxjoke.entities.AbstractEntity;
import com.pxjoke.tables.AbstractTable;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public abstract class AbstractMapper<E extends AbstractEntity> implements RowMapper<E> {
    public final class Row {
        private final ResultSet result;

        public Row(final ResultSet result) {
            this.result = result;
        }

        public final Long getLong(final AbstractTable column) throws SQLException {
            try {
                return result.getLong(column.getColumnName());
            } catch (final Exception ignored) {
            }

            return null;
        }

        public final Integer getInteger(final AbstractTable column) throws SQLException {
            try {
                return result.getInt(column.getColumnName());
            } catch (final Exception ignored) {
            }

            return null;
        }

        public final Double getDouble(final AbstractTable column) throws SQLException {
            try {
                return result.getDouble(column.getColumnName());
            } catch (final Exception ignored) {
            }

            return null;
        }

        public final String getString(final AbstractTable column) throws SQLException {
            try {
                return result.getString(column.getColumnName());
            } catch (final Exception ignored) {
            }

            return null;
        }

        public final Date getDate(final AbstractTable column) throws SQLException {
            try {
                return result.getDate(column.getColumnName());
            } catch (final Exception ignored) {
            }

            return null;
        }

        public final <T extends Enum<T>> T getEnum(final AbstractTable column, final Class<T> clazz) throws SQLException {
            final String value = getString(column);
            if (value == null)
                return null;

            try {
                return Enum.valueOf(clazz, value);
            } catch (final Throwable ignored) {
            }

            return null;
        }

        private double resolve(final Double value) {
            return value == null ? 0.0 : value;
        }

        public final <T> T getObject(final AbstractTable column, final Class<T> clazz) throws SQLException {
            try {
                return clazz.cast(result.getObject(column.getColumnName()));
            } catch (final Exception ignored) {
            }

            return null;
        }
    }

    @Override
    public final E mapRow(final ResultSet resultSet, final int i) throws SQLException {
        return map(new Row(resultSet));
    }

    public abstract E map(final Row row) throws SQLException;
}
