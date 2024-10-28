package com.example.Calculator.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculate")
public class Calcontroller {
	
	@PostMapping("/add")
	public int addition(@RequestBody List<Integer> numbers) {
		return numbers.stream().mapToInt(Integer::intValue).sum();	
	}
	@PostMapping("/sub")
	public int subtraction(@RequestBody List<Integer> numbers) {
		return numbers.stream().reduce((a,b) -> a- b).orElse(0);
	}
    @PostMapping("/mult")
    public int multiplication(@RequestBody List<Integer> numbers) {
    	if(numbers.contains(0)){
    		return 0;
    	}
    	return numbers.stream().reduce((a,b) -> a*b).orElse(1);
    }
    
    @GetMapping("/div")
    public int division(@RequestParam int a, @RequestParam int b) {
    		if(b == 0) {
    			throw new IllegalArgumentException("division should not done with 0");
    		}
    		return a/b;
    	}
    
}
