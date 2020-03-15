package kr.hanlight.common

sealed class Lce<out T> {
    open val data: T? = null

    abstract fun <R> map(f: (T) -> R): Lce<R>

    inline fun doOnData(f: (T) -> Unit) {
        if (this is Content) {
            f(data)
        }
    }

    object Loading: Lce<Nothing>() {
        override fun <R> map(f: (Nothing) -> R): Lce<R> = this
    }

    data class Content<out T>(
        override val data: T
    ) : Lce<T>() {
        override fun <R> map(f: (T) -> R): Lce<R> = Content(f(data))
    }

    data class Error(
        val throwable: Throwable = Exception("default LCE throwable"),
        val message: String = ""
    ) : Lce<Nothing>() {
        override fun <R> map(f: (Nothing) -> R): Lce<R> = this
    }
}