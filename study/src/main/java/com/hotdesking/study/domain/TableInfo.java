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
public class TableInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tableSn;

    @Column
    private String tableId;

    @Column
    private boolean using;

    @Column
    private String tableUser;

}
