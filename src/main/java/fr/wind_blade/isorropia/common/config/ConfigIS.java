package fr.wind_blade.isorropia.common.config;

import net.minecraftforge.common.ForgeConfigSpec;

public final class ConfigIS {
    public static final ForgeConfigSpec SPEC;
    public static final ForgeConfigSpec.IntValue TAINT_EAT_COOLDOWN;
    public static final ForgeConfigSpec.DoubleValue ORE_PIG_MAIN_WEIGHT;
    public static final ForgeConfigSpec.DoubleValue ORE_PIG_OTHER_WEIGHT;
    public static final ForgeConfigSpec.ConfigValue<java.util.List<? extends String>> ORE_PIG_MATERIALS;
    public static final ForgeConfigSpec.BooleanValue ORE_PIG_DUST_FALLBACK;

    static {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();
        builder.comment("The configuration for the creatures of the mod").push("creatures");
        TAINT_EAT_COOLDOWN = builder
                .comment("Ticks the taint pig waits before eating another taint block (20 ticks = 1 second)")
                .defineInRange("taint_eat_cooldown", 3, 0, 72000);
        ORE_PIG_MAIN_WEIGHT = builder
                .comment("Weight of the ore an ore pig was infused with in its nugget roll")
                .defineInRange("ore_pig_main_weight", 1.0D, 0.0D, 1000.0D);
        ORE_PIG_OTHER_WEIGHT = builder
                .comment("Weight of every other ore in an ore pig's nugget roll")
                .defineInRange("ore_pig_other_weight", 1.0D, 0.0D, 1000.0D);
        ORE_PIG_MATERIALS = builder
                .comment("Allowed forge:ores/<material> suffixes for ore pig drops. Use [\"*\"] for the legacy unrestricted pool; [] disables drops.")
                .defineListAllowEmpty("ore_pig_materials", java.util.List.of("*"),
                        value -> value instanceof String id && (id.equals("*") || id.matches("[a-z0-9_]+")));
        ORE_PIG_DUST_FALLBACK = builder
                .comment("When a material has no nugget, allow one whole dust instead. Disable in progression packs.")
                .define("ore_pig_dust_fallback", true);
        builder.pop();
        SPEC = builder.build();
    }

    private ConfigIS() {
    }
}
