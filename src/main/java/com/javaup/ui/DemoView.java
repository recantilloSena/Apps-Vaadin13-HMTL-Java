/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaup.ui;

import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.Notification.Position;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 *
 * @author Ricardo
 */
@Route(value = "demoView", layout = MainLayout.class)
@PageTitle("Ejemplos Vaadin 13")
public class DemoView extends VerticalLayout{

    
    
    public DemoView() {
        //Inlcuir componentes de nuestra Vista!!
        NumberField number = new NumberField();
        number.setHasControls(true);
        number.setValue(1d);
        number.setMin(0);
        number.setMax(10);
        
        //ComboBox - Select - List
        List<Locale> locales = Arrays.asList(new Locale("Other"),
        new Locale("es"),
        new Locale("fi"),
        new Locale("en"));

            Select<Locale> select = new Select<>();
            select.setPlaceholder("Language");
            select.setTextRenderer(Locale::getDisplayLanguage);
            select.setItemLabelGenerator(locale -> {
                if ("Other".equalsIgnoreCase(locale.getLanguage())) {
                    // Empty label string will show the placeholder
                    return "";
                } else {
                    return locale.getISO3Language();
                }
            });
            
        select.setItems(locales);
        
        //Acordion + forms
        // BEGIN ACCORDION
Accordion accordion = new Accordion();

// ACCOUNT INFORMATION
        FormLayout accountForm = new FormLayout();
        accountForm.add(new TextField("Email"));
        accountForm.add(new ChildrensRating());
        accountForm.add(new PasswordField("Password"));
        accountForm.add(new PasswordField("Confirm password"));

        accordion.add("Account information", accountForm);

// PROFILE INFORMATION
        FormLayout profileInfoForm = new FormLayout();
        profileInfoForm.add(new TextField("First name"));
        profileInfoForm.add(new TextField("Last name"));
        RadioButtonGroup<String> languageGroup = new RadioButtonGroup<>();
        languageGroup.setLabel("Language");
        languageGroup.setItems("English", "Finnish");
        profileInfoForm.add(languageGroup);
        profileInfoForm.add(new DatePicker("Date of birth"));

        accordion.add("Profile information", profileInfoForm);

// TOPICS OF INTEREST
        FormLayout topicsForm = new FormLayout();
        topicsForm.add(new Checkbox("Culture"));
        topicsForm.add(new Checkbox("Environment"));
        topicsForm.add(new Checkbox("Fashion"));
        topicsForm.add(new Checkbox("Finance"));
        topicsForm.add(new Checkbox("Food", true));
        topicsForm.add(new Checkbox("Politics"));
        topicsForm.add(new Checkbox("Sports"));
        topicsForm.add(new Checkbox("Technology", true));

        accordion.add("Topics of interest", topicsForm);

// TERMS AND CONDITIONS
        Paragraph paragraph = new Paragraph();
        paragraph.setText("After all has been said and done, I agree that "
                + "my data shall be safely stored for the sole purpose of "
                + "my ultimate enjoyment.");

        Button submit = new Button("Sign up");
        submit.setEnabled(false);
        submit.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        submit.addClickListener(e -> Notification.show("Complete! \uD83D\uDC4D",
                4000, Position.BOTTOM_END));
        Checkbox consent = new Checkbox("I agree");
        consent.addValueChangeListener(e -> submit.setEnabled(e.getValue()));

        HorizontalLayout bottomPanel = new HorizontalLayout(consent, submit);
        bottomPanel.setWidthFull();
        bottomPanel.setFlexGrow(1, consent);
        VerticalLayout terms = new VerticalLayout(paragraph, bottomPanel);

        accordion.add("Terms and conditions", terms);
        
        PaperRating rating = new PaperRating();
        
        rating.setIcon("favorite");
        rating.setTotal("10");
        
        
        
        
        
        add(rating, number, select, accordion);
        
        
        
        
    }
    
    
    
}
