/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.ashish29agre.di.dagger2.retrofit2;

import in.ashish29agre.di.dagger2.retrofit2.modules.ApiModule;
import in.ashish29agre.di.dagger2.retrofit2.views.PostView;
import in.ashish29agre.di.dagger2.retrofit2.views.View;
import java.util.List;
import java.util.logging.Logger;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 *
 * @author Ashish
 */
public class PostPresenter extends AbstractPresenter {

    private static final Logger logger = Logger.getLogger(PostPresenter.class.getSimpleName());
    private PostView postView;
    private PostService postService;

    public PostPresenter(PostView postView, PostService postService) {
        this.postView = postView;
        this.postService = postService;
    }

    @Override
    protected View getView() {
        logger.info("Getting view");
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void getPosts() {
        logger.info("Getting posts ");
        Call<List<Post>> posts = this.postService.getPosts();
        postView.showProgressIndicator();
        posts.enqueue(new Callback<List<Post>>() {

            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> rspns) {
                postView.onListItems(rspns.body(), 1, 25, true);
                postView.hideProgressIndicator();
                postView.onSuccess();
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable thrwbl) {
                onApiCallError(thrwbl);
                postView.hideProgressIndicator();
            }
        });
    }
}
