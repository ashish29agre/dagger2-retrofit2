/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.ashish29agre.di.dagger2.retrofit2.views;

import java.util.List;

/**
 *
 * @author Ashish
 */
public interface ListView<E> {

    public void onListItems(List<E> items,
            int pageNum,
            int pageSize,
            boolean next);

}
