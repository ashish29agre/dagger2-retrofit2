/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.ashish29agre.di.dagger2.injecttest.modules;

import dagger.Module;
import dagger.Provides;
import in.ashish29agre.di.dagger2.injecttest.server.AudioServer;
import in.ashish29agre.di.dagger2.injecttest.server.Server;
import in.ashish29agre.di.dagger2.injecttest.server.VideoServer;
import javax.inject.Named;
import javax.inject.Singleton;

/**
 *
 * @author Ashish
 */
@Module
public class ServerModule {

    public ServerModule() {
    }

    @Provides
    @Named("audio")
    @Singleton
    Server provideAudioServer() {
        return new AudioServer();
    }

    @Provides
    @Named("video")
    @Singleton
    Server provideVideoServer() {
        return new VideoServer();
    }
}
