package com.pmdm.birthdayremember.domain.entity

data class Group(
    val id: Int,
    val name: String,
) {
    init {
        require(name.isNotBlank()) {
            "El nombre del grupo no puede estar vacio."
        }
        require(name.all { !it.isDigit() }) {
            "El nombre del grupo no puede contener números."
        }
    }


}
