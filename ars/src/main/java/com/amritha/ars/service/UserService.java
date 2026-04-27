package com.amritha.ars.service;

//service/UserService.java

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

 private Map<String, String> userStore = new HashMap<>();

 public boolean register(String username, String password) {
     if (userStore.containsKey(username)) return false;
     userStore.put(username, password);
     return true;
 }

 public boolean authenticate(String username, String password) {
     return userStore.containsKey(username) && userStore.get(username).equals(password);
 }
}
