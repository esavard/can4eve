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
package com.bitplan.elm327;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * test snippet handling
 * @author wf
 *
 */
public class TestSnippets {
   
  @Test
  public void testSnippetComplete() {
    String snippets[] = { "A", "OK>" };
    boolean expected[] = { true, false };
    int index = 0;
    ConnectionImpl con=new ConnectionImpl();
    for (String snippet : snippets) {
      con.addSnippet(snippet);
      Packet p=con.getResponse(null);
      assertNotNull(p);
      assertEquals(snippets[index],expected[index], p.isTimeOut());
      if (!p.isTimeOut()) {
        System.out.println(p.getData());
      }
      index++;
    }
  }
}
