package com.turimstransac.turismo.controllers;

import com.turimstransac.turismo.exceptions.PlanNotFoundException;
import com.turimstransac.turismo.models.Plan;
import com.turimstransac.turismo.repositories.PlanRepository;
import org.springframework.web.bind.annotation.*;

@RestController
public class PlanController {

    private final PlanRepository planRepository;

    public PlanController(PlanRepository planRepository) {
        this.planRepository = planRepository;
    }

    @GetMapping("/plan/{planname}")
    Plan getPlan(@PathVariable String planname){
        return planRepository.findById(planname)
                .orElseThrow(() -> new PlanNotFoundException("No se encontro el plan con el nombre: " + planname));
    }

    @PostMapping("/plans")
    Plan newPlan(@RequestBody Plan plan){
        return planRepository.save(plan);
    }

}
