/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.ashish29agre.di.dagger2.injecttest;

import in.ashish29agre.di.dagger2.injecttest.component.DaggerServerComponent;
import in.ashish29agre.di.dagger2.injecttest.component.ServerComponent;
import in.ashish29agre.di.dagger2.injecttest.server.Server;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Ashish
 */
public class TestInject {

    private static final Logger logger = Logger.getLogger(TestInject.class.getSimpleName());

    @Inject
    @Named("audio")
    Server audioServer;
    
    @Inject
    @Named("video")
    Server videoServer;

    public TestInject() {
        ServerComponent component = DaggerServerComponent.builder()
                .build();
        component.inject(this);
    }

    public void testAudioServer() {
        String serverResponse = null;
        if (audioServer != null) {
            audioServer.start();
            serverResponse = audioServer.request("game.mp3");
            logger.warning(serverResponse);
            audioServer.stop();
        } else {
            serverResponse = "audio server Failure";
            logger.info(serverResponse);
        }
    }
    
    public void testVideoServer() {
        String serverResponse = null;
        if (videoServer != null) {
            videoServer.start();
            serverResponse = videoServer.request("movie.mp4");
            logger.warning(serverResponse);
            videoServer.stop();
        } else {
            serverResponse = "Video server Failure";
            logger.info(serverResponse);
        }
    }

    public static void main(String[] args) {
        TestInject testInject = new TestInject();
        testInject.testAudioServer();
        testInject.testVideoServer();
    }
}
