package com.experiment.microdot;

public interface Poppable {

	void popNow(long channelId);
	
	void popAfter(long channelId, long time);
	
	Object getData();
}
