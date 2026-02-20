package com.devhamaad.Personalized.Quote.Generator.API.with.SQ.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(
        name = "quotes",
        indexes = {
                @Index(name = "idx_author", columnList = "author"),
                @Index(name = "idx_category", columnList = "category")
        }
)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Quote implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(
            name = "text",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String text;

    @Column(
            name = "author",
            nullable = false,
            length = 150
    )
    private String author;

    @Column(
            name = "category",
            nullable = false,
            length = 100
    )
    private String category;

    @Column(
            name = "requested_count",
            nullable = false,
            columnDefinition = "INT DEFAULT 0"
    )
    private Integer requestedCount = 0;


}
