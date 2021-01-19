package com.example.demo.models

import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDate
import java.time.LocalTime

@Document
data class Environment(
    @Id val id:String? = null,
    val temp: Double, // температура воздуха
    val humidity: Double, // влажность воздуха
    val pressure: Double, // давление
    val radiation: Double, // уровень радиации
    var date: LocalDate?, // дата получения информации
    var time: LocalTime?
    )
