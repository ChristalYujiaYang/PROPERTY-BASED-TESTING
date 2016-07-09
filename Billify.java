import java.util.Random;

public class Billify {
	// Billify method
	public int[] Billify(int[] x) {
		// get the length of input array
		int len = x.length;
		int sum = 0;
		int[] result = new int[len + 1];
		int i = 0;
		// add the square of elements into the array
		while (i < len) {
			result[i] = (int) Math.pow(x[i], 2);
			sum += result[i];
			i++;
		}
		// add sum of all other elements into the array
		result[i] = sum;
		return result;
	}
	/*
	 * public static void main(String[] args) { int[] x=new int[10]; Random
	 * r=new Random(10); for(int i=0;i<x.length;i++){ x[i]=r.nextInt(100);
	 * System.out.print(x[i]+" "); } System.out.println(); Billify a=new
	 * Billify(); int[] res=new int[11]; res=a.Billify(x); for(int
	 * i=0;i<res.length;i++){ System.out.print(res[i]+" "); } }
	 */
}
