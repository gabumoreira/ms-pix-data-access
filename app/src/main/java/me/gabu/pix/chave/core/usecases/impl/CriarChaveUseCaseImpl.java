package me.gabu.pix.chave.core.usecases.impl;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.gabu.pix.chave.adapters.data.dao.ChaveDAO;
import me.gabu.pix.chave.core.model.Chave;
import me.gabu.pix.chave.core.usecases.CriarChaveUseCase;
import me.gabu.pix.chave.service.ValidationService;
import me.gabu.pix.chave.service.validations.ValidationEnum;

@Slf4j
@Service
@AllArgsConstructor
public class CriarChaveUseCaseImpl implements CriarChaveUseCase {

    private final ChaveDAO dao;
    private final ValidationService validator;

    @Override
    public Chave run(Chave chave, String usuario) {
        log.info("[USECASE] [CREATE] {}", chave);
        validator.validate(chave, ValidationEnum.CREATE);
        chave.setUsuarioCriacao(usuario);
        return dao.save(chave);
    }

}
