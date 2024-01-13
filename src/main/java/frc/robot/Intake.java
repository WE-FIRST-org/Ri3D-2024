package frc.robot;

import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

public class Intake {
    VictorSPX intakeMotor;
    double speed = 0.5;

    public Intake() {
        intakeMotor = new VictorSPX(6);
    }

    public void setspeed(double targ) {
        speed = targ;
    }

    public void in() {
        intakeMotor.set(VictorSPXControlMode.PercentOutput, speed);
    }

    public void out() {
        intakeMotor.set(VictorSPXControlMode.PercentOutput, -speed);
    }

    public void off() {
        intakeMotor.set(VictorSPXControlMode.PercentOutput, 0);
    }
}
