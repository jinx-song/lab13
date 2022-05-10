import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;

public class lab13 {
	
	ArrayList<Integer> ints = new ArrayList<>();
	
	public void readData(String filename) {
		try {
			String inn;
			BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
			while((inn = input.readLine()) != null) {
				ints.add(Integer.parseInt(inn));
			}
		}
		
		catch(Exception e) {
			System.out.println(e.toString());
			System.exit(0);
		}
	}
	
	public long getTotalCount() {
		return ints.stream().count();
	}
	
	public long getOddCount() {
		return ints.stream().filter(i -> i%2 == 1).count();
	}
	
	public long getEvenCount() {
		return ints.stream().filter(i -> i%2 == 0).count();
	}
	
	public long getDistinctGreaterThanFiveCount() {
		return ints.stream().distinct().filter(i -> i > 5).count();
	}
	
	public Integer[] getResult1() {
		return ints.stream().filter(i-> i%2 == 0).filter(x -> x > 5).filter(y -> y < 50).sorted().toArray(Integer[]:: new);
	}
	
	public Integer[] getResult2() {
		return ints.stream().limit(50).map(i -> i*i*3).toArray(Integer[]:: new);
	}
	
	public Integer[] getResult3() {
		return ints.stream().filter(i -> i%2 == 1).map(x -> x*2).sorted().skip(20).distinct().toArray(Integer[]:: new);
	}

}
