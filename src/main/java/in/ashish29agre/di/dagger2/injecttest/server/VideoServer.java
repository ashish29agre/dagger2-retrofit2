/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.ashish29agre.di.dagger2.injecttest.server;

/**
 *
 * @author Ashish
 */
public class VideoServer extends AbstractServer {

    @Override
    public String request(String request) {
        if (isStarted()) {
            return "Response from Video server: " + request;
        } else {
            throw new IllegalStateException("Server not started");
        }
    }
}
