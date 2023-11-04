package com.docplus.entity;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.imifou.jsonschema.module.addon.TypeFormat;
import com.github.imifou.jsonschema.module.addon.annotation.JsonSchema;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document
@ToString
@EqualsAndHashCode(callSuper = false)
@JsonPropertyOrder({"examinationDate",
        "patientId",
        "height",
        "weight",
        "bpmin",
        "bpmax",
        "heartRate",
        "temperature",
        "saturation",
        "notes"
})
public class VitalInfo {

    @Id
    @NotNull
    @JsonSchema(ignore = true)
    private String id;

    @NotNull
    @JsonSchema(title = "Examination Date", description = "Please enter the examination date & Time", required = true, format = TypeFormat.DATE_TIME)
    @JsonPropertyDescription("First Name")
    private LocalDate examinationDate;

    @NotNull
    private Integer patientId;

    @NotNull
    @JsonSchema(title = "Height (cm)", description = "Please enter the height", required = true)
    @JsonPropertyDescription("Height (cm)")
    private Integer height;

    @NotNull
    @JsonSchema(title = "Weight (kg)", description = "Please enter the examination date & Time", required = true)
    @JsonPropertyDescription("Weight (kg)")
    private Double weight;

    @NotNull
    @JsonSchema(title = "Blood Pressure MIN (mmHg)", description = "Please enter the min blood pressure", required = true)
    @JsonPropertyDescription("Blood Pressure MIN")
    private Integer bpmin;

    @NotNull
    @JsonSchema(title = "Blood Pressure MAX in mmHg", description = "Please enter the max blood pressure", required = true)
    @JsonPropertyDescription("Blood Pressure MAX ")
    private Integer bpmax;


    @NotNull
    @JsonSchema(title = "Heart Rate", description = "Please enter the heart rate", required = true)
    @JsonPropertyDescription("Heart Rate")
    private Integer heartRate;

    @NotNull
    @JsonSchema(title = "Temperature (°C)", description = "Please enter the temperature in °C", required = true)
    @JsonPropertyDescription("Temperature (°C)")
    private Integer temperature;

    @NotNull
    @JsonSchema(title = "Saturation (%)", description = "Please enter the saturation in %", required = true)
    @JsonPropertyDescription("Temperature (°C)")
    private Integer saturation;

    @NotNull
    @JsonSchema(title = "Notes", description = "Please enter the notes", required = true)
    @JsonPropertyDescription("Notes")
    private List<Note> notes;


}
