package com.overfluxstudios.netherenhanced.block;

import com.overfluxstudios.netherenhanced.NetherEnhanced;
import com.overfluxstudios.netherenhanced.util.Registration;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks
{
    public static final RegistryObject<Block> LAVA_STEEL_BLOCK = Register("lava_steel_block",
            () -> new Block(AbstractBlock.Properties.create(Material.IRON)
                    .harvestLevel(2).harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(3f, 10f).sound(SoundType.METAL)));

    public static final RegistryObject<Block> LAVA_STEEL_ORE = Register("lava_steel_ore",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .harvestLevel(2).harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(2f, 12f)));

    public static final RegistryObject<Block> BLACK_STEEL_BLOCK = Register("black_steel_block",
            () -> new Block(AbstractBlock.Properties.create(Material.IRON)
            .harvestLevel(3).harvestTool(ToolType.PICKAXE)
            .hardnessAndResistance(10f, 20f)));

    public static void Register() { }

    private static <T extends Block>RegistryObject<T> Register (String name, Supplier<T> block){

        RegistryObject<T> toReturn = Registration.BLOCKS.register(name, block);
        Registration.ITEMS.register(name, () -> new BlockItem(toReturn.get(),
                new Item.Properties().group(NetherEnhanced.NETHERENHANCED_TAB)));
        return toReturn;
    }
}
