package com.mainframe.mainframe.board.entity;

import com.mainframe.mainframe.member.entity.Member;
import com.mainframe.mainframe.roobit.entity.Roobit;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Entity
@Data
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long boardId;

    @Column(length = 20, nullable = false)
    private String boardName;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date dDay;

    @Column(nullable = false)
    private long boardTheme;

    @Column
    private String boardStatus;

    @Column
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @OneToMany(mappedBy = "board", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Roobit> roobits = new ArrayList<>();

    public enum BoardStatus {
        BOARD_ONGOING(1,"루빗보드 진행중"),
        BOARD_OPENED(2, "루빗보드 오픈 디데이"),
        BOARD_CLOSED(3, "루빗보드 닫힘"),
        BOARD_CANCELED(4, "루빗보드 취소");

        @Getter
        private int stepNumber;

        @Getter
        private String stepDescription;

        BoardStatus(int stepNumber, String stepDescription) {
            this.stepNumber = stepNumber;
            this.stepDescription = stepDescription;
        }
    }
}
