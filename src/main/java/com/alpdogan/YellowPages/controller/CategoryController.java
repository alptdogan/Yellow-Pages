package com.alpdogan.YellowPages.controller;

import com.alpdogan.YellowPages.dto.requestDto.SaveCategoryRequestDto;
import com.alpdogan.YellowPages.dto.requestDto.UpdateCategoryRequestDto;
import com.alpdogan.YellowPages.dto.responseDto.CategoryResponseDto;
import com.alpdogan.YellowPages.entity.Category;
import com.alpdogan.YellowPages.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @PostMapping("/saveCategory")
    public ResponseEntity<String> saveCategory(@RequestBody SaveCategoryRequestDto saveCategoryRequestDto) {

        String categorySaveDescription = categoryService.saveCategory(saveCategoryRequestDto);

        return new ResponseEntity<>(categorySaveDescription, HttpStatus.OK);

    }

    @GetMapping("/findCategoryById")
    public ResponseEntity<Category> findCategoryById(@RequestParam Integer categoryId) {

        Category category = categoryService.findCategory(categoryId);

        return new ResponseEntity<>(category, HttpStatus.OK);

    }

    @GetMapping("/findAllCategory")
    public ResponseEntity<List<CategoryResponseDto>> findAllCategory() {

        List<CategoryResponseDto> categoryResponseDtos = categoryService.findAllCategory();

        return new ResponseEntity<>(categoryResponseDtos, HttpStatus.OK);

    }

    @PostMapping("/updateCategory")
    public ResponseEntity<String> updateCategory(@RequestBody UpdateCategoryRequestDto updateCategoryRequestDto) {

        String updateCategoryDescription = categoryService.updateCategory(updateCategoryRequestDto);

        return new ResponseEntity<>(updateCategoryDescription, HttpStatus.OK);

    }

    @DeleteMapping("/deleteCategory")
    public ResponseEntity<String> deleteCategoryById(@RequestParam Integer categoryId) {

        String deleteCategoryDescription = categoryService.deleteCategoryById(categoryId);

        return new ResponseEntity<>(deleteCategoryDescription, HttpStatus.OK);

    }

}
