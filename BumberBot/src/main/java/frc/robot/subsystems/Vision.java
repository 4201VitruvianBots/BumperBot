// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.cscore.UsbCamera;
import edu.wpi.first.cscore.VideoMode.PixelFormat;
import edu.wpi.first.cscore.VideoSource.ConnectionStrategy;
import edu.wpi.first.net.PortForwarder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Vision extends SubsystemBase {
  /** Creates a new Vision. */
  public Vision() {
    UsbCamera usbCamera = new UsbCamera("Microsoft LifeCam HD-3000", 0);
    usbCamera.setFPS(15);
    // usbCamera.setExposureManual(10);
    usbCamera.setPixelFormat(PixelFormat.kYUYV);
    usbCamera.setConnectionStrategy(ConnectionStrategy.kKeepOpen);
    usbCamera.setResolution(160, 120);
    CameraServer.startAutomaticCapture(usbCamera);

    PortForwarder.add(5803, Constants.VisionConstants.VISION_SERVER_IP, 5802);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
