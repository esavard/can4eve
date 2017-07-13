/**
 *
 * This file is part of the https://github.com/BITPlan/can4eve open source project
 *
 * Copyright 2017 BITPlan GmbH https://github.com/BITPlan
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 *
 *  You may obtain a copy of the License at
 *
 *  http:www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.bitplan.obdii;

import java.io.File;
import java.io.IOException;
import java.net.Socket;

import com.bitplan.can4eve.Pid;
import com.bitplan.can4eve.VehicleGroup;
import com.bitplan.obdii.elm327.ELM327;

/**
 * OBD Handler
 * @author wf
 *
 */
public abstract class OBDHandler extends AbstractOBDHandler{

  public OBDHandler(VehicleGroup vehicleGroup) {
    super(vehicleGroup);
  }

  public OBDHandler(VehicleGroup vehicleGroup, String device, int baudRate) {
    super(vehicleGroup,device,baudRate);
  }

  public OBDHandler(VehicleGroup vehicleGroup, File file) {
    super(vehicleGroup,file);
  }

  public OBDHandler(VehicleGroup vehicleGroup, ELM327 elm) {
    super(vehicleGroup,elm);
  }

  public OBDHandler(VehicleGroup vehicleGroup, Socket socket, boolean debug) throws Exception {
    super(vehicleGroup,socket,debug);
  }

  /**
   * get the PID with the given PID id
   * 
   * @param pidId
   * @return
   * @throws Exception
   */
  public Pid pidByName(String pidId) throws Exception {
    Pid pid = getVehicleGroup().getPidByName(pidId);
    return pid;
  }
  
  /**
   * delegate the initialization of the OBD device
   * 
   * @throws Exception
   */
  public void initOBD() throws Exception {
    this.getElm327().initOBD2();
  }

}
