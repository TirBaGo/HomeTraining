@REM ----------------------------------------------------------------------------
@REM  Copyright 2001-2006 The Apache Software Foundation.
@REM
@REM  Licensed under the Apache License, Version 2.0 (the "License");
@REM  you may not use this file except in compliance with the License.
@REM  You may obtain a copy of the License at
@REM
@REM       http://www.apache.org/licenses/LICENSE-2.0
@REM
@REM  Unless required by applicable law or agreed to in writing, software
@REM  distributed under the License is distributed on an "AS IS" BASIS,
@REM  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
@REM  See the License for the specific language governing permissions and
@REM  limitations under the License.
@REM ----------------------------------------------------------------------------
@REM
@REM   Copyright (c) 2001-2006 The Apache Software Foundation.  All rights
@REM   reserved.

@echo off

set ERROR_CODE=0

:init
@REM Decide how to startup depending on the version of windows

@REM -- Win98ME
if NOT "%OS%"=="Windows_NT" goto Win9xArg

@REM set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" @setlocal

@REM -- 4NT shell
if "%eval[2+2]" == "4" goto 4NTArgs

@REM -- Regular WinNT shell
set CMD_LINE_ARGS=%*
goto WinNTGetScriptDir

@REM The 4NT Shell from jp software
:4NTArgs
set CMD_LINE_ARGS=%$
goto WinNTGetScriptDir

:Win9xArg
@REM Slurp the command line arguments.  This loop allows for an unlimited number
@REM of arguments (up to the command line limit, anyway).
set CMD_LINE_ARGS=
:Win9xApp
if %1a==a goto Win9xGetScriptDir
set CMD_LINE_ARGS=%CMD_LINE_ARGS% %1
shift
goto Win9xApp

:Win9xGetScriptDir
set SAVEDIR=%CD%
%0\
cd %0\..\.. 
set BASEDIR=%CD%
cd %SAVEDIR%
set SAVE_DIR=
goto repoSetup

:WinNTGetScriptDir
set BASEDIR=%~dp0\..

:repoSetup
set REPO=


if "%JAVACMD%"=="" set JAVACMD=java

if "%REPO%"=="" set REPO=%BASEDIR%\repo

