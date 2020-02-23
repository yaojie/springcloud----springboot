package com.southwind.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
public class Account {
    private long id;
    private String username;
	private String password;
    private String nickname;
    private String gender;
    private String telephone;
    private String address;
	private Date registerdate;
}
