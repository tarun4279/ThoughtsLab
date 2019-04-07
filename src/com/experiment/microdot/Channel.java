package com.experiment.microdot;

import java.util.function.Function;

public abstract class Channel {

	private final long id;
	private boolean acceptPoppables = false;
	private Function<Poppable, Boolean> channelFunction;
	
	public Channel(long id) {
		this.id = id;
	}
	
	public boolean isAcceptPoppables() {
		return acceptPoppables;
	}
	
	public void setAcceptPoppables(boolean acceptPoppables) {
		this.acceptPoppables = acceptPoppables;
	}
	
	public Function<Poppable, Boolean> getChannelFunction() {
		return channelFunction;
	}
	
	public void setChannelFunction(Function<Poppable, Boolean> channelFunction) {
		this.channelFunction = channelFunction;
	}
	
	public long getId() {
		return id;
	}
	
	public void stop() {
		this.setAcceptPoppables(false);
	}
	
	public void start() {
		this.setAcceptPoppables(true);
	}
	
	public abstract void acceptPoppables(Poppable p);
	
}
