package com.spring.basics.springineasysteps.basic;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary // as there are 2 beans of type SortAlgorithm we need to use Primary to choose a bean for autowiring 
public class QuickSortAlgorithm implements SortAlgorithm {
	
	public int[] sort(int[] numbers) {
		return numbers;
	}

}
