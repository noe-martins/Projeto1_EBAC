package dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import domain.Cliente;

public class ClienteMapDAO implements IClienteDAO{
	private Map<Long, Cliente> map;

    public ClienteMapDAO() {
        this.map = new HashMap<>();
    }
    @Override
    public Boolean register(Cliente client) {
        if(this.map.containsKey(client.getCpf())){
            return false;
        }
        this.map.put(client.getCpf(), client);
        return true;
    }

    @Override
    public void delete(Long cpf) {
        Cliente clientRegistered = this.map.get(cpf);

        if (clientRegistered != null){
            this.map.remove(clientRegistered.getCpf(), clientRegistered);
        }
    }

    @Override
    public void alter(Cliente client) { //cliente é o que está recebendo da tela e client register é o do map, já cadastrado
        Cliente clientRegistered = this.map.get(client.getCpf());
        if (clientRegistered != null){
            clientRegistered.setName(client.getName());
            clientRegistered.setTel(client.getTel());
            clientRegistered.setNumber(client.getNumber());
            clientRegistered.setName(client.getAdsress());
            clientRegistered.setCity(client.getCity());
            clientRegistered.setState(client.getState());
        }
    }

    @Override
    public Cliente consult(Long cpf) {
        return this.map.get(cpf);
    }

    @Override
    public Collection<Cliente> searchAll() {
        return this.map.values();
    }
}
