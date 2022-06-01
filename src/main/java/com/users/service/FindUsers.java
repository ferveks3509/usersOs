package com.users.service;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

@Service
public class FindUsers {

    public boolean checkUserName(String name) {
        String userHomeFolder = System.getProperty("user.home");
        String line;
        try (BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(userHomeFolder + "/users.txt")))) {
            while ((line = in.readLine()) != null) {
               if (line.contains(name)) {
                   return true;
               }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
