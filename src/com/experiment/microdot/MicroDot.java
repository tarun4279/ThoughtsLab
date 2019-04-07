package com.experiment.microdot;

import java.util.Timer;
import java.util.TimerTask;

public class MicroDot implements Poppable{

	private final Timer timer = new Timer(false);
	private int data;
	
	public MicroDot(int data) {
		this.data = data;		
	}

	@Override
	public void popNow(long channelId) {
		this.timer.schedule(new MicroDotTimerTask(this, channelId), 0);
	}

	@Override
	public void popAfter(long channelId, long time) {
		this.timer.schedule(new MicroDotTimerTask(this, channelId), time);
	}
	
	private class MicroDotTimerTask extends TimerTask{

		long channelId;
		private Poppable poppingItem;
		
		public MicroDotTimerTask(Poppable poppingItem, long channelId) {
			this.poppingItem = poppingItem;
			this.channelId = channelId;
		}
		
		@Override
		public void run() {
			
			System.out.println("Micro dot exploded at " + System.currentTimeMillis());
			System.out.println("Micro dot holds this data " + data);
			
			try {
				Panel.getChannel(channelId).acceptPoppables(this.poppingItem);
			} catch (Exception e) {
				System.err.println("Unable to send data to channel with id "
										+ channelId + "due to " + e.getMessage());
			}
			
		}
		
	}

	@Override
	public Object getData() {
		return data;
	}	
}
