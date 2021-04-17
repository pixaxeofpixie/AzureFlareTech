package sunrise.content;

import arc.func.Prov;
import arc.graphics.*;
import arc.struct.*;
import mindustry.content.UnitTypes;
import mindustry.entities.abilities.UnitSpawnAbility;
import mindustry.entities.bullet.*;
import mindustry.content.StatusEffects;
import mindustry.gen.*;
import mindustry.content.Fx;
import mindustry.graphics.Layer;
import sunrise.AzureFx;
import mindustry.type.*;
import mindustry.ctype.ContentList;
import sunrise.AzurePal;

public class AzureUnitTypes implements ContentList {
    public static  UnitType morningStar, syreni;


    public AzureUnitTypes() {
        AzureUnitTypes.class.isArray();
    }

    @Override
    public void load() {
        morningStar = new UnitType("morning-star"){{
            hitSize = 32f;
           // unit.constructor = ::new;

            rotateSpeed = 1.4f;
            canDrown = false;
            mechFrontSway = 1.2f;
            buildSpeed = 3f;
            constructor = Types.legs;

            legCount = 4;
            legLength = 14f;
            legBaseOffset = 11f;
            legMoveSpace = 1.5f;
            legTrns = 0.58f;
            hovering = true;
            visualElevation = 0.2f;
            allowLegStep = true;
            ammoType = AmmoTypes.powerHigh;
            groundLayer = Layer.legUnit;

            speed = 0.38f;

            mineTier = 2;
            mineSpeed = 7f;
            drawShields = false;

            mechStepParticles = true;
            mechStepShake = 0.3f;
            ammoType = AmmoTypes.powerHigh;

            speed = 0.39f;
            boostMultiplier = 2.2f;
            engineOffset = 16f;
            engineSize = 8f;
            lowAltitude = true;
            //riseSpeed = 0.02f;

            health = 19000f;
            armor = 10f;
            canBoost = true;
            landShake = 4f;
            immunities = ObjectSet.with(StatusEffects.burning, StatusEffects.sapped);

            commandLimit = 8;

            weapons.add(new Weapon("morning-star-weapon"){{
                mirror = false;
                top = false;
                shake = 4f;
                shootY = 13f;
                y = -1f;
                x = 2.8f;

                firstShotDelay = AzureFx.orangeLaserCharge.lifetime - 1f;

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

                    shootEffect = AzureFx.orangeLaserCharge;

                    incendChance = 0.1f;
                    incendSpread = 5f;
                    incendAmount = 1;

                    //constant healing
                    healPercent = 1f;
                    collidesTeam = true;

                    colors = new Color[]{AzurePal.orangeLaserColor.cpy().a(.2f), AzurePal.orangeLaserColor.cpy().a(.5f), AzurePal.orangeLaserColor.cpy().mul(1.2f), Color.white};
                }};

                shootStatus = StatusEffects.slow;
                shootStatusDuration = bullet.lifetime + firstShotDelay;
            }},
                    new Weapon("morning-star-weapon"){{
                        mirror = false;
                        top = false;
                        shake = 4f;
                        shootY = 13f;
                        y = -1f;
                        x = -2.8f;

                        firstShotDelay = AzureFx.orangeLaserCharge.lifetime - 1f;

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

                            shootEffect = AzureFx.mintLaserCharge;

                            incendChance = 0.1f;
                            incendSpread = 5f;
                            incendAmount = 1;

                            //constant healing
                            healPercent = 1f;
                            collidesTeam = true;

                            colors = new Color[]{AzurePal.mintLaserColor.cpy().a(.2f), AzurePal.mintLaserColor.cpy().a(.5f), AzurePal.mintLaserColor.cpy().mul(1.2f), Color.white};
                        }};

                        shootStatus = StatusEffects.slow;
                        shootStatusDuration = bullet.lifetime + firstShotDelay;
            }});
        }};
        syreni = new UnitType("syreni"){{
            localizedName = "Syren";
            description = "Powerful naval sniper";
            constructor = Types.naval;
            health = 23000;
            speed = 0.62f;
            drag = 0.18f;
            hitSize = 50f;
            armor = 16f;
            accel = 0.19f;
            rotateSpeed = 0.9f;
            rotateShooting = false;

            float spawnTime = 60f * 15f;

            abilities.add(new UnitSpawnAbility(UnitTypes.flare, spawnTime, 19.25f, -31.75f), new UnitSpawnAbility(UnitTypes.flare, spawnTime, -19.25f, -31.75f));

            trailLength = 70;
            trailX = 23f;
            trailY = -32f;
            trailScl = 3.5f;

            this.weapons.add(

                    new Weapon("nas-syreni-launcher") {
                        {
                            this.reload = 80;
                            this.x = 14;
                            this.y = 38f;
                            //this.shadow = 9;
                            this.rotateSpeed = 0.6f;
                            this.rotate = true;
                            this.shots = 2;
                            this.shotDelay = 10;
                            this.inaccuracy = 7f;
                            this.velocityRnd = 0.1f;
                            this.shootSound = Sounds.missile;
                            this.bullet = new ArtilleryBulletType() {
                                {
                                    this.width = 14;
                                    this.height = 16;
                                    this.shrinkY = 0.1f;
                                    this.speed = 2.5f;
                                    this.drag = 0f;
                                    this.splashDamageRadius = 25f;
                                    this.splashDamage = 24f;
                                    this.hitEffect =this.despawnEffect = Fx.explosion;
                                    this.homingPower = 0.2f;
                                    this.lightningDamage = 10f;
                                    this.lightning = 3;
                                    this.lightningLength = 4;
                                    this.makeFire = true;
                                    this.status = StatusEffects.slow;
                                    this.lifetime = 90f;
                                    this.trailColor = AzurePal.syreniColor;
                                    this.backColor = AzurePal.syreniBackColor;
                                    this.frontColor = AzurePal.syreniFrontColor;
                                    this.lightningColor=this.frontColor;
                                    this.weaveScale = 1f;
                                    this.weaveMag = 3f;

                                    fragLifeMin = 0.3f;
                                    fragBullets = 4;

                                    fragBullet = new MissileBulletType(){{
                                        this.width = 10;
                                        this.height = 12;
                                        this.shrinkY = 0.1f;
                                        this.speed = 2.2f;
                                        this.drag = 0f;
                                        this.splashDamageRadius = 25f;
                                        this.splashDamage = 24f;
                                        this.hitEffect =this.despawnEffect = Fx.blastExplosion;
                                        this.homingPower = 0.2f;
                                        this.lightningDamage = 10f;
                                        this.lightning = 3;
                                        this.lightningLength = 4;
                                        this.makeFire = true;
                                        this.status = StatusEffects.slow;
                                        this.lifetime = 90f;
                                        this.trailColor = AzurePal.syreniColor;
                                        this.backColor = AzurePal.syreniBackColor;
                                        this.frontColor = AzurePal.syreniFrontColor;
                                        this.lightningColor=this.frontColor;
                                        this.weaveScale = 1f;
                                        this.weaveMag = 3f;
                                    }};
                                }};
                        }
                    },

                new Weapon("naz-syreni-cannon"){{
                reload = 110f;
                cooldownTime = 90f;
                mirror = false;
                x = 0f;
                y = -3.5f;
                rotateSpeed = 1.4f;
                rotate = true;
                shootY = 23f;
                shake = 6f;
                recoil = 10.5f;
                //shadow = 50f;
                shootSound = Sounds.railgun;

                shots = 1;
                ejectEffect = Fx.none;

                bullet = new RailBulletType(){{
                    shootEffect = AzureFx.syreniShoot;
                    length = 500;
                    updateEffectSeg = 60f;
                    pierceEffect = AzureFx.syreniHit;
                    updateEffect = AzureFx.syreniTrail;
                    hitEffect = Fx.massiveExplosion;
                    smokeEffect = AzureFx.syreniShoot;
                    damage = 1150;
                    pierceDamageFactor = 0.5f;
                }};
            }});
        }};
    }
    public static class Types {
        static Prov<? extends Unit> payload = PayloadUnit::create;
        static Prov<? extends Unit> naval = UnitWaterMove::create;
        static Prov<? extends Unit> legs = LegsUnit::create;
        static Prov<? extends Unit> mech = MechUnit::create;
    }
}
