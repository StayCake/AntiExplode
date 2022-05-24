package kr.yhs.antiExplode.listener

import io.papermc.paper.event.player.PlayerBedFailEnterEvent
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener

class BedListener : BaseListener, Listener {
    override val type: String
        get() = "Bed"
    @EventHandler
    fun onBedFailEnter(event: PlayerBedFailEnterEvent) {
        if (
            (event.failReason == PlayerBedFailEnterEvent.FailReason.NOT_POSSIBLE_HERE || event.willExplode)
            && getExplodeConfig("BED", event.player.world)
        ) {
            event.isCancelled = true
            sendMessage(event.player, "BED")
        }
    }
}
