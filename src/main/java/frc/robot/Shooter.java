package frc.robot;

import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.motorcontrol.Spark;

public class Shooter {

    Spark daisy;
    VictorSPX outer, inner;

    public Shooter(){
        outer = new VictorSPX(4);
        inner = new VictorSPX(5);

        daisy = new Spark(9);
    }

    public void shoot(double shootspeed) {
        outer.set(VictorSPXControlMode.PercentOutput, shootspeed);
        inner.set(VictorSPXControlMode.PercentOutput, shootspeed * 0.8);
    }

    public void feed(double feedspeed) {
        daisy.set(feedspeed);
    }

}
