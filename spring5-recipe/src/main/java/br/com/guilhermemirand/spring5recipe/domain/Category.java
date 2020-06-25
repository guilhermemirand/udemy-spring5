package br.com.guilhermemirand.spring5recipe.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @ManyToMany(mappedBy = "categories")
    private Set<Recipe> recipes;

}
