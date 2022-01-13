package com.davenotdavid.archcomponentsample.ui.articledetail

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.viewinterop.AndroidView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs

/**
 * TODO: Somewhat of a more hybrid approach for now, but renders a Composable function!
 */
class ArticleDetailFragment : Fragment() {

    private val articleDetailArgs: ArticleDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                ArticleWebView(articleDetailArgs.articleUrl)
            }
        }
    }

}

@Composable
@SuppressLint("SetJavaScriptEnabled")
private fun ArticleWebView(url: String) {
    AndroidView(factory = {
        WebView(it).apply {
            settings.javaScriptEnabled = true

            loadUrl(url)
        }
    })
}
