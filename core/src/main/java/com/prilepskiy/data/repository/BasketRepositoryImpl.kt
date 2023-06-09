package com.prilepskiy.data.repository

import android.util.Log
import com.prilepskiy.data.databaseService.database.BasketDataBase
import com.prilepskiy.data.databaseService.entity.BasketEntity
import com.prilepskiy.domain.repository.BasketRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onEach

class BasketRepositoryImpl(private val db: BasketDataBase): BasketRepository {
    override suspend fun getBasketCash(): Flow<List<BasketEntity>> {
       return db.basketDao.getBasket()
    }

    private suspend fun addBtCash(basket: BasketEntity,isPositive:Boolean) {
        db.basketDao.getBasket().onEach {
            Log.d("TAG", "addBtCash: $it")
                        it.forEach {
                if (it==basket){
                    if (isPositive)
                    db.basketDao.insert(basket.copy(colum = it.colum+1))
                    else if ( basket.colum!=0) {
                        db.basketDao.insert(basket.copy(colum = it.colum-1))
                    }else{
                        delBtCash(basket)
                    }
                }
            }
        }
//            .collect {
//            it.forEach {
//                if (it==basket){
//                    if (isPositive)
//                    db.basketDao.insert(basket.copy(colum = it.colum+1))
//                    else if ( basket.colum!=0) {
//                        db.basketDao.insert(basket.copy(colum = it.colum-1))
//                    }else{
//                        delBtCash(basket)
//                    }
//                }
//            }
//        }

        //db.basketDao.insert(basket)
    }

    private suspend fun delBtCash(basket: BasketEntity) {
        db.basketDao.delete(basket)
    }

    override suspend fun updateBtCash(basket: BasketEntity,isPositive:Boolean) {
        if(basket.colum==0){
            delBtCash(basket)
        }else{
            addBtCash(basket,isPositive)
        }
    }
}