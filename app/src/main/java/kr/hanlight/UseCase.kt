package kr.hanlight

interface UseCase<in Params, Result> {
    fun excute(params: Params? = null): Result
}