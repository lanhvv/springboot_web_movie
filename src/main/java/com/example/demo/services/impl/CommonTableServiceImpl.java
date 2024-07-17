package com.example.demo.services.impl;

import com.example.demo.domain.CommonTable;
import com.example.demo.services.CommonTableService;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CommonTableServiceImpl implements CommonTableService {

    @Override
    public <T> void setInfoCommonTableNew(T object, String createdBy) {
        CommonTable commonTable = (CommonTable) object;
        commonTable.setCreatedBy(createdBy);
        commonTable.setCreatedTime(new Date());
        commonTable.setStatus(true);
    }

    @Override
    public <T> void setInfoCommonTableUpdate(T object, String modifiedBy) {
        CommonTable commonTable = (CommonTable) object;
        commonTable.setModifiedBy(modifiedBy);
        commonTable.setModifiedTime(new Date());
    }

    @Override
    public <T> void setStatus(T object, boolean status) {
        CommonTable commonTable = (CommonTable) object;
        commonTable.setStatus(status);
    }
}
