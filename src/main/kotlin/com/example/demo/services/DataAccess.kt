package com.example.demo.services

import com.example.demo.models.Environment
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories
import java.time.LocalDate
import java.time.LocalTime
import java.util.*

// интерфейс для data access object
@EnableMongoRepositories
interface EnvironmentDao: MongoRepository<Environment, String> {
    fun findByDate(date: LocalDate, time: LocalTime? = null): List<Environment>
}

// интерфейс для базовых CRUD-операций
interface CrudBase<K, T> {
    fun getAll(): List<T>
    fun getById(id:K): Optional<T>
    fun insert(obj:T): T
    fun update(obj:T): T
    fun deleteById(id: K):Optional<T>
}