package fun.exort.module.list.render.hud;

import com.google.common.base.Suppliers;
import com.google.common.eventbus.Subscribe;
import fun.exort.event.list.EventHUD;
import fun.exort.module.Module;
import fun.exort.module.ModuleCategory;
import fun.exort.module.ModuleInformation;
import fun.exort.module.settings.BooleanSetting;
import fun.exort.util.render.builders.Builder;
import fun.exort.util.render.builders.states.QuadColorState;
import fun.exort.util.render.builders.states.QuadRadiusState;
import fun.exort.util.render.builders.states.SizeState;
import fun.exort.util.render.msdf.MsdfFont;
import fun.exort.util.render.renderers.impl.BuiltBlur;
import fun.exort.util.render.renderers.impl.BuiltText;
import net.minecraft.client.gui.DrawContext;
import org.joml.Matrix4f;

import java.awt.*;
import java.util.function.Supplier;

@ModuleInformation(moduleName = "Hud", moduleCategory = ModuleCategory.RENDER)
public class Hud extends Module {

    public BooleanSetting watermark = new BooleanSetting("Watermark", this, true);
    public BooleanSetting coordinates = new BooleanSetting("CoordsInfo", this, false);
    public BooleanSetting notification = new BooleanSetting("Notification", this, false);

    private static final Supplier<MsdfFont> BIKO_FONT = Suppliers.memoize(() -> MsdfFont.builder().atlas("biko").data("biko").build());

    public Hud() {
        addSetting(watermark);
        addSetting(coordinates);
        addSetting(notification);
    }

    @Subscribe
    public void onEventHUD(EventHUD event) {
        if (watermark.getValue()) {
            renderWatermark(event.getDrawContext());
        }
        if (coordinates.getValue()) {
            renderCoordsInfo(event.getDrawContext());
        }
    }

    private void renderWatermark(DrawContext context) {
        if (mc.player == null) return;

        Matrix4f matrix = context.getMatrices().peek().getPositionMatrix();

        String watermarkTitle = "ExortWare  >  " + mc.player.getName().getString() + "  >  " + mc.getCurrentFps() + " fps";

        BuiltBlur blur = Builder.blur()
                .size(new SizeState(BIKO_FONT.get().getWidth(watermarkTitle, 10) + 15, 20))
                .color(new QuadColorState(new Color(30, 30, 30, 255)))
                .radius(new QuadRadiusState(4))
                .smoothness(1f)
                .blurRadius(6)
                .build();
        blur.render(matrix, 5, 5);

        BuiltText text = Builder.text()
                .font(BIKO_FONT.get())
                .size(10)
                .text(watermarkTitle)
                .thickness(0.02f)
                .color(-1)
                .build();
        text.render(matrix, 11, 10.5f);
    }

    private void renderCoordsInfo(DrawContext context) {
        if (mc.player == null) return;

        Matrix4f matrix = context.getMatrices().peek().getPositionMatrix();

        float x = Math.round(mc.player.getPos().getX());
        float y = Math.round(mc.player.getPos().getY());
        float z = Math.round(mc.player.getPos().getZ());

        String coordsTitle = "X: " + x + ", Y: " + y + ", Z: " + z;

        BuiltBlur blur = Builder.blur()
                .size(new SizeState(BIKO_FONT.get().getWidth(coordsTitle, 10) + 15, 20))
                .color(new QuadColorState(new Color(30, 30, 30, 255)))
                .radius(new QuadRadiusState(4))
                .smoothness(1f)
                .blurRadius(6)
                .build();
        blur.render(matrix, 5, 5 + 510);

        BuiltText text = Builder.text()
                .font(BIKO_FONT.get())
                .size(10)
                .text(coordsTitle)
                .thickness(0.02f)
                .color(-1)
                .build();
        text.render(matrix, 11, 10.5f + 510);
    }
}
