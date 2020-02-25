package kr.hanlight.common

interface Mapper<FROM, TO> {
    fun map(from: FROM): TO
}