package com.barook.accountservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer id;
    public String balance;

    @OneToOne(cascade = CascadeType.ALL)
    public User user;

}
