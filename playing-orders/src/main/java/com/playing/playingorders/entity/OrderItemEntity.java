package com.playing.playingorders.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity(name = "order_items")
@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
public class OrderItemEntity {

    @Id
    @GeneratedValue
    private Long id;
    @NotNull(message = "IdOrder can't be null")
    private Long idOrder;
    @NotNull(message = "IdProduct can't be null")
    private Long idProduct;
    @NotNull(message = "Quantity can't be null")
    private Integer quantity;

    public OrderItemEntity() { }

    @Override
    public boolean equals(final Object o) {
        if (this == o) { return true; }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) { return false; }
        final OrderItemEntity that = (OrderItemEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
