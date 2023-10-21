package net.masik.mythiccharms.compat.rei;

import io.wispforest.owo.compat.rei.ReiUIAdapter;
import io.wispforest.owo.ui.component.Components;
import io.wispforest.owo.ui.container.Containers;
import io.wispforest.owo.ui.core.HorizontalAlignment;
import io.wispforest.owo.ui.core.Sizing;
import io.wispforest.owo.ui.core.VerticalAlignment;
import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.gui.Renderer;
import me.shedaniel.rei.api.client.gui.widgets.Widget;
import me.shedaniel.rei.api.client.gui.widgets.Widgets;
import me.shedaniel.rei.api.client.registry.display.DisplayCategory;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.masik.mythiccharms.MythicCharms;
import net.masik.mythiccharms.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.List;

public class ResonanceTableCategory implements DisplayCategory<ResonanceTableDisplay> {

    @Override
    public List<Widget> setupDisplay(ResonanceTableDisplay display, Rectangle bounds) {

        var adapter = new ReiUIAdapter<>(bounds, Containers::stack);

        var root = adapter.rootComponent();

        root.horizontalAlignment(HorizontalAlignment.CENTER).verticalAlignment(VerticalAlignment.CENTER);

        root.child(adapter.wrap(Widgets.createRecipeBase(bounds)));

        root.child(Containers.verticalFlow(Sizing.content(), Sizing.content())
                .child(Containers.horizontalFlow(Sizing.content(), Sizing.content())
                        .child(Containers.verticalFlow(Sizing.content(), Sizing.content())
                                .child(Containers.horizontalFlow(Sizing.content(), Sizing.content())
                                        .child(adapter.wrap(Widgets::createSlot, slot -> slot.entries(display.getInputEntries().get(0))))
                                        .child(adapter.wrap(Widgets::createSlot, slot -> slot.entries(display.getInputEntries().get(1))))
                                        .child(adapter.wrap(Widgets::createSlot, slot -> slot.entries(display.getInputEntries().get(2))))
                                        .gap(3))
                                .child(Containers.horizontalFlow(Sizing.content(), Sizing.content())
                                        .child(adapter.wrap(Widgets::createSlot, slot -> slot.entries(display.getInputEntries().get(3))))
                                        .child(adapter.wrap(Widgets::createSlot, slot -> slot.entries(display.getInputEntries().get(4))))
                                        .gap(3))
                                .gap(3).horizontalAlignment(HorizontalAlignment.CENTER))
                        .child(Containers.verticalFlow(Sizing.content(), Sizing.content())
                                .child(adapter.wrap(Widgets::createSlot, slot -> slot.entries(display.getInputEntries().get(5))))
                                .gap(5)
                                .child(Components.texture(new Identifier(MythicCharms.MOD_ID, "textures/gui/widgets.png"), 0,0, 31, 15, 256, 256))
                                .horizontalAlignment(HorizontalAlignment.CENTER))
                        .verticalAlignment(VerticalAlignment.CENTER))
                .child(Containers.horizontalFlow(Sizing.content(), Sizing.content())
                        .child(adapter.wrap(Widgets::createSlot, slot -> slot.entries(display.getInputEntries().get(6))))
                        .gap(5)
                        .child(Containers.verticalFlow(Sizing.content(), Sizing.content())
                                .child(Components.block(ModBlocks.RESONANCE_TABLE.getDefaultState()).sizing(Sizing.fixed(32)))
                                .child(Components.block(Blocks.LAPIS_BLOCK.getDefaultState()).sizing(Sizing.fixed(32)))
                                .gap(-8))
                        .child(adapter.wrap(Widgets.createArrow(ReiUIAdapter.LAYOUT)))
                        .child(adapter.wrap(Widgets::createSlot, slot -> slot.entries(display.getOutputEntries().get(0))))
                        .gap(5)
                        .verticalAlignment(VerticalAlignment.CENTER))
                .gap(5)
                .horizontalAlignment(HorizontalAlignment.CENTER));

        adapter.prepare();

        return List.of(adapter);

    }

    @Override
    public int getDisplayHeight() {
        return 120;
    }

    @Override
    public CategoryIdentifier<? extends ResonanceTableDisplay> getCategoryIdentifier() {

        return MythicCharmsReiPlugin.RESONANCE_INFUSING;

    }

    @Override
    public Text getTitle() {
        return Text.translatable("category.mythic_charms.resonance");
    }

    @Override
    public Renderer getIcon() {
        return EntryStacks.of(ModBlocks.RESONANCE_TABLE);
    }

}