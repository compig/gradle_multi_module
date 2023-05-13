package com.coldbrew.common.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;


@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "board")
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private Long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @Embedded
    @Builder.Default
    private Audit audit = new Audit();

    public void update(Board updateBoard) {
        this.title = StringUtils.defaultIfEmpty(updateBoard.getTitle(), this.title);
        this.content = StringUtils.defaultIfEmpty(updateBoard.getContent(), this.content);
    }
}
