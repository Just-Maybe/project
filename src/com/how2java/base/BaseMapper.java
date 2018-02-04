package com.how2java.base;

import java.util.List;

public interface BaseMapper<T> {
    public int insert(T t);


    public void delete(int id);


    public T query(int id);


    public int update(T t);


    public List<T> list();

    public int count();

}
