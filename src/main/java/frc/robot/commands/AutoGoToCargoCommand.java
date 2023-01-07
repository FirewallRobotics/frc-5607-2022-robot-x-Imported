package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.*;

public class AutoGoToCargoCommand extends CommandBase {

  private static final int MaxRadius = 0;
  private DriveTrain m_drivetrain;
  private Vision m_vision;
  private int x_Red;
  private int x_Blue;
  private boolean isFinished = false;

  public AutoGoToCargoCommand(DriveTrain dt_subsystem, Vision v_subsystem) {
    m_drivetrain = dt_subsystem;
    m_vision = v_subsystem;
    addRequirements(dt_subsystem);
    addRequirements(v_subsystem);
  }

  // @Override
  // protected void initialize() {
  // }

  @Override
  public void execute() {
    boolean IsRedAlliance = m_vision.red_alliance.getBoolean(false);
    double x_Blue = Math.round(m_vision.x_Blue.getDouble(0));
    double blue_radius = Math.round(m_vision.blue_radius.getDouble(0));
    double x_Red = Math.round(m_vision.x_Red.getDouble(0));
    double red_radius = Math.round(m_vision.red_radius.getDouble(0));
    isFinished = false;
    if (IsRedAlliance == false) {
      int center = 320;
      double radiusToStop = 200;
      if (Math.abs(x_Blue - center) < 5) {
        long distanceDif = Math.round(blue_radius - radiusToStop);
        if (Math.abs(distanceDif) < 5) {
          m_drivetrain.Drive(0, 0, 0);
          isFinished = true;
        } else if (distanceDif < 0) {
          m_drivetrain.Drive(0.15 + (distanceDif / 640), 0, 0);
        } else {
          m_drivetrain.Drive(-0.15 + (distanceDif / 640), 0, 0);
        }
      } else if (x_Blue < center) {
        m_drivetrain.Drive(0, 0, -0.3);
      } else if (x_Blue > center) {
        m_drivetrain.Drive(0, 0, 0.3);
      }
    } else {
      int center = 320;
      double radiusToStop = 200;
      if (Math.abs(x_Red - center) < 5) {
        long distanceDif = Math.round(red_radius - radiusToStop);
        if (Math.abs(distanceDif) < 5) {
          m_drivetrain.Drive(0, 0, 0);
          isFinished = true;
        } else if (distanceDif < 0) {
          m_drivetrain.Drive(0.15 + (distanceDif / 640), 0, 0);
        } else {
          m_drivetrain.Drive(-0.15 + (distanceDif / 640), 0, 0);
        }
      } else if (x_Red < center) {
        m_drivetrain.Drive(0, 0, -0.3);
      } else if (x_Red > center) {
        m_drivetrain.Drive(0, 0, 0.3);
      }
    }
  }

  @Override
  public boolean isFinished() {
    return (isFinished);
  }
  // @Override
  // protected void end() {

  // }

  // break movements into moving right and left/up and down

  // find a way to slow down motors as the robot gets closer to the ball

}
