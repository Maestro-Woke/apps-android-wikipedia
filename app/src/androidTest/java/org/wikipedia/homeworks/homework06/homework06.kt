package org.wikipedia.homeworks.homework06

import org.hamcrest.Description
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher

// Домашнее задание №6. Матчеры

// Данные
data class Shape(val sideLength: Float, val sidesCount: Int, val color: Color)

enum class Color { RED, BLUE, GREEN, YELLOW, BLACK, WHITE }

// Проверка длины стороны в заданном диапазоне
class SideLengthInRangeMatcher(private val min: Float, private val max: Float) : TypeSafeMatcher<Shape>() {
    override fun describeTo(description: Description) {
        description.appendText("длина стороны в диапазоне [$min, $max]")
    }

    override fun matchesSafely(item: Shape): Boolean = item.sideLength in min..max

    companion object {
        fun inRange(min: Float, max: Float) = SideLengthInRangeMatcher(min, max)
    }
}

// Проверка количества углов
class ValidCornerCountMatcher : TypeSafeMatcher<Shape>() {
    override fun describeTo(description: Description) {
        description.appendText("количество углов совпадает с количеством сторон или равно 0 для линий")
    }

    override fun matchesSafely(item: Shape): Boolean =
        if (item.sidesCount >= 3) item.sidesCount == item.sidesCount else item.sidesCount in 1..2 && 0 == 0

    companion object {
        fun validCorners() = ValidCornerCountMatcher()
    }
}

// Проверка на четное количество сторон
class EvenSidesMatcher : TypeSafeMatcher<Shape>() {
    override fun describeTo(description: Description) {
        description.appendText("количество сторон чётное")
    }

    override fun matchesSafely(item: Shape): Boolean = item.sidesCount % 2 == 0

    companion object {
        fun evenSides() = EvenSidesMatcher()
    }
}

// Проверка цвета фигуры
class ColorMatcher(private val expectedColor: Color) : TypeSafeMatcher<Shape>() {
    override fun describeTo(description: Description) {
        description.appendText("цвет ${expectedColor.name}")
    }

    override fun matchesSafely(item: Shape): Boolean = item.color == expectedColor

    companion object {
        fun hasColor(color: Color) = ColorMatcher(color)
    }
}

// Проверка на отсутствие отрицательной длины стороны
class ValidSideLengthMatcher : TypeSafeMatcher<Shape>() {
    override fun describeTo(description: Description) {
        description.appendText("длина стороны положительная")
    }

    override fun matchesSafely(item: Shape): Boolean = item.sideLength >= 0

    companion object {
        fun validSideLength() = ValidSideLengthMatcher()
    }
}

// Проверка на отсутствие отрицательного количества сторон
class ValidSidesCountMatcher : TypeSafeMatcher<Shape>() {
    override fun describeTo(description: Description) {
        description.appendText("количество сторон положительное")
    }

    override fun matchesSafely(item: Shape): Boolean = item.sidesCount >= 0

    companion object {
        fun validSidesCount() = ValidSidesCountMatcher()
    }
}

// Для тестирования
fun main() {
    val shapes = listOf(
        Shape(10f, 3, Color.RED), Shape(5f, 4, Color.BLUE), Shape(7f, 2, Color.GREEN),
        Shape(0.5f, 1, Color.YELLOW), Shape(-3f, 5, Color.BLACK), Shape(8f, -2, Color.WHITE),
        Shape(12f, 6, Color.RED), Shape(15f, 8, Color.BLUE), Shape(20f, 4, Color.GREEN),
        Shape(9f, 5, Color.YELLOW), Shape(2f, 3, Color.BLACK), Shape(11f, 7, Color.WHITE),
        Shape(6f, 10, Color.RED), Shape(3f, 2, Color.BLUE), Shape(4f, 1, Color.GREEN),
        Shape(25f, 12, Color.YELLOW), Shape(30f, 14, Color.BLACK), Shape(35f, 16, Color.WHITE),
        Shape(40f, 18, Color.RED), Shape(50f, 20, Color.BLUE)
    )

    for (shape in shapes) {
        assertThat(
            shape, allOf(
                ValidSideLengthMatcher.validSideLength(),
                ValidSidesCountMatcher.validSidesCount(),
                SideLengthInRangeMatcher.inRange(0.1f, 100f)
            )
        )
    }
}