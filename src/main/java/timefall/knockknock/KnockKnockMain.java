package timefall.knockknock;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.TrapdoorBlock;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;

public class KnockKnockMain implements ModInitializer {

    public static boolean isADoor(BlockState blockState) {
        Block block = blockState.getBlock();
        return block instanceof DoorBlock;
    }

    public static boolean isATrapDoor(BlockState blockState) {
        Block block = blockState.getBlock();
        return block instanceof TrapdoorBlock;
    }

    @Override
    public void onInitialize() {

        AttackBlockCallback.EVENT.register((player, world, hand, pos, direction) ->
        {
            BlockState state = world.getBlockState(pos);
            if (!player.isSpectator() && isADoor(state))
                world.playSound(null, pos, SoundEvents.BLOCK_WOOD_PLACE, SoundCategory.BLOCKS, 1f, 0.6f);
            if (!player.isSpectator() && isATrapDoor(state))
                world.playSound(null, pos, SoundEvents.BLOCK_WOOD_PLACE, SoundCategory.BLOCKS, 1f, 0.6f);

            return ActionResult.PASS;
        });
   }
}
