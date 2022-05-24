package kr.yhs.antiExplode.listener

import kr.yhs.antiExplode.AntiExplode
import org.bukkit.World
import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.entity.Player

interface BaseListener {

    val type: String

    fun baseConfig(): FileConfiguration {
        return AntiExplode.instance.config
    }
    fun getExplodeConfig(name: String, world: World): Boolean =
        baseConfig().getConfigurationSection(world.name)?.getBoolean(name) ?: false

    private fun formatPlayer(player: Player, comment: String): String =
        comment.replace("{player}", player.name)

    fun sendMessage(player: Player, name: String) {
        val comment: String =
            baseConfig().getConfigurationSection("comment")?.getString(name) ?: return
        sendComment(player, comment)
    }

    private fun sendComment(
        player: Player,
        comment: String
    ) = player.sendMessage(
        formatPlayer(player, comment)
    )
}