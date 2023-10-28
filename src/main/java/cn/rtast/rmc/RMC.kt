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

package cn.rtast.rmc

import cn.rtast.rmc.mixin.StatsAccessor
import com.google.common.collect.Sets
import net.fabricmc.api.DedicatedServerModInitializer
import net.minecraft.stat.Stat
import net.minecraft.stat.StatFormatter
import net.minecraft.util.Identifier

class RMC : DedicatedServerModInitializer {


    companion object {
        private val stats: MutableSet<String> = Sets.newHashSet()

        var RMC_STAT_ID: Identifier? = null

        private fun addStat(stat: Identifier) {
            stats.add(stat.toString())
        }

        fun registerStats() {
            addStat(StatsAccessor.callRegister("rmc", StatFormatter.TIME).also { RMC_STAT_ID = it })
        }

        operator fun contains(stat: Stat<*>): Boolean {
            return stats.contains(stat.value.toString())
        }
    }

    override fun onInitializeServer() {
        println("RMC 已加载!")
    }
}