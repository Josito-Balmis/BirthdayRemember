package com.pmdm.birthdayremember.infraestructure.room.seeder

import android.content.Context
import com.pmdm.birthdayremember.infraestructure.room.dao.GroupDao
import com.pmdm.birthdayremember.infraestructure.room.dto.GroupDto
import com.pmdm.birthdayremember.infraestructure.room.mapper.toEntity
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class InitialGroupSeeder @Inject constructor(
    @ApplicationContext private val context: Context,
    private val groupDao: GroupDao
) {
    private val moshi = moshiConfig()
    private val jsonFilename = "initial_groups.json"

    private fun readAssetFile(): String {
        return context.assets.open(jsonFilename).bufferedReader().use { it.readText() }
    }

    private fun moshiConfig(): Moshi {
        return Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build()
    }

    private fun adapter(): JsonAdapter<List<GroupDto>> {
        val type = Types.newParameterizedType(List::class.java, GroupDto::class.java)
        val adapter = moshi.adapter<List<GroupDto>>(type)

        return adapter
    }

    private fun parseGroupJson(json: String): List<GroupDto> {
        return adapter().fromJson(json) ?: emptyList()
    }

    suspend fun seedIfIsEmpty() {
        if (groupDao.count() != 0) return

        val json = readAssetFile()
        val dtos = parseGroupJson(json)
        val entities = dtos.map {
            it.toEntity()
        }

        entities.forEach { group ->
            groupDao.insert(group)
        }
    }
}