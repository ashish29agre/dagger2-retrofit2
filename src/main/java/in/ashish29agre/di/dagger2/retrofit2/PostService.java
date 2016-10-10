/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.ashish29agre.di.dagger2.retrofit2;

import java.util.List;
import java.util.logging.Logger;
import retrofit2.Call;

/**
 *
 * @author Ashish
 */
public class PostService {

    private static final Logger logger = Logger.getLogger(PostService.class.getSimpleName());
    private final Api api;

    public PostService(Api api) {
        this.api = api;
    }

    public Call<List<Post>> getPosts() {
        logger.info("Getting post frmo service");
        return api.getPosts();
    }
}
