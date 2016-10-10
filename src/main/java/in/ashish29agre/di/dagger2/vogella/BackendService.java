/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.ashish29agre.di.dagger2.vogella;

import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Ashish
 */
public class BackendService {

    private User user;

    private String serverUrl;

    public BackendService(String serverUrl, User user) {
        this.serverUrl = serverUrl;
        this.user = user;
    }

    public boolean call() {
        if (user != null && serverUrl != null && serverUrl.length() > 0) {
            System.out.println("Success->User: " + user.toString());
            System.err.println("ServerUrl: " + serverUrl);
            return true;
        } else {
            System.err.println("Failure->User: " + user);
            System.err.println("ServerUrl: " + serverUrl);
            return false;
        }
    }

}
