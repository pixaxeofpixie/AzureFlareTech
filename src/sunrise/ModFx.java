package sunrise;
import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import mindustry.entities.*;

import static arc.graphics.g2d.Draw.rect;

public class ModFx {
    public static final Effect

    orangeLaserCharge = new Effect(90.0F, 110.0F, (e) -> {
        Color color = ModPal.orangeLaserColor;
        Draw.color(color);
        Lines.stroke(e.fin() * 2.5F);
        Lines.circle(e.x, e.y, 7.0F + e.fout() * 100.0F);
        Fill.circle(e.x, e.y, e.fin() * 23.0F);
        Angles.randLenVectors((long) e.id, 50, 45.0F * e.fout(), (x, y) -> {
            Fill.circle(e.x + x, e.y + y, e.fin() * 5.2F);
        });
        Draw.color();
        Fill.circle(e.x, e.y, e.fin() * 15.0F);
    });
}