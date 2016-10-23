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
public abstract class AbstractServer implements Server {

    private boolean started;

    @Override
    public void start() {
        started = true;
    }

    @Override
    public void stop() {
        if (!started) {
            throw new IllegalStateException("Server was not started");
        }
    }

    public boolean isStarted() {
        return started;
    }
    
}
