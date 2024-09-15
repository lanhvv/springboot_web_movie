package com.example.demo.services.impl;

import com.example.demo.config.exception.policy.BusinessLogicException;
import com.example.demo.domain.Category;
import com.example.demo.dto.mapper.ToDoCategoryMapper;
import com.example.demo.dto.request.CategoryDTORQ;
import com.example.demo.dto.response.CategoryDTORS;
import com.example.demo.repositories.CategoryRepo;
import com.example.demo.services.CategoryService;
import com.example.demo.services.CommonCURD;
import com.example.demo.utils.CommonHandleCollectionUtils;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {
    private final Logger logger = LoggerFactory.getLogger(CategoryServiceImpl.class);
    private final CategoryRepo categoryRepo;
    private final ToDoCategoryMapper toDoCategoryMapper;

    @Override
    public void save(CategoryDTORQ in) {

    }

    @Override
    public void delete(CategoryDTORQ in) {
        Optional<Category> category = this.categoryRepo.findBySlug(in.getSlug());
        category.ifPresent(this.categoryRepo::delete);
    }

    @Override
    public List<CategoryDTORS> getAll(CategoryDTORQ in) {
        boolean isAll = false;
        try {
            isAll = CommonHandleCollectionUtils.objectToMap(in).entrySet()
                    .stream()
                    .filter(map -> ObjectUtils.isEmpty(map.getValue()))
                    .count() > 0;
        } catch (IllegalAccessException e) {
            throw new BusinessLogicException(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()), e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        if (isAll) {
            return this.toDoCategoryMapper.toDoEntityToDTO(this.categoryRepo.findAll());
        }
        return List.of();
    }

    @Override
    public List<CategoryDTORS> getList(CategoryDTORQ in, Pageable pageable) {
        return List.of();
    }
}
