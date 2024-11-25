package com.ichao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientService {
    //客户姓名
    private String clientName;
    //客户意见
    private String clientOpinion;
    //员工姓名
    private String employeeName;

}
