package com.gfb.hellowicket.dao;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Sergey on 01.11.2015.
 */
public interface IBaseDao<T> {
    public List<T> load() throws SQLException;

    public T get(long id) throws SQLException;

    public void create(T entity) throws SQLException;

    public void update(T entity) throws SQLException;

    public void delete(long id) throws SQLException;
}
