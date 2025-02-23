package org.wikipedia.homeworks.homework08

import android.view.View
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.google.android.material.button.MaterialButton
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import io.github.kakaocup.kakao.pager2.KViewPager2
import io.github.kakaocup.kakao.text.KButton
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.views.AppTextView

object OnboardingScreen {
    // Слайды в пейджере
    val viewPager = KViewPager2 { withId(R.id.view_pager_onboarding) }

    // Картинка в центре
    val imageViewCentered = KImageView { withId(R.id.imageViewCentered) }

    // Заголовок
    val primaryTextView = KTextView { withId(R.id.primaryTextView) }

    // Подзаголовок
    val secondaryTextView = KTextView { withId(R.id.secondaryTextView) }

    // Контейнер со списком языков
    val languageListContainer = KView { withId(R.id.languageListContainer) }

    // Список языков

    val languageOptionEnglish = listOf(
        AppTextView::class.java,
        "option_label"
    )
    val addLanguageButton = listOf(
        MaterialButton::class.java,
        "addLanguageButton",
        "onboarding_multilingual_add_language_text"
    )
}