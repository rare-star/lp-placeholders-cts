package su.trap.lpplaceholderscts;

import net.fabricmc.api.ModInitializer;
import eu.pb4.placeholders.PlaceholderAPI;
import eu.pb4.placeholders.PlaceholderResult;
import net.minecraft.resources.ResourceLocation;
import java.util.UUID;

public class LuckPermsPlaceholdersCTS implements ModInitializer {
	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.


        PlaceholderAPI.register(
                new ResourceLocation("luckperms", "prefix"),
                (ctx) -> {
                    if (ctx.hasPlayer()) {
                        return PlaceholderResult.value(LuckPermsAPI.getPrefix(LuckPermsAPI.getUserByUUID(ctx.getPlayer().getUUID())));
                    } else {
                        return PlaceholderResult.invalid("No player!");
                    }
                }
        );
        PlaceholderAPI.register(
                new ResourceLocation("luckperms", "suffix"),
                (ctx) -> {
                    if (ctx.hasPlayer()) {
                        return PlaceholderResult.value(LuckPermsAPI.getSuffix(LuckPermsAPI.getUserByUUID(ctx.getPlayer().getUUID())));
                    } else {
                        return PlaceholderResult.invalid("No player!");
                    }
                }
        );
        PlaceholderAPI.register(
                new ResourceLocation("luckperms", "primary_group_name"),
                (ctx) -> {
                    if (ctx.hasPlayer()) {
                        return PlaceholderResult.value(LuckPermsAPI.getGroup(LuckPermsAPI.getUserByUUID(ctx.getPlayer().getUUID())));
                    } else {
                        return PlaceholderResult.invalid("No player!");
                    }
                }
        );
    }
}
