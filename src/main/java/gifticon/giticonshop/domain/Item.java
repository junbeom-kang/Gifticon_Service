package gifticon.giticonshop.domain;

import gifticon.giticonshop.exception.NotEnoughStockException;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
public class Item {
    @Id @GeneratedValue
    @Column(name="item_id")
    private Long id;
    private String name;
    private int price;
    private int stock;

    public void add(int plus) {
        this.stock+=plus;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                '}';
    }

    public void minus(int minus) {
        int temp=this.stock-minus;
        if (temp<0) {
            throw new NotEnoughStockException("재고가 부족합니다");
        }
        this.stock=temp;
    }
}
