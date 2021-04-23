package gifticon.giticonshop.controller;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
@NotEmpty
public class MemberForm {
    private String name;
    private String login_id;
    private String password;
}
