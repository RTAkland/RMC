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

package cn.rtast.rmc.mixin;

import cn.rtast.rmc.RMC;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.stat.ServerStatHandler;
import net.minecraft.stat.Stat;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ServerStatHandler.class)
public abstract class ServerStatHandlerMixin {
    @Redirect(method = "sendStats", at = @At(value = "INVOKE", target = "Lit/unimi/dsi/fastutil/objects/Object2IntMap;put(Ljava/lang/Object;I)I"), remap = false)
    private int excludeCustomStats(Object2IntMap<Stat<?>> map, Object object, int value, ServerPlayerEntity player) {
        if (!RMC.Companion.contains((Stat<?>) object)) {
            return map.put((Stat<?>) object, value);
        } else {
            return map.defaultReturnValue();
        }
    }
}