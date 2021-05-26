package org.cloudland.study.dubbo.treaty.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
public class Demo implements Serializable {

    private String id;

    private int age;

    private List<String> array;

}
