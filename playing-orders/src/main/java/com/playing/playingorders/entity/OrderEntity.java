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
import java.time.LocalDateTime;
import java.util.Objects;

@Entity(name = "orders")
@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
public class OrderEntity {

    @Id
    @GeneratedValue
    private Long id;
    @NotNull(message = "DateTime can't be null")
    private LocalDateTime dateTime;
    private Double amount;

    public OrderEntity() { }

    @Override
    public boolean equals(final Object o) {
        if (this == o) { return true; }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) { return false; }
        final OrderEntity that = (OrderEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
