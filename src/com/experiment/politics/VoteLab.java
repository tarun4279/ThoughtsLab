package com.experiment.politics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class VoteLab {

	public static final int NUMBER_OF_PARTIES = 3;
	public static final int NUMBER_OF_ = 3;
	
	public static int populationSize = 3*6;
	public static int permutations = 0;
	
	
	public static void backTrack(List<Decision> solution) {
		
		
		if(solution.size() == populationSize) {
			
			boolean isNeutral = false;
			
			try {
				
				isNeutral = new DecisionsList(solution).getWinner()
						.getValue().equals(Decision.NEUTRAL.getValue());
				
			}catch (IllegalStateException e) {
				
				//System.out.println(e.getMessage());
				
			}
			 
			
			if(isNeutral && isPopulationFair(solution)) {
//				System.out.println();
//				solution.stream().forEach(d -> System.out.printf(d.getValue() + ":"));
				System.out.print(".");
				permutations++;
			}
			
			solution.remove(solution.size() - 1);
			
			return;	
		}
		
		for(Decision d : Decision.getValues()){
			
			int size = solution.size();
			solution.add(size, d);
			backTrack(solution);
			
		}
		
		
		if(!solution.isEmpty())
		solution.remove(solution.size() - 1);
		
	}
	
	public static void main(String[] args) {
		
		List<Decision> solution = new ArrayList<>();
		backTrack(solution);
		
		System.out.println();
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
		System.out.println("x Number of Permutations = " + permutations);
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
	}
	
	private static boolean isPopulationFair(List<Decision> data) {
		
		Map<Object, Long> counters = data.stream()
			     .collect(Collectors.groupingBy(a -> a, 
			         Collectors.counting()));
		
		
		return counters.values().size() == 3 && new HashSet(Arrays.asList(counters.values().toArray())).size() <= 1;
	}
}
