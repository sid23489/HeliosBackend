package com.siddharth.helios.dto;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobRequestDTO {
    @NotBlank
    private String name;

    @NotBlank
    private String cronExpr;

    @NotBlank
    private String command;

    @Min(0)
    private int maxRetries = 3;
}
