package br.com.cwi.tcc_android.domain.entity

class Class(
    val id: String,
    val name: String,
    val dice: Int,
    val proficiencyChoices: List<BaseChoose>,
    val proficiencies: List<BaseListItem>,
    val savingThrows: List<BaseListItem>,
    val startingEquipment: List<StartingEquipment>,
    val startingEquipmentOptions: List<BaseChoose>,
    val subClasses: List<BaseListItem>,
)