package br.com.cwi.tcc_android.fixture

import br.com.cwi.tcc_android.domain.entity.Spell

class SpellFixture {
    companion object {
        fun getSpell() = Spell(
            id = "acid-arrow",
            name = "Acid Arrow",
            desc = listOf("A shimmering green arrow streaks toward a target within range and bursts in a spray of acid. Make a ranged spell attack against the target. On a hit, the target takes 4d4 acid damage immediately and 2d4 acid damage at the end of its next turn. On a miss, the arrow splashes the target with acid for half as much of the initial damage and no damage at the end of its next turn."),
            range = "90 feet",
            components = listOf("V", "S", "M"),
            duration = "Instantaneous",
            castingTime = "1 action",
            level = 2,
            school = "Evocation",
            classes = listOf("wizard"),
            higherLevel = null,
            material = null
        )

        fun getSpellList() = listOf(getSpell())
    }
}