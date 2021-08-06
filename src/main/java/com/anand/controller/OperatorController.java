package com.anand.controller;

import com.anand.model.OperatorRequest;
import com.anand.orchestration.OperatorOrchestration;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequestMapping(value = "/operators")
@RestController
public class OperatorController {
    private final OperatorOrchestration operatorOrchestration;

    public OperatorController(OperatorOrchestration operatorOrchestration) {
        this.operatorOrchestration = operatorOrchestration;
    }

    @PostMapping(consumes = "application/json")
    public Integer operator(@RequestBody @Valid OperatorRequest operatorRequest) {
        return operatorOrchestration.doOperation(operatorRequest);
    }
}
