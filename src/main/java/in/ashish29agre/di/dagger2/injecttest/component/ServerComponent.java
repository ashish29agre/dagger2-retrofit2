/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.ashish29agre.di.dagger2.injecttest.component;

import dagger.Component;
import in.ashish29agre.di.dagger2.injecttest.TestInject;
//import in.ashish29agre.di.dagger2.injecttest.TestInject;
import in.ashish29agre.di.dagger2.injecttest.modules.ServerModule;
import in.ashish29agre.di.dagger2.injecttest.server.Server;
import in.ashish29agre.di.dagger2.injecttest.server.VideoServer;
import javax.inject.Named;
import javax.inject.Singleton;

/**
 *
 * @author Ashish
 */
@Singleton
@Component(modules = {ServerModule.class})
public interface ServerComponent {

    @Named("audio")
    Server provideAudioServer();

    @Named("video")
    Server provideVideoServer();

    void inject(TestInject inject);
}
