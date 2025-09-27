package com.example.CifraFree.shared;

public interface IAuthorizationUseCase<I, O> {
    O execute(I input, Long userId);
}