package fr.wind_blade.isorropia.common.config;

import java.util.List;

/** Pack policy without registry access; an empty whitelist deliberately yields no drops. */
public final class OrePigPolicy {
    private OrePigPolicy() {}

    public static boolean allows(String material, boolean hasNugget, List<? extends String> allowed,
                                 boolean dustFallback) {
        return (hasNugget || dustFallback) && (allowed.contains("*") || allowed.contains(material));
    }
}
