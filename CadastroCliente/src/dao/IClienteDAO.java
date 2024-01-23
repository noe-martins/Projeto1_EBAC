package dao;

import java.util.Collection;

import domain.Cliente;

public interface IClienteDAO {
	public Boolean register(Cliente client);
    public void delete(Long cpf);
    public void alter(Cliente client);
    public Cliente consult(Long cpf);
    public Collection<Cliente> searchAll();
}
