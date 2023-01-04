package org.example.model.pojos;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("bios")
public record Bios(@Field("_id") @Id String id,
                   @Field("name-english") String englishName,
                   @Field("name-greek") String greekName,
                   @Field("main-type") String mainType,
                   @Field("sub-type") String subType,
                   @Field("description") String description){
}
