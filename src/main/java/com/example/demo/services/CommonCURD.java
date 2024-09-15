package com.example.demo.services;

import java.awt.print.Pageable;
import java.util.List;

public interface CommonCURD<IN_SAVE, IN_SEARCH, OUT> {
    void save(IN_SAVE in);
    void delete(IN_SAVE in);
    List<OUT> getAll(IN_SEARCH in);
    List<OUT> getList(IN_SEARCH in, Pageable pageable);

}
