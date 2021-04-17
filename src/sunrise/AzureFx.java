package sunrise;
import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import mindustry.entities.*;
import mindustry.graphics.Drawf;

import static arc.graphics.g2d.Draw.rect;

public class AzureFx {
    public static final Effect

            orangeLaserCharge = new Effect(90.0F, 110.0F, (e) -> {
        Color color = AzurePal.orangeLaserColor;
        Draw.color(color);
        Lines.stroke(e.fin() * 2.5F);
        Lines.circle(e.x, e.y, 7.0F + e.fout() * 100.0F);
        Fill.circle(e.x, e.y, e.fin() * 23.0F);
        Angles.randLenVectors((long) e.id, 50, 45.0F * e.fout(), (x, y) -> {
            Fill.circle(e.x + x, e.y + y, e.fin() * 5.2F);
        });
        Draw.color();
        Fill.circle(e.x, e.y, e.fin() * 15.0F);
    }),
//just change 1 color
    mintLaserCharge = new Effect(90.0F, 110.0F, (e) -> {
        Color color = AzurePal.mintLaserColor;
        Draw.color(color);
        Lines.stroke(e.fin() * 2.5F);
        Lines.circle(e.x, e.y, 7.0F + e.fout() * 100.0F);
        Fill.circle(e.x, e.y, e.fin() * 23.0F);
        Angles.randLenVectors((long) e.id, 50, 45.0F * e.fout(), (x, y) -> {
            Fill.circle(e.x + x, e.y + y, e.fin() * 5.2F);
        });
        Draw.color();
        Fill.circle(e.x, e.y, e.fin() * 15.0F);
    }),
        syreniRocketExplosion = new Effect(22.0F, e -> {
            Draw.color(AzurePal.syreniFrontColor);
            e.scaled(6.0F, (i) -> {
                Lines.stroke(3.0F * i.fout());
                Lines.circle(e.x, e.y, 3.0F + i.fin() * 15.0F);
            });
            Draw.color(Color.gray);
            Angles.randLenVectors((long) e.id, 5, 2.0F + 23.0F * e.finpow(), (x, y) -> {
                Fill.circle(e.x + x, e.y + y, e.fout() * 4.0F + 0.5F);
            });
            Draw.color(AzurePal.syreniBackColor);
            Lines.stroke(e.fout());
            Angles.randLenVectors((long) (e.id + 1), 4, 1.0F + 23.0F * e.finpow(), (x, y) -> {
                Lines.lineAngle(e.x + x, e.y + y, Mathf.angle(x, y), 1.0F + e.fout() * 3.0F);
            });
        }),

    syreniTrail = new Effect(37.0F, (e) -> {
        for (int i = 0; i < 2; ++i) {
            Draw.color(i == 0 ? AzurePal.syreniBackColor : AzurePal.syreniFrontColor);
            float m = i == 0 ? 1.0F : 0.5F;
            float rot = e.rotation + 180.0F;
            float w = 20.0F * e.fout() * m;
            Drawf.tri(e.x, e.y, w, (30.0F + Mathf.randomSeedRange((long) e.id, 19.0F)) * m, rot);
            Drawf.tri(e.x, e.y, w, 8.0F * m, rot);
        }

    }),

    syreniShoot = new Effect(60.0F, (e) -> {
        e.scaled(32.0F, (b) -> {
            Draw.color(Color.white, AzurePal.syreniFrontColor, b.fin());
            Lines.stroke(b.fout() * 5.0F + 1.7F);
            Lines.circle(b.x, b.y, b.fin() * 50.0F);
            Lines.square(e.x, e.y, b.fin() * 40.0F, 60);
        });
        Draw.color(AzurePal.syreniFrontColor);
        int[] var1 = Mathf.signs;
        int var2 = var1.length;

        for (int var3 = 0; var3 < var2; ++var3) {
            int i = var1[var3];
            Drawf.tri(e.x, e.y, 13.0F * e.fout(), 85.0F, e.rotation + 90.0F * (float) i);
            Drawf.tri(e.x, e.y, 11.0F * e.fout(), 50.0F, e.rotation + 20.0F * (float) i);
            Drawf.tri(e.x, e.y, 5.0F * e.fout(), 60.0F, e.rotation + 12.0F * (float) i);
            Drawf.tri(e.x, e.y, 8.0F * e.fout(), 100.0F, e.rotation + 120.0F * (float) i);
        }

    }),

    syreniHit = new Effect(20.0F, 200.0F, (e) -> {
        Draw.color(AzurePal.syreniColor);

        for (int i = 0; i < 2; ++i) {
            Draw.color(i == 0 ? AzurePal.syreniColor : AzurePal.syreniFrontColor);
            float m = i == 0 ? 1.0F : 0.5F;

            for (int j = 0; j < 5; ++j) {
                float rot = e.rotation + Mathf.randomSeedRange((long) (e.id + j), 50.0F);
                float w = 23.0F * e.fout() * m;
                Drawf.tri(e.x, e.y, w, (80.0F + Mathf.randomSeedRange((long) (e.id + j), 40.0F)) * m, rot);
                Drawf.tri(e.x, e.y, w, 20.0F * m, rot + 180.0F);
            }
        }

        e.scaled(10.0F, (c) -> {
            Draw.color(AzurePal.syreniColor);
            Lines.stroke(c.fout() * 2.0F + 0.2F);
            Lines.circle(e.x, e.y, c.fin() * 30.0F);
        });
        e.scaled(12.0F, (c) -> {
            Draw.color(AzurePal.syreniColor);
            Angles.randLenVectors((long) e.id, 25, 5.0F + e.fin() * 80.0F, e.rotation, 60.0F, (x, y) -> {
                Fill.square(e.x + x, e.y + y, c.fout() * 3.0F, 45.0F);
            });
        });
    });

}