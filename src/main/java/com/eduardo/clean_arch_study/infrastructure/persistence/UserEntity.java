package com.eduardo.clean_arch_study.infrastructure.persistence;

import com.eduardo.clean_arch_study.core.enums.UserType;
import jakarta.persistence.*;

@Entity
@Table(name = "TB_USERS")
public class UserEntity {

    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false, unique = true, length = 11)
    private String cpf;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserType type;

    public UserEntity() {
    }

    public UserEntity(Long id, String username, String email, String cpf, UserType type) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.cpf = cpf;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }
}
