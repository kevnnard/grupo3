package com.turimstransac.turismo.controllers;

import com.turimstransac.turismo.exceptions.PlanNotFoundException;
import com.turimstransac.turismo.models.Reserva;
import com.turimstransac.turismo.models.Plan;
import com.turimstransac.turismo.repositories.PlanRepository;
import com.turimstransac.turismo.repositories.ReservaRepository;
import org.springframework.web.bind.annotation.*;
// import java.util.Date;
// import java.util.List;
// import java.util.stream.Collectors;
// import java.util.stream.Stream;

// import javax.print.DocFlavor.READER;

public class ReservaController {
    private final PlanRepository planRepository;
    private final ReservaRepository reservaRepository;

    public ReservaController(PlanRepository planRepository, ReservaRepository reservaRepository) {
        this.planRepository = planRepository;
        this.reservaRepository = reservaRepository;
    }
    @PostMapping("/reservas")
    Reserva newReserva(@RequestBody Reserva reserva) {
        Plan newplan = planRepository.findById(reserva.getIdplan()).orElse(null);

        if(newplan == null){
            throw new PlanNotFoundException("No sé encontró: "+ reserva.getIdplan());
        }

        newplan.setLugar(newplan.getLugar());
        planRepository.save(newplan);


        return reservaRepository.save(reserva);
    }
}
