package com.experiment.microdot;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class SimulationPlayground {

	public static void main(String[] args) throws Exception {
		
		long testChannelId = 1;
		String searchValue = "10";
		
		SearchChannel searchChannel = new SearchChannel(testChannelId);
		searchChannel.setChannelFunction(new Function<Poppable, Boolean>() {
			
			@Override
			public Boolean apply(Poppable t) {
				return ((MicroDot) (t)).getData().toString().equals(searchValue);
				
			}
		});
		
		Panel.addChannel(searchChannel);
		
		List<Poppable> dots = new ArrayList<>();
		dots.add(new MicroDot(4));
		dots.add(new MicroDot(10));
		dots.add(new MicroDot(5));
		
		
		Notifier notifier = new Notifier(dots);
		notifier.initiateForChannel(searchChannel.getId());
		

	}

}
