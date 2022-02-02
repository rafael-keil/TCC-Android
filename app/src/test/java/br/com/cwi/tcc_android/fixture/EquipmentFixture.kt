package br.com.cwi.tcc_android.fixture

import br.com.cwi.tcc_android.domain.entity.Cost
import br.com.cwi.tcc_android.domain.entity.Equipment

class EquipmentFixture {
    companion object {
        fun getEquipment() = Equipment(
            id = "abacus",
            name = "Abacus",
            equipmentCategory = "Adventuring Gear",
            cost = Cost(2, "gp"),
            weight = null,
            desc = null,
            weaponCategory = null,
            weaponRange = null,
            damage = null,
            properties = null,
            armorCategory = null,
            armorClass = null,
            strMinimum = null,
            stealthDisadvantage = null,
        )

        fun getEquipmentList() = listOf(getEquipment())
    }
}