import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BillifyTest {

	@Before
	public void setUp() throws Exception {
		// If you use @Mock, you need to do this
	}

	@After
	public void tearDown() throws Exception {
		// any necessary teardown - none needed here
	}

	// generate different random arrays of different sizes
	ArrayList<int[]> res=new ArrayList<>();
	public void generate() {
		for(int i=0;i<100;i++){
			Random r1=new Random();
			int[] array = new int[r1.nextInt(100)+1];
			Random r2=new Random();
			for (int j = 0; j < array.length; j++) {
				array[j] = r2.nextInt(100)+1;
			}
			res.add(array);
		}
	}
	
	//construct method 
	//assign the global variable res
	public BillifyTest(){
		generate();
	}	
	
	// the number of elements in the result array
	// should be equal to the number of elements in the input array plus one
	@Test
	public void testElementNum() {
		Billify map = new Billify();
		BillifyTest test = new BillifyTest();
		for (int i = 0; i < 100; i++) {
			int[] array = test.res.get(i);
//			for (int j = 0; j < array.length; j++)
//				System.out.print(array[j] + " ");
//			System.out.println();
			int len = array.length;
			int length = map.Billify(array).length;
			assertEquals(len + 1, length);
		}
		System.out.println();
	}

	// the last element in the result array
	// should equal or larger than any elements before in the array
	@Test
	public void testMaxLast() {
		Billify map = new Billify();
		BillifyTest test = new BillifyTest();
		for (int i = 0; i < 100; i++) {
			int[] array = test.res.get(i);
			int[] result = map.Billify(array);
			int max = Integer.MIN_VALUE;
			
			//find the max one in the result array
			for (int j = 0; j < result.length; j++) {
				if (result[j] >= max)
					max = result[j];
			}
			assertEquals(max, result[result.length - 1]);
		}
	}

	// each element in the result array except the last one
	// should be a perfect square
	@Test
	public void testPerfectSquare() {
		Billify map = new Billify();
		BillifyTest test = new BillifyTest();
		for (int i = 0; i < 100; i++) {
			int[] array = test.res.get(i);
			int[] result = map.Billify(array);
			for (int j = 0; j < result.length - 1; j++) {
				boolean square = test.isPerfectSquare(result[j]);
				assertTrue(square);
			}
		}
	}

	// judge whether a number is a perfect square or not
	public boolean isPerfectSquare(int num) {
		double sqrt = Math.sqrt(num);
		int k = (int) sqrt;
		if (sqrt - k == 0)
			return true;
		else
			return false;
	}
}
