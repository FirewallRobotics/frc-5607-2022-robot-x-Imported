package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.*;

/** An example command that uses an example subsystem. */
public class ShootingCargoCommand extends CommandBase {

  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final Shooter m_shooter;

  /**
   * Creates a new ShootingCargoCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public ShootingCargoCommand(Shooter subsystem) {
    m_shooter = subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  @Override
  public void execute() {
    m_shooter.HighShooterStart();
  }

  @Override
  public void end(boolean interrupted) {
    m_shooter.ShooterStop();
  }
}
