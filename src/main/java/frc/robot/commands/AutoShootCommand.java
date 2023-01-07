package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.*;

public class AutoShootCommand extends CommandBase {

  private DriveTrain m_drivetrain;
  private Vision m_vision;
  private boolean isFinished = false;

  public AutoShootCommand(DriveTrain dt_subsystem, Vision v_subsystem) {
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
    isFinished = false;
    long hubXMin = Math.round(m_vision.hubXmin.getDouble(0));
    // long hubYMin = Math.round(m_vision.hubYmin.getDouble(0));
    long hubXMax = Math.round(m_vision.hubXmax.getDouble(0));
    /// long hubYMax = Math.round(m_vision.hubYmax.getDouble(0));
    // long xDif = (hubXMax - hubXMin);
    long centerOfFrame = Constants.ShooterConstants.CenterOfShootingFrame;
    long centerOfHub = Math.round((hubXMax + hubXMin) / 2);
    long centerDif = Math.abs(centerOfFrame - centerOfHub);
    long shootingDistance = Constants.ShooterConstants.ShootingDistance;
    long distance = (hubXMax - hubXMin);
    long distanceDif = shootingDistance - distance;
    if (centerDif < 5) {
      // Shoot or whatever
      // Comment the next few lines if we can't get this to drive to the correct spot
      if (Math.abs(distanceDif) < 3) {
        m_drivetrain.Drive(0, 0, 0);
        isFinished = true;
      } else if (distanceDif < 0) {
        m_drivetrain.Drive(-0.15 + (distanceDif / 640), 0, 0);
      } else {
        m_drivetrain.Drive(0.15 + (distanceDif / 640), 0, 0);
      }
    } else if (centerOfHub < centerOfFrame) {
      // Move bot left
      m_drivetrain.Drive(0, 0, -0.3);
    } else if (centerOfHub > centerOfFrame) {
      // Move bot right
      m_drivetrain.Drive(0, 0, 0.3);
    }

    /*if (hubXMin == 0) {
      // ScaledX = 0;
      // red_radius = 0;
      blue_radius = 0;
    } else {
      // ScaledX = PGainX * ((((Maxx - Minx) * ((X - MinX) / (MaxX - MinX))) + Minx) -
      // NeutralOffSetX);
      m_vision.ScaledRadius =
          m_vision.PGainR
                  * ((((m_vision.MaxOutR - m_vision.MinOutR)
                          * (blue_radius - m_vision.MinRadius)
                          / (MaxRadius - m_vision.MinRadius)))
                      + m_vision.MinOutR)
              - m_vision.NeutralOffSetR;
    }
    if (x_Blue == centerOfFrame) {
      m_drivetrain.Drive(0.25, 0, 0);
    } else if (x_Blue < centerOfFrame) {
      m_drivetrain.Drive(0, -0.25, 0);
    } else if (x_Blue > centerOfFrame) {
      m_drivetrain.Drive(0, 0.25, 0);
    }*/
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
