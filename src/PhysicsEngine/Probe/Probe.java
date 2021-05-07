package PhysicsEngine.Probe;

import PhysicsEngine.titan.Vector3dInterface;

public class Probe {

    //Data taken from Rocket Specifics announcement
    public double mass = 78000;             //7.8e4 kg
    public double massLander = 6000;        //6e3 kg
    public double exhaustVel = 20;          //20 km/s = 2e4 m/s
    public double maxThrust = 30;           //30 MN = 3e7 N

    //Data taken from the PlanetStart class
    public double radius = 10;
    public double gravity = 1e-10;

    //Other data to be added
    public double fuel = 0.0;
    public double positionX = 0;
    public double positionY = 0;
    public double positionZ = 0;
    public double velocityX = 0;
    public double velocityY = 0;
    public double velocityZ = 0;
    public Vector3dInterface posVector;
    public Vector3dInterface velVector;
    public Vector3dInterface accVector;

    //Constructor
    public Probe() {

    }

    //DATA REMOVED FROM PLANET CLASS!!!

    //Spacecraft
    //Planet spaceCraft = new Planet("SpaceCraft");
    //Adding the Earths radius somewhere = 6371e+3;
    //spaceCraft.mass = 15000;
    //spaceCraft.radius = 10;
    //spaceCraft.gravity = 1e-10;
//        spaceCraft.positionX = (6371e+3 + -1.471922101663588e+11);
//        spaceCraft.positionY = (6371e+3 + -2.860995816266412e+10);
//        spaceCraft.positionZ = (6371e+3 + 8.278183193596080e+06);
//        spaceCraft.velocityX = 5.427193405797901e+03;
//        spaceCraft.velocityY = -2.931056622265021e+04;
//        spaceCraft.velocityZ = 6.575428158157592e-01;
    //spaceCraft.positionX = 0;
    //spaceCraft.positionY = 0;
    //spaceCraft.positionZ = 0;
    //spaceCraft.velocityX = 0;
    //spaceCraft.velocityY = 0;
    //spaceCraft.velocityZ = 0;
        //spaceCraft.vectors();
    //planets[11] = spaceCraft;
}
