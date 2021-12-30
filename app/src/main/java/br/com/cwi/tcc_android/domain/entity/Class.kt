package br.com.cwi.tcc_android.domain.entity

class Class(
    val index: String,
    val name: String,
    val hitDie: Int,
    val proficiencyChoices: List<BaseChoose>,
    val proficiencies: List<BaseListItem>,
    val savingThrows: List<BaseListItem>,
    val startingEquipment: List<StartingEquipment>,
    val startingEquipmentOptions: List<BaseChoose>,
    val multiClassing: MultiClassing,
    val subClasses: List<BaseListItem>,
)