package com.prilepskiy.core.presenter.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ProfileFragmentViewModel(): ViewModel() {
    private val _groupQuestionHistory: MutableStateFlow<List<Pair<String, ArrayList<String>>>?> by lazy {
        MutableStateFlow(
            null
        )
    }
    val groupQuestionHistory = _groupQuestionHistory.asStateFlow()
    private val questionHistory: MutableList<Pair<String, ArrayList<String>>> = mutableListOf()
    private val childrenHistory = ArrayList<String>()

    private val _groupQuestionFavorite: MutableStateFlow<List<Pair<String, ArrayList<String>>>?> by lazy {
        MutableStateFlow(
            null
        )
    }
    val groupQuestionFavorite = _groupQuestionFavorite.asStateFlow()
    private val questionFavorite: MutableList<Pair<String, ArrayList<String>>> = mutableListOf()
    private val childrenFavorite = ArrayList<String>()


    fun getTest() {

        childrenHistory.add("test1")
        childrenHistory.add("test2")
        childrenHistory.add("test3")
        childrenHistory.add("test4")
        childrenHistory.add("test5")
        childrenHistory.add("test6")
        childrenHistory.add("test7")
        childrenHistory.add("test8")
        childrenHistory.add("test9")
        childrenHistory.add("test10")
        childrenHistory.add("test11")
        childrenHistory.add("test12")
        questionHistory.add(Pair("History", childrenHistory))
        _groupQuestionHistory.value = questionHistory

    }
    fun getTest1() {

        childrenFavorite.add("test1")
        childrenFavorite.add("test2")
        childrenFavorite.add("test3")
        childrenFavorite.add("test4")
        childrenFavorite.add("test5")
        childrenFavorite.add("test6")
        questionFavorite.add(Pair("Favorite", childrenFavorite))
        _groupQuestionFavorite.value = questionFavorite

    }
}