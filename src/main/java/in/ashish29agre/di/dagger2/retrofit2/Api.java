/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.ashish29agre.di.dagger2.retrofit2;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 *
 * @author Ashish
 */
public interface Api {

    @GET("/posts")
    Call<List<Post>> getPosts();
}
