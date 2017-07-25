package com.edu.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.ComponentScan.Filter;

@ComponentScan(value = "com.edu.spring", excludeFilters = @Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {
		UserController.class }))
@Configuration
public class AnnotationScan {

}
