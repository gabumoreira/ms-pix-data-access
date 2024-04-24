package me.gabu.pix.chave.service.impl;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import lombok.AllArgsConstructor;
import me.gabu.pix.chave.core.exceptions.UnprocessableEntityException;
import me.gabu.pix.chave.core.model.Chave;
import me.gabu.pix.chave.service.ValidationService;
import me.gabu.pix.chave.service.validations.Create;
import me.gabu.pix.chave.service.validations.Update;
import me.gabu.pix.chave.service.validations.ValidationEnum;

@Service
@AllArgsConstructor
public class ValidationServiceImpl implements ValidationService {

    private final Validator validator;

    @Override
    public void validate(Chave chave, ValidationEnum validation) {

        Set<ConstraintViolation<Chave>> contraints = getContraints(chave, validation);

        if (!CollectionUtils.isEmpty(contraints))
            throw new UnprocessableEntityException(processaContraint(contraints));

    }

    private Set<ConstraintViolation<Chave>> getContraints(Chave chave, ValidationEnum validation) {
        switch (validation) {
        case CREATE:
            return getValidator().validate(chave, Create.class);

        case UPDATE:
        default:
            return getValidator().validate(chave, Update.class);
        }
    }

    protected Validator getValidator() {
        return validator;
    }

    private List<String> processaContraint(Set<ConstraintViolation<Chave>> contraints) {
        return contraints.stream()
                .map(violation -> String.format("[%s %s]",
                        StreamSupport.stream(violation.getPropertyPath().spliterator(), false)
                                .reduce((first, second) -> second).orElse(null),
                        violation.getMessage()))
                .collect(Collectors.toList());
    }

}
