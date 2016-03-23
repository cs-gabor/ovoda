package ovoda;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VoteProcessor {
	
	List<Child> group = new ArrayList<Child>();
	String separator;
	
	String processClassVotes(InputStream is) throws IOException{
		readFromStream(is);
		return getTheMostPopularChildsName();
	}
	
	
	void readFromStream(InputStream is) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
		String line;
		boolean onlygetdelimiteronce = false;
		while((line = br.readLine()) != null){
			if (!onlygetdelimiteronce) {
				setConstDelimiter(line);
				onlygetdelimiteronce = true;
			}
			separateVoteToVoterAndVotedNames(separateVotestringToStringarray(line));
		}	
	}
	
	String[] separateVotestringToStringarray(String line){
		return line.split(separator); 
	}
	

	void setConstDelimiter(String line){
		Pattern checkWhiteSpace = Pattern.compile("\\s[A-Za-z]"); 
		Matcher whitespacematcher = checkWhiteSpace.matcher(line);
		while(whitespacematcher.find()){
			separator = String.valueOf(line.charAt(whitespacematcher.start()));
			return;
		}
		
	}

	void createNewChildOrAddVoterToExistingChild(String voterName, String votedName){

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
	
	void separateVoteToVoterAndVotedNames(String[] votedNames){
		String voterName = votedNames[0];
		for (int i = 1; i < votedNames.length; i++) {
			createNewChildOrAddVoterToExistingChild(voterName, votedNames[i]);
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
	
	public String getSeparator() {
		return separator;
	}

}
