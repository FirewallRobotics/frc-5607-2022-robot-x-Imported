package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Indexer;

public class StopIndexerCommand extends CommandBase {
  private final Indexer m_indexer;

  public StopIndexerCommand(Indexer subsystem) {

    m_indexer = subsystem;
    addRequirements(subsystem); // indexer is needed to intake the ball
  }

  public void initialize() {
    // withTimeout(FlushConstants.FlushTime);
  }

  /*
   *execute() - intake power cell
   */
  @Override
  public void execute() {
    m_indexer.stop();
  }
  /*
   * isFinished
   */
  // public boolean isFinished() {
  //    return isTimedOut();
  // return false;

  @Override
  public void end(boolean interrupted) {
    m_indexer.stop();
  }
}
