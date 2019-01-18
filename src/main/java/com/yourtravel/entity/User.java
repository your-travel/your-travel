package com.yourtravel.entity;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "USER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false)
    private String login;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String secondName;

    @Column(nullable = false)
    private Boolean enable;

    private Integer warn = 0;

    @Lob
    @Column(columnDefinition = "BLOB")
    byte[] avatar;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = { @JoinColumn(name = "role_id") }
            )
    private Set<Role> roles = new HashSet<>();
}
