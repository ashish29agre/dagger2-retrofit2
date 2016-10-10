/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.ashish29agre.di.dagger2.vogella;

import dagger.Module;
import dagger.Provides;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 *
 * @author Ashish
 */
@Module
public class UserModule {

    @Provides
    @Singleton
    User user() {
        return new User("John", "Doe");
    }

}
