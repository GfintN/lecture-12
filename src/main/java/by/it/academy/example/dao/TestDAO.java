package by.it.academy.example.dao;

import by.it.academy.example.CommandsSQL;

import java.sql.SQLException;
import java.util.List;

public interface TestDAO<E,K> extends DAO<K>{
    List<E> getAllTestDbParameter(K id) throws SQLException;
    int getOneByTwo(CommandsSQL id) throws SQLException;
}
