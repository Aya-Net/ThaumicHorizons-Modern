package fr.wind_blade.isorropia.common.config;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class OrePigPolicyTest {
    @Test void packWhitelistExcludesLateMaterials() {
        var allowed = List.of("iron", "copper", "tin", "gold");
        assertTrue(OrePigPolicy.allows("iron", true, allowed, false));
        assertFalse(OrePigPolicy.allows("naquadah", true, allowed, false));
        assertFalse(OrePigPolicy.allows("osmium", true, allowed, false));
    }
    @Test void dustFallbackMustBeExplicit() {
        assertFalse(OrePigPolicy.allows("iron", false, List.of("iron"), false));
        assertTrue(OrePigPolicy.allows("iron", false, List.of("iron"), true));
        assertFalse(OrePigPolicy.allows("naquadah", false, List.of("iron"), true));
    }
    @Test void legacyAndEmptyPolicies() {
        assertTrue(OrePigPolicy.allows("anything", true, List.of("*"), true));
        assertFalse(OrePigPolicy.allows("anything", false, List.of("*"), false));
        assertFalse(OrePigPolicy.allows("iron", true, List.of(), true));
    }
}
