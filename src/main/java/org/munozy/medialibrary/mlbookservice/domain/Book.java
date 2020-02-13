package org.munozy.medialibrary.mlbookservice.domain;


import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(
        name = "book",
        schema = "ml_book_service",
        uniqueConstraints = {
                @UniqueConstraint(
                        columnNames = { "title" , "author"},
                        name = "constraint_unique_book_title_author"
                )
        }
)
public class Book {

    @Id
    @GeneratedValue(strategy =  GenerationType.SEQUENCE, generator = "sequence_book_generator")
    @GenericGenerator(
            name = "sequence_book_generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "ml_book_service.sequence_book_generator"),
                    @Parameter(name = "initial_value", value = "1000"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    long id;

    @NotNull
    @Size(min = 1, max = 255)
    @Column(name= "title", length = 255, nullable = false)
    String title;

    @NotNull
    @Size(min = 1, max = 255)
    @Column(name= "author", length = 255, nullable = false)
    String author;
}
