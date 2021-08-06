package com.anand.model;


import com.anand.enums.OperatorEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class OperatorRequest {
    @NotNull(message = "operator is required")
    private OperatorEnum operator;
    @NotNull(message = "left is required")
    private int left;
    @NotNull(message = "right is required")
    private int right;
}
