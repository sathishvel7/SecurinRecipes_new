package com.example.demo;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="recipes")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cuisine;
    private String title;
    private Double rating;
    private Integer prepTime;
    private Integer cookTime;
    private Integer totalTime;

    @Column(length = 2000)
    private String description;

    @Lob
    private String nutrients; // JSON stored as text

    private String serves;
}

