package com.overfluxstudios.netherenhanced;

import com.overfluxstudios.netherenhanced.block.ModBlocks;
import com.overfluxstudios.netherenhanced.item.ModItems;
import com.overfluxstudios.netherenhanced.util.Registration;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;

@Mod(NetherEnhanced.MOD_ID)
public class NetherEnhanced
{
    public static final String MOD_ID = "netherenhanced";

    public static final ItemGroup NETHERENHANCED_TAB = new ItemGroup("netherEnhanced")
    {
        @Override
        public ItemStack createIcon()
        {
            return new ItemStack(ModItems.LAVA_STEEL_INGOT.get());
        }
    };

    public NetherEnhanced() {
        Registration.Register();
        ModItems.Register();
        ModBlocks.Register();
    }
}
