package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Employee;
import com.demo.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService es;

	@GetMapping(value = "/")
	public List<Employee> m1() {
		return es.findAll();
	}

	@GetMapping(value = "/req1/{a}")
	public Employee m2(@PathVariable int a) {
		return es.findByEid(a);
	}

	@GetMapping(value = "/req2/{a}/{b}")
	public Employee m3(@PathVariable int a, @PathVariable String b) {
		return es.findByEidAndEname(a, b);
	}

	@GetMapping(value = "/req3/{a}/{b}")
	public List<Employee> m4(@PathVariable int a, @PathVariable String b) {
		return es.findByEidOrEname(a, b);
	}

	@PostMapping(value = "/save")
	public Employee m5(@RequestBody Employee e) {
		return es.save(e);
	}

	@PutMapping(value = "/update")
	public Employee m6(@RequestBody Employee e) {
		return es.save(e);
	}
	@DeleteMapping(value = "/delete/{eid}")
	public int m7(@PathVariable int eid) {
		
		return es.deleteByEid(eid);
	}
}
