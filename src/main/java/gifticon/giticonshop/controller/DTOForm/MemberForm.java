package gifticon.giticonshop.controller.DTOForm;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
@NotEmpty(message = "위 항목은 필수 항목입니다.")
public class MemberForm {
    private String name;
    private String login_id;
    private String password;
}
