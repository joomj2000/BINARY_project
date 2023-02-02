package com.hotdesking.study.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Table
public class User{
    @Id
    @GeneratedValue //(strategy = GenerationType.IDENTITY)
    private Long userSn;

    @Column(unique = true)
    private String userId;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String userName;
}
