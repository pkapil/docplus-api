package com.docplus.entity;

import com.github.imifou.jsonschema.module.addon.TypeFormat;
import com.github.imifou.jsonschema.module.addon.annotation.JsonSchema;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@EqualsAndHashCode(callSuper = false)
public class Note {

    @NotNull
    @JsonSchema(title = "Time of note", description = "Please enter note taking time", required = true)
    private String dateOfNote;

    @NotNull
    @JsonSchema(title = "Details", description = "Note details", required = true)
    private String summary;
}
