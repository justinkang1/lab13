import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class lab13Test 
{
	lab13 lab;
	Integer[] expectedResult1;
	Integer[] expectedResult2;
	Integer[] expectedResult3;
	String inputFilename = "lab13_input_data.txt";
	String expectedResultsFilename = "lab13_expected_results.txt";

	@BeforeEach
	public void setUp() throws Exception 
	{
		lab = new lab13();
		
		lab.readData(inputFilename);
		
		ArrayList<ArrayList<Integer>> testData = new ArrayList<>();
		for( int i = 0; i < 3; i++ )
		{
			testData.add(new ArrayList<Integer>());
		}
		
		try
		{
			System.out.println("reading " + expectedResultsFilename);
			java.io.BufferedReader input = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(expectedResultsFilename)));
			for( int i = 0; i < testData.size(); i++ )
			{
				ArrayList<Integer> currentTestData = testData.get(i); 
				String inn;
				input.readLine();
				while( (inn = input.readLine()) != null )
				{
					if( inn.length() > 0 )
					{
						currentTestData.add(Integer.valueOf(inn));
					}
					else
					{
						break;
					}
				}
				testData.set(i, currentTestData);
				System.out.println("testData.get(" + i + ").size() = " + testData.get(i).size());
			}
			input.close();
			
			expectedResult1 = new Integer[testData.get(0).size()];
            for(int i = 0; i < expectedResult1.length; i++){
                expectedResult1[i] = testData.get(0).get(i);
            }
			
			expectedResult2 = new Integer[testData.get(1).size()];
            for(int i = 0; i < expectedResult2.length; i++){
                expectedResult2[i] = testData.get(1).get(i);
            }
			
			expectedResult3 = new Integer[testData.get(2).size()];
            for(int i = 0; i < expectedResult3.length; i++){
                expectedResult3[i] = testData.get(2).get(i);
            }
			
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
			System.exit(0);
		}		
	}

    @Test
    void test1(){
        assertEquals(1000, lab.getTotalCount());
    }

    @Test
    void test2(){
        assertEquals(507, lab.getOddCount());
    }

    @Test
    void test3(){
        assertEquals(493, lab.getEvenCount());
    }

    @Test
    void test4(){
        assertEquals(94, lab.getDistinctGreaterThanFiveCount());
    }

    @Test
    void test5(){
        assertArrayEquals(expectedResult1, lab.getResult1());
    }

    @Test
    void test6(){
        assertArrayEquals(expectedResult2, lab.getResult2());
    }

    @Test
    void test7(){
        assertArrayEquals(expectedResult3, lab.getResult3());
    }
}
