package sunrise;
import arc.*;
import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.math.geom.*;
import arc.struct.*;
import arc.util.*;
import mindustry.entities.*;
import mindustry.game.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.ui.*;

import sunrise.SunriseColors;

import static arc.graphics.g2d.Draw.rect;
import static arc.graphics.g2d.Draw.*;
import static arc.graphics.g2d.Lines.*;
import static arc.math.Angles.*;
import static mindustry.Vars.*;

public class SunriseEffects {
    public static final Effect

    orangeLaserCharge = new Effect(90.0F, 110.0F, (e) -> {
        Color color = SunriseColors.orangeLaserColor;
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