package sunrise.content;

import arc.graphics.*;
import arc.struct.*;
import mindustry.ctype.*;
import mindustry.entities.bullet.*;
import mindustry.content.StatusEffects;
import mindustry.gen.*;
import mindustry.content.Fx;
import mindustry.type.*;

import sunrise.ModPal;
import sunrise.ModFx;

public class ModUnitTypes implements ContentList {
    public static  UnitType morningStar;

    public ModUnitTypes() {
        ModUnitTypes.class.isArray();
    }

    @Override
    public void load() {
        morningStar = new UnitType("morning-star"){{
            hitSize = 32f;

            rotateSpeed = 1.4f;
            canDrown = false;
            mechFrontSway = 1.2f;
            buildSpeed = 3f;

            mechStepParticles = true;
            mechStepShake = 0.19f;
            ammoType = AmmoTypes.powerHigh;

            speed = 0.39f;
            boostMultiplier = 2.2f;
            engineOffset = 12f;
            engineSize = 6f;
            lowAltitude = true;
            //riseSpeed = 0.02f;

            health = 9500f;
            armor = 9f;
            canBoost = true;
            landShake = 4f;
            immunities = ObjectSet.with(StatusEffects.burning);

            commandLimit = 8;

            weapons.add(new Weapon("morning-star-weapon"){{
                mirror = false;
                top = false;
                shake = 4f;
                shootY = 13f;
                x = y = 0f;

                firstShotDelay = ModFx.orangeLaserCharge.lifetime - 1f;

                reload = 155f;
                recoil = 0f;
                chargeSound = Sounds.lasercharge2;
                shootSound = Sounds.beam;
                continuous = true;
                cooldownTime = 200f;

                bullet = new ContinuousLaserBulletType(){{
                    damage = 90f;
                    length = 175f;
                    hitEffect = Fx.hitMeltHeal;
                    drawSize = 420f;
                    lifetime = 160f;
                    shake = 1f;
                    despawnEffect = Fx.smokeCloud;
                    smokeEffect = Fx.shootBig;

                    shootEffect = ModFx.orangeLaserCharge;

                    incendChance = 0.1f;
                    incendSpread = 5f;
                    incendAmount = 1;

                    //constant healing
                    healPercent = 1f;
                    collidesTeam = true;

                    colors = new Color[]{ModPal.orangeLaserColor.cpy().a(.2f), ModPal.orangeLaserColor.cpy().a(.5f), ModPal.orangeLaserColor.cpy().mul(1.2f), Color.white};
                }};

                shootStatus = StatusEffects.slow;
                shootStatusDuration = bullet.lifetime + firstShotDelay;
            }});
        }};
    }
}
