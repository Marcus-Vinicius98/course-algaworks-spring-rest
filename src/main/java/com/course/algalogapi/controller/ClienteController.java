package com.course.algalogapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.course.algalogapi.domain.model.Cliente;
import com.course.algalogapi.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	ClienteService clienteService;

	@PostMapping
	public ResponseEntity<Cliente> save(@RequestBody Cliente cliente) {
		return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
	}

	@GetMapping("{/id}")
	public ResponseEntity<Cliente> findById(@PathVariable Long id) {
		return clienteService.findById(id).map(cliente -> ResponseEntity.status(HttpStatus.OK).body(cliente))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());

	}

	@GetMapping
	public ResponseEntity<List<Cliente>> findAll() {
		return ResponseEntity.ok().body(clienteService.findAll());

	}

	@PutMapping("/{clienteId}")
	public ResponseEntity<Cliente> update(@PathVariable Long clienteId, @Valid @RequestBody Cliente cliente) {
		if (!clienteService.existsById(clienteId)) {
			return ResponseEntity.notFound().build();
		}

		cliente.setId(clienteId);
		cliente = clienteService.save(cliente);

		return ResponseEntity.ok(cliente);
	}

	@DeleteMapping("/{clienteId}")
	public ResponseEntity<Void> remover(@PathVariable Long clienteId) {
		if (clienteService.existsById(clienteId)) {
			return ResponseEntity.notFound().build();
		}

		clienteService.removeById(clienteId);

		return ResponseEntity.noContent().build();
	}
}
