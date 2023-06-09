package com.prilepskiy.domain.interactors


import com.prilepskiy.domain.model.TagModel
import kotlinx.coroutines.flow.Flow

interface GetTagsUseCase {
    suspend operator fun invoke(): Flow<List<TagModel>>
}