package com.Practice.JavaPrograms;

public class MergeSortAlgo1 {
	public void mergeMethod(int a[], int l, int r, int m) {
		int n1 = m-l+1;
		int n2 = r-m;
		int L[] = new int [n1];
		int R[] = new int [n2];
		for(int i = 0; i <n1; i++) {
			L[i] = a[l+i];
			
		}
		for(int j = 0; j<n2; j++) {
			R[j] = a[m+1+j];
			
		}
		int k = l;
		int i = 0;
		int j = 0;
		while(i <n1 && j <n2) {
			if(L[i] <= R[j]) {
				a[k] = L[i];
				i++;
				
			}
			else {
				if(R[j] <= L[i]) {
					a[k] = R[j];
					j++;
				}
			}
			k++;
			
			
		}
		while(i < n1) {
			a[k] = L[i];
			i++;
			k++;
		}
		while(j <n2) {
			a[k] = R[j];
			j++;
			k++;
		}
		
		
	}
	public void printArray(int a[]) {
		for(int i : a) {
			System.out.print(" " + i );
		}
	}
	public void sortMethod(int a[],int l, int r) {
		if(l<r) {
		int m = (l+r)/2;
		sortMethod(a,l,m);
		sortMethod(a,m+1,r);
		mergeMethod(a,l,r,m);
		}
	}
	public static void main(String [] args) {
		int a[] = {2,4,5,3,9,7,6,8,10,1};
		MergeSortAlgo1 obj = new MergeSortAlgo1();
		obj.sortMethod(a, 0, a.length-1);
		obj.printArray(a);
		
	}

}
