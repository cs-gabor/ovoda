package ovoda;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.junit.Test;

public class VoteProcessorTest {

	
	@Test
	public void testOvoda_feladat(){
	
			VoteProcessor ovisok = new VoteProcessor();
			InputStream is;
			try {
				is = new FileInputStream("ovisok.txt");
				ovisok.readFromStream(is);
			} catch (FileNotFoundException e) {
				System.out.println("Exception thrown  :" + e);
			} catch (IOException e) {
				System.out.println("Exception thrown  :" + e);
			}
			
			ovisok.listVotingResult();
			System.out.println();
			
			assertEquals("andi",ovisok.getTheMostPopularChildsName());
		
	
		
	}
	

}
