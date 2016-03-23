package ovoda;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;


import org.junit.Test;

public class VoteProcessorTest {

	
	@Test
	public void testOvoda_feladat(){
	
			VoteProcessor ovisok = new VoteProcessor();
			InputStream is;
			try {
				is = new FileInputStream("ovisok.txt");
					assertEquals("andi",ovisok.processClassVotes(is));
			} catch (FileNotFoundException e) {
				System.out.println("Exception thrown  :" + e);
			} catch (IOException e) {
				System.out.println("Exception thrown  :" + e);
			}
			
			ovisok.listVotingResult();
		
	
		
	}
	
	@Test
	public void testSetConstDelimiter(){
			
		String names= "alma peti andi regina dávid zsuzsi";
		VoteProcessor ovisok = new VoteProcessor();
		ovisok.setConstDelimiter(names);
		System.out.println("----" + ovisok.getSeparator() + "----");
		assertEquals(" ", ovisok.getSeparator());
		
		
	}
	
}
