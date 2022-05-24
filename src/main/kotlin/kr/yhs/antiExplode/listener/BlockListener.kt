package kr.yhs.antiExplode.listener

import kr.yhs.antiExplode.AntiExplode
import org.bukkit.Bukkit
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockExplodeEvent

class BlockListener : BaseListener, Listener {
    override val type: String
        get() = "Block"
    @EventHandler
    fun onBlockExplode(block: BlockExplodeEvent) {
        if (AntiExplode.debug) {
            Bukkit.getLogger().info("Block Explode: ${block.block.type} ${block.blockList()}")
        }

        if (AntiExplode.globalBlockExplode) {
            block.isCancelled = true
        }
    }
}