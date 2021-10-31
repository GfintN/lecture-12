package by.it.academy.example.dao;

import java.sql.SQLException;

public interface DAO <T>{
    T save (T id) throws SQLException;
    T get(T id) throws  SQLException;
    int update(T t) throws SQLException;
    int delete(T id) throws  SQLException;
}
