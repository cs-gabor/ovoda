package ovoda;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class VoteProcessor {
	
	List<Child> group = new ArrayList<Child>();
	
	void readFromStream(InputStream is) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		String line;
		while((line = br.readLine()) != null){
			voteProcess(separateVotes(line));
		}
		
	}
	
	String[] separateVotes(String line){
		return line.split("\\s+"); //az összes white space eseten szétszed és ezek kombinacioinal is
	}

	void vote(String voterName, String votedName){

		if (voterName.equals(votedName)) {
			return;
		}
		
		for (Child child : group) {
			if(child.getName().equals(votedName)){
				child.addVoter(voterName);
				return;
			}
		}
		group.add(new Child(votedName,voterName));
	}
	
	void voteProcess(String[] votedNames){
		String voterName = votedNames[0];
		for (int i = 1; i < votedNames.length; i++) {
			vote(voterName, votedNames[i]);
		}
	}
	

	void listVotingResult(){
		Collections.sort(group);
		for (Child child : group) {
			System.out.println(child.toString());
		}
	}
	
	String getTheMostPopularChildsName(){
		Collections.sort(group);
		return group.get(0).getName();
	}
}
