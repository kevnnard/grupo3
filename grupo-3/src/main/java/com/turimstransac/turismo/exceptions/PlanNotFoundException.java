package com.turimstransac.turismo.exceptions;

public class PlanNotFoundException extends RuntimeException{
    public PlanNotFoundException(String message) {
        super(message);
    }
}
