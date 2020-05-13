package com.spring.basics.springineasysteps.basic;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class BinarySearchImpl {

	Logger logger = LoggerFactory.getLogger(BinarySearchImpl.class);

	@Autowired // this is also auto wiring by setter
	private SortAlgorithm sortAlgorithm; // we have 2 sort algorithms, BubbleSortAlgorithm and QuickSortAlgorithm, way
											// it currently works is because of @Primary annotation, there is one more
											// in which we can achieve this, we can rename variable sortAlgorithm to
											// bubbleSortAlgorithm, this is called "Autowiring by name". If annotation
											// is also present as well as variable name is also set as per Autowiring
											// rule then @Primary takes precedence.

	@Autowired
	@Qualifier("third")
	private SortAlgorithm oneMoreSortAlgorithm;

	public BinarySearchImpl() {
		super();
	}

	// @Autowired - this is autowiring by constructor
	public BinarySearchImpl(SortAlgorithm sortAlgorithm) {
		super();
		this.sortAlgorithm = sortAlgorithm;
	}

	// @Autowired - this is autowiring by setter
	public void setSortAlgorithm(SortAlgorithm sortAlgorithm) {
		this.sortAlgorithm = sortAlgorithm;
	}

	public int binarySearch(int[] numbers, int numberToSearch) {
		// implement sorting logic
		// bubble sort algorithm
		BubbleSortAlgorithm bsa = new BubbleSortAlgorithm();

		int[] sortedNumbers = bsa.sort(numbers);

		// "Above is tightly coupled because if we
		// have to change the algorithm then we would need to change this class to
		// change
		// the code to use new algorithm."

		// "Solution to above is create an interface SortAlgorithm and let both
		// algorithms implement that
		// interface, then create a private member in this class of SortAlgorithm,
		// instantiate that in a
		// constructor with whatever algorithm we want and then sort.
		// This way we don't have to change implementation of binary search even if
		// tomorrow there
		// comes a new algorithm.

		// search the number in array
		return 1;
	}

	public int binarySearch1(int[] numbers, int numberToSearch) {
		sortAlgorithm.sort(numbers);
		return 2;
	}

	public int binarySearch2(int[] numbers, int numberToSearch) {
		oneMoreSortAlgorithm.sort(numbers);
		return 3;
	}

	@PostConstruct
	private void postConstructMethod() {
		// we used it to load currencies from the Database
		logger.info("in postConstructMethod");
	}

	@PreDestroy
	private void preDestroy() {
		logger.info("in preDestroyMethod");
	}

}
