package com.bankingproject.model;

import com.bankingproject.utils.IdGeneratingClass;
import lombok.Data;

@Data
public class Administrator {

    private Long uniqueId;
    private String name;
    private String username;

    public Administrator() {

        this.uniqueId = IdGeneratingClass.generateIdforAdmin.incrementAndGet();
    }

    public Administrator(String name, String username) {

        this.uniqueId = IdGeneratingClass.generateIdforAdmin.incrementAndGet();
        this.name = name;
        this.username = username;
    }


}
