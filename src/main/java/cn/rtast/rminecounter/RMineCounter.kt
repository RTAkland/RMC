/*
 * Copyright 2023 RTAkland
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package cn.rtast.rminecounter

import cn.rtast.rminecounter.mixins.StatsAccessor
import com.google.common.collect.Sets
import net.fabricmc.api.ModInitializer
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.stat.Stat
import net.minecraft.stat.StatFormatter
import net.minecraft.util.Identifier


object RMineCounter : ModInitializer {

    private var RMC: Identifier? = null

    private val stats: MutableSet<String> = Sets.newHashSet()

    private fun addStat(stat: Identifier) {
        stats.add(stat.toString())
    }

    fun registerStats() {
        addStat(StatsAccessor.callRegister("rmc", StatFormatter.DEFAULT).also { RMC = it })
    }

    fun onPlayerMineFinish(player: PlayerEntity) {
        player.increaseStat(RMC, 1)
    }

    operator fun contains(stat: Stat<*>): Boolean {
        return stats.contains(stat.value.toString())
    }

    override fun onInitialize() {
        println("RMC 已加载!")
    }
}