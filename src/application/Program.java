package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Map;
import java.util.TreeMap;

import entities.Candidate;

public class Program {

	public static void main(String[] args) {

		String filePath = "<<Path of Your TXT File>>";
		
		Map<Candidate, Integer> candidatesMap = new TreeMap<>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))){

			String line = br.readLine();
			while(line != null) {
				String[] fields = line.split(",");
				Candidate candidate = new Candidate(fields[0]);
				
				if (candidatesMap.containsKey(candidate)) {
					int totalVotes = candidatesMap.get(candidate) + Integer.parseInt(fields[1]);
					candidatesMap.put(candidate, totalVotes);
				}else {
					candidatesMap.put(candidate, Integer.parseInt(fields[1]));
				}
				line = br.readLine();
			}
			
			for(Candidate candidate : candidatesMap.keySet()) {
				System.out.println(candidate.getName() + ": " + candidatesMap.get(candidate));
			}
			
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}