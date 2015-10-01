package QuickSort;
/**
 
* Use Iterative way to finish QuickSort Function
 * @author lunaguo
 * Date: 09/19/2015
 */

import java.util.*;
import java.lang.*;
import java.io.*;


public class QuickSortIterative {
	
	//Partition, pick rear number as pivot and search for its position
	private int Partition(int[] arr, int left, int right){
		
		int pivot = arr[right];
		int i = left-1;
		for(int j=left; j<=right-1; j++){
			if(arr[j] <= pivot){
				i++;
				swap(arr, i, j);
			}
		}
		swap(arr, i+1, right);
		
		System.out.println("qsort: \n");
		for(int x = 0; x < arr.length;x++){
			System.out.print(arr[x] + " ");
		}
		System.out.println("\n");
		
		
		return i+1;
		
	}
	
	//Swap function
	private void swap(int [] arr, int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	//Divide and Conquer Method of partition
	private void IterQuickSort(int [] arr){
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(0);
		stack.push(arr.length-1);
		
		while(!stack.isEmpty()){
			int right = stack.pop();
			int left = stack.pop();
			if(right - left <= 1) continue;
			
			int pivot = Partition(arr, left, right);
			stack.push(pivot+1);
			stack.push(right);
			stack.push(left);
			stack.push(pivot-1);
		}
		
	}

	public static void main(String[] args){
	    int N = 20;
	    int range = 100;
	    
		Random r = new Random();
		int [] arr = new int[N];
		
		System.out.println("Randomly select " + N + " numbers: \n");
		for(int i=0; i<N; i++){
			arr[i] = r.nextInt(range); // Randomly select 20 numbers
			System.out.print(arr[i]+" ");
		}
		System.out.println("\n");
		
		//Recursive quicksort 
		new QuickSortIterative().IterQuickSort(arr);
		System.out.println("The result: \n");
		for(int i = 0; i < arr.length;i++){
			System.out.print(arr[i] + " ");
		}
	}
}