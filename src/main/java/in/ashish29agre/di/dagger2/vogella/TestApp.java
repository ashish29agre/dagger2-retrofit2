/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.ashish29agre.di.dagger2.vogella;

import javax.inject.Inject;
import javax.inject.Named;
//http://frogermcs.github.io/dependency-injection-with-dagger-2-the-api/
//http://stackoverflow.com/questions/28661693/dagger2-dependency-gradle
//http://stackoverflow.com/questions/39902710/dagger2-providing-retrofit-instances-with-different-apis-same-time

/**
 *
 * @author Ashish
 */
public class TestApp {

    @Inject
    User user;

    @Inject
    BackendService backendService;

    private void testServer() {
        BackendComponent backendComponent = DaggerBackendComponent.builder()
                .build();
        backendComponent.inject(this);
        backendService.call();
        System.out.println("TestApp->User: " + user);
    }

    public static void main(String[] args) {
        new TestApp().testServer();
    }
}
