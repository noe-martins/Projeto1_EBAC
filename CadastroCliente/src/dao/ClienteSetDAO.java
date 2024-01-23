package dao;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import domain.Cliente;

public class ClienteSetDAO implements IClienteDAO{
	private Set<Cliente> set;

    public ClienteSetDAO() {
        this.set = new HashSet<>();
    }

    @Override
    public Boolean register(Cliente client) {
        return this.set.add(client);
    }

    @Override
    public void delete(Long cpf) {
        Cliente clientFound = null;
        for (Cliente client : this.set) {
            if (client.getCpf().equals(cpf)) {
                clientFound = client;
                break;
            }else System.out.println("Resgistro não existe");
        }

        if (clientFound != null) {
            this.set.remove(clientFound);
        }
    }


    @Override
    public void alter(Cliente client) {
        if (this.set.contains(client)) {
            for (Cliente clientRegistered : this.set) {
                if (clientRegistered.equals(client)) {
                    clientRegistered.setName(client.getName());
                    clientRegistered.setTel(client.getTel());
                    clientRegistered.setNumber(client.getNumber());
                    clientRegistered.setName(client.getAdsress());
                    clientRegistered.setCity(client.getCity());
                    clientRegistered.setState(client.getState());
                    break;
                }
            }
        }
    }

    @Override
    public Cliente consult(Long cpf) {
        for (Cliente clientRegistered : this.set) {
            if (clientRegistered.getCpf().equals(cpf)) {
                return clientRegistered;
            }
        }
        return null;
    }

    @Override
    public Collection<Cliente> searchAll() {
        return this.set;
    }
}
