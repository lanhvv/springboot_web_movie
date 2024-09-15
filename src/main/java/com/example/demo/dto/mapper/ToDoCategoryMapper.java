package com.example.demo.dto.mapper;

import com.example.demo.domain.Category;
import com.example.demo.dto.response.CategoryDTORS;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface ToDoCategoryMapper {
    List<CategoryDTORS> toDoEntityToDTO(List<Category> categoryList);
}
