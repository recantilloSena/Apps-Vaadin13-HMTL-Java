/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaup.ui;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Synchronize;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.HtmlImport;

/**
 *
 * @author Ricardo
 */
@Tag("l2t-paper-rating")
@HtmlImport("bower_components/l2t-paper-rating/l2t-paper-rating.html")
public class PaperRating extends Component{

   
    
    public PaperRating() {
        
        
    }

    public void setIcon(String icon) {
        getElement().setProperty("icon", icon) ;
    }

    public void setTotal(String total) {
         getElement().setProperty("total", total) ;
    }

    
    public void setRating(String rating) {
         getElement().setProperty("rating", rating) ;
    }
    
    
    
    
}
