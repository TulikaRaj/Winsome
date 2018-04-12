package com.Practice.JavaPrograms;

public class QuichSort {
	
	public static int sortMethod(int a[], int low, int high) {
		int pivot = a[high];
		int i = (low-1);
		for(int j = low; j <high; j++) {
			if(a[j] <= pivot) {
				i++;
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				
				
			}
		}
		int temp = a[i+1];
		a[i+1] = a[high];
		a[high] = temp;
		return i+1;
	}
	public static void method(int a[], int low, int high) {
		if(low<high) {
			int pi = sortMethod(a,low,high);
			method(a,low,pi-1);
			method(a, pi+1,high);
		}
		
	}
	public static void printArray(int a[]) {
		for(int i : a) {
			System.out.print(" " + i );
		}
	}
	public static void main(String [] args) {
		int a[] = {2,8,6,5,3,9,10};
		method(a,0,a.length-1);
		printArray(a);
		
	}

}
