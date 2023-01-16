package com.alpdogan.YellowPages.service;

import com.alpdogan.YellowPages.dto.requestDto.SaveCategoryRequestDto;
import com.alpdogan.YellowPages.entity.Category;
import com.alpdogan.YellowPages.repository.CategoryRepository;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

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

}
