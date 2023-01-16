package com.alpdogan.YellowPages.service;

import com.alpdogan.YellowPages.dto.requestDto.SaveCategoryRequestDto;
import com.alpdogan.YellowPages.dto.requestDto.UpdateCategoryRequestDto;
import com.alpdogan.YellowPages.entity.Category;
import com.alpdogan.YellowPages.repository.CategoryRepository;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@SpringBootTest
public class CategoryServiceTest {

    @InjectMocks
    CategoryService categoryService;

    @Mock
    CategoryRepository categoryRepository;

    @Mock
    ModelMapper modelMapper;

    @Test
    void testSaveCategory() {

        SaveCategoryRequestDto saveCategoryRequestDtoMock = mock(SaveCategoryRequestDto.class);
        saveCategoryRequestDtoMock.setCategoryName("Software Developer");

        Category categoryMock = mock(Category.class);
        categoryMock.setId(1);

        when(modelMapper.map(saveCategoryRequestDtoMock, Category.class)).thenReturn(categoryMock);
        when(categoryRepository.save(categoryMock)).thenReturn(categoryMock);

        String saveCategory = categoryService.saveCategory(saveCategoryRequestDtoMock);
        String saveCategoryMessage = categoryMock.getCategoryName() + " has been created successfully.";

        assertEquals(saveCategory, saveCategoryMessage);

    }

    @Test
    void testFindCategory() {

        Category categoryMock = mock(Category.class);
        categoryMock.setId(1);

        when(categoryRepository.findById(categoryMock.getId())).thenReturn(Optional.of(categoryMock));
        Category findCategory = categoryService.findCategory(categoryMock.getId());

        assertEquals(categoryMock, findCategory);

    }

    @Test
    void testUpdateCategory() {

        Category categoryMock = mock(Category.class);
        categoryMock.setId(1);
        categoryMock.setCategoryName("Software Developer");

        UpdateCategoryRequestDto updateCategoryRequestDtoMock = mock(UpdateCategoryRequestDto.class);
        updateCategoryRequestDtoMock.setCategoryName("Back End Developer");

        when(categoryRepository.findById(categoryMock.getId())).thenReturn(Optional.of(categoryMock));

        String updateCategory = categoryService.updateCategory(updateCategoryRequestDtoMock);
        String updateCategoryMessage = "Changes saved successfully.";

        assertEquals(updateCategory, updateCategoryMessage);

    }

    @Test
    void testDeleteCategoryById() {

        Category categoryMock = mock(Category.class);
        categoryMock.setId(1);

        when(categoryRepository.findById(categoryMock.getId())).thenReturn(Optional.of(categoryMock));

        String deleteCategory = categoryService.deleteCategoryById(categoryMock.getId());
        String deleteCategoryMessage = "The category has been deleted.";

        assertEquals(deleteCategory, deleteCategoryMessage);

    }

}
