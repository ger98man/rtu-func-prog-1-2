package imperative;
import java.lang.Math;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PerfectNumber {

// CORRECT TASK VARIANT
	public enum STATE {
		ABUNDANT,
		DEFICIENT,
		PERFECT;
	}

	public static ArrayList<Integer> divisors(int n) {
		ArrayList<Integer> divisors_list = new ArrayList<Integer>();
		
		int numberSqrtIntRound = (int) Math.round(Math.sqrt(n)+0.5);

		IntStream.range(1, numberSqrtIntRound).forEach(nbr -> { 
			if(n % nbr == 0)  {
				divisors_list.add(nbr);
				if (!divisors_list.contains(n/nbr)) {
					divisors_list.add(n/nbr);
				}
			}
		});
		
		return (ArrayList<Integer>) divisors_list.stream().sorted().collect(Collectors.toList());
	}
	
	public static STATE process(int n) {
		
		int sum = divisors(n).stream().mapToInt(Integer::intValue).sum();
		sum = sum - n;
		
		System.out.println(divisors(n));
		
		int numberSqrtIntRound = (int) Math.round(Math.sqrt(n));
		System.out.println(numberSqrtIntRound);

		STATE classification;
		if (sum < n) {
			classification = STATE.DEFICIENT;
		} else {
			if (sum == n) {
				classification = STATE.PERFECT;
			} else {
				classification = STATE.ABUNDANT;
			}
		}
		return classification;
	}
}