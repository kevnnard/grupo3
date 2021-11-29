package com.turimstransac.turismo.repositories;

import com.turimstransac.turismo.models.Reserva;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ReservaRepository extends MongoRepository <Reserva,String>{
}
