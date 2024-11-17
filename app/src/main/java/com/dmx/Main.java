package com.dmx;

import com.dmx.user.domain.User;

public class Main {
    public static void main(String[] args) {
        User usuario = new User("David");
        System.out.println("usuario.getName() = " + usuario.getName());
    }
}