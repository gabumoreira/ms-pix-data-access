
package me.gabu.pix.chave.service;

public interface TokenService {

    public void validaToken(String token);
    public String recuperarUsuario(String token);
}
