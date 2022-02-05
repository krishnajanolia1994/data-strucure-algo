package com.krishna.algorithm.DSAlgo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.krishna.algorithm.DSAlgo.service.SortingService;

@Component
public class SortingServiceImpl implements SortingService {
	@Override
	public int[] insertionSort(int[] ar) {

		int length = ar.length;
		for (int i = 1; i < length; i++) {
			if (ar[i - 1] > ar[i]) {

				shift(ar, i, ar[i]);

			}
		}
		return ar;
	}

	private void shift(int[] ar, int i, int temp) {
		int index = i - 1;
		while (index >= 0) {
			if (temp > ar[index]) {
				break;
			} else {
				ar[index + 1] = ar[index];  
				if (index != 0) 
					index--;              
				else  
					break;
			}
		}
		ar[index] = temp;
	}

	@Override
	public int[] mergeSort(int[] ar) {
		return mergeSortArr(ar, 0, ar.length - 1);
	}

	private int[] mergeSortArr(int[] ar, int first, int last) {
		if (first < last) {
			int mid = (first + last) / 2;
			mergeSortArr(ar, first, mid);
			mergeSortArr(ar, mid + 1, last);
			merge(ar, first, mid, last);

		}
		return ar;
	}

	private void merge(int[] ar, int first, int mid, int last) {

		int[] firstArr = new int[mid - first + 1];
		int[] secondArr = new int[last - mid];

		int index = 0;

		int i;
		for (i = first; i <= mid; i++) {
			firstArr[index] = ar[i];
			index++;
		}
		index = 0;

		for (i = mid + 1; i <= last; i++) {
			secondArr[index] = ar[i];
			index++;
		}

		int firstArrIndex = 0;
		int secondArrIndex = 0;

		for (i = first; i <= last; i++) {
			if (firstArr.length == firstArrIndex) {
				ar[i] = secondArr[secondArrIndex];
				secondArrIndex++;
			} else if (secondArr.length == secondArrIndex) {
				ar[i] = firstArr[firstArrIndex];
				firstArrIndex++;
			} else if (firstArr[firstArrIndex] < secondArr[secondArrIndex]) {
				ar[i] = firstArr[firstArrIndex];
				firstArrIndex++;
			} else {
				ar[i] = secondArr[secondArrIndex];
				secondArrIndex++;
				;
			}
		}
	}

	@Override
	public int[] heapSort(int[] ar) {
		int length = ar.length;
		for (int i = (length / 2) - 1; i >= 0; i--) {
			heapify(ar, i, length);
		}

		for (int i = 0; i < length - 1; i++) {
			swap(ar, 0, length - i - 1);

			heapify(ar, 0, length - i - 1);

		}
		return ar;
	}

	private void swap(int[] ar, int i, int j) {
		int temp = ar[i];
		ar[i] = ar[j];
		ar[j] = temp;
	}

	private void heapify(int[] ar, int root, int largest) {
		int max = root;
		int localMax = root;
		int left = (root * 2) + 1;
		int right = (root * 2) + 2;
		if (left < largest && ar[left] > ar[max]) {
			localMax = left;
		}
		if (right < largest && ar[right] > ar[max] && ar[right] > ar[left]) {
			localMax = right;
		}
		if (localMax != max) {
			swap(ar, localMax, max);
			heapify(ar, localMax, largest);
		}
	}

	@Override
	public int[] countingSort(int[] ar) {
		int length = ar.length;
		int max = getMax(ar);
		int countArr[] = new int[max + 1];
		int i;
		for (i = 0; i < length; i++) {
			countArr[ar[i]]++;
			System.out.println(i);
		}
		int index = 0;
		for (i = 0; i < max + 1; i++) {
			if (countArr[i] > 0) {
				index = add(ar, index, countArr[i], i);
			}
		}
		return ar;
	}

	private int add(int[] ar, int index, int count, int value) {
		for (int i = 0; i < count; i++) {
			ar[index] = value;
			index++;
		}
		return index;
	}

	private int getMax(int[] ar) {
		int max = ar[0];
		for (int i = 1; i < ar.length; i++) {
			if (max < ar[i])
				max = ar[i];
		}
		return max;
	}

	@Override
	public int[] indexSort(int[] ar) {
		int maxDigit = getMaxDigit(ar);
		for (int i = 1; i <= maxDigit; i++)
			sortByDigitPosition(ar, i);
		return ar;
	}

	private void sortByDigitPosition(int[] ar, int digitPosition) {
		List<Integer> zero = new ArrayList<Integer>();
		List<Integer> one = new ArrayList<Integer>();
		List<Integer> two = new ArrayList<Integer>();
		List<Integer> three = new ArrayList<Integer>();
		List<Integer> four = new ArrayList<Integer>();
		List<Integer> five = new ArrayList<Integer>();
		List<Integer> six = new ArrayList<Integer>();
		List<Integer> seven = new ArrayList<Integer>();
		List<Integer> eight = new ArrayList<Integer>();
		List<Integer> nine = new ArrayList<Integer>();

		addElementToTheBucket(ar, digitPosition, zero, one, two, three, four, five, six, seven, eight, nine);
		int index = 0;
		index = addBucketToArray(ar, zero, index);
		index = addBucketToArray(ar, one, index);
		index = addBucketToArray(ar, two, index);
		index = addBucketToArray(ar, three, index);
		index = addBucketToArray(ar, four, index);
		index = addBucketToArray(ar, five, index);
		index = addBucketToArray(ar, six, index);
		index = addBucketToArray(ar, seven, index);
		index = addBucketToArray(ar, eight, index);
		addBucketToArray(ar, nine, index);

	}

	private int addBucketToArray(int[] ar, List<Integer> bucket, int index) {
		for (int i = 0; i < bucket.size(); i++) {
			ar[index] = bucket.get(i);
			index++;
		}
		return index;

	}

	private void addElementToTheBucket(int[] ar, int digitPosition, List<Integer> zero, List<Integer> one,
			List<Integer> two, List<Integer> three, List<Integer> four, List<Integer> five, List<Integer> six,
			List<Integer> seven, List<Integer> eight, List<Integer> nine) {
		for (int i = 0; i < ar.length; i++) {
			int digitValue = getDigitValueByPosition(ar[i], digitPosition);
			switch (digitValue) {
			case 0:
				zero.add(ar[i]);
				break;
			case 1:
				one.add(ar[i]);
				break;
			case 2:
				two.add(ar[i]);
				break;
			case 3:
				three.add(ar[i]);
				break;
			case 4:
				four.add(ar[i]);
				break;
			case 5:
				five.add(ar[i]);
				break;
			case 6:
				six.add(ar[i]);
				break;
			case 7:
				seven.add(ar[i]);
				break;
			case 8:
				eight.add(ar[i]);
				break;
			case 9:
				nine.add(ar[i]);
				break;

			}
		}
	}

	private int getDigitValueByPosition(int value, int digitPosition) {
		value /= Math.pow(10, digitPosition - 1);
		int digitValue = 0;
		if (value > 0)
			digitValue = value % 10;
		return digitValue;
	}

	private int getMaxDigit(int[] ar) {
		int max = ar[0];
		for (int i = 1; i < ar.length; i++)
			if (max < ar[i])
				max = ar[i];
		int maxDigit = 0;
		while (max > 0) {
			max /= 10;
			maxDigit++;
		}
		return maxDigit; 
	}

}
