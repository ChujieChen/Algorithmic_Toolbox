package week1;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class MaxPairwiseProductTest {
	
	MaxPairwiseProduct mpp;
	long productSlow;
	long productFast;

	@Before
	public void setUp() throws Exception {
		mpp = new MaxPairwiseProduct();
	}

	@Test
	public void testSmall() {
		int[] smallArray1 = {1,2};
		int[] smallArray2 = {2,1};
		int[] smallArray3 = {7, 4, 5, 6};
		productSlow = mpp.getMaxPairwiseProduct(smallArray1);
		productFast = mpp.getMaxPairwiseProductFast(smallArray1);
		assertEquals("Testing slow smallArray1", productSlow, 2);
		assertEquals("Testing smallArray1", productSlow, productFast);
		
		productSlow = mpp.getMaxPairwiseProduct(smallArray2);
		productFast = mpp.getMaxPairwiseProductFast(smallArray2);
		assertEquals("Testing slow smallArray2", productSlow, 2);
		assertEquals("Testing smallArray2", productSlow, productFast);
		
		productSlow = mpp.getMaxPairwiseProduct(smallArray3);
		productFast = mpp.getMaxPairwiseProductFast(smallArray3);
		assertEquals("Testing slow smallArray3", productSlow, 42);
		assertEquals("Testing smallArray3", productSlow, productFast);
	}
	
	@Test
	public void testBig() {
		int[] bigArray1 = {100000, 90000};
		
		productSlow = mpp.getMaxPairwiseProduct(bigArray1);
		productFast = mpp.getMaxPairwiseProductFast(bigArray1);
		assertEquals("Testing slow bigArray1", 9000000000L, productSlow);
		assertEquals("Testing bigArray1", productSlow, productFast);
	}
	
	@Test
	public void testLarge() {
		int[] largeArray1 = new int[(int)2e5];
		for(int i=0; i<2e5;i++) {
			largeArray1[i] = i;
		}
		
		productSlow = mpp.getMaxPairwiseProduct(largeArray1);
		productFast = mpp.getMaxPairwiseProductFast(largeArray1);
		assertEquals("Testing slow largeArray1",(long)(2e5 - 1) * (long)(2e5-2) , productSlow);
		assertEquals("Testing largeArray1", productSlow, productFast);
	}
	
	@Test
	public void stressTest() {
		int N = 10;
		int M = 100000;
		while(true){
			Random rand = new Random();
			int n = rand.nextInt(N - 2) + 2;
			int[] randomArray = new int[n];
			for(int i=0; i<n; i++) {
				randomArray[i] = rand.nextInt(M);
			}
			System.out.println(Arrays.toString(randomArray));
			productSlow = mpp.getMaxPairwiseProduct(randomArray);
			productFast = mpp.getMaxPairwiseProductFast(randomArray);
			assertEquals("Testing randomArray", productSlow, productFast);
		}
			
			
	}

}
