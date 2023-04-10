package com.cookbook.cookbook.models.authors;

import com.cookbook.cookbook.schemas.cookbook.Author;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorDto {
    private String id;
    private String name;
    private String surname;

    public AuthorDto(Author author){
        this.id = author.getId();
        this.name = author.getName();
        this.surname = author.getSurname();
    }
}
