package kr.yhs.antiExplode

import kr.yhs.antiExplode.listener.AnchorListener
import kr.yhs.antiExplode.listener.BedListener
import kr.yhs.antiExplode.listener.BlockListener
import kr.yhs.antiExplode.listener.EntityListener
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin

class AntiExplode : JavaPlugin(){

    companion object {
        lateinit var instance: AntiExplode
            private set
        var debug: Boolean = false
        var globalBlockExplode: Boolean = false
        var globalEntityExplode: Boolean = false
    }

    override fun onLoad() {
        Bukkit.getLogger().info("AntiExplode - Now Loading... [${description.version}")
    }

    override fun onEnable() {
        instance = this

        reloadConfig()
        debug = config.getBoolean("debug")
        globalBlockExplode = config.getBoolean("globalBlockExplode")
        globalEntityExplode = config.getBoolean("globalEntityExplode")

        if (!dataFolder.exists()) {
            this.saveDefaultConfig()
            Bukkit.getLogger().info("AntiExplode - Initialized configuration!")
        }
        server.pluginManager.apply {
            registerEvents(AnchorListener(), this@AntiExplode)
            registerEvents(BedListener(), this@AntiExplode)
            registerEvents(BlockListener(), this@AntiExplode)
            registerEvents(EntityListener(), this@AntiExplode)
        }
        Bukkit.getLogger().info("AntiExplode - Minecraft listener registered!")
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}