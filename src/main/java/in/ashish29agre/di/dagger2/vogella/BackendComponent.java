/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.ashish29agre.di.dagger2.vogella;

import dagger.Component;
import javax.inject.Singleton;

/**
 *
 * @author Ashish
 */
@Singleton
@Component(modules = {UserModule.class, BackendServiceModule.class})
public interface BackendComponent {

    BackendService proviedBackendServiceModule();

    void inject(TestApp app);

}
