package com.example.application.views.loginform;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import jakarta.annotation.security.RolesAllowed;

@PageTitle("Login Form")
@Menu(icon = "line-awesome/svg/key-solid.svg", order = 0)
@Route(value = "")
@RouteAlias(value = "")
@RolesAllowed("USER")
public class LoginFormView extends Composite<VerticalLayout> {

    public LoginFormView() {
        H3 h3 = new H3();
        VerticalLayout layoutColumn2 = new VerticalLayout();
        EmailField emailField = new EmailField();
        PasswordField passwordField = new PasswordField();
        Button buttonPrimary = new Button();
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        getContent().setJustifyContentMode(JustifyContentMode.START);
        getContent().setAlignItems(Alignment.CENTER);
        h3.setText("Personal Information");
        h3.setWidth("100%");
        layoutColumn2.setWidthFull();
        getContent().setFlexGrow(1.0, layoutColumn2);
        layoutColumn2.setWidth("100%");
        layoutColumn2.getStyle().set("flex-grow", "1");
        emailField.setLabel("Email");
        passwordField.setLabel("Password field");
        passwordField.setWidth("min-content");
        buttonPrimary.setText("Save");
        buttonPrimary.setWidth("min-content");
        buttonPrimary.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        getContent().add(h3);
        getContent().add(layoutColumn2);
        layoutColumn2.add(emailField);
        layoutColumn2.add(passwordField);
        layoutColumn2.add(buttonPrimary);
    }
}
