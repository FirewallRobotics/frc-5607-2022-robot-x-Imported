package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.*;

public class ClimberRetractCommand extends CommandBase {
  @Override
  public void initialize() {}

  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final Climbing m_climbing;

  /**
   * Creates a new ClimberRetractCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public ClimberRetractCommand(Climbing subsystem) {
    m_climbing = subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  @Override
  public void execute() {
    // Write code for climbing here
    m_climbing.ClimberRetractCommand();
  }

  @Override
  public boolean isFinished() {
    return false;
  }

  @Override
  public void end(boolean interrupted) {
    m_climbing.ClimberStopCommand();
  }
}
