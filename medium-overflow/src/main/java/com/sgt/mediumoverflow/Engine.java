package com.sgt.mediumoverflow;

import org.springframework.stereotype.Component;

//bean bnaya
//always a class is made a bean not a method.
@Component
public class Engine {
    public int start(){
        System.out.println("hii");
        return 1;
    }
}
