package com.example.CifraFree.shared;

public interface IUseCase<I, O> {
    O execute(I input);
}
