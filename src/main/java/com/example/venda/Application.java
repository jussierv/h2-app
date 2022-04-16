package com.example.venda;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.example.entity.Cliente;
import com.example.repository.ClienteRepository;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.example")
public class Application {
	
	@Autowired ClienteRepository clienteRepository;
	
	@Bean 
	public CommandLineRunner init() {
		return args -> {
//			clienteRepository.salvar(new Cliente("Jussiêr"));
//			clienteRepository.salvar(new Cliente("Adriana"));
			
			List<Cliente> clientes = clienteRepository.getAll();
			
			clientes.forEach(System.out::println);
			
//			
//			clientes.forEach(c -> {
//				c.setNome(c.getNome()+" atualizado.");
//				c.setId(c.getId());
//				clienteRepository.atualizar(c);
//			});
//			
//			clientes = clienteRepository.getAll();
//			clientes.forEach(System.out::println);
//			
//			clienteRepository.getNome("adr").forEach(System.out::println);
			
		};
	}

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
