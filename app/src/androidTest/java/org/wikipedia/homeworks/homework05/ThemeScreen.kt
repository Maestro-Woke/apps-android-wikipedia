package org.wikipedia.homeworks.homework05

// Импорты для заданий 5-6
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.switch.KSwitch
import io.github.kakaocup.kakao.text.KTextView
import io.github.kakaocup.kakao.scroll.KScrollView
import io.github.kakaocup.kakao.text.KButton
import org.wikipedia.R

// Домашнее задание №5. Типизированные элементы

object SettingsScreen : KScreen<SettingsScreen>() {
    val textSettingsCategory = KTextView { withId(R.id.textSettingsCategory) }
    val textSizePercent = KTextView { withId(R.id.text_size_percent) }

    val syntaxHighlightSwitch = KSwitch { withId(R.id.syntax_highlight_switch) }
    val typingSuggestionsSwitch = KSwitch { withId(R.id.typing_suggestions_switch) }
    val showLineNumbersSwitch = KSwitch { withId(R.id.show_line_numbers_switch) }
    val monospaceFontSwitch = KSwitch { withId(R.id.monospace_font_switch) }

    val fontFamilyContainer = KView { withId(R.id.fontFamilyContainer) }
    val readingFocusModeContainer = KView { withId(R.id.readingFocusModeContainer) }
    val themeChooserDescription = KTextView { withId(R.id.theme_chooser_reading_focus_mode_description) }

    val scrollView = KScrollView { withId(R.id.scrollView) }
    val buttonFontFamilySansSerif = KButton { withId(R.id.button_font_family_sans_serif) }
    val buttonFontFamilySerif = KButton { withId(R.id.button_font_family_serif) }
    override val layoutId: Int?
        get() = TODO("Not yet implemented")
    override val viewClass: Class<*>?
        get() = TODO("Not yet implemented")
}

