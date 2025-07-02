package com.pmdm.birthdayremember.application.usecase.group

import com.pmdm.birthdayremember.domain.entity.Group
import com.pmdm.birthdayremember.domain.repository.GroupRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetGroupUseCase @Inject constructor(
    private val groupRepository: GroupRepository
) {

    suspend operator fun invoke(idGroup: Int): Result<Group> {
        val groupFound = groupRepository.get(idGroup)
            ?: return Result.failure(Exception("Grupo no encontrado con la id $idGroup."))

        return Result.success(groupFound)
    }

}