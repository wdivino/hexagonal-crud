package com.divino.hexagonal.application.usecases;

public abstract class UseCase<INPUT, OUTPUT> {

    public abstract OUTPUT executar(INPUT input);
}
