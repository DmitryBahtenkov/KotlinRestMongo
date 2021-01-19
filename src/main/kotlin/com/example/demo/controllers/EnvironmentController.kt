package com.example.demo.controllers

import com.example.demo.DemoApplication
import com.example.demo.models.Environment
import com.example.demo.services.EnvironmentDao
import com.example.demo.services.EnvironmentService
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("api/environment")
class EnvironmentController(private val environmentService: EnvironmentService){
    @GetMapping fun getAll(): List<Environment> {
        return environmentService.getAll()
    }

    @GetMapping("{id}") fun getById(@PathVariable id: String): Optional<Environment> {
        return environmentService.getById(id)
    }

    @GetMapping("date/{date}") fun getByDate(@PathVariable date: String): List<Environment> {
        return environmentService.getByDate(date)
    }

    @PostMapping fun insert(@RequestBody environment: Environment): Environment {
        return environmentService.insert(environment)
    }

    @PutMapping fun update(@RequestBody environment: Environment): Environment {
        return environmentService.update(environment)
    }

    @DeleteMapping("{id}") fun deleteById(@PathVariable id: String): Optional<Environment> {
        return environmentService.deleteById(id)
    }
}
