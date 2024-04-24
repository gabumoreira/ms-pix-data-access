package me.gabu.pix.chave.adapters.http.in;

import java.util.Collection;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.gabu.pix.chave.adapters.http.in.dto.ChaveDTO;
import me.gabu.pix.chave.adapters.http.in.dto.mapper.ChaveDTOMapper;
import me.gabu.pix.chave.core.model.Chave;
import me.gabu.pix.chave.service.ChaveService;
import me.gabu.pix.chave.service.TokenService;

@Slf4j
@RestController
@RequestMapping("/chave")
@AllArgsConstructor
public class ChaveController {

    private final ChaveService service;
    private final TokenService tokenService;

    private ChaveDTOMapper mapper = ChaveDTOMapper.INSTANCE;

    @PostMapping
    @ApiOperation(value = "Cadastra novo Chave")
    public @ResponseBody ChaveDTO post(@RequestBody ChaveDTO chaveDTO, @RequestHeader("token") String token) {
        log.info("[POST] [/chave] Request: {}", chaveDTO);

        validaToken(token);

        Chave chave = toModel(chaveDTO);
        Chave chaveCriado = service.criarChave(chave, getUsuario(token));

        return toDTO(chaveCriado);
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Consulta chave já cadastrado pelo ID")
    public @ResponseBody ChaveDTO getByID(@PathVariable("id") UUID id, @RequestHeader("token") String token) {
        log.info("[GET] [/chave/{}]", id);

        validaToken(token);

        return toDTO(service.consultarChave(id));
    }

    @PutMapping(value = "/{id}")
    @ApiOperation(value = "Sobrescreve os dados de um chave cadastrado")
    public @ResponseBody ChaveDTO put(@PathVariable("id") UUID id, @RequestHeader("token") String token,
            @RequestBody ChaveDTO chaveDTO) {
        log.info("[PUT] [/chave/{}] Request: {}", id, chaveDTO);

        validaToken(token);

        Chave chave = toModel(chaveDTO);
        chave.setId(id);

        return toDTO(service.atualizarChave(chave, getUsuario(token)));
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation(value = "Apaga o registro de um chave")
    public ResponseEntity<ChaveDTO> delete(@PathVariable("id") UUID id, @RequestHeader("token") String token) {
        log.info("[DELETE] [/chave/{}]", id);
        validaToken(token);

        service.apagarChave(id, getUsuario(token));

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    @GetMapping
    @ApiOperation(value = "Lista todos os chave cadastrados, podendo ser filtrado do nome do chave")
    public @ResponseBody Collection<ChaveDTO> get(@RequestParam(required = false) String nome,
            @RequestHeader("token") String token) {
        validaToken(token);

        return toDTO(service.listarchave(nome));
    }

    private String getUsuario(String token) {
        return tokenService.recuperarUsuario(token);
    }

    private void validaToken(String token) {
        tokenService.validaToken(token);
    }

    protected Collection<ChaveDTO> toDTO(Collection<Chave> chaveCriada) {
        return mapper.modelToDto(chaveCriada);
    }

    protected ChaveDTO toDTO(Chave chaveCriada) {
        return mapper.modelToDto(chaveCriada);
    }

    protected Chave toModel(ChaveDTO chaveDTO) {
        return mapper.dtoToModel(chaveDTO);
    }

}
