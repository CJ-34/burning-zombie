package me.miguel.knockknock;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.mineacademy.fo.plugin.SimplePlugin;

/**
 * PluginTemplate is a simple template you can use every time you make
 * a new plugin. This will save you time because you no longer have to
 * recreate the same skeleton and features each time.
 * <p>
 * It uses Foundation for fast and efficient development process.
 */
public final class KnockPlugin extends SimplePlugin {

	/**
	 * Automatically perform login ONCE when the plugin starts.
	 */
	@Override
	protected void onPluginStart() {

		int result = 4;

		int apples = 5;

		apples++;

		System.out.println(apples);

		System.out.println(result);

		System.out.println("Add: " + (1 + 5));
		System.out.println("Multiply: " + (1.9 * 5.568909));
		System.out.println("Division: " + (1.9 / 5.56998789));

		System.out.println("Modulo: " + (15 % 2));
	}

	/**
	 * Automatically perform login when the plugin starts and each time it is reloaded.
	 */
	@Override
	protected void onReloadablesStart() {

		// You can check for necessary plugins and disable loading if they are missing
		// Valid.checkBoolean(HookManager.isVaultLoaded(), "You need to install Vault so that we can work with packets, offline player data, prefixes and groups.");

		// Uncomment to load variables
		// Variable.loadVariables();

		//
		// Add your own plugin parts to load automatically here
		// Please see @AutoRegister for parts you do not have to register manually
		//
	}

	@Override
	protected void onPluginPreReload() {

		// Close your database here if you use one
		//YourDatabase.getInstance().close();
	}

	/* ------------------------------------------------------------------------------- */
	/* Events */
	/* ------------------------------------------------------------------------------- */

	/**
	 * An example event that checks if the right clicked entity is a cow, and makes an explosion.
	 * You can write your events to your main class without having to register a listener.
	 *
	 * @param event
	 */
	@EventHandler
	public void onRightClick(PlayerInteractEntityEvent event) {
		boolean isZombie = event.getRightClicked().getType() == EntityType.ZOMBIE;

		if (isZombie) {
			Zombie zombie = (Zombie) event.getRightClicked();
			zombie.damage(1);
			zombie.setFireTicks(2 * 20);
			event.getPlayer().sendMessage("You burnt a zombie. Naughty boy!");
		}
		
	}

	/* ------------------------------------------------------------------------------- */
	/* Static */
	/* ------------------------------------------------------------------------------- */

	/**
	 * Return the instance of this plugin, which simply refers to a static
	 * field already created for you in SimplePlugin but casts it to your
	 * specific plugin instance for your convenience.
	 *
	 * @return
	 */
	public static KnockPlugin getInstance() {
		return (KnockPlugin) SimplePlugin.getInstance();
	}
}
