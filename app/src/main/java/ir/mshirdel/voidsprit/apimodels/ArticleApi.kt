package ir.mshirdel.voidsprit.apimodels

import ir.mshirdel.voidsprit.models.Article

data class ArticleApi(val articles: List<Article>, val articleCount: Int)