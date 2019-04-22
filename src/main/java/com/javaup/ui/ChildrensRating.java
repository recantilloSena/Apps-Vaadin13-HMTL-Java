/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaup.ui;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

/**
 *
 * @author Ricardo
 */
public class ChildrensRating extends HorizontalLayout{

    private final Label label = new Label("Nro de Hijos :");
    private final PaperRating rating = new PaperRating();
    
    public ChildrensRating() {
        rating.setIcon("face");
        rating.setTotal("5");
        
        add(label,rating);
        
    }
    
    
    
}
