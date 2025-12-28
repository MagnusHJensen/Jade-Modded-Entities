package dk.magnusjensen.jademoddedentities.ui;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.phys.Vec2;
import snownee.jade.api.ui.Element;
import snownee.jade.overlay.OverlayRenderer;

import static snownee.jade.overlay.DisplayHelper.drawTexturedModalRect;

public class VanillaIconElement extends Element {
    private static final ResourceLocation GUI_ICONS_LOCATION = new ResourceLocation("textures/gui/icons.png");

   private final VanillaIcon icon;

    public VanillaIconElement(VanillaIcon icon) {
        this.icon = icon;
    }

    @Override
    public Vec2 getSize() {
        return new Vec2(8.0F, 8.0F);
    }

    @Override
    public void render(GuiGraphics guiGraphics, float x, float y, float sx, float sy) {
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, OverlayRenderer.alpha);
        RenderSystem.setShaderTexture(0, GUI_ICONS_LOCATION);
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();

        drawTexturedModalRect(guiGraphics, x, y, icon.u, icon.v, 8, 8, icon.tw, icon.th);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
    }
}
