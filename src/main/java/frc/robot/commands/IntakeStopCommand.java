package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.*;

/** An example command that uses an example subsystem. */
public class IntakeStopCommand extends CommandBase {

  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final Intake m_intake;

  /**
   * Creates a new IntakeCargoCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public IntakeStopCommand(Intake subsystem) {
    m_intake = subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  @Override
  public void execute() {
    m_intake.intakeStop();
    m_intake.retractSolenoid();
  }
}
