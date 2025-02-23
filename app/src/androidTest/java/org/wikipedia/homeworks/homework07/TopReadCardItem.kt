package org.wikipedia.homeworks.homework07

import android.view.View
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class TopReadCardItem(matcher: Matcher<View>) : KRecyclerItem<TopReadCardItem>(matcher) {
    val title = KTextView(matcher) { withId(R.id.view_list_card_item_title) }
    val subtitle = KTextView(matcher) { withId(R.id.view_list_card_item_subtitle) }
    val graphView = KView(matcher) { withId(R.id.view_list_card_item_graph) }
    val rankNumber = KTextView(matcher) { withId(R.id.numberView) }
    val pageViewsCount = KTextView(matcher) { withId(R.id.view_list_card_item_pageviews) }
    val thumbnailImage = KImageView(matcher) { withId(R.id.view_list_card_item_image) }
}