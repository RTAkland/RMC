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
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.stat.Stat
import net.minecraft.stat.StatFormatter
import net.minecraft.util.Identifier


object RMineCounter {

    private var RMCC: Identifier? = null

    private val stats: MutableSet<String> = Sets.newHashSet()

    private fun addStat(stat: Identifier) {
        this.stats.add(stat.toString())
    }

    fun registerStats() {
        this.addStat(StatsAccessor.callRegister("rmc", StatFormatter.DEFAULT).also { this.RMCC = it })
    }

    fun onPlayerMineFinish(player: PlayerEntity) {
        player.increaseStat(this.RMCC, 1)
    }

    operator fun contains(stat: Stat<*>): Boolean {
        return this.stats.contains(stat.value.toString())
    }
}