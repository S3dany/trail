package com.tosp.trail;

import org.junit.Before;
import org.junit.Test;



import java.util.ArrayList;

import static org.junit.Assert.*;

public class UserTest {
    private User John;
    private User john_friend;

    @Before
    public void setUp() throws Exception {
        John = new User("john", "john@dreamcatcher.com","john123", new ArrayList<User>(), new ArrayList<FriendRequest>(),new ArrayList<FriendRequest>());
        john_friend =  new User("John's Friend", "johns_friend@dreamcatcher.com","john_friend123",new ArrayList<User>(), new ArrayList<FriendRequest>(),new ArrayList<FriendRequest>());
    }



    @Test
    public void addFriend() {
        John.addFriend(john_friend);
        assertTrue(John.getFriends().size() == 1);
        assertTrue(John.getFriends().contains(john_friend));
    }


    @Test
    public void send_friend_request() {
        FriendRequest request = John.send_friend_request(john_friend);
        assertTrue(john_friend.getReceivedRequests().size()==1);
        assertTrue(John.getSentRequests().size()==1);
        assertTrue(john_friend.getReceivedRequests().contains(request));
        assertTrue(John.getSentRequests().contains(request));

    }

    @Test
    public void accept_friend_request() {
        FriendRequest request = John.send_friend_request(john_friend);
        John.accept_friend_request(request);
        assertTrue(john_friend.getReceivedRequests().size()==0);
        assertTrue(John.getSentRequests().size()==0);
        assertFalse(john_friend.getReceivedRequests().contains(request));
        assertFalse(John.getSentRequests().contains(request));
        assertTrue(John.getFriends().size() == 1);
        assertTrue(John.getFriends().contains(john_friend));

    }

    @Test
    public void decline_friend_request() {
        FriendRequest request = John.send_friend_request(john_friend);
        John.decline_friend_request(request);
        assertTrue(john_friend.getReceivedRequests().size()==0);
        assertTrue(John.getSentRequests().size()==0);
        assertFalse(john_friend.getReceivedRequests().contains(request));
        assertFalse(John.getSentRequests().contains(request));
        assertTrue(John.getFriends().size() == 0);
        assertFalse(John.getFriends().contains(john_friend));
    }
}