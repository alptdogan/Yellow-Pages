package com.alpdogan.YellowPages.service;

import com.alpdogan.YellowPages.dto.requestDto.SaveCategoryRequestDto;
import com.alpdogan.YellowPages.dto.requestDto.UpdateCategoryRequestDto;
import com.alpdogan.YellowPages.dto.responseDto.CategoryResponseDto;
import com.alpdogan.YellowPages.entity.Category;
import com.alpdogan.YellowPages.repository.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ModelMapper modelMapper;

    public String saveCategory(SaveCategoryRequestDto saveCategoryRequestDto) {

        Category category = modelMapper.map(saveCategoryRequestDto, Category.class);

        category = categoryRepository.save(category);

        return category.getCategoryName() + " has been successfully created.";

    }

    public Category findCategory(Integer categoryId) {

        return categoryRepository.findById(categoryId).get();

    }

    public String updateCategory(UpdateCategoryRequestDto updateCategoryRequestDto) {

        int idCategoryRequest = updateCategoryRequestDto.getId();
        String nameCategoryRequest = updateCategoryRequestDto.getCategoryName();

        Optional<Category> categoryOptional = categoryRepository.findById(idCategoryRequest);
        Category category = categoryOptional.get();

        category.setCategoryName(nameCategoryRequest);

        categoryRepository.save(category);

        return "Changes saved successfully.";

    }

    public String deleteCategoryById(Integer categoryId) {

        Optional<Category> optionalCategory = categoryRepository.findById(categoryId);

        Category category = optionalCategory.get();
        categoryRepository.delete(category);

        return "The category has been deleted.";

    }

    public List<CategoryResponseDto> findAllCategory() {

        Iterable<Category> categories = categoryRepository.findAll();

        List<CategoryResponseDto> categoryResponseDtos = new ArrayList<>();

        for (Category category : categories) {

            CategoryResponseDto categoryResponseDto = modelMapper.map(category, CategoryResponseDto.class);
            categoryResponseDtos.add(categoryResponseDto);

        }

        return categoryResponseDtos;

    }

}
