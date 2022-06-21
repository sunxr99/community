package com.nowcoder.community.service;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
//@Scope("prototype")
public class AlphaService {

    public AlphaService() {
        System.out.println("实力话");

    }

    @PostConstruct
    public void init(){
        System.out.println(
                "init"
        );
    }
    @PreDestroy
    public void destroy(){
        System.out.println("destroy");
    }
}
