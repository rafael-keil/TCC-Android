package br.com.cwi.tcc_android.data.repository

import br.com.cwi.tcc_android.data.network.DndApi
import br.com.cwi.tcc_android.data.network.mapper.EquipmentMapper
import br.com.cwi.tcc_android.data.network.mapper.SpellMapper
import br.com.cwi.tcc_android.domain.entity.Equipment
import br.com.cwi.tcc_android.domain.entity.Spell
import br.com.cwi.tcc_android.domain.repository.DndRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DndRepositoryImpl(
    private val api: DndApi,
    private val spellMapper: SpellMapper,
    private val equipmentMapper: EquipmentMapper,
) : DndRepository {

    override suspend fun getSpells(): List<Spell> {
        return withContext(Dispatchers.IO) {

            spellMapper.toDomain(api.getSpells())
        }
    }

    override suspend fun getSpell(id: String): Spell {
        return withContext(Dispatchers.IO) {

            spellMapper.toDomain(api.getSpell(id))
        }
    }

    override suspend fun getEquipments(): List<Equipment> {
        return withContext(Dispatchers.IO) {

            equipmentMapper.toDomain(api.getEquipments())
        }
    }

    override suspend fun getEquipment(id: String): Equipment {
        return withContext(Dispatchers.IO) {

            equipmentMapper.toDomain(api.getEquipment(id))
        }
    }
}