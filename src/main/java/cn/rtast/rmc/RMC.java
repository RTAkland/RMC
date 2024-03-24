/*
 * Copyright 2024 RTAkland
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


package cn.rtast.rmc;

import net.fabricmc.api.ModInitializer;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.stat.Stats;
import net.minecraft.util.Identifier;

public class RMC implements ModInitializer {

    public static final Identifier RMC_STAT_ID = new Identifier("rmc", "dig");

    @Override
    public void onInitialize() {
        Registry.register(Registries.CUSTOM_STAT, "rmc.dig", RMC_STAT_ID);
        Stats.CUSTOM.getOrCreateStat(RMC_STAT_ID);
    }

}