package fr.wind_blade.isorropia.common.compat;

import dev.tc4port.thaumcraft.api.aspect.AspectAmounts;
import dev.tc4port.thaumcraft.api.aspect.AspectId;
import dev.tc4port.thaumcraft.api.aspect.BuiltinAspects;
import dev.tc4port.thaumcraft.api.vis.VisDecomposition;
import dev.tc4port.thaumcraft.api.vis.VisStorage;
import dev.tc4port.thaumcraft.api.vis.VisStorageCapabilities;
import dev.tc4port.thaumcraft.api.wand.WandCapabilities;
import dev.tc4port.thaumcraft.api.wand.WandTool;
import dev.tc4port.thaumcraft.api.wand.WandView;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import net.minecraft.world.item.ItemStack;

public final class VisCompat {
    /** The legacy dynamo button, bit mask, and save order. */
    public static final List<AspectId> PRIMALS = List.of(BuiltinAspects.AER, BuiltinAspects.TERRA,
            BuiltinAspects.IGNIS, BuiltinAspects.AQUA, BuiltinAspects.ORDO, BuiltinAspects.PERDITIO);

    private VisCompat() { }

    public static Optional<WandView> wandView(ItemStack stack) {
        //? if forge {
        return stack.getCapability(WandCapabilities.TOOL).resolve().flatMap(WandTool::view);
        //?} else {
        /*return Optional.ofNullable(stack.getCapability(WandCapabilities.TOOL)).flatMap(WandTool::view);
        *///?}
    }

    public static Optional<VisStorage> wandStorage(ItemStack stack) {
        //? if forge {
        return stack.getCapability(VisStorageCapabilities.ITEM).resolve();
        //?} else {
        /*return Optional.ofNullable(stack.getCapability(VisStorageCapabilities.ITEM));
        *///?}
    }

    public static Set<AspectId> primalComponents(AspectId aspect) {
        var reduced = VisDecomposition.reduce(new AspectAmounts(Map.of(aspect, 1)), PRIMALS, true);
        var ordered = new LinkedHashSet<>(PRIMALS);
        ordered.retainAll(reduced.amounts().keySet());
        return ordered;
    }
}
