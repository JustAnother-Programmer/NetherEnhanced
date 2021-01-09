package com.overfluxstudios.netherenhanced.item;

import com.overfluxstudios.netherenhanced.NetherEnhanced;
import com.overfluxstudios.netherenhanced.util.Registration;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;

public class ModItems
{
    public static final RegistryObject<Item> COPPER_INGOT =
            Registration.ITEMS.register("copper_ingot",
                    () -> new Item(new Item.Properties().group(NetherEnhanced.NETHERENHANCED_TAB)));

    public static final RegistryObject<Item> COPPER_WIRE =
            Registration.ITEMS.register("copper_wire",
                    () -> new Item(new Item.Properties().group(NetherEnhanced.NETHERENHANCED_TAB)));

    public static void Register() { }
}