set CLASSPATH="%BASEDIR%"\etc;"%REPO%"\org\springframework\spring-webmvc\4.3.10.RELEASE\spring-webmvc-4.3.10.RELEASE.jar;"%REPO%"\org\springframework\spring-aop\4.3.10.RELEASE\spring-aop-4.3.10.RELEASE.jar;"%REPO%"\org\springframework\spring-beans\4.3.10.RELEASE\spring-beans-4.3.10.RELEASE.jar;"%REPO%"\org\springframework\spring-context\4.3.10.RELEASE\spring-context-4.3.10.RELEASE.jar;"%REPO%"\org\springframework\spring-core\4.3.10.RELEASE\spring-core-4.3.10.RELEASE.jar;"%REPO%"\org\springframework\spring-expression\4.3.10.RELEASE\spring-expression-4.3.10.RELEASE.jar;"%REPO%"\org\springframework\spring-web\4.3.10.RELEASE\spring-web-4.3.10.RELEASE.jar;"%REPO%"\org\springframework\spring-orm\4.3.10.RELEASE\spring-orm-4.3.10.RELEASE.jar;"%REPO%"\org\springframework\spring-jdbc\4.3.10.RELEASE\spring-jdbc-4.3.10.RELEASE.jar;"%REPO%"\org\springframework\spring-tx\4.3.10.RELEASE\spring-tx-4.3.10.RELEASE.jar;"%REPO%"\org\hibernate\hibernate-core\5.2.11.Final\hibernate-core-5.2.11.Final.jar;"%REPO%"\org\jboss\logging\jboss-logging\3.3.0.Final\jboss-logging-3.3.0.Final.jar;"%REPO%"\org\hibernate\javax\persistence\hibernate-jpa-2.1-api\1.0.0.Final\hibernate-jpa-2.1-api-1.0.0.Final.jar;"%REPO%"\org\javassist\javassist\3.20.0-GA\javassist-3.20.0-GA.jar;"%REPO%"\antlr\antlr\2.7.7\antlr-2.7.7.jar;"%REPO%"\org\jboss\spec\javax\transaction\jboss-transaction-api_1.2_spec\1.0.1.Final\jboss-transaction-api_1.2_spec-1.0.1.Final.jar;"%REPO%"\org\jboss\jandex\2.0.3.Final\jandex-2.0.3.Final.jar;"%REPO%"\com\fasterxml\classmate\1.3.0\classmate-1.3.0.jar;"%REPO%"\dom4j\dom4j\1.6.1\dom4j-1.6.1.jar;"%REPO%"\org\hibernate\common\hibernate-commons-annotations\5.0.1.Final\hibernate-commons-annotations-5.0.1.Final.jar;"%REPO%"\org\hibernate\hibernate-c3p0\5.2.11.Final\hibernate-c3p0-5.2.11.Final.jar;"%REPO%"\com\mchange\c3p0\0.9.5.2\c3p0-0.9.5.2.jar;"%REPO%"\com\mchange\mchange-commons-java\0.2.11\mchange-commons-java-0.2.11.jar;"%REPO%"\org\postgresql\postgresql\42.3.1\postgresql-42.3.1.jar;"%REPO%"\org\checkerframework\checker-qual\3.5.0\checker-qual-3.5.0.jar;"%REPO%"\com\fasterxml\jackson\core\jackson-databind\2.8.7\jackson-databind-2.8.7.jar;"%REPO%"\com\fasterxml\jackson\core\jackson-annotations\2.8.0\jackson-annotations-2.8.0.jar;"%REPO%"\com\fasterxml\jackson\core\jackson-core\2.8.7\jackson-core-2.8.7.jar;"%REPO%"\javax\servlet\jstl\1.2\jstl-1.2.jar;"%REPO%"\org\apache\tomcat\embed\tomcat-embed-core\8.5.38\tomcat-embed-core-8.5.38.jar;"%REPO%"\org\apache\tomcat\tomcat-annotations-api\8.5.38\tomcat-annotations-api-8.5.38.jar;"%REPO%"\javax\javaee-web-api\7.0\javaee-web-api-7.0.jar;"%REPO%"\javax\persistence\persistence-api\1.0.2\persistence-api-1.0.2.jar;"%REPO%"\org\apache\maven\plugins\maven-compiler-plugin\3.8.1\maven-compiler-plugin-3.8.1.jar;"%REPO%"\org\apache\maven\maven-plugin-api\3.0\maven-plugin-api-3.0.jar;"%REPO%"\org\apache\maven\maven-model\3.0\maven-model-3.0.jar;"%REPO%"\org\sonatype\sisu\sisu-inject-plexus\1.4.2\sisu-inject-plexus-1.4.2.jar;"%REPO%"\org\sonatype\sisu\sisu-inject-bean\1.4.2\sisu-inject-bean-1.4.2.jar;"%REPO%"\org\sonatype\sisu\sisu-guice\2.1.7\sisu-guice-2.1.7-noaop.jar;"%REPO%"\org\apache\maven\maven-artifact\3.0\maven-artifact-3.0.jar;"%REPO%"\org\codehaus\plexus\plexus-utils\2.0.4\plexus-utils-2.0.4.jar;"%REPO%"\org\apache\maven\maven-core\3.0\maven-core-3.0.jar;"%REPO%"\org\apache\maven\maven-settings\3.0\maven-settings-3.0.jar;"%REPO%"\org\apache\maven\maven-settings-builder\3.0\maven-settings-builder-3.0.jar;"%REPO%"\org\apache\maven\maven-repository-metadata\3.0\maven-repository-metadata-3.0.jar;"%REPO%"\org\apache\maven\maven-model-builder\3.0\maven-model-builder-3.0.jar;"%REPO%"\org\apache\maven\maven-aether-provider\3.0\maven-aether-provider-3.0.jar;"%REPO%"\org\sonatype\aether\aether-impl\1.7\aether-impl-1.7.jar;"%REPO%"\org\sonatype\aether\aether-spi\1.7\aether-spi-1.7.jar;"%REPO%"\org\sonatype\aether\aether-api\1.7\aether-api-1.7.jar;"%REPO%"\org\sonatype\aether\aether-util\1.7\aether-util-1.7.jar;"%REPO%"\org\codehaus\plexus\plexus-interpolation\1.14\plexus-interpolation-1.14.jar;"%REPO%"\org\codehaus\plexus\plexus-classworlds\2.2.3\plexus-classworlds-2.2.3.jar;"%REPO%"\org\codehaus\plexus\plexus-component-annotations\1.5.5\plexus-component-annotations-1.5.5.jar;"%REPO%"\org\sonatype\plexus\plexus-sec-dispatcher\1.3\plexus-sec-dispatcher-1.3.jar;"%REPO%"\org\sonatype\plexus\plexus-cipher\1.4\plexus-cipher-1.4.jar;"%REPO%"\org\apache\maven\shared\maven-shared-utils\3.2.1\maven-shared-utils-3.2.1.jar;"%REPO%"\commons-io\commons-io\2.5\commons-io-2.5.jar;"%REPO%"\org\apache\maven\shared\maven-shared-incremental\1.1\maven-shared-incremental-1.1.jar;"%REPO%"\org\codehaus\plexus\plexus-java\0.9.10\plexus-java-0.9.10.jar;"%REPO%"\org\ow2\asm\asm\6.2\asm-6.2.jar;"%REPO%"\com\thoughtworks\qdox\qdox\2.0-M8\qdox-2.0-M8.jar;"%REPO%"\org\codehaus\plexus\plexus-compiler-api\2.8.4\plexus-compiler-api-2.8.4.jar;"%REPO%"\org\codehaus\plexus\plexus-compiler-manager\2.8.4\plexus-compiler-manager-2.8.4.jar;"%REPO%"\org\codehaus\plexus\plexus-compiler-javac\2.8.4\plexus-compiler-javac-2.8.4.jar;"%REPO%"\commons-digester\commons-digester\2.1\commons-digester-2.1.jar;"%REPO%"\commons-beanutils\commons-beanutils\1.8.3\commons-beanutils-1.8.3.jar;"%REPO%"\commons-logging\commons-logging\1.1.1\commons-logging-1.1.1.jar;"%REPO%"\com\TirBaGO\TirBaGO-HomeTraining\0.0.1-SNAPSHOT\TirBaGO-HomeTraining-0.0.1-SNAPSHOT.war

