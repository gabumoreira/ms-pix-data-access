package me.gabu.pix.chave.service;

import me.gabu.pix.chave.core.model.Chave;
import me.gabu.pix.chave.service.validations.ValidationEnum;

public interface ValidationService {
    public void validate(Chave chave, ValidationEnum validation);
}
