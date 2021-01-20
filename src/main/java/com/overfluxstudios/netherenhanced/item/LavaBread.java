package com.overfluxstudios.netherenhanced.item;

import com.overfluxstudios.netherenhanced.NetherEnhanced;
import com.overfluxstudios.netherenhanced.util.KeyboardUtil;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import java.util.List;

public class LavaBread extends Item
{
    public LavaBread(){
        super(new Properties().group(NetherEnhanced.NETHERENHANCED_TAB)
                .food(new Food.Builder()
                        .hunger(6)
                        .saturation(2)
                        .effect(() -> new EffectInstance(Effects.FIRE_RESISTANCE, 300, 1), 1f)
                        .build()));
    }

    @Override
    public void addInformation(ItemStack stack, World world, List<ITextComponent> tooltip, ITooltipFlag flag)
    {
        if(KeyboardUtil.isHoldingShift())
        {
            tooltip.add(new StringTextComponent("Hint: Eat to get fire resistance!"));
        }
        else{
            tooltip.add(new StringTextComponent("Hold " + "\u00a7e" + "SHIFT" + "\u00a77" + " for more information"));
        }

        super.addInformation(stack, world, tooltip, flag);
    }
}
