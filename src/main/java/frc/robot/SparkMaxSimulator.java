package frc.robot;

import com.revrobotics.CANSparkMax;
import edu.wpi.first.hal.SimDevice;
import edu.wpi.first.hal.SimDevice.Direction;
import edu.wpi.first.hal.SimDouble;
import edu.wpi.first.wpilibj.RobotController;

public class SparkMaxSimulator extends CANSparkMax {
  private SimDouble m_simSpeed;
  private SimDevice m_simSparkMax;

  public SparkMaxSimulator(int deviceID, MotorType type) {
    super(deviceID, type);

    m_simSparkMax = SimDevice.create("SparkMax", deviceID);
    if (m_simSparkMax != null) {
      m_simSpeed = m_simSparkMax.createDouble("speed", Direction.kBidir, 0.0);
    }
  }

  @Override
  public double get() {
    if (m_simSparkMax != null) {
      return m_simSpeed.get();
    }
    return super.get();
  }

  @Override
  public void set(double speed) {
    if (m_simSparkMax != null) {
      m_simSpeed.set(speed);
    } else {
      super.set(speed);
    }
  }

  @Override
  public void setVoltage(
      double
          outputVolts) { // For simulation purposes, we are expecting that the battery voltage stays
    // constant.
    if (m_simSparkMax != null) {
      set(outputVolts / RobotController.getBatteryVoltage());
    } else {
      super.setVoltage(outputVolts);
    }
  }
}
