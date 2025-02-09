package org.wikipedia.homeworks.homework04

import java.time.LocalTime
import java.time.format.DateTimeFormatter

// Класс для хранения занятия
data class ScheduleEntity(val lesson: String, val startTime: LocalTime, val endTime: LocalTime)

// Дни недели
enum class Days {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

// Класс расписания
class Schedule {
    private val scheduleOfWeek = mutableMapOf<Days, MutableList<ScheduleEntity>>()
    private val timeFormatter = DateTimeFormatter.ofPattern("HH:mm")

    fun addSchedule(day: Days, scheduleEntity: ScheduleEntity) {
        scheduleOfWeek.getOrPut(day) { mutableListOf() }.add(scheduleEntity)
    }

    override fun toString(): String {
        return scheduleOfWeek.toSortedMap()
            .map { (day, list) ->
                list.sortedBy { it.startTime }
                    .joinToString("\n") {
                        "\t${it.lesson}: ${it.startTime.format(timeFormatter)} - ${it.endTime.format(timeFormatter)}"
                    }.let {
                        "${day.name.lowercase().replaceFirstChar { it.uppercase() }}:\n$it"
                    }
            }.joinToString("\n\n")
    }
}

// Глобальная переменная для хранения текущего дня недели
private var currentDay: Days? = null
private lateinit var currentSchedule: Schedule

// Оператор для создания диапазона времени
operator fun String.rangeTo(other: String): Pair<LocalTime, LocalTime> {
    val formatter = DateTimeFormatter.ofPattern("HH:mm")
    return LocalTime.parse(this, formatter) to LocalTime.parse(other, formatter)
}

// Инфиксная функция для добавления занятия
infix fun Pair<LocalTime, LocalTime>.schedule(lesson: String) {
    val (start, end) = this
    currentDay?.let { currentSchedule.addSchedule(it, ScheduleEntity(lesson, start, end)) }
}

// Функции для задания дней недели
fun Schedule.monday(block: Schedule.() -> Unit) {
    currentDay = Days.MONDAY
    block()
    currentDay = null
}

fun Schedule.tuesday(block: Schedule.() -> Unit) {
    currentDay = Days.TUESDAY
    block()
    currentDay = null
}

fun Schedule.wednesday(block: Schedule.() -> Unit) {
    currentDay = Days.TUESDAY
    block()
    currentDay = null
}

fun Schedule.thursday(block: Schedule.() -> Unit) {
    currentDay = Days.TUESDAY
    block()
    currentDay = null
}

fun Schedule.friday(block: Schedule.() -> Unit) {
    currentDay = Days.TUESDAY
    block()
    currentDay = null
}

fun Schedule.saturday(block: Schedule.() -> Unit) {
    currentDay = Days.TUESDAY
    block()
    currentDay = null
}

fun Schedule.sunday(block: Schedule.() -> Unit) {
    currentDay = Days.TUESDAY
    block()
    currentDay = null
}

// Главная функция для создания расписания
fun schedule(block: Schedule.() -> Unit): Schedule {
    currentSchedule = Schedule()
    currentSchedule.block()
    return currentSchedule
}

// Тестируем
fun main() {
    val schedule = schedule {
        monday {
            "10:30".."11:10" schedule "Biology"
            "11:15".."11:55" schedule "Chemistry"
        }

        tuesday {
            "09:00".."09:40" schedule "English"
        }
    }

    println(schedule)
}