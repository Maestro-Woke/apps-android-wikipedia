package org.wikipedia.homeworks.homework03

import android.widget.LinearLayout
import androidx.appcompat.widget.AppCompatImageView
import com.google.android.material.button.MaterialButton
import org.wikipedia.views.AppTextView

// Картинка
val imageViewCentered = listOf(
    AppCompatImageView::class.java,
    "imageViewCentered",
    null
)

// Заголовок
val primaryTextView = listOf(
    AppTextView::class.java,
    "primaryTextView",
    null
)

// Подзаголовок
val secondaryTextView = listOf(
    AppTextView::class.java,
    "secondaryTextView",
    null
)

// Контейнер с листом
val languageListContainer = listOf(
    LinearLayout::class.java,
    "languageListContainer",
    null
)

//  Выбор языка в контейнере
val option_label = listOf(
    AppTextView::class.java,
    "option_label",
    null
)

// Кнопка добавления языка
val addLanguageButton = listOf(
    MaterialButton::class.java,
    "addLanguageButton",
    null
)