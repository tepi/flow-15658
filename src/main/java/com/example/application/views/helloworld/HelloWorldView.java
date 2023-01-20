package com.example.application.views.helloworld;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import com.example.application.views.MainLayout;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.server.StreamResource;

@PageTitle("Hello World")
@Route(value = "hello", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
public class HelloWorldView extends HorizontalLayout {

    private TextField name;
    private Button sayHello;

    public HelloWorldView() {
        for (int i = 1; i <= 5; i++)
            add(getImage("sample" + i + ".jpg"));
    }


    public Image getImage(String resourceName) {
        InputStream ioStream = this.getClass().getClassLoader().getResourceAsStream(resourceName);
        try {
            byte[] buf = ioStream.readAllBytes();
            Image img = new Image(new StreamResource("", () -> new ByteArrayInputStream(buf)), "");
            img.setWidth("200px");
            img.setHeight("200px");
            return img;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
