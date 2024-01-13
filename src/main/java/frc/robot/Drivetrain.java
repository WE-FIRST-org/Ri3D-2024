package frc.robot;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

public class Drivetrain {
    VictorSPX[] motors = new VictorSPX[4];
    
    public Drivetrain() {
        for(int i=0; i < 4; i++) {
            motors[i] = new VictorSPX(i);

            if(i < 1) motors[i].set(ControlMode.Follower, i % 2);
            if (i % 2 == 0) {
                motors[i].setInverted(true);
            }
          }
    }

    public void tank(double l, double r) {
        motors[0].set(VictorSPXControlMode.PercentOutput, l);
        motors[1].set(VictorSPXControlMode.PercentOutput, r);
    }

    public void arcade (double x, double y) {
        motors[0].set(VictorSPXControlMode.PercentOutput, y+x);
        motors[1].set(VictorSPXControlMode.PercentOutput, y-x);
    }

}

