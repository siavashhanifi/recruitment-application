package kth.iv1201.grupp10.recruitmentApplication.domain;

import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;
@Component("onlineUsers")
public class OnlineUsers {
	private ConcurrentHashMap<String, User> onlineUsers;
	
	public void addUser(UserLoginCredentials userLoginCredentials) {
	}

}
