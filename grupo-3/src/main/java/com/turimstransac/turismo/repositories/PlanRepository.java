package com.turimstransac.turismo.repositories;

import com.turimstransac.turismo.models.Plan;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PlanRepository extends MongoRepository <Plan, String> { }
