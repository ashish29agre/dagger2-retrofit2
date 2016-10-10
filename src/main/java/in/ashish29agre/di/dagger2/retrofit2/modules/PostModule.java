/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.ashish29agre.di.dagger2.retrofit2.modules;

import dagger.Module;
import dagger.Provides;
import in.ashish29agre.di.dagger2.retrofit2.Api;
import in.ashish29agre.di.dagger2.retrofit2.PostPresenter;
import in.ashish29agre.di.dagger2.retrofit2.PostService;
import in.ashish29agre.di.dagger2.retrofit2.scopes.UserScope;
import in.ashish29agre.di.dagger2.retrofit2.views.PostView;
import java.util.logging.Logger;

/**
 *
 * @author Ashish
 */
@Module
public class PostModule {

    private static final Logger logger = Logger.getLogger(PostModule.class.getSimpleName());
    private final PostView postView;

    public PostModule(PostView postView) {
        this.postView = postView;
    }

    @Provides
    @UserScope
    PostService providePostService(Api api) {
        logger.info("Provider post with api now");
        return new PostService(api);
    }

    @Provides
    @UserScope
    PostPresenter providePostPresenter(PostService service) {
        logger.info("Providing presenter with service now");
        return new PostPresenter(postView, service);
    }
}
