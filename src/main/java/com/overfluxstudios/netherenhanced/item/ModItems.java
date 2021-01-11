package com.overfluxstudios.netherenhanced.item;

import com.overfluxstudios.netherenhanced.NetherEnhanced;
import com.overfluxstudios.netherenhanced.util.Registration;
import net.minecraft.item.*;
import net.minecraft.item.crafting.Ingredient;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;

public class ModItems
{
    public static final RegistryObject<Item> LAVA_STEEL_INGOT =
            Registration.ITEMS.register("lava_steel_ingot",
                    () -> new Item(new Item.Properties().group(NetherEnhanced.NETHERENHANCED_TAB)));

    public static final RegistryObject<Item> LAVA_BREAD =
            Registration.ITEMS.register("lava_bread",
                    () -> new LavaBread());

    public static final RegistryObject<Item> LAVA_STEEL_SHOVEL =
            Registration.ITEMS.register("lava_steel_shovel",
                    () -> new ShovelItem(ModItemTier.LAVA_STEEL, 1.5f, 2f,
                            new Item.Properties()
                                .defaultMaxDamage(300)
                                .addToolType(ToolType.SHOVEL, 3)
                                .group(NetherEnhanced.NETHERENHANCED_TAB)));

    public static void Register() { }

    public enum ModItemTier implements IItemTier
    {
        LAVA_STEEL(3, 300, 3.25f, 3f, 20,
                Ingredient.fromStacks(new ItemStack(ModItems.LAVA_STEEL_INGOT.get())));

        private final int harvestLevel;
        private final int maxUses;
        private final float efficiency;
        private final float attackDamage;
        private final int enchantability;
        private final Ingredient repairMaterial;

        ModItemTier(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Ingredient repairMaterial)
        {
            this.harvestLevel = harvestLevel;
            this.maxUses = maxUses;
            this.efficiency = efficiency;
            this.attackDamage = attackDamage;
            this.enchantability = enchantability;
            this.repairMaterial = repairMaterial;
        }

        @Override
        public int getMaxUses()
        {
            return maxUses;
        }

        @Override
        public float getEfficiency()
        {
            return efficiency;
        }

        @Override
        public float getAttackDamage()
        {
            return attackDamage;
        }

        @Override
        public int getHarvestLevel()
        {
            return harvestLevel;
        }

        @Override
        public int getEnchantability()
        {
            return enchantability;
        }

        @Override
        public Ingredient getRepairMaterial()
        {
            return repairMaterial;
        }
    }
}
