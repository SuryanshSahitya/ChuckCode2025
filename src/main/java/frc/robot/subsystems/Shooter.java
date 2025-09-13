package frc.robot.subsystems;

import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import swervelib.encoders.DIODutyCycleEncoderSwerve;

public class Shooter extends SubsystemBase{
    public SparkMax shooter_right = new SparkMax(13,MotorType.kBrushless);
    public SparkMax shooter_left = new SparkMax(11,MotorType.kBrushless);

    public Shooter() {

    }
    @Override
    public void periodic(){
      

    }
    public void setShooterSpeed(double shooter_speed) {
        shooter_left.set(-shooter_speed);
        shooter_right.set(shooter_speed);
    }

    public Command  shooterCommand(double shooter_speed) {
        
        
        return new Command() {
            @Override
            public void initialize() {
                // Initialization code, such as resetting encoders or PID controllers
            }
    
            @Override
            public void execute() {
                // Set the intake motors to the specified speed
                shooter_left.set(shooter_speed);
                shooter_right.set(shooter_speed);
                
            }
    
            @Override
            public void end(boolean interrupted) {
                shooter_left.set(0);
                shooter_left.set(0);
                // Stop the motor when the command ends or is interrupted
            }
    
            @Override
            public boolean isFinished() {
                return false;
            }
        };
    }

}
