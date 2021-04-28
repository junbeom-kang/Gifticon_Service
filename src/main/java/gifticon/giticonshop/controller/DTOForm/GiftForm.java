package gifticon.giticonshop.controller.DTOForm;

import lombok.Data;

@Data
public class GiftForm {
    public Long buyerId;
    public Long getterId;
    public Long itemId;
    public int count;
}
