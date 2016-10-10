/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.ashish29agre.di.dagger2.retrofit2.views;

/**
 *
 * @author Ashish
 */
public interface View {

    public void showProgressIndicator();

    public void hideProgressIndicator();

    public void onSuccess();

    public void onFailure();

    public void onFailure(String message);
}
