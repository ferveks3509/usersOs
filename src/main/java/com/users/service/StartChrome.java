package com.users.service;

import java.io.IOException;

public class StartChrome {

    public void start() {
        Runtime runtime = Runtime.getRuntime();
        try {
            runtime.exec("cmd /c start http://localhost:8080/");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
