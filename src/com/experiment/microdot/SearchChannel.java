package com.experiment.microdot;

public class SearchChannel extends Channel{

	
	public SearchChannel(long id) {
		super(id);
	}

	@Override
	public void acceptPoppables(Poppable p) {
		
		System.out.println("Received poppable with data" + p.getData());
		
		if(this.getChannelFunction() == null) {
			throw new RuntimeException("Function is not defined for this channel yet");
		}
		
		if(this.isAcceptPoppables() && this.getChannelFunction().apply(p)) {
			System.err.println("Search value found. Thus stopping");
			this.stop();
		}
	}

}
