import java.util.*;
import java.io.*;

public class lab13 {

	private static ArrayList<Integer> list = null;
	
	public void readData(String filename) {
		String str = "";
		BufferedReader read;
		list = new ArrayList<>();
		try {
			read = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
			
			while ((str = read.readLine()) != null) {
				list.add(Integer.valueOf(str.trim()));
			}
			read.close();

		}catch(Exception e) {
			System.out.println(e.toString());
		}
		
	}
	
	public long getTotalCount() {
		return list.stream().count();
	}
	
	public long getOddCount(){
        return list.stream().filter(x -> x % 2 != 0).count();
	}
	
    public long getEvenCount(){
        return list.stream().filter(x -> x % 2 == 0).count();
    }

    public long getDistinctGreaterThanFiveCount(){
        return list.stream().filter(x -> x > 5).distinct().count();
    }

    public Integer[] getResult1(){
        return list.stream().filter(x -> x % 2 == 0 && x > 5 && x < 50).sorted().toArray(Integer[]::new);
     }

    public Integer[] getResult2(){
        return list.stream().map(x -> x * x * 3).limit(50).toArray(Integer[]::new);
     }

    public Integer[] getResult3(){
         return list.stream().filter(x -> x % 2 == 1).map(x -> x * 2).sorted().skip(20).distinct().toArray(Integer[]::new);
     }
}
