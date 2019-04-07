package com.experiment.microdot;

import java.util.List;
import java.util.Random;

public class Notifier {

	private List<Poppable> poppables;
	
	public Notifier(List<Poppable> poppables) {
		this.poppables = poppables;
	}
	
	public void initiateForChannel(long channelId) throws Exception {
	
		Panel.getChannel(channelId).start();
		
		Random rand = new Random();
		this.poppables.parallelStream().forEach(p -> p.popAfter(channelId, rand.nextInt(100)));
		
	}
	
	
}
