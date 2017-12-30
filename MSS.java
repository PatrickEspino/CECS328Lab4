/**
 * Name: Patrick Espino
 * ID: 014254979
 * Lab: 4
 * 
 */



import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class MSS {
	public static void main(String[] args)
	{
		ArrayList<Integer> arr = new ArrayList<Integer>();
		
		System.out.println("Enter a positive integer");
		Scanner read = new Scanner(System.in);
		Random random = new Random();
		int n = read.nextInt();
		for(int i=0; i<n; i++)
		{
			arr.add(random.nextInt(100 + 1 + 100) - 100);
		}
		
		for(int i = 0; i < arr.size(); i++)
		{
			System.out.print(arr.get(i) + " ");
		}
		System.out.println();
		
		System.out.println("MSS is " + MSSn(arr));
		System.out.println("MSS nlogn is " + MSSnlogn(arr,0,arr.size()-1));
	}
	
	public static int MSSn(ArrayList<Integer> arr)
	{
		int max = 0;
		int sum = 0;
		for(int i = 0; i < arr.size(); i++)
		{
			sum += arr.get(i);
			
			if(sum > max)
			{
				max = sum;
			}
			else if (sum < 0)
			{
				sum = 0;
			}
		}
		return max;
	}
	
	public static int MSSnlogn(ArrayList<Integer> arr, int start, int end)
	{
		
		//Nothing in the array
		if(arr.size() - 1 == 0)
		{
			return 0;
		}
		//Only 1 element in the array
		if(end - start + 1 == 1)
		{
			return arr.get(0);
		}
		
		int mid = (end + start) / 2;
		
		//find sum of left
		int sum = 0;	
		int lsum = 0;
		for(int i = mid; i >= start; i--)
		{
			sum += arr.get(i);
			if(sum > lsum)
			{
				lsum = sum;
			}
		}
		
		//find sum of right
		int sum2 = 0;
		int rsum = 0;	
		for(int i = mid + 1; i <= end; i++)
		{
			sum2 += arr.get(i);
			if(sum2 > rsum)
			{
				rsum = sum2;
			}
		}
		//sum of left side + right side
		int z = rsum + lsum;
		//subsequence sums of left side
		int x = MSSnlogn(arr,start,mid);
		//subsequence sums of right side
		int y = MSSnlogn(arr,mid+1,end);
		
		return Math.max(Math.max(x, y),z);
		
	}
}

