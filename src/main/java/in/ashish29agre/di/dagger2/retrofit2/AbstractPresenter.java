/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.ashish29agre.di.dagger2.retrofit2;

import in.ashish29agre.di.dagger2.retrofit2.views.View;
import java.util.logging.FileHandler;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 *
 * @author Ashish
 */
public abstract class AbstractPresenter {

    private static final Logger logger = Logger.getLogger(AbstractPresenter.class.getSimpleName());

    protected abstract View getView();

    /*
     * General indication whether api call stated or not.
     */
    protected void onApiCallStart() {
        logger.info("Api call started");
        View v = getView();
        if (v != null) {
            v.showProgressIndicator();
        }
    }

    protected void onApiCallEnd() {
        logger.info("Api call finished");
        View v = getView();
        if (v != null) {
            v.hideProgressIndicator();
        }
    }

    /*
     * General error handling 
     */
    protected void onApiCallError(Throwable e) {
        logger.info("Api call terminated with error");
        View v = getView();
        if (v != null && e != null) {
            v.onFailure(e.getMessage());
        }
    }
}
