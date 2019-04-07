package com.experiment.microdot;

import java.util.HashMap;
import java.util.Map;

/**
 * This class holds all the channels and their details
 * and the active ones
 * @author tarun.kundhiya
 */
public class Panel {

	private static Map<Long, Channel> CHANNELS = new HashMap<>();
	
	public static void addChannel(Channel channel) throws Exception {
		
		if(CHANNELS.containsKey(channel.getId())){
			throw new Exception("Channel with same id already exists");
		}
		
		CHANNELS.put(channel.getId(), channel);
	}
	
	public static void removeChannel(long channelId) {
		CHANNELS.remove(channelId);
	}
	
	public static Channel getChannel(long channelId) throws Exception {
		
		if(! CHANNELS.containsKey(channelId)){
			throw new Exception("Channel with same id already exists");
		}
		
		return CHANNELS.get(channelId);
	}
}
