package com.users.service;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class FindUsers {

    public boolean checkUserNameInList(String userName) {
        try {
            List<String> users = findAllUserInWindows();
            return users.contains(userName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    private List<String> findAllUserInWindows() throws IOException {
        String command = "powershell.exe Get-LocalUser";
        Process pw = Runtime.getRuntime().exec(command);
        String line;
        List<String> users = new ArrayList<>();
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(pw.getInputStream()))) {
            while ((line = bf.readLine()) != null) {
                String[] q = line.split(" ");
                users.add(q[0]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }
}
