package com.example.demo.services;

import java.util.Date;

public interface CommonTableService {
    <T> void setInfoCommonTableNew(T object, String createdBy);
    <T> void setInfoCommonTableUpdate(T object, String modifiedBy);
    <T> void setStatus(T object, boolean status);
}
