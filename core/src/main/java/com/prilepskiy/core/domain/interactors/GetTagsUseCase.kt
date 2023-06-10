package com.prilepskiy.core.domain.interactors


import com.prilepskiy.core.domain.model.TagModel
import kotlinx.coroutines.flow.Flow

interface GetTagsUseCase {
    suspend operator fun invoke(): Flow<List<com.prilepskiy.core.domain.model.TagModel>>
}