package com.how2java.service;

import org.springframework.stereotype.Service;

import java.util.List;

public interface BaseService<T> {
    List<T> list();

    void insert(T t);

    void delete(int id);

    void update(T t);

    T query(int id);

    int count();
}
