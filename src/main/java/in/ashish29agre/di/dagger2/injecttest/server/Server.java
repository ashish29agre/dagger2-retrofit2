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
public interface Server {
    
    public void start();
    
    public void stop();

    public String request(String request);
}
