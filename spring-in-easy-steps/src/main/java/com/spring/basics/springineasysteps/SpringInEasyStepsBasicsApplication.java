package com.spring.basics.springineasysteps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.spring.basics.springineasysteps.basic.BinarySearchImpl;
import com.spring.basics.springineasysteps.basic.BubbleSortAlgorithm;
import com.spring.basics.springineasysteps.basic.ThirdSortAlgorithm;

@SpringBootApplication
public class SpringInEasyStepsBasicsApplication {

	public static void main(String[] args) {

		// this is calling the binary search where algorithm is tightly coupled
		BinarySearchImpl bsi = new BinarySearchImpl();
		System.out.println(bsi.binarySearch(new int[] { 2, 4, 3, 6 }, 3));

		// this is calling the binary search where algorithm is not tightly coupled
		BinarySearchImpl bsi1 = new BinarySearchImpl(new BubbleSortAlgorithm());
		System.out.println(bsi1.binarySearch1(new int[] { 2, 4, 3, 6 }, 3));

		
		
		// create the beans by annotating class with @Component annotation
		// then inject dependencies by using @Autowired annotation
		// by default beans are searched in package and sub-packages where class with annotation @@SpringBootApplication
		// is present, so not using ComponentScan at the moment.
		
		// Get the bean using Application Context because "Application Context" maintains all the beans.  
		ApplicationContext applicationContext = SpringApplication.run(SpringInEasyStepsBasicsApplication.class, args);
		BinarySearchImpl binarySearchImpl = applicationContext.getBean(BinarySearchImpl.class);
		int result = binarySearchImpl.binarySearch1(new int[] {1, 2,3,4,5}, 90);
		System.out.println(result);
		
		System.out.println(binarySearchImpl.binarySearch2(new int[] { 2, 4, 3, 6 }, 3));
		
		/* 
		 * Bean Scope
		 * singleton - one bean per spring context
		 * prototype - new bean whenever requested
		 * request - new bean per HTTP request
		 * session - one bean per user session
		 */
		// example of prototype scope
		ThirdSortAlgorithm tsa1 = applicationContext.getBean(ThirdSortAlgorithm.class);
		ThirdSortAlgorithm tsa2 = applicationContext.getBean(ThirdSortAlgorithm.class);
		System.out.println(tsa1); //com.spring.basics.springineasysteps.ThirdSortAlgorithm@df6620a
		System.out.println(tsa2); //com.spring.basics.springineasysteps.ThirdSortAlgorithm@4e31276e
		
		
	}

}
