package kr.hanlight.login.data

import kr.hanlight.common.Mapper
import kr.hanlight.login.entity.User
import kr.hanlight.network.response.model.UserRaw

class UserMapper : Mapper<UserRaw, User> {
    override fun map(from: UserRaw): User {
        return User(
            from.accessToken,
            from.user.type,
            isAdmin(from.user.admin),
            from.user.name,
            from.user.id,
            from.user.major,
            from.user.grade,
            from.user.classNum,
            from.user.studentNum
        )
    }

    private fun isAdmin(param: Int): Boolean {
        if (param <= 0) {
            return false
        }
        return true
    }
}