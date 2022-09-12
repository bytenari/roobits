package com.mainframe.mainframe.roobit.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import javax.persistence.*;

@NoArgsConstructor
@Data
@Entity
public class Roobit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roobitId;

    @Column
    private Long memberId;

    @Column(length = 15, nullable = false)
    private String password;

    @Column(length = 140, nullable = false)
    private String content;
}
