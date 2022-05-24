package kr.yhs.antiExplode.listener

import kr.yhs.antiExplode.AntiExplode
import org.bukkit.Bukkit
import org.bukkit.entity.Entity
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityExplodeEvent

class EntityListener(): BaseListener, Listener {

    override val type: String
        get() = "Entity"
    private fun entityCheck(entity: Entity) = getExplodeConfig(entity.type.name, entity.world)

    @EventHandler
    fun onEntityExplode(entity: EntityExplodeEvent) {
        if (AntiExplode.debug) {
            Bukkit.getLogger().info("AntiExplode - Entity Explode: ${entity.entity.type}")
        }

        if (AntiExplode.globalEntityExplode && entityCheck(entity.entity)) {
            entity.isCancelled = true
        }
    }
}