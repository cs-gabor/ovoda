package ovoda;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Child implements Comparable<Child> {

	private String name;
	
	private  Set<String> voters = new HashSet<String>();
	

	public void addVoter(String voterName){
		voters.add(voterName);
	}
	
	

	public Child(String name, String voter) {
		this.name = name;
		voters.add(voter);
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<String> getVoters() {
		return voters;
	}


	public void setVoters(Set<String> voters) {
		this.voters = voters;
	}

	public int compareTo(Child o) {
		if (this.voters.size() < o.voters.size()) {
			return 1;
		}else if (this.voters.size() > o.voters.size()) {
			return -1;
		}
		return 0;
	}



	@Override
	public String toString() {
		return this.getName() + " " + this.getVoters().size();
	}

}
