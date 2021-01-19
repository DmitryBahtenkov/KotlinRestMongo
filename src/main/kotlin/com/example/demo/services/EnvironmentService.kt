package com.example.demo.services

import com.example.demo.models.Environment
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.time.LocalTime
import java.util.*

@Suppress("DEPRECATION")
@Service
class EnvironmentService(private val environmentDao: EnvironmentDao): CrudBase<String, Environment> {
    override fun getAll(): List<Environment> {
        return environmentDao.findAll()
    }

    override fun getById(id: String): Optional<Environment> {
        return environmentDao.findById(id)
    }

    fun getByDate(date: String): List<Environment> {
        return environmentDao.findByDate(LocalDate.parse(date))
    }

    override fun insert(obj: Environment): Environment {
        obj.date = LocalDate.now()
        obj.time = LocalTime.now()
        return environmentDao.insert(obj)
    }

    override fun update(obj: Environment): Environment {
        return environmentDao.save(obj)
    }

    override fun deleteById(id: String): Optional<Environment> {
        return environmentDao.findById(id).apply {
            this.ifPresent { environmentDao.delete(it) }
        }
    }
}
