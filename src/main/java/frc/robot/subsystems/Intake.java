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

public class Intake extends SubsystemBase{
    public SparkMax intakemotor1 = new SparkMax(9,MotorType.kBrushless);
    public SparkMax intakemotor2 = new SparkMax(10,MotorType.kBrushless);
    public SparkMax Feeder_motor = new SparkMax(14,MotorType.kBrushless);
    private PIDController pid = new PIDController(0.05, 0, 0);
    private DigitalInput beambreak = new DigitalInput(0);

    public Intake() {

    }
    @Override
    public void periodic(){
        SmartDashboard.putBoolean("BeamBreak Activation", beambreak.get());
      

    }

    public Command intakeCommand(double intake_speed, double feeder_speed) {
        
        
        return new Command() {
            @Override
            public void initialize() {
                // Initialization code, such as resetting encoders or PID controllers
            }
    
            @Override
            public void execute() {
                // Set the intake motors to the specified speed
                intakemotor1.set(-intake_speed);
                intakemotor2.set(intake_speed);
                Feeder_motor.set(-feeder_speed);
                
                // Optionally, you can add logic to control the PID controller or other subsystems
            }
    
            @Override
            public void end(boolean interrupted) {
                intakemotor1.set(0);
                intakemotor2.set(0);
                Feeder_motor.set(0);
                // Stop the motor when the command ends or is interrupted
            }
    
            @Override
            public boolean isFinished() {
                return !beambreak.get();
            }
        };
    }

}
