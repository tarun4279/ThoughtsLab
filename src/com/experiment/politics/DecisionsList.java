package com.experiment.politics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DecisionsList {

	private List<Decision> dataList;
	
	private static final String POSITIVE_DECISION = Decision.POSITIVE.getValue();
	private static final String NEGATIVE_DECISION = Decision.NEGATIVE.getValue();
	private static final String NEUTRAL_DECISION = Decision.NEUTRAL.getValue();
	
	public DecisionsList(List<Decision> data) {
		this.dataList = data;
	}
	
	private static Map<String,Integer> initMap() {
		
//		Map<String,Integer> decisionCount = this.dataList.stream()
//				.map(d -> d.getValue())
//				.distinct()
//				.collect(Collectors.toMap(Function.identity(), d -> 0));

		Map<String,Integer> decisionCount = new HashMap<>();
		
		decisionCount.put(POSITIVE_DECISION, 0);
		decisionCount.put(NEGATIVE_DECISION, 0);
		decisionCount.put(NEUTRAL_DECISION, 0);
				
		return decisionCount;
	}
	
	
	public Decision getWinner() {
					
		Map<String,Integer> decisionCount = initMap();
		
		
		Decision lastDecision = null;
				
		for(Decision decision : dataList) {
			
			
			switch(decision.getValue()) {
			
				case "positive" :
				case "negative" :
					int currentCount = decisionCount.get(decision.getValue());
					decisionCount.put(decision.getValue(), currentCount+1);
					break;
					
				case "neutral" :
					
					int positiveCount = decisionCount.get(POSITIVE_DECISION);
					int negativeCount = decisionCount.get(NEGATIVE_DECISION);
					
					if(lastDecision == null) throw new IllegalStateException("First Decision can be neutral");
					else if(positiveCount > negativeCount) decisionCount.put(POSITIVE_DECISION, positiveCount+1);
					else if(positiveCount < negativeCount) decisionCount.put(NEGATIVE_DECISION, negativeCount+1);
					else
						if(lastDecision == null) throw new IllegalStateException("First Decision cant be neutral");
						else if(lastDecision.getValue().equals(POSITIVE_DECISION))  decisionCount.put(POSITIVE_DECISION, positiveCount+1);
						else if(lastDecision.getValue().equals(NEGATIVE_DECISION))  decisionCount.put(NEGATIVE_DECISION, positiveCount+1);
						
			}			
			
			lastDecision = decision;
		}
		
		if(decisionCount.get(POSITIVE_DECISION) == decisionCount.get(NEGATIVE_DECISION)) {
			return Decision.NEUTRAL;
		}
		
		
		return decisionCount.get(POSITIVE_DECISION) > decisionCount.get(NEGATIVE_DECISION) ? Decision.POSITIVE : Decision.NEGATIVE;
	}
	
}
