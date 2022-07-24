package com.course.algalogapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.algalogapi.domain.model.Cliente;
import com.course.algalogapi.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository clienteRepository;

	public Cliente save(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	public Optional<Cliente> findById(Long id) {
		return clienteRepository.findById(id);

	}

	public List<Cliente> findAll() {
		return clienteRepository.findAll();

	}

	public void removeById(Long id) {
		clienteRepository.deleteById(id);
	}

}
