package com.ichao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contact {
    //合同名
    private String name;
    //客户名字
    private String clientName;
    //员工名字
    private String employeeName;
    //合同内容
    private String contents;
    //合同生效时间
    private String start;
    //合同到期时间
    private String end;


}
