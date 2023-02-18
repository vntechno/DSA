package com.vrtech.dsa.searching;


public class SearchUtils {

	public static int binarySearch(int[] arr, int size, int key) {

		int start = 0;
		int end = size - 1;
		int mid = start + (end - start) / 2;

		while (start <= end) {

			if (arr[mid] == key) {
				return mid;
			}
			if (key > arr[mid]) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
			mid = start + (end - start) / 2;
		}
		return -1;
	}

	public static int firstOccInArray(int[] arr, int size, int key) {

		int start = 0;
		int end = size - 1;
		int mid = start + (end - start) / 2;
		int ans = -1;

		while (start <= end) {

			if (arr[mid] == key) {
				ans = mid;
				end = mid - 1;
			}
			if (key > arr[mid]) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
			mid = start + (end - start) / 2;
		}
		return ans;
	}
	
	public static int lastOccInArray(int[] arr, int size, int key) {

		int start = 0;
		int end = size - 1;
		int mid = start + (end - start) / 2;
		int ans = -1;

		while (start <= end) {

			if (arr[mid] == key) {
				ans = mid;
				start = mid + 1;
			}
			if (key > arr[mid]) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
			mid = start + (end - start) / 2;
		}
		return ans;
	}
	
	public static int peekElementInMountainArray(int[] arr) {	
		int start = 0;
		int end = arr.length - 1;
		int mid = start + (end - start) / 2;
		while (start < end) {
			if (arr[mid]<arr[mid+1]) {
				start=mid+1;
			} else {
				end = mid;
			}
			mid = start + (end - start) / 2;
		}
		return start;		
	}
	
	public static void main(String[] args) {
		
		int [] arr= {0,1,3,0};		
		//System.out.println(SearchUtils.binarySearch(arr, arr.length, 8));
		//System.out.println(SearchUtils.firstOccInArray(arr, arr.length, 5));
		System.out.println(SearchUtils.peekElementInMountainArray(arr));
		
	}
}
