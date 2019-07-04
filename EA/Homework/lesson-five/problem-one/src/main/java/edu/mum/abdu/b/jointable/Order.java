package edu.mum.cs544.b.jointable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Setter
@Getter
@NoArgsConstructor
@Entity(name="JOrder")
public class Order {

    @Id
    @Column(length = 250)
    private String orderid;

    private LocalDateTime dateTime;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Order(String orderid, LocalDateTime dateTime) {
        this.orderid = orderid;
        this.dateTime = dateTime;
    }

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "order_id")
    private List<OrderLine> orderLineList = new ArrayList<>();


    public boolean addOrderLine(OrderLine orderLine) {
        return orderLineList.add(orderLine);
    }


}