set ENDORSED_DIR=
if NOT "%ENDORSED_DIR%" == "" set CLASSPATH="%BASEDIR%"\%ENDORSED_DIR%\*;%CLASSPATH%

if NOT "%CLASSPATH_PREFIX%" == "" set CLASSPATH=%CLASSPATH_PREFIX%;%CLASSPATH%

@REM Reaching here means variables are defined and arguments have been captured
:endInit

%JAVACMD% %JAVA_OPTS%  -classpath %CLASSPATH% -Dapp.name="webapp" -Dapp.repo="%REPO%" -Dapp.home="%BASEDIR%" -Dbasedir="%BASEDIR%" launch.Main %CMD_LINE_ARGS%
if %ERRORLEVEL% NEQ 0 goto error
goto end

:error
if "%OS%"=="Windows_NT" @endlocal
set ERROR_CODE=%ERRORLEVEL%

:end
@REM set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" goto endNT

@REM For old DOS remove the set variables from ENV - we assume they were not set
@REM before we started - at least we don't leave any baggage around
set CMD_LINE_ARGS=
goto postExec

:endNT
@REM If error code is set to 1 then the endlocal was done already in :error.
if %ERROR_CODE% EQU 0 @endlocal


:postExec

if "%FORCE_EXIT_ON_ERROR%" == "on" (
  if %ERROR_CODE% NEQ 0 exit %ERROR_CODE%
)

exit /B %ERROR_CODE%
