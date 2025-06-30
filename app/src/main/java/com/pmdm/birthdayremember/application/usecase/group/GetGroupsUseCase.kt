package com.pmdm.birthdayremember.application.usecase.group

import com.pmdm.birthdayremember.domain.entity.Group
import com.pmdm.birthdayremember.domain.repository.GroupRepository
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class GetGroupsUseCase @Inject constructor(
    private val groupRepository: GroupRepository
) {
    suspend operator fun invoke(): Result<List<Group>> {
        val groups = groupRepository.get()

        return Result.success(groups)
    }
}