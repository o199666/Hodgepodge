package com.cwj.common.net.error

import com.byl.mvvm.api.error.ErrorResult
import retrofit2.HttpException

object ErrorUtil {

    fun getError(e: Throwable): ErrorResult {
        val errorResult = ErrorResult()
        if (e is HttpException) {
            errorResult.code = e.code()
        }
        errorResult.errMsg = e.message
        if (errorResult.errMsg.isNullOrEmpty()) errorResult.errMsg = "网络请求失败，请重试"
        return errorResult
    }

    fun getError(apiIndex: Int, e: Throwable): ErrorResult {
        val errorResult = ErrorResult()
        errorResult.index = apiIndex
        if (e is HttpException) {
            errorResult.code = e.code()
        }
        errorResult.errMsg = e.message
        if (errorResult.errMsg.isNullOrEmpty()) errorResult.errMsg = "网络请求失败，请重试"
        return errorResult
    }

}