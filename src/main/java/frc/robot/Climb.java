package frc.robot;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class Climb {
    TalonSRX climba, climbb;

    public Climb(){
        climba = new TalonSRX(10);
        climba.setInverted(false);
        climbb = new TalonSRX(11);
        climbb.setInverted(false);
    }

    public void off() {
        climba.set(TalonSRXControlMode.PercentOutput, 0);
        climbb.set(TalonSRXControlMode.PercentOutput, 0);
    }

    public void up() {
        climba.set(TalonSRXControlMode.PercentOutput,1);
        climbb.set(TalonSRXControlMode.PercentOutput, 1);
    }

    public void down() {
        climba.set(TalonSRXControlMode.PercentOutput, -0.5);
        climbb.set(TalonSRXControlMode.PercentOutput, -0.5); 
    }
}
