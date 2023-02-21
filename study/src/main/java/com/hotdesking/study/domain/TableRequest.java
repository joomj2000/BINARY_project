package com.hotdesking.study.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TableRequest {
    private String tableId;
    //private int using;
    //private String tableUser; // 애는 언굴 인식 후 추가
}
