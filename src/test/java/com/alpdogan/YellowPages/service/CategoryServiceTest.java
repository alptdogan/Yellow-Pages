package com.alpdogan.YellowPages.service;

import com.alpdogan.YellowPages.repository.CategoryRepository;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class CategoryServiceTest {

    @InjectMocks
    CategoryService categoryService;

    @Mock
    CategoryRepository categoryRepository;

    @Mock
    ModelMapper modelMapper;



}
