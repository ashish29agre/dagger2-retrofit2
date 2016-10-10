/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.ashish29agre.di.dagger2.retrofit2.components;

import dagger.Component;
import in.ashish29agre.di.dagger2.retrofit2.Api;
import in.ashish29agre.di.dagger2.retrofit2.modules.ApiModule;
import javax.inject.Singleton;

/**
 *
 * @author Ashish
 */
@Singleton
@Component(modules = ApiModule.class)
public interface ApiComponent {

    Api provideApi();

}
