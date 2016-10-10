/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.ashish29agre.di.dagger2.retrofit2;

import com.google.gson.Gson;
import in.ashish29agre.di.dagger2.retrofit2.components.ApiComponent;
import in.ashish29agre.di.dagger2.retrofit2.components.DaggerApiComponent;
import in.ashish29agre.di.dagger2.retrofit2.components.DaggerPostComponent;
import in.ashish29agre.di.dagger2.retrofit2.components.PostComponent;
import in.ashish29agre.di.dagger2.retrofit2.modules.ApiModule;
import in.ashish29agre.di.dagger2.retrofit2.modules.PostModule;
import in.ashish29agre.di.dagger2.retrofit2.views.PostView;
import java.util.List;
import java.util.logging.Logger;
import javax.inject.Inject;

/**
 *
 * @author Ashish
 */
public class NetworkTest implements PostView {

    private static final Logger logger = Logger.getLogger(NetworkTest.class.getSimpleName());

    private PostComponent component;
    @Inject
    PostPresenter presenter;

    public NetworkTest(ApiComponent apiComponent) {
        component = DaggerPostComponent.builder()
                .apiComponent(apiComponent)
                .postModule(new PostModule(this))
                .build();
    }

    public void init() {
        component.inject(this);
    }

    void showPosts() {
        if (presenter != null) {
            logger.info("Hurray it worked");
            presenter.getPosts();
        } else {
            logger.warning("Alas it failed");
        }
    }

    @Override
    public void showProgressIndicator() {
        logger.info("Show progress indicator here");
    }

    @Override
    public void hideProgressIndicator() {
        logger.info("Hide progress indicator here");
    }

    @Override
    public void onSuccess() {
        logger.info("Api calls successfull");
        System.exit(0);
    }

    @Override
    public void onFailure() {
        logger.warning("Api call failure");
        System.exit(0);
    }

    @Override
    public void onFailure(String message) {
        logger.warning(message);
        System.exit(0);
    }

    @Override
    public void onListItems(List<Post> items, int pageNum, int pageSize, boolean next) {
        logger.info("List received is: " + new Gson().toJson(items));
    }

    @Override
    public void onEmpty(String e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void main(String[] args) {
        ApiComponent apiComponent = DaggerApiComponent.builder()
                .apiModule(new ApiModule("https://jsonplaceholder.typicode.com/"))
                .build();

        NetworkTest networkTest = new NetworkTest(apiComponent);
        networkTest.init();
        networkTest.showPosts();
    }

}
