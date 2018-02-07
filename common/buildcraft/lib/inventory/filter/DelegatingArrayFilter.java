/*
 * Copyright (c) 2017 SpaceToad and the BuildCraft team
 * This Source Code Form is subject to the terms of the Mozilla Public License, v. 2.0. If a copy of the MPL was not
 * distributed with this file, You can obtain one at https://mozilla.org/MPL/2.0/
 */

package buildcraft.lib.inventory.filter;

import javax.annotation.Nonnull;

import net.minecraft.item.ItemStack;

import buildcraft.api.core.IStackFilter;

import java.util.List;

public class DelegatingArrayFilter implements IStackFilter {
    private final ISingleStackFilter perStackFilter;
    private final List<ItemStack> stacks;

    public DelegatingArrayFilter(ISingleStackFilter perStackFilter, List<ItemStack> stacks) {
        this.perStackFilter = perStackFilter;
        this.stacks = stacks;
    }

    @Nonnull
    @Override
    public List<ItemStack> getExamples() {
        return stacks;
    }

    @Override
    public boolean matches(@Nonnull ItemStack stack) {
        for (ItemStack possible : stacks) {
            if (perStackFilter.matches(possible, stack)) {
                return true;
            }
        }
        return false;
    }
}
