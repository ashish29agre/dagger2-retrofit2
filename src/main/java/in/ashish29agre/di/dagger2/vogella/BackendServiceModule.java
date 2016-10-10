/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.ashish29agre.di.dagger2.vogella;

import dagger.Module;
import dagger.Provides;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

/**
 *
 * @author Ashish
 */
@Module
public class BackendServiceModule {

//    private String url;
////    public BackendServiceModule(String url) {
//        this.url = url;
//    }
    @Provides
    @Singleton
    BackendService proviedBackendServiceModule(@Named("testUrl") String serverUrl, User user) {
        return new BackendService(serverUrl, user);
    }

    @Provides
    @Named("testUrl")
    String provideTestUrl() {
        return "http://www.facebook.com";
    }

    @Provides
    @Named("serverUrl")
    String provideServerUrl() {
        return "http://www.google.com";
    }
}
