package com.spring.basics.springineasysteps.basic;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Qualifier("third")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) // using this scope would result in a new bean whenever requested
public class ThirdSortAlgorithm implements SortAlgorithm {
	
	public int[] sort(int[] numbers) {
		System.out.println("sort method of ThirdSortAlgorithm");
		return numbers;
	}

}
