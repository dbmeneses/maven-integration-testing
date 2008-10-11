package org.apache.maven.it;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import org.apache.maven.it.Verifier;
import org.apache.maven.it.util.ResourceExtractor;

import java.io.File;

public class MavenIT0079Test
    extends AbstractMavenIntegrationTestCase
{

    /**
     * Test that source attachments have the same build number as the main
     * artifact when deployed.
     */
    public void testit0079()
        throws Exception
    {
        File testDir = ResourceExtractor.simpleExtractResources( getClass(), "/it0079" );
        Verifier verifier = new Verifier( testDir.getAbsolutePath() );
        verifier.executeGoal( "initialize" );
        verifier.assertFilePresent(
            "target/test-repo/org/apache/maven/its/it0079/maven-it-it0079/SNAPSHOT/maven-it-it0079-*-1.jar" );
        verifier.assertFilePresent(
            "target/test-repo/org/apache/maven/its/it0079/maven-it-it0079/SNAPSHOT/maven-it-it0079-*-1-it.jar" );
        verifier.verifyErrorFreeLog();
        verifier.resetStreams();
    }

}