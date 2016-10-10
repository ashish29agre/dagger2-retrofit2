/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.ashish29agre.di.dagger2.retrofit2.components;

import dagger.Component;
import in.ashish29agre.di.dagger2.retrofit2.NetworkTest;
import in.ashish29agre.di.dagger2.retrofit2.PostPresenter;
import in.ashish29agre.di.dagger2.retrofit2.modules.PostModule;
import in.ashish29agre.di.dagger2.retrofit2.scopes.UserScope;
import in.ashish29agre.di.dagger2.retrofit2.views.PostView;

/**
 *
 * @author Ashish
 */
@UserScope
@Component(dependencies = ApiComponent.class, modules = PostModule.class)
public interface PostComponent {

    PostPresenter providePostPresenter();

    void inject(NetworkTest networkTest);
}
